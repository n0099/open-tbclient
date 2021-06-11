package d.a.n0.t2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.n0.e3.j0.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f64889a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f64890b = {BaseWebViewActivity.SHOUBAI_SCHEME, "taobao", ThirdPartyUtil.TYPE_WEIXIN, "alipays"};

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f64891c = false;

    /* loaded from: classes5.dex */
    public static class a implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f64892a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f64894c;

        public a(TbImageView tbImageView, int i2, float f2) {
            this.f64892a = tbImageView;
            this.f64893b = i2;
            this.f64894c = f2;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f64892a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.f64893b;
                float f2 = this.f64894c;
                if (f2 <= 0.0f) {
                    f2 = 2.0f;
                }
                layoutParams.width = (int) (layoutParams.height * f2);
                this.f64892a.setLayoutParams(layoutParams);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.f64892a.setAlpha(0.8f);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    public static void A() {
        if (d.a.n0.a.h().x() || f64891c) {
            return;
        }
        f64891c = true;
        String[] strArr = {"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"};
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                Class.forName(strArr[i2]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean B(AdvertAppInfo advertAppInfo, String str) {
        if (advertAppInfo == null || !advertAppInfo.F4() || TextUtils.isEmpty(str) || !q(advertAppInfo.b4) || str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return w(advertAppInfo);
    }

    public static final void a(AdvertAppInfo advertAppInfo) {
        d.a.n0.t2.c0.e.n().g(advertAppInfo.a4, advertAppInfo.getDownloadId(), true);
    }

    public static boolean b(String str) {
        if (r(TbadkCoreApplication.getInst(), str)) {
            return n(str);
        }
        return false;
    }

    public static boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean checkWriteExternalStorage = PermissionUtil.checkWriteExternalStorage(activity);
        if (activity.getApplicationInfo().targetSdkVersion >= 23 || !Environment.getExternalStorageState().equals("unmounted")) {
            return checkWriteExternalStorage;
        }
        return false;
    }

    public static int d(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str2);
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, str3);
        if (str.startsWith("tieba://deeplink?")) {
            Uri parse = Uri.parse(str);
            int z = z(parse, context);
            if (z != 1000) {
                if (h(context, parse.getQueryParameter("wap"), bundle)) {
                    return z;
                }
                return 0;
            }
            return 1000;
        }
        return h(context, str, bundle) ? 1 : 0;
    }

    public static int e(TbPageContext tbPageContext, String str, String str2, String str3) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return d(tbPageContext.getPageActivity(), str, str2, str3);
    }

    public static int f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
            return 0;
        }
        return z(Uri.parse(str), context);
    }

    public static int g(Context context, String str, AdvertAppInfo advertAppInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            int z = z(Uri.parse(str), context);
            if (z != 1000) {
                x.p().k(advertAppInfo, context);
                return z;
            }
            return 1000;
        }
        x.p().k(advertAppInfo, context);
        return 1;
    }

    public static boolean h(@NonNull Context context, String str, Bundle bundle) {
        String[] strArr = {str};
        m g2 = x.p().g();
        if (g2 == null) {
            return false;
        }
        if (g2.a(str)) {
            g2.b(context, strArr, true, bundle);
            return true;
        }
        return g2.c(context, strArr, bundle);
    }

    public static final boolean i(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.W3;
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return j(context, advertAppInfo, i2, str, downloadStaticsData);
    }

    public static final boolean j(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        d.a.m0.u.a.k().h(advertAppInfo);
        String str2 = advertAppInfo.W3;
        d.a.n0.t2.c0.e.n().E(advertAppInfo.getDownloadId(), advertAppInfo.a4, StringUtils.isNull(str2) ? str : str2, i2, d.a.n0.t2.c0.e.o(advertAppInfo.b4).intValue(), null, true, false, true, advertAppInfo.X3, downloadStaticsData, advertAppInfo.W3);
        return true;
    }

    public static void k(String str, TbImageView tbImageView, float f2, int i2) {
        if (tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.U(str, 10, false);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            if (f2 <= 0.0f) {
                f2 = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f2);
            tbImageView.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                tbImageView.setAlpha(0.8f);
            }
        }
        tbImageView.setVisibility(0);
    }

    public static Intent l(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String m(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) ? Uri.parse(str).getQueryParameter("wap") : str;
    }

    public static boolean n(@NonNull String str) {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        if (TextUtils.isEmpty(str)) {
            d.a.c.e.p.l.L(inst, R.string.download_error);
            return false;
        }
        File d2 = b.d(str);
        if (b.l(d2)) {
            Intent intent = new Intent();
            if (d.a.n0.a.h().s()) {
                intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(d2, intent, inst), "application/vnd.android.package-archive");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            inst.startActivity(intent);
            return true;
        }
        return false;
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("tieba://deeplink?");
    }

    public static boolean p(int i2) {
        switch (i2) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
                return true;
            default:
                return false;
        }
    }

    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean r(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public static int s(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                return 1004;
            }
            context.startActivity(intent);
            return 1000;
        } catch (Exception unused) {
            return 1006;
        }
    }

    public static void t(String str, TbImageView tbImageView, float f2, int i2) {
        if (tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.U(str, 10, false);
        tbImageView.setEvent(new a(tbImageView, i2, f2));
    }

    public static void u(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        x.p().n(z, str, str2, str3, list, str4);
    }

    public static void v(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        x.p().d(z, str, str2, str3, str4, list, str5);
    }

    public static boolean w(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            return false;
        }
        return x(advertAppInfo.b4);
    }

    public static boolean x(String str) {
        Context context;
        Intent l;
        if (TextUtils.isEmpty(str) || (l = l((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return false;
        }
        try {
            context.startActivity(l);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean y(String str, @NonNull Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.a.n0.k1.o.k.a.e(f64889a)) {
            List<String> a2 = d.a.m0.s.c.i.a();
            f64889a = a2;
            if (a2 == null) {
                f64889a = new ArrayList();
            }
            f64889a.addAll(Arrays.asList(f64890b));
        }
        for (String str2 : f64889a) {
            if (str.startsWith(str2)) {
                return s(context, Uri.parse(str)) == 1000;
            }
        }
        return false;
    }

    public static int z(Uri uri, Context context) {
        try {
            String queryParameter = uri.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            if (TextUtils.isEmpty(queryParameter)) {
                return 1003;
            }
            return s(context, Uri.parse(queryParameter));
        } catch (Exception unused) {
            return 1003;
        }
    }
}
