package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d7c;
import com.baidu.tieba.e7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.agconnect.core.ServiceDiscovery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes10.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getValue().intValue() - entry2.getValue().intValue() : invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final <T extends e7c> T a(String str) {
        InterceptResult invokeL;
        StringBuilder sb;
        String localizedMessage;
        String sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                Class<?> cls = Class.forName(str);
                if (e7c.class.isAssignableFrom(cls)) {
                    return (T) Class.forName(str).newInstance();
                }
                Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
                return null;
            } catch (ClassNotFoundException e) {
                sb2 = "Can not found service class, " + e.getMessage();
                Log.e("ServiceRegistrarParser", sb2);
                return null;
            } catch (IllegalAccessException e2) {
                sb = new StringBuilder();
                sb.append("instantiate service class exception ");
                localizedMessage = e2.getLocalizedMessage();
                sb.append(localizedMessage);
                sb2 = sb.toString();
                Log.e("ServiceRegistrarParser", sb2);
                return null;
            } catch (InstantiationException e3) {
                sb = new StringBuilder();
                sb.append("instantiate service class exception ");
                localizedMessage = e3.getLocalizedMessage();
                sb.append(localizedMessage);
                sb2 = sb.toString();
                Log.e("ServiceRegistrarParser", sb2);
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public List<d7c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Log.i("ServiceRegistrarParser", "getServices");
            List<String> c = c();
            ArrayList arrayList = new ArrayList();
            for (String str : c) {
                e7c a2 = a(str);
                if (a2 != null) {
                    a2.a(this.a);
                    List<d7c> b2 = a2.b(this.a);
                    if (b2 != null) {
                        arrayList.addAll(b2);
                    }
                }
            }
            Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<String> c() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Bundle d = d();
            if (d == null) {
                return arrayList;
            }
            HashMap hashMap = new HashMap(10);
            for (String str : d.keySet()) {
                if ("com.huawei.agconnect.core.ServiceRegistrar".equals(d.getString(str))) {
                    String[] split = str.split(":");
                    if (split.length == 2) {
                        try {
                            hashMap.put(split[0], Integer.valueOf(split[1]));
                        } catch (NumberFormatException e) {
                            sb = new StringBuilder();
                            sb.append("registrar configuration format error:");
                            str = e.getMessage();
                        }
                    } else if (split.length == 1) {
                        hashMap.put(split[0], 1000);
                    } else {
                        sb = new StringBuilder();
                        sb.append("registrar configuration error, ");
                        sb.append(str);
                        Log.e("ServiceRegistrarParser", sb.toString());
                    }
                }
            }
            ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList2, new a(null));
            for (Map.Entry entry : arrayList2) {
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final Bundle d() {
        InterceptResult invokeV;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            try {
                serviceInfo = packageManager.getServiceInfo(new ComponentName(this.a, ServiceDiscovery.class), 128);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e.getLocalizedMessage());
            }
            if (serviceInfo == null) {
                Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
                return null;
            }
            return serviceInfo.metaData;
        }
        return (Bundle) invokeV.objValue;
    }
}
