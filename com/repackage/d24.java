package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c24;
/* loaded from: classes5.dex */
public class d24 extends EventTargetImpl implements c24.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ApiButton a;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public c24 style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d24 a;

        public a(d24 d24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.a.a) == null) {
                return;
            }
            a24.d(apiButton);
            this.a.a = null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d24 a;

        public b(d24 d24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.a.a) == null) {
                return;
            }
            apiButton.hide();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d24 a;

        public c(d24 d24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.a.a) == null) {
                return;
            }
            apiButton.show();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ d24 b;

        public d(d24 d24Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d24Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d24Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (rf1.a) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + this.a);
                }
                if (this.b.a == null) {
                    return;
                }
                String str = this.a;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && str.equals("image")) {
                        c = 1;
                    }
                } else if (str.equals("text")) {
                    c = 0;
                }
                if (c == 0) {
                    d24 d24Var = this.b;
                    d24Var.a.setButtonText(d24Var.text);
                } else if (c != 1) {
                } else {
                    d24 d24Var2 = this.b;
                    d24Var2.a.setImageUrl(d24Var2.image);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d24 a;

        public e(d24 d24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d24 d24Var = this.a;
                if (d24Var.a == null || d24Var.C()) {
                    return;
                }
                this.a.a.h();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d24(JsObject jsObject, r62 r62Var) {
        super(r62Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, r62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "text";
        this.text = oi2.c().getString(R.string.obfuscated_res_0x7f0f00ff);
        B(jsObject);
    }

    public final np2 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c24 c24Var = this.style;
            if (c24Var == null || this.a == null) {
                return null;
            }
            int g = yc3.g(c24Var.width);
            int g2 = yc3.g(this.style.height);
            int g3 = yc3.g(this.style.left);
            int g4 = yc3.g(this.style.top);
            int g5 = yc3.g(this.style.borderWidth) * 2;
            if (g < g5) {
                g = g5;
            }
            if (g2 < g5) {
                g2 = g5;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            if (layoutParams != null && layoutParams.width == g && layoutParams.height == g2 && layoutParams.leftMargin == g3 && layoutParams.topMargin == g4) {
                return null;
            }
            return new np2(g3, g4, g, g2);
        }
        return (np2) invokeV.objValue;
    }

    public final void B(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            or1 F = or1.F(jsObject);
            if (rf1.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse jsObject = ");
                sb.append(F);
                Log.d("BaseButtonProxy", sb.toString() != null ? F.toString() : null);
            }
            if (F == null) {
                return;
            }
            this.type = F.C("type", this.type);
            this.text = F.C("text", this.text);
            this.image = F.C("image", this.image);
            or1 x = F.x("style", null);
            this.style = x == null ? this.style : new c24(x);
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        np2 A;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.a == null || this.style == null || (A = A()) == null || !a24.f(this.a, A)) ? false : true : invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bd3.e0(new a(this));
        }
    }

    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bd3.e0(new b(this));
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            bd3.e0(new d(this, str));
        }
    }

    @Override // com.repackage.c24.a
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            bd3.e0(new e(this));
        }
    }

    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bd3.e0(new c(this));
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        c24 c24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null || (c24Var = this.style) == null) {
                return false;
            }
            c24Var.b(this);
            np2 A = A();
            return A != null && a24.a(this.a, A);
        }
        return invokeV.booleanValue;
    }
}
