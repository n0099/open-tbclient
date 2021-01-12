package com.kwad.sdk.contentalliance.detail.photo.newui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.g.a.a;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class WaterMarkView2 extends a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f8533a;

    public WaterMarkView2(Context context) {
        this(context, null);
    }

    public WaterMarkView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_video_water_mark_2, (ViewGroup) this, true);
        this.f8533a = (TextView) findViewById(R.id.ksad_video_water_mark_text);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, ao.a(getContext(), 40.0f), ao.a(getContext(), 16.0f));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAlignment(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8533a.getLayoutParams();
        if (i == 1) {
            layoutParams.gravity = 5;
        } else {
            layoutParams.gravity = 3;
        }
        this.f8533a.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAuthorId(long j) {
        if (j == 0) {
            this.f8533a.setVisibility(4);
        } else {
            this.f8533a.setVisibility(0);
        }
        this.f8533a.setText(String.format("＠%d", Long.valueOf(j)));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_water_logo);
        setDrawableBounds(drawable);
        this.f8533a.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
        this.f8533a.setCompoundDrawables(drawable, null, null, null);
    }
}
