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
import com.repackage.iy;
import com.repackage.om4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class xx<T extends om4> implements cx, bi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public bx<T> b;
    public Context c;
    public FrameLayout d;
    public ThreadCardView e;
    public RelativeLayout f;
    public LinearLayout g;
    public mw<T> h;
    public mw<T> i;
    public List<tw> j;
    public mw<T> k;
    public ArrayList<ow> l;
    public cx m;
    public yx n;
    public T o;
    public iy p;
    public int q;
    public iy.a r;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx a;

        public a(xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xxVar;
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
                    xx xxVar = this.a;
                    xxVar.o(xxVar.r);
                    return false;
                }
                this.a.r.d(Boolean.TRUE);
                xx xxVar2 = this.a;
                xxVar2.o(xxVar2.r);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ xx(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.repackage.bi5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(ow owVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, owVar) == null) || owVar == null || owVar.b() == null) {
            return;
        }
        n(owVar);
        owVar.b().setVisibility(0);
        if (owVar.d() == null) {
            this.f.addView(owVar.b(), owVar.c());
        } else {
            this.f.addView(owVar.b(), owVar.c(), owVar.d());
        }
        owVar.j(this);
        owVar.e();
        this.l.add(owVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ow owVar = new ow();
            owVar.g(new TbImageView(this.c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(li.f(this.c, R.dimen.obfuscated_res_0x7f070264), li.f(this.c, R.dimen.obfuscated_res_0x7f0702d5));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.n.g;
            owVar.i(layoutParams);
            owVar.h(-1);
            this.l.add(owVar);
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

    public mw<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (mw) invokeV.objValue;
    }

    public mw<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (mw) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    public List<tw> h() {
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
            yx yxVar = this.n;
            ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).setMargins(yxVar.f, yxVar.d, yxVar.g, yxVar.e);
            this.g.postInvalidate();
        }
        if (this.n.a) {
            d();
        }
        mw<T> mwVar = this.h;
        if (mwVar != null) {
            mwVar.j(this);
            this.g.addView(this.h.g());
            this.h.h();
        }
        mw<T> mwVar2 = this.i;
        if (mwVar2 != null) {
            mwVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.n.b;
            if (this.i.f().booleanValue()) {
                yx yxVar2 = this.n;
                layoutParams.leftMargin = -yxVar2.f;
                layoutParams.rightMargin = -yxVar2.g;
            }
            this.g.addView(this.i.g(), layoutParams);
            this.i.h();
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                tw twVar = this.j.get(i);
                if (twVar != null) {
                    twVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = twVar.p();
                    layoutParams2.bottomMargin = twVar.o();
                    if (twVar.f().booleanValue()) {
                        yx yxVar3 = this.n;
                        layoutParams2.leftMargin = -yxVar3.f;
                        layoutParams2.rightMargin = -yxVar3.g;
                    }
                    this.g.addView(twVar.g(), layoutParams2);
                    twVar.h();
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
        Iterator<ow> it = this.l.iterator();
        while (it.hasNext()) {
            ow next = it.next();
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
            mw<T> mwVar = this.h;
            if (mwVar != null) {
                mwVar.a(t);
            }
            mw<T> mwVar2 = this.i;
            if (mwVar2 != null) {
                mwVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.j)) {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    tw twVar = this.j.get(i);
                    twVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(twVar.g(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            mw<T> mwVar3 = this.k;
            if (mwVar3 != null) {
                mwVar3.a(t);
            }
            bx<T> bxVar = this.b;
            if (bxVar != null) {
                bxVar.a(t);
            }
            e(this.g);
            e(this.f);
        }
    }

    public void m(int i, iy.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.p.a(i, bVar);
        }
    }

    public void n(ow owVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, owVar) == null) || owVar == null || owVar.b() == null) {
            return;
        }
        this.l.remove(owVar);
        if (owVar.b().getParent() != null) {
            ((ViewGroup) owVar.b().getParent()).removeView(owVar.b());
            owVar.f();
            owVar.j(null);
        }
    }

    public boolean o(iy.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.p.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.repackage.cx
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
        mw<T> mwVar = this.h;
        if (mwVar != null) {
            mwVar.onChangeSkinType(tbPageContext, i);
            if (this.k == null && ((t2 = this.o) == null || !t2.isSupportContent())) {
                wq4 d = wq4.d(this.e);
                d.m(1);
                d.n(R.string.J_X06);
                d.f(this.n.h);
            }
        }
        mw<T> mwVar2 = this.i;
        if (mwVar2 != null) {
            mwVar2.onChangeSkinType(tbPageContext, i);
        }
        for (tw twVar : this.j) {
            if (twVar != null) {
                twVar.onChangeSkinType(tbPageContext, i);
            }
        }
        mw<T> mwVar3 = this.k;
        if (mwVar3 != null) {
            mwVar3.onChangeSkinType(tbPageContext, i);
            if (this.h == null && ((t = this.o) == null || !t.isSupportContent())) {
                wq4 d2 = wq4.d(this.e);
                d2.m(2);
                d2.n(R.string.J_X06);
                d2.f(this.n.h);
            }
        }
        if (this.h != null && this.k != null) {
            wq4 d3 = wq4.d(this.e);
            d3.n(R.string.J_X06);
            d3.i(this.n.h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.l)) {
            Iterator<ow> it = this.l.iterator();
            while (it.hasNext()) {
                ow next = it.next();
                if (next != null && (next instanceof cx)) {
                    ((cx) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        cx cxVar = this.m;
        if (cxVar != null) {
            cxVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(nw5<T> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nw5Var) == null) {
            mw<T> mwVar = this.h;
            if (mwVar != null) {
                mwVar.l(nw5Var);
            }
            mw<T> mwVar2 = this.i;
            if (mwVar2 != null) {
                mwVar2.l(nw5Var);
            }
            for (tw twVar : this.j) {
                if (twVar != null) {
                    twVar.l(nw5Var);
                }
            }
            mw<T> mwVar3 = this.k;
            if (mwVar3 != null) {
                mwVar3.l(nw5Var);
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

    public /* synthetic */ xx(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, pn pnVar, a aVar) {
        this(bVar, supportType, viewGroup, pnVar);
    }

    public /* synthetic */ xx(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xx(b bVar) {
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
    public xx(b bVar, BaseCardInfo.SupportType supportType) {
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
    public xx(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (pn) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (pn) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public xx(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, pn pnVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, pnVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = null;
        this.m = null;
        this.p = new iy();
        this.q = 0;
        this.r = new iy.a(7);
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
        this.f = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904f1);
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
        this.e.setITypeListView(pnVar);
        k();
        int f = this.n.a() ? li.f(this.c, R.dimen.M_W_X004) : 0;
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

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public mw a;
        public mw b;
        public List<tw> c;
        public mw d;
        public ArrayList<ow> e;
        public Context f;
        public yx g;

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
            yx yxVar = new yx();
            this.g = yxVar;
            if (!z) {
                yxVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(tw twVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, twVar)) == null) {
                this.c.add(twVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public xx i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new xx(this, (a) null) : (xx) invokeV.objValue;
        }

        public xx j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new xx(this, supportType, viewGroup, (a) null) : (xx) invokeLL.objValue;
        }

        public xx k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, pn pnVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, pnVar)) == null) ? new xx(this, supportType, viewGroup, pnVar, null) : (xx) invokeLLL.objValue;
        }

        public yx l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (yx) invokeV.objValue;
        }

        public b m(mw mwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mwVar)) == null) {
                this.d = mwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(mw mwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mwVar)) == null) {
                this.b = mwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(mw mwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mwVar)) == null) {
                this.a = mwVar;
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
