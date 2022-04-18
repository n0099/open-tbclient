package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k28;
/* loaded from: classes7.dex */
public class y28 extends tw5<k28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public ImageView k;
    public LinearLayout l;
    public k28 m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k28.a a;
        public final /* synthetic */ y28 b;

        public a(y28 y28Var, k28.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y28Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y28Var;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y28(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View k = k();
        this.i = k.findViewById(R.id.obfuscated_res_0x7f090724);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091f1e);
        ImageView imageView = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090e98);
        this.k = imageView;
        imageView.setOnClickListener(this);
        this.l = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090c2f);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06ba : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            for (int i2 = 0; i2 < this.l.getChildCount(); i2++) {
                SkinManager.setViewTextColor((TextView) this.l.getChildAt(i2).findViewById(R.id.obfuscated_res_0x7f090726), (int) R.color.CAM_X0105);
            }
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(oi.f(this.c, R.dimen.tbds21)).setBgColor(R.color.CAM_X0201).setShadowColor(R.color.CAM_X0806).setShadowSide(ShadowDrawable.ALL).setShadowRadius(oi.f(this.c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(oi.f(this.c, R.dimen.tbds5)).into(this.i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.getId() == this.k.getId()) {
            w(R.string.obfuscated_res_0x7f0f045d, TbConfig.URL_CREATE_CENTER);
            TiebaStatic.log("c13842");
        }
    }

    public final View t(Context context, k28.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setId(R.id.obfuscated_res_0x7f090725);
            tbImageView.setImageResource(aVar.b);
            int f = oi.f(context, R.dimen.tbds126);
            linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(f, f));
            TextView textView = new TextView(context);
            textView.setId(R.id.obfuscated_res_0x7f090726);
            textView.setText(aVar.c);
            textView.setIncludeFontPadding(false);
            textView.setTextSize(0, oi.f(this.c, R.dimen.tbfontsize32));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oi.f(context, R.dimen.tbds32);
            linearLayout.addView(textView, layoutParams);
            linearLayout.setOnClickListener(new a(this, aVar));
            return linearLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void u(k28.a aVar) {
        k28 k28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || (k28Var = this.m) == null || k28Var.b == null) {
            return;
        }
        int i = aVar.a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.b.getPageActivity(), this.m.b.getUserId(), this.m.b.getSex(), this.m.b.getPortrait())));
            TiebaStatic.log("c13843");
        } else if (i == 2) {
            w(R.string.obfuscated_res_0x7f0f07b6, TbConfig.URL_GOD_AUTH);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 1));
        } else if (i == 5) {
            w(R.string.obfuscated_res_0x7f0f07bb, TbConfig.URL_GOD_EXAMINE);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 2));
        } else if (i == 3) {
            w(R.string.obfuscated_res_0x7f0f045e, TbConfig.URL_CREATE_COLLEGE);
            TiebaStatic.log("c13845");
        } else if (i == 4) {
            w(R.string.obfuscated_res_0x7f0f0857, TbConfig.URL_HOT_ACTIVITIES);
            TiebaStatic.log("c13846");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: v */
    public void l(k28 k28Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, k28Var) == null) || k28Var == null || ListUtils.isEmpty(k28Var.a)) {
            return;
        }
        if (k28Var != this.m) {
            this.l.removeAllViews();
            int k = (oi.k(this.c) - (oi.f(this.c, R.dimen.tbds44) * 2)) / k28Var.a.size();
            for (k28.a aVar : k28Var.a) {
                if (aVar != null) {
                    this.l.addView(t(this.c, aVar), new LinearLayout.LayoutParams(k, -2));
                }
            }
            this.m = k28Var;
        }
        m(j(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void w(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            this.b.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.getPageActivity(), this.b.getString(i), str, true)));
        }
    }
}
