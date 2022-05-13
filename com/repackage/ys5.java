package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ys5 extends pc6<hi8, FrsPageAlaInsertRecLiveHolder> implements sx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public jt5 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = "";
    }

    @Override // com.repackage.pc6, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i, view2, viewGroup, (hi8) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view2;
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.t = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public FrsPageAlaInsertRecLiveHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                return null;
            }
            jt5 jt5Var = new jt5(tbPageContext);
            this.u = jt5Var;
            jt5Var.a(this.t);
            return new FrsPageAlaInsertRecLiveHolder(this.u);
        }
        return (FrsPageAlaInsertRecLiveHolder) invokeL.objValue;
    }

    public View m0(int i, View view2, ViewGroup viewGroup, hi8 hi8Var, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hi8Var, frsPageAlaInsertRecLiveHolder})) == null) {
            super.S(i, view2, viewGroup, hi8Var, frsPageAlaInsertRecLiveHolder);
            if (hi8Var != null) {
                FrsViewData frsViewData = this.j;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                List<ThreadData> list = hi8Var.a;
                if (list != null && list.get(0) != null) {
                    hi8Var.a.get(0).statFloor = (i + 1) - topThreadSize;
                }
                frsPageAlaInsertRecLiveHolder.a.a(this.t);
                frsPageAlaInsertRecLiveHolder.a.l(hi8Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }
}
