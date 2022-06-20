package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.my;
import com.repackage.ym4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class by<T extends ym4> implements gx, yi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public fx<T> b;
    public Context c;
    public FrameLayout d;
    public ThreadCardView e;
    public RelativeLayout f;
    public LinearLayout g;
    public qw<T> h;
    public qw<T> i;
    public List<xw> j;
    public qw<T> k;
    public ArrayList<sw> l;
    public gx m;
    public cy n;
    public T o;
    public my p;
    public int q;
    public my.a r;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by a;

        public a(by byVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                        }
                    }
                    this.a.r.d(Boolean.FALSE);
                    by byVar = this.a;
                    byVar.o(byVar.r);
                    return false;
                }
                this.a.r.d(Boolean.TRUE);
                by byVar2 = this.a;
                byVar2.o(byVar2.r);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ by(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.repackage.yi5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(sw swVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swVar) == null) || swVar == null || swVar.b() == null) {
            return;
        }
        n(swVar);
        swVar.b().setVisibility(0);
        if (swVar.d() == null) {
            this.f.addView(swVar.b(), swVar.c());
        } else {
            this.f.addView(swVar.b(), swVar.c(), swVar.d());
        }
        swVar.j(this);
        swVar.e();
        this.l.add(swVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sw swVar = new sw();
            swVar.g(new TbImageView(this.c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pi.f(this.c, R.dimen.obfuscated_res_0x7f070264), pi.f(this.c, R.dimen.obfuscated_res_0x7f0702d5));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.n.g;
            swVar.i(layoutParams);
            swVar.h(-1);
            this.l.add(swVar);
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                z = 8 != viewGroup.getChildAt(i).getVisibility();
                if (z) {
                    break;
                }
            }
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public qw<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (qw) invokeV.objValue;
    }

    public qw<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (qw) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    public List<xw> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout frameLayout = this.d;
            return frameLayout != null ? frameLayout : this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.n == null) {
            return;
        }
        if (this.g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            cy cyVar = this.n;
            ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).setMargins(cyVar.f, cyVar.d, cyVar.g, cyVar.e);
            this.g.postInvalidate();
        }
        if (this.n.a) {
            d();
        }
        qw<T> qwVar = this.h;
        if (qwVar != null) {
            qwVar.j(this);
            this.g.addView(this.h.g());
            this.h.h();
        }
        qw<T> qwVar2 = this.i;
        if (qwVar2 != null) {
            qwVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.n.b;
            if (this.i.f().booleanValue()) {
                cy cyVar2 = this.n;
                layoutParams.leftMargin = -cyVar2.f;
                layoutParams.rightMargin = -cyVar2.g;
            }
            this.g.addView(this.i.g(), layoutParams);
            this.i.h();
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                xw xwVar = this.j.get(i);
                if (xwVar != null) {
                    xwVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = xwVar.p();
                    layoutParams2.bottomMargin = xwVar.o();
                    if (xwVar.f().booleanValue()) {
                        cy cyVar3 = this.n;
                        layoutParams2.leftMargin = -cyVar3.f;
                        layoutParams2.rightMargin = -cyVar3.g;
                    }
                    this.g.addView(xwVar.g(), layoutParams2);
                    xwVar.h();
                }
            }
        }
        if (this.k != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.n.c;
            this.k.j(this);
            this.g.addView(this.k.g(), layoutParams3);
            this.k.h();
        }
        if (ListUtils.isEmpty(this.l)) {
            return;
        }
        Iterator<sw> it = this.l.iterator();
        while (it.hasNext()) {
            sw next = it.next();
            if (next != null && next.b() != null) {
                if (next.d() == null) {
                    this.f.addView(next.b(), next.c());
                } else {
                    this.f.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            this.o = t;
            qw<T> qwVar = this.h;
            if (qwVar != null) {
                qwVar.a(t);
            }
            qw<T> qwVar2 = this.i;
            if (qwVar2 != null) {
                qwVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.j)) {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    xw xwVar = this.j.get(i);
                    xwVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(xwVar.g(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            qw<T> qwVar3 = this.k;
            if (qwVar3 != null) {
                qwVar3.a(t);
            }
            fx<T> fxVar = this.b;
            if (fxVar != null) {
                fxVar.a(t);
            }
            e(this.g);
            e(this.f);
        }
    }

    public void m(int i, my.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.p.a(i, bVar);
        }
    }

    public void n(sw swVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, swVar) == null) || swVar == null || swVar.b() == null) {
            return;
        }
        this.l.remove(swVar);
        if (swVar.b().getParent() != null) {
            ((ViewGroup) swVar.b().getParent()).removeView(swVar.b());
            swVar.f();
            swVar.j(null);
        }
    }

    public boolean o(my.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.p.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.repackage.gx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) || i == this.a) {
            return;
        }
        this.a = i;
        T t3 = this.o;
        if (t3 != null && !t3.isSupportNone()) {
            SkinManager.setBackgroundResource(this.e, this.n.h);
        }
        qw<T> qwVar = this.h;
        if (qwVar != null) {
            qwVar.onChangeSkinType(tbPageContext, i);
            if (this.k == null && ((t2 = this.o) == null || !t2.isSupportContent())) {
                fr4 d = fr4.d(this.e);
                d.m(1);
                d.n(R.string.J_X06);
                d.f(this.n.h);
            }
        }
        qw<T> qwVar2 = this.i;
        if (qwVar2 != null) {
            qwVar2.onChangeSkinType(tbPageContext, i);
        }
        for (xw xwVar : this.j) {
            if (xwVar != null) {
                xwVar.onChangeSkinType(tbPageContext, i);
            }
        }
        qw<T> qwVar3 = this.k;
        if (qwVar3 != null) {
            qwVar3.onChangeSkinType(tbPageContext, i);
            if (this.h == null && ((t = this.o) == null || !t.isSupportContent())) {
                fr4 d2 = fr4.d(this.e);
                d2.m(2);
                d2.n(R.string.J_X06);
                d2.f(this.n.h);
            }
        }
        if (this.h != null && this.k != null) {
            fr4 d3 = fr4.d(this.e);
            d3.n(R.string.J_X06);
            d3.i(this.n.h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.l)) {
            Iterator<sw> it = this.l.iterator();
            while (it.hasNext()) {
                sw next = it.next();
                if (next != null && (next instanceof gx)) {
                    ((gx) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        gx gxVar = this.m;
        if (gxVar != null) {
            gxVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(mx5<T> mx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mx5Var) == null) {
            qw<T> qwVar = this.h;
            if (qwVar != null) {
                qwVar.l(mx5Var);
            }
            qw<T> qwVar2 = this.i;
            if (qwVar2 != null) {
                qwVar2.l(mx5Var);
            }
            for (xw xwVar : this.j) {
                if (xwVar != null) {
                    xwVar.l(mx5Var);
                }
            }
            qw<T> qwVar3 = this.k;
            if (qwVar3 != null) {
                qwVar3.l(mx5Var);
            }
        }
    }

    public void q(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (threadCardView = this.e) == null) {
            return;
        }
        threadCardView.setPosition(i);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.q = i;
        }
    }

    public /* synthetic */ by(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, tn tnVar, a aVar) {
        this(bVar, supportType, viewGroup, tnVar);
    }

    public /* synthetic */ by(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public by(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public by(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public by(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (tn) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (tn) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public by(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, tn tnVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, tnVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = null;
        this.m = null;
        this.p = new my();
        this.q = 0;
        this.r = new my.a(7);
        this.c = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0811, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.c);
            this.d = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0811, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f091f85);
        this.e = threadCardView;
        this.f = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904d1);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090391);
        this.g = linearLayout;
        linearLayout.setClipToPadding(false);
        this.h = bVar.a;
        this.i = bVar.b;
        this.j = bVar.c;
        this.k = bVar.d;
        this.l = bVar.e;
        this.n = bVar.g;
        this.e.setParent(viewGroup);
        this.e.setITypeListView(tnVar);
        k();
        int f = this.n.a() ? pi.f(this.c, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + f, marginLayoutParams.topMargin + this.n.i, marginLayoutParams.rightMargin + f, marginLayoutParams.bottomMargin);
                this.e.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + f, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + f, marginLayoutParams2.bottomMargin);
                this.e.postInvalidate();
            }
        } else if (f != 0 && (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + f, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + f, marginLayoutParams3.bottomMargin);
            this.e.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qw a;
        public qw b;
        public List<xw> c;
        public qw d;
        public ArrayList<sw> e;
        public Context f;
        public cy g;

        public b(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.d = null;
            this.f = context;
            this.e = new ArrayList<>();
            cy cyVar = new cy();
            this.g = cyVar;
            if (!z) {
                cyVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(xw xwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xwVar)) == null) {
                this.c.add(xwVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public by i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new by(this, (a) null) : (by) invokeV.objValue;
        }

        public by j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new by(this, supportType, viewGroup, (a) null) : (by) invokeLL.objValue;
        }

        public by k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, tn tnVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, tnVar)) == null) ? new by(this, supportType, viewGroup, tnVar, null) : (by) invokeLLL.objValue;
        }

        public cy l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (cy) invokeV.objValue;
        }

        public b m(qw qwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qwVar)) == null) {
                this.d = qwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(qw qwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qwVar)) == null) {
                this.b = qwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(qw qwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qwVar)) == null) {
                this.a = qwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            this(context, true);
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
                    this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
