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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f72222a;

    /* renamed from: b  reason: collision with root package name */
    public Window f72223b;

    /* renamed from: c  reason: collision with root package name */
    public View f72224c;

    /* renamed from: d  reason: collision with root package name */
    public View f72225d;

    /* renamed from: e  reason: collision with root package name */
    public View f72226e;

    /* renamed from: f  reason: collision with root package name */
    public b f72227f;

    /* renamed from: g  reason: collision with root package name */
    public int f72228g;

    /* renamed from: h  reason: collision with root package name */
    public int f72229h;

    /* renamed from: i  reason: collision with root package name */
    public int f72230i;
    public int j;
    public int k;
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
        public final /* synthetic */ e f72231e;

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
            this.f72231e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f72231e.o) {
                Rect rect = new Rect();
                this.f72231e.f72224c.getWindowVisibleDisplayFrame(rect);
                if (this.f72231e.f72227f.B) {
                    int height2 = (this.f72231e.f72225d.getHeight() - rect.bottom) - this.f72231e.n;
                    if (this.f72231e.f72227f.D != null) {
                        this.f72231e.f72227f.D.a(height2 > this.f72231e.n, height2);
                    }
                } else if (this.f72231e.f72226e != null) {
                    if (this.f72231e.f72227f.w) {
                        height = this.f72231e.f72225d.getHeight() + this.f72231e.l + this.f72231e.m;
                        i5 = rect.bottom;
                    } else if (this.f72231e.f72227f.r) {
                        height = this.f72231e.f72225d.getHeight() + this.f72231e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f72231e.f72225d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f72231e.f72227f.f72206i ? i6 - this.f72231e.n : i6;
                    if (this.f72231e.f72227f.f72206i && i6 == this.f72231e.n) {
                        i6 -= this.f72231e.n;
                    }
                    if (i7 != this.f72231e.k) {
                        this.f72231e.f72225d.setPadding(this.f72231e.f72228g, this.f72231e.f72229h, this.f72231e.f72230i, i6 + this.f72231e.j);
                        this.f72231e.k = i7;
                        if (this.f72231e.f72227f.D != null) {
                            this.f72231e.f72227f.D.a(i7 > this.f72231e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f72231e.f72225d.getHeight() - rect.bottom;
                    if (this.f72231e.f72227f.z && this.f72231e.f72227f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f72231e.n;
                        } else if (!this.f72231e.f72227f.f72206i) {
                            i4 = height3;
                            if (this.f72231e.f72227f.f72206i && height3 == this.f72231e.n) {
                                height3 -= this.f72231e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f72231e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f72231e.f72227f.f72206i) {
                            height3 -= this.f72231e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f72231e.k) {
                        if (this.f72231e.f72227f.w) {
                            this.f72231e.f72225d.setPadding(0, this.f72231e.l + this.f72231e.m, 0, i2);
                        } else if (this.f72231e.f72227f.r) {
                            this.f72231e.f72225d.setPadding(0, this.f72231e.l, 0, i2);
                        } else {
                            this.f72231e.f72225d.setPadding(0, 0, 0, i2);
                        }
                        this.f72231e.k = height3;
                        if (this.f72231e.f72227f.D != null) {
                            this.f72231e.f72227f.D.a(height3 > this.f72231e.n, height3);
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
        this.f72222a = activity;
        this.f72223b = window;
        View decorView = window.getDecorView();
        this.f72224c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f72226e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f72225d = frameLayout;
        this.f72228g = frameLayout.getPaddingLeft();
        this.f72229h = this.f72225d.getPaddingTop();
        this.f72230i = this.f72225d.getPaddingRight();
        this.j = this.f72225d.getPaddingBottom();
        i.a.a.e.i.a.a aVar = new i.a.a.e.i.a.a(this.f72222a);
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
                this.f72223b.setSoftInputMode(i2);
                this.f72224c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f72222a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f72223b.setSoftInputMode(i2);
        this.f72224c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f72227f = bVar;
        }
    }
}
