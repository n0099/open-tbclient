package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class AppScoreView extends LinearLayout {
    public ImageView a;
    public ImageView b;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d041f, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09112d);
        this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09112c);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b98);
            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080b98);
        } else if (d > 4.0d) {
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b98);
            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080b97);
        } else {
            if (d > 3.5d) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b98);
            } else {
                int i = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
                if (i > 0) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b97);
                } else if (i != 0) {
                    return;
                } else {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b96);
                }
            }
            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080b96);
        }
    }
}
