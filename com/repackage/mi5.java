package com.repackage;

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
/* loaded from: classes6.dex */
public class mi5 extends xi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p98 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi5(p98 p98Var, BdUniqueId bdUniqueId) {
        super(p98Var.o().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p98Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = p98Var;
    }

    @Override // com.repackage.xi5, com.repackage.an
    public View D(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof ni5) {
                ni5 ni5Var = (ni5) obj;
                si5 R0 = ((ti5) this.i).R0(1);
                if (R0 instanceof pi5) {
                    return ((pi5) R0).l(i, view2, viewGroup, ni5Var.a());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.an
    public TypeAdapter.ViewHolder N(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (ni5.g(getType()) != -1 && (obj instanceof ni5)) {
                si5 R0 = ((ti5) this.i).R0(1);
                if (R0 instanceof pi5) {
                    return ((pi5) R0).f(viewGroup, ((ni5) obj).a());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.an
    public void T(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof ni5)) {
            si5 R0 = ((ti5) this.i).R0(1);
            if (R0 instanceof pi5) {
                ((pi5) R0).m(i, viewGroup, viewHolder, ((ni5) obj).a());
            }
        }
    }
}
