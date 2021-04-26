package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.c;
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
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static final HashMap<Long, Double> t = new HashMap<>(8);
    public int A;
    public ViewGroup.MarginLayoutParams B;
    public Handler C;
    public k.b D;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f34083f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f34084g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34085h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f34086i;
    public com.kwad.sdk.core.webview.a j;
    public int k;
    public double l;
    public List<Integer> m;
    public com.kwad.sdk.core.video.videoview.b n;
    public j o;
    public ImageView p;
    public boolean q;
    public RatioFrameLayout r;
    public o s;
    public boolean u;
    public String v;
    public boolean w;
    public com.kwad.sdk.feed.widget.base.a x;
    public KsAdVideoPlayConfig y;
    public a z;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public l(@NonNull Context context) {
        super(context);
        this.k = -1;
        this.q = false;
        this.w = false;
        this.C = new Handler(Looper.getMainLooper());
        this.D = new k.b() { // from class: com.kwad.sdk.feed.widget.l.12
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
                if (l.this.x != null) {
                    l.this.x.setVisibility(8);
                }
                l.this.f34084g.setVisibility(0);
                com.kwad.sdk.core.report.e.a(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a);
                l.this.C.removeCallbacksAndMessages(null);
                if (l.this.z != null) {
                    l.this.z.a();
                }
            }
        };
        this.A = context.getResources().getDisplayMetrics().widthPixels;
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
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34024a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f34025b);
            this.o.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.n);
            FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f34024a.type);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.F(this.f34025b)) {
                com.kwad.sdk.core.download.b.a.b(an.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f34024a, new a.InterfaceC0376a() { // from class: com.kwad.sdk.feed.widget.l.3
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                    public void a() {
                        l.this.k();
                    }
                }, this.f34085h, z);
            } else {
                com.kwad.sdk.core.download.b.a.a(an.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f34024a, new a.InterfaceC0376a() { // from class: com.kwad.sdk.feed.widget.l.4
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                    public void a() {
                        l.this.k();
                    }
                }, this.f34085h, z);
            }
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        this.s = new o();
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f34085h, new a.b() { // from class: com.kwad.sdk.feed.widget.l.7
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0386a c0386a) {
                if (com.kwad.sdk.core.response.b.a.F(l.this.f34025b) && (((com.kwad.sdk.feed.widget.base.a) l.this).f34024a.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) l.this).f34024a.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                    com.kwad.sdk.core.download.b.a.b(an.a(l.this), ((com.kwad.sdk.feed.widget.base.a) l.this).f34024a, new a.InterfaceC0376a() { // from class: com.kwad.sdk.feed.widget.l.7.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (l.this.f34026c != null) {
                                l.this.f34026c.a();
                            }
                        }
                    }, l.this.f34085h, c0386a != null ? c0386a.f33658a : false);
                } else {
                    com.kwad.sdk.core.download.b.a.a(an.a(l.this), ((com.kwad.sdk.feed.widget.base.a) l.this).f34024a, new a.InterfaceC0376a() { // from class: com.kwad.sdk.feed.widget.l.7.2
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (l.this.f34026c != null) {
                                l.this.f34026c.a();
                            }
                        }
                    }, l.this.f34085h, c0386a != null ? c0386a.f33658a : false);
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.j, new i.b() { // from class: com.kwad.sdk.feed.widget.l.8
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                l.this.f34084g.setVisibility(0);
                if (l.this.l == 0.0d) {
                    l.this.l = aVar.f33707a;
                    double d2 = aVar.f33707a / l.this.A;
                    l.this.f34083f.setRatio((float) d2);
                    l.t.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a.posId), Double.valueOf(d2));
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new WebCardVideoPositionHandler(this.j, new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.feed.widget.l.9
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (l.this.f34025b == null || !com.kwad.sdk.core.response.b.a.F(l.this.f34025b)) {
                    return;
                }
                l lVar = l.this;
                lVar.B = (ViewGroup.MarginLayoutParams) lVar.r.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.l);
                int i2 = l.this.A;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.B.topMargin = (int) (videoPosition.topMarginRation * ceil);
                double d2 = i2;
                l.this.B.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                l.this.B.width = (int) (d2 * videoPosition.widthRation);
                l.this.B.height = (int) (l.this.B.width * videoPosition.heightWidthRation);
                l.this.r.setLayoutParams(l.this.B);
                l lVar2 = l.this;
                lVar2.a(lVar2.y);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.j, new b.a() { // from class: com.kwad.sdk.feed.widget.l.10
            @Override // com.kwad.sdk.core.webview.jshandler.b.a
            public void a() {
                l.this.C.post(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.l();
                    }
                });
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.j);
        cVar.a(new c.b() { // from class: com.kwad.sdk.feed.widget.l.11
            @Override // com.kwad.sdk.core.webview.jshandler.c.b
            public void a(c.a aVar) {
                aVar.f33667b = 0;
                aVar.f33666a = l.this.A;
                l.this.w = true;
            }
        });
        gVar.a(cVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.D));
        gVar.a(new n(this.j, this.f34085h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.j));
        gVar.a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.kwad.sdk.core.d.a.a("FeedWebView", "handleWebViewError " + str);
        this.C.removeCallbacksAndMessages(null);
        if (this.u) {
            return;
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
        this.z = null;
        this.u = true;
        com.kwad.sdk.core.report.e.c(((com.kwad.sdk.feed.widget.base.a) this).f34024a, com.kwad.sdk.core.config.c.a().h5Url, str);
        if (this.x == null) {
            com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f34024a.type), com.kwad.sdk.core.response.b.a.H(this.f34025b));
            this.x = a2;
            if (a2 != null) {
                this.x.setMargin(an.a(getContext(), 16.0f));
                this.f34083f.removeAllViews();
                this.f34083f.setRatio(0.0f);
                this.f34084g.setVisibility(8);
                this.r.setVisibility(8);
            }
            this.f34083f.addView(this.x);
            this.x.a(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            com.kwad.sdk.feed.widget.base.a aVar2 = this.x;
            if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar2).a(this.y);
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

    @SuppressLint({"ClickableViewAccessibility"})
    private void m() {
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        aVar.f33622b = ((com.kwad.sdk.feed.widget.base.a) this).f34024a;
        aVar.f33621a = 0;
        aVar.f33623c = null;
        aVar.f33625e = this.f34083f;
        aVar.f33626f = this.f34084g;
        aVar.f33624d = null;
        aVar.f33627g = false;
    }

    private void o() {
        com.kwad.sdk.core.webview.a.g gVar = this.f34086i;
        if (gVar != null) {
            gVar.a();
            this.f34086i = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(String str) {
        o();
        aq.b(this.f34084g);
        this.f34084g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.feed.widget.l.6
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
                l.this.a("2");
            }
        });
        com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f34084g);
        this.f34086i = gVar;
        a(gVar);
        this.f34084g.addJavascriptInterface(this.f34086i, "KwaiAd");
        this.f34084g.loadUrl(str);
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.q = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.Q(this.f34025b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.p;
            i2 = 8;
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            imageView = this.p;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.m = com.kwad.sdk.core.response.b.a.I(this.f34025b);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f34027d);
        this.n = bVar;
        bVar.setTag(this.m);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f34025b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.n.a(new c.a().a(a3).b(com.kwad.sdk.core.response.b.d.b(com.kwad.sdk.core.response.b.c.h(((com.kwad.sdk.feed.widget.base.a) this).f34024a))).a(((com.kwad.sdk.feed.widget.base.a) this).f34024a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(this.f34025b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.n.setVideoSoundEnable(this.q);
        j jVar = new j(this.f34027d, ((com.kwad.sdk.feed.widget.base.a) this).f34024a, this.n);
        this.o = jVar;
        jVar.setVideoPlayCallback(new a.InterfaceC0383a() { // from class: com.kwad.sdk.feed.widget.l.13
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a);
                l.this.s.a(3);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a);
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
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.this.n.d()) {
                    l lVar = l.this;
                    lVar.a(lVar.n, false);
                    return;
                }
                l.this.n.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(l.this.f34025b), System.currentTimeMillis()));
                l.this.n.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.u) {
            com.kwad.sdk.feed.widget.base.a aVar = this.x;
            if (aVar != null) {
                aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.x;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.y);
                    return;
                }
                return;
            }
            return;
        }
        if (this.k != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
        }
        String str = this.v;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (f()) {
                this.f34084g.reload();
            } else {
                e();
            }
        }
        this.v = adTemplate.mOriginJString;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        a aVar2 = this.z;
        if (aVar2 != null) {
            aVar2.a();
            this.z = null;
        }
        this.z = aVar;
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.k != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
        }
        String str = this.v;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (f()) {
                this.f34084g.reload();
            } else {
                e();
            }
        }
        this.v = adTemplate.mOriginJString;
        this.C.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.f34084g.stopLoading();
                l.this.f34084g.setVisibility(8);
                l.this.a("0");
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        this.f34085h = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
        ((com.kwad.sdk.feed.widget.base.a) this).f34024a = adTemplate;
        Double d2 = t.get(Long.valueOf(adTemplate.posId));
        if (d2 != null) {
            this.f34083f.setRatio(d2.floatValue());
        } else {
            double d3 = this.f34025b.adStyleInfo.feedAdInfo.heightRatio;
            if (d3 > 0.0d) {
                ratioFrameLayout = this.f34083f;
                c2 = (float) d3;
            } else if (this.f34083f.getRatio() == 0.0f) {
                ratioFrameLayout = this.f34083f;
                c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            }
            ratioFrameLayout.setRatio(c2);
        }
        m();
        n();
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
        this.f34084g = ksAdWebView;
        ksAdWebView.setVisibility(4);
        this.f34083f = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.r = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.p = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
    }

    public void e() {
        File c2 = com.kwad.sdk.core.config.c.c(getContext());
        if (c2.exists() || c2.length() <= 0) {
            setupJsBridgeAndLoadUrl(Uri.fromFile(c2).toString());
        } else {
            a("0");
        }
    }

    public boolean f() {
        return this.k == 1;
    }

    public void g() {
        this.C.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.kwad.sdk.core.view.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
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
        String a2 = com.kwad.sdk.core.response.b.a.a(this.f34025b);
        this.n.setVideoSoundEnable(this.q);
        this.o.setVideoPlayCallback(new a.InterfaceC0383a() { // from class: com.kwad.sdk.feed.widget.l.5
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0383a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) l.this).f34024a);
                if (l.this.r != null) {
                    l.this.r.setVisibility(8);
                }
            }
        });
        this.o.n();
        this.o.setAutoRelease(true);
        AdVideoPlayerViewCache.a().a(a2);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void setMargin(int i2) {
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.y = ksAdVideoPlayConfig;
    }

    public void setWidth(int i2) {
        this.A = i2;
    }
}
