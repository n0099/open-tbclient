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
import com.repackage.vz;
import com.repackage.zn4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class kz<T extends zn4> implements py, hj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public oy<T> b;
    public Context c;
    public FrameLayout d;
    public ThreadCardView e;
    public RelativeLayout f;
    public LinearLayout g;
    public zx<T> h;
    public zx<T> i;
    public List<gy> j;
    public zx<T> k;
    public ArrayList<by> l;
    public py m;
    public lz n;
    public T o;
    public vz p;
    public int q;
    public vz.a r;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz a;

        public a(kz kzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kzVar;
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
                    kz kzVar = this.a;
                    kzVar.o(kzVar.r);
                    return false;
                }
                this.a.r.d(Boolean.TRUE);
                kz kzVar2 = this.a;
                kzVar2.o(kzVar2.r);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ kz(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.repackage.hj5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(by byVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byVar) == null) || byVar == null || byVar.b() == null) {
            return;
        }
        n(byVar);
        byVar.b().setVisibility(0);
        if (byVar.d() == null) {
            this.f.addView(byVar.b(), byVar.c());
        } else {
            this.f.addView(byVar.b(), byVar.c(), byVar.d());
        }
        byVar.j(this);
        byVar.e();
        this.l.add(byVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            by byVar = new by();
            byVar.g(new TbImageView(this.c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mi.f(this.c, R.dimen.obfuscated_res_0x7f070264), mi.f(this.c, R.dimen.obfuscated_res_0x7f0702d5));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.n.g;
            byVar.i(layoutParams);
            byVar.h(-1);
            this.l.add(byVar);
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

    public zx<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (zx) invokeV.objValue;
    }

    public zx<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (zx) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    public List<gy> h() {
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
            lz lzVar = this.n;
            ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).setMargins(lzVar.f, lzVar.d, lzVar.g, lzVar.e);
            this.g.postInvalidate();
        }
        if (this.n.a) {
            d();
        }
        zx<T> zxVar = this.h;
        if (zxVar != null) {
            zxVar.j(this);
            this.g.addView(this.h.g());
            this.h.h();
        }
        zx<T> zxVar2 = this.i;
        if (zxVar2 != null) {
            zxVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.n.b;
            if (this.i.f().booleanValue()) {
                lz lzVar2 = this.n;
                layoutParams.leftMargin = -lzVar2.f;
                layoutParams.rightMargin = -lzVar2.g;
            }
            this.g.addView(this.i.g(), layoutParams);
            this.i.h();
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                gy gyVar = this.j.get(i);
                if (gyVar != null) {
                    gyVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = gyVar.p();
                    layoutParams2.bottomMargin = gyVar.o();
                    if (gyVar.f().booleanValue()) {
                        lz lzVar3 = this.n;
                        layoutParams2.leftMargin = -lzVar3.f;
                        layoutParams2.rightMargin = -lzVar3.g;
                    }
                    this.g.addView(gyVar.g(), layoutParams2);
                    gyVar.h();
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
        Iterator<by> it = this.l.iterator();
        while (it.hasNext()) {
            by next = it.next();
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
            zx<T> zxVar = this.h;
            if (zxVar != null) {
                zxVar.a(t);
            }
            zx<T> zxVar2 = this.i;
            if (zxVar2 != null) {
                zxVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.j)) {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    gy gyVar = this.j.get(i);
                    gyVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(gyVar.g(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            zx<T> zxVar3 = this.k;
            if (zxVar3 != null) {
                zxVar3.a(t);
            }
            oy<T> oyVar = this.b;
            if (oyVar != null) {
                oyVar.a(t);
            }
            e(this.g);
            e(this.f);
        }
    }

    public void m(int i, vz.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.p.a(i, bVar);
        }
    }

    public void n(by byVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, byVar) == null) || byVar == null || byVar.b() == null) {
            return;
        }
        this.l.remove(byVar);
        if (byVar.b().getParent() != null) {
            ((ViewGroup) byVar.b().getParent()).removeView(byVar.b());
            byVar.f();
            byVar.j(null);
        }
    }

    public boolean o(vz.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.p.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.repackage.py
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
        zx<T> zxVar = this.h;
        if (zxVar != null) {
            zxVar.onChangeSkinType(tbPageContext, i);
            if (this.k == null && ((t2 = this.o) == null || !t2.isSupportContent())) {
                gs4 d = gs4.d(this.e);
                d.m(1);
                d.n(R.string.J_X06);
                d.f(this.n.h);
            }
        }
        zx<T> zxVar2 = this.i;
        if (zxVar2 != null) {
            zxVar2.onChangeSkinType(tbPageContext, i);
        }
        for (gy gyVar : this.j) {
            if (gyVar != null) {
                gyVar.onChangeSkinType(tbPageContext, i);
            }
        }
        zx<T> zxVar3 = this.k;
        if (zxVar3 != null) {
            zxVar3.onChangeSkinType(tbPageContext, i);
            if (this.h == null && ((t = this.o) == null || !t.isSupportContent())) {
                gs4 d2 = gs4.d(this.e);
                d2.m(2);
                d2.n(R.string.J_X06);
                d2.f(this.n.h);
            }
        }
        if (this.h != null && this.k != null) {
            gs4 d3 = gs4.d(this.e);
            d3.n(R.string.J_X06);
            d3.i(this.n.h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.l)) {
            Iterator<by> it = this.l.iterator();
            while (it.hasNext()) {
                by next = it.next();
                if (next != null && (next instanceof py)) {
                    ((py) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        py pyVar = this.m;
        if (pyVar != null) {
            pyVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(ux5<T> ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ux5Var) == null) {
            zx<T> zxVar = this.h;
            if (zxVar != null) {
                zxVar.l(ux5Var);
            }
            zx<T> zxVar2 = this.i;
            if (zxVar2 != null) {
                zxVar2.l(ux5Var);
            }
            for (gy gyVar : this.j) {
                if (gyVar != null) {
                    gyVar.l(ux5Var);
                }
            }
            zx<T> zxVar3 = this.k;
            if (zxVar3 != null) {
                zxVar3.l(ux5Var);
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

    public /* synthetic */ kz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, xo xoVar, a aVar) {
        this(bVar, supportType, viewGroup, xoVar);
    }

    public /* synthetic */ kz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kz(b bVar) {
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
    public kz(b bVar, BaseCardInfo.SupportType supportType) {
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
    public kz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (xo) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (xo) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public kz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, xo xoVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, xoVar};
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
        this.p = new vz();
        this.q = 0;
        this.r = new vz.a(7);
        this.c = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d081e, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.c);
            this.d = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d081e, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f091fe0);
        this.e = threadCardView;
        this.f = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904f7);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090396);
        this.g = linearLayout;
        linearLayout.setClipToPadding(false);
        this.h = bVar.a;
        this.i = bVar.b;
        this.j = bVar.c;
        this.k = bVar.d;
        this.l = bVar.e;
        this.n = bVar.g;
        this.e.setParent(viewGroup);
        this.e.setITypeListView(xoVar);
        k();
        int f = this.n.a() ? mi.f(this.c, R.dimen.M_W_X004) : 0;
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
        public zx a;
        public zx b;
        public List<gy> c;
        public zx d;
        public ArrayList<by> e;
        public Context f;
        public lz g;

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
            lz lzVar = new lz();
            this.g = lzVar;
            if (!z) {
                lzVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(gy gyVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gyVar)) == null) {
                this.c.add(gyVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public kz i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new kz(this, (a) null) : (kz) invokeV.objValue;
        }

        public kz j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new kz(this, supportType, viewGroup, (a) null) : (kz) invokeLL.objValue;
        }

        public kz k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, xo xoVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, xoVar)) == null) ? new kz(this, supportType, viewGroup, xoVar, null) : (kz) invokeLLL.objValue;
        }

        public lz l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (lz) invokeV.objValue;
        }

        public b m(zx zxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zxVar)) == null) {
                this.d = zxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(zx zxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zxVar)) == null) {
                this.b = zxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(zx zxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zxVar)) == null) {
                this.a = zxVar;
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
