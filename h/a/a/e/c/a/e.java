package h.a.a.e.c.a;

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
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Window f45110b;

    /* renamed from: c  reason: collision with root package name */
    public View f45111c;

    /* renamed from: d  reason: collision with root package name */
    public View f45112d;

    /* renamed from: e  reason: collision with root package name */
    public View f45113e;

    /* renamed from: f  reason: collision with root package name */
    public b f45114f;

    /* renamed from: g  reason: collision with root package name */
    public int f45115g;

    /* renamed from: h  reason: collision with root package name */
    public int f45116h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int i2;
            int i3;
            int height;
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.o) {
                Rect rect = new Rect();
                this.a.f45111c.getWindowVisibleDisplayFrame(rect);
                if (this.a.f45114f.x) {
                    int height2 = (this.a.f45112d.getHeight() - rect.bottom) - this.a.n;
                    if (this.a.f45114f.z != null) {
                        this.a.f45114f.z.a(height2 > this.a.n, height2);
                    }
                } else if (this.a.f45113e != null) {
                    if (this.a.f45114f.s) {
                        height = this.a.f45112d.getHeight() + this.a.l + this.a.m;
                        i4 = rect.bottom;
                    } else if (this.a.f45114f.n) {
                        height = this.a.f45112d.getHeight() + this.a.l;
                        i4 = rect.bottom;
                    } else {
                        height = this.a.f45112d.getHeight();
                        i4 = rect.bottom;
                    }
                    int i5 = height - i4;
                    int i6 = this.a.f45114f.f45096e ? i5 - this.a.n : i5;
                    if (this.a.f45114f.f45096e && i5 == this.a.n) {
                        i5 -= this.a.n;
                    }
                    if (i6 != this.a.k) {
                        this.a.f45112d.setPadding(this.a.f45115g, this.a.f45116h, this.a.i, i5 + this.a.j);
                        this.a.k = i6;
                        if (this.a.f45114f.z != null) {
                            this.a.f45114f.z.a(i6 > this.a.n, i6);
                        }
                    }
                } else {
                    int height3 = this.a.f45112d.getHeight() - rect.bottom;
                    if (this.a.f45114f.v && this.a.f45114f.w) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i2 = this.a.n;
                        } else if (!this.a.f45114f.f45096e) {
                            i3 = height3;
                            if (this.a.f45114f.f45096e && height3 == this.a.n) {
                                height3 -= this.a.n;
                            }
                            int i7 = height3;
                            height3 = i3;
                            i = i7;
                        } else {
                            i2 = this.a.n;
                        }
                        i3 = height3 - i2;
                        if (this.a.f45114f.f45096e) {
                            height3 -= this.a.n;
                        }
                        int i72 = height3;
                        height3 = i3;
                        i = i72;
                    } else {
                        i = height3;
                    }
                    if (height3 != this.a.k) {
                        if (this.a.f45114f.s) {
                            this.a.f45112d.setPadding(0, this.a.l + this.a.m, 0, i);
                        } else if (this.a.f45114f.n) {
                            this.a.f45112d.setPadding(0, this.a.l, 0, i);
                        } else {
                            this.a.f45112d.setPadding(0, 0, 0, i);
                        }
                        this.a.k = height3;
                        if (this.a.f45114f.z != null) {
                            this.a.f45114f.z.a(height3 > this.a.n, height3);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.a = activity;
        this.f45110b = window;
        View decorView = window.getDecorView();
        this.f45111c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f45113e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f45112d = frameLayout;
        this.f45115g = frameLayout.getPaddingLeft();
        this.f45116h = this.f45112d.getPaddingTop();
        this.i = this.f45112d.getPaddingRight();
        this.j = this.f45112d.getPaddingBottom();
        h.a.a.e.c.a.a aVar = new h.a.a.e.c.a.a(this.a);
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

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f45110b.setSoftInputMode(i);
                this.f45111c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.a = null;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f45110b.setSoftInputMode(i);
        this.f45111c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f45114f = bVar;
        }
    }
}
