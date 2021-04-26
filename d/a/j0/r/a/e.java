package d.a.j0.r.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.SplashAdFacade;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.p.l;
import d.a.i0.m0.j;
import d.a.i0.z0.n0;
import java.lang.ref.WeakReference;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e implements d.a.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public int f59469b = 5;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f59470c = AdLoadState.INIT;

    /* renamed from: d  reason: collision with root package name */
    public d.a.b0.b.f.d f59471d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f59472e;

    /* loaded from: classes4.dex */
    public class a implements d.a.b0.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.k.a f59473a;

        public a(d.a.i0.k.a aVar) {
            this.f59473a = aVar;
        }

        @Override // d.a.b0.b.d
        public void a(String str) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59501c, str, 0);
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59501c, "1");
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad loaded failed: " + str);
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("");
            }
            e.this.f59470c = AdLoadState.FAILED;
            e("advert_show", 0);
        }

        @Override // d.a.b0.b.d
        public void b() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad finish");
            }
            d.a.i0.k.a aVar = this.f59473a;
            if (aVar != null) {
                aVar.onAdDismiss();
            }
        }

        @Override // d.a.b0.b.d
        public void c(d.a.d0.a.g.d dVar) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59501c, "0", 0);
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue gd loaded success");
            }
            e.this.f59470c = AdLoadState.SUCCEED;
            d.a.j0.r.a.h.a.c().g(this.f59473a);
            e("advert_load", 1);
        }

        @Override // d.a.b0.b.d
        @NonNull
        public ViewGroup d() {
            return (ViewGroup) e.this.f59472e.get();
        }

        public final void e(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "prologue");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // d.a.b0.b.d
        public void onAdClick() {
            boolean z;
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad onclick");
            }
            if (this.f59473a != null) {
                if (e.this.f59471d == null || e.this.f59471d.f() == null) {
                    z = false;
                } else {
                    boolean z2 = e.this.f59471d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    r1 = z2;
                    z = e.this.f59471d.f().optInt("full_type", 0) == 1;
                }
                this.f59473a.b(r1, z, e.this.f59469b);
            }
        }

        @Override // d.a.b0.b.d
        public void onAdShow() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad show");
            }
            d.a.i0.k.a aVar = this.f59473a;
            if (aVar != null) {
                aVar.c(true, false, e.this.f59469b);
            }
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59501c, "0");
            e("advert_show", 1);
        }

        @Override // d.a.b0.b.d
        public void onSkip() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad onskip");
            }
            int i2 = 1;
            boolean z = e.this.f59471d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
            boolean z2 = e.this.f59471d.f().optInt("full_type", 0) == 1;
            if (z2 && z) {
                i2 = 4;
            } else if (z) {
                i2 = 3;
            } else if (z2) {
                i2 = 2;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i2));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d.a.b0.a.b.a {

        /* renamed from: b  reason: collision with root package name */
        public final Context f59475b;

        public b(Context context) {
            this.f59475b = context;
        }

        @Override // d.a.b0.a.b.a
        public String A() {
            return "7352842";
        }

        @Override // d.a.b0.a.b.a
        public int B() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String C() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String D() {
            return TbConfig.getVersion();
        }

        @Override // d.a.b0.a.b.a
        public int E() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String a() {
            return Settings.System.getString(this.f59475b.getContentResolver(), IAdRequestParam.ANDROID_ID);
        }

        @Override // d.a.b0.a.b.a
        public String b() {
            return "1099a";
        }

        @Override // d.a.b0.a.b.a
        public String c() {
            return "";
        }

        @Override // d.a.b0.a.b.a
        public int d() {
            return 120;
        }

        @Override // d.a.b0.a.b.a
        public int e() {
            return R.drawable.pic_splash_logo;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String f() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // d.a.b0.a.b.a
        public String from() {
            return "1099a";
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String g() {
            return Build.VERSION.RELEASE;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String h() {
            String b2 = n0.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + b2);
            }
            return b2;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String i() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // d.a.b0.a.b.a
        public String j() {
            AppPosInfo a2 = d.a.j0.s2.f0.a.e().a();
            return a2 != null ? a2.coordinate_type : "";
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String k() {
            String[] split;
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = d.a.i0.l.a.f48578a;
            }
            if (cookie != null) {
                for (String str : cookie.split(";")) {
                    if (str.contains("BAIDUID=")) {
                        return str.trim().substring(8);
                    }
                }
            }
            return "";
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String l() {
            return "1481698145541";
        }

        @Override // d.a.b0.a.b.a
        public String m() {
            return d.a.q.b.d(TbadkCoreApplication.getInst()).e();
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String n() {
            int[] b2 = d.a.b0.b.b.a().b();
            return TextUtils.join("_", new String[]{String.valueOf(b2[0]), String.valueOf(b2[1]), "android", D(), String.valueOf(b2[2])});
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public Context o() {
            return this.f59475b;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String p() {
            return "2";
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String q() {
            return Build.MODEL;
        }

        @Override // d.a.b0.a.b.a
        public String r() {
            return "bb3808eb";
        }

        @Override // d.a.b0.a.b.a
        public boolean s() {
            return TbadkCoreApplication.getInst().isDebugMode();
        }

        @Override // d.a.b0.a.b.a
        public int t() {
            return 5000;
        }

        @Override // d.a.b0.a.b.a
        public String u() {
            return "tieba";
        }

        @Override // d.a.b0.a.b.a
        public boolean v(String str, d.a.b0.c.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
            return true;
        }

        @Override // d.a.b0.a.b.a
        @NonNull
        public String w() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            return currentAccount == null ? "" : currentAccount;
        }

        @Override // d.a.b0.a.b.a
        public String[] x() {
            AppPosInfo a2;
            if (d.a.j0.s2.f0.a.e() != null && (a2 = d.a.j0.s2.f0.a.e().a()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + a2.longitude + FieldBuilder.SE + a2.latitude);
                }
                return new String[]{a2.longitude, a2.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // d.a.b0.a.b.a
        public String y() {
            return (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) ? "" : TbadkCoreApplication.getInst().getAdAdSense().r;
        }

        @Override // d.a.b0.a.b.a
        public boolean z() {
            return this.f59475b.getResources().getConfiguration().orientation == 2;
        }
    }

    public static void h() {
        SplashAdFacade.a().b(new b(TbadkCoreApplication.getInst()));
    }

    @Override // d.a.j0.r.a.h.b
    public AdLoadState a() {
        return this.f59470c;
    }

    @Override // d.a.j0.r.a.h.b
    public void b(d.a.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        d.a.i0.k.a a2 = cVar.a();
        this.f59472e = new WeakReference<>(cVar.b());
        try {
            this.f59471d = new d.a.b0.b.f.d(TbadkCoreApplication.getInst().getContext(), "1481698145541", new RequestParameters.Builder().setHeight(l.k(cVar.b().getContext())).setWidth(l.i(cVar.b().getContext())).build(), new a(a2));
            this.f59470c = AdLoadState.LOADING;
            d.a.j0.r.a.j.a.h(d.a.j0.r.a.j.a.f59501c);
            this.f59471d.g();
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "prologue ad start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.a("oom");
        }
    }

    @Override // d.a.j0.r.a.h.b
    public String c() {
        return "prologue_gd";
    }

    @Override // d.a.j0.r.a.h.b
    public void destroy() {
        d.a.b0.b.f.d dVar = this.f59471d;
        if (dVar != null) {
            dVar.e();
            this.f59471d = null;
        }
    }

    public final void g() {
        WeakReference<ViewGroup> weakReference = this.f59472e;
        if (weakReference == null || weakReference.get().getParent() == null || !(this.f59472e.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59472e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f59472e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f59471d == null || (weakReference = this.f59472e) == null || weakReference.get() == null || this.f59470c != AdLoadState.SUCCEED) {
            return;
        }
        g();
        this.f59470c = AdLoadState.SHOWED;
        if (d.a.j0.r.a.h.b.f59491a) {
            Log.d("IAdSdkSplash", "prologue ad start show");
        }
        this.f59471d.k(this.f59472e.get());
    }
}
