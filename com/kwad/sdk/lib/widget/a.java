package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f35964a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f35965b = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f35966c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f35967d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f35968e = 1.0f;

    /* renamed from: com.kwad.sdk.lib.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0424a {
        CharSequence a();

        TextPaint b();
    }

    public float a(CharSequence charSequence, TextPaint textPaint, float f2) {
        textPaint.setTextSize(f2);
        return Layout.getDesiredWidth(charSequence, textPaint);
    }
}
