package j.a.a.e.c.a;

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
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Window f60796b;

    /* renamed from: c  reason: collision with root package name */
    public View f60797c;

    /* renamed from: d  reason: collision with root package name */
    public View f60798d;

    /* renamed from: e  reason: collision with root package name */
    public View f60799e;

    /* renamed from: f  reason: collision with root package name */
    public b f60800f;

    /* renamed from: g  reason: collision with root package name */
    public int f60801g;

    /* renamed from: h  reason: collision with root package name */
    public int f60802h;

    /* renamed from: i  reason: collision with root package name */
    public int f60803i;

    /* renamed from: j  reason: collision with root package name */
    public int f60804j;
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
        public final /* synthetic */ e f60805e;

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
            this.f60805e = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f60805e.o) {
                Rect rect = new Rect();
                this.f60805e.f60797c.getWindowVisibleDisplayFrame(rect);
                if (this.f60805e.f60800f.B) {
                    int height2 = (this.f60805e.f60798d.getHeight() - rect.bottom) - this.f60805e.n;
                    if (this.f60805e.f60800f.D != null) {
                        this.f60805e.f60800f.D.a(height2 > this.f60805e.n, height2);
                    }
                } else if (this.f60805e.f60799e != null) {
                    if (this.f60805e.f60800f.w) {
                        height = this.f60805e.f60798d.getHeight() + this.f60805e.l + this.f60805e.m;
                        i5 = rect.bottom;
                    } else if (this.f60805e.f60800f.r) {
                        height = this.f60805e.f60798d.getHeight() + this.f60805e.l;
                        i5 = rect.bottom;
                    } else {
                        height = this.f60805e.f60798d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = this.f60805e.f60800f.f60782i ? i6 - this.f60805e.n : i6;
                    if (this.f60805e.f60800f.f60782i && i6 == this.f60805e.n) {
                        i6 -= this.f60805e.n;
                    }
                    if (i7 != this.f60805e.k) {
                        this.f60805e.f60798d.setPadding(this.f60805e.f60801g, this.f60805e.f60802h, this.f60805e.f60803i, i6 + this.f60805e.f60804j);
                        this.f60805e.k = i7;
                        if (this.f60805e.f60800f.D != null) {
                            this.f60805e.f60800f.D.a(i7 > this.f60805e.n, i7);
                        }
                    }
                } else {
                    int height3 = this.f60805e.f60798d.getHeight() - rect.bottom;
                    if (this.f60805e.f60800f.z && this.f60805e.f60800f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = this.f60805e.n;
                        } else if (!this.f60805e.f60800f.f60782i) {
                            i4 = height3;
                            if (this.f60805e.f60800f.f60782i && height3 == this.f60805e.n) {
                                height3 -= this.f60805e.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = this.f60805e.n;
                        }
                        i4 = height3 - i3;
                        if (this.f60805e.f60800f.f60782i) {
                            height3 -= this.f60805e.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != this.f60805e.k) {
                        if (this.f60805e.f60800f.w) {
                            this.f60805e.f60798d.setPadding(0, this.f60805e.l + this.f60805e.m, 0, i2);
                        } else if (this.f60805e.f60800f.r) {
                            this.f60805e.f60798d.setPadding(0, this.f60805e.l, 0, i2);
                        } else {
                            this.f60805e.f60798d.setPadding(0, 0, 0, i2);
                        }
                        this.f60805e.k = height3;
                        if (this.f60805e.f60800f.D != null) {
                            this.f60805e.f60800f.D.a(height3 > this.f60805e.n, height3);
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
        this.f60796b = window;
        View decorView = window.getDecorView();
        this.f60797c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f60799e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f60798d = frameLayout;
        this.f60801g = frameLayout.getPaddingLeft();
        this.f60802h = this.f60798d.getPaddingTop();
        this.f60803i = this.f60798d.getPaddingRight();
        this.f60804j = this.f60798d.getPaddingBottom();
        j.a.a.e.c.a.a aVar = new j.a.a.e.c.a.a(this.a);
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
                this.f60796b.setSoftInputMode(i2);
                this.f60797c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
            }
            this.a = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f60796b.setSoftInputMode(i2);
        this.f60797c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f60800f = bVar;
        }
    }
}
