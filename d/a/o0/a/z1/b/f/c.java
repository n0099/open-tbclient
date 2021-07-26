package d.a.o0.a.z1.b.f;

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
import d.a.o0.a.i;
import d.a.o0.a.z1.b.f.e;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49317a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49318b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f49319c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f49320d;

    /* renamed from: e  reason: collision with root package name */
    public View f49321e;

    /* renamed from: f  reason: collision with root package name */
    public View f49322f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f49323g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f49324h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f49325i;
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
        public final /* synthetic */ c f49326e;

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
            this.f49326e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49326e.f49321e != null) {
                    if (this.f49326e.f49321e.getParent() != null) {
                        this.f49326e.f49319c.removeView(this.f49326e.f49321e);
                        if (this.f49326e.k != null) {
                            this.f49326e.k.onDismiss();
                            this.f49326e.k = null;
                        }
                    }
                    this.f49326e.f49321e = null;
                }
                if (this.f49326e.m != null) {
                    if (this.f49326e.m.getParent() != null) {
                        this.f49326e.f49319c.removeView(this.f49326e.m);
                    }
                    this.f49326e.m = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f49327e;

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
            this.f49327e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f49327e.l) {
                    if (this.f49327e.m != null && (this.f49327e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f49327e.m.getParent()).removeView(this.f49327e.m);
                    }
                    WindowManager.LayoutParams t = this.f49327e.t();
                    this.f49327e.n = new FrameLayout(this.f49327e.f49318b);
                    this.f49327e.n.setClickable(true);
                    this.f49327e.f49319c.addView(this.f49327e.n, t);
                    this.f49327e.m = this.f49327e.n;
                }
                if (this.f49327e.f49322f != null && (this.f49327e.f49322f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f49327e.f49322f.getParent()).removeView(this.f49327e.f49322f);
                }
                this.f49327e.f49319c.addView(this.f49327e.f49322f, this.f49327e.f49323g);
                this.f49327e.f49321e = this.f49327e.f49322f;
                this.f49327e.f49324h.postDelayed(this.f49327e.j, this.f49327e.f49320d * 1000);
                if (this.f49327e.f49317a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1015c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f49328e;

        public RunnableC1015c(c cVar) {
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
            this.f49328e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f49328e.f49321e != null) {
                    if (this.f49328e.f49321e.getParent() != null) {
                        this.f49328e.f49319c.removeViewImmediate(this.f49328e.f49321e);
                    }
                    if (this.f49328e.k != null) {
                        this.f49328e.k.onDismiss();
                        this.f49328e.k = null;
                    }
                    if (this.f49328e.f49317a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    this.f49328e.f49321e = null;
                }
                if (this.f49328e.m != null) {
                    if (this.f49328e.m.getParent() != null) {
                        this.f49328e.f49319c.removeViewImmediate(this.f49328e.m);
                    }
                    if (this.f49328e.f49317a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    this.f49328e.m = null;
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
        this.f49318b = context;
        this.f49319c = (WindowManager) context.getSystemService("window");
        this.f49324h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f49323g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f49323g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f49320d = 2;
        this.f49317a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f49323g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f49325i;
            if (runnable != null) {
                this.f49324h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f49325i = bVar;
            this.f49324h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f49324h) == null) {
            return;
        }
        handler.post(new RunnableC1015c(this));
        this.f49324h.removeCallbacks(this.j);
        if (this.f49317a) {
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
            layoutParams.verticalMargin = e.c(this.f49318b);
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
            View view = this.f49321e;
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
            this.f49320d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f49323g) == null) {
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
            this.f49322f = view;
            view.setClickable(true);
        }
    }
}
