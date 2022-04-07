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
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static final HashMap<Long, Double> s = new HashMap<>(8);
    public ViewGroup.MarginLayoutParams A;
    public Handler B;
    public p.b C;
    public final a.InterfaceC0308a D;
    public RatioFrameLayout a;
    public KsAdWebView f;
    @Nullable
    public com.kwad.sdk.core.download.a.b g;
    public com.kwad.sdk.core.webview.kwai.g h;
    public com.kwad.sdk.core.webview.a i;
    public int j;
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

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public l(@NonNull Context context) {
        super(context);
        this.j = -1;
        this.p = false;
        this.v = false;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new p.b() { // from class: com.kwad.sdk.feed.widget.l.12
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                if (l.this.t) {
                    return;
                }
                l.this.j = aVar.a;
                if (l.this.j != 1) {
                    l.this.a("3");
                    return;
                }
                if (l.this.w != null) {
                    l.this.w.setVisibility(8);
                }
                l.this.f.setVisibility(0);
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).b);
                l.this.B.removeCallbacksAndMessages(null);
                if (l.this.y != null) {
                    l.this.y.a();
                }
            }
        };
        this.D = new a.InterfaceC0308a() { // from class: com.kwad.sdk.feed.widget.l.5
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0308a
            public void a(int i, z.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                p.a aVar2 = new p.a();
                aVar2.g = aVar;
                aVar2.b = i2;
                com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(l.this.m)).a(((com.kwad.sdk.feed.widget.base.a) l.this).b).a(l.this.g).a(i3).a(z).c(true).a(aVar2).e(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.l.5.1
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
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.l.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
            boolean z = false;
            this.n.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.m);
            FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).b.type);
            a.C0296a a3 = new a.C0296a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).b).a(this.g).a(2);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) this).c)) {
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
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.i, this.g, getClickListener()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.i, this.g, getClickListener()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.i, new j.b() { // from class: com.kwad.sdk.feed.widget.l.7
            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
                l.this.f.setVisibility(0);
                if (l.this.k == 0.0d) {
                    l.this.k = aVar.a;
                    double d = aVar.a / l.this.z;
                    l.this.a.setRatio((float) d);
                    l.s.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) l.this).b.posId), Double.valueOf(d));
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.i));
        gVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.feed.widget.l.8
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (((com.kwad.sdk.feed.widget.base.a) l.this).c == null || !com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) l.this).c)) {
                    return;
                }
                l lVar = l.this;
                lVar.A = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.k);
                int i = l.this.z;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.A.topMargin = (int) (videoPosition.topMarginRation * ceil);
                double d = i;
                l.this.A.leftMargin = (int) (videoPosition.leftMarginRation * d);
                l.this.A.width = (int) (d * videoPosition.widthRation);
                l.this.A.height = (int) (l.this.A.width * videoPosition.heightWidthRation);
                l.this.q.setRadius(videoPosition.borderRadius);
                l.this.q.setLayoutParams(l.this.A);
                l lVar2 = l.this;
                lVar2.a(lVar2.x);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.i, new c.a() { // from class: com.kwad.sdk.feed.widget.l.9
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
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.i));
        com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.i);
        dVar.a(new d.b() { // from class: com.kwad.sdk.feed.widget.l.10
            @Override // com.kwad.sdk.core.webview.jshandler.d.b
            public void a(d.a aVar) {
                aVar.b = 0;
                aVar.a = l.this.z;
                l.this.v = true;
            }
        });
        gVar.a(dVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.p(this.C));
        gVar.a(new t(this.i, this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.i));
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
        AdTemplate adTemplate = ((com.kwad.sdk.feed.widget.base.a) this).b;
        com.kwad.sdk.core.report.d.c(adTemplate, com.kwad.sdk.core.response.a.b.k(adTemplate), str);
        if (this.w == null) {
            com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).b.type), com.kwad.sdk.core.response.a.a.R(((com.kwad.sdk.feed.widget.base.a) this).c));
            this.w = a2;
            if (a2 != null) {
                this.w.setMargin(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
                this.a.removeAllViews();
                this.a.setRatio(0.0f);
                this.f.setVisibility(8);
                this.q.setVisibility(8);
            }
            this.a.addView(this.w);
            this.w.a(((com.kwad.sdk.feed.widget.base.a) this).b);
            com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
            if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.a ? aVar.b : aVar.c == 1;
    }

    private float c(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    @NonNull
    private b.c getClickListener() {
        return new b.c() { // from class: com.kwad.sdk.feed.widget.l.11
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                int i = aVar.c;
                if (aVar.a) {
                    i = aVar.b ? 1 : 2;
                }
                boolean z = com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) l.this).c) && (((com.kwad.sdk.feed.widget.base.a) l.this).b.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) l.this).b.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                p.a aVar2 = new p.a();
                b.C0313b c0313b = aVar.d;
                if (c0313b != null && !TextUtils.isEmpty(c0313b.a)) {
                    aVar2.h = aVar.d.a;
                }
                com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(l.this)).a(((com.kwad.sdk.feed.widget.base.a) l.this).b).a(l.this.g).a(l.this.a(aVar)).a(i).f(aVar.a).e(z).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.l.11.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        if (((com.kwad.sdk.feed.widget.base.a) l.this).d != null) {
                            ((com.kwad.sdk.feed.widget.base.a) l.this).d.a();
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
        this.i = aVar;
        aVar.a(((com.kwad.sdk.feed.widget.base.a) this).b);
        com.kwad.sdk.core.webview.a aVar2 = this.i;
        aVar2.a = 0;
        aVar2.b = null;
        aVar2.d = this.a;
        aVar2.e = this.f;
        aVar2.c = null;
        aVar2.h = false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        be.b(this.f);
        this.f.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.feed.widget.l.6
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                l.this.v = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
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
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f);
        this.h = gVar;
        a(gVar);
        this.f.addJavascriptInterface(this.h, "KwaiAd");
        this.f.loadUrl(com.kwad.sdk.core.response.a.b.k(((com.kwad.sdk.feed.widget.base.a) this).b));
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.h;
        if (gVar != null) {
            gVar.a();
            this.h = null;
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).c).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.o;
            i = 8;
        } else {
            this.o.setImageDrawable(null);
            KSImageLoader.loadImage(this.o, a2, ((com.kwad.sdk.feed.widget.base.a) this).b);
            imageView = this.o;
            i = 0;
        }
        imageView.setVisibility(i);
        this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).c);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).e);
        this.m = bVar;
        bVar.setTag(this.l);
        String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).b).a(a3).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).b))).a(((com.kwad.sdk.feed.widget.base.a) this).b.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).b, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.m.setVideoSoundEnable(this.p);
        j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).e, ((com.kwad.sdk.feed.widget.base.a) this).b, this.m);
        this.n = jVar;
        jVar.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.feed.widget.l.13
            public boolean b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) l.this).b);
                l.this.r.a(3);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.b) {
                    return;
                }
                this.b = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) l.this).b);
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
            public void onClick(View view2) {
                if (!l.this.m.d()) {
                    l lVar = l.this;
                    lVar.a(lVar.m);
                    return;
                }
                m.b(((com.kwad.sdk.feed.widget.base.a) l.this).b);
                l.this.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) l.this).b));
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
                aVar.a(((com.kwad.sdk.feed.widget.base.a) this).b);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                    return;
                }
                return;
            }
            return;
        }
        if (this.j != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).b);
        }
        String str = this.u;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f.reload();
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
        if (this.j != 1) {
            b(((com.kwad.sdk.feed.widget.base.a) this).b);
        }
        String str = this.u;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (g()) {
                this.f.reload();
            } else {
                d();
            }
        }
        this.u = adTemplate.mOriginJString;
        this.B.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.widget.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.f.stopLoading();
                l.this.f.setVisibility(8);
                l.this.a("0");
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        m.a(((com.kwad.sdk.feed.widget.base.a) this).b);
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).b);
        this.g = bVar;
        bVar.a((DialogInterface.OnShowListener) this);
        this.g.a((DialogInterface.OnDismissListener) this);
        ((com.kwad.sdk.feed.widget.base.a) this).b = adTemplate;
        Double d = s.get(Long.valueOf(adTemplate.posId));
        if (d != null) {
            this.a.setRatio(d.floatValue());
        } else {
            if (com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).b) > 0.0f) {
                ratioFrameLayout = this.a;
                c = com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).b);
            } else if (this.a.getRatio() == 0.0f) {
                ratioFrameLayout = this.a;
                c = c(((com.kwad.sdk.feed.widget.base.a) this).b);
            }
            ratioFrameLayout.setRatio(c);
        }
        o();
        p();
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091184);
        this.f = ksAdWebView;
        ksAdWebView.setVisibility(4);
        this.a = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091052);
        this.q = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091157);
        this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f091167);
    }

    public void d() {
        if (com.kwad.sdk.core.response.a.b.m(((com.kwad.sdk.feed.widget.base.a) this).b)) {
            q();
        } else {
            a("0");
        }
    }

    public boolean g() {
        return this.j == 1;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d043c;
    }

    public void h() {
        this.B.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
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
        String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
        this.m.setVideoSoundEnable(this.p);
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.x;
        if (ksAdVideoPlayConfig != null) {
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        }
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.feed.widget.l.4
            public boolean b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                l.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) l.this).b);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.b) {
                    return;
                }
                this.b = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) l.this).b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) l.this).b);
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
    public void setMargin(int i) {
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

    public void setWidth(int i) {
        this.z = i;
    }
}
