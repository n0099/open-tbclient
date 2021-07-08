package d.a.c.d;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: d.a.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0545a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f40995c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40996a;

        /* renamed from: b  reason: collision with root package name */
        public final d f40997b;

        public C0545a() {
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
            this.f40996a = 0;
            this.f40997b = new d();
            if (NSGif.f2156f) {
                this.f40996a = 0;
            } else {
                this.f40996a = 1;
            }
        }

        public static synchronized a b() {
            InterceptResult invokeV;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (C0545a.class) {
                    if (f40995c == null) {
                        f40995c = new C0545a();
                    }
                    aVar = f40995c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // d.a.c.d.a
        public d.a.c.k.d.a a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.f40996a == 0) {
                    try {
                        return this.f40997b.a(bArr, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (d.a.c.k.d.a) invokeLII.objValue;
        }

        @Override // d.a.c.d.a
        public d.a.c.k.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f40996a == 0) {
                    try {
                        return this.f40997b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (d.a.c.k.d.a) invokeL.objValue;
        }
    }

    d.a.c.k.d.a a(byte[] bArr, int i2, int i3);

    d.a.c.k.d.a get(String str);
}
