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
    public Activity f78843a;

    /* renamed from: b  reason: collision with root package name */
    public Window f78844b;

    /* renamed from: c  reason: collision with root package name */
    public View f78845c;

    /* renamed from: d  reason: collision with root package name */
    public View f78846d;

    /* renamed from: e  reason: collision with root package name */
    public View f78847e;

    /* renamed from: f  reason: collision with root package name */
    public b f78848f;

    /* renamed from: g  reason: collision with root package name */
    public int f78849g;

    /* renamed from: h  reason: collision with root package name */
    public int f78850h;

    /* renamed from: i  reason: collision with root package name */
    public int f78851i;

    /* renamed from: j  reason: collision with root package name */
    public int f78852j;
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
        public final /* synthetic */ e f78853e;

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
            this.f78853e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f78853e.o) {
                Rect rect = new Rect();
                this.f78853e.f78845c.getWindowVisibleDisplayFrame(rect);
                if (this.f78853e.f78848f.B) {
                    int height2 = (this.f78853e.f78846d.getHeight() - rect.bottom) - this.f78853e.n;
                    if (this.f78853e.f78848f.D != null) {
                        this.f78853e.f78848f.D.a(height2 > this.f78853e.n, height2);
                    }
                } else if (this.f78853e.f78847e != null) {
                    if (this.f78853e.f78848f.w) {
                        height = this.f78853e.f78846d.getHeight() + this.f78853e.l + this.f78853e.m;
                        i5 = rect.bottom;
                    } else if (this.f78853e.f78848f.r) {
                        height = this.f78853e.f78846d.getHeight() + this.f78853e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f78853e.f78846d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f78853e.f78848f.f78825i ? i6 - this.f78853e.n : i6;
                    if (this.f78853e.f78848f.f78825i && i6 == this.f78853e.n) {
                        i6 -= this.f78853e.n;
                    }
                    if (i7 != this.f78853e.k) {
                        this.f78853e.f78846d.setPadding(this.f78853e.f78849g, this.f78853e.f78850h, this.f78853e.f78851i, i6 + this.f78853e.f78852j);
                        this.f78853e.k = i7;
                        if (this.f78853e.f78848f.D != null) {
                            this.f78853e.f78848f.D.a(i7 > this.f78853e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f78853e.f78846d.getHeight() - rect.bottom;
                    if (this.f78853e.f78848f.z && this.f78853e.f78848f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f78853e.n;
                        } else if (!this.f78853e.f78848f.f78825i) {
                            i4 = height3;
                            if (this.f78853e.f78848f.f78825i && height3 == this.f78853e.n) {
                                height3 -= this.f78853e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f78853e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f78853e.f78848f.f78825i) {
                            height3 -= this.f78853e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f78853e.k) {
                        if (this.f78853e.f78848f.w) {
                            this.f78853e.f78846d.setPadding(0, this.f78853e.l + this.f78853e.m, 0, i2);
                        } else if (this.f78853e.f78848f.r) {
                            this.f78853e.f78846d.setPadding(0, this.f78853e.l, 0, i2);
                        } else {
                            this.f78853e.f78846d.setPadding(0, 0, 0, i2);
                        }
                        this.f78853e.k = height3;
                        if (this.f78853e.f78848f.D != null) {
                            this.f78853e.f78848f.D.a(height3 > this.f78853e.n, height3);
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
        this.f78843a = activity;
        this.f78844b = window;
        View decorView = window.getDecorView();
        this.f78845c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f78847e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f78846d = frameLayout;
        this.f78849g = frameLayout.getPaddingLeft();
        this.f78850h = this.f78846d.getPaddingTop();
        this.f78851i = this.f78846d.getPaddingRight();
        this.f78852j = this.f78846d.getPaddingBottom();
        j.a.a.e.i.a.a aVar = new j.a.a.e.i.a.a(this.f78843a);
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
                this.f78844b.setSoftInputMode(i2);
                this.f78845c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.f78843a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f78844b.setSoftInputMode(i2);
        this.f78845c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f78848f = bVar;
        }
    }
}
