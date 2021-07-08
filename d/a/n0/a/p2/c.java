package d.a.n0.a.p2;

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
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46746f;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.n0.a.p2.a f46747g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f46748h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f46749a;

    /* renamed from: b  reason: collision with root package name */
    public int f46750b;

    /* renamed from: c  reason: collision with root package name */
    public int f46751c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f46752d;

    /* renamed from: e  reason: collision with root package name */
    public String f46753e;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f46754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f46755f;

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
            this.f46755f = cVar;
            this.f46754e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f46747g != null) {
                    c.f46747g.c(this.f46755f.f46753e);
                }
                Rect rect = new Rect();
                this.f46754e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f46755f.f46751c == this.f46755f.f46749a) {
                    this.f46755f.f46751c = height;
                } else if (this.f46755f.f46751c == height) {
                } else {
                    if (this.f46755f.f46751c - height > this.f46755f.f46750b) {
                        if (c.f46747g != null) {
                            c.f46747g.b(this.f46755f.f46753e, this.f46755f.f46751c - height);
                            if (c.f46746f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.f46755f.f46751c + " visibleHeight " + height);
                            }
                        }
                        this.f46755f.f46751c = height;
                    } else if (height - this.f46755f.f46751c > this.f46755f.f46750b) {
                        if (c.f46747g != null) {
                            c.f46747g.a(this.f46755f.f46753e, height - this.f46755f.f46751c);
                        }
                        if (c.f46746f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + this.f46755f.f46751c + " visibleHeight " + height);
                        }
                        this.f46755f.f46751c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(713923183, "Ld/a/n0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(713923183, "Ld/a/n0/a/p2/c;");
                return;
            }
        }
        f46746f = k.f45831a;
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
        this.f46749a = 0;
        this.f46750b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f46748h == null) {
                synchronized (c.class) {
                    if (f46748h == null) {
                        f46748h = new c();
                    }
                }
            }
            return f46748h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f46747g = null;
            f46748h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f46752d == null) {
                this.f46752d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f46752d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f46752d);
            this.f46753e = "";
            f46747g = null;
            this.f46751c = 0;
        }
    }

    public void l(View view, String str, d.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f46753e = str;
            f46747g = aVar;
            this.f46751c = 0;
        }
    }
}
