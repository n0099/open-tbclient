package d.a.s0.u0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e0 extends SparseArray<o0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f65835e;

    public e0() {
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
        this.f65835e = null;
    }

    public void a(int i2, o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, o0Var) == null) {
            if (i2 > 100) {
                i2 = 100;
            }
            put(i2, o0Var);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                o0 valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.t(null);
                    valueAt.h();
                }
            }
        }
    }

    public o0 e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 > 100) {
                i2 = 100;
            }
            return get(i2);
        }
        return (o0) invokeI.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                o0 valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.init();
                }
            }
        }
    }

    public void g(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s0Var) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                o0 valueAt = valueAt(i2);
                if (valueAt != null) {
                    valueAt.t(s0Var);
                }
            }
        }
    }
}
