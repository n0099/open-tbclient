package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class AppScoreView extends LinearLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57607b;

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
        this.f57607b = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f2) {
        ImageView imageView;
        int i2;
        ImageView imageView2;
        int i3;
        double d2 = f2;
        if (d2 > 4.5d) {
            this.a.setImageResource(R.drawable.ksad_app_score_yellow);
            imageView2 = this.f57607b;
            i3 = R.drawable.ksad_app_score_yellow;
        } else if (d2 > 4.0d) {
            this.a.setImageResource(R.drawable.ksad_app_score_yellow);
            imageView2 = this.f57607b;
            i3 = R.drawable.ksad_app_score_half;
        } else {
            if (d2 > 3.5d) {
                imageView = this.a;
                i2 = R.drawable.ksad_app_score_yellow;
            } else {
                int i4 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
                if (i4 > 0) {
                    imageView = this.a;
                    i2 = R.drawable.ksad_app_score_half;
                } else if (i4 != 0) {
                    return;
                } else {
                    imageView = this.a;
                    i2 = R.drawable.ksad_app_score_gray;
                }
            }
            imageView.setImageResource(i2);
            imageView2 = this.f57607b;
            i3 = R.drawable.ksad_app_score_gray;
        }
        imageView2.setImageResource(i3);
    }
}
