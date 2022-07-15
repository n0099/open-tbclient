package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class jw6<T, V extends TypeAdapter.ViewHolder> extends an<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean i;
    public TbPageContext<?> j;
    public tn k;
    public jm4 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = true;
        n(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    @Override // com.repackage.an
    public View S(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? view2 : (View) invokeCommon.objValue;
    }

    @Override // com.repackage.an
    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }

    public void Z(View view2, ThreadData threadData) {
        jm4 jm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, threadData) == null) || (jm4Var = this.l) == null) {
            return;
        }
        int i = threadData.position;
        jm4Var.c(view2, threadData, i, i);
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void b0(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jm4Var) == null) {
            this.l = jm4Var;
        }
    }

    public void c0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tnVar) == null) {
            this.k = tnVar;
        }
    }

    public void d0(View view2, ThreadData threadData, int i, long j) {
        jm4 jm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, threadData, Integer.valueOf(i), Long.valueOf(j)}) == null) || (jm4Var = this.l) == null) {
            return;
        }
        jm4Var.d(view2, threadData, i, j);
    }

    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, tbPageContext, bdUniqueId) == null) || tbPageContext == null) {
            return;
        }
        this.a = tbPageContext.getPageActivity();
        this.j = tbPageContext;
        this.e = bdUniqueId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw6(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.i = true;
        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
        this.j = pageContext;
        n(pageContext, pageContext == null ? null : pageContext.getUniqueId());
    }
}
