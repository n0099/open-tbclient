package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;
/* loaded from: classes4.dex */
public abstract class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    protected a f13684a;
    @SuppressLint({"NewApi"})

    /* renamed from: b  reason: collision with root package name */
    protected final WebChromeClient f13685b;

    protected abstract void a(String str);

    public b(Context context, int i) {
        super(context, i);
        this.f13685b = new WebChromeClient() { // from class: com.tencent.open.b.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT > 7) {
                    b.this.a(consoleMessage == null ? "" : consoleMessage.message());
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i2 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    b.this.a(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13684a = new a();
    }
}
