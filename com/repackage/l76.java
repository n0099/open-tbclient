package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public RoundRelativeLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l76 a;

        public a(l76 l76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                s46.b(this.a.a, null);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.k ? 5 : 1);
                statisticItem.param("obj_source", this.a.k ? 1 : 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public l76(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02c6, (ViewGroup) null);
        this.b = inflate;
        this.c = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091dfa);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091e10);
        this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091e16);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e18);
        this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091dfc);
        this.f = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090fb6);
        this.g.setText(R.string.obfuscated_res_0x7f0f06b3);
        this.h.setText(R.string.obfuscated_res_0x7f0f06af);
        this.b.setOnClickListener(new a(this));
        this.i = pi.f(this.a.getPageActivity(), R.dimen.tbds90);
        this.j = pi.f(this.a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.c;
        int i3 = this.i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i3, i3, i3, i3, i3, i3, i3, i3});
    }

    public void c(v46 v46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v46Var) == null) {
            if (v46Var.isTop()) {
                if (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                    int i = marginLayoutParams.bottomMargin;
                    int i2 = this.j;
                    if (i != i2) {
                        marginLayoutParams.bottomMargin = i2;
                        this.c.requestLayout();
                    }
                }
            } else if (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                if (marginLayoutParams2.bottomMargin != 0) {
                    marginLayoutParams2.bottomMargin = 0;
                    this.c.requestLayout();
                }
            }
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0206);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.d, R.drawable.obfuscated_res_0x7f080636, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.e, R.drawable.pic_mask_square_circle);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f0805e4, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }
}
