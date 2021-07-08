package com.bytedance.sdk.openadsdk.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.b;
import com.bytedance.sdk.component.adnet.b.d;
import com.bytedance.sdk.component.adnet.core.l;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import com.bytedance.sdk.component.net.NetClient;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f31462a;

    /* renamed from: c  reason: collision with root package name */
    public static IHttpStack f31463c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f31464b;

    /* renamed from: d  reason: collision with root package name */
    public volatile l f31465d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.component.adnet.b.b f31466e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.component.adnet.b.d f31467f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.l.a.b f31468g;

    /* renamed from: h  reason: collision with root package name */
    public final NetClient f31469h;

    /* loaded from: classes5.dex */
    public static class a implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f31470a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31471b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31472c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31473d;

        public a(ImageView imageView, String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31470a = imageView;
            this.f31471b = str;
            this.f31472c = i2;
            this.f31473d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            InterceptResult invokeV;
            Object tag;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                ImageView imageView = this.f31470a;
                return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f31471b)) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.component.adnet.b.d.e
        public void a() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageView imageView = this.f31470a;
                if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f31470a.getContext()).isFinishing()) || this.f31470a == null || !c() || (i2 = this.f31472c) == 0) {
                    return;
                }
                this.f31470a.setImageResource(i2);
            }
        }

        @Override // com.bytedance.sdk.component.adnet.core.m.a
        public void a(m<Bitmap> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.component.adnet.b.d.e
        public boolean a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.bytedance.sdk.component.adnet.b.d.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f31470a = null;
            }
        }

        @Override // com.bytedance.sdk.component.adnet.core.m.a
        public void b(m<Bitmap> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
                ImageView imageView = this.f31470a;
                if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f31470a.getContext()).isFinishing()) || this.f31470a == null || this.f31473d == 0 || !c()) {
                    return;
                }
                this.f31470a.setImageResource(this.f31473d);
            }
        }

        @Override // com.bytedance.sdk.component.adnet.b.d.e
        public void a(d.c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, z) == null) {
                ImageView imageView = this.f31470a;
                if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f31470a.getContext()).isFinishing()) || this.f31470a == null || !c() || cVar.a() == null) {
                    return;
                }
                this.f31470a.setImageBitmap(cVar.a());
            }
        }
    }

    public e(Context context) {
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
        this.f31464b = context == null ? o.a() : context.getApplicationContext();
        this.f31469h = new NetClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS).enableTNC(true).build();
    }

    public static IHttpStack a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f31463c : (IHttpStack) invokeV.objValue;
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f31462a == null) {
                synchronized (e.class) {
                    if (f31462a == null) {
                        f31462a = new e(o.a());
                    }
                }
            }
            return f31462a;
        }
        return (e) invokeV.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.f31468g == null) {
            this.f31468g = new com.bytedance.sdk.openadsdk.l.a.b(d());
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.f31467f == null) {
            this.f31467f = new com.bytedance.sdk.component.adnet.b.d(d(), com.bytedance.sdk.openadsdk.l.a.a());
        }
    }

    public NetClient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31469h : (NetClient) invokeV.objValue;
    }

    public l d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f31465d == null) {
                synchronized (e.class) {
                    if (this.f31465d == null) {
                        this.f31465d = com.bytedance.sdk.component.adnet.a.a(this.f31464b);
                    }
                }
            }
            return this.f31465d;
        }
        return (l) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.l.a.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            f();
            return this.f31468g;
        }
        return (com.bytedance.sdk.openadsdk.l.a.b) invokeV.objValue;
    }

    public static void a(IHttpStack iHttpStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iHttpStack) == null) {
            f31463c = iHttpStack;
        }
    }

    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            if (this.f31466e == null) {
                this.f31466e = new com.bytedance.sdk.component.adnet.b.b(this.f31464b, d());
            }
            this.f31466e.a(str, aVar);
        }
    }

    public void a(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageView) == null) {
            a(str, imageView, a(str, imageView, 0, 0));
        }
    }

    public void a(String str, ImageView imageView, d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageView, eVar) == null) {
            g();
            this.f31467f.a(str, eVar);
        }
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, str, imageView, i2, i3)) == null) ? new a(imageView, str, i2, i3) : (a) invokeLLII.objValue;
    }
}
