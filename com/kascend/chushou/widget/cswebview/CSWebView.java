package com.kascend.chushou.widget.cswebview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.JSInterface;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.a;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes5.dex */
public class CSWebView extends SimpleWebview implements View.OnLongClickListener, DownloadListener {
    private JSInterface naS;

    @SuppressLint({"AddJavascriptInterface"})
    public static void a(CSWebView cSWebView, Context context, c cVar, a aVar) {
        if (cSWebView != null && context != null) {
            JSInterface dGr = aVar != null ? aVar.dGr() : null;
            JSInterface jSInterface = dGr == null ? new JSInterface(context) : dGr;
            d dGp = aVar != null ? aVar.dGp() : null;
            com.kascend.chushou.toolkit.b dGq = aVar != null ? aVar.dGq() : null;
            jSInterface.setCloseListener(dGp);
            jSInterface.setJsToNative(dGq);
            Object d = aVar != null ? aVar.d() : null;
            if (d != null) {
                jSInterface.setExtraData(d);
            }
            cSWebView.addJavascriptInterface(jSInterface, "ChuShouJS");
            cSWebView.setJSInterface(jSInterface);
            cSWebView.setWebViewClient(cVar);
        }
    }

    public CSWebView(Context context) {
        super(context);
    }

    public CSWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.widget.cswebview.SimpleWebview
    public void a() {
        String str;
        super.a();
        WebSettings settings = getSettings();
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.b.b.class);
        if (bVar == null) {
            str = "Android ChushouTV SDK/5.5.6";
        } else {
            str = bVar.getUserAgent();
        }
        settings.setUserAgentString(settings.getUserAgentString() + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.widget.cswebview.SimpleWebview
    public void b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 19 && tv.chushou.zues.utils.e.dRL()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @Override // com.kascend.chushou.widget.cswebview.SimpleWebview, android.webkit.WebView
    public void loadUrl(String str) {
        String c = com.kascend.chushou.d.e.c(str);
        if (h.isEmpty(c)) {
            c = "";
        }
        tv.chushou.zues.utils.e.d("CSWebView", "loadUrl=" + c);
        super.loadUrl(c);
    }

    @Override // com.kascend.chushou.widget.cswebview.SimpleWebview
    protected void a(final Context context, final String str) {
        new tv.chushou.zues.widget.sweetalert.b(context).a(new b.a() { // from class: com.kascend.chushou.widget.cswebview.CSWebView.2
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.widget.cswebview.CSWebView.1
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
                if (h.isEmpty(str)) {
                    if (ViewCompat.isAttachedToWindow(CSWebView.this)) {
                        g.c(context, context.getString(a.i.str_download_fail));
                        return;
                    }
                    return;
                }
                tv.chushou.zues.widget.fresco.a.a(str, com.kascend.chushou.d.c.mHD.dDX().getAbsolutePath(), new a.InterfaceC0922a() { // from class: com.kascend.chushou.widget.cswebview.CSWebView.1.1
                    @Override // tv.chushou.zues.widget.fresco.a.InterfaceC0922a
                    public void onComplete(boolean z, String str2) {
                        if (ViewCompat.isAttachedToWindow(CSWebView.this)) {
                            if (z) {
                                g.c(context, context.getString(a.i.str_img_already_download, str2));
                            } else {
                                g.c(context, context.getString(a.i.str_download_fail));
                            }
                        }
                    }
                });
            }
        }).SC(context.getString(a.i.alert_dialog_cancel)).SE(context.getString(a.i.alert_dialog_ok)).x(context.getString(a.i.str_download_img)).show();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return (this.naS != null && this.naS.isCanScrollHorizontally()) || super.canScrollHorizontally(i);
    }

    public void setJSInterface(JSInterface jSInterface) {
        this.naS = jSInterface;
    }

    public void a(String str) {
        a(str, (Object) null);
    }

    public void a(String str, Object obj) {
        if (!h.isEmpty(str)) {
            super.loadUrl(M(str, obj));
        }
    }

    private String M(String str, Object obj) {
        String json;
        if (obj == null) {
            json = "";
        } else if (obj instanceof String) {
            json = (String) obj;
        } else {
            json = tv.chushou.zues.utils.d.toJson(obj);
        }
        String str2 = "javascript:(function(){var fun=window." + str + ";  if(fun && typeof fun==='function') {fun('" + json + "');}})();";
        tv.chushou.zues.utils.e.d("CSWebView", "call js :" + str2);
        return str2;
    }
}
