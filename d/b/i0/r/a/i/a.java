package d.b.i0.r.a.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import d.b.b.e.p.l;
import d.b.i0.r.a.e.b;
import java.io.File;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f59685a;

    /* renamed from: d.b.i0.r.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1500a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59686a;

        static {
            int[] iArr = new int[AdSplashStyle.SplashElement.values().length];
            f59686a = iArr;
            try {
                iArr[AdSplashStyle.SplashElement.LOGO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59686a[AdSplashStyle.SplashElement.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59686a[AdSplashStyle.SplashElement.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f59686a[AdSplashStyle.SplashElement.VOICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f59686a[AdSplashStyle.SplashElement.WIFI_TIP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        if ((i & i2) == i2) {
            layoutParams.addRule(i3);
        }
    }

    public static void b() {
        File file = new File(d.b.i0.r.a.h.a.f59678b);
        if (file.exists()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public static void c(File file) {
        File[] listFiles;
        File file2 = new File(d.b.i0.r.a.h.a.f59678b);
        if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3 != null && !file3.equals(file)) {
                FileHelper.deleteFileOrDir(file3);
            }
        }
    }

    public static void d() {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
    }

    public static int e(AdSplashStyle.SplashElement splashElement, boolean z) {
        int i = C1500a.f59686a[splashElement.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return i != 5 ? 0 : 9;
                    }
                    return 10;
                }
                return 6;
            }
            return 9;
        }
        return 5;
    }

    public static String f(AdSplashStyle.SplashElement splashElement, boolean z) {
        int i = C1500a.f59686a[splashElement.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "0_58_15_0" : "0_0_9_20" : z ? "0_0_0_65" : "0_0_0_0" : "0_20_15_0" : "15_20_0_0";
    }

    public static String g() {
        return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
    }

    public static AdSplashStyle.a h(AdSplashStyle.SplashElement splashElement, AdSplashStyle adSplashStyle, boolean z) {
        int i = C1500a.f59686a[splashElement.ordinal()];
        if (i == 1) {
            return z ? adSplashStyle.i : adSplashStyle.f14645d;
        } else if (i == 2) {
            return z ? adSplashStyle.j : adSplashStyle.f14646e;
        } else if (i == 3) {
            return z ? adSplashStyle.k : adSplashStyle.f14647f;
        } else if (i == 4) {
            return z ? adSplashStyle.l : adSplashStyle.f14648g;
        } else if (i != 5) {
            return null;
        } else {
            return z ? adSplashStyle.m : adSplashStyle.f14649h;
        }
    }

    public static boolean i() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f59685a;
        if (0 >= j || j >= 500) {
            f59685a = currentTimeMillis;
            return false;
        }
        return true;
    }

    public static void j(AdInfo adInfo) {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", b.a(adInfo).toString()).apply();
    }

    public static void k(b bVar) {
        if (bVar == null) {
            d();
        } else {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", bVar.toString()).apply();
        }
    }

    public static void l(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    public static void m(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        marginLayoutParams.setMargins(l.e(applicationContext, iArr[0]), l.e(applicationContext, iArr[1]), l.e(applicationContext, iArr[2]), l.e(applicationContext, iArr[3]));
    }

    public static void n(RelativeLayout.LayoutParams layoutParams, AdSplashStyle.SplashElement splashElement, AdSplashStyle adSplashStyle, boolean z) {
        AdSplashStyle.a h2 = h(splashElement, adSplashStyle, z);
        if (h2 == null) {
            h2 = new AdSplashStyle.a(e(splashElement, z), f(splashElement, z));
        }
        int i = h2.f14650a;
        String str = h2.f14651b;
        if (i <= 0) {
            i = e(splashElement, z);
        }
        if (h2.f14652c == null || TextUtils.isEmpty(str)) {
            str = f(splashElement, z);
        }
        h2.b(i, str);
        Log.i("BESAdSdkSplash", splashElement + "-->isFullScreen=" + z + ",gravity=" + h2.f14650a + ",margins=" + h2.f14651b);
        l(layoutParams, h2.f14650a);
        m(layoutParams, h2.f14652c);
    }

    public static void o() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
    }
}
