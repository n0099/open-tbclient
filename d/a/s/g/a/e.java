package d.a.s.g.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.common.cc.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public final class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public b f67870d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f67871a;

        /* renamed from: b  reason: collision with root package name */
        public Method f67872b;

        /* renamed from: c  reason: collision with root package name */
        public Method f67873c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            d();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final long b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    return ((Long) this.f67873c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
            return invokeL.longValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f67871a = Class.forName(n.a(h.a()), true, Object.class.getClassLoader());
                    this.f67872b = n.b(this.f67871a, n.a(h.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.f67873c = n.b(this.f67871a, n.a(h.c()), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, obj, bArr, i2, i3) == null) {
                try {
                    this.f67872b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
        }

        public final Object g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67871a.newInstance() : invokeV.objValue;
        }
    }

    public e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67867a = 32;
        this.f67868b = i2;
        this.f67869c = i3;
        this.f67870d = new b(null);
    }

    @Override // d.a.s.g.a.d
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i2, int i3) {
        long j;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            try {
                Object g2 = this.f67870d.g();
                this.f67870d.f(g2, bArr, i2, i3);
                j = this.f67870d.b(g2);
            } catch (Exception unused) {
                j = 4294967295L;
            }
            return com.baidu.helios.common.cc.a.a(new long[]{j});
        }
        return (com.baidu.helios.common.cc.a) invokeLII.objValue;
    }
}
