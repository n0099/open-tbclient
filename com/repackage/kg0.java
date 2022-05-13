package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class kg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes6.dex */
    public class a implements ei0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;
        public final /* synthetic */ kg0 j;

        public a(kg0 kg0Var, c cVar, Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg0Var, cVar, context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = kg0Var;
            this.a = cVar;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = z;
            this.i = str6;
        }

        @Override // com.repackage.ei0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.j.c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.j.a)) {
                            clogBuilder.p(this.j.a);
                        }
                        clogBuilder.t("DEEPLINK");
                        clogBuilder.w(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.h("APP");
                        clogBuilder.n(this.j.c);
                        if (this.j.d == 1) {
                            clogBuilder.i("deferred");
                        }
                        ez0.c(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                    }
                    og0.e(this.j.c);
                    return;
                }
                this.j.j(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ei0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kg0 d;

        public b(kg0 kg0Var, c cVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg0Var, cVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kg0Var;
            this.a = cVar;
            this.b = context;
            this.c = str;
        }

        @Override // com.repackage.ei0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.d.c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.d.a)) {
                            clogBuilder.p(this.d.a);
                        }
                        clogBuilder.t("DEEPLINK");
                        clogBuilder.w(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.h("MARKET");
                        clogBuilder.n(this.d.c);
                        ez0.c(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                        return;
                    }
                    return;
                }
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.onResult(this.d.h(this.b, this.c));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onResult(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755559971, "Lcom/repackage/kg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755559971, "Lcom/repackage/kg0;");
                return;
            }
        }
        e = ki0.a().k() + "://vendor/ad/easybrowse?ad_id=_AD_ID_&ext_info=_AD_EXT_&url=_URL_TEMPLATE_";
    }

    public kg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0;
    }

    public boolean f(Context context, String str, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, hashMap, cVar)) == null) {
            this.a = str;
            return k(context, hashMap, cVar);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean g(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap, cVar)) == null) ? f(context, null, hashMap, cVar) : invokeLLL.booleanValue;
    }

    public final boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!TextUtils.isEmpty(this.c)) {
                ClogBuilder clogBuilder = new ClogBuilder();
                if (!TextUtils.isEmpty(this.a)) {
                    clogBuilder.p(this.a);
                }
                clogBuilder.t("DEEPLINK");
                clogBuilder.w(ClogBuilder.LogType.DEEP_LINK);
                clogBuilder.h("URL");
                clogBuilder.n(this.c);
                if (this.d == 1) {
                    clogBuilder.i("deferred");
                }
                ez0.c(clogBuilder);
            }
            if (!str.startsWith(ki0.a().k()) && !str.startsWith("nadcorevendor://")) {
                if (str.startsWith("http") || str.startsWith("https")) {
                    String replace = e.replace("_URL_TEMPLATE_", str);
                    if (!TextUtils.isEmpty(this.b)) {
                        replace = replace.replace("_AD_ID_", this.b);
                    }
                    if (!TextUtils.isEmpty(this.c)) {
                        replace = replace.replace("_AD_EXT_", this.c);
                    }
                    th0.c(replace, context);
                    return true;
                }
                return false;
            }
            th0.c(str, context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void i(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, str3, str4, str5, str6, Boolean.valueOf(z), str7, cVar}) != null) {
            return;
        }
        try {
            try {
                gi0.a(context, str, str6, new a(this, cVar, context, str2, str3, str4, str5, str6, z, str7), z);
            } catch (Exception unused) {
                j(context, str2, str3, str4, str5, str6, z, str7, cVar);
            }
        } catch (Exception unused2) {
        }
    }

    public final void j(Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6, cVar}) == null) {
            if (TextUtils.isEmpty(str2)) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                    return;
                }
                return;
            }
            try {
                gi0.a(context, str2, str3, new b(this, cVar, context, str), z);
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                }
            }
        }
    }

    public final boolean k(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, hashMap, cVar)) == null) {
            if (hashMap == null) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
            try {
                String str = hashMap.get("app_url");
                String str2 = hashMap.get("web_url");
                String str3 = hashMap.get("min_version");
                String str4 = hashMap.get(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                String str5 = hashMap.get("market_url");
                String str6 = hashMap.get("market_pkg_name");
                String str7 = hashMap.get("exemption");
                int parseInt = !TextUtils.isEmpty(str7) ? Integer.parseInt(str7) : 0;
                String str8 = hashMap.get("source");
                this.b = hashMap.get(LegoListActivityConfig.AD_ID);
                this.c = hashMap.get("ext_info");
                String str9 = hashMap.get("exemption");
                if (!TextUtils.isEmpty(str9)) {
                    this.d = Integer.parseInt(str9);
                }
                hashMap.get("ad_name");
                if (!TextUtils.isEmpty(str)) {
                    i(context, str, str2, str5, str6, str3, str4, parseInt != 1, str8, cVar);
                } else if (!TextUtils.isEmpty(str5)) {
                    j(context, str2, str5, str6, str3, str4, parseInt != 1, str8, cVar);
                } else if (TextUtils.isEmpty(str2)) {
                    if (cVar != null) {
                        cVar.onResult(false);
                    }
                    return false;
                } else if (cVar != null) {
                    cVar.onResult(h(context, str2));
                }
                return true;
            } catch (NumberFormatException unused) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
