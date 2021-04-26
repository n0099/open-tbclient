package d.a.j0.s2;

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
import d.a.j0.d3.j0.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f60360a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f60361b = {BaseWebViewActivity.SHOUBAI_SCHEME, "taobao", ThirdPartyUtil.TYPE_WEIXIN, "alipays"};

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f60362c = false;

    /* loaded from: classes3.dex */
    public static class a implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f60363a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f60365c;

        public a(TbImageView tbImageView, int i2, float f2) {
            this.f60363a = tbImageView;
            this.f60364b = i2;
            this.f60365c = f2;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f60363a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.f60364b;
                float f2 = this.f60365c;
                if (f2 <= 0.0f) {
                    f2 = 2.0f;
                }
                layoutParams.width = (int) (layoutParams.height * f2);
                this.f60363a.setLayoutParams(layoutParams);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.f60363a.setAlpha(0.8f);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    public static void A() {
        if (d.a.j0.a.e().t() || f60362c) {
            return;
        }
        f60362c = true;
        String[] strArr = {"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"};
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                Class.forName(strArr[i2]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean B(AdvertAppInfo advertAppInfo, String str) {
        if (advertAppInfo == null || !advertAppInfo.B4() || TextUtils.isEmpty(str) || !q(advertAppInfo.J3) || str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return w(advertAppInfo);
    }

    public static final void a(AdvertAppInfo advertAppInfo) {
        d.a.j0.s2.b0.e.n().g(advertAppInfo.I3, advertAppInfo.J3, true);
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
                w.p().k(advertAppInfo, context);
                return z;
            }
            return 1000;
        }
        w.p().k(advertAppInfo, context);
        return 1;
    }

    public static boolean h(@NonNull Context context, String str, Bundle bundle) {
        String[] strArr = {str};
        l g2 = w.p().g();
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
        AdvertAppInfo.a aVar;
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.F3;
        if (StringUtils.isNull(str) && (aVar = advertAppInfo.U3) != null) {
            str = aVar.f12788b;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return j(context, advertAppInfo, i2, str, downloadStaticsData);
    }

    public static final boolean j(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        d.a.i0.u.a.l().i(advertAppInfo);
        String str2 = advertAppInfo.F3;
        String str3 = StringUtils.isNull(str2) ? str : str2;
        d.a.j0.s2.b0.e n = d.a.j0.s2.b0.e.n();
        String str4 = advertAppInfo.J3;
        String str5 = advertAppInfo.I3;
        int intValue = d.a.j0.s2.b0.e.o(str4).intValue();
        AdvertAppInfo.a aVar = advertAppInfo.U3;
        n.E(str4, str5, str3, i2, intValue, null, true, false, true, aVar.f12789c, downloadStaticsData, aVar.f12788b);
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
        tbImageView.V(str, 10, false);
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
            if (d.a.j0.a.e().p()) {
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
        tbImageView.V(str, 10, false);
        tbImageView.setEvent(new a(tbImageView, i2, f2));
    }

    public static void u(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        w.p().n(z, str, str2, str3, list, str4);
    }

    public static void v(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        w.p().d(z, str, str2, str3, str4, list, str5);
    }

    public static boolean w(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            return false;
        }
        return x(advertAppInfo.J3);
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
        if (d.a.j0.j1.o.k.a.e(f60360a)) {
            List<String> a2 = d.a.i0.s.c.i.a();
            f60360a = a2;
            if (a2 == null) {
                f60360a = new ArrayList();
            }
            f60360a.addAll(Arrays.asList(f60361b));
        }
        for (String str2 : f60360a) {
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
