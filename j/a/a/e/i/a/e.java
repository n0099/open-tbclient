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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f79400a;

    /* renamed from: b  reason: collision with root package name */
    public Window f79401b;

    /* renamed from: c  reason: collision with root package name */
    public View f79402c;

    /* renamed from: d  reason: collision with root package name */
    public View f79403d;

    /* renamed from: e  reason: collision with root package name */
    public View f79404e;

    /* renamed from: f  reason: collision with root package name */
    public b f79405f;

    /* renamed from: g  reason: collision with root package name */
    public int f79406g;

    /* renamed from: h  reason: collision with root package name */
    public int f79407h;

    /* renamed from: i  reason: collision with root package name */
    public int f79408i;

    /* renamed from: j  reason: collision with root package name */
    public int f79409j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f79410e;

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
            this.f79410e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f79410e.o) {
                Rect rect = new Rect();
                this.f79410e.f79402c.getWindowVisibleDisplayFrame(rect);
                if (this.f79410e.f79405f.B) {
                    int height2 = (this.f79410e.f79403d.getHeight() - rect.bottom) - this.f79410e.n;
                    if (this.f79410e.f79405f.D != null) {
                        this.f79410e.f79405f.D.a(height2 > this.f79410e.n, height2);
                    }
                } else if (this.f79410e.f79404e != null) {
                    if (this.f79410e.f79405f.w) {
                        height = this.f79410e.f79403d.getHeight() + this.f79410e.l + this.f79410e.m;
                        i5 = rect.bottom;
                    } else if (this.f79410e.f79405f.r) {
                        height = this.f79410e.f79403d.getHeight() + this.f79410e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f79410e.f79403d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f79410e.f79405f.f79382i ? i6 - this.f79410e.n : i6;
                    if (this.f79410e.f79405f.f79382i && i6 == this.f79410e.n) {
                        i6 -= this.f79410e.n;
                    }
                    if (i7 != this.f79410e.k) {
                        this.f79410e.f79403d.setPadding(this.f79410e.f79406g, this.f79410e.f79407h, this.f79410e.f79408i, i6 + this.f79410e.f79409j);
                        this.f79410e.k = i7;
                        if (this.f79410e.f79405f.D != null) {
                            this.f79410e.f79405f.D.a(i7 > this.f79410e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f79410e.f79403d.getHeight() - rect.bottom;
                    if (this.f79410e.f79405f.z && this.f79410e.f79405f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f79410e.n;
                        } else if (!this.f79410e.f79405f.f79382i) {
                            i4 = height3;
                            if (this.f79410e.f79405f.f79382i && height3 == this.f79410e.n) {
                                height3 -= this.f79410e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f79410e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f79410e.f79405f.f79382i) {
                            height3 -= this.f79410e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f79410e.k) {
                        if (this.f79410e.f79405f.w) {
                            this.f79410e.f79403d.setPadding(0, this.f79410e.l + this.f79410e.m, 0, i2);
                        } else if (this.f79410e.f79405f.r) {
                            this.f79410e.f79403d.setPadding(0, this.f79410e.l, 0, i2);
                        } else {
                            this.f79410e.f79403d.setPadding(0, 0, 0, i2);
                        }
                        this.f79410e.k = height3;
                        if (this.f79410e.f79405f.D != null) {
                            this.f79410e.f79405f.D.a(height3 > this.f79410e.n, height3);
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
        this.f79400a = activity;
        this.f79401b = window;
        View decorView = window.getDecorView();
        this.f79402c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f79404e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f79403d = frameLayout;
        this.f79406g = frameLayout.getPaddingLeft();
        this.f79407h = this.f79403d.getPaddingTop();
        this.f79408i = this.f79403d.getPaddingRight();
        this.f79409j = this.f79403d.getPaddingBottom();
        j.a.a.e.i.a.a aVar = new j.a.a.e.i.a.a(this.f79400a);
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
                this.f79401b.setSoftInputMode(i2);
                this.f79402c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f79400a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f79401b.setSoftInputMode(i2);
        this.f79402c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f79405f = bVar;
        }
    }
}
