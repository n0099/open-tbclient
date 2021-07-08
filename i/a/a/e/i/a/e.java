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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f72805a;

    /* renamed from: b  reason: collision with root package name */
    public Window f72806b;

    /* renamed from: c  reason: collision with root package name */
    public View f72807c;

    /* renamed from: d  reason: collision with root package name */
    public View f72808d;

    /* renamed from: e  reason: collision with root package name */
    public View f72809e;

    /* renamed from: f  reason: collision with root package name */
    public b f72810f;

    /* renamed from: g  reason: collision with root package name */
    public int f72811g;

    /* renamed from: h  reason: collision with root package name */
    public int f72812h;

    /* renamed from: i  reason: collision with root package name */
    public int f72813i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f72814e;

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
            this.f72814e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f72814e.o) {
                Rect rect = new Rect();
                this.f72814e.f72807c.getWindowVisibleDisplayFrame(rect);
                if (this.f72814e.f72810f.B) {
                    int height2 = (this.f72814e.f72808d.getHeight() - rect.bottom) - this.f72814e.n;
                    if (this.f72814e.f72810f.D != null) {
                        this.f72814e.f72810f.D.a(height2 > this.f72814e.n, height2);
                    }
                } else if (this.f72814e.f72809e != null) {
                    if (this.f72814e.f72810f.w) {
                        height = this.f72814e.f72808d.getHeight() + this.f72814e.l + this.f72814e.m;
                        i5 = rect.bottom;
                    } else if (this.f72814e.f72810f.r) {
                        height = this.f72814e.f72808d.getHeight() + this.f72814e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f72814e.f72808d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f72814e.f72810f.f72789i ? i6 - this.f72814e.n : i6;
                    if (this.f72814e.f72810f.f72789i && i6 == this.f72814e.n) {
                        i6 -= this.f72814e.n;
                    }
                    if (i7 != this.f72814e.k) {
                        this.f72814e.f72808d.setPadding(this.f72814e.f72811g, this.f72814e.f72812h, this.f72814e.f72813i, i6 + this.f72814e.j);
                        this.f72814e.k = i7;
                        if (this.f72814e.f72810f.D != null) {
                            this.f72814e.f72810f.D.a(i7 > this.f72814e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f72814e.f72808d.getHeight() - rect.bottom;
                    if (this.f72814e.f72810f.z && this.f72814e.f72810f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f72814e.n;
                        } else if (!this.f72814e.f72810f.f72789i) {
                            i4 = height3;
                            if (this.f72814e.f72810f.f72789i && height3 == this.f72814e.n) {
                                height3 -= this.f72814e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f72814e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f72814e.f72810f.f72789i) {
                            height3 -= this.f72814e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f72814e.k) {
                        if (this.f72814e.f72810f.w) {
                            this.f72814e.f72808d.setPadding(0, this.f72814e.l + this.f72814e.m, 0, i2);
                        } else if (this.f72814e.f72810f.r) {
                            this.f72814e.f72808d.setPadding(0, this.f72814e.l, 0, i2);
                        } else {
                            this.f72814e.f72808d.setPadding(0, 0, 0, i2);
                        }
                        this.f72814e.k = height3;
                        if (this.f72814e.f72810f.D != null) {
                            this.f72814e.f72810f.D.a(height3 > this.f72814e.n, height3);
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
        this.f72805a = activity;
        this.f72806b = window;
        View decorView = window.getDecorView();
        this.f72807c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f72809e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f72808d = frameLayout;
        this.f72811g = frameLayout.getPaddingLeft();
        this.f72812h = this.f72808d.getPaddingTop();
        this.f72813i = this.f72808d.getPaddingRight();
        this.j = this.f72808d.getPaddingBottom();
        i.a.a.e.i.a.a aVar = new i.a.a.e.i.a.a(this.f72805a);
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
                this.f72806b.setSoftInputMode(i2);
                this.f72807c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f72805a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f72806b.setSoftInputMode(i2);
        this.f72807c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f72810f = bVar;
        }
    }
}
