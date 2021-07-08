package d.l.a.e.b.o.b;

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
import d.l.a.e.b.g.e;
import d.l.a.e.b.o.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final ArrayList<String> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f72029a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f72030b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f72031c;

    /* renamed from: d  reason: collision with root package name */
    public int f72032d;

    /* renamed from: e  reason: collision with root package name */
    public long f72033e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f72034f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72035g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72036h;

    /* renamed from: i  reason: collision with root package name */
    public i f72037i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1228118044, "Ld/l/a/e/b/o/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1228118044, "Ld/l/a/e/b/o/b/c;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(6);
        j = arrayList;
        arrayList.add("Content-Length");
        j.add("Content-Range");
        j.add("Transfer-Encoding");
        j.add(Util.ACCEPT_RANGES);
        j.add(Util.ETAG);
        j.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72031c = null;
        this.f72034f = new Object();
        this.f72029a = str;
        this.f72030b = list;
    }

    @Override // d.l.a.e.b.o.i
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, String> map = this.f72031c;
            if (map != null) {
                return map.get(str);
            }
            i iVar = this.f72037i;
            if (iVar != null) {
                return iVar.a(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.l.a.e.b.o.i
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72032d : invokeV.intValue;
    }

    @Override // d.l.a.e.b.o.i
    public void c() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f72037i) == null) {
            return;
        }
        iVar.c();
    }

    public void d() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.f72034f) {
                if (this.f72036h && this.f72031c == null) {
                    this.f72034f.wait();
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f72031c == null) {
            try {
                this.f72036h = true;
                this.f72037i = e.x(this.f72029a, this.f72030b);
                synchronized (this.f72034f) {
                    if (this.f72037i != null) {
                        HashMap hashMap = new HashMap();
                        this.f72031c = hashMap;
                        f(this.f72037i, hashMap);
                        this.f72032d = this.f72037i.b();
                        this.f72033e = System.currentTimeMillis();
                        this.f72035g = g(this.f72032d);
                    }
                    this.f72036h = false;
                    this.f72034f.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.f72034f) {
                    if (this.f72037i != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f72031c = hashMap2;
                        f(this.f72037i, hashMap2);
                        this.f72032d = this.f72037i.b();
                        this.f72033e = System.currentTimeMillis();
                        this.f72035g = g(this.f72032d);
                    }
                    this.f72036h = false;
                    this.f72034f.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final void f(i iVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, iVar, map) == null) || iVar == null || map == null) {
            return;
        }
        Iterator<String> it = j.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, iVar.a(next));
        }
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72035g : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? System.currentTimeMillis() - this.f72033e < b.f72026d : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f72036h : invokeV.booleanValue;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f72030b : (List) invokeV.objValue;
    }

    public Map<String, String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f72031c : (Map) invokeV.objValue;
    }
}
