package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qo7 extends an<zo7, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hp7 i;

    /* loaded from: classes7.dex */
    public class a implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo7 a;

        public a(qo7 qo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qo7Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof zo7)) {
                zo7 zo7Var = (zo7) nnVar;
                zo7Var.t(!zo7Var.k());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.a.i0(interestedForumStyleAForumViewHolder.h, zo7Var.k());
                }
                if (this.a.i != null) {
                    this.a.i.a();
                }
                if (zo7Var.k()) {
                    this.a.c0(zo7Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo7(Context context, BdUniqueId bdUniqueId) {
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
        this.a = context;
        this.d = bdUniqueId;
        V(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, zo7 zo7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        e0(i, view2, viewGroup, zo7Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public final void c0(zo7 zo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zo7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", zo7Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public InterestedForumStyleAForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new InterestedForumStyleAForumViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03e7, viewGroup, false)) : (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view2, ViewGroup viewGroup, zo7 zo7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo7Var, interestedForumStyleAForumViewHolder})) == null) {
            if (zo7Var == null) {
                return view2;
            }
            h0(interestedForumStyleAForumViewHolder);
            f0(interestedForumStyleAForumViewHolder, zo7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, zo7 zo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, zo7Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.J(zo7Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(zo7Var.d() + this.a.getString(R.string.obfuscated_res_0x7f0f064c));
            if (!StringUtils.isNull(zo7Var.h())) {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091f, zo7Var.h()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0923));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0419), StringHelper.numberUniformFormatExtraWithRoundInt(zo7Var.g())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06b5), StringHelper.numberUniformFormatExtraWithRoundInt(zo7Var.i())));
            i0(interestedForumStyleAForumViewHolder.h, zo7Var.k());
        }
    }

    public void g0(hp7 hp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hp7Var) == null) {
            this.i = hp7Var;
        }
    }

    public final void h0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            vr4 d = vr4.d(interestedForumStyleAForumViewHolder.c);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            vr4 d2 = vr4.d(interestedForumStyleAForumViewHolder.d);
            d2.v(R.color.CAM_X0109);
            d2.z(R.dimen.T_X09);
            vr4 d3 = vr4.d(interestedForumStyleAForumViewHolder.e);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            vr4 d4 = vr4.d(interestedForumStyleAForumViewHolder.f);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void i0(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView, z) == null) {
            if (z) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            }
        }
    }
}
