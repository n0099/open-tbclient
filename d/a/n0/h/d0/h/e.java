package d.a.n0.h.d0.h;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.q;
import d.a.n0.h.d0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49925e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.n0.h.d0.h.a> f49926a;

    /* renamed from: b  reason: collision with root package name */
    public String f49927b;

    /* renamed from: c  reason: collision with root package name */
    public String f49928c;

    /* renamed from: d  reason: collision with root package name */
    public int f49929d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f49930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f49931f;

        public a(e eVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49931f = eVar;
            this.f49930e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e2 = this.f49931f.e();
                d dVar = new d();
                dVar.f49922a = this.f49931f.f49927b;
                dVar.f49923b = e2;
                dVar.f49924c = this.f49931f.f49928c;
                d.a.n0.h.t.a.h().b(dVar, this.f49930e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1295872177, "Ld/a/n0/h/d0/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1295872177, "Ld/a/n0/h/d0/h/e;");
                return;
            }
        }
        f49925e = k.f45831a;
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f49925e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.n0.h.d0.h.a> d2 = d(arrayList);
        this.f49926a = d2;
        this.f49927b = str;
        this.f49928c = str2;
        this.f49929d = d2.size();
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new a(this, cVar), "clipVideo");
    }

    public final ArrayList<d.a.n0.h.d0.h.a> d(ArrayList<b> arrayList) {
        InterceptResult invokeL;
        d.a.n0.h.d0.h.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<d.a.n0.h.d0.h.a> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ArrayList<long[]> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<long[]> arrayList = new ArrayList<>();
            if (this.f49929d == 0) {
                return arrayList;
            }
            if (f49925e) {
                Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f49926a);
            }
            Collections.sort(this.f49926a, new a.C1088a());
            d.a.n0.h.d0.h.a aVar = this.f49926a.get(0);
            for (int i2 = 1; i2 < this.f49929d; i2++) {
                d.a.n0.h.d0.h.a aVar2 = this.f49926a.get(i2);
                if (!aVar.b(aVar2)) {
                    arrayList.add(d.a.n0.h.d0.h.a.a(aVar));
                    aVar = aVar2;
                }
            }
            arrayList.add(d.a.n0.h.d0.h.a.a(aVar));
            if (f49925e) {
                Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
