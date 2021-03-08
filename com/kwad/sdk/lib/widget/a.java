package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private float f6879a = -1.0f;
    private float b = 10.0f;
    private float c = 1.0f;
    private float d = 0.0f;
    private float e = 1.0f;

    /* renamed from: com.kwad.sdk.lib.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1157a {
        CharSequence a();

        TextPaint b();
    }

    public float a(CharSequence charSequence, TextPaint textPaint, float f) {
        textPaint.setTextSize(f);
        return Layout.getDesiredWidth(charSequence, textPaint);
    }
}
