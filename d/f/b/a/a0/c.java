package d.f.b.a.a0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.t.q;
import d.f.b.a.a0.t.v;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public final class c implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Constructor<? extends e> f72104g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72105a;

    /* renamed from: b  reason: collision with root package name */
    public int f72106b;

    /* renamed from: c  reason: collision with root package name */
    public int f72107c;

    /* renamed from: d  reason: collision with root package name */
    public int f72108d;

    /* renamed from: e  reason: collision with root package name */
    public int f72109e;

    /* renamed from: f  reason: collision with root package name */
    public int f72110f;

    static {
        Constructor<? extends e> constructor;
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(77998621, "Ld/f/b/a/a0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(77998621, "Ld/f/b/a/a0/c;");
                return;
            }
        }
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f72104g = constructor;
    }

    public c() {
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
        this.f72109e = 1;
    }

    @Override // d.f.b.a.a0.h
    public synchronized e[] a() {
        InterceptResult invokeV;
        e[] eVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                eVarArr = new e[f72104g == null ? 11 : 12];
                eVarArr[0] = new d.f.b.a.a0.o.d(this.f72105a);
                eVarArr[1] = new d.f.b.a.a0.q.e(this.f72107c);
                eVarArr[2] = new d.f.b.a.a0.q.g(this.f72106b);
                eVarArr[3] = new d.f.b.a.a0.p.b(this.f72108d);
                eVarArr[4] = new d.f.b.a.a0.t.c();
                eVarArr[5] = new d.f.b.a.a0.t.a();
                eVarArr[6] = new v(this.f72109e, this.f72110f);
                eVarArr[7] = new d.f.b.a.a0.n.b();
                eVarArr[8] = new d.f.b.a.a0.r.c();
                eVarArr[9] = new q();
                eVarArr[10] = new d.f.b.a.a0.u.a();
                if (f72104g != null) {
                    try {
                        eVarArr[11] = f72104g.newInstance(new Object[0]);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
            }
            return eVarArr;
        }
        return (e[]) invokeV.objValue;
    }
}
