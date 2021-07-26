package d.a.q0.h2.k.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static k f57933c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.d.l<byte[]> f57934a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.e.d.l<byte[]> f57935b;

    public k() {
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
        this.f57934a = null;
        this.f57935b = null;
        c();
    }

    public static synchronized k b() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (k.class) {
                if (f57933c == null) {
                    f57933c = new k();
                }
                kVar = f57933c;
            }
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        l.b<byte[]> h2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                d.a.d.e.d.l<byte[]> lVar = this.f57934a;
                if (lVar != null && str != null) {
                    h2 = lVar.h(str);
                }
                h2 = null;
            } else {
                d.a.d.e.d.l<byte[]> lVar2 = this.f57935b;
                if (lVar2 != null && str != null) {
                    h2 = lVar2.h(str);
                }
                h2 = null;
            }
            if (h2 == null || (bArr = h2.f41627b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f57934a == null) {
                this.f57934a = d.a.p0.s.r.a.f().d("tb.pb_mark");
            }
            if (this.f57935b == null) {
                this.f57935b = d.a.p0.s.r.a.f().d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                d.a.d.e.d.l<byte[]> lVar = this.f57934a;
                if (lVar == null || str == null) {
                    return;
                }
                lVar.i(str, new byte[0], 0L);
                return;
            }
            d.a.d.e.d.l<byte[]> lVar2 = this.f57935b;
            if (lVar2 == null || str == null) {
                return;
            }
            lVar2.i(str, new byte[0], 0L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) || str == null) {
            return;
        }
        c();
        if (z) {
            this.f57934a.e(str, bArr, 604800000L);
        } else {
            this.f57935b.e(str, bArr, 86400000L);
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) || bArr == null || str == null) {
            return;
        }
        c();
        this.f57934a.e(str, bArr, 2592000000L);
    }
}
