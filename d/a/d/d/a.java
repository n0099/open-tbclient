package d.a.d.d;

import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: d.a.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0554a implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static a f41499c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41500a;

        /* renamed from: b  reason: collision with root package name */
        public final d f41501b;

        public C0554a() {
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
            this.f41500a = 0;
            this.f41501b = new d();
            if (NSGif.f2182f) {
                this.f41500a = 0;
            } else {
                this.f41500a = 1;
            }
        }

        public static synchronized a b() {
            InterceptResult invokeV;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (C0554a.class) {
                    if (f41499c == null) {
                        f41499c = new C0554a();
                    }
                    aVar = f41499c;
                }
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // d.a.d.d.a
        public d.a.d.k.d.a a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.f41500a == 0) {
                    try {
                        return this.f41501b.a(bArr, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (d.a.d.k.d.a) invokeLII.objValue;
        }

        @Override // d.a.d.d.a
        public d.a.d.k.d.a get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f41500a == 0) {
                    try {
                        return this.f41501b.get(str);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (d.a.d.k.d.a) invokeL.objValue;
        }
    }

    d.a.d.k.d.a a(byte[] bArr, int i2, int i3);

    d.a.d.k.d.a get(String str);
}
