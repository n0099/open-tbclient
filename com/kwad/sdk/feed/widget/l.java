package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    private static final HashMap<Long, Double> t = new HashMap<>(8);
    private a A;
    private int B;
    private ViewGroup.MarginLayoutParams C;
    private Handler D;
    private k.b E;
    private RatioFrameLayout f;
    private KsAdWebView g;
    @Nullable
    private com.kwad.sdk.core.download.b.b h;
    private com.kwad.sdk.core.webview.a.g i;
    private com.kwad.sdk.core.webview.a j;
    private int k;
    private double l;
    private List<Integer> m;
    private com.kwad.sdk.core.video.videoview.b n;
    private j o;
    private ImageView p;
    private boolean q;
    private RatioFrameLayout r;
    private p s;
    private boolean u;
    private String v;
    private boolean w;
    private int x;
    private com.kwad.sdk.feed.widget.base.a y;
    private KsAdVideoPlayConfig z;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public l(@NonNull Context context) {
        super(context);
        this.k = -1;
        this.q = false;
        this.w = false;
        this.D = new Handler(Looper.getMainLooper());
        this.E = new k.b() { // from class: com.kwad.sdk.feed.widget.l.14
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i) {
                if (l.this.u) {
                    return;
                }
                l.this.k = i;
                if (l.this.k != 1) {
                    l.this.a("3");
                    return;
                }
                if (l.this.y != null) {
                    l.this.y.setVisibility(8);
                }
                l.this.g.setVisibility(0);
                com.kwad.sdk.core.report.e.m(l.this.f6524a);
                l.this.D.removeCallbacksAndMessages(null);
                if (l.this.A != null) {
                    l.this.A.a();
                }
            }
        };
        this.B = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        if (this.m == null || this.m.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.m.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(this.f6524a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.b);
            this.o.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.n);
            FeedType fromInt = FeedType.fromInt(this.f6524a.type);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.J(this.b)) {
                com.kwad.sdk.core.download.b.a.b(ao.a(this), this.f6524a, new a.InterfaceC1111a() { // from class: com.kwad.sdk.feed.widget.l.4
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                    public void a() {
                        l.this.k();
                    }
                }, this.h);
            } else {
                com.kwad.sdk.core.download.b.a.a(ao.a(this), this.f6524a, new a.InterfaceC1111a() { // from class: com.kwad.sdk.feed.widget.l.5
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                    public void a() {
                        l.this.k();
                    }
                }, this.h);
            }
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        this.s = new p();
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.h, new a.b() { // from class: com.kwad.sdk.feed.widget.l.9
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                if (com.kwad.sdk.core.response.b.a.J(l.this.b) && (l.this.f6524a.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || l.this.f6524a.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                    com.kwad.sdk.core.download.b.a.b(ao.a(l.this), l.this.f6524a, new a.InterfaceC1111a() { // from class: com.kwad.sdk.feed.widget.l.9.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                        public void a() {
                            if (l.this.c != null) {
                                l.this.c.a();
                            }
                        }
                    }, l.this.h);
                } else {
                    com.kwad.sdk.core.download.b.a.a(ao.a(l.this), l.this.f6524a, new a.InterfaceC1111a() { // from class: com.kwad.sdk.feed.widget.l.9.2
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                        public void a() {
                            if (l.this.c != null) {
                                l.this.c.a();
                            }
                        }
                    }, l.this.h);
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.j, new i.b() { // from class: com.kwad.sdk.feed.widget.l.10
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                l.this.g.setVisibility(0);
                if (l.this.l == 0.0d) {
                    l.this.l = aVar.f6349a;
                    double d = aVar.f6349a / l.this.B;
                    l.this.f.setRatio((float) d);
                    l.t.put(Long.valueOf(l.this.f6524a.posId), Double.valueOf(d));
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new WebCardVideoPositionHandler(this.j, new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.feed.widget.l.11
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (l.this.b == null || !com.kwad.sdk.core.response.b.a.J(l.this.b)) {
                    return;
                }
                l.this.C = (ViewGroup.MarginLayoutParams) l.this.r.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.l);
                int i = l.this.B;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.C.topMargin = (int) (videoPosition.topMarginRation * ceil);
                l.this.C.leftMargin = (int) (videoPosition.leftMarginRation * i);
                l.this.C.width = (int) (i * videoPosition.widthRation);
                l.this.C.height = (int) (l.this.C.width * videoPosition.heightWidthRation);
                l.this.r.setLayoutParams(l.this.C);
                l.this.a(l.this.z);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.j, new b.a() { // from class: com.kwad.sdk.feed.widget.l.12
            @Override // com.kwad.sdk.core.webview.jshandler.b.a
            public void a() {
                l.this.D.post(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.l();
                    }
                });
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.j);
        cVar.a(new c.b() { // from class: com.kwad.sdk.feed.widget.l.13
            @Override // com.kwad.sdk.core.webview.jshandler.c.b
            public void a(c.a aVar) {
                aVar.b = 0;
                aVar.f6335a = l.this.B;
                l.this.w = true;
            }
        });
        gVar.a(cVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.E));
        gVar.a(new o(this.j, this.h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.j));
        gVar.a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.kwad.sdk.core.d.a.a("FeedWebView", "handleWebViewError " + str);
        this.D.removeCallbacksAndMessages(null);
        if (this.u) {
            return;
        }
        if (this.A != null) {
            this.A.a();
        }
        this.A = null;
        this.u = true;
        com.kwad.sdk.core.report.e.e(this.f6524a, com.kwad.sdk.core.config.c.a().h5Url, str);
        if (this.y == null) {
            this.y = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(this.f6524a.type), com.kwad.sdk.core.response.b.a.L(this.b));
            if (this.y != null) {
                this.y.setMargin(ao.a(getContext(), 16.0f));
                this.f.removeAllViews();
                this.f.setRatio(0.0f);
                this.g.setVisibility(8);
                this.r.setVisibility(8);
            }
            this.f.addView(this.y);
            this.y.a(this.f6524a);
            if (this.y instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) this.y).a(this.z);
            }
        }
    }

    private float c(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    static /* synthetic */ int d(l lVar) {
        int i = lVar.x;
        lVar.x = i + 1;
        return i;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void m() {
    }

    private void n() {
        this.j = new com.kwad.sdk.core.webview.a();
        this.j.b = this.f6524a;
        this.j.f6320a = 0;
        this.j.c = null;
        this.j.e = this.f;
        this.j.f = this.g;
        this.j.d = null;
        this.j.g = false;
    }

    private void o() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(final String str) {
        o();
        ar.b(this.g);
        this.g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.feed.widget.l.7
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                l.this.w = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str2, String str3) {
                l.this.a("1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (l.this.w) {
                    return;
                }
                if (l.this.x >= 2) {
                    l.this.a("2");
                    return;
                }
                l.this.g.reload();
                l.d(l.this);
            }
        });
        this.i = new com.kwad.sdk.core.webview.a.g(this.g);
        a(this.i);
        this.g.a(this.i, "KwaiAd", new ValueCallback<String>() { // from class: com.kwad.sdk.feed.widget.l.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str2) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.g.loadUrl(str);
                        l.d(l.this);
                    }
                });
            }
        });
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.q = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.U(this.b).a();
        if (TextUtils.isEmpty(a2)) {
            this.p.setVisibility(8);
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, this.f6524a);
            this.p.setVisibility(0);
        }
        this.m = com.kwad.sdk.core.response.b.a.M(this.b);
        this.n = new com.kwad.sdk.core.video.videoview.b(this.d);
        this.n.setTag(this.m);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.n.a(new d.a().a(a3).a(this.f6524a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.n.setVideoSoundEnable(this.q);
        this.o = new j(this.d, this.f6524a, this.n);
        this.o.setVideoPlayCallback(new a.InterfaceC1124a() { // from class: com.kwad.sdk.feed.widget.l.2
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void a() {
                com.kwad.sdk.core.report.b.h(l.this.f6524a);
                l.this.s.a(3);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void b() {
                com.kwad.sdk.core.report.b.i(l.this.f6524a);
                l.this.s.a(9);
                if (l.this.r != null) {
                    l.this.r.setVisibility(8);
                }
            }
        });
        this.o.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.n.setController(this.o);
        if (this.r.getTag() != null) {
            this.r.removeView((View) this.r.getTag());
            this.r.setTag(null);
        }
        this.r.addView(this.n);
        this.r.setTag(this.n);
        this.r.setClickable(true);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.this.n.d()) {
                    l.this.a(l.this.n);
                    return;
                }
                l.this.n.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(l.this.b), System.currentTimeMillis()));
                l.this.n.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.u) {
            if (this.y != null) {
                this.y.a(this.f6524a);
                if (this.y instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) this.y).a(this.z);
                    return;
                }
                return;
            }
            return;
        }
        if (this.k != 1) {
            b(this.f6524a);
        }
        if (this.v == null || !this.v.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.g.reload();
            } else {
                f();
            }
        }
        this.v = adTemplate.mOriginJString;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        if (this.A != null) {
            this.A.a();
            this.A = null;
        }
        this.A = aVar;
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.k != 1) {
            b(this.f6524a);
        }
        if (this.v == null || !this.v.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.g.reload();
            } else {
                f();
            }
        }
        this.v = adTemplate.mOriginJString;
        this.D.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.g.stopLoading();
                l.this.g.setVisibility(8);
                l.this.a("0");
            }
        }, 2500L);
    }

    public void b(AdTemplate adTemplate) {
        this.h = new com.kwad.sdk.core.download.b.b(this.f6524a);
        this.f6524a = adTemplate;
        Double d = t.get(Long.valueOf(this.f6524a.posId));
        if (d != null) {
            this.f.setRatio(d.floatValue());
        } else if (this.b.adStyleInfo.feedAdInfo.heightRatio > 0.0d) {
            this.f.setRatio((float) this.b.adStyleInfo.feedAdInfo.heightRatio);
        } else if (this.f.getRatio() == 0.0f) {
            this.f.setRatio(c(this.f6524a));
        }
        m();
        n();
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.g = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
        this.g.setVisibility(4);
        this.f = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.r = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.p = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
    }

    public void f() {
        File c = com.kwad.sdk.core.config.c.c(getContext());
        if (c.exists() || c.length() <= 0) {
            setupJsBridgeAndLoadUrl(Uri.fromFile(c).toString());
        } else {
            a("0");
        }
    }

    protected boolean g() {
        return this.k == 1;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    public void h() {
        this.D.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.view.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (!z || this.n == null || (viewGroup = (ViewGroup) this.n.getParent()) == this.r) {
            return;
        }
        viewGroup.removeView(this.n);
        if (this.r.getTag() != null) {
            this.r.removeView((View) this.r.getTag());
            this.r.setTag(null);
        }
        this.r.addView(this.n);
        this.r.setTag(this.n);
        String a2 = com.kwad.sdk.core.response.b.a.a(this.b);
        this.n.setVideoSoundEnable(this.q);
        this.o.setVideoPlayCallback(new a.InterfaceC1124a() { // from class: com.kwad.sdk.feed.widget.l.6
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void a() {
                com.kwad.sdk.core.report.b.h(l.this.f6524a);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1124a
            public void b() {
                com.kwad.sdk.core.report.b.i(l.this.f6524a);
                if (l.this.r != null) {
                    l.this.r.setVisibility(8);
                }
            }
        });
        this.o.m();
        this.o.setAutoRelease(true);
        AdVideoPlayerViewCache.a().a(a2);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void setMargin(int i) {
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.z = ksAdVideoPlayConfig;
    }

    public void setWidth(int i) {
        this.B = i;
    }
}
