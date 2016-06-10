package com.avene_avene.pfcyarouex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.avene_avene.pfcyarouex.model.PFCProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.weight_editText)
    EditText weightEditText;
    @BindView(R.id.fat_mass_rate_editText)
    EditText fatMassRateEditText;
    @BindView(R.id.cals_from_fat_rate_editText)
    EditText calsFromFatRateEditText;
    @BindView(R.id.protein_factor_editText)
    EditText proteinFactorEditText;
    @BindView(R.id.total_cals_label_textView)
    TextView totalCalsLabelTextView;
    @BindView(R.id.total_cals_textView)
    TextView totalCalsTextView;
    @BindView(R.id.protein_grams_label_textView)
    TextView proteinGramsLabelTextView;
    @BindView(R.id.protein_grams_textView)
    TextView proteinGramsTextView;
    @BindView(R.id.fat_grams_label_textView)
    TextView fatGramsLabelTextView;
    @BindView(R.id.fat_grams_textView)
    TextView fatGramsTextView;
    @BindView(R.id.carbo_grams_label_textView)
    TextView carboGramsLabelTextView;
    @BindView(R.id.carbo_grams_textView)
    TextView carboGramsTextView;

    private PFCProfile pfc = new PFCProfile();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnTextChanged({R.id.weight_editText, R.id.fat_mass_rate_editText,
            R.id.cals_from_fat_rate_editText, R.id.protein_factor_editText})
    public void onTextChanged(CharSequence text) {
        calculatePFC();
    }

    private void calculatePFC() {
        String weightString = weightEditText.getText().toString();
        pfc.setWeight(weightString.isEmpty() ? 0 : Double.parseDouble(weightString));

        String fatMassRateString = fatMassRateEditText.getText().toString();
        pfc.setFatMassRate(fatMassRateString.isEmpty() ? 0 : Double.parseDouble(fatMassRateString));

        String calsFromFatRateString = calsFromFatRateEditText.getText().toString();
        pfc.setCalsFromFatRate(calsFromFatRateString.isEmpty() ? 0 : Double.parseDouble(calsFromFatRateString));

        String proteinFactorString = proteinFactorEditText.getText().toString();
        pfc.setProteinFactor(proteinFactorString.isEmpty() ? 0 : Double.parseDouble(proteinFactorString));

        pfc.calculate();
        totalCalsTextView.setText(String.valueOf(pfc.getTotalCals()));
        proteinGramsTextView.setText(String.valueOf(pfc.getProteinGrams()));
        fatGramsTextView.setText(String.valueOf(pfc.getFatGrams()));
        carboGramsTextView.setText(String.valueOf(pfc.getCarbGrams()));

    }
}
