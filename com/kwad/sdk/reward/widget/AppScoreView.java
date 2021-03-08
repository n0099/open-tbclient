package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class AppScoreView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f7033a;
    private ImageView b;

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
        inflate(getContext(), R.layout.ksad_app_score, this);
        this.f7033a = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.b = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        if (f > 4.5d) {
            this.f7033a.setImageResource(R.drawable.ksad_app_score_yellow);
            this.b.setImageResource(R.drawable.ksad_app_score_yellow);
        } else if (f > 4.0d) {
            this.f7033a.setImageResource(R.drawable.ksad_app_score_yellow);
            this.b.setImageResource(R.drawable.ksad_app_score_half);
        } else if (f > 3.5d) {
            this.f7033a.setImageResource(R.drawable.ksad_app_score_yellow);
            this.b.setImageResource(R.drawable.ksad_app_score_gray);
        } else if (f > 3.0d) {
            this.f7033a.setImageResource(R.drawable.ksad_app_score_half);
            this.b.setImageResource(R.drawable.ksad_app_score_gray);
        } else if (f == 3.0d) {
            this.f7033a.setImageResource(R.drawable.ksad_app_score_gray);
            this.b.setImageResource(R.drawable.ksad_app_score_gray);
        }
    }
}
