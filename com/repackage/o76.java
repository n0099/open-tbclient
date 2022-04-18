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
/* loaded from: classes6.dex */
public class o76 extends a75<no4, o46> {
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r46 a;
        public final /* synthetic */ o76 b;

        public a(o76 o76Var, r46 r46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o76Var, r46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o76Var;
            this.a = r46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.r.dispatchMvcEvent(new s65(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no4 a;
        public final /* synthetic */ o76 b;

        public b(o76 o76Var, no4 no4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o76Var, no4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o76Var;
            this.a = no4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.p());
                bundle.putParcelable("info_forum_name_rect", this.b.q());
                s65 s65Var = new s65(1, this.a, null, null);
                s65Var.g(bundle);
                this.b.r.dispatchMvcEvent(s65Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no4 a;
        public final /* synthetic */ o76 b;

        public c(o76 o76Var, no4 no4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o76Var, no4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o76Var;
            this.a = no4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.r.dispatchMvcEvent(new s65(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ o76 c;

        public d(o76 o76Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o76Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o76Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = oi.k(this.c.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.b + oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o76(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091adf);
        this.g = findViewById;
        this.h = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0914e5);
        this.i = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0912ad);
        this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09183f);
        this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092137);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090852);
        this.m = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ceb);
        this.n = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090ce8);
        this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09162f);
        this.s = this.g.findViewById(R.id.obfuscated_res_0x7f0908ed);
        this.t = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092160);
        this.p = (BarImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090a26);
        this.u = this.g.findViewById(R.id.obfuscated_res_0x7f090a9b);
        this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090a57);
        this.p.setPlaceHolder(1);
        this.p.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // com.repackage.zj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            f95.a(tbPageContext, e());
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
    @Override // com.repackage.e75
    /* renamed from: r */
    public void i(no4 no4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, no4Var) == null) {
            super.i(no4Var);
            if (no4Var == null) {
                return;
            }
            u(no4Var);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.obfuscated_res_0x7f0808e7, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
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
    @Override // com.repackage.e75
    /* renamed from: t */
    public void k(o46 o46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o46Var) == null) {
            super.k(o46Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.g.setBackgroundDrawable(stateListDrawable);
            this.p.setPlaceHolder(1);
        }
    }

    public final void u(no4 no4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, no4Var) == null) || no4Var == null) {
            return;
        }
        o46 o46Var = (o46) f();
        this.g.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i2 = 0;
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        if (no4Var instanceof r46) {
            r46 r46Var = (r46) no4Var;
            this.h.setText(r46Var.r());
            this.m.setVisibility(r46Var.G() == 0 ? 8 : 0);
            if (r46Var.q() == 0) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(r46Var.q()));
            }
            this.p.setShowOval(true);
            this.p.K(r46Var.i(), 10, false);
            this.p.setShowOuterBorder(false);
            this.p.setShowInnerBorder(true);
            this.p.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.p.setStrokeColorResId(R.color.CAM_X0401);
            if (r46Var.m() > 0) {
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.u, R.color.transparent);
            }
            this.q.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0877), StringHelper.numberUniformFormatExtraWithRoundInt(r46Var.A())));
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(r46Var.r())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            this.o.setVisibility((r46Var.E() == 1 && r46Var.F() == 1) ? 0 : 8);
            if (r46Var.C() == 1) {
                this.j.setVisibility(0);
                this.j.setText(R.string.obfuscated_res_0x7f0f0330);
                SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f0804d1);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
                this.i.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(mg.g(r46Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.i.setVisibility(0);
                    this.i.setText("");
                    SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08068d);
                    SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0111);
                } else {
                    this.i.setVisibility(8);
                }
                this.j.setVisibility(8);
            }
            if (r46Var.H()) {
                this.k.setVisibility(0);
                i = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.k.setVisibility(8);
                i = 0;
            }
            if (r46Var.D()) {
                this.l.setVisibility(0);
                i += oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.l.setVisibility(8);
            }
            i2 = i;
            this.l.setOnClickListener(new a(this, r46Var));
        } else if (no4Var instanceof dq4) {
            dq4 dq4Var = (dq4) no4Var;
            this.h.setText(dq4Var.m());
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(dq4Var.m())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.o, R.drawable.obfuscated_res_0x7f080887);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        this.t.setVisibility(8);
        this.g.setOnClickListener(new b(this, no4Var));
        this.g.setOnLongClickListener(new c(this, no4Var));
        s(this.h, i2);
    }
}
