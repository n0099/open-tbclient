package com.repackage;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.framework.net.LiveNetwork;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ea0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-420994176, "Lcom/repackage/ea0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-420994176, "Lcom/repackage/ea0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-420994145, "Lcom/repackage/ea0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-420994145, "Lcom/repackage/ea0$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL.intValue;
        }
    }

    public static final Map<String, String> a(Map<String, String> map, Map<String, String> map2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, map, map2, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("livefeed_sdk_version", "3.6.11");
            hashMap.put("npslist", k());
            if (z) {
                hashMap.put("sign", g(map, hashMap, map2));
            } else {
                hashMap.put("sign", h(map, hashMap, map2));
            }
            return hashMap;
        }
        return (Map) invokeLLZ.objValue;
    }

    public static /* synthetic */ Map b(Map map, Map map2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(map, map2, z);
    }

    public static final String c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            String fullUrl = la0.a(str);
            if (map != null) {
                String a2 = ua0.a(fullUrl, map);
                Intrinsics.checkNotNullExpressionValue(a2, "UrlUtil.addParam(fullUrl, params)");
                return a2;
            }
            Intrinsics.checkNotNullExpressionValue(fullUrl, "fullUrl");
            return fullUrl;
        }
        return (String) invokeLL.objValue;
    }

    public static final StringBuffer d(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                        stringBuffer.append("&");
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final StringBuffer e(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final <T> void f(String url, Map<String, String> post, da0<T> callback, int i, int i2, Map<String, String> map, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{url, post, callback, Integer.valueOf(i), Integer.valueOf(i2), map, list}) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(post, "post");
            Intrinsics.checkNotNullParameter(callback, "callback");
            LiveNetwork liveNetwork = new LiveNetwork();
            String c = c(url, map);
            LiveFeedPageSdk f = LiveFeedPageSdk.f();
            Intrinsics.checkNotNullExpressionValue(f, "LiveFeedPageSdk.getInstance()");
            if (f.g() != null) {
                LiveFeedPageSdk f2 = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f2, "LiveFeedPageSdk.getInstance()");
                j90 g = f2.g();
                Intrinsics.checkNotNull(g);
                Intrinsics.checkNotNullExpressionValue(g, "LiveFeedPageSdk.getInstance().invoker!!");
                String iid = g.getIID();
                if (!TextUtils.isEmpty(iid)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkNotNullExpressionValue(iid, "iid");
                    linkedHashMap.put("iid_bak", iid);
                    c = ua0.a(c, linkedHashMap);
                    Intrinsics.checkNotNullExpressionValue(c, "UrlUtil.addParam(fullUrl, iidParam)");
                }
            }
            Map b2 = b(post, l(c), false, 4, null);
            liveNetwork.e(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            liveNetwork.f(c);
            liveNetwork.d(o(MapsKt__MapsKt.plus(new HashMap(b2), post)), callback, list);
        }
    }

    public static final String g(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, a.a);
            StringBuffer stringBuffer = new StringBuffer(1024);
            e(stringBuffer, arrayList);
            stringBuffer.append("tiebaclient!!!");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = oa0.b(bytes, true);
                Intrinsics.checkNotNullExpressionValue(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final String h(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, b.a);
            StringBuffer stringBuffer = new StringBuffer(1024);
            d(stringBuffer, arrayList);
            stringBuffer.append("CtmXzYPtdE58nCCcvqM0ectyqW3N5rfY");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = oa0.b(bytes, true);
                Intrinsics.checkNotNullExpressionValue(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final int i(String pkg) {
        InterceptResult invokeL;
        ga0 ga0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pkg)) == null) {
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            SparseArray<ga0> j = j(pkg);
            if (j == null || (ga0Var = j.get(3)) == null) {
                return 0;
            }
            return ga0Var.a();
        }
        return invokeL.intValue;
    }

    public static final SparseArray<ga0> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                return m(bundleGroup);
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, String.valueOf(i(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME)));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static final Map<String, String> l(String fullUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, fullUrl)) == null) {
            Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
            return ua0.d(ua0.b(fullUrl));
        }
        return (Map) invokeL.objValue;
    }

    public static final SparseArray<ga0> m(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bundleInfoGroup)) == null) {
            SparseArray<ga0> sparseArray = new SparseArray<>();
            try {
                sparseArray.append(1, n(bundleInfoGroup.getBundleByType(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sparseArray.append(2, n(bundleInfoGroup.getBundleByType(2)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                sparseArray.append(3, n(bundleInfoGroup.getBundleByType(3)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final ga0 n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String packageName = bundleInfo.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "bundle.packageName");
            return new ga0(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
        }
        return (ga0) invokeL.objValue;
    }

    public static final Map<String, String> o(Map<String, String> map) {
        InterceptResult invokeL;
        String key;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && (key = entry.getKey()) != null) {
                        hashMap.put(key, entry.getValue());
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
