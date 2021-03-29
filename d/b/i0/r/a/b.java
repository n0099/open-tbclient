package d.b.i0.r.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.h0.m0.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b implements d.b.i0.r.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public RsplashType f59628a;

    /* renamed from: e  reason: collision with root package name */
    public SplashAd f59632e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<ViewGroup> f59633f;

    /* renamed from: b  reason: collision with root package name */
    public int f59629b = 5;

    /* renamed from: c  reason: collision with root package name */
    public int f59630c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final AdSplashStyle f59631d = new AdSplashStyle();

    /* renamed from: g  reason: collision with root package name */
    public AdLoadState f59634g = AdLoadState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.k.b f59635h = new a();

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.k.b {
        public a() {
        }

        @Override // d.b.h0.k.b
        public void a() {
            b.this.p();
        }
    }

    /* renamed from: d.b.i0.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1494b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.k.a f59637a;

        /* renamed from: d.b.i0.r.a.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(C1494b c1494b) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.r.a.i.a.o();
            }
        }

        /* renamed from: d.b.i0.r.a.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1495b implements CountDownTextView.d {
            public C1495b() {
            }

            @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.d
            public void a(View view) {
                boolean z = b.this.f59634g == AdLoadState.DISMISSED;
                C1494b c1494b = C1494b.this;
                if (c1494b.f59637a != null && !z) {
                    b.this.q();
                    C1494b.this.f59637a.onAdDismiss();
                }
                b.this.f59634g = AdLoadState.DISMISSED;
            }
        }

        /* renamed from: d.b.i0.r.a.b$b$c */
        /* loaded from: classes4.dex */
        public class c implements CountDownTextView.b {

            /* renamed from: d.b.i0.r.a.b$b$c$a */
            /* loaded from: classes4.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z = b.this.f59634g == AdLoadState.DISMISSED;
                    C1494b c1494b = C1494b.this;
                    if (c1494b.f59637a != null && !z) {
                        b.this.q();
                        C1494b.this.f59637a.onAdDismiss();
                    }
                    b.this.f59634g = AdLoadState.DISMISSED;
                }
            }

            public c() {
            }

            @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.b
            public void a(int i) {
                if (i != 1 || b.this.f59628a == null || b.this.f59628a == RsplashType.VIDEO) {
                    return;
                }
                e.a().postDelayed(new a(), 300L);
            }
        }

        public C1494b(d.b.h0.k.a aVar) {
            this.f59637a = aVar;
        }

        public final void a(String str, int i) {
            d.b.b.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.i0.r.a.g.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            b.this.f59634g = AdLoadState.SUCCEED;
            if (b.this.f59632e == null || b.this.f59633f == null) {
                return;
            }
            b.this.f59628a = rsplashType;
            if (b.this.f59632e != null && b.this.f59632e.getExtData() != null) {
                HashMap extData = b.this.f59632e.getExtData();
                Object obj = extData.get("custom_ext_data");
                Object obj2 = extData.get("pattern");
                if (obj2 != null) {
                    b.this.f59630c = d.b.b.e.m.b.d(obj2.toString(), 1);
                }
                if (obj != null) {
                    b.this.f59631d.c(obj.toString());
                }
            }
            int i2 = b.this.f59631d.f14643b;
            if (rsplashType == RsplashType.VIDEO) {
                if (i2 >= 3) {
                    b.this.f59629b = i2;
                } else {
                    b.this.f59634g = AdLoadState.FAILED;
                }
            } else if (i2 < 3 || i2 > 5) {
                b.this.f59629b = 3;
            } else {
                b.this.f59629b = i2;
            }
            d.b.i0.r.a.g.a.c().g(this.f59637a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdClick() {
            d.b.h0.k.a aVar = this.f59637a;
            if (aVar != null) {
                aVar.a(b.this.f59628a == RsplashType.VIDEO, 1 == b.this.f59630c, 1);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdDismissed() {
            b.this.q();
            boolean z = b.this.f59634g == AdLoadState.DISMISSED;
            b.this.f59634g = AdLoadState.DISMISSED;
            d.b.h0.k.a aVar = this.f59637a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdFailed(String str) {
            b.this.f59634g = AdLoadState.FAILED;
            d.b.i0.r.a.g.a.c().g(this.f59637a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdPresent() {
            boolean z = 1 == b.this.f59630c;
            d.b.h0.k.a aVar = this.f59637a;
            if (aVar != null) {
                aVar.c(b.this.f59628a == RsplashType.VIDEO, z, 1);
            }
            ViewGroup viewGroup = (ViewGroup) b.this.f59633f.get();
            if (viewGroup != null) {
                Context context = viewGroup.getContext();
                CountDownTextView countDownTextView = new CountDownTextView(context);
                countDownTextView.setGravity(17);
                countDownTextView.setNumTypeFromBes(true);
                countDownTextView.d(context.getResources().getString(R.string.ad_skip), b.this.f59629b);
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(countDownTextView);
                a2.h(R.string.AD_J_X45);
                a2.r(R.dimen.tbds42);
                a2.n(R.color.CAM_X0101);
                a2.c(R.color.black_alpha20);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(context, R.dimen.tbds216), l.g(context, R.dimen.tbds90));
                d.b.i0.r.a.i.a.n(layoutParams, AdSplashStyle.SplashElement.SKIP, b.this.f59631d, z);
                viewGroup.addView(countDownTextView, layoutParams);
                countDownTextView.setOnClickListener(new a(this));
                countDownTextView.setTimeoutListener(new C1495b());
                countDownTextView.setTimerChangedListener(new c());
                if (!TextUtils.isEmpty(b.this.f59631d.f14644c)) {
                    TextView textView = new TextView(context);
                    textView.setGravity(17);
                    textView.setText(b.this.f59631d.f14644c);
                    d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(textView);
                    a3.h(R.string.AD_J_X09);
                    a3.r(R.dimen.tbds36);
                    a3.n(R.color.CAM_X0101);
                    a3.c(R.color.black_alpha20);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.g(context, R.dimen.tbds105), l.g(context, R.dimen.tbds63));
                    d.b.i0.r.a.i.a.n(layoutParams2, AdSplashStyle.SplashElement.LABEL, b.this.f59631d, z);
                    viewGroup.addView(textView, layoutParams2);
                }
                if (z) {
                    int g2 = l.g(context, R.dimen.tbds90);
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(b.this.f59631d.a() ? R.drawable.bg_bes_splash_logo_white : R.drawable.bg_bes_splash_logo_blue);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, g2);
                    d.b.i0.r.a.i.a.n(layoutParams3, AdSplashStyle.SplashElement.LOGO, b.this.f59631d, z);
                    viewGroup.addView(imageView, layoutParams3);
                }
            }
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.SplashLpCloseListener
        public void onLpClosed() {
            d.b.h0.k.a aVar = this.f59637a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            b.this.q();
        }
    }

    @Override // d.b.i0.r.a.g.b
    public String a() {
        return null;
    }

    @Override // d.b.i0.r.a.g.b
    public AdLoadState b() {
        return this.f59634g;
    }

    @Override // d.b.i0.r.a.g.b
    public void c(d.b.h0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50238c = this.f59635h;
        d.b.h0.k.a a2 = cVar.a();
        this.f59633f = new WeakReference<>(cVar.b());
        C1494b c1494b = new C1494b(a2);
        try {
            Context context = cVar.b().getContext();
            SplashAd splashAd = new SplashAd(context, cVar.b(), c1494b, "4776976", true, new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").build(), 1000, false, true);
            this.f59632e = splashAd;
            this.f59634g = AdLoadState.LOADING;
            splashAd.load();
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.b("oom");
        }
    }

    public final void p() {
        WeakReference<ViewGroup> weakReference = this.f59633f;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59633f.get().getLayoutParams();
        if (1 != this.f59630c) {
            layoutParams.width = l.k(this.f59633f.get().getContext());
            layoutParams.height = (int) (l.i(this.f59633f.get().getContext()) * 0.8125d);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        this.f59633f.get().setLayoutParams(layoutParams);
    }

    public void q() {
        SplashAd splashAd = this.f59632e;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.i0.r.a.g.a.c().a();
    }

    @Override // d.b.i0.r.a.g.b
    public void show() {
        if (this.f59632e == null || this.f59633f == null || this.f59634g != AdLoadState.SUCCEED) {
            return;
        }
        p();
        int i = this.f59630c;
        this.f59634g = AdLoadState.SHOWED;
        this.f59632e.show();
    }
}
