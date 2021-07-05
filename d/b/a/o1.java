package d.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o1 extends h1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f71717f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f71718d;

    /* renamed from: e  reason: collision with root package name */
    public long f71719e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413437639, "Ld/b/a/o1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413437639, "Ld/b/a/o1;");
                return;
            }
        }
        f71717f = new long[]{60000};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.a.h1
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long Z = this.f71678a.i().Z();
            if (Z > 60000 || Z <= 0) {
                Z = 60000;
            }
            f71717f[0] = Z;
            return this.f71718d + Z;
        }
        return invokeV.longValue;
    }

    @Override // d.b.a.h1
    public long[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f71717f : (long[]) invokeV.objValue;
    }

    @Override // d.b.a.h1
    public boolean d() {
        InterceptResult invokeV;
        u c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (System.currentTimeMillis() > this.f71719e + this.f71678a.i().Z()) {
                JSONObject j = this.f71678a.j().j();
                p1 m = this.f71678a.m();
                if (m != null && j != null && (c2 = m.c()) != null) {
                    this.f71678a.h().n(j, c2, m.h());
                    this.f71719e = System.currentTimeMillis();
                }
            }
            ArrayList<v> e2 = this.f71678a.h().e();
            ArrayList<v> arrayList = new ArrayList<>(e2.size());
            ArrayList<v> arrayList2 = new ArrayList<>(e2.size());
            j1 j1Var = this.f71678a;
            String[] b2 = o.b(j1Var, j1Var.f(), this.f71678a.j().c());
            Iterator<v> it = e2.iterator();
            while (it.hasNext()) {
                v next = it.next();
                int a2 = n.a(b2, next.m, this.f71678a.i());
                if (a2 == 200) {
                    arrayList.add(next);
                } else {
                    next.o = a2;
                    arrayList2.add(next);
                }
            }
            if (arrayList.size() > 0 || arrayList2.size() > 0) {
                this.f71678a.h().k(arrayList, arrayList2);
            }
            h0.e(e() + arrayList.size() + " " + e2.size(), null);
            if (arrayList.size() == e2.size()) {
                this.f71718d = System.currentTimeMillis();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "s" : (String) invokeV.objValue;
    }
}
