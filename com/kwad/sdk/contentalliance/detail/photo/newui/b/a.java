package com.kwad.sdk.contentalliance.detail.photo.newui.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8839a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f8840b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8839a = null;
        this.f8840b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_func_button_2, (ViewGroup) this, true);
        this.f8839a = (ImageView) findViewById(R.id.ksad_photo_func_button_image);
        this.f8840b = (TextView) findViewById(R.id.ksad_photo_func_button_text);
    }

    public void setButtonImageResource(int i) {
        this.f8839a.setImageResource(i);
    }

    public void setButtonText(String str) {
        this.f8840b.setText(str);
    }
}
