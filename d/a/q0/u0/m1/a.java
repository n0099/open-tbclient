package d.a.q0.u0.m1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.s;
import d.a.q0.u0.m1.d.e0;
import d.a.q0.u0.m1.d.q;
import d.a.q0.u0.o2.d;
/* loaded from: classes8.dex */
public class a implements d.a.q0.u0.m1.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.u0.r2.b f63709a;

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
            }
        }
    }

    @Override // d.a.q0.u0.m1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.W2()) {
                return null;
            }
            return new d(frsFragment, noPressedRelativeLayout);
        }
        return (d) invokeLL.objValue;
    }

    @Override // d.a.q0.u0.m1.e.a
    public e0 b(FrsFragment frsFragment, s sVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, sVar, z)) == null) ? new q(frsFragment, sVar, z) : (e0) invokeLLZ.objValue;
    }

    @Override // d.a.q0.u0.m1.e.a
    public d.a.q0.u0.m1.e.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c() : (d.a.q0.u0.m1.e.b) invokeV.objValue;
    }

    @Override // d.a.q0.u0.m1.e.a
    public d.a.q0.u0.m1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new d.a.q0.u0.o2.b(frsFragment, noPressedRelativeLayout) : (d.a.q0.u0.m1.e.c) invokeLL.objValue;
    }

    @Override // d.a.q0.u0.m1.e.a
    public d.a.q0.u0.r2.b e(String str, FrsFragment frsFragment, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i2)) == null) {
            if (frsFragment == null) {
                return null;
            }
            b bVar = new b(frsFragment, null, null, i2);
            this.f63709a = bVar;
            bVar.L(frsFragment.B2());
            return this.f63709a;
        }
        return (d.a.q0.u0.r2.b) invokeLLI.objValue;
    }
}
