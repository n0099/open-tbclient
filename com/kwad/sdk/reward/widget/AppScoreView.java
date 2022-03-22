package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class AppScoreView extends LinearLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41101b;

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
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0424, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091133);
        this.f41101b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091132);
    }

    public void setScore(float f2) {
        double d2 = f2;
        if (d2 > 4.5d) {
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b93);
            this.f41101b.setImageResource(R.drawable.obfuscated_res_0x7f080b93);
        } else if (d2 > 4.0d) {
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b93);
            this.f41101b.setImageResource(R.drawable.obfuscated_res_0x7f080b92);
        } else {
            if (d2 > 3.5d) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b93);
            } else {
                int i = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
                if (i > 0) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b92);
                } else if (i != 0) {
                    return;
                } else {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b91);
                }
            }
            this.f41101b.setImageResource(R.drawable.obfuscated_res_0x7f080b91);
        }
    }
}
