package d.a.s0.u.b.i;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.BuildConfig;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.p.d.i;
import d.a.r0.a.g;
import d.a.r0.f0.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes9.dex */
public final class a implements i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f65688a;

    /* renamed from: b  reason: collision with root package name */
    public static String f65689b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.u.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1699a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65690a;

        public C1699a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65690a = context;
        }

        @Override // d.a.r0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(d.a.r0.a.g.w) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f65690a, null, (String) hashMap.get(d.a.r0.a.g.w), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(356528788, "Ld/a/s0/u/b/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(356528788, "Ld/a/s0/u/b/i/a;");
                return;
            }
        }
        f65688a = k.f49133a;
        f65689b = NewUrlSchemaHelper.SCHEME;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        String str5;
        String str6;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.isEmpty(next) || (opt = jSONObject.opt(next)) == null) {
                    return null;
                }
                String obj = opt.toString();
                sb.append(next + "=" + Uri.encode(obj) + "&");
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            if (TextUtils.equals(str3, AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA)) {
                str5 = "";
            } else {
                str5 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str5 + str4;
            }
            String str7 = f65689b;
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    str7 = str7 + str;
                }
            } else {
                String substring = str2.substring(1, str2.length());
                if (TextUtils.isEmpty(str)) {
                    str6 = str7 + substring;
                } else {
                    str6 = str7 + str + "/" + substring;
                }
                str7 = str6;
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
            String str8 = str7 + "?" + ((Object) sb2);
            if (f65688a) {
                Log.i("DefaultInnerSkip", "encodeParams: " + ((Object) sb2));
            }
            return str8;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
                Uri parse = Uri.parse(str);
                if (d.a.r0.a.g.c(parse)) {
                    d.a.r0.a.g.b().j(str, parse, new C1699a(context));
                } else {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context);
                    tbWebViewActivityConfig.setUri(parse);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
                return true;
            }
            if (!TextUtils.isEmpty(str) && str.contains("com.baidu.tieba")) {
                Uri parse2 = Uri.parse(str);
                if ("miniapp".equals(parse2.getAuthority()) && "/goods".equals(parse2.getPath())) {
                    h.i(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                    return true;
                }
            }
            return UtilHelper.dealOneScheme(context, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.a.p.d.i
    public d.a.q0.a.q2.a a(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            if (context == null) {
                d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                aVar.e("Context exception");
                return aVar;
            } else if (TextUtils.isEmpty(str5)) {
                return c(str5);
            } else {
                if (TextUtils.isEmpty(str3)) {
                    str3 = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                if ("icashwebview".equals(str4) && !StringUtils.isNull(str5)) {
                    try {
                        String optString = new JSONObject(str5).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            e(optString);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                    aVar2.e("invoke failed");
                    return aVar2;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    jSONObject.put("launchMode", BuildConfig.FLAVOR);
                    String b2 = b(str, str2, str3, str4, jSONObject);
                    boolean d2 = d(context, b2);
                    if (f65688a) {
                        Log.i("DefaultInnerSkip", "result = " + d2 + "\n拼接后的uri is: " + b2);
                    }
                    if (d2) {
                        return null;
                    }
                    d.a.q0.a.q2.a aVar3 = new d.a.q0.a.q2.a();
                    aVar3.e("invoke failed");
                    return aVar3;
                } catch (JSONException e3) {
                    if (f65688a) {
                        Log.i("DefaultInnerSkip", Log.getStackTraceString(e3));
                    }
                    return c(str5);
                }
            }
        }
        return (d.a.q0.a.q2.a) invokeCommon.objValue;
    }

    public final d.a.q0.a.q2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(5L);
            aVar.h(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
            sb.append(TextUtils.isEmpty(str) ? " empty" : "");
            sb.append(" parameter:");
            sb.append(str);
            sb.append("\n");
            sb.append(" appId:");
            sb.append(d.a.q0.a.a2.d.g().getAppId());
            sb.append("\n");
            sb.append(" curPage:");
            sb.append(d.a.q0.a.g1.f.V().U());
            sb.append("\n");
            aVar.e(sb.toString());
            return aVar;
        }
        return (d.a.q0.a.q2.a) invokeL.objValue;
    }

    public final void e(String str) {
        d.a.q0.a.a2.e i2;
        d.a.q0.a.v1.c.e.a z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (i2 = d.a.q0.a.a2.e.i()) == null || (z = i2.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.K(bundle, c.class);
    }
}
