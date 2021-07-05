package d.a.k.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cesium.a.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public final class f extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public b f45845d;

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
        public Class<?> f45846a;

        /* renamed from: b  reason: collision with root package name */
        public Method f45847b;

        /* renamed from: c  reason: collision with root package name */
        public Method f45848c;

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
                    return ((Long) this.f45848c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new i.a("");
                }
            }
            return invokeL.longValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f45846a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                    this.f45847b = i.b(this.f45846a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.f45848c = i.b(this.f45846a, i.a(c.c()), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, obj, bArr, i2, i3) == null) {
                try {
                    this.f45847b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
                } catch (Exception unused) {
                    throw new i.a("");
                }
            }
        }

        public final Object g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45846a.newInstance() : invokeV.objValue;
        }
    }

    public f(int i2, int i3) {
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
        this.f45842a = 32;
        this.f45843b = i2;
        this.f45844c = i3;
        this.f45845d = new b(null);
    }

    @Override // d.a.k.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i2, int i3) {
        long j;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            try {
                Object g2 = this.f45845d.g();
                this.f45845d.f(g2, bArr, i2, i3);
                j = this.f45845d.b(g2);
            } catch (Exception unused) {
                j = 4294967295L;
            }
            return com.baidu.cesium.a.b.a(new long[]{j});
        }
        return (com.baidu.cesium.a.b) invokeLII.objValue;
    }
}
