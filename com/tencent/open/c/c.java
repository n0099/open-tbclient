package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.a.f;
import com.tencent.open.web.security.SecureJsInterface;
/* loaded from: classes7.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36434a;

    /* renamed from: b  reason: collision with root package name */
    public KeyEvent f36435b;

    /* renamed from: c  reason: collision with root package name */
    public com.tencent.open.web.security.a f36436c;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        f.b("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f36434a);
        if (!f36434a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f36435b = keyEvent2;
                            return super.dispatchKeyEvent(keyEvent2);
                        }
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    com.tencent.open.web.security.a.f36502b = true;
                    return super.dispatchKeyEvent(keyEvent);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        f.c("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        f.a("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            f36434a = true;
            com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
            this.f36436c = aVar;
            return aVar;
        }
        f36434a = false;
        return onCreateInputConnection;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int unicodeChar;
        f.b("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f36434a);
        if (!f36434a) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.onKeyDown(i2, keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f36435b = keyEvent2;
                            return super.onKeyDown(keyEvent2.getKeyCode(), this.f36435b);
                        }
                        return super.onKeyDown(i2, keyEvent);
                    }
                    com.tencent.open.web.security.a.f36502b = true;
                    return super.onKeyDown(i2, keyEvent);
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
