package com.kascend.chushou.view.h5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.bean.ImageInfo;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.base.d;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.kascend.chushou.widget.cswebview.CSWebView;
import com.kascend.chushou.widget.cswebview.CustomSwipeRefreshLayout;
import com.kascend.chushou.widget.cswebview.c;
import java.util.ArrayList;
import java.util.HashMap;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a extends d {
    public String c;
    private boolean j;
    private EmptyLoadingView nvB;
    private CustomSwipeRefreshLayout nvC;
    private com.kascend.chushou.widget.cswebview.a nvD;
    private InterfaceC0843a nvE;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private int i = -1;
    private boolean m = false;
    private boolean n = false;
    private boolean q = false;

    /* renamed from: com.kascend.chushou.view.h5.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0843a {
        void a(String str);
    }

    public static a a(H5Options h5Options) {
        return a(h5Options, (com.kascend.chushou.widget.cswebview.a) null);
    }

    public static a a(H5Options h5Options, com.kascend.chushou.widget.cswebview.a aVar) {
        a aVar2 = new a();
        aVar2.a(aVar);
        Bundle bundle = new Bundle();
        bundle.putParcelable("h5Options", h5Options);
        aVar2.setArguments(bundle);
        return aVar2;
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        H5Options h5Options = (H5Options) getArguments().getParcelable("h5Options");
        if (h5Options != null) {
            this.d = h5Options.b;
            this.e = h5Options.d;
            this.f = h5Options.c;
            this.g = h5Options.e;
            this.c = h5Options.a;
            this.h = h5Options.g;
            this.i = h5Options.h;
        }
        this.m = false;
        e.d(this.TAG, "mH5Url = " + this.c + ", mCanBack = " + this.d + ", mAutoLoad = " + this.e + ", mEnableRefresh = " + this.f + ", mdoPauseTime = " + this.h);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final View inflate = layoutInflater.inflate(a.h.view_refreshable_x5_page, viewGroup, false);
        if (this.i > 0) {
            inflate.setBackgroundColor(this.i);
        }
        this.nvB = (EmptyLoadingView) inflate.findViewById(a.f.empty_view);
        this.nvm = (CSWebView) inflate.findViewById(a.f.web_view);
        this.nvC = (CustomSwipeRefreshLayout) inflate.findViewById(a.f.swipeRefreshLayout);
        this.nvC.setEnabled(this.f);
        this.nvm.setWebChromeClient(new com.kascend.chushou.widget.cswebview.b() { // from class: com.kascend.chushou.view.h5.a.1
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (a.this.mContext != null && (a.this.mContext instanceof H5Activity)) {
                    ((H5Activity) a.this.mContext).a(str);
                }
                if (a.this.nvE != null) {
                    a.this.nvE.a(str);
                }
            }
        });
        this.q = true;
        final com.kascend.chushou.widget.cswebview.d dLn = this.nvD != null ? this.nvD.dLn() : null;
        com.kascend.chushou.widget.cswebview.d dVar = new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.view.h5.a.2
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                if (dLn != null) {
                    dLn.a((Object) null);
                    return;
                }
                FragmentActivity activity = a.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        };
        if (this.nvD == null) {
            this.nvD = new com.kascend.chushou.widget.cswebview.a();
        }
        this.nvD.a(dVar);
        this.nvD.a(this);
        CSWebView.a(this.nvm, this.mContext, new c() { // from class: com.kascend.chushou.view.h5.a.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!a.this.isFinishing() && a.this.q) {
                    a.this.nvC.setEnabled(false);
                    if (!a.this.n) {
                        a.this.showStatus(1);
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                e.e(a.this.TAG, "onPageFinished");
                if (!a.this.isFinishing() && a.this.q) {
                    a.this.n = false;
                    a.this.nvC.setEnabled(a.this.f);
                    a.this.m = true;
                    String str2 = (String) webView.getTag();
                    if (tv.chushou.zues.utils.a.dWH()) {
                        if (str2 != null && str2.equals(BdStatsConstant.StatsType.ERROR)) {
                            a.this.showStatus(4);
                        } else {
                            a.this.showStatus(2);
                        }
                    } else {
                        a.this.showStatus(3);
                    }
                    inflate.setBackgroundColor(ContextCompat.getColor(a.this.mContext, a.c.background));
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                e.e(a.this.TAG, "onReceivedError code=" + i);
                if (!a.this.isFinishing() && a.this.q) {
                    a.this.n = false;
                    try {
                        webView.stopLoading();
                    } catch (Exception e) {
                    }
                    try {
                        webView.clearView();
                    } catch (Exception e2) {
                    }
                    a.this.nvC.setEnabled(a.this.f);
                    webView.setTag(BdStatsConstant.StatsType.ERROR);
                }
            }
        }, this.nvD);
        this.nvC.setColorSchemeResources(a.c.swap_holo_green_bright, a.c.swap_holo_bule_bright, a.c.swap_holo_green_bright, a.c.swap_holo_bule_bright);
        this.nvC.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kascend.chushou.view.h5.a.4
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                a.this.nvC.setRefreshing(false);
                if (tv.chushou.zues.utils.a.dWH()) {
                    a.this.n = true;
                    if (a.this.c == null || a.this.c.length() <= 0) {
                        a.this.nvm.loadUrl("");
                        return;
                    } else {
                        a.this.nvm.loadUrl(a.this.c);
                        return;
                    }
                }
                a.this.showStatus(3);
            }
        });
        this.nvB.setReloadListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.h5.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.isFinishing()) {
                    a.this.e();
                }
            }
        });
        if (!this.h && this.j && this.nvm != null) {
            this.nvm.resumeTimers();
        }
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        if (!this.m) {
            showStatus(1);
        }
        if (this.e) {
            e();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.nvm != null) {
            this.nvm.onResume();
            this.nvm.resumeTimers();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.nvm != null) {
            this.nvm.pauseTimers();
            this.nvm.onPause();
        }
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.q = false;
        tv.chushou.zues.a.a.ci(this);
        if (this.nvm != null) {
            this.nvm.loadUrl("");
            this.nvm.removeAllViews();
            this.nvm.destroy();
        }
        super.onDestroyView();
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a == 0 && (iVar.b instanceof Boolean) && ((Boolean) iVar.b).booleanValue() && !h.isEmpty(this.c)) {
            if (this.c.contains("m/register.htm") || this.c.contains("m/password.htm")) {
                ((Activity) this.mContext).setResult(-1);
                ((Activity) this.mContext).finish();
            } else if (this.nvm != null) {
                this.nvm.loadUrl(this.c);
            }
        }
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (this.g) {
                    this.nvm.setVisibility(8);
                    this.nvB.Ku(1);
                    return;
                }
                return;
            case 2:
                this.nvm.setVisibility(0);
                this.nvB.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.nvm.setVisibility(8);
                this.nvB.setVisibility(0);
                this.nvB.Ku(i);
                return;
            default:
                return;
        }
    }

    public void a(com.kascend.chushou.widget.cswebview.a aVar) {
        this.nvD = aVar;
        if (aVar != null) {
            this.nvn = aVar.dLo();
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a() {
        if (!this.d || this.nvm == null) {
            return false;
        }
        return this.nvm.canGoBack();
    }

    public void a(String str) {
        this.c = str;
        e();
    }

    public void b() {
        if (!this.m) {
            e();
        }
    }

    public void c() {
        if (tv.chushou.zues.utils.a.dWH()) {
            this.n = true;
            if (this.c != null && this.c.length() > 0) {
                this.nvm.loadUrl(this.c);
                return;
            } else {
                this.nvm.loadUrl("");
                return;
            }
        }
        showStatus(3);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4 && this.d && this.nvm.canGoBack()) {
            this.nvm.goBack();
            return true;
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666) {
            e.d(this.TAG, "onActivityResult");
            if (this.c != null) {
                if (this.c.contains("m/bigfans/pay.htm")) {
                    String str = tv.chushou.common.a.dWn() + "m/bigfans/pay.htm";
                    if (LoginManager.Instance().islogined()) {
                        str = str + "?token=" + LoginManager.Instance().getUserInfo().mToken + "&state=1";
                    }
                    e.d(this.TAG, "refresh pay loayal fans success,  url=" + str);
                    this.nvm.loadUrl(str);
                } else if (this.c.contains("m/noble/info.htm")) {
                    if (intent != null) {
                        String str2 = this.c;
                        String stringExtra = intent.getStringExtra("payLevel");
                        String stringExtra2 = intent.getStringExtra("payCount");
                        String stringExtra3 = intent.getStringExtra("roomId");
                        if (LoginManager.Instance().islogined()) {
                            if (!str2.contains("?")) {
                                str2 = str2 + "?";
                            }
                            if (!str2.endsWith("?")) {
                                str2 = str2 + ETAG.ITEM_SEPARATOR;
                            }
                            str2 = str2 + "payResultCode=1&roomId=" + stringExtra3 + "&payLevel=" + stringExtra + "&payCount=" + stringExtra2;
                        }
                        e.d(this.TAG, "refresh pay noble success,  url=" + str2);
                        this.nvm.loadUrl(str2);
                    }
                } else {
                    d();
                }
            }
        } else if (i == 100 && i2 == 101 && intent != null) {
            ArrayList<ImageInfo> parcelableArrayListExtra = intent.getParcelableArrayListExtra("uploadResult");
            String stringExtra4 = intent.getStringExtra("uploadCallback");
            if ("upload".equals(intent.getStringExtra("jsMethod"))) {
                ArrayList arrayList = new ArrayList();
                if (parcelableArrayListExtra != null) {
                    for (ImageInfo imageInfo : parcelableArrayListExtra) {
                        arrayList.add(imageInfo.url);
                    }
                }
                if (!h.isEmpty(stringExtra4)) {
                    this.nvm.a(stringExtra4, arrayList);
                }
            } else if (!h.isEmpty(stringExtra4)) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", parcelableArrayListExtra);
                this.nvm.a(stringExtra4, hashMap);
            }
        }
    }

    private void d() {
        String str = tv.chushou.common.a.dWn() + "m/pay.htm";
        if (LoginManager.Instance().islogined()) {
            str = str + "?token=" + LoginManager.Instance().getUserInfo().mToken + "&state=1";
        }
        e.d(this.TAG, "refreshAfterRechargeSuccess url=" + str);
        this.nvm.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e.d(this.TAG, "H5=" + this.c);
        if (this.nvm != null) {
            this.nvm.setTag(null);
            this.nvC.setRefreshing(false);
            if (tv.chushou.zues.utils.a.dWH()) {
                if (this.c != null && this.c.length() > 0) {
                    this.nvm.loadUrl(this.c);
                    return;
                } else {
                    this.nvm.loadUrl("");
                    return;
                }
            }
            showStatus(3);
        }
    }

    @Subscribe
    public void onSwipeEnableMessgae(com.kascend.chushou.b.a.a.e eVar) {
        if (eVar.a) {
            this.nvC.setEnabled(this.f);
        } else {
            this.nvC.setEnabled(false);
        }
    }

    @Subscribe
    public void onHardwareEnableMessgae(com.kascend.chushou.b.a.a.d dVar) {
        if (dVar.a) {
            this.nvm.setLayerType(2, null);
        } else {
            this.nvm.setLayerType(1, null);
        }
    }

    public void a(InterfaceC0843a interfaceC0843a) {
        this.nvE = interfaceC0843a;
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.j = z;
        if (!this.h) {
            if (z) {
                if (this.nvm != null) {
                    this.nvm.resumeTimers();
                }
            } else if (this.nvm != null) {
                this.nvm.pauseTimers();
            }
        }
    }
}
