package d.a.q0.e.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.e.e.f;
import d.a.q0.w2.t;
/* loaded from: classes8.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.m().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tVar;
    }

    @Override // d.a.d.k.e.a
    public View I(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                d.a.q0.e.e.a injectPlugin = ((d.a.q0.e.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).l(i2, view, viewGroup, bVar.b());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.d.k.e.a
    public TypeAdapter.ViewHolder R(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b.h(H()) != -1 && (obj instanceof b)) {
                d.a.q0.e.e.a injectPlugin = ((d.a.q0.e.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).f(viewGroup, ((b) obj).b());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // d.a.d.k.e.a
    public void Y(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof b)) {
            d.a.q0.e.e.a injectPlugin = ((d.a.q0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).m(i2, viewGroup, viewHolder, ((b) obj).b());
            }
        }
    }
}
