package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private float f10730a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f10731b = 10.0f;
    private float c = 1.0f;
    private float d = 0.0f;
    private float e = 1.0f;

    /* renamed from: com.kwad.sdk.lib.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1110a {
        CharSequence a();

        TextPaint b();
    }

    public float a(CharSequence charSequence, TextPaint textPaint, float f) {
        textPaint.setTextSize(f);
        return Layout.getDesiredWidth(charSequence, textPaint);
    }
}
