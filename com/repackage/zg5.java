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
/* loaded from: classes7.dex */
public class zg5 extends kh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ia8 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg5(ia8 ia8Var, BdUniqueId bdUniqueId) {
        super(ia8Var.i().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia8Var, bdUniqueId};
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
        this.i = ia8Var;
    }

    @Override // com.repackage.kh5, com.repackage.ho
    public View E(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof ah5) {
                ah5 ah5Var = (ah5) obj;
                fh5 injectPlugin = ((gh5) this.i).getInjectPlugin(1);
                if (injectPlugin instanceof ch5) {
                    return ((ch5) injectPlugin).k(i, view2, viewGroup, ah5Var.a());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ho
    public TypeAdapter.ViewHolder N(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (ah5.g(getType()) != -1 && (obj instanceof ah5)) {
                fh5 injectPlugin = ((gh5) this.i).getInjectPlugin(1);
                if (injectPlugin instanceof ch5) {
                    return ((ch5) injectPlugin).e(viewGroup, ((ah5) obj).a());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ho
    public void T(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof ah5)) {
            fh5 injectPlugin = ((gh5) this.i).getInjectPlugin(1);
            if (injectPlugin instanceof ch5) {
                ((ch5) injectPlugin).l(i, viewGroup, viewHolder, ((ah5) obj).a());
            }
        }
    }
}
