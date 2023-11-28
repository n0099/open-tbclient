package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AppScoreView extends LinearLayout {
    public ImageView HR;
    public ImageView HS;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04b2, this);
        this.HR = (ImageView) findViewById(R.id.obfuscated_res_0x7f091496);
        this.HS = (ImageView) findViewById(R.id.obfuscated_res_0x7f091495);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.HR.setImageResource(R.drawable.obfuscated_res_0x7f080f03);
            this.HS.setImageResource(R.drawable.obfuscated_res_0x7f080f03);
        } else if (d > 4.0d) {
            this.HR.setImageResource(R.drawable.obfuscated_res_0x7f080f03);
            this.HS.setImageResource(R.drawable.obfuscated_res_0x7f080f04);
        } else if (d > 3.5d) {
            this.HR.setImageResource(R.drawable.obfuscated_res_0x7f080f03);
            this.HS.setImageResource(R.drawable.obfuscated_res_0x7f080f05);
        } else {
            int i = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
            if (i > 0) {
                this.HR.setImageResource(R.drawable.obfuscated_res_0x7f080f04);
                this.HS.setImageResource(R.drawable.obfuscated_res_0x7f080f05);
            } else if (i == 0) {
                this.HR.setImageResource(R.drawable.obfuscated_res_0x7f080f05);
                this.HS.setImageResource(R.drawable.obfuscated_res_0x7f080f05);
            }
        }
    }
}
