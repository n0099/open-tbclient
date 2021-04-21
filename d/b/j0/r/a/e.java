package d.b.j0.r.a;

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
import d.b.c.e.p.l;
import d.b.i0.m0.j;
import d.b.i0.z0.n0;
import java.lang.ref.WeakReference;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e implements d.b.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public int f61328b = 5;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f61329c = AdLoadState.INIT;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b0.b.f.d f61330d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f61331e;

    /* loaded from: classes4.dex */
    public class a implements d.b.b0.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.k.a f61332a;

        public a(d.b.i0.k.a aVar) {
            this.f61332a = aVar;
        }

        @Override // d.b.b0.b.d
        public void a(String str) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61359c, str, 0);
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61359c, "1");
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad loaded failed: " + str);
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("");
            }
            e.this.f61329c = AdLoadState.FAILED;
            e("advert_show", 0);
        }

        @Override // d.b.b0.b.d
        @NonNull
        public ViewGroup b() {
            return (ViewGroup) e.this.f61331e.get();
        }

        @Override // d.b.b0.b.d
        public void c() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad finish");
            }
            d.b.i0.k.a aVar = this.f61332a;
            if (aVar != null) {
                aVar.onAdDismiss();
            }
        }

        @Override // d.b.b0.b.d
        public void d(d.b.d0.a.g.d dVar) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61359c, "0", 0);
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue gd loaded success");
            }
            e.this.f61329c = AdLoadState.SUCCEED;
            d.b.j0.r.a.h.a.c().g(this.f61332a);
            e("advert_load", 1);
        }

        public final void e(String str, int i) {
            d.b.c.e.n.a a2 = j.a();
            a2.b("type", "prologue");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // d.b.b0.b.d
        public void onAdClick() {
            boolean z;
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad onclick");
            }
            if (this.f61332a != null) {
                if (e.this.f61330d == null || e.this.f61330d.f() == null) {
                    z = false;
                } else {
                    boolean z2 = e.this.f61330d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    r1 = z2;
                    z = e.this.f61330d.f().optInt("full_type", 0) == 1;
                }
                this.f61332a.b(r1, z, e.this.f61328b);
            }
        }

        @Override // d.b.b0.b.d
        public void onAdShow() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad show");
            }
            d.b.i0.k.a aVar = this.f61332a;
            if (aVar != null) {
                aVar.c(true, false, e.this.f61328b);
            }
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61359c, "0");
            e("advert_show", 1);
        }

        @Override // d.b.b0.b.d
        public void onSkip() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad onskip");
            }
            int i = 1;
            boolean z = e.this.f61330d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
            boolean z2 = e.this.f61330d.f().optInt("full_type", 0) == 1;
            if (z2 && z) {
                i = 4;
            } else if (z) {
                i = 3;
            } else if (z2) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d.b.b0.a.b.a {

        /* renamed from: b  reason: collision with root package name */
        public final Context f61334b;

        public b(Context context) {
            this.f61334b = context;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String A() {
            return Build.MODEL;
        }

        @Override // d.b.b0.a.b.a
        public int B() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // d.b.b0.a.b.a
        public String C() {
            return "bb3808eb";
        }

        @Override // d.b.b0.a.b.a
        public boolean D() {
            return TbadkCoreApplication.getInst().isDebugMode();
        }

        @Override // d.b.b0.a.b.a
        public int E() {
            return 5000;
        }

        @Override // d.b.b0.a.b.a
        public String a() {
            return "tieba";
        }

        @Override // d.b.b0.a.b.a
        public boolean b(String str, d.b.b0.c.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
            return true;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String c() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            return currentAccount == null ? "" : currentAccount;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String d() {
            return Settings.System.getString(this.f61334b.getContentResolver(), IAdRequestParam.ANDROID_ID);
        }

        @Override // d.b.b0.a.b.a
        public String e() {
            return "1099a";
        }

        @Override // d.b.b0.a.b.a
        public String f() {
            return "";
        }

        @Override // d.b.b0.a.b.a
        public String from() {
            return "1099a";
        }

        @Override // d.b.b0.a.b.a
        public int g() {
            return 120;
        }

        @Override // d.b.b0.a.b.a
        public int h() {
            return R.drawable.pic_splash_logo;
        }

        @Override // d.b.b0.a.b.a
        public String[] i() {
            AppPosInfo a2;
            if (d.b.j0.s2.d0.a.e() != null && (a2 = d.b.j0.s2.d0.a.e().a()) != null) {
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

        @Override // d.b.b0.a.b.a
        @NonNull
        public String j() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String k() {
            return Build.VERSION.RELEASE;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String l() {
            String b2 = n0.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + b2);
            }
            return b2;
        }

        @Override // d.b.b0.a.b.a
        public String m() {
            return (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) ? "" : TbadkCoreApplication.getInst().getAdAdSense().r;
        }

        @Override // d.b.b0.a.b.a
        public boolean n() {
            return this.f61334b.getResources().getConfiguration().orientation == 2;
        }

        @Override // d.b.b0.a.b.a
        public String o() {
            return "7352842";
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String p() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // d.b.b0.a.b.a
        public String q() {
            AppPosInfo a2 = d.b.j0.s2.d0.a.e().a();
            return a2 != null ? a2.coordinate_type : "";
        }

        @Override // d.b.b0.a.b.a
        public int r() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String s() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String t() {
            return TbConfig.getVersion();
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String u() {
            String[] split;
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = d.b.i0.l.a.f50995a;
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

        @Override // d.b.b0.a.b.a
        @NonNull
        public String v() {
            return "1481698145541";
        }

        @Override // d.b.b0.a.b.a
        public String w() {
            return d.b.q.b.d(TbadkCoreApplication.getInst()).e();
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String x() {
            int[] b2 = d.b.b0.b.b.a().b();
            return TextUtils.join("_", new String[]{String.valueOf(b2[0]), String.valueOf(b2[1]), "android", t(), String.valueOf(b2[2])});
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public Context y() {
            return this.f61334b;
        }

        @Override // d.b.b0.a.b.a
        @NonNull
        public String z() {
            return "2";
        }
    }

    public static void h() {
        SplashAdFacade.a().b(new b(TbadkCoreApplication.getInst()));
    }

    @Override // d.b.j0.r.a.h.b
    public String a() {
        return "prologue_gd";
    }

    @Override // d.b.j0.r.a.h.b
    public AdLoadState b() {
        return this.f61329c;
    }

    @Override // d.b.j0.r.a.h.b
    public void c(d.b.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        d.b.i0.k.a a2 = cVar.a();
        this.f61331e = new WeakReference<>(cVar.b());
        try {
            this.f61330d = new d.b.b0.b.f.d(cVar.b().getContext(), "1481698145541", new RequestParameters.Builder().setHeight(l.k(cVar.b().getContext())).setWidth(l.i(cVar.b().getContext())).build(), new a(a2));
            this.f61329c = AdLoadState.LOADING;
            d.b.j0.r.a.j.a.h(d.b.j0.r.a.j.a.f61359c);
            this.f61330d.g();
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "prologue ad start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.a("oom");
        }
    }

    public final void g() {
        WeakReference<ViewGroup> weakReference = this.f61331e;
        if (weakReference == null || weakReference.get().getParent() == null || !(this.f61331e.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61331e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f61331e.get().setLayoutParams(layoutParams);
    }

    @Override // d.b.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f61330d == null || (weakReference = this.f61331e) == null || weakReference.get() == null || this.f61329c != AdLoadState.SUCCEED) {
            return;
        }
        g();
        this.f61329c = AdLoadState.SHOWED;
        if (d.b.j0.r.a.h.b.f61349a) {
            Log.d("IAdSdkSplash", "prologue ad start show");
        }
        this.f61330d.k(this.f61331e.get());
    }
}
