package d.a.q0.a.z1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.q0.a.i;
import d.a.q0.a.z1.b.f.e;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52115a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52116b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f52117c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f52118d;

    /* renamed from: e  reason: collision with root package name */
    public View f52119e;

    /* renamed from: f  reason: collision with root package name */
    public View f52120f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f52121g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f52122h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f52123i;
    public Runnable j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52124e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52124e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52124e.f52119e != null) {
                    if (this.f52124e.f52119e.getParent() != null) {
                        this.f52124e.f52117c.removeView(this.f52124e.f52119e);
                        if (this.f52124e.k != null) {
                            this.f52124e.k.onDismiss();
                            this.f52124e.k = null;
                        }
                    }
                    this.f52124e.f52119e = null;
                }
                if (this.f52124e.m != null) {
                    if (this.f52124e.m.getParent() != null) {
                        this.f52124e.f52117c.removeView(this.f52124e.m);
                    }
                    this.f52124e.m = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52125e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52125e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f52125e.l) {
                    if (this.f52125e.m != null && (this.f52125e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f52125e.m.getParent()).removeView(this.f52125e.m);
                    }
                    WindowManager.LayoutParams t = this.f52125e.t();
                    this.f52125e.n = new FrameLayout(this.f52125e.f52116b);
                    this.f52125e.n.setClickable(true);
                    this.f52125e.f52117c.addView(this.f52125e.n, t);
                    this.f52125e.m = this.f52125e.n;
                }
                if (this.f52125e.f52120f != null && (this.f52125e.f52120f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f52125e.f52120f.getParent()).removeView(this.f52125e.f52120f);
                }
                this.f52125e.f52117c.addView(this.f52125e.f52120f, this.f52125e.f52121g);
                this.f52125e.f52119e = this.f52125e.f52120f;
                this.f52125e.f52122h.postDelayed(this.f52125e.j, this.f52125e.f52118d * 1000);
                if (this.f52125e.f52115a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1057c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52126e;

        public RunnableC1057c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52126e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f52126e.f52119e != null) {
                    if (this.f52126e.f52119e.getParent() != null) {
                        this.f52126e.f52117c.removeViewImmediate(this.f52126e.f52119e);
                    }
                    if (this.f52126e.k != null) {
                        this.f52126e.k.onDismiss();
                        this.f52126e.k = null;
                    }
                    if (this.f52126e.f52115a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    this.f52126e.f52119e = null;
                }
                if (this.f52126e.m != null) {
                    if (this.f52126e.m.getParent() != null) {
                        this.f52126e.f52117c.removeViewImmediate(this.f52126e.m);
                    }
                    if (this.f52126e.f52115a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    this.f52126e.m = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52116b = context;
        this.f52117c = (WindowManager) context.getSystemService("window");
        this.f52122h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f52121g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f52121g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f52118d = 2;
        this.f52115a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f52121g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f52123i;
            if (runnable != null) {
                this.f52122h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f52123i = bVar;
            this.f52122h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f52122h) == null) {
            return;
        }
        handler.post(new RunnableC1057c(this));
        this.f52122h.removeCallbacks(this.j);
        if (this.f52115a) {
            Log.d("ToastCustom", QueryResponse.Options.CANCEL);
        }
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f52116b);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view = this.f52119e;
            return (view == null || view.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f52118d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f52121g) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void y(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void z(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f52120f = view;
            view.setClickable(true);
        }
    }
}
