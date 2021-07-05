package d.a.s0.p0.a0;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EmotionPackageDetailActivity f64369a;

    /* renamed from: b  reason: collision with root package name */
    public final float f64370b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64371c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64372d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f64373e;

    /* renamed from: f  reason: collision with root package name */
    public int f64374f;

    /* renamed from: g  reason: collision with root package name */
    public int f64375g;

    /* renamed from: h  reason: collision with root package name */
    public int f64376h;

    /* renamed from: i  reason: collision with root package name */
    public int f64377i;
    public Handler j;
    public EmotionPreview k;
    public PackageDetailListView l;
    public boolean m;
    public boolean n;
    public FrameLayout o;
    public int p;
    public e q;
    public final Runnable r;
    public final PackageDetailListView.a s;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64378e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64378e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64378e.B();
            }
        }
    }

    /* renamed from: d.a.s0.p0.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1628b implements PackageDetailListView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64379a;

        public C1628b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64379a = bVar;
        }

        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            e v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (motionEvent == null) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.f64379a.f64374f > -1 && this.f64379a.f64375g > -1) {
                                this.f64379a.f64376h = (int) motionEvent.getX();
                                this.f64379a.f64377i = (int) motionEvent.getY();
                                if (this.f64379a.m || this.f64379a.q != null) {
                                    if (this.f64379a.q != null && (v = this.f64379a.v()) != null && (this.f64379a.q == null || !this.f64379a.q.equals(v))) {
                                        this.f64379a.z(v);
                                    }
                                } else {
                                    float f2 = this.f64379a.f64376h - this.f64379a.f64374f;
                                    float f3 = this.f64379a.f64377i - this.f64379a.f64375g;
                                    if ((f2 * f2) + (f3 * f3) > this.f64379a.f64370b * this.f64379a.f64370b) {
                                        this.f64379a.m = true;
                                    }
                                }
                            }
                            return this.f64379a.q != null;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    this.f64379a.u();
                    return false;
                }
                this.f64379a.f64374f = (int) motionEvent.getX();
                this.f64379a.f64375g = (int) motionEvent.getY();
                this.f64379a.m = false;
                this.f64379a.A();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64380e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64380e = bVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f64380e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements SwipeBackLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64381a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64381a = bVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f64381a.n = false;
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64381a.n = true;
                this.f64381a.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f64382a;

        /* renamed from: b  reason: collision with root package name */
        public int f64383b;

        /* renamed from: c  reason: collision with root package name */
        public int f64384c;

        public e(View view, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64382a = view;
            this.f64383b = i2;
            this.f64384c = i3;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == null || !(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return eVar.f64383b == this.f64383b && eVar.f64384c == this.f64384c && eVar.f64382a == this.f64382a;
            }
            return invokeL.booleanValue;
        }
    }

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionPackageDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64373e = new Rect();
        this.f64374f = -1;
        this.f64375g = -1;
        this.f64376h = -1;
        this.f64377i = -1;
        this.m = false;
        this.n = false;
        this.p = 3;
        this.r = new a(this);
        this.s = new C1628b(this);
        this.f64369a = emotionPackageDetailActivity;
        PackageDetailListView listView = emotionPackageDetailActivity.getListView();
        this.l = listView;
        listView.setTouchEventInterceptHandler(this.s);
        this.j = emotionPackageDetailActivity.getSafeHandler();
        this.l = emotionPackageDetailActivity.getListView();
        this.f64370b = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.f64371c = l.g(emotionPackageDetailActivity, R.dimen.ds240);
        this.f64372d = l.g(emotionPackageDetailActivity, R.dimen.ds260);
        this.l.setOnScrollListener(new c(this));
        SwipeBackLayout swipeBackLayout = emotionPackageDetailActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            swipeBackLayout.setOnSlidingStateChangeListener(new d(this));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.removeCallbacks(this.r);
            this.j.postDelayed(this.r, 500L);
        }
    }

    public final void B() {
        e v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m || this.n || this.q != null || (v = v()) == null) {
            return;
        }
        z(v);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.removeCallbacks(this.r);
            u();
        }
    }

    public final boolean t(View view, EmotionPackageData.SingleEmotionData singleEmotionData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, singleEmotionData)) == null) {
            if (singleEmotionData == null || TextUtils.isEmpty(singleEmotionData.url) || view == null) {
                return false;
            }
            Log.d("PackageDetailPreview", "show preview, url: " + singleEmotionData.url);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            EmotionPreview emotionPreview = new EmotionPreview(this.f64369a);
            this.k = emotionPreview;
            SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, this.p);
            this.k.e(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f64371c, this.f64372d);
            int i2 = iArr[0] - 60;
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = iArr[1] - this.f64372d;
            if (i2 < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.f64371c > l.k(this.f64369a)) {
                layoutParams.leftMargin = l.k(this.f64369a) - this.f64371c;
            }
            if (this.o == null) {
                this.o = (FrameLayout) this.f64369a.getWindow().getDecorView();
            }
            if (this.k.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.o.addView(this.k, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f64377i = -1;
            this.f64376h = -1;
            this.f64375g = -1;
            this.f64374f = -1;
            this.m = false;
            this.f64369a.setSwipeBackEnabled(true);
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview == null || this.q == null) {
                return;
            }
            if (emotionPreview.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.q = null;
            this.l.setDisableListViewTouchIntercept(false);
        }
    }

    public final e v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f64376h;
            int i3 = this.f64377i;
            if (i2 < 0) {
                i2 = this.f64374f;
            }
            if (i3 < 0) {
                i3 = this.f64375g;
            }
            int pointToPosition = this.l.pointToPosition(i2, i3);
            if (pointToPosition >= 0) {
                this.f64373e.set(i2, i3, i2 + 1, i3 + 1);
                View childAt = this.l.getChildAt(pointToPosition);
                if (childAt == null || !(childAt instanceof ViewGroup)) {
                    return null;
                }
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.l.offsetRectIntoDescendantCoords(childAt, this.f64373e);
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = viewGroup.getChildAt(i4);
                    if (childAt2.getLeft() < this.f64373e.left && childAt2.getRight() > this.f64373e.right && childAt2.getTop() < this.f64373e.left && childAt2.getBottom() > this.f64373e.bottom) {
                        int headerViewsCount = pointToPosition - this.l.getHeaderViewsCount();
                        e eVar = new e(childAt2, headerViewsCount, i4);
                        Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
                        return eVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public final EmotionPackageData.SingleEmotionData w(int i2, int i3) {
        InterceptResult invokeII;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            d.a.c.k.e.e adapter2 = this.l.getAdapter2();
            int i4 = (i2 * 4) + i3;
            int headerViewsCount = i2 + this.l.getHeaderViewsCount();
            if (adapter2 == null || headerViewsCount <= -1 || headerViewsCount >= adapter2.getCount() || (list = (List) adapter2.getItem(headerViewsCount)) == null || i4 <= -1 || i4 >= list.size()) {
                return null;
            }
            return (EmotionPackageData.SingleEmotionData) list.get(i4);
        }
        return (EmotionPackageData.SingleEmotionData) invokeII.objValue;
    }

    public final void x() {
        EmotionPreview emotionPreview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (emotionPreview = this.k) == null || this.o == null) {
            return;
        }
        if (emotionPreview.getParent() != null) {
            ViewParent parent = this.k.getParent();
            FrameLayout frameLayout = this.o;
            if (parent == frameLayout) {
                frameLayout.removeView(this.k);
            }
        }
        this.k = null;
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview != null) {
                SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, i2);
            }
        }
    }

    public final void z(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        x();
        if (t(eVar.f64382a, w(eVar.f64383b, eVar.f64384c))) {
            this.q = eVar;
            this.l.setDisableListViewTouchIntercept(true);
            this.f64369a.setSwipeBackEnabled(false);
        }
    }
}
