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
/* loaded from: classes6.dex */
public class gp7 extends eo<qp7, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yp7 i;

    /* loaded from: classes6.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public a(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof qp7)) {
                qp7 qp7Var = (qp7) roVar;
                qp7Var.u(!qp7Var.k());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.a.i0(interestedForumStyleAForumViewHolder.h, qp7Var.k());
                }
                if (this.a.i != null) {
                    this.a.i.a();
                }
                if (qp7Var.k()) {
                    this.a.c0(qp7Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, qp7 qp7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        e0(i, view2, viewGroup, qp7Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public final void c0(qp7 qp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qp7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", qp7Var.e());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public InterestedForumStyleAForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03f1, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03f4, viewGroup, false) : null;
            }
            return new InterestedForumStyleAForumViewHolder(inflate);
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view2, ViewGroup viewGroup, qp7 qp7Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qp7Var, interestedForumStyleAForumViewHolder})) == null) {
            if (qp7Var == null) {
                return view2;
            }
            h0(interestedForumStyleAForumViewHolder);
            f0(interestedForumStyleAForumViewHolder, qp7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, qp7 qp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, qp7Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.K(qp7Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(qp7Var.f() + this.a.getString(R.string.obfuscated_res_0x7f0f064b));
            if (!StringUtils.isNull(qp7Var.i())) {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091e, qp7Var.i()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0922));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f041b), StringHelper.numberUniformFormatExtraWithRoundInt(qp7Var.g())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06b4), StringHelper.numberUniformFormatExtraWithRoundInt(qp7Var.j())));
            i0(interestedForumStyleAForumViewHolder.h, qp7Var.k());
        }
    }

    public void g0(yp7 yp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yp7Var) == null) {
            this.i = yp7Var;
        }
    }

    public final void h0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            gs4 d = gs4.d(interestedForumStyleAForumViewHolder.c);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            gs4 d2 = gs4.d(interestedForumStyleAForumViewHolder.d);
            d2.v(R.color.CAM_X0109);
            d2.z(R.dimen.T_X09);
            gs4 d3 = gs4.d(interestedForumStyleAForumViewHolder.e);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            gs4 d4 = gs4.d(interestedForumStyleAForumViewHolder.f);
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
