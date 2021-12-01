package j.a.a.e.i.a;

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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Window f64085b;

    /* renamed from: c  reason: collision with root package name */
    public View f64086c;

    /* renamed from: d  reason: collision with root package name */
    public View f64087d;

    /* renamed from: e  reason: collision with root package name */
    public View f64088e;

    /* renamed from: f  reason: collision with root package name */
    public b f64089f;

    /* renamed from: g  reason: collision with root package name */
    public int f64090g;

    /* renamed from: h  reason: collision with root package name */
    public int f64091h;

    /* renamed from: i  reason: collision with root package name */
    public int f64092i;

    /* renamed from: j  reason: collision with root package name */
    public int f64093j;

    /* renamed from: k  reason: collision with root package name */
    public int f64094k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64095e;

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
            this.f64095e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64095e.o) {
                Rect rect = new Rect();
                this.f64095e.f64086c.getWindowVisibleDisplayFrame(rect);
                if (this.f64095e.f64089f.B) {
                    int height2 = (this.f64095e.f64087d.getHeight() - rect.bottom) - this.f64095e.n;
                    if (this.f64095e.f64089f.D != null) {
                        this.f64095e.f64089f.D.a(height2 > this.f64095e.n, height2);
                    }
                } else if (this.f64095e.f64088e != null) {
                    if (this.f64095e.f64089f.w) {
                        height = this.f64095e.f64087d.getHeight() + this.f64095e.l + this.f64095e.m;
                        i5 = rect.bottom;
                    } else if (this.f64095e.f64089f.r) {
                        height = this.f64095e.f64087d.getHeight() + this.f64095e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f64095e.f64087d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f64095e.f64089f.f64069i ? i6 - this.f64095e.n : i6;
                    if (this.f64095e.f64089f.f64069i && i6 == this.f64095e.n) {
                        i6 -= this.f64095e.n;
                    }
                    if (i7 != this.f64095e.f64094k) {
                        this.f64095e.f64087d.setPadding(this.f64095e.f64090g, this.f64095e.f64091h, this.f64095e.f64092i, i6 + this.f64095e.f64093j);
                        this.f64095e.f64094k = i7;
                        if (this.f64095e.f64089f.D != null) {
                            this.f64095e.f64089f.D.a(i7 > this.f64095e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f64095e.f64087d.getHeight() - rect.bottom;
                    if (this.f64095e.f64089f.z && this.f64095e.f64089f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f64095e.n;
                        } else if (!this.f64095e.f64089f.f64069i) {
                            i4 = height3;
                            if (this.f64095e.f64089f.f64069i && height3 == this.f64095e.n) {
                                height3 -= this.f64095e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f64095e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f64095e.f64089f.f64069i) {
                            height3 -= this.f64095e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f64095e.f64094k) {
                        if (this.f64095e.f64089f.w) {
                            this.f64095e.f64087d.setPadding(0, this.f64095e.l + this.f64095e.m, 0, i2);
                        } else if (this.f64095e.f64089f.r) {
                            this.f64095e.f64087d.setPadding(0, this.f64095e.l, 0, i2);
                        } else {
                            this.f64095e.f64087d.setPadding(0, 0, 0, i2);
                        }
                        this.f64095e.f64094k = height3;
                        if (this.f64095e.f64089f.D != null) {
                            this.f64095e.f64089f.D.a(height3 > this.f64095e.n, height3);
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
        this.f64085b = window;
        View decorView = window.getDecorView();
        this.f64086c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f64088e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f64087d = frameLayout;
        this.f64090g = frameLayout.getPaddingLeft();
        this.f64091h = this.f64087d.getPaddingTop();
        this.f64092i = this.f64087d.getPaddingRight();
        this.f64093j = this.f64087d.getPaddingBottom();
        j.a.a.e.i.a.a aVar = new j.a.a.e.i.a.a(this.a);
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
                this.f64085b.setSoftInputMode(i2);
                this.f64086c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f64085b.setSoftInputMode(i2);
        this.f64086c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f64089f = bVar;
        }
    }
}
