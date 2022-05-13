package com.repackage;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x66 extends q75<xo4, p46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public BarImageView p;
    public TextView q;
    public ViewEventCenter r;
    public View s;
    public TextView t;
    public View u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s46 a;
        public final /* synthetic */ x66 b;

        public a(x66 x66Var, s46 s46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x66Var, s46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x66Var;
            this.a = s46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.r.dispatchMvcEvent(new i75(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xo4 a;
        public final /* synthetic */ x66 b;

        public b(x66 x66Var, xo4 xo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x66Var, xo4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x66Var;
            this.a = xo4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.p());
                bundle.putParcelable("info_forum_name_rect", this.b.q());
                i75 i75Var = new i75(1, this.a, null, null);
                i75Var.g(bundle);
                this.b.r.dispatchMvcEvent(i75Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xo4 a;
        public final /* synthetic */ x66 b;

        public c(x66 x66Var, xo4 xo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x66Var, xo4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x66Var;
            this.a = xo4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.r.dispatchMvcEvent(new i75(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ x66 c;

        public d(x66 x66Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x66Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x66Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = mi.k(this.c.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.b + mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x66(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = viewEventCenter;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091b2d);
        this.g = findViewById;
        this.h = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091504);
        this.i = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0912bc);
        this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091897);
        this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09218e);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09084a);
        this.m = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091d41);
        this.n = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090cd4);
        this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091656);
        this.s = this.g.findViewById(R.id.obfuscated_res_0x7f0908e5);
        this.t = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0921b6);
        this.p = (BarImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090a1b);
        this.u = this.g.findViewById(R.id.obfuscated_res_0x7f090a8a);
        this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090a4d);
        this.p.setPlaceHolder(1);
        this.p.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // com.repackage.wi8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            w95.a(tbPageContext, e());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final Rect p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect();
            this.p.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Rect rect = new Rect();
            this.h.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u75
    /* renamed from: r */
    public void i(xo4 xo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xo4Var) == null) {
            super.i(xo4Var);
            if (xo4Var == null) {
                return;
            }
            u(xo4Var);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.obfuscated_res_0x7f0808f5, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        }
    }

    public final void s(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, textView, i) == null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u75
    /* renamed from: t */
    public void k(p46 p46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p46Var) == null) {
            super.k(p46Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.g.setBackgroundDrawable(stateListDrawable);
            this.p.setPlaceHolder(1);
        }
    }

    public final void u(xo4 xo4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xo4Var) == null) || xo4Var == null) {
            return;
        }
        p46 p46Var = (p46) f();
        this.g.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i2 = 0;
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        if (xo4Var instanceof s46) {
            s46 s46Var = (s46) xo4Var;
            this.h.setText(s46Var.r());
            this.m.setVisibility(s46Var.G() == 0 ? 8 : 0);
            if (s46Var.q() == 0) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(s46Var.q()));
            }
            this.p.setShowOval(true);
            this.p.K(s46Var.i(), 10, false);
            this.p.setShowOuterBorder(false);
            this.p.setShowInnerBorder(true);
            this.p.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.p.setStrokeColorResId(R.color.CAM_X0401);
            if (s46Var.m() > 0) {
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.u, R.color.transparent);
            }
            this.q.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f087f), StringHelper.numberUniformFormatExtraWithRoundInt(s46Var.A())));
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(s46Var.r())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            this.o.setVisibility((s46Var.E() == 1 && s46Var.F() == 1) ? 0 : 8);
            if (s46Var.C() == 1) {
                this.j.setVisibility(0);
                this.j.setText(R.string.obfuscated_res_0x7f0f0335);
                SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f0804ca);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
                this.i.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(kg.g(s46Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.i.setVisibility(0);
                    this.i.setText("");
                    SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08067c);
                    SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0111);
                } else {
                    this.i.setVisibility(8);
                }
                this.j.setVisibility(8);
            }
            if (s46Var.H()) {
                this.k.setVisibility(0);
                i = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.k.setVisibility(8);
                i = 0;
            }
            if (s46Var.D()) {
                this.l.setVisibility(0);
                i += mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.l.setVisibility(8);
            }
            i2 = i;
            this.l.setOnClickListener(new a(this, s46Var));
        } else if (xo4Var instanceof oq4) {
            oq4 oq4Var = (oq4) xo4Var;
            this.h.setText(oq4Var.m());
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(oq4Var.m())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.o, R.drawable.obfuscated_res_0x7f08088a);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        this.t.setVisibility(8);
        this.g.setOnClickListener(new b(this, xo4Var));
        this.g.setOnLongClickListener(new c(this, xo4Var));
        s(this.h, i2);
    }
}
