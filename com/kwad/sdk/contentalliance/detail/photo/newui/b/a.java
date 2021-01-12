package com.kwad.sdk.contentalliance.detail.photo.newui.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes4.dex */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8539a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f8540b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8539a = null;
        this.f8540b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_func_button_2, (ViewGroup) this, true);
        this.f8539a = (ImageView) findViewById(R.id.ksad_photo_func_button_image);
        this.f8540b = (TextView) findViewById(R.id.ksad_photo_func_button_text);
    }

    public void setButtonImageResource(int i) {
        this.f8539a.setImageResource(i);
    }

    public void setButtonText(String str) {
        this.f8540b.setText(str);
    }
}
