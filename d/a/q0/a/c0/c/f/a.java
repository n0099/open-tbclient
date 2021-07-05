package d.a.q0.a.c0.c.f;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.x;
import d.a.q0.a.z0.f.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.c0.a.a.a<SwanEditText, d.a.q0.a.c0.c.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f46800i;
    public d.a.q0.a.h0.g.f j;
    public d.a.q0.a.z0.f.b k;
    public int l;

    /* renamed from: d.a.q0.a.c0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0692a extends d.a.q0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f46802b;

        public C0692a(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46802b = aVar;
            this.f46801a = swanEditText;
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46802b.k == null) {
                return;
            }
            this.f46802b.k.dismiss();
            this.f46802b.r0(this.f46801a);
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, keyEvent)) == null) {
                if (i2 != 4 || this.f46802b.k == null) {
                    return false;
                }
                this.f46802b.k.dismiss();
                this.f46802b.r0(this.f46801a);
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.f.b f46804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t0.a f46805c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f46806d;

        public b(a aVar, SwanEditText swanEditText, d.a.q0.a.c0.c.f.b bVar, d.a.q0.a.t0.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46806d = aVar;
            this.f46803a = swanEditText;
            this.f46804b = bVar;
            this.f46805c = aVar2;
        }

        @Override // d.a.q0.a.z0.f.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.f46806d.A0(this.f46803a);
                this.f46806d.f46800i.unregisterCallback(this.f46805c);
            }
        }

        @Override // d.a.q0.a.z0.f.b.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                a aVar = this.f46806d;
                aVar.B0(aVar.f46800i, this.f46803a, this.f46804b, i2);
                this.f46806d.f46800i.registerCallback(this.f46805c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.f.b f46807a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46808b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f46809c;

        public c(a aVar, d.a.q0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46809c = aVar;
            this.f46807a = bVar;
            this.f46808b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                d.a.q0.a.z0.c.d(d.a.q0.a.z0.b.d().c(), this.f46809c.l);
                if (this.f46807a.P) {
                    return true;
                }
                this.f46808b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46810e;

        public d(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46810e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || i3 == i4) {
                return;
            }
            d.a.q0.a.z0.c.c(this.f46810e, i3 > i4 ? '\b' : charSequence.charAt((i2 + i4) - 1));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.f.b f46811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46812f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f46813g;

        public e(a aVar, d.a.q0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46813g = aVar;
            this.f46811e = bVar;
            this.f46812f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                d.a.q0.a.e0.d.g("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.f46811e.O) && this.f46813g.k != null) {
                    this.f46813g.k.dismiss();
                }
                d.a.q0.a.z0.c.b(this.f46812f, this.f46813g.l);
                this.f46813g.r0(this.f46812f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.p2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.f.b f46816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f46817d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46818e;

        public f(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, d.a.q0.a.c0.c.f.b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, swanAppActivity, bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46818e = aVar;
            this.f46814a = swanEditText;
            this.f46815b = swanAppActivity;
            this.f46816c = bVar;
            this.f46817d = view;
        }

        @Override // d.a.q0.a.p2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f46818e.A0(this.f46814a);
                d.a.q0.a.p2.c.i().k(this.f46817d);
            }
        }

        @Override // d.a.q0.a.p2.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) && this.f46814a.hasFocus()) {
                this.f46818e.B0(this.f46815b, this.f46814a, this.f46816c, i2);
            }
        }

        @Override // d.a.q0.a.p2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull d.a.q0.a.c0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.a.q0.a.h0.g.f fVar, @NonNull g gVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.a.q0.a.c0.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46800i = swanAppActivity;
        this.j = fVar;
        d.a.q0.a.z0.c.a(gVar);
    }

    @Override // d.a.q0.a.c0.b.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
        }
    }

    public final void A0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.k3().getScrollY() > 0) {
                    this.j.k3().setScrollY(0);
                }
            }
        }
    }

    public final void B0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, d.a.q0.a.c0.c.f.b bVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, swanAppActivity, swanEditText, bVar, i2) == null) {
            d.a.q0.a.p.e.c h2 = d.a.q0.a.g1.f.V().h();
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i2);
            }
            if (this.l == i2 || h2 == null) {
                return;
            }
            this.l = i2;
            d.a.q0.a.z0.c.f(swanEditText, i2);
            if (bVar.Q) {
                if (bVar.l == null) {
                    bVar.l = new d.a.q0.a.l1.e.a.a();
                }
                int webViewScrollY = h2.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.l.f();
                }
                int height2 = ((this.j.k3().getHeight() - bVar.l.h()) - height) + webViewScrollY + n0.k(swanAppActivity);
                int i4 = bVar.H;
                if (i4 > height2) {
                    i4 = height2;
                }
                int i5 = height2 - i2;
                int scrollY = this.j.k3().getScrollY();
                if (i5 < 0) {
                    i3 = i4 - i5;
                } else {
                    if (i4 > i5) {
                        scrollY = i4 - i5;
                    }
                    i3 = scrollY;
                }
                this.j.k3().setScrollY(i3);
            }
        }
    }

    public final void C0(SwanEditText swanEditText, d.a.q0.a.c0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, swanEditText, bVar, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, bVar, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, bVar, swanEditText));
            if (TextUtils.equals("text", bVar.O)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                d.a.q0.a.p2.c.i().l(decorView, bVar.f46779f, new f(this, swanEditText, swanAppActivity, bVar, decorView));
            }
            d.a.q0.a.z0.b.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void D0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanEditText) == null) {
            SwanAppActivity activity = d.a.q0.a.g1.f.V().getActivity();
            if (activity == null) {
                d.a.q0.a.e0.d.l("Component-Input", "activity is null when close input");
                return;
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            d.a.q0.a.e0.d.g("Component-Input", "remove input");
            if (C().a()) {
                d.a.q0.a.e0.d.g("Component-Input", "remove input success");
            } else {
                d.a.q0.a.e0.d.l("Component-Input", "remove input fail");
            }
            d.a.q0.a.z0.b.d().b();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            r0(d.a.q0.a.z0.b.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    @NonNull
    /* renamed from: t0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            s0();
            return d.a.q0.a.z0.b.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    /* renamed from: u0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, swanEditText) == null) {
            super.B(swanEditText);
            d.a.q0.a.c0.c.f.b bVar = (d.a.q0.a.c0.c.f.b) n();
            swanEditText.setText(bVar.x);
            int i2 = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(bVar.f46782i);
            if (!TextUtils.equals("text", bVar.O)) {
                String str = bVar.O;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1193508181) {
                    if (hashCode == 95582509 && str.equals("digit")) {
                        c2 = 0;
                    }
                } else if (str.equals("idcard")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    i2 = 2;
                } else if (c2 != 1) {
                    i2 = 0;
                }
                this.k = new d.a.q0.a.z0.f.b(this.f46800i, swanEditText, i2, bVar.G);
                this.k.e(new b(this, swanEditText, bVar, new C0692a(this, swanEditText)));
                this.k.f();
            }
            if (bVar.M) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: v0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.f.b bVar, @NonNull d.a.q0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, swanEditText, bVar, bVar2) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(d.a.q0.a.z0.b.d().e());
            }
            super.c0(swanEditText, bVar, bVar2);
            if (t) {
                swanEditText.addTextChangedListener(d.a.q0.a.z0.b.d().e());
            } else {
                C0(swanEditText, bVar, this.f46800i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.d.a
    /* renamed from: w0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: x0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.W(swanEditText, bVar);
                try {
                    swanEditText.setSelection(bVar.x.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (d.a.q0.a.c0.b.a.f46766h) {
                        e2.printStackTrace();
                    }
                    d.a.q0.a.c0.g.a.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
            } else {
                d.a.q0.a.c0.g.a.a("Component-Input", "insert input: set text must before render");
                super.W(swanEditText, bVar);
            }
        }
    }

    @Override // d.a.q0.a.c0.b.a
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.y(z);
            if (!z) {
                d.a.q0.a.c0.g.a.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                d.a.q0.a.c0.g.a.a("Component-Input", "onAttached with null editText");
                swanEditText = d.a.q0.a.z0.b.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((d.a.q0.a.c0.c.f.b) n()).O, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f46800i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                D0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: y0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = bVar.D;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode == -841373419 && str.equals("boldItalic")) {
                    c2 = 1;
                }
            } else if (str.equals("italic")) {
                c2 = 0;
            }
            if (c2 == 0) {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
            } else if (c2 != 1) {
                super.Y(swanEditText, bVar);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: z0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, swanEditText, bVar) == null) {
            a0(swanEditText, bVar, 16);
        }
    }
}
