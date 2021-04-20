package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class AppScoreView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36753a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36754b;

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
        LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
        this.f36753a = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.f36754b = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f2) {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        double d2 = f2;
        if (d2 > 4.5d) {
            this.f36753a.setImageResource(R.drawable.ksad_app_score_yellow);
            imageView2 = this.f36754b;
            i2 = R.drawable.ksad_app_score_yellow;
        } else if (d2 > 4.0d) {
            this.f36753a.setImageResource(R.drawable.ksad_app_score_yellow);
            imageView2 = this.f36754b;
            i2 = R.drawable.ksad_app_score_half;
        } else {
            if (d2 > 3.5d) {
                imageView = this.f36753a;
                i = R.drawable.ksad_app_score_yellow;
            } else {
                int i3 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
                if (i3 > 0) {
                    imageView = this.f36753a;
                    i = R.drawable.ksad_app_score_half;
                } else if (i3 != 0) {
                    return;
                } else {
                    imageView = this.f36753a;
                    i = R.drawable.ksad_app_score_gray;
                }
            }
            imageView.setImageResource(i);
            imageView2 = this.f36754b;
            i2 = R.drawable.ksad_app_score_gray;
        }
        imageView2.setImageResource(i2);
    }
}
