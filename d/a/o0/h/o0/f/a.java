package d.a.o0.h.o0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.h.u.a;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f50688a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f50689b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f50690c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f50691d;

    /* renamed from: e  reason: collision with root package name */
    public Button f50692e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50693f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f50694g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.h.u.c f50695h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f50696i;
    public TextWatcher j;
    public TextView.OnEditorActionListener k;

    /* renamed from: d.a.o0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1117a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50697e;

        public View$OnClickListenerC1117a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50697e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f50697e.f50690c != null && this.f50697e.f50693f) {
                if (this.f50697e.f50694g != null) {
                    this.f50697e.f50694g.c(this.f50697e.f50690c.getText().toString());
                }
                if (this.f50697e.f50695h == null || this.f50697e.f50695h.f50830d || this.f50697e.f50694g == null) {
                    return;
                }
                this.f50697e.f50694g.a();
                this.f50697e.m("");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50698e;

        /* renamed from: d.a.o0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1118a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f50699e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f50700f;

            public RunnableC1118a(b bVar, Editable editable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, editable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50700f = bVar;
                this.f50699e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f50699e.toString())) {
                        this.f50700f.f50698e.f50692e.setEnabled(false);
                    } else if (this.f50700f.f50698e.f50692e.isEnabled()) {
                    } else {
                        this.f50700f.f50698e.f50692e.setEnabled(true);
                    }
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50698e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f50698e.f50694g != null) {
                    this.f50698e.f50694g.e(editable.toString());
                }
                this.f50698e.f50692e.post(new RunnableC1118a(this, editable));
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
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50701a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50701a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f50701a.f50695h == null || this.f50701a.f50695h.f50831e != i2 || this.f50701a.f50690c == null || !this.f50701a.f50693f) {
                    return false;
                }
                if (this.f50701a.f50694g != null) {
                    this.f50701a.f50694g.c(this.f50701a.f50690c.getText().toString());
                }
                if (this.f50701a.f50695h.f50830d || this.f50701a.f50694g == null) {
                    return true;
                }
                this.f50701a.f50694g.a();
                this.f50701a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50702e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50702e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50702e.f50692e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.u.c f50703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50704f;

        public e(a aVar, d.a.o0.h.u.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50704f = aVar;
            this.f50703e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f50704f.f50690c.getText().length() <= this.f50703e.f50827a.length()) {
                        length = this.f50704f.f50690c.getText().length();
                    } else {
                        length = this.f50703e.f50827a.length();
                    }
                    this.f50704f.f50690c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f46335a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50706f;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50706f = aVar;
            this.f50705e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50706f.f50690c.setSelection(this.f50705e.length());
            }
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
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
        this.f50693f = false;
        this.f50696i = new View$OnClickListenerC1117a(this);
        this.j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.o0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f50688a = relativeLayout;
        this.f50689b = (EditText) relativeLayout.findViewById(d.a.o0.f.e.ai_games_virtual_input_et);
        this.f50691d = (RelativeLayout) this.f50688a.findViewById(d.a.o0.f.e.ai_games_real_input_container);
        this.f50690c = (EditText) this.f50688a.findViewById(d.a.o0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f50688a.findViewById(d.a.o0.f.e.ai_games_input_send_btn);
        this.f50692e = button;
        button.setOnClickListener(this.f50696i);
        this.f50690c.addTextChangedListener(this.j);
        this.f50690c.setOnEditorActionListener(this.k);
        this.f50692e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50688a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50693f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f50690c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f50693f = false;
            this.f50689b.setVisibility(8);
            this.f50691d.setVisibility(8);
            a.f fVar = this.f50694g;
            if (fVar == null || (editText2 = this.f50690c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f50694g = fVar;
        }
    }

    public void j(d.a.o0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f50695h = cVar;
            if (this.f50690c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f50827a)) {
                this.f50690c.setText(cVar.f50827a);
                if (cVar.f50828b > 0) {
                    if (!TextUtils.isEmpty(cVar.f50827a) && cVar.f50827a.length() > cVar.f50828b) {
                        cVar.f50828b = cVar.f50827a.length();
                    }
                    this.f50690c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f50828b)});
                }
                this.f50690c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f50690c.setText("");
            }
            this.f50692e.setEnabled(!TextUtils.isEmpty(cVar.f50827a));
            if (cVar.f50829c) {
                this.f50690c.setMinLines(1);
                this.f50690c.setInputType(131073);
                this.f50692e.setText(cVar.f50832f);
                return;
            }
            this.f50690c.setMaxLines(1);
            this.f50690c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f50691d.setVisibility(0);
            this.f50690c.setFocusableInTouchMode(true);
            this.f50690c.requestFocus();
            this.f50689b.setVisibility(8);
            this.f50693f = true;
            a.f fVar = this.f50694g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f50693f) {
                return false;
            }
            this.f50689b.setVisibility(0);
            this.f50691d.setVisibility(8);
            this.f50689b.setFocusableInTouchMode(true);
            this.f50689b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f50689b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f50693f || (editText = this.f50690c) == null) {
                return false;
            }
            editText.setText(str);
            this.f50690c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}
