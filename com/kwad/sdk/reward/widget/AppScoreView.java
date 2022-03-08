package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AppScoreView extends LinearLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56169b;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
        this.a = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.f56169b = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f2) {
        double d2 = f2;
        if (d2 > 4.5d) {
            this.a.setImageResource(R.drawable.ksad_app_score_yellow);
            this.f56169b.setImageResource(R.drawable.ksad_app_score_yellow);
        } else if (d2 > 4.0d) {
            this.a.setImageResource(R.drawable.ksad_app_score_yellow);
            this.f56169b.setImageResource(R.drawable.ksad_app_score_half);
        } else {
            if (d2 > 3.5d) {
                this.a.setImageResource(R.drawable.ksad_app_score_yellow);
            } else {
                int i2 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
                if (i2 > 0) {
                    this.a.setImageResource(R.drawable.ksad_app_score_half);
                } else if (i2 != 0) {
                    return;
                } else {
                    this.a.setImageResource(R.drawable.ksad_app_score_gray);
                }
            }
            this.f56169b.setImageResource(R.drawable.ksad_app_score_gray);
        }
    }
}
