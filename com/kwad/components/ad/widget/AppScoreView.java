package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AppScoreView extends LinearLayout {
    public ImageView Cj;
    public ImageView Ck;

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
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0483, this);
        this.Cj = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913e4);
        this.Ck = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913e3);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080eab);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080eab);
        } else if (d > 4.0d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080eab);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080eac);
        } else if (d > 3.5d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080eab);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080ead);
        } else {
            int i = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
            if (i > 0) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080eac);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080ead);
            } else if (i == 0) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080ead);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080ead);
            }
        }
    }
}
