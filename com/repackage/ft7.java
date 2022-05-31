package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ft7 extends es7<to4, PbRecommendNovelHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp7 o;
    public PbRecommendNovelHolder.b p;

    /* loaded from: classes5.dex */
    public class a implements PbRecommendNovelHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        public a(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.b
        public void a(to4 to4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, to4Var) == null) || to4Var == null) {
                return;
            }
            ew7.a(this.a.o, to4Var, to4Var.h0, 6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pw7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
    }

    @Override // com.repackage.es7, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        d0(i, view2, viewGroup, (to4) obj, (PbRecommendNovelHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public PbRecommendNovelHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbRecommendNovelHolder(this.j.getPageContext(), LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0680, viewGroup, false), this.p) : (PbRecommendNovelHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, to4 to4Var, PbRecommendNovelHolder pbRecommendNovelHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, to4Var, pbRecommendNovelHolder})) == null) {
            super.S(i, view2, viewGroup, to4Var, pbRecommendNovelHolder);
            if (to4Var == null) {
                return view2;
            }
            to4Var.h0 = i + 1;
            ew7.d(this.j.getUniqueId(), this.o, to4Var, to4Var.h0, 6);
            pbRecommendNovelHolder.f(to4Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kp7Var) == null) {
            this.o = kp7Var;
        }
    }
}
