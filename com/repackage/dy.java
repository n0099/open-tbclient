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
import com.repackage.fo4;
import com.repackage.oy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class dy<T extends fo4> implements ix, ol5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public hx<T> b;
    public Context c;
    public FrameLayout d;
    public ThreadCardView e;
    public RelativeLayout f;
    public LinearLayout g;
    public rw<T> h;
    public rw<T> i;
    public List<yw> j;
    public rw<T> k;
    public ArrayList<tw> l;
    public ix m;
    public ey n;
    public T o;
    public oy p;
    public int q;
    public oy.a r;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy a;

        public a(dy dyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dyVar;
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
                    dy dyVar = this.a;
                    dyVar.o(dyVar.r);
                    return false;
                }
                this.a.r.d(Boolean.TRUE);
                dy dyVar2 = this.a;
                dyVar2.o(dyVar2.r);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ dy(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.repackage.ol5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(tw twVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, twVar) == null) || twVar == null || twVar.b() == null) {
            return;
        }
        n(twVar);
        twVar.b().setVisibility(0);
        if (twVar.d() == null) {
            this.f.addView(twVar.b(), twVar.c());
        } else {
            this.f.addView(twVar.b(), twVar.c(), twVar.d());
        }
        twVar.j(this);
        twVar.e();
        this.l.add(twVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tw twVar = new tw();
            twVar.g(new TbImageView(this.c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(qi.f(this.c, R.dimen.obfuscated_res_0x7f070260), qi.f(this.c, R.dimen.obfuscated_res_0x7f0702d2));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.n.g;
            twVar.i(layoutParams);
            twVar.h(-1);
            this.l.add(twVar);
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

    public rw<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (rw) invokeV.objValue;
    }

    public rw<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (rw) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    public List<yw> h() {
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
            ey eyVar = this.n;
            ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).setMargins(eyVar.f, eyVar.d, eyVar.g, eyVar.e);
            this.g.postInvalidate();
        }
        if (this.n.a) {
            d();
        }
        rw<T> rwVar = this.h;
        if (rwVar != null) {
            rwVar.k(this);
            this.g.addView(this.h.h());
            this.h.i();
        }
        rw<T> rwVar2 = this.i;
        if (rwVar2 != null) {
            rwVar2.k(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.n.b;
            if (this.i.g().booleanValue()) {
                ey eyVar2 = this.n;
                layoutParams.leftMargin = -eyVar2.f;
                layoutParams.rightMargin = -eyVar2.g;
            }
            this.g.addView(this.i.h(), layoutParams);
            this.i.i();
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                yw ywVar = this.j.get(i);
                if (ywVar != null) {
                    ywVar.k(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = ywVar.q();
                    layoutParams2.bottomMargin = ywVar.p();
                    if (ywVar.g().booleanValue()) {
                        ey eyVar3 = this.n;
                        layoutParams2.leftMargin = -eyVar3.f;
                        layoutParams2.rightMargin = -eyVar3.g;
                    }
                    this.g.addView(ywVar.h(), layoutParams2);
                    ywVar.i();
                }
            }
        }
        if (this.k != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.n.c;
            this.k.k(this);
            this.g.addView(this.k.h(), layoutParams3);
            this.k.i();
        }
        if (ListUtils.isEmpty(this.l)) {
            return;
        }
        Iterator<tw> it = this.l.iterator();
        while (it.hasNext()) {
            tw next = it.next();
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
            if (this.h != null) {
                this.e.setTag(R.id.obfuscated_res_0x7f0925a0, null);
                this.h.a(t);
                rw<T> rwVar = this.h;
                if (rwVar instanceof vy8) {
                    this.e.setTag(R.id.obfuscated_res_0x7f0925a0, rwVar);
                }
            }
            rw<T> rwVar2 = this.i;
            if (rwVar2 != null) {
                rwVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.j)) {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    yw ywVar = this.j.get(i);
                    ywVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(ywVar.h(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            rw<T> rwVar3 = this.k;
            if (rwVar3 != null) {
                rwVar3.a(t);
            }
            hx<T> hxVar = this.b;
            if (hxVar != null) {
                hxVar.a(t);
            }
            e(this.g);
            e(this.f);
        }
    }

    public void m(int i, oy.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.p.a(i, bVar);
        }
    }

    public void n(tw twVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, twVar) == null) || twVar == null || twVar.b() == null) {
            return;
        }
        this.l.remove(twVar);
        if (twVar.b().getParent() != null) {
            ((ViewGroup) twVar.b().getParent()).removeView(twVar.b());
            twVar.f();
            twVar.j(null);
        }
    }

    public boolean o(oy.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.p.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.repackage.ix
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
        rw<T> rwVar = this.h;
        if (rwVar != null) {
            rwVar.onChangeSkinType(tbPageContext, i);
            if (this.k == null && ((t2 = this.o) == null || !t2.isSupportContent())) {
                ms4 d = ms4.d(this.e);
                d.m(1);
                d.n(R.string.J_X06);
                d.f(this.n.h);
            }
        }
        rw<T> rwVar2 = this.i;
        if (rwVar2 != null) {
            rwVar2.onChangeSkinType(tbPageContext, i);
        }
        for (yw ywVar : this.j) {
            if (ywVar != null) {
                ywVar.onChangeSkinType(tbPageContext, i);
            }
        }
        rw<T> rwVar3 = this.k;
        if (rwVar3 != null) {
            rwVar3.onChangeSkinType(tbPageContext, i);
            if (this.h == null && ((t = this.o) == null || !t.isSupportContent())) {
                ms4 d2 = ms4.d(this.e);
                d2.m(2);
                d2.n(R.string.J_X06);
                d2.f(this.n.h);
            }
        }
        if (this.h != null && this.k != null) {
            ms4 d3 = ms4.d(this.e);
            d3.n(R.string.J_X06);
            d3.i(this.n.h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.l)) {
            Iterator<tw> it = this.l.iterator();
            while (it.hasNext()) {
                tw next = it.next();
                if (next != null && (next instanceof ix)) {
                    ((ix) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        ix ixVar = this.m;
        if (ixVar != null) {
            ixVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(b06<T> b06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, b06Var) == null) {
            rw<T> rwVar = this.h;
            if (rwVar != null) {
                rwVar.m(b06Var);
            }
            rw<T> rwVar2 = this.i;
            if (rwVar2 != null) {
                rwVar2.m(b06Var);
            }
            for (yw ywVar : this.j) {
                if (ywVar != null) {
                    ywVar.m(b06Var);
                }
            }
            rw<T> rwVar3 = this.k;
            if (rwVar3 != null) {
                rwVar3.m(b06Var);
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

    public /* synthetic */ dy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, un unVar, a aVar) {
        this(bVar, supportType, viewGroup, unVar);
    }

    public /* synthetic */ dy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dy(b bVar) {
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
    public dy(b bVar, BaseCardInfo.SupportType supportType) {
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
    public dy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (un) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (un) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public dy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, un unVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, unVar};
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
        this.p = new oy();
        this.q = 0;
        this.r = new oy.a(7);
        this.c = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0863, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.c);
            this.d = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0863, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f09212a);
        this.e = threadCardView;
        this.f = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904ee);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0903ab);
        this.g = linearLayout;
        linearLayout.setClipToPadding(false);
        this.h = bVar.a;
        this.i = bVar.b;
        this.j = bVar.c;
        this.k = bVar.d;
        this.l = bVar.e;
        this.n = bVar.g;
        this.e.setParent(viewGroup);
        this.e.setITypeListView(unVar);
        k();
        int f = this.n.a() ? qi.f(this.c, R.dimen.M_W_X004) : 0;
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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rw a;
        public rw b;
        public List<yw> c;
        public rw d;
        public ArrayList<tw> e;
        public Context f;
        public ey g;

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
            ey eyVar = new ey();
            this.g = eyVar;
            if (!z) {
                eyVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(yw ywVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ywVar)) == null) {
                this.c.add(ywVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public dy i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new dy(this, (a) null) : (dy) invokeV.objValue;
        }

        public dy j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new dy(this, supportType, viewGroup, (a) null) : (dy) invokeLL.objValue;
        }

        public dy k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, un unVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, unVar)) == null) ? new dy(this, supportType, viewGroup, unVar, null) : (dy) invokeLLL.objValue;
        }

        public ey l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (ey) invokeV.objValue;
        }

        public b m(rw rwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rwVar)) == null) {
                this.d = rwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(rw rwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rwVar)) == null) {
                this.b = rwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(rw rwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rwVar)) == null) {
                this.a = rwVar;
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
