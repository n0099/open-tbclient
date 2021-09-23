package com.bytedance.sdk.openadsdk.f;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.preload.geckox.a.a.a;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import java.io.File;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f68190a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public File f68191b;

    /* renamed from: c  reason: collision with root package name */
    public Map.Entry<String, JSONObject> f68192c;

    /* renamed from: com.bytedance.sdk.openadsdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1922a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f68195a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-521189637, "Lcom/bytedance/sdk/openadsdk/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-521189637, "Lcom/bytedance/sdk/openadsdk/f/a$a;");
                    return;
                }
            }
            f68195a = new a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97781592, "Lcom/bytedance/sdk/openadsdk/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97781592, "Lcom/bytedance/sdk/openadsdk/f/a;");
                return;
            }
        }
        f68190a = new String[]{"gecko-pangle-lf.snssdk.com", "gecko-pangle-hl.snssdk.com", "gecko-pangle-lq.snssdk.com"};
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1922a.f68195a : (a) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String[] I = o.h().I();
            StringBuilder sb = new StringBuilder();
            sb.append("GeckoLog:get gecko hosts from settings ");
            sb.append(I == null ? 0 : I.length);
            k.b("GeckoHub", sb.toString());
            if (I == null) {
                I = f68190a;
            }
            String str = I[new SecureRandom().nextInt(I.length)];
            if (TextUtils.isEmpty(str)) {
                str = f68190a[new SecureRandom().nextInt(f68190a.length)];
            }
            k.b("GeckoHub", "GeckoLog:random host " + str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.falconx.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return new com.bytedance.sdk.openadsdk.preload.falconx.a.a(o.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.f68191b);
            } catch (Throwable th) {
                k.c("GeckoHub", "getGeckoResLoader error", th);
                return null;
            }
        }
        return (com.bytedance.sdk.openadsdk.preload.falconx.a.a) invokeV.objValue;
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
                return;
            }
        }
        this.f68191b = new File(o.a().getCacheDir() + File.separator + "gecko");
        if (h.d().x()) {
            b.a();
        }
    }

    public void a(Map<String, m> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            String a2 = j.a(o.a());
            if (TextUtils.isEmpty(a2)) {
                k.b("GeckoHub", "no did so don't preload");
                return;
            }
            com.bytedance.sdk.openadsdk.preload.geckox.a a3 = com.bytedance.sdk.openadsdk.preload.geckox.a.a(new b.a(o.a()).b("4ab312f7094810afa84659d3dc6cf0fe").a("4ab312f7094810afa84659d3dc6cf0fe").a(Long.parseLong("1371")).b(a2).a("9999999.0.0").a(new a.C1935a().a(20).a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.b.f68981c).a()).a(this.f68191b).a(false).c(c()).b(e.a()).a(e.a()).a(new com.bytedance.sdk.openadsdk.preload.geckox.statistic.a(this, map) { // from class: com.bytedance.sdk.openadsdk.f.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f68193a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f68194b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68194b = this;
                    this.f68193a = map;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.geckox.statistic.a
                public void a(String str, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) && "geckosdk_update_stats".equals(str)) {
                        m mVar = (m) this.f68193a.get(jSONObject.optString("channel"));
                        if (mVar != null) {
                            d.a.a(str, jSONObject, mVar);
                        }
                    }
                }
            }).a());
            HashMap hashMap = new HashMap();
            LinkedList linkedList = new LinkedList();
            for (String str : map.keySet()) {
                linkedList.add(new CheckRequestBodyModel.TargetChannel(str));
            }
            hashMap.put("4ab312f7094810afa84659d3dc6cf0fe", linkedList);
            a3.a(hashMap);
        }
    }

    private InputStream b(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, str, str2)) == null) {
            String str3 = str + File.separator + str2;
            if (aVar.b(str3)) {
                return aVar.a(str3);
            }
            return null;
        }
        return (InputStream) invokeLLL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf("?");
            return indexOf == -1 ? str : str.substring(0, indexOf);
        }
        return (String) invokeL.objValue;
    }

    private JSONObject a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                try {
                    if (this.f68192c == null || !str.equals(this.f68192c.getKey())) {
                        k.b("GeckoHub", "refresh cache manifest");
                        com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar = new com.bytedance.sdk.openadsdk.preload.falconx.a.a(o.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.f68191b);
                        String a2 = com.bytedance.sdk.openadsdk.n.g.a.a(aVar.a(str + "/manifest.json"));
                        if (TextUtils.isEmpty(a2)) {
                            k.f("GeckoHub", "getFileInfoInManifest error null");
                            return null;
                        }
                        this.f68192c = new AbstractMap.SimpleEntry(str, new JSONObject(a2));
                    }
                    JSONObject value = this.f68192c.getValue();
                    String a3 = com.bytedance.sdk.component.utils.e.a(str2);
                    if (value.has(a3)) {
                        return value.getJSONObject(a3);
                    }
                    String a4 = a(str2);
                    if (a4 == null) {
                        return null;
                    }
                    String a5 = com.bytedance.sdk.component.utils.e.a(a4);
                    if (value.has(a5)) {
                        return value.getJSONObject(a5);
                    }
                    return null;
                } catch (Throwable th) {
                    k.c("GeckoHub", "getFileInfoInManifest error", th);
                }
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            aVar.a();
        } catch (Throwable th) {
            k.c("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    public WebResourceResponse a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        JSONObject a2;
        String optString;
        InputStream b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, str, str2)) == null) {
            if (aVar == null) {
                return null;
            }
            try {
                if (TextUtils.isEmpty(str) || (a2 = a(str, str2)) == null || (optString = a2.optString("fileName", null)) == null) {
                    return null;
                }
                JSONObject jSONObject = a2.has("respHeader") ? a2.getJSONObject("respHeader") : null;
                if (jSONObject == null || (b2 = b(aVar, str, optString)) == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return com.bytedance.sdk.openadsdk.preload.falconx.b.a.a(b2, hashMap);
            } catch (Throwable th) {
                k.c("GeckoHub", "findRes error", th);
                return null;
            }
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }
}
