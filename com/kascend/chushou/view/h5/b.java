package com.kascend.chushou.view.h5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.base.d;
import com.kascend.chushou.widget.cswebview.CSWebView;
import com.kascend.chushou.widget.cswebview.CustomSwipeRefreshLayout;
import com.kascend.chushou.widget.cswebview.c;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class b extends d implements View.OnClickListener {
    public String c;
    private FrameLayout j;
    private ImageView k;
    private View l;
    private ImageView m;
    private View n;
    private CSWebView nfh;
    private CustomSwipeRefreshLayout nfi;
    private com.kascend.chushou.widget.cswebview.a nfj;
    private com.kascend.chushou.widget.cswebview.d nfk;
    private TextView o;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private int i = -1;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;

    public static b b(H5Options h5Options, com.kascend.chushou.widget.cswebview.a aVar) {
        b bVar = new b();
        bVar.a(aVar);
        Bundle bundle = new Bundle();
        bundle.putParcelable("h5Options", h5Options);
        bVar.setArguments(bundle);
        return bVar;
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
            this.i = h5Options.h;
            this.h = h5Options.f;
        }
        if (this.c != null) {
            this.t = this.c.contains("bizCode");
        }
        this.r = false;
        e.d(this.TAG, "mH5Url = " + this.c + ", mCanBack = " + this.d + ", mAutoLoad = " + this.e + ", mEnableRefresh = " + this.f);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.fragment_small_h5_fragment, viewGroup, false);
        this.j = (FrameLayout) inflate.findViewById(a.f.empty_loading_view);
        this.k = (ImageView) inflate.findViewById(a.f.iv_close);
        this.k.setOnClickListener(this);
        if (this.h) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        this.l = inflate.findViewById(a.f.ll_error);
        this.m = (ImageView) inflate.findViewById(a.f.iv_empty);
        this.o = (TextView) inflate.findViewById(a.f.tv_refresh);
        this.o.setOnClickListener(this);
        this.n = inflate.findViewById(a.f.ll_loading);
        this.nfh = (CSWebView) inflate.findViewById(a.f.web_view);
        if (this.i != -1) {
            inflate.setBackgroundColor(this.i);
            this.nfh.setBackgroundColor(this.i);
        }
        this.nfi = (CustomSwipeRefreshLayout) inflate.findViewById(a.f.swipeRefreshLayout);
        this.nfi.setEnabled(this.f);
        this.nfh.setWebChromeClient(new com.kascend.chushou.widget.cswebview.b() { // from class: com.kascend.chushou.view.h5.b.1
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (b.this.mContext != null && (b.this.mContext instanceof H5Activity)) {
                    ((H5Activity) b.this.mContext).a(str);
                }
            }
        });
        final com.kascend.chushou.widget.cswebview.d dDm = this.nfj != null ? this.nfj.dDm() : null;
        this.nfk = new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.view.h5.b.2
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                if (dDm != null) {
                    dDm.a((Object) null);
                } else if (b.this.getActivity() != null) {
                    b.this.getActivity().finish();
                }
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        };
        if (this.nfj == null) {
            this.nfj = new com.kascend.chushou.widget.cswebview.a();
        }
        this.nfj.a(this.nfk);
        this.nfj.a(this);
        CSWebView.a(this.nfh, this.mContext, new c() { // from class: com.kascend.chushou.view.h5.b.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!b.this.isFinishing()) {
                    b.this.nfi.setEnabled(false);
                    if (!b.this.s) {
                        b.this.showStatus(1);
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                e.e(b.this.TAG, "onPageFinished");
                if (!b.this.isFinishing()) {
                    b.this.s = false;
                    b.this.nfi.setEnabled(b.this.f);
                    String str2 = (String) webView.getTag();
                    if (tv.chushou.zues.utils.a.dOY()) {
                        if (str2 != null && str2.equals(BdStatsConstant.StatsType.ERROR)) {
                            b.this.showStatus(4);
                        } else {
                            b.this.showStatus(2);
                        }
                    } else {
                        b.this.showStatus(3);
                    }
                    b.this.r = true;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                e.e(b.this.TAG, "onReceivedError code=" + i);
                if (!b.this.isFinishing()) {
                    b.this.s = false;
                    try {
                        webView.stopLoading();
                    } catch (Exception e) {
                    }
                    try {
                        webView.clearView();
                    } catch (Exception e2) {
                    }
                    b.this.nfi.setEnabled(b.this.f);
                    webView.setTag(BdStatsConstant.StatsType.ERROR);
                }
            }
        }, this.nfj);
        this.nfi.setColorSchemeResources(a.c.swap_holo_green_bright, a.c.swap_holo_bule_bright, a.c.swap_holo_green_bright, a.c.swap_holo_bule_bright);
        this.nfi.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kascend.chushou.view.h5.b.4
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                b.this.nfi.setRefreshing(false);
                if (tv.chushou.zues.utils.a.dOY()) {
                    b.this.s = true;
                    if (b.this.c == null || b.this.c.length() <= 0) {
                        b.this.nfh.loadUrl("");
                        return;
                    } else {
                        b.this.nfh.loadUrl(b.this.c);
                        return;
                    }
                }
                b.this.showStatus(3);
            }
        });
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        if (!this.r) {
            showStatus(1);
        }
        if (this.e) {
            b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.nfh != null) {
            this.nfh.resumeTimers();
            this.nfh.onResume();
        }
        e.d(this.TAG, MissionEvent.MESSAGE_RESUME);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.nfh != null) {
            this.nfh.onPause();
        }
        e.d(this.TAG, MissionEvent.MESSAGE_PAUSE);
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onDestroyView() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.view.base.b
    public void unInit() {
        tv.chushou.zues.a.a.cq(this);
        if (this.nfh != null) {
            this.nfh.loadUrl("");
            this.nfh.removeAllViews();
            this.nfh.destroy();
            this.nfh = null;
        }
        this.nfi = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666) {
            e.d(this.TAG, "onActivityResult");
            if (this.c != null) {
                if (this.c.contains("m/bigfans/pay.htm")) {
                    String str = tv.chushou.common.a.dOH() + "m/bigfans/pay.htm";
                    if (LoginManager.Instance().islogined()) {
                        str = str + "?token=" + LoginManager.Instance().getUserInfo().mToken + "&state=1";
                    }
                    e.d(this.TAG, "refresh pay loayal fans success,  url=" + str);
                    this.nfh.loadUrl(str);
                } else if (this.c.contains("m/noble/info.htm")) {
                    if (intent != null) {
                        String str2 = tv.chushou.common.a.dOH() + "m/noble/info.htm";
                        String stringExtra = intent.getStringExtra("payLevel");
                        String stringExtra2 = intent.getStringExtra("payCount");
                        String stringExtra3 = intent.getStringExtra("roomId");
                        if (LoginManager.Instance().islogined()) {
                            str2 = str2 + "?token=" + LoginManager.Instance().getUserInfo().mToken + "&payResultCode=1&roomId=" + stringExtra3 + "&payLevel=" + stringExtra + "&payCount=" + stringExtra2;
                        }
                        e.d(this.TAG, "refresh pay noble success,  url=" + str2);
                        this.nfh.loadUrl(str2);
                    }
                } else {
                    a();
                }
            }
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a == 0 && (iVar.b instanceof Boolean) && ((Boolean) iVar.b).booleanValue() && !h.isEmpty(this.c)) {
            if (this.c.contains("m/register.htm") || this.c.contains("m/password.htm")) {
                ((Activity) this.mContext).setResult(-1);
                ((Activity) this.mContext).finish();
            } else if (this.nfh != null) {
                this.nfh.loadUrl(this.c);
            }
        }
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (this.g) {
                    this.nfh.setVisibility(8);
                    this.j.setVisibility(0);
                    this.j.setBackgroundResource(a.c.transparent);
                    this.l.setVisibility(8);
                    this.n.setVisibility(0);
                    if (this.h) {
                        this.k.setVisibility(0);
                        this.k.setImageResource(a.e.pop_h5_close_white);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                this.j.setVisibility(8);
                tv.chushou.zues.toolkit.d.b.setScaleX(this.nfh, 0.0f);
                tv.chushou.zues.toolkit.d.b.setScaleY(this.nfh, 0.0f);
                this.nfh.setVisibility(0);
                this.nfh.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).start();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.nfh.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setBackgroundResource(a.e.powindow_circle_bg);
                this.n.setVisibility(8);
                this.l.setVisibility(0);
                this.m.setVisibility(0);
                int i2 = a.e.commonres_pagestatus_unknown_error;
                if (i == 3) {
                    i2 = a.e.commonres_pagestatus_net_error;
                }
                this.m.setImageResource(i2);
                this.o.setVisibility(0);
                if (this.h) {
                    this.k.setVisibility(0);
                    this.k.setImageResource(a.e.pop_h5_close_black);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_refresh) {
            b();
        } else if (id == a.f.iv_close && this.nfk != null) {
            this.nfk.a((Object) null);
        }
    }

    public void a(com.kascend.chushou.widget.cswebview.a aVar) {
        this.nfj = aVar;
        if (aVar != null) {
            this.neM = aVar.dDn();
        }
    }

    public void a(String str) {
        if (this.nfh != null) {
            this.nfh.a(str);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4 && this.d && this.nfh.canGoBack()) {
            this.nfh.goBack();
            return true;
        }
        return false;
    }

    private void a() {
        String str = tv.chushou.common.a.dOH() + "m/pay.htm";
        if (LoginManager.Instance().islogined()) {
            str = str + "?token=" + LoginManager.Instance().getUserInfo().mToken + "&state=1";
        }
        e.d(this.TAG, "refreshAfterRechargeSuccess url=" + str);
        this.nfh.loadUrl(str);
    }

    private void b() {
        e.d(this.TAG, "H5=" + this.c);
        if (this.nfh != null) {
            this.nfh.setTag(null);
            this.nfi.setRefreshing(false);
            if (tv.chushou.zues.utils.a.dOY()) {
                if (this.c != null && this.c.length() > 0) {
                    this.nfh.loadUrl(this.c);
                    return;
                } else {
                    this.nfh.loadUrl("");
                    return;
                }
            }
            showStatus(3);
        }
    }
}
