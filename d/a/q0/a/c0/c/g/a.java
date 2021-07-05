package d.a.q0.a.c0.c.g;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.c0.a.a.a<SwanEditText, d.a.q0.a.c0.c.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f46819i;
    public d.a.q0.a.h0.g.f j;
    public int k;
    public h l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: d.a.q0.a.c0.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0693a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.g.b f46820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f46822g;

        public RunnableC0693a(a aVar, d.a.q0.a.c0.c.g.b bVar, SwanEditText swanEditText) {
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
            this.f46822g = aVar;
            this.f46820e = bVar;
            this.f46821f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46822g.f46819i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f46822g.f46819i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.f46820e.S) {
                        return;
                    }
                    this.f46821f.setFocusable(true);
                    this.f46821f.setFocusableInTouchMode(true);
                    this.f46821f.requestFocus();
                    inputMethodManager.showSoftInput(this.f46821f, 0);
                    return;
                }
                d.a.q0.a.c0.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46823a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f46824b;

        public b(a aVar, SwanEditText swanEditText) {
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
            this.f46824b = aVar;
            this.f46823a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f46824b.E0(this.f46823a, "selection");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46825e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46826f;

        public c(a aVar, SwanEditText swanEditText) {
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
            this.f46826f = aVar;
            this.f46825e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f46825e.hasFocus()) {
                d.a.q0.a.e0.d.g("Component-TextArea", "send input callback");
                this.f46826f.E0(this.f46825e, "input");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f46825e.getLineCount() <= 0 || this.f46826f.q == this.f46825e.getLineCount()) {
                return;
            }
            d.a.q0.a.e0.d.g("Component-TextArea", "send line change callback");
            this.f46826f.E0(this.f46825e, "linechange");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46827e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46828f;

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
            this.f46828f = aVar;
            this.f46827e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (this.f46828f.k != 0) {
                        this.f46828f.E0(this.f46827e, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.f46828f.H0();
                    return;
                }
                this.f46828f.E0(this.f46827e, "blur");
                this.f46828f.G0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.p2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46829a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46830b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f46831c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f46832d;

        /* renamed from: d.a.q0.a.c0.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0694a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.c0.c.g.b f46833a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f46834b;

            public C0694a(e eVar, d.a.q0.a.c0.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46834b = eVar;
                this.f46833a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!this.f46833a.a0 && (inputMethodManager = (InputMethodManager) this.f46834b.f46830b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.f46834b.f46829a.getWindowToken(), 0);
                    }
                    d.a.q0.a.e0.d.g("Component-TextArea", "send confirm change callback");
                    e eVar = this.f46834b;
                    eVar.f46832d.E0(eVar.f46829a, "confirm");
                }
            }
        }

        public e(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, swanAppActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46832d = aVar;
            this.f46829a = swanEditText;
            this.f46830b = swanAppActivity;
            this.f46831c = view;
        }

        @Override // d.a.q0.a.p2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (this.f46832d.k != 0) {
                    this.f46832d.k = 0;
                    if (this.f46832d.j.k3().getScrollY() > 0) {
                        this.f46832d.j.k3().setScrollY(0);
                        this.f46832d.p = false;
                    }
                    if (this.f46832d.o != null && this.f46832d.o.getVisibility() == 0) {
                        ((FrameLayout) this.f46831c.findViewById(16908290)).removeView(this.f46832d.o);
                        this.f46832d.o = null;
                    }
                }
                if (this.f46829a.hasFocus()) {
                    this.f46829a.clearFocus();
                    if (d.a.q0.a.c0.b.a.f46766h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // d.a.q0.a.p2.a
        public void b(String str, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                d.a.q0.a.c0.c.g.b bVar = (d.a.q0.a.c0.c.g.b) this.f46832d.n();
                d.a.q0.a.p.e.c h2 = d.a.q0.a.g1.f.V().h();
                if (this.f46832d.k == i2 || !this.f46829a.hasFocus() || h2 == null) {
                    return;
                }
                this.f46832d.k = i2;
                this.f46832d.n = this.f46829a.getHeight();
                this.f46832d.E0(this.f46829a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = bVar.W;
                if (bVar.V) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i3 = n0.g(38.0f);
                    if (this.f46832d.o == null) {
                        this.f46832d.o = new ShowConfirmBarLayout(this.f46830b);
                        this.f46832d.o.setOnConfirmButtonClickListener(new C0694a(this, bVar));
                        layoutParams.topMargin = ((this.f46831c.getHeight() - i2) - i3) - n0.s();
                        ((FrameLayout) this.f46831c.findViewById(16908290)).addView(this.f46832d.o, layoutParams);
                    }
                } else {
                    i3 = 0;
                }
                if (z) {
                    int webViewScrollY = !bVar.U ? h2.getWebViewScrollY() : 0;
                    d.a.q0.a.l1.e.a.a aVar = bVar.l;
                    int height = ((this.f46832d.j.k3().getHeight() - (aVar != null ? aVar.h() : 0)) - this.f46829a.getHeight()) + webViewScrollY;
                    int i4 = bVar.H;
                    if (height - i4 < i2) {
                        this.f46832d.p = true;
                        if (i4 > height) {
                            this.f46832d.j.k3().setScrollY(i2 + i3);
                            return;
                        } else {
                            this.f46832d.j.k3().setScrollY((i2 - height) + i4 + i3);
                            return;
                        }
                    }
                    this.f46832d.p = false;
                }
            }
        }

        @Override // d.a.q0.a.p2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f46832d.q == this.f46829a.getLineCount()) {
                return;
            }
            d.a.q0.a.e0.d.g("Component-TextArea", "send line change callback");
            this.f46832d.E0(this.f46829a, "linechange");
            this.f46832d.D0(this.f46829a, str);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46836f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f46837g;

        public f(a aVar, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46837g = aVar;
            this.f46835e = swanEditText;
            this.f46836f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46835e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f46835e.getTag().toString();
            if (!TextUtils.equals(obj, ((d.a.q0.a.c0.c.g.b) this.f46837g.n()).f46779f)) {
                d.a.q0.a.c0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int C0 = this.f46837g.C0(this.f46835e);
            try {
                jSONObject.put("eventName", this.f46836f);
                jSONObject.put("value", this.f46835e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f46835e.getSelectionStart());
                jSONObject.put("selectionStart", this.f46835e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f46835e.getSelectionEnd());
                jSONObject.put("lineCount", this.f46835e.getLineCount());
                jSONObject.put("height", n0.K(C0));
                jSONObject.put("keyboardHeight", n0.K(this.f46837g.k));
            } catch (JSONException e2) {
                if (d.a.q0.a.c0.b.a.f46766h) {
                    e2.printStackTrace();
                }
            }
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.f46837g.l.a(obj, this.f46837g.m, jSONObject);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f46838a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.c0.c.g.b f46839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f46840c;

        public g(a aVar, SwanEditText swanEditText, d.a.q0.a.c0.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46840c = aVar;
            this.f46838a = swanEditText;
            this.f46839b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 >= 2 && i2 <= 7) {
                    this.f46840c.E0(this.f46838a, "confirm");
                }
                return this.f46839b.a0;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface h {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull d.a.q0.a.c0.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.a.q0.a.h0.g.f fVar, @NonNull h hVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, hVar};
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
        this.p = false;
        this.q = 1;
        this.f46819i = swanAppActivity;
        this.j = fVar;
        this.l = hVar;
    }

    public final int C0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText)) == null) {
            d.a.q0.a.c0.c.g.b bVar = (d.a.q0.a.c0.c.g.b) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = bVar.X;
            int i3 = bVar.Y;
            int height = swanEditText.getHeight();
            if (bVar.T) {
                int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
                if (i3 < i2) {
                    i3 = i2;
                }
                return paddingTop <= i2 ? i2 : paddingTop >= i3 ? i3 : paddingTop;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public final void D0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            d.a.q0.a.c0.c.g.b bVar = (d.a.q0.a.c0.c.g.b) n();
            if (!TextUtils.equals(str, bVar.f46779f)) {
                d.a.q0.a.c0.g.a.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = bVar.W;
            if (!swanEditText.hasFocus() || bVar.U) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.j.k3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.j.k3().setScrollY(scrollY);
                } else {
                    this.j.k3().setScrollY(0);
                }
            }
            this.n = swanEditText.getHeight();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void E0(SwanEditText swanEditText, String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, swanEditText, str) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals("blur")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 97604824:
                    if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 259718308:
                    if (str.equals("linechange")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.q = swanEditText.getLineCount();
                ((d.a.q0.a.c0.c.g.b) n()).o(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((d.a.q0.a.c0.c.g.b) n()).l(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((d.a.q0.a.c0.c.g.b) n()).s(true);
            } else if (c2 == 3) {
                ((d.a.q0.a.c0.c.g.b) n()).s(false);
            } else if (c2 == 4) {
                ((d.a.q0.a.c0.c.g.b) n()).n(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.X(new f(this, swanEditText, str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.a.a, d.a.q0.a.c0.a.c.b, d.a.q0.a.c0.a.d.a, d.a.q0.a.c0.b.a
    @NonNull
    /* renamed from: F0 */
    public d.a.q0.a.c0.f.b k(@NonNull d.a.q0.a.c0.c.g.b bVar, @NonNull d.a.q0.a.c0.c.g.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, bVar2)) == null) {
            d.a.q0.a.c0.f.b k = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.O, bVar2.O)) {
                k.b(14);
            }
            if (bVar.P != bVar2.P) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.Q, bVar2.Q)) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.R, bVar2.R)) {
                k.b(14);
            }
            if (bVar.Z != bVar2.Z) {
                k.b(15);
            }
            return k;
        }
        return (d.a.q0.a.c0.f.b) invokeLL.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SwanAppActivity activity = d.a.q0.a.g1.f.V().getActivity();
            if (activity == null) {
                d.a.q0.a.e0.d.l("Component-TextArea", "activity is null when close input");
                return;
            }
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SwanAppActivity activity = d.a.q0.a.g1.f.V().getActivity();
            if (activity == null) {
                d.a.q0.a.e0.d.l("Component-TextArea", "activity is null when open input");
                return;
            }
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            x.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    @NonNull
    /* renamed from: I0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    /* renamed from: J0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanEditText) == null) {
            super.B(swanEditText);
            d.a.q0.a.c0.c.g.b bVar = (d.a.q0.a.c0.c.g.b) n();
            swanEditText.setTag(bVar.f46779f);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = bVar.f46782i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: K0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar, @NonNull d.a.q0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, swanEditText, bVar, bVar2) == null) {
            super.c0(swanEditText, bVar, bVar2);
            if (bVar2.a(14)) {
                O0(swanEditText, bVar);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(bVar.X);
                swanEditText.setMaxHeight(bVar.Y);
            }
            q0.X(new RunnableC0693a(this, bVar, swanEditText));
            if (bVar2.a(15)) {
                N0(swanEditText, bVar);
            }
            if (z) {
                T0(swanEditText, this.f46819i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.a.a
    /* renamed from: L0 */
    public boolean e0(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, swanEditText, bVar)) == null) {
            if (TextUtils.isEmpty(bVar.L) || "default".equals(bVar.L)) {
                return false;
            }
            boolean e0 = super.e0(swanEditText, bVar);
            if (e0) {
                swanEditText.setOnEditorActionListener(new g(this, swanEditText, bVar));
            }
            return e0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.a.a
    /* renamed from: M0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (bVar.S) {
                int i2 = bVar.I;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void N0(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!bVar.Z);
        }
    }

    public final void O0(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(bVar.O);
            String str = bVar.Q;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
                    c2 = 1;
                }
            } else if (str.equals("normal")) {
                c2 = 0;
            }
            if (c2 == 0) {
                styleSpan = new StyleSpan(0);
            } else if (c2 != 1) {
                styleSpan = new StyleSpan(0);
            } else {
                styleSpan = new StyleSpan(1);
            }
            spannableString.setSpan(styleSpan, 0, bVar.O.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.s(bVar.R)), 0, bVar.O.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.P, true), 0, bVar.O.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.a.a
    /* renamed from: P0 */
    public void h0(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = bVar.K;
            if (i3 > length || i3 <= 0 || (i2 = bVar.J) > i3 || i2 <= 0 || !bVar.S || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(bVar.J, bVar.K);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: Q0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
                return;
            }
            swanEditText.setText(bVar.x);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.a.c.b
    /* renamed from: R0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull d.a.q0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            super.a0(swanEditText, bVar, 48);
        }
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (!TextUtils.equals(((d.a.q0.a.c0.c.g.b) n()).f46779f, str)) {
                d.a.q0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                d.a.q0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                E0(swanEditText, "linechange");
            }
        }
    }

    public final void T0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            d.a.q0.a.p2.b.g(((d.a.q0.a.c0.c.g.b) n()).f46779f, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}
