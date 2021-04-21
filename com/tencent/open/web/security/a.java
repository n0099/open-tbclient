package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.f;
/* loaded from: classes7.dex */
public class a extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static String f39725a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39726b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39727c = false;

    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        f39727c = true;
        f39725a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            f.c("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f39725a = String.valueOf((char) keyEvent.getUnicodeChar());
            f39727c = true;
            f.b("openSDK_LOG.CaptureInputConnection", "s: " + f39725a);
        }
        f.b("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f39725a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        f39727c = true;
        f39725a = charSequence.toString();
        f.a("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
