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
import androidx.appcompat.widget.TooltipCompatHandler;
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
/* loaded from: classes7.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static final HashMap<Long, Double> t = new HashMap<>(8);
    public a A;
    public int B;
    public ViewGroup.MarginLayoutParams C;
    public Handler D;
    public k.b E;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f35638f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f35639g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35640h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f35641i;
    public com.kwad.sdk.core.webview.a j;
    public int k;
    public double l;
    public List<Integer> m;
    public com.kwad.sdk.core.video.videoview.b n;
    public j o;
    public ImageView p;
    public boolean q;
    public RatioFrameLayout r;
    public p s;
    public boolean u;
    public String v;
    public boolean w;
    public int x;
    public com.kwad.sdk.feed.widget.base.a y;
    public KsAdVideoPlayConfig z;

    /* loaded from: classes7.dex */
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
            public void a(int i2) {
                if (l.this.u) {
                    return;
                }
                l.this.k = i2;
                if (l.this.k != 1) {
                    l.this.a("3");
                    return;
                }
                if (l.this.y != null) {
                    l.this.y.setVisibility(8);
                }
                l.this.f35639g.setVisibility(0);
                com.kwad.sdk.core.report.e.m(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a);
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
        List<Integer> list = this.m;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.m.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35578a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f35579b);
            this.o.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.n);
            FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f35578a.type);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.J(this.f35579b)) {
                com.kwad.sdk.core.download.b.a.b(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35578a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.l.4
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                    public void a() {
                        l.this.k();
                    }
                }, this.f35640h);
            } else {
                com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35578a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.l.5
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                    public void a() {
                        l.this.k();
                    }
                }, this.f35640h);
            }
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        this.s = new p();
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f35640h, new a.b() { // from class: com.kwad.sdk.feed.widget.l.9
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                if (com.kwad.sdk.core.response.b.a.J(l.this.f35579b) && (((com.kwad.sdk.feed.widget.base.a) l.this).f35578a.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) l.this).f35578a.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                    com.kwad.sdk.core.download.b.a.b(ao.a(l.this), ((com.kwad.sdk.feed.widget.base.a) l.this).f35578a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.l.9.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                        public void a() {
                            if (l.this.f35580c != null) {
                                l.this.f35580c.a();
                            }
                        }
                    }, l.this.f35640h);
                } else {
                    com.kwad.sdk.core.download.b.a.a(ao.a(l.this), ((com.kwad.sdk.feed.widget.base.a) l.this).f35578a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.l.9.2
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                        public void a() {
                            if (l.this.f35580c != null) {
                                l.this.f35580c.a();
                            }
                        }
                    }, l.this.f35640h);
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.j, new i.b() { // from class: com.kwad.sdk.feed.widget.l.10
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                l.this.f35639g.setVisibility(0);
                if (l.this.l == 0.0d) {
                    l.this.l = aVar.f35007a;
                    double d2 = aVar.f35007a / l.this.B;
                    l.this.f35638f.setRatio((float) d2);
                    l.t.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a.posId), Double.valueOf(d2));
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new WebCardVideoPositionHandler(this.j, new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.feed.widget.l.11
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (l.this.f35579b == null || !com.kwad.sdk.core.response.b.a.J(l.this.f35579b)) {
                    return;
                }
                l lVar = l.this;
                lVar.C = (ViewGroup.MarginLayoutParams) lVar.r.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.l);
                int i2 = l.this.B;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.C.topMargin = (int) (videoPosition.topMarginRation * ceil);
                double d2 = i2;
                l.this.C.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                l.this.C.width = (int) (d2 * videoPosition.widthRation);
                l.this.C.height = (int) (l.this.C.width * videoPosition.heightWidthRation);
                l.this.r.setLayoutParams(l.this.C);
                l lVar2 = l.this;
                lVar2.a(lVar2.z);
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
                aVar.f34967b = 0;
                aVar.f34966a = l.this.B;
                l.this.w = true;
            }
        });
        gVar.a(cVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.E));
        gVar.a(new o(this.j, this.f35640h));
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
        a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
        this.A = null;
        this.u = true;
        com.kwad.sdk.core.report.e.e(((com.kwad.sdk.feed.widget.base.a) this).f35578a, com.kwad.sdk.core.config.c.a().h5Url, str);
        if (this.y == null) {
            com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f35578a.type), com.kwad.sdk.core.response.b.a.L(this.f35579b));
            this.y = a2;
            if (a2 != null) {
                this.y.setMargin(ao.a(getContext(), 16.0f));
                this.f35638f.removeAllViews();
                this.f35638f.setRatio(0.0f);
                this.f35639g.setVisibility(8);
                this.r.setVisibility(8);
            }
            this.f35638f.addView(this.y);
            this.y.a(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            com.kwad.sdk.feed.widget.base.a aVar2 = this.y;
            if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar2).a(this.z);
            }
        }
    }

    private float c(AdTemplate adTemplate) {
        int i2 = adTemplate.type;
        if (i2 == 1) {
            return 0.6013f;
        }
        return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
    }

    public static /* synthetic */ int d(l lVar) {
        int i2 = lVar.x;
        lVar.x = i2 + 1;
        return i2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void m() {
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        aVar.f34929b = ((com.kwad.sdk.feed.widget.base.a) this).f35578a;
        aVar.f34928a = 0;
        aVar.f34930c = null;
        aVar.f34932e = this.f35638f;
        aVar.f34933f = this.f35639g;
        aVar.f34931d = null;
        aVar.f34934g = false;
    }

    private void o() {
        com.kwad.sdk.core.webview.a.g gVar = this.f35641i;
        if (gVar != null) {
            gVar.a();
            this.f35641i = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(final String str) {
        o();
        ar.b(this.f35639g);
        this.f35639g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.feed.widget.l.7
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                l.this.w = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str2, String str3) {
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
                l.this.f35639g.reload();
                l.d(l.this);
            }
        });
        com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f35639g);
        this.f35641i = gVar;
        a(gVar);
        this.f35639g.a(this.f35641i, "KwaiAd", new ValueCallback<String>() { // from class: com.kwad.sdk.feed.widget.l.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str2) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.f35639g.loadUrl(str);
                        l.d(l.this);
                    }
                });
            }
        });
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.q = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.U(this.f35579b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.p;
            i2 = 8;
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            imageView = this.p;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.m = com.kwad.sdk.core.response.b.a.M(this.f35579b);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f35581d);
        this.n = bVar;
        bVar.setTag(this.m);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f35579b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.n.a(new d.a().a(a3).a(((com.kwad.sdk.feed.widget.base.a) this).f35578a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f35579b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.n.setVideoSoundEnable(this.q);
        j jVar = new j(this.f35581d, ((com.kwad.sdk.feed.widget.base.a) this).f35578a, this.n);
        this.o = jVar;
        jVar.setVideoPlayCallback(new a.InterfaceC0392a() { // from class: com.kwad.sdk.feed.widget.l.2
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a);
                l.this.s.a(3);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a);
                l.this.s.a(9);
                if (l.this.r != null) {
                    l.this.r.setVisibility(8);
                }
            }
        });
        this.o.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.n.setController(this.o);
        if (this.r.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.r;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.r.setTag(null);
        }
        this.r.addView(this.n);
        this.r.setTag(this.n);
        this.r.setClickable(true);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.this.n.d()) {
                    l lVar = l.this;
                    lVar.a(lVar.n);
                    return;
                }
                l.this.n.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(l.this.f35579b), System.currentTimeMillis()));
                l.this.n.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.u) {
            com.kwad.sdk.feed.widget.base.a aVar = this.y;
            if (aVar != null) {
                aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.y;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.z);
                    return;
                }
                return;
            }
            return;
        }
        if (this.k != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
        }
        String str = this.v;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f35639g.reload();
            } else {
                f();
            }
        }
        this.v = adTemplate.mOriginJString;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.a();
            this.A = null;
        }
        this.A = aVar;
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.k != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
        }
        String str = this.v;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f35639g.reload();
            } else {
                f();
            }
        }
        this.v = adTemplate.mOriginJString;
        this.D.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.f35639g.stopLoading();
                l.this.f35639g.setVisibility(8);
                l.this.a("0");
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        this.f35640h = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
        ((com.kwad.sdk.feed.widget.base.a) this).f35578a = adTemplate;
        Double d2 = t.get(Long.valueOf(adTemplate.posId));
        if (d2 != null) {
            this.f35638f.setRatio(d2.floatValue());
        } else {
            double d3 = this.f35579b.adStyleInfo.feedAdInfo.heightRatio;
            if (d3 > 0.0d) {
                ratioFrameLayout = this.f35638f;
                c2 = (float) d3;
            } else if (this.f35638f.getRatio() == 0.0f) {
                ratioFrameLayout = this.f35638f;
                c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            }
            ratioFrameLayout.setRatio(c2);
        }
        m();
        n();
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
        this.f35639g = ksAdWebView;
        ksAdWebView.setVisibility(4);
        this.f35638f = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.r = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.p = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
    }

    public void f() {
        File c2 = com.kwad.sdk.core.config.c.c(getContext());
        if (c2.exists() || c2.length() <= 0) {
            setupJsBridgeAndLoadUrl(Uri.fromFile(c2).toString());
        } else {
            a("0");
        }
    }

    public boolean g() {
        return this.k == 1;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    public void h() {
        this.D.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.kwad.sdk.core.view.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (!z || (bVar = this.n) == null || (viewGroup = (ViewGroup) bVar.getParent()) == this.r) {
            return;
        }
        viewGroup.removeView(this.n);
        if (this.r.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.r;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.r.setTag(null);
        }
        this.r.addView(this.n);
        this.r.setTag(this.n);
        String a2 = com.kwad.sdk.core.response.b.a.a(this.f35579b);
        this.n.setVideoSoundEnable(this.q);
        this.o.setVideoPlayCallback(new a.InterfaceC0392a() { // from class: com.kwad.sdk.feed.widget.l.6
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) l.this).f35578a);
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
    public void setMargin(int i2) {
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.z = ksAdVideoPlayConfig;
    }

    public void setWidth(int i2) {
        this.B = i2;
    }
}
