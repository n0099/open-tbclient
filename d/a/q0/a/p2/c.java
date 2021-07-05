package d.a.q0.a.p2;

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
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50048f;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.q0.a.p2.a f50049g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f50050h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50051a;

    /* renamed from: b  reason: collision with root package name */
    public int f50052b;

    /* renamed from: c  reason: collision with root package name */
    public int f50053c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f50054d;

    /* renamed from: e  reason: collision with root package name */
    public String f50055e;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f50056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f50057f;

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
            this.f50057f = cVar;
            this.f50056e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f50049g != null) {
                    c.f50049g.c(this.f50057f.f50055e);
                }
                Rect rect = new Rect();
                this.f50056e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f50057f.f50053c == this.f50057f.f50051a) {
                    this.f50057f.f50053c = height;
                } else if (this.f50057f.f50053c == height) {
                } else {
                    if (this.f50057f.f50053c - height > this.f50057f.f50052b) {
                        if (c.f50049g != null) {
                            c.f50049g.b(this.f50057f.f50055e, this.f50057f.f50053c - height);
                            if (c.f50048f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.f50057f.f50053c + " visibleHeight " + height);
                            }
                        }
                        this.f50057f.f50053c = height;
                    } else if (height - this.f50057f.f50053c > this.f50057f.f50052b) {
                        if (c.f50049g != null) {
                            c.f50049g.a(this.f50057f.f50055e, height - this.f50057f.f50053c);
                        }
                        if (c.f50048f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + this.f50057f.f50053c + " visibleHeight " + height);
                        }
                        this.f50057f.f50053c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(124382668, "Ld/a/q0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(124382668, "Ld/a/q0/a/p2/c;");
                return;
            }
        }
        f50048f = k.f49133a;
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
        this.f50051a = 0;
        this.f50052b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f50050h == null) {
                synchronized (c.class) {
                    if (f50050h == null) {
                        f50050h = new c();
                    }
                }
            }
            return f50050h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f50049g = null;
            f50050h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f50054d == null) {
                this.f50054d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f50054d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f50054d);
            this.f50055e = "";
            f50049g = null;
            this.f50053c = 0;
        }
    }

    public void l(View view, String str, d.a.q0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f50055e = str;
            f50049g = aVar;
            this.f50053c = 0;
        }
    }
}
