package d.a.n0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44889d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f44890a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f44891b;

    /* renamed from: c  reason: collision with root package name */
    public final int f44892c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961088528, "Ld/a/n0/a/h0/l/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(961088528, "Ld/a/n0/a/h0/l/g/g;");
                return;
            }
        }
        f44889d = d.a.n0.a.k.f45831a;
    }

    public g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 < 1) {
            if (f44889d) {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
            i2 = 1;
        }
        this.f44892c = i2;
        this.f44891b = new Object();
        this.f44890a = new LinkedList();
    }

    public void a(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            boolean z = collection == null || collection.size() <= 0;
            if (f44889d) {
                StringBuilder sb = new StringBuilder();
                sb.append("master pool clear, excludes size - ");
                sb.append(collection != null ? collection.size() : 0);
                Log.i("MasterPool", sb.toString());
                if (collection != null) {
                    for (k kVar : collection) {
                        if (kVar.i() != null) {
                            Log.i("MasterPool", "excludes  - " + kVar.i().b());
                        }
                    }
                }
            }
            synchronized (this.f44891b) {
                ArrayList arrayList = new ArrayList();
                for (k kVar2 : this.f44890a) {
                    if (z || !collection.contains(kVar2)) {
                        arrayList.add(kVar2);
                    }
                }
                b(arrayList);
            }
        }
    }

    public final void b(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) || collection.size() <= 0) {
            return;
        }
        long currentTimeMillis = f44889d ? System.currentTimeMillis() : 0L;
        this.f44890a.removeAll(collection);
        if (f44889d) {
            Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
        }
        for (k kVar : collection) {
            if (kVar.i() != null) {
                kVar.i().destroy();
                if (f44889d) {
                    Log.i("MasterPool", "master destroy, id - " + kVar.i().b() + ", isReady - " + kVar.n() + ", is Default - " + kVar.l() + ", is Prefetch - " + kVar.j());
                }
            }
        }
        if (f44889d) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.f44891b) {
            ArrayList arrayList = new ArrayList();
            for (k kVar : this.f44890a) {
                if (TextUtils.equals(kVar.h(), str)) {
                    arrayList.add(kVar);
                }
            }
            b(arrayList);
        }
    }

    public k d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            k kVar = null;
            if (TextUtils.isEmpty(str)) {
                if (f44889d) {
                    Log.w("MasterPool", "appId can not be empty");
                }
                return null;
            }
            synchronized (this.f44891b) {
                if (TextUtils.equals(str, "_default_id_")) {
                    if (f44889d) {
                        Log.i("MasterPool", "get default master manger for id - " + str);
                    }
                    return e();
                }
                int size = this.f44890a.size() - 1;
                int i2 = size;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    k kVar2 = this.f44890a.get(i2);
                    if (TextUtils.equals(kVar2.h(), str)) {
                        if (f44889d) {
                            Log.i("MasterPool", "get master in pool for id - " + str);
                        }
                        kVar = kVar2;
                    } else {
                        i2--;
                    }
                }
                if (kVar != null && i2 != size) {
                    this.f44890a.remove(i2);
                    this.f44890a.add(kVar);
                }
                if (f44889d) {
                    if (kVar == null) {
                        Log.i("MasterPool", "find no master for id - " + str);
                    } else {
                        Log.i("MasterPool", "hit a master cache for id - " + str);
                    }
                }
                return kVar;
            }
        }
        return (k) invokeL.objValue;
    }

    public final k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (k kVar : this.f44890a) {
                if (kVar.l()) {
                    return kVar;
                }
            }
            if (f44889d) {
                throw new RuntimeException("there must be one default master in pool, you should add default one first");
            }
            return null;
        }
        return (k) invokeV.objValue;
    }

    public void f(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) || kVar == null) {
            return;
        }
        synchronized (this.f44891b) {
            if (!this.f44890a.contains(kVar)) {
                this.f44890a.add(kVar);
            }
            h();
        }
    }

    public void g(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            if (this.f44892c >= 3) {
                boolean z = true;
                if (this.f44890a.size() > 1) {
                    if (collection != null && collection.size() > 0) {
                        z = false;
                    }
                    synchronized (this.f44891b) {
                        ArrayList arrayList = new ArrayList();
                        for (k kVar : this.f44890a) {
                            if (!kVar.l() && kVar.j() && (z || !collection.contains(kVar))) {
                                arrayList.add(kVar);
                            }
                        }
                        if (f44889d) {
                            Log.d("MasterPool", "remove all prefetch event master, size - " + arrayList.size());
                        }
                        b(arrayList);
                    }
                    return;
                }
            }
            if (f44889d) {
                Log.d("MasterPool", "no need to remove prefetch master");
                Log.d("MasterPool", "max size - " + this.f44892c);
                Log.d("MasterPool", "current cache size - " + this.f44890a.size());
            }
        }
    }

    public final void h() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (size = this.f44890a.size()) <= this.f44892c) {
            return;
        }
        if (f44889d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.f44892c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f44890a.get(i2);
            if (!kVar.l() || z) {
                arrayList.add(kVar);
                if (arrayList.size() >= size - this.f44892c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
