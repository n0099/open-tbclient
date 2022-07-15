package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.player.AdVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ld1;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zc1 extends wc1 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean o0;
    public static boolean p0;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoView i0;
    public AtomicInteger j0;
    public volatile boolean k0;
    public ld1 l0;
    public ld1.a m0;
    public ld1.b n0;

    /* loaded from: classes7.dex */
    public class a implements ld1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc1 a;

        public a(zc1 zc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc1Var;
        }

        @Override // com.repackage.ld1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f0("video_onError");
            }
        }

        @Override // com.repackage.ld1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.h0();
            }
        }

        @Override // com.repackage.ld1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.i0();
            }
        }

        @Override // com.repackage.ld1
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.f0("time_end");
            }
        }

        @Override // com.repackage.ld1
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    AdVideoView adVideoView = this.a.i0;
                    adVideoView.getLayoutParams().width = -1;
                    adVideoView.getLayoutParams().height = -1;
                    zc1.super.C();
                    this.a.O();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ld1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc1 a;

        public b(zc1 zc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc1Var;
        }

        @Override // com.repackage.ld1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.i0 != null) {
                        AdVideoView adVideoView = this.a.i0;
                        adVideoView.getLayoutParams().width = 1;
                        adVideoView.getLayoutParams().height = 1;
                    }
                    if (this.a.m != null) {
                        this.a.m.setVisibility(8);
                    }
                    if (this.a.c != null) {
                        this.a.c.setVisibility(8);
                    }
                    if (this.a.d != null) {
                        this.a.d.setVisibility(8);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ld1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc1 a;

        public c(zc1 zc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc1Var;
        }

        @Override // com.repackage.ld1.b
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc1 a;

        public d(zc1 zc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc1 a;

        public e(zc1 zc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755116919, "Lcom/repackage/zc1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755116919, "Lcom/repackage/zc1;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc1(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j0 = new AtomicInteger(0);
        this.k0 = false;
        this.l0 = new a(this);
        this.m0 = new b(this);
        this.n0 = new c(this);
        this.r = "video";
        try {
            AdVideoView adVideoView = new AdVideoView(this.a);
            this.i0 = adVideoView;
            if (this.F == 17) {
                adVideoView.setDisplayMode(7);
            } else {
                adVideoView.setDisplayMode(2);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
            layoutParams.addRule(13);
            j(this.i0, layoutParams);
            this.i0.setAdVideoViewListener(this.l0);
            this.i0.setDestroyedListener(this.m0);
            this.i0.setPreparedListener(this.n0);
            this.i0.B();
            this.i0.n();
            this.i0.setVideoMute(true);
            this.i0.setVideoUrl(g0());
        } catch (Exception e2) {
            f0("video_container_excepiton_constructor_" + e2.toString());
        }
    }

    @Override // com.repackage.wc1
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.i0.A(g0());
                e0();
            } catch (Exception e2) {
                f0("video_container_excepiton_doStartOnUIThread_" + e2.toString());
            }
        }
    }

    @Override // com.repackage.wc1
    public void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.i0 == null) {
            return;
        }
        p0 = true;
    }

    @Override // com.repackage.wc1
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.V();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.j0.incrementAndGet() == 2) {
                    uh0.b(new e(this));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            p0 = false;
            super.y(str);
        }
    }

    public final String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String b2 = this.h.b(this.t, MaterialLoader.MaterialCacheType.VIDEO);
            return TextUtils.isEmpty(b2) ? this.t : b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    public final void h0() {
        AtomicBoolean atomicBoolean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (atomicBoolean = o0) == null) {
            return;
        }
        atomicBoolean.compareAndSet(true, false);
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (o0 == null) {
                o0 = new AtomicBoolean(true);
            }
            o0.compareAndSet(false, true);
        }
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.load();
            this.i0.setOnClickListener(new d(this));
            V();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            String str = wc1.h0;
            Log.d(str, "onWindowFocusChanged: " + z);
            AdVideoView adVideoView = this.i0;
            if (adVideoView == null) {
                return;
            }
            if (!z) {
                adVideoView.r();
            } else {
                adVideoView.s();
            }
            if (this.i0 != null && this.k0 && z && !p0) {
                f0("onWindowFocusChanged");
            }
            this.k0 = !z;
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    @Override // com.repackage.wc1
    public void z() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (adVideoView = this.i0) == null) {
            return;
        }
        adVideoView.setOnClickListener(null);
    }
}
