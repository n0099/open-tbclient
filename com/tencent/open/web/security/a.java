package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.f;
/* loaded from: classes6.dex */
public class a extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static String f39630a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39631b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39632c = false;

    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        f39632c = true;
        f39630a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            f.c("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f39630a = String.valueOf((char) keyEvent.getUnicodeChar());
            f39632c = true;
            f.b("openSDK_LOG.CaptureInputConnection", "s: " + f39630a);
        }
        f.b("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f39630a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        f39632c = true;
        f39630a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
