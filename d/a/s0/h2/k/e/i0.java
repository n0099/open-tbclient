package d.a.s0.h2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.d1;
/* loaded from: classes9.dex */
public class i0 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId F0;
    public transient /* synthetic */ FieldHolder $fh;
    public d1 C0;
    public d1 D0;
    public d1 E0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1863596078, "Ld/a/s0/h2/k/e/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1863596078, "Ld/a/s0/h2/k/e/i0;");
                return;
            }
        }
        F0 = BdUniqueId.gen();
    }

    public i0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d1 d1Var = this.C0;
            if (d1Var == null || StringUtils.isNull(d1Var.f55904b)) {
                d1 d1Var2 = this.D0;
                if (d1Var2 == null || StringUtils.isNull(d1Var2.f55904b)) {
                    d1 d1Var3 = this.E0;
                    return (d1Var3 == null || StringUtils.isNull(d1Var3.f55904b)) ? false : true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? F0 : (BdUniqueId) invokeV.objValue;
    }
}
