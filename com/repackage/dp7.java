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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes5.dex */
public class dp7 extends ho<np7, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vp7 i;

    /* loaded from: classes5.dex */
    public class a implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dp7 a;

        public a(dp7 dp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dp7Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof np7)) {
                np7 np7Var = (np7) uoVar;
                np7Var.u(!np7Var.k());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.a.i0(interestedForumStyleAForumViewHolder.h, np7Var.k());
                }
                if (this.a.i != null) {
                    this.a.i.a();
                }
                if (np7Var.k()) {
                    this.a.c0(np7Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, np7 np7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        e0(i, view2, viewGroup, np7Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public final void c0(np7 np7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, np7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", np7Var.e());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public InterestedForumStyleAForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03fd, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0400, viewGroup, false) : null;
            }
            return new InterestedForumStyleAForumViewHolder(inflate);
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view2, ViewGroup viewGroup, np7 np7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, np7Var, interestedForumStyleAForumViewHolder})) == null) {
            if (np7Var == null) {
                return view2;
            }
            h0(interestedForumStyleAForumViewHolder);
            f0(interestedForumStyleAForumViewHolder, np7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, np7 np7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, np7Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.K(np7Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(np7Var.f() + this.a.getString(R.string.obfuscated_res_0x7f0f0643));
            if (!StringUtils.isNull(np7Var.i())) {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091a, np7Var.i()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091e));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0415), StringHelper.numberUniformFormatExtraWithRoundInt(np7Var.g())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06ab), StringHelper.numberUniformFormatExtraWithRoundInt(np7Var.j())));
            i0(interestedForumStyleAForumViewHolder.h, np7Var.k());
        }
    }

    public void g0(vp7 vp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vp7Var) == null) {
            this.i = vp7Var;
        }
    }

    public final void h0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            wr4 d = wr4.d(interestedForumStyleAForumViewHolder.c);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            wr4 d2 = wr4.d(interestedForumStyleAForumViewHolder.d);
            d2.v(R.color.CAM_X0109);
            d2.z(R.dimen.T_X09);
            wr4 d3 = wr4.d(interestedForumStyleAForumViewHolder.e);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            wr4 d4 = wr4.d(interestedForumStyleAForumViewHolder.f);
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
