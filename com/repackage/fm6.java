package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class fm6 extends an<hg8, FrsLikeRecommendHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fm6(@NonNull Context context) {
        super(context, hg8.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, hg8 hg8Var, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        b0(i, view2, viewGroup, hg8Var, frsLikeRecommendHolder);
        return view2;
    }

    public /* synthetic */ void Z(hg8 hg8Var, ViewGroup viewGroup, int i, View view2) {
        if (z() != null) {
            z().b(view2, hg8Var, hg8.f, viewGroup, i, view2.getId());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public FrsLikeRecommendHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new FrsLikeRecommendHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0327, viewGroup, false), this.i) : (FrsLikeRecommendHolder) invokeL.objValue;
    }

    public View b0(final int i, View view2, final ViewGroup viewGroup, final hg8 hg8Var, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hg8Var, frsLikeRecommendHolder})) == null) {
            if (hg8Var != null && frsLikeRecommendHolder != null) {
                frsLikeRecommendHolder.c(hg8Var);
                frsLikeRecommendHolder.e(new View.OnClickListener() { // from class: com.repackage.bm6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            fm6.this.Z(hg8Var, viewGroup, i, view3);
                        }
                    }
                });
                frsLikeRecommendHolder.d();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, themeColorInfo) == null) {
            this.i = themeColorInfo;
        }
    }
}
