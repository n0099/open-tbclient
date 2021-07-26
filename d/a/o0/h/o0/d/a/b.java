package d.a.o0.h.o0.d.a;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q0;
import d.a.o0.f.g;
import d.a.o0.h.o0.d.a.a;
/* loaded from: classes7.dex */
public class b extends EventTargetImpl implements a.InterfaceC1115a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ApiButton f50678e;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public d.a.o0.h.o0.d.a.a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50679e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50679e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f50679e.f50678e) == null) {
                return;
            }
            d.a.o0.h.o0.b.d(apiButton);
            this.f50679e.f50678e = null;
        }
    }

    /* renamed from: d.a.o0.h.o0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1116b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50680e;

        public RunnableC1116b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50680e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f50680e.f50678e) == null) {
                return;
            }
            apiButton.hide();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50681e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50681e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f50681e.f50678e) == null) {
                return;
            }
            apiButton.show();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50683f;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50683f = bVar;
            this.f50682e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (k.f46335a) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + this.f50682e);
                }
                if (this.f50683f.f50678e == null) {
                    return;
                }
                String str = this.f50682e;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && str.equals("image")) {
                        c2 = 1;
                    }
                } else if (str.equals("text")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    b bVar = this.f50683f;
                    bVar.f50678e.setButtonText(bVar.text);
                } else if (c2 != 1) {
                } else {
                    b bVar2 = this.f50683f;
                    bVar2.f50678e.setImageUrl(bVar2.image);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50684e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50684e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f50684e;
                if (bVar.f50678e == null || bVar.C()) {
                    return;
                }
                this.f50684e.f50678e.h();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, d.a.o0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "text";
        this.text = d.a.o0.a.c1.a.b().getString(g.aiapps_aigames_userinfo_button_text_des);
        B(jsObject);
    }

    public final d.a.o0.a.l1.e.a.a A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.o0.h.o0.d.a.a aVar = this.style;
            if (aVar == null || this.f50678e == null) {
                return null;
            }
            int g2 = n0.g(aVar.width);
            int g3 = n0.g(this.style.height);
            int g4 = n0.g(this.style.left);
            int g5 = n0.g(this.style.top);
            int g6 = n0.g(this.style.borderWidth) * 2;
            if (g2 < g6) {
                g2 = g6;
            }
            if (g3 < g6) {
                g3 = g6;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f50678e.getLayoutParams();
            if (layoutParams != null && layoutParams.width == g2 && layoutParams.height == g3 && layoutParams.leftMargin == g4 && layoutParams.topMargin == g5) {
                return null;
            }
            return new d.a.o0.a.l1.e.a.a(g4, g5, g2, g3);
        }
        return (d.a.o0.a.l1.e.a.a) invokeV.objValue;
    }

    public final void B(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            if (k.f46335a) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse jsObject = ");
                sb.append(G);
                Log.d("BaseButtonProxy", sb.toString() != null ? G.toString() : null);
            }
            if (G == null) {
                return;
            }
            this.type = G.D("type", this.type);
            this.text = G.D("text", this.text);
            this.image = G.D("image", this.image);
            d.a.o0.a.y.b.a y = G.y("style", null);
            this.style = y == null ? this.style : new d.a.o0.h.o0.d.a.a(y);
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        d.a.o0.a.l1.e.a.a A;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f50678e == null || this.style == null || (A = A()) == null || !d.a.o0.h.o0.b.f(this.f50678e, A)) ? false : true : invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q0.b0(new a(this));
        }
    }

    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new RunnableC1116b(this));
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            q0.b0(new d(this, str));
        }
    }

    @Override // d.a.o0.h.o0.d.a.a.InterfaceC1115a
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            q0.b0(new e(this));
        }
    }

    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q0.b0(new c(this));
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        d.a.o0.h.o0.d.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f50678e == null || (aVar = this.style) == null) {
                return false;
            }
            aVar.b(this);
            d.a.o0.a.l1.e.a.a A = A();
            return A != null && d.a.o0.h.o0.b.a(this.f50678e, A);
        }
        return invokeV.booleanValue;
    }
}
