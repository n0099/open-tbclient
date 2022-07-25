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
public class g76 extends f85<mo4, z46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public BarImageView o;
    public TextView p;
    public ViewEventCenter q;
    public View r;
    public TextView s;
    public View t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c56 a;
        public final /* synthetic */ g76 b;

        public a(g76 g76Var, c56 c56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g76Var, c56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g76Var;
            this.a = c56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.q.dispatchMvcEvent(new y75(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo4 a;
        public final /* synthetic */ g76 b;

        public b(g76 g76Var, mo4 mo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g76Var, mo4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g76Var;
            this.a = mo4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.m());
                bundle.putParcelable("info_forum_name_rect", this.b.n());
                y75 y75Var = new y75(1, this.a, null, null);
                y75Var.g(bundle);
                this.b.q.dispatchMvcEvent(y75Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo4 a;
        public final /* synthetic */ g76 b;

        public c(g76 g76Var, mo4 mo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g76Var, mo4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g76Var;
            this.a = mo4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.q.dispatchMvcEvent(new y75(12, this.a, null, null));
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
        public final /* synthetic */ g76 c;

        public d(g76 g76Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g76Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g76Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = pi.k(this.c.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.b + pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g76(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        this.q = viewEventCenter;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091b4d);
        this.f = findViewById;
        this.g = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091539);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0912f0);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0918c6);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0921d5);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09081e);
        this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091d8c);
        this.m = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090c8a);
        this.n = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091682);
        this.r = this.f.findViewById(R.id.obfuscated_res_0x7f0908be);
        this.s = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0921fd);
        this.o = (BarImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0909f5);
        this.t = this.f.findViewById(R.id.obfuscated_res_0x7f090a68);
        this.p = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090a27);
        this.o.setPlaceHolder(1);
        this.o.setStrokeColorResId(R.color.CAM_X0201);
    }

    public final Rect m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Rect rect = new Rect();
            this.o.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect();
            this.g.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.i85
    /* renamed from: o */
    public void f(mo4 mo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mo4Var) == null) {
            super.f(mo4Var);
            if (mo4Var == null) {
                return;
            }
            r(mo4Var);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f0808ed, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    @Override // com.repackage.lh8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            ha5.a(tbPageContext, c());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void p(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, textView, i) == null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.i85
    /* renamed from: q */
    public void h(z46 z46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, z46Var) == null) {
            super.h(z46Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.f.setBackgroundDrawable(stateListDrawable);
            this.o.setPlaceHolder(1);
        }
    }

    public final void r(mo4 mo4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mo4Var) == null) || mo4Var == null) {
            return;
        }
        z46 z46Var = (z46) d();
        this.f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i2 = 0;
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        if (mo4Var instanceof c56) {
            c56 c56Var = (c56) mo4Var;
            this.g.setText(c56Var.o());
            this.l.setVisibility(c56Var.G() == 0 ? 8 : 0);
            if (c56Var.m() == 0) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(c56Var.m()));
            }
            this.o.setShowOval(true);
            this.o.J(c56Var.g(), 10, false);
            this.o.setShowOuterBorder(false);
            this.o.setShowInnerBorder(true);
            this.o.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.o.setStrokeColorResId(R.color.CAM_X0401);
            if (c56Var.k() > 0) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.transparent);
            }
            this.p.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0878), StringHelper.numberUniformFormatExtraWithRoundInt(c56Var.A())));
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(c56Var.o())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            this.n.setVisibility((c56Var.E() == 1 && c56Var.F() == 1) ? 0 : 8);
            if (c56Var.C() == 1) {
                this.i.setVisibility(0);
                this.i.setText(R.string.obfuscated_res_0x7f0f0339);
                SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f0804c7);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                this.h.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(ng.g(c56Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.h.setVisibility(0);
                    this.h.setText("");
                    SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f080678);
                    SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0111);
                } else {
                    this.h.setVisibility(8);
                }
                this.i.setVisibility(8);
            }
            if (c56Var.H()) {
                this.j.setVisibility(0);
                i = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.j.setVisibility(8);
                i = 0;
            }
            if (c56Var.D()) {
                this.k.setVisibility(0);
                i += pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.k.setVisibility(8);
            }
            i2 = i;
            this.k.setOnClickListener(new a(this, c56Var));
        } else if (mo4Var instanceof dq4) {
            dq4 dq4Var = (dq4) mo4Var;
            this.g.setText(dq4Var.k());
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(dq4Var.k())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.n, R.drawable.obfuscated_res_0x7f08087f);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        this.s.setVisibility(8);
        this.f.setOnClickListener(new b(this, mo4Var));
        this.f.setOnLongClickListener(new c(this, mo4Var));
        p(this.g, i2);
    }
}
