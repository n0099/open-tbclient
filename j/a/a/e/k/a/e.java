package j.a.a.e.k.a;

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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Window f62279b;

    /* renamed from: c  reason: collision with root package name */
    public View f62280c;

    /* renamed from: d  reason: collision with root package name */
    public View f62281d;

    /* renamed from: e  reason: collision with root package name */
    public View f62282e;

    /* renamed from: f  reason: collision with root package name */
    public b f62283f;

    /* renamed from: g  reason: collision with root package name */
    public int f62284g;

    /* renamed from: h  reason: collision with root package name */
    public int f62285h;

    /* renamed from: i  reason: collision with root package name */
    public int f62286i;

    /* renamed from: j  reason: collision with root package name */
    public int f62287j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f62288e;

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
            this.f62288e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62288e.o) {
                Rect rect = new Rect();
                this.f62288e.f62280c.getWindowVisibleDisplayFrame(rect);
                if (this.f62288e.f62283f.B) {
                    int height2 = (this.f62288e.f62281d.getHeight() - rect.bottom) - this.f62288e.n;
                    if (this.f62288e.f62283f.D != null) {
                        this.f62288e.f62283f.D.a(height2 > this.f62288e.n, height2);
                    }
                } else if (this.f62288e.f62282e != null) {
                    if (this.f62288e.f62283f.w) {
                        height = this.f62288e.f62281d.getHeight() + this.f62288e.l + this.f62288e.m;
                        i5 = rect.bottom;
                    } else if (this.f62288e.f62283f.r) {
                        height = this.f62288e.f62281d.getHeight() + this.f62288e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f62288e.f62281d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f62288e.f62283f.f62265i ? i6 - this.f62288e.n : i6;
                    if (this.f62288e.f62283f.f62265i && i6 == this.f62288e.n) {
                        i6 -= this.f62288e.n;
                    }
                    if (i7 != this.f62288e.k) {
                        this.f62288e.f62281d.setPadding(this.f62288e.f62284g, this.f62288e.f62285h, this.f62288e.f62286i, i6 + this.f62288e.f62287j);
                        this.f62288e.k = i7;
                        if (this.f62288e.f62283f.D != null) {
                            this.f62288e.f62283f.D.a(i7 > this.f62288e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f62288e.f62281d.getHeight() - rect.bottom;
                    if (this.f62288e.f62283f.z && this.f62288e.f62283f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f62288e.n;
                        } else if (!this.f62288e.f62283f.f62265i) {
                            i4 = height3;
                            if (this.f62288e.f62283f.f62265i && height3 == this.f62288e.n) {
                                height3 -= this.f62288e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f62288e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f62288e.f62283f.f62265i) {
                            height3 -= this.f62288e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f62288e.k) {
                        if (this.f62288e.f62283f.w) {
                            this.f62288e.f62281d.setPadding(0, this.f62288e.l + this.f62288e.m, 0, i2);
                        } else if (this.f62288e.f62283f.r) {
                            this.f62288e.f62281d.setPadding(0, this.f62288e.l, 0, i2);
                        } else {
                            this.f62288e.f62281d.setPadding(0, 0, 0, i2);
                        }
                        this.f62288e.k = height3;
                        if (this.f62288e.f62283f.D != null) {
                            this.f62288e.f62283f.D.a(height3 > this.f62288e.n, height3);
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
        this.a = activity;
        this.f62279b = window;
        View decorView = window.getDecorView();
        this.f62280c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f62282e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f62281d = frameLayout;
        this.f62284g = frameLayout.getPaddingLeft();
        this.f62285h = this.f62281d.getPaddingTop();
        this.f62286i = this.f62281d.getPaddingRight();
        this.f62287j = this.f62281d.getPaddingBottom();
        j.a.a.e.k.a.a aVar = new j.a.a.e.k.a.a(this.a);
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
                this.f62279b.setSoftInputMode(i2);
                this.f62280c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f62279b.setSoftInputMode(i2);
        this.f62280c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f62283f = bVar;
        }
    }
}
