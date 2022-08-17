package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zs5 extends bn<vt5, SpecialLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public lt5 b;
    public du5 c;
    public int d;
    public long e;
    public String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs5(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), vt5.c);
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
        this.e = 0L;
        this.f = "";
        this.a = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: s */
    public SpecialLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            lt5 lt5Var = new lt5(this.a, viewGroup);
            this.b = lt5Var;
            du5 du5Var = this.c;
            if (du5Var != null) {
                lt5Var.t(du5Var);
            }
            return new SpecialLiveDoubleViewHolder(this.b);
        }
        return (SpecialLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vt5 vt5Var, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vt5Var, specialLiveDoubleViewHolder})) == null) {
            specialLiveDoubleViewHolder.a.s(vt5Var, this.d, this.e, this.f);
            return specialLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.e = j;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public void w(du5 du5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, du5Var) == null) {
            this.c = du5Var;
            lt5 lt5Var = this.b;
            if (lt5Var != null) {
                lt5Var.t(du5Var);
            }
        }
    }
}
