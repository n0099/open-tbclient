package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.f;
/* loaded from: classes7.dex */
public class a extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static String f40283a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40284b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f40285c = false;

    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        f40285c = true;
        f40283a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            f.c("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f40283a = String.valueOf((char) keyEvent.getUnicodeChar());
            f40285c = true;
            f.b("openSDK_LOG.CaptureInputConnection", "s: " + f40283a);
        }
        f.b("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f40283a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        f40285c = true;
        f40283a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i2);
    }
}
