package d.a.d.k.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f42408a;

    /* renamed from: b  reason: collision with root package name */
    public m f42409b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f42410c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f42411d;

    /* renamed from: e  reason: collision with root package name */
    public float f42412e;

    /* renamed from: f  reason: collision with root package name */
    public float f42413f;

    /* renamed from: g  reason: collision with root package name */
    public int f42414g;

    /* renamed from: h  reason: collision with root package name */
    public int f42415h;

    /* renamed from: i  reason: collision with root package name */
    public int f42416i;
    public d.a.p0.o0.o.a j;
    public RecyclerView.OnChildAttachStateChangeListener k;
    public RecyclerView.OnScrollListener l;
    public RecyclerView.OnItemTouchListener m;

    /* loaded from: classes7.dex */
    public class a implements RecyclerView.OnChildAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f42417a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42417a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42417a.r(view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f42417a.s(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f42418a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42418a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                this.f42418a.u(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f42418a.t(i2, i3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements RecyclerView.OnItemTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f42419a;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42419a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    this.f42419a.f42410c.stopScroll();
                    this.f42419a.f42412e = motionEvent.getX();
                    this.f42419a.f42413f = motionEvent.getY();
                    l lVar = this.f42419a;
                    View x = lVar.x(lVar.f42412e, this.f42419a.f42413f);
                    l lVar2 = this.f42419a;
                    lVar2.f42414g = lVar2.f42410c.getChildAdapterPosition(x);
                    if (this.f42419a.f42411d == null) {
                        this.f42419a.f42411d = VelocityTracker.obtain();
                    }
                    this.f42419a.f42411d.addMovement(motionEvent);
                    return false;
                }
                if (actionMasked != 2) {
                    if (actionMasked == 3 || actionMasked == 1) {
                        this.f42419a.f42412e = 0.0f;
                        this.f42419a.f42413f = 0.0f;
                        this.f42419a.f42411d.clear();
                        return false;
                    }
                    return false;
                }
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                int i2 = (this.f42419a.f42416i == 2 ? y - this.f42419a.f42413f : x2 - this.f42419a.f42412e) >= 0.0f ? 2 : 1;
                if (i2 != this.f42419a.f42415h) {
                    this.f42419a.f42415h = i2;
                    this.f42419a.f42411d.clear();
                }
                this.f42419a.f42411d.addMovement(motionEvent);
                this.f42419a.f42411d.computeCurrentVelocity(50);
                l lVar3 = this.f42419a;
                lVar3.v(lVar3.f42411d.getXVelocity(), this.f42419a.f42411d.getYVelocity());
                this.f42419a.f42412e = x2;
                this.f42419a.f42413f = y;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
            }
        }
    }

    public l(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.f42408a = new i(jVar);
        this.f42409b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f42410c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f42410c.removeOnScrollListener(this.l);
            this.f42410c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f42410c = recyclerView;
        this.f42416i = i2;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f42409b.e((BdTypeRecyclerView) recyclerView, i2);
        } else {
            this.f42408a.e(recyclerView, i2);
        }
        this.f42410c.addOnItemTouchListener(this.m);
        this.f42410c.addOnScrollListener(this.l);
        this.f42410c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.f42410c instanceof BdTypeRecyclerView) {
                this.f42409b.j(view);
            } else {
                this.f42408a.g(view);
            }
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (this.f42410c instanceof BdTypeRecyclerView) {
                this.f42409b.k(view);
            } else {
                this.f42408a.h(view);
            }
        }
    }

    public final void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (this.f42410c instanceof BdTypeRecyclerView) {
                this.f42409b.o(i2, i3, this.f42414g);
            }
            this.f42408a.l(i2, i3, this.f42414g);
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                    if (this.j == null) {
                        this.j = new d.a.p0.o0.o.a("anim_switch_slide");
                    }
                    this.j.b();
                }
            } else if (i2 == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                this.j.c();
            }
            if (this.f42410c instanceof BdTypeRecyclerView) {
                this.f42409b.p(i2);
            }
            this.f42408a.m(i2);
        }
    }

    public final void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.f42410c instanceof BdTypeRecyclerView) {
                this.f42409b.s(f2, f3, this.f42414g);
            }
            this.f42408a.o(f2, f3, this.f42414g);
        }
    }

    public void w() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (recyclerView = this.f42410c) == null) {
            return;
        }
        recyclerView.removeOnItemTouchListener(this.m);
        this.f42410c.removeOnScrollListener(this.l);
        this.f42410c.removeOnChildAttachStateChangeListener(this.k);
    }

    public View x(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            RecyclerView recyclerView = this.f42410c;
            if (recyclerView == null) {
                return null;
            }
            for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.f42410c.getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
