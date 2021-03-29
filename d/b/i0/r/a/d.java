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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.h0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.b.i0.r.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public RsplashType f59650a;

    /* renamed from: e  reason: collision with root package name */
    public SplashAd f59654e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<ViewGroup> f59655f;

    /* renamed from: b  reason: collision with root package name */
    public int f59651b = 5;

    /* renamed from: c  reason: collision with root package name */
    public int f59652c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final AdSplashStyle f59653d = new AdSplashStyle();

    /* renamed from: g  reason: collision with root package name */
    public AdLoadState f59656g = AdLoadState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.k.b f59657h = new a();

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.k.b {
        public a() {
        }

        @Override // d.b.h0.k.b
        public void a() {
            d.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.k.a f59659a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.r.a.i.a.o();
            }
        }

        /* renamed from: d.b.i0.r.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1496b implements View.OnClickListener {
            public View$OnClickListenerC1496b(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.r.a.i.a.o();
            }
        }

        /* loaded from: classes4.dex */
        public class c implements CountDownTextView.d {
            public c() {
            }

            @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.d
            public void a(View view) {
                boolean z = d.this.f59656g == AdLoadState.DISMISSED;
                d.this.f59656g = AdLoadState.DISMISSED;
                b bVar = b.this;
                if (bVar.f59659a == null || z) {
                    return;
                }
                d.this.q();
                b.this.f59659a.onAdDismiss();
            }
        }

        /* renamed from: d.b.i0.r.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1497d implements CountDownTextView.b {

            /* renamed from: d.b.i0.r.a.d$b$d$a */
            /* loaded from: classes4.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z = d.this.f59656g == AdLoadState.DISMISSED;
                    d.this.f59656g = AdLoadState.DISMISSED;
                    b bVar = b.this;
                    if (bVar.f59659a == null || z) {
                        return;
                    }
                    d.this.q();
                    b.this.f59659a.onAdDismiss();
                }
            }

            public C1497d() {
            }

            @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.b
            public void a(int i) {
                if (i != 1 || d.this.f59650a == null || d.this.f59650a == RsplashType.VIDEO) {
                    return;
                }
                e.a().postDelayed(new a(), 300L);
            }
        }

        public b(d.b.h0.k.a aVar) {
            this.f59659a = aVar;
        }

        public final void a(String str, int i) {
            d.b.b.e.n.a a2 = j.a();
            a2.b("type", AdCard.CHARGE_STYLE_CPC);
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.i0.r.a.g.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.this.f59656g = AdLoadState.SUCCEED;
            if (d.this.f59654e == null || d.this.f59655f == null) {
                return;
            }
            d.this.f59650a = rsplashType;
            d.this.f59652c = 0;
            int i2 = i / 1000;
            if (rsplashType == RsplashType.VIDEO) {
                d.this.f59651b = (i2 < 3 || i2 > 5) ? 5 : 5;
            } else {
                d.this.f59651b = 3;
            }
            d.b.i0.r.a.g.a.c().g(this.f59659a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdClick() {
            d.b.h0.k.a aVar = this.f59659a;
            if (aVar != null) {
                aVar.a(d.this.f59650a == RsplashType.VIDEO, 1 == d.this.f59652c, 7);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdDismissed() {
            d.this.q();
            boolean z = d.this.f59656g == AdLoadState.DISMISSED;
            d.this.f59656g = AdLoadState.DISMISSED;
            d.b.h0.k.a aVar = this.f59659a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdFailed(String str) {
            d.this.f59656g = AdLoadState.FAILED;
            d.b.i0.r.a.g.a.c().g(this.f59659a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 7).param("obj_type", "a064").param("obj_locate", 1));
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdPresent() {
            boolean z = 1 == d.this.f59652c;
            d.b.h0.k.a aVar = this.f59659a;
            if (aVar != null) {
                aVar.c(d.this.f59650a == RsplashType.VIDEO, z, 7);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 7).param("obj_type", "a064").param("obj_locate", 0));
            a("advert_show", 1);
            ViewGroup viewGroup = (ViewGroup) d.this.f59655f.get();
            if (viewGroup != null) {
                Context context = viewGroup.getContext();
                CountDownTextView countDownTextView = new CountDownTextView(context);
                countDownTextView.setGravity(17);
                countDownTextView.setNumTypeFromBes(true);
                countDownTextView.d(context.getResources().getString(R.string.ad_skip), d.this.f59651b);
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(countDownTextView);
                a2.h(R.string.AD_J_X45);
                a2.r(R.dimen.tbds42);
                a2.n(R.color.CAM_X0101);
                a2.c(R.color.black_alpha20);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(context, R.dimen.tbds216), l.g(context, R.dimen.tbds90));
                d.b.i0.r.a.i.a.n(layoutParams, AdSplashStyle.SplashElement.SKIP, d.this.f59653d, z);
                viewGroup.addView(countDownTextView, layoutParams);
                countDownTextView.setOnClickListener(new a(this));
                countDownTextView.setOnClickListener(new View$OnClickListenerC1496b(this));
                countDownTextView.setTimeoutListener(new c());
                countDownTextView.setTimerChangedListener(new C1497d());
                if (!TextUtils.isEmpty(d.this.f59653d.f14644c)) {
                    TextView textView = new TextView(context);
                    textView.setGravity(17);
                    textView.setText(d.this.f59653d.f14644c);
                    d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(textView);
                    a3.h(R.string.AD_J_X09);
                    a3.r(R.dimen.tbds36);
                    a3.n(R.color.CAM_X0101);
                    a3.c(R.color.black_alpha20);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.g(context, R.dimen.tbds105), l.g(context, R.dimen.tbds63));
                    d.b.i0.r.a.i.a.n(layoutParams2, AdSplashStyle.SplashElement.LABEL, d.this.f59653d, z);
                    viewGroup.addView(textView, layoutParams2);
                }
                if (z) {
                    int g2 = l.g(context, R.dimen.tbds90);
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(d.this.f59653d.a() ? R.drawable.bg_bes_splash_logo_white : R.drawable.bg_bes_splash_logo_blue);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, g2);
                    d.b.i0.r.a.i.a.n(layoutParams3, AdSplashStyle.SplashElement.LOGO, d.this.f59653d, z);
                    viewGroup.addView(imageView, layoutParams3);
                }
            }
        }

        @Override // com.baidu.mobads.SplashLpCloseListener
        public void onLpClosed() {
            d.b.h0.k.a aVar = this.f59659a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            d.this.q();
        }
    }

    @Override // d.b.i0.r.a.g.b
    public String a() {
        return AdCard.CHARGE_STYLE_CPC;
    }

    @Override // d.b.i0.r.a.g.b
    public AdLoadState b() {
        return this.f59656g;
    }

    @Override // d.b.i0.r.a.g.b
    public void c(d.b.h0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50238c = this.f59657h;
        d.b.h0.k.a a2 = cVar.a();
        this.f59655f = new WeakReference<>(cVar.b());
        b bVar = new b(a2);
        try {
            Context context = cVar.b().getContext();
            SplashAd splashAd = new SplashAd(context, cVar.b(), bVar, "7352842", true, new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").build(), 1000, false, true);
            this.f59654e = splashAd;
            this.f59656g = AdLoadState.LOADING;
            splashAd.load();
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.b("oom");
        }
    }

    public final void p() {
        WeakReference<ViewGroup> weakReference = this.f59655f;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59655f.get().getLayoutParams();
        if (1 != this.f59652c) {
            layoutParams.width = l.k(this.f59655f.get().getContext());
            layoutParams.height = (int) (l.i(this.f59655f.get().getContext()) * 0.8125d);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        this.f59655f.get().setLayoutParams(layoutParams);
    }

    public void q() {
        SplashAd splashAd = this.f59654e;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.i0.r.a.g.a.c().a();
    }

    @Override // d.b.i0.r.a.g.b
    public void show() {
        if (this.f59654e == null || this.f59655f == null || this.f59656g != AdLoadState.SUCCEED) {
            return;
        }
        p();
        int i = this.f59652c;
        this.f59656g = AdLoadState.SHOWED;
        this.f59654e.show();
    }
}
