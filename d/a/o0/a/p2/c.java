package d.a.o0.a.p2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47250f;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.o0.a.p2.a f47251g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f47252h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f47253a;

    /* renamed from: b  reason: collision with root package name */
    public int f47254b;

    /* renamed from: c  reason: collision with root package name */
    public int f47255c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47256d;

    /* renamed from: e  reason: collision with root package name */
    public String f47257e;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f47259f;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47259f = cVar;
            this.f47258e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f47251g != null) {
                    c.f47251g.c(this.f47259f.f47257e);
                }
                Rect rect = new Rect();
                this.f47258e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f47259f.f47255c == this.f47259f.f47253a) {
                    this.f47259f.f47255c = height;
                } else if (this.f47259f.f47255c == height) {
                } else {
                    if (this.f47259f.f47255c - height > this.f47259f.f47254b) {
                        if (c.f47251g != null) {
                            c.f47251g.b(this.f47259f.f47257e, this.f47259f.f47255c - height);
                            if (c.f47250f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.f47259f.f47255c + " visibleHeight " + height);
                            }
                        }
                        this.f47259f.f47255c = height;
                    } else if (height - this.f47259f.f47255c > this.f47259f.f47254b) {
                        if (c.f47251g != null) {
                            c.f47251g.a(this.f47259f.f47257e, height - this.f47259f.f47255c);
                        }
                        if (c.f47250f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + this.f47259f.f47255c + " visibleHeight " + height);
                        }
                        this.f47259f.f47255c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(517409678, "Ld/a/o0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(517409678, "Ld/a/o0/a/p2/c;");
                return;
            }
        }
        f47250f = k.f46335a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47253a = 0;
        this.f47254b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f47252h == null) {
                synchronized (c.class) {
                    if (f47252h == null) {
                        f47252h = new c();
                    }
                }
            }
            return f47252h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f47251g = null;
            f47252h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f47256d == null) {
                this.f47256d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f47256d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47256d);
            this.f47257e = "";
            f47251g = null;
            this.f47255c = 0;
        }
    }

    public void l(View view, String str, d.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f47257e = str;
            f47251g = aVar;
            this.f47255c = 0;
        }
    }
}
