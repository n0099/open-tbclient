package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zq5 extends bn<dr5, SdkDoubleLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public hs5 b;
    public int c;
    public boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zq5(TbPageContext tbPageContext, int i, boolean z) {
        super(tbPageContext.getPageActivity(), z ? dr5.d : dr5.c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.a = tbPageContext;
        this.c = i;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: s */
    public SdkDoubleLiveViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.b = new hs5(this.a, viewGroup, this.c, this.d);
            return new SdkDoubleLiveViewHolder(this.b);
        }
        return (SdkDoubleLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dr5 dr5Var, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        InterceptResult invokeCommon;
        hs5 hs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dr5Var, sdkDoubleLiveViewHolder})) == null) {
            if (sdkDoubleLiveViewHolder == null || (hs5Var = sdkDoubleLiveViewHolder.a) == null) {
                return null;
            }
            hs5Var.i(dr5Var);
            sdkDoubleLiveViewHolder.a.j(this.a, TbadkCoreApplication.getInst().getSkinType());
            return sdkDoubleLiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
