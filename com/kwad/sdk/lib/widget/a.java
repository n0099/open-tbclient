package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f36669a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f36670b = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f36671c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f36672d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f36673e = 1.0f;

    /* renamed from: com.kwad.sdk.lib.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0425a {
        CharSequence a();

        TextPaint b();
    }

    public float a(CharSequence charSequence, TextPaint textPaint, float f2) {
        textPaint.setTextSize(f2);
        return Layout.getDesiredWidth(charSequence, textPaint);
    }
}
