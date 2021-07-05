package d.a.s0.w2;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.j0.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f69271a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f69272b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f69273c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f69274a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f69275b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f69276c;

        public a(TbImageView tbImageView, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i2), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69274a = tbImageView;
            this.f69275b = i2;
            this.f69276c = f2;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || (layoutParams = this.f69274a.getLayoutParams()) == null) {
                return;
            }
            layoutParams.height = this.f69275b;
            float f2 = this.f69276c;
            if (f2 <= 0.0f) {
                f2 = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f2);
            this.f69274a.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f69274a.setAlpha(0.8f);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623507702, "Ld/a/s0/w2/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-623507702, "Ld/a/s0/w2/x;");
                return;
            }
        }
        f69272b = new String[]{BaseWebViewActivity.SHOUBAI_SCHEME, "taobao", ThirdPartyUtil.TYPE_WEIXIN, "alipays"};
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || d.a.s0.a.h().y() || f69273c) {
            return;
        }
        f69273c = true;
        String[] strArr = {"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"};
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                Class.forName(strArr[i2]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean B(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, advertAppInfo, str)) == null) {
            if (advertAppInfo == null || !advertAppInfo.t4() || TextUtils.isEmpty(str) || !q(advertAppInfo.d4) || str.startsWith("tieba://deeplink?")) {
                return false;
            }
            return w(advertAppInfo);
        }
        return invokeLL.booleanValue;
    }

    public static final void a(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) {
            d.a.s0.w2.c0.e.n().g(advertAppInfo.c4, advertAppInfo.getDownloadId(), true);
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (r(TbadkCoreApplication.getInst(), str)) {
                return n(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            boolean checkWriteExternalStorage = PermissionUtil.checkWriteExternalStorage(activity);
            if (activity.getApplicationInfo().targetSdkVersion >= 23 || !Environment.getExternalStorageState().equals("unmounted")) {
                return checkWriteExternalStorage;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int d(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, str3)) == null) {
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
        return invokeLLLL.intValue;
    }

    public static int e(TbPageContext tbPageContext, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, tbPageContext, str, str2, str3)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            return d(tbPageContext.getPageActivity(), str, str2, str3);
        }
        return invokeLLLL.intValue;
    }

    public static int f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
                return 0;
            }
            return z(Uri.parse(str), context);
        }
        return invokeLL.intValue;
    }

    public static int g(Context context, String str, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, str, advertAppInfo)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("tieba://deeplink?")) {
                int z = z(Uri.parse(str), context);
                if (z != 1000) {
                    w.p().j(advertAppInfo, context);
                    return z;
                }
                return 1000;
            }
            w.p().j(advertAppInfo, context);
            return 1;
        }
        return invokeLLL.intValue;
    }

    public static boolean h(@NonNull Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, bundle)) == null) {
            String[] strArr = {str};
            l f2 = w.p().f();
            if (f2 == null) {
                return false;
            }
            if (f2.a(str)) {
                f2.b(context, strArr, true, bundle);
                return true;
            }
            return f2.c(context, strArr, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public static final boolean i(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65547, null, context, advertAppInfo, i2, downloadStaticsData)) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            String str = advertAppInfo.Y3;
            if (StringUtils.isNull(str)) {
                str = "";
            }
            return j(context, advertAppInfo, i2, str, downloadStaticsData);
        }
        return invokeLLIL.booleanValue;
    }

    public static final boolean j(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, advertAppInfo, Integer.valueOf(i2), str, downloadStaticsData})) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            d.a.r0.u.a.k().h(advertAppInfo);
            String str2 = advertAppInfo.Y3;
            d.a.s0.w2.c0.e.n().E(advertAppInfo.getDownloadId(), advertAppInfo.c4, StringUtils.isNull(str2) ? str : str2, i2, d.a.s0.w2.c0.e.o(advertAppInfo.d4).intValue(), null, true, false, true, advertAppInfo.Z3, downloadStaticsData, advertAppInfo.Y3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void k(String str, TbImageView tbImageView, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, tbImageView, Float.valueOf(f2), Integer.valueOf(i2)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.M(str, 10, false);
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) ? Uri.parse(str).getQueryParameter("wap") : str : (String) invokeL.objValue;
    }

    public static boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (TextUtils.isEmpty(str)) {
                d.a.c.e.p.l.L(inst, R.string.download_error);
                return false;
            }
            File d2 = b.d(str);
            if (b.l(d2)) {
                Intent intent = new Intent();
                if (d.a.s0.a.h().s()) {
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
        return invokeL.booleanValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("tieba://deeplink?");
        }
        return invokeL.booleanValue;
    }

    public static boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
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
        return invokeI.booleanValue;
    }

    public static boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 8192) != null;
        }
        return invokeL.booleanValue;
    }

    public static boolean r(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
        }
        return invokeLL.booleanValue;
    }

    public static int s(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, uri)) == null) {
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
        return invokeLL.intValue;
    }

    public static void t(String str, TbImageView tbImageView, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{str, tbImageView, Float.valueOf(f2), Integer.valueOf(i2)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.M(str, 10, false);
        tbImageView.setEvent(new a(tbImageView, i2, f2));
    }

    public static void u(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            w.p().n(z, str, str2, str3, list, str4);
        }
    }

    public static void v(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            w.p().d(z, str, str2, str3, str4, list, str5);
        }
    }

    public static boolean w(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return false;
            }
            return x(advertAppInfo.d4);
        }
        return invokeL.booleanValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Context context;
        Intent l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean y(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, context)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (d.a.s0.n1.o.k.a.e(f69271a)) {
                List<String> a2 = d.a.r0.s.c.i.a();
                f69271a = a2;
                if (a2 == null) {
                    f69271a = new ArrayList();
                }
                f69271a.addAll(Arrays.asList(f69272b));
            }
            for (String str2 : f69271a) {
                if (str.startsWith(str2)) {
                    return s(context, Uri.parse(str)) == 1000;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int z(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, uri, context)) == null) {
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
        return invokeLL.intValue;
    }
}
