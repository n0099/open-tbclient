package d.a.p0.a0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes7.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431536543, "Ld/a/p0/a0/e0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431536543, "Ld/a/p0/a0/e0/j;");
                return;
            }
        }
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
    }

    public j(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53795e = b2Var;
    }

    public static boolean W(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) {
            if (b2Var == null) {
                return false;
            }
            if (b2Var.j1() == 49 || b2Var.j1() == 69) {
                return true;
            }
            return b2Var.j1() == 67 && b2Var.g1() != null && b2Var.g1().friendRoomStatus == 2;
        }
        return invokeL.booleanValue;
    }

    public StatisticItem Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StatisticItem d2 = d(str);
            d2.delete("obj_type");
            d2.delete("obj_type");
            d2.param("obj_type", 3);
            return d2;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // d.a.p0.a0.e0.k, d.a.p0.a0.e0.b, d.a.o0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53795e : (b2) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var != null && b2Var.j1() == 67) {
                return Q0;
            }
            return P0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
