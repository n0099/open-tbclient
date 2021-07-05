package d.a.s0.c0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import d.a.c.a.j;
import d.a.s0.c0.a;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1342a f57890a;

        public a(a.C1342a c1342a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1342a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57890a = c1342a;
        }

        @Override // d.a.s0.c0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f57890a.a(2, i2);
            }
        }
    }

    /* renamed from: d.a.s0.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1343b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C1342a f57891a;

        public C1343b(a.C1342a c1342a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1342a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57891a = c1342a;
        }

        @Override // d.a.s0.c0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f57891a.a(2, i2);
            }
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, uri, bundle, Boolean.valueOf(z)})) == null) ? b(context, uri, null, bundle, z) : invokeCommon.booleanValue;
    }

    public static boolean b(Context context, Uri uri, d.a.s0.c0.a aVar, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, uri, aVar, bundle, Boolean.valueOf(z)})) == null) {
            a.C1342a c1342a = new a.C1342a();
            if (uri == null) {
                if (aVar != null) {
                    aVar.b(1, "Uri is empty.", c1342a);
                }
                return false;
            } else if (!"deeplink".equals(uri.getHost())) {
                if (aVar != null) {
                    aVar.b(2, "Uri host is not deeplink.", c1342a);
                }
                return false;
            } else {
                String queryParameter = uri.getQueryParameter("appUrl");
                String queryParameter2 = uri.getQueryParameter("marketUrl");
                String queryParameter3 = uri.getQueryParameter(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
                String queryParameter4 = uri.getQueryParameter(PushClientConstants.TAG_PKG_NAME);
                String queryParameter5 = uri.getQueryParameter("marketPkgName");
                boolean booleanQueryParameter = uri.getBooleanQueryParameter("isDesignatePkg", true);
                if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c1342a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c1342a)) {
                    return true;
                }
                return g(context, queryParameter3, bundle, aVar, c1342a, z);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(Context context, String str, String str2, boolean z, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), cVar})) == null) {
            try {
                Intent b2 = d.b(context, str, str2, z, cVar);
                if (b2 == null) {
                    return false;
                }
                context.startActivity(b2);
                return true;
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.onFailed(-101);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean d(Context context, String str, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, bundle, Boolean.valueOf(z)})) == null) {
            String[] strArr = {str};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (tbPageContext = (TbPageContext) j.a(context)) == null) {
                return false;
            }
            if (urlManager.UrlValidated(str)) {
                urlManager.dealOneLink(tbPageContext, strArr, true);
                return true;
            }
            return urlManager.dealOneLink(tbPageContext, strArr);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e(Context context, String str, String str2, d.a.s0.c0.a aVar, boolean z, a.C1342a c1342a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c1342a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1342a.a(1, -4);
                return false;
            } else if (c(context, str, str2, z, new a(c1342a))) {
                c1342a.b(1);
                if (aVar != null) {
                    aVar.a(1, c1342a);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(Context context, String str, String str2, d.a.s0.c0.a aVar, boolean z, a.C1342a c1342a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c1342a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1342a.a(2, -5);
                return false;
            } else if (c(context, str, str2, z, new C1343b(c1342a))) {
                c1342a.b(2);
                if (aVar != null) {
                    aVar.a(2, c1342a);
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(Context context, String str, Bundle bundle, d.a.s0.c0.a aVar, a.C1342a c1342a, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, bundle, aVar, c1342a, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1342a.a(3, -6);
                if (aVar != null) {
                    aVar.b(-6, "Uri web url is empty", c1342a);
                }
                return false;
            } else if (d(context, str, bundle, z)) {
                c1342a.b(3);
                if (aVar != null) {
                    aVar.a(3, c1342a);
                    return true;
                }
                return true;
            } else {
                c1342a.a(3, -7);
                if (aVar != null) {
                    aVar.b(-7, "Uri web url open failed", c1342a);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
