package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ap5 extends eo<xo5, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public np5 j;
    public sp5 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), xo5.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: Z */
    public LiveTabConcernItemViewLineHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            np5 np5Var = new np5(this.i, viewGroup);
            this.j = np5Var;
            sp5 sp5Var = this.k;
            if (sp5Var != null) {
                np5Var.t(sp5Var);
            }
            return new LiveTabConcernItemViewLineHolder(this.j);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, xo5 xo5Var, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        np5 np5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xo5Var, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder == null || (np5Var = liveTabConcernItemViewLineHolder.a) == null) {
                return null;
            }
            np5Var.l(xo5Var);
            return liveTabConcernItemViewLineHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(sp5 sp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sp5Var) == null) {
            this.k = sp5Var;
            np5 np5Var = this.j;
            if (np5Var != null) {
                np5Var.t(sp5Var);
            }
        }
    }
}
