package d.a.s0.s0.d.a.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f65314a;

    public a() {
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
        b();
    }

    public byte[] a(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            l<byte[]> lVar = this.f65314a;
            l.b<byte[]> h2 = (lVar == null || str == null) ? null : lVar.h(str);
            if (h2 == null || (bArr = h2.f44107b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f65314a == null) {
            this.f65314a = d.a.r0.r.r.a.f().d("tb.tbtiel_level_info");
        }
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) || StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f65314a.e(str, bArr, TbConfig.MILLS_7DAYS);
    }
}
