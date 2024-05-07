package it.thomas.temperatureconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.thomas.temperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
        
    }

    private void initListener() {
        binding.rgTemp.setOnCheckedChangeListener(this);
        binding.btConvert.setOnClickListener(v -> {
            String input = binding.etInput.getText().toString();
            double temp = Double.parseDouble(input);
            if(binding.rbC2F.isChecked()) {
                double fah = (temp * 1.8) + 32;
                binding.etOutput.setText(fah + " F");
                binding.tvThank.setText("Thanks For Using My App");
            } else {
                double cel = (temp - 32) * 0.556;
                binding.etOutput.setText(cel + " C");
                binding.tvThank.setText("Thanks For Using My App");
            }
        });

        binding.btClear.setOnClickListener(v -> {
            binding.etInput.getText().clear();
            binding.etOutput.getText().clear();
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rbC2F) {
            //Celsius to Fahrenheit
            Log.d("Myat", "Celsius to Fahrenheit");
        } else {
            //Fahrenheit to Celsius
            Log.d("Myat", "Fahrenheit");
        }
    }
}