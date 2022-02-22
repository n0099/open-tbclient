package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.v;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static final HashMap<Long, Double> s = new HashMap<>(8);
    public ViewGroup.MarginLayoutParams A;
    public Handler B;
    public p.b C;
    public final a.InterfaceC2128a D;
    public RatioFrameLayout a;

    /* renamed from: f  reason: collision with root package name */
    public KsAdWebView f57136f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57137g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57138h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57139i;

    /* renamed from: j  reason: collision with root package name */
    public int f57140j;
    public double k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public ImageView o;
    public boolean p;
    public KSFrameLayout q;
    public v r;
    public boolean t;
    public String u;
    public boolean v;
    public com.kwad.sdk.feed.widget.base.a w;
    public KsAdVideoPlayConfig x;
    public a y;
    public int z;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public l(@NonNull Context context) {
        super(context);
        this.f57140j = -1;
        this.p = false;
        this.v = false;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new p.b() { // from class: com.kwad.sdk.feed.widget.l.12
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                if (l.this.t) {
                    return;
                }
                l.this.f57140j = aVar.a;
                if (l.this.f57140j != 1) {
                    l.this.a("3");
                    return;
                }
                if (l.this.w != null) {
                    l.this.w.setVisibility(8);
                }
                l.this.f57136f.setVisibility(0);
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
                l.this.B.removeCallbacksAndMessages(null);
                if (l.this.y != null) {
                    l.this.y.a();
                }
            }
        };
        this.D = new a.InterfaceC2128a() { // from class: com.kwad.sdk.feed.widget.l.5
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2128a
            public void a(int i2, z.a aVar) {
                int i3;
                int i4 = 2;
                boolean z = false;
                if (i2 == 1) {
                    i3 = 13;
                } else if (i2 == 2) {
                    i3 = 82;
                } else if (i2 != 3) {
                    i3 = 108;
                } else {
                    i3 = 83;
                    i4 = 1;
                    z = true;
                }
                p.a aVar2 = new p.a();
                aVar2.f56278g = aVar;
                aVar2.f56273b = i3;
                com.kwad.sdk.core.download.a.a.a(new a.C2116a(bb.a(l.this.m)).a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b).a(l.this.f57137g).a(i4).a(z).c(true).a(aVar2).e(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.l.5.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        l.this.l();
                    }
                }));
            }
        };
        this.z = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.l.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f57095b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
            boolean z = false;
            this.n.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.m);
            FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f57095b.type);
            a.C2116a a3 = new a.C2116a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f57095b).a(this.f57137g).a(2);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) this).f57096c)) {
                z = true;
            }
            com.kwad.sdk.core.download.a.a.a(a3.e(z).a(new a.b() { // from class: com.kwad.sdk.feed.widget.l.3
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    l.this.k();
                }
            }));
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        this.r = new v();
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f57139i, this.f57137g, getClickListener()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57139i, this.f57137g, getClickListener()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f57139i, new j.b() { // from class: com.kwad.sdk.feed.widget.l.7
            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
                l.this.f57136f.setVisibility(0);
                if (l.this.k == 0.0d) {
                    l.this.k = aVar.a;
                    double d2 = aVar.a / l.this.z;
                    l.this.a.setRatio((float) d2);
                    l.s.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b.posId), Double.valueOf(d2));
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f57139i));
        gVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.feed.widget.l.8
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (((com.kwad.sdk.feed.widget.base.a) l.this).f57096c == null || !com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) l.this).f57096c)) {
                    return;
                }
                l lVar = l.this;
                lVar.A = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.k);
                int i2 = l.this.z;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.A.topMargin = (int) (videoPosition.topMarginRation * ceil);
                double d2 = i2;
                l.this.A.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                l.this.A.width = (int) (d2 * videoPosition.widthRation);
                l.this.A.height = (int) (l.this.A.width * videoPosition.heightWidthRation);
                l.this.q.setRadius(videoPosition.borderRadius);
                l.this.q.setLayoutParams(l.this.A);
                l lVar2 = l.this;
                lVar2.a(lVar2.x);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f57139i, new c.a() { // from class: com.kwad.sdk.feed.widget.l.9
            @Override // com.kwad.sdk.core.webview.jshandler.c.a
            public void a() {
                l.this.B.post(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.m();
                    }
                });
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57139i));
        com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.f57139i);
        dVar.a(new d.b() { // from class: com.kwad.sdk.feed.widget.l.10
            @Override // com.kwad.sdk.core.webview.jshandler.d.b
            public void a(d.a aVar) {
                aVar.f56578b = 0;
                aVar.a = l.this.z;
                l.this.v = true;
            }
        });
        gVar.a(dVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.p(this.C));
        gVar.a(new t(this.f57139i, this.f57137g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f57139i));
        gVar.a(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.kwad.sdk.core.d.a.a("FeedWebView", "handleWebViewError " + str);
        this.B.removeCallbacksAndMessages(null);
        if (this.t) {
            return;
        }
        a aVar = this.y;
        if (aVar != null) {
            aVar.a();
        }
        this.y = null;
        this.t = true;
        AdTemplate adTemplate = ((com.kwad.sdk.feed.widget.base.a) this).f57095b;
        com.kwad.sdk.core.report.d.c(adTemplate, com.kwad.sdk.core.response.a.b.k(adTemplate), str);
        if (this.w == null) {
            com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f57095b.type), com.kwad.sdk.core.response.a.a.R(((com.kwad.sdk.feed.widget.base.a) this).f57096c));
            this.w = a2;
            if (a2 != null) {
                this.w.setMargin(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
                this.a.removeAllViews();
                this.a.setRatio(0.0f);
                this.f57136f.setVisibility(8);
                this.q.setVisibility(8);
            }
            this.a.addView(this.w);
            this.w.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
            com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
            if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.a ? aVar.f56571b : aVar.f56572c == 1;
    }

    private float c(AdTemplate adTemplate) {
        int i2 = adTemplate.type;
        if (i2 == 1) {
            return 0.6013f;
        }
        return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
    }

    @NonNull
    private b.c getClickListener() {
        return new b.c() { // from class: com.kwad.sdk.feed.widget.l.11
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                int i2 = aVar.f56572c;
                if (aVar.a) {
                    i2 = aVar.f56571b ? 1 : 2;
                }
                boolean z = com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) l.this).f57096c) && (((com.kwad.sdk.feed.widget.base.a) l.this).f57095b.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) l.this).f57095b.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                p.a aVar2 = new p.a();
                b.C2133b c2133b = aVar.f56573d;
                if (c2133b != null && !TextUtils.isEmpty(c2133b.a)) {
                    aVar2.f56279h = aVar.f56573d.a;
                }
                com.kwad.sdk.core.download.a.a.a(new a.C2116a(bb.a(l.this)).a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b).a(l.this.f57137g).a(l.this.a(aVar)).a(i2).f(aVar.a).e(z).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.l.11.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        if (((com.kwad.sdk.feed.widget.base.a) l.this).f57097d != null) {
                            ((com.kwad.sdk.feed.widget.base.a) l.this).f57097d.a();
                        }
                    }
                }));
            }
        };
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void o() {
    }

    private void p() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f57139i = aVar;
        aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
        com.kwad.sdk.core.webview.a aVar2 = this.f57139i;
        aVar2.a = 0;
        aVar2.f56539b = null;
        aVar2.f56541d = this.a;
        aVar2.f56542e = this.f57136f;
        aVar2.f56540c = null;
        aVar2.f56545h = false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        be.b(this.f57136f);
        this.f57136f.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.feed.widget.l.6
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                l.this.v = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                l.this.a("1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (l.this.v) {
                    return;
                }
                l.this.a("2");
            }
        });
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57136f);
        this.f57138h = gVar;
        a(gVar);
        this.f57136f.addJavascriptInterface(this.f57138h, "KwaiAd");
        this.f57136f.loadUrl(com.kwad.sdk.core.response.a.b.k(((com.kwad.sdk.feed.widget.base.a) this).f57095b));
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f57138h;
        if (gVar != null) {
            gVar.a();
            this.f57138h = null;
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f57096c).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.o;
            i2 = 8;
        } else {
            this.o.setImageDrawable(null);
            KSImageLoader.loadImage(this.o, a2, ((com.kwad.sdk.feed.widget.base.a) this).f57095b);
            imageView = this.o;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f57098e);
        this.m = bVar;
        bVar.setTag(this.l);
        String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b).a(a3).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f57095b))).a(((com.kwad.sdk.feed.widget.base.a) this).f57095b.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f57095b, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.m.setVideoSoundEnable(this.p);
        j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f57098e, ((com.kwad.sdk.feed.widget.base.a) this).f57095b, this.m);
        this.n = jVar;
        jVar.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.feed.widget.l.13

            /* renamed from: b  reason: collision with root package name */
            public boolean f57141b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                l.this.a(j2);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
                l.this.r.a(3);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.f57141b) {
                    return;
                }
                this.f57141b = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
                l.this.r.a(9);
                if (l.this.q != null) {
                    l.this.q.setVisibility(8);
                }
            }
        });
        this.n.setAdClickListener(this.D);
        this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.m.setController(this.n);
        if (this.q.getTag() != null) {
            KSFrameLayout kSFrameLayout = this.q;
            kSFrameLayout.removeView((View) kSFrameLayout.getTag());
            this.q.setTag(null);
        }
        this.q.addView(this.m);
        this.q.setTag(this.m);
        this.q.setClickable(true);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.this.m.d()) {
                    l lVar = l.this;
                    lVar.a(lVar.m);
                    return;
                }
                m.b(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
                l.this.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b));
                l.this.m.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.t) {
            com.kwad.sdk.feed.widget.base.a aVar = this.w;
            if (aVar != null) {
                aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f57140j != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
        }
        String str = this.u;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f57136f.reload();
            } else {
                d();
            }
        }
        this.u = adTemplate.mOriginJString;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        a aVar2 = this.y;
        if (aVar2 != null) {
            aVar2.a();
            this.y = null;
        }
        this.y = aVar;
        adTemplate.realShowType = 2;
        super.a(adTemplate);
        if (this.f57140j != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
        }
        String str = this.u;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f57136f.reload();
            } else {
                d();
            }
        }
        this.u = adTemplate.mOriginJString;
        this.B.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.f57136f.stopLoading();
                l.this.f57136f.setVisibility(8);
                l.this.a("0");
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        m.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
        this.f57137g = bVar;
        bVar.a((DialogInterface.OnShowListener) this);
        this.f57137g.a((DialogInterface.OnDismissListener) this);
        ((com.kwad.sdk.feed.widget.base.a) this).f57095b = adTemplate;
        Double d2 = s.get(Long.valueOf(adTemplate.posId));
        if (d2 != null) {
            this.a.setRatio(d2.floatValue());
        } else {
            if (com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).f57095b) > 0.0f) {
                ratioFrameLayout = this.a;
                c2 = com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
            } else if (this.a.getRatio() == 0.0f) {
                ratioFrameLayout = this.a;
                c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f57095b);
            }
            ratioFrameLayout.setRatio(c2);
        }
        o();
        p();
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
        this.f57136f = ksAdWebView;
        ksAdWebView.setVisibility(4);
        this.a = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.q = (KSFrameLayout) findViewById(R.id.ksad_video_container);
        this.o = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
    }

    public void d() {
        if (com.kwad.sdk.core.response.a.b.m(((com.kwad.sdk.feed.widget.base.a) this).f57095b)) {
            q();
        } else {
            a("0");
        }
    }

    public boolean g() {
        return this.f57140j == 1;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    public void h() {
        this.B.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (!z || (bVar = this.m) == null || (viewGroup = (ViewGroup) bVar.getParent()) == this.q) {
            return;
        }
        viewGroup.removeView(this.m);
        if (this.q.getTag() != null) {
            KSFrameLayout kSFrameLayout = this.q;
            kSFrameLayout.removeView((View) kSFrameLayout.getTag());
            this.q.setTag(null);
        }
        this.q.addView(this.m);
        this.q.setTag(this.m);
        String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        this.m.setVideoSoundEnable(this.p);
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.x;
        if (ksAdVideoPlayConfig != null) {
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        }
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.feed.widget.l.4

            /* renamed from: b  reason: collision with root package name */
            public boolean f57142b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                l.this.a(j2);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.f57142b) {
                    return;
                }
                this.f57142b = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) l.this).f57095b);
                if (l.this.q != null) {
                    l.this.q.setVisibility(8);
                }
            }
        });
        this.n.setAdClickListener(this.D);
        this.n.getAdTemplate().mAdWebVideoPageShowing = false;
        this.n.p();
        this.n.setAutoRelease(true);
        AdVideoPlayerViewCache.a().a(a2);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void setMargin(int i2) {
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.x = ksAdVideoPlayConfig;
        com.kwad.sdk.core.video.videoview.b bVar = this.m;
        if (bVar != null) {
            bVar.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        }
        j jVar = this.n;
        if (jVar != null) {
            jVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        }
    }

    public void setWidth(int i2) {
        this.z = i2;
    }
}
