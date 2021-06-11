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
/* loaded from: classes6.dex */
public class WaterMarkView2 extends a {

    /* renamed from: a  reason: collision with root package name */
    public TextView f32977a;

    public WaterMarkView2(Context context) {
        this(context, null);
    }

    public WaterMarkView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_video_water_mark_2, (ViewGroup) this, true);
        this.f32977a = (TextView) findViewById(R.id.ksad_video_water_mark_text);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, ao.a(getContext(), 40.0f), ao.a(getContext(), 16.0f));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAlignment(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f32977a.getLayoutParams();
        layoutParams.gravity = i2 == 1 ? 5 : 3;
        this.f32977a.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAuthorId(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        TextView textView = this.f32977a;
        if (i2 == 0) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
        }
        this.f32977a.setText(String.format("＠%d", Long.valueOf(j)));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_water_logo);
        setDrawableBounds(drawable);
        this.f32977a.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
        this.f32977a.setCompoundDrawables(drawable, null, null, null);
    }
}
