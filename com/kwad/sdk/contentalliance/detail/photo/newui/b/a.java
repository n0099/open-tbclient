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
    public ImageView f33088a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33089b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33088a = null;
        this.f33089b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_func_button_2, (ViewGroup) this, true);
        this.f33088a = (ImageView) findViewById(R.id.ksad_photo_func_button_image);
        this.f33089b = (TextView) findViewById(R.id.ksad_photo_func_button_text);
    }

    public void setButtonImageResource(int i2) {
        this.f33088a.setImageResource(i2);
    }

    public void setButtonText(String str) {
        this.f33089b.setText(str);
    }
}
