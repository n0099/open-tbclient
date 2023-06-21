package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
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
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0474, this);
        this.Cj = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913ad);
        this.Ck = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913ac);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080e84);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080e84);
        } else if (d > 4.0d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080e84);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080e85);
        } else if (d > 3.5d) {
            this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080e84);
            this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080e86);
        } else {
            int i = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
            if (i > 0) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080e85);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080e86);
            } else if (i == 0) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080e86);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080e86);
            }
        }
    }
}
