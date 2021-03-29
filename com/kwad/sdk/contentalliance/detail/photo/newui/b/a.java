package com.kwad.sdk.contentalliance.detail.photo.newui.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f32416a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32417b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32416a = null;
        this.f32417b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_func_button_2, (ViewGroup) this, true);
        this.f32416a = (ImageView) findViewById(R.id.ksad_photo_func_button_image);
        this.f32417b = (TextView) findViewById(R.id.ksad_photo_func_button_text);
    }

    public void setButtonImageResource(int i) {
        this.f32416a.setImageResource(i);
    }

    public void setButtonText(String str) {
        this.f32417b.setText(str);
    }
}
