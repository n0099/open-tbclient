package d.a.o0.a.w1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.w1.j.e;
import d.a.o0.a.w1.j.g;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48739e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f48740a;

    /* renamed from: b  reason: collision with root package name */
    public final View f48741b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.w1.k.a f48742c;

    /* renamed from: d  reason: collision with root package name */
    public Context f48743d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(903593884, "Ld/a/o0/a/w1/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(903593884, "Ld/a/o0/a/w1/i/c;");
                return;
            }
        }
        f48739e = k.f46335a;
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48740a = -1;
        this.f48741b = view;
        this.f48743d = view.getContext();
    }

    public final d.a.o0.a.w1.k.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            d.a.o0.a.w1.k.a aVar = this.f48742c;
            if (aVar != null) {
                return aVar;
            }
            if (view instanceof d.a.o0.a.w1.k.a) {
                d.a.o0.a.w1.k.a aVar2 = (d.a.o0.a.w1.k.a) view;
                this.f48742c = aVar2;
                return aVar2;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    d.a.o0.a.w1.k.a a2 = a(viewGroup.getChildAt(i2));
                    if (a2 != null) {
                        this.f48742c = a2;
                        return a2;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (d.a.o0.a.w1.k.a) invokeL.objValue;
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            Context context = this.f48743d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (g.f(activity) && this.f48741b.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.f48741b.getWindowVisibleDisplayFrame(rect);
                    i3 = rect.bottom - rect.top;
                    if (f48739e) {
                        Log.d("SPSwitchRootLayout", "TranslucentStatus && FitsSystemWindows = true, height: " + i3);
                    }
                }
                if (g.e(activity) && this.f48741b.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.f48741b.getWindowVisibleDisplayFrame(rect2);
                    i3 = rect2.bottom - rect2.top;
                    if (f48739e) {
                        Log.d("SPSwitchRootLayout", "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3);
                    }
                }
            }
            if (f48739e) {
                Log.d("SPSwitchRootLayout", "onMeasure, width: " + i2 + " height: " + i3);
            }
            if (i3 < 0) {
                return;
            }
            int i4 = this.f48740a;
            if (i4 < 0) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "onMeasure, oldHeight < 0, oldHeight: " + this.f48740a);
                }
                this.f48740a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "offset == 0, break;");
                    return;
                }
                return;
            }
            this.f48740a = i3;
            d.a.o0.a.w1.k.a a2 = a(this.f48741b);
            if (a2 == null) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) a2).getVisibility();
            if (f48739e) {
                Log.d("SPSwitchRootLayout", "panel visibility: " + visibility);
            }
            if (Math.abs(i5) < e.g(this.f48741b.getContext())) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i5) > e.e(this.f48741b.getContext())) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i5 > 0) {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "offset > 0, offset : " + i5 + ", panel->handleHide...");
                }
                a2.handleHide();
            } else {
                if (f48739e) {
                    Log.d("SPSwitchRootLayout", "offset < 0, offset : " + i5 + ", panel->handleShow...");
                }
                a2.handleShow();
            }
        }
    }
}
