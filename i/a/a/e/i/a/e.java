package i.a.a.e.i.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f73259a;

    /* renamed from: b  reason: collision with root package name */
    public Window f73260b;

    /* renamed from: c  reason: collision with root package name */
    public View f73261c;

    /* renamed from: d  reason: collision with root package name */
    public View f73262d;

    /* renamed from: e  reason: collision with root package name */
    public View f73263e;

    /* renamed from: f  reason: collision with root package name */
    public b f73264f;

    /* renamed from: g  reason: collision with root package name */
    public int f73265g;

    /* renamed from: h  reason: collision with root package name */
    public int f73266h;

    /* renamed from: i  reason: collision with root package name */
    public int f73267i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f73268e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73268e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73268e.o) {
                Rect rect = new Rect();
                this.f73268e.f73261c.getWindowVisibleDisplayFrame(rect);
                if (this.f73268e.f73264f.B) {
                    int height2 = (this.f73268e.f73262d.getHeight() - rect.bottom) - this.f73268e.n;
                    if (this.f73268e.f73264f.D != null) {
                        this.f73268e.f73264f.D.a(height2 > this.f73268e.n, height2);
                    }
                } else if (this.f73268e.f73263e != null) {
                    if (this.f73268e.f73264f.w) {
                        height = this.f73268e.f73262d.getHeight() + this.f73268e.l + this.f73268e.m;
                        i5 = rect.bottom;
                    } else if (this.f73268e.f73264f.r) {
                        height = this.f73268e.f73262d.getHeight() + this.f73268e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f73268e.f73262d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f73268e.f73264f.f73243i ? i6 - this.f73268e.n : i6;
                    if (this.f73268e.f73264f.f73243i && i6 == this.f73268e.n) {
                        i6 -= this.f73268e.n;
                    }
                    if (i7 != this.f73268e.k) {
                        this.f73268e.f73262d.setPadding(this.f73268e.f73265g, this.f73268e.f73266h, this.f73268e.f73267i, i6 + this.f73268e.j);
                        this.f73268e.k = i7;
                        if (this.f73268e.f73264f.D != null) {
                            this.f73268e.f73264f.D.a(i7 > this.f73268e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f73268e.f73262d.getHeight() - rect.bottom;
                    if (this.f73268e.f73264f.z && this.f73268e.f73264f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f73268e.n;
                        } else if (!this.f73268e.f73264f.f73243i) {
                            i4 = height3;
                            if (this.f73268e.f73264f.f73243i && height3 == this.f73268e.n) {
                                height3 -= this.f73268e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f73268e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f73268e.f73264f.f73243i) {
                            height3 -= this.f73268e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f73268e.k) {
                        if (this.f73268e.f73264f.w) {
                            this.f73268e.f73262d.setPadding(0, this.f73268e.l + this.f73268e.m, 0, i2);
                        } else if (this.f73268e.f73264f.r) {
                            this.f73268e.f73262d.setPadding(0, this.f73268e.l, 0, i2);
                        } else {
                            this.f73268e.f73262d.setPadding(0, 0, 0, i2);
                        }
                        this.f73268e.k = height3;
                        if (this.f73268e.f73264f.D != null) {
                            this.f73268e.f73264f.D.a(height3 > this.f73268e.n, height3);
                        }
                    }
                }
            }
        }
    }

    public e(Activity activity, Window window) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, window};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.f73259a = activity;
        this.f73260b = window;
        View decorView = window.getDecorView();
        this.f73261c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f73263e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f73262d = frameLayout;
        this.f73265g = frameLayout.getPaddingLeft();
        this.f73266h = this.f73262d.getPaddingTop();
        this.f73267i = this.f73262d.getPaddingRight();
        this.j = this.f73262d.getPaddingBottom();
        i.a.a.e.i.a.a aVar = new i.a.a.e.i.a.a(this.f73259a);
        this.l = aVar.i();
        this.n = aVar.d();
        this.m = aVar.a();
        this.o = aVar.l();
    }

    public static e q(Activity activity, Window window) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, activity, window)) == null) ? new e(activity, window) : (e) invokeLL.objValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f73260b.setSoftInputMode(i2);
                this.f73261c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f73259a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f73260b.setSoftInputMode(i2);
        this.f73261c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f73264f = bVar;
        }
    }
}
