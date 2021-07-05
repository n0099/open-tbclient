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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f75771a;

    /* renamed from: b  reason: collision with root package name */
    public Window f75772b;

    /* renamed from: c  reason: collision with root package name */
    public View f75773c;

    /* renamed from: d  reason: collision with root package name */
    public View f75774d;

    /* renamed from: e  reason: collision with root package name */
    public View f75775e;

    /* renamed from: f  reason: collision with root package name */
    public b f75776f;

    /* renamed from: g  reason: collision with root package name */
    public int f75777g;

    /* renamed from: h  reason: collision with root package name */
    public int f75778h;

    /* renamed from: i  reason: collision with root package name */
    public int f75779i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes10.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f75780e;

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
            this.f75780e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f75780e.o) {
                Rect rect = new Rect();
                this.f75780e.f75773c.getWindowVisibleDisplayFrame(rect);
                if (this.f75780e.f75776f.B) {
                    int height2 = (this.f75780e.f75774d.getHeight() - rect.bottom) - this.f75780e.n;
                    if (this.f75780e.f75776f.D != null) {
                        this.f75780e.f75776f.D.a(height2 > this.f75780e.n, height2);
                    }
                } else if (this.f75780e.f75775e != null) {
                    if (this.f75780e.f75776f.w) {
                        height = this.f75780e.f75774d.getHeight() + this.f75780e.l + this.f75780e.m;
                        i5 = rect.bottom;
                    } else if (this.f75780e.f75776f.r) {
                        height = this.f75780e.f75774d.getHeight() + this.f75780e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f75780e.f75774d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f75780e.f75776f.f75755i ? i6 - this.f75780e.n : i6;
                    if (this.f75780e.f75776f.f75755i && i6 == this.f75780e.n) {
                        i6 -= this.f75780e.n;
                    }
                    if (i7 != this.f75780e.k) {
                        this.f75780e.f75774d.setPadding(this.f75780e.f75777g, this.f75780e.f75778h, this.f75780e.f75779i, i6 + this.f75780e.j);
                        this.f75780e.k = i7;
                        if (this.f75780e.f75776f.D != null) {
                            this.f75780e.f75776f.D.a(i7 > this.f75780e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f75780e.f75774d.getHeight() - rect.bottom;
                    if (this.f75780e.f75776f.z && this.f75780e.f75776f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f75780e.n;
                        } else if (!this.f75780e.f75776f.f75755i) {
                            i4 = height3;
                            if (this.f75780e.f75776f.f75755i && height3 == this.f75780e.n) {
                                height3 -= this.f75780e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f75780e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f75780e.f75776f.f75755i) {
                            height3 -= this.f75780e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f75780e.k) {
                        if (this.f75780e.f75776f.w) {
                            this.f75780e.f75774d.setPadding(0, this.f75780e.l + this.f75780e.m, 0, i2);
                        } else if (this.f75780e.f75776f.r) {
                            this.f75780e.f75774d.setPadding(0, this.f75780e.l, 0, i2);
                        } else {
                            this.f75780e.f75774d.setPadding(0, 0, 0, i2);
                        }
                        this.f75780e.k = height3;
                        if (this.f75780e.f75776f.D != null) {
                            this.f75780e.f75776f.D.a(height3 > this.f75780e.n, height3);
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
        this.f75771a = activity;
        this.f75772b = window;
        View decorView = window.getDecorView();
        this.f75773c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f75775e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f75774d = frameLayout;
        this.f75777g = frameLayout.getPaddingLeft();
        this.f75778h = this.f75774d.getPaddingTop();
        this.f75779i = this.f75774d.getPaddingRight();
        this.j = this.f75774d.getPaddingBottom();
        i.a.a.e.i.a.a aVar = new i.a.a.e.i.a.a(this.f75771a);
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
                this.f75772b.setSoftInputMode(i2);
                this.f75773c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f75771a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f75772b.setSoftInputMode(i2);
        this.f75773c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f75776f = bVar;
        }
    }
}
