package com.ss.android.socialbase.downloader.network.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c implements g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<String> f70579e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f70580a;

    /* renamed from: b  reason: collision with root package name */
    public final long f70581b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f70582c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f70583d;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f70584f;

    /* renamed from: g  reason: collision with root package name */
    public int f70585g;

    /* renamed from: h  reason: collision with root package name */
    public long f70586h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70587i;
    public boolean j;
    public g k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746012421, "Lcom/ss/android/socialbase/downloader/network/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1746012421, "Lcom/ss/android/socialbase/downloader/network/a/c;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(6);
        f70579e = arrayList;
        arrayList.add("Content-Length");
        f70579e.add("Content-Range");
        f70579e.add("Transfer-Encoding");
        f70579e.add(Util.ACCEPT_RANGES);
        f70579e.add(Util.ETAG);
        f70579e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70584f = null;
        this.f70583d = new Object();
        this.f70580a = str;
        this.f70582c = list;
        this.f70581b = j;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f70584f == null) {
            try {
                this.j = true;
                this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.f70580a, this.f70582c);
                synchronized (this.f70583d) {
                    if (this.k != null) {
                        HashMap hashMap = new HashMap();
                        this.f70584f = hashMap;
                        a(this.k, hashMap);
                        this.f70585g = this.k.b();
                        this.f70586h = System.currentTimeMillis();
                        this.f70587i = a(this.f70585g);
                    }
                    this.j = false;
                    this.f70583d.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.f70583d) {
                    if (this.k != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f70584f = hashMap2;
                        a(this.k, hashMap2);
                        this.f70585g = this.k.b();
                        this.f70586h = System.currentTimeMillis();
                        this.f70587i = a(this.f70585g);
                    }
                    this.j = false;
                    this.f70583d.notifyAll();
                    throw th;
                }
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70585g : invokeV.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.k) == null) {
            return;
        }
        gVar.c();
    }

    public void d() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f70583d) {
                if (this.j && this.f70584f == null) {
                    this.f70583d.wait();
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70587i : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? System.currentTimeMillis() - this.f70586h < b.f70574b : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70582c : (List) invokeV.objValue;
    }

    public Map<String, String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70584f : (Map) invokeV.objValue;
    }

    private void a(g gVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, gVar, map) == null) || gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f70579e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, String> map = this.f70584f;
            if (map != null) {
                return map.get(str);
            }
            g gVar = this.k;
            if (gVar != null) {
                return gVar.a(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
