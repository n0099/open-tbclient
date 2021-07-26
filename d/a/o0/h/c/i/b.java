package d.a.o0.h.c.i;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50333f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f50334a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f50335b;

    /* renamed from: c  reason: collision with root package name */
    public String f50336c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.h.y.b f50337d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f50338e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2096298235, "Ld/a/o0/h/c/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2096298235, "Ld/a/o0/h/c/i/b;");
                return;
            }
        }
        f50333f = k.f46335a;
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50334a = new HashMap<>();
        this.f50335b = new HashMap<>();
        this.f50338e = new Object();
        this.f50336c = str;
    }

    @Override // d.a.o0.h.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.f50338e) {
                if (d(str) && (arrayList = this.f50335b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).a(str, str2);
                        if (f50333f) {
                            Log.e("AudioDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.f50334a.remove(str);
                }
            }
        }
    }

    public final void b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (this.f50335b.containsKey(str)) {
                this.f50335b.get(str).add(aVar);
                return;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            arrayList.add(aVar);
            this.f50335b.put(str, arrayList);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f50333f) {
                Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
            }
            if (this.f50337d == null) {
                this.f50337d = d.a.o0.h.y.b.d();
            }
            c cVar = new c(this.f50337d, this.f50336c, str, this);
            this.f50334a.put(str, cVar);
            cVar.e();
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f50334a.containsKey(str) : invokeL.booleanValue;
    }

    public void e(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, aVar) == null) {
            synchronized (this.f50338e) {
                if (!d(str)) {
                    if (f50333f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    c(str);
                } else if (f50333f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                b(str, aVar);
            }
        }
    }

    @Override // d.a.o0.h.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            synchronized (this.f50338e) {
                if (d(str) && (arrayList = this.f50335b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.get(i3).fail(i2, str);
                    }
                    this.f50334a.remove(str);
                }
            }
        }
    }
}
