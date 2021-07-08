package d.a.n0.a.z1.b.f;

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
import d.a.n0.a.i;
import d.a.n0.a.z1.b.f.e;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48813a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48814b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f48815c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f48816d;

    /* renamed from: e  reason: collision with root package name */
    public View f48817e;

    /* renamed from: f  reason: collision with root package name */
    public View f48818f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f48819g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f48820h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f48821i;
    public Runnable j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48822e;

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
            this.f48822e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48822e.f48817e != null) {
                    if (this.f48822e.f48817e.getParent() != null) {
                        this.f48822e.f48815c.removeView(this.f48822e.f48817e);
                        if (this.f48822e.k != null) {
                            this.f48822e.k.onDismiss();
                            this.f48822e.k = null;
                        }
                    }
                    this.f48822e.f48817e = null;
                }
                if (this.f48822e.m != null) {
                    if (this.f48822e.m.getParent() != null) {
                        this.f48822e.f48815c.removeView(this.f48822e.m);
                    }
                    this.f48822e.m = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48823e;

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
            this.f48823e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f48823e.l) {
                    if (this.f48823e.m != null && (this.f48823e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f48823e.m.getParent()).removeView(this.f48823e.m);
                    }
                    WindowManager.LayoutParams t = this.f48823e.t();
                    this.f48823e.n = new FrameLayout(this.f48823e.f48814b);
                    this.f48823e.n.setClickable(true);
                    this.f48823e.f48815c.addView(this.f48823e.n, t);
                    this.f48823e.m = this.f48823e.n;
                }
                if (this.f48823e.f48818f != null && (this.f48823e.f48818f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f48823e.f48818f.getParent()).removeView(this.f48823e.f48818f);
                }
                this.f48823e.f48815c.addView(this.f48823e.f48818f, this.f48823e.f48819g);
                this.f48823e.f48817e = this.f48823e.f48818f;
                this.f48823e.f48820h.postDelayed(this.f48823e.j, this.f48823e.f48816d * 1000);
                if (this.f48823e.f48813a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1006c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48824e;

        public RunnableC1006c(c cVar) {
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
            this.f48824e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f48824e.f48817e != null) {
                    if (this.f48824e.f48817e.getParent() != null) {
                        this.f48824e.f48815c.removeViewImmediate(this.f48824e.f48817e);
                    }
                    if (this.f48824e.k != null) {
                        this.f48824e.k.onDismiss();
                        this.f48824e.k = null;
                    }
                    if (this.f48824e.f48813a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    this.f48824e.f48817e = null;
                }
                if (this.f48824e.m != null) {
                    if (this.f48824e.m.getParent() != null) {
                        this.f48824e.f48815c.removeViewImmediate(this.f48824e.m);
                    }
                    if (this.f48824e.f48813a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    this.f48824e.m = null;
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
        this.f48814b = context;
        this.f48815c = (WindowManager) context.getSystemService("window");
        this.f48820h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f48819g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f48819g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f48816d = 2;
        this.f48813a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f48819g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f48821i;
            if (runnable != null) {
                this.f48820h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f48821i = bVar;
            this.f48820h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f48820h) == null) {
            return;
        }
        handler.post(new RunnableC1006c(this));
        this.f48820h.removeCallbacks(this.j);
        if (this.f48813a) {
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
            layoutParams.verticalMargin = e.c(this.f48814b);
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
            View view = this.f48817e;
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
            this.f48816d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f48819g) == null) {
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
            this.f48818f = view;
            view.setClickable(true);
        }
    }
}
