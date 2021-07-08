package d.a.n0.h.o0.f;

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
import d.a.n0.a.k;
import d.a.n0.h.u.a;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f50184a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f50185b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f50186c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f50187d;

    /* renamed from: e  reason: collision with root package name */
    public Button f50188e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50189f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f50190g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.h.u.c f50191h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f50192i;
    public TextWatcher j;
    public TextView.OnEditorActionListener k;

    /* renamed from: d.a.n0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1108a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50193e;

        public View$OnClickListenerC1108a(a aVar) {
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
            this.f50193e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f50193e.f50186c != null && this.f50193e.f50189f) {
                if (this.f50193e.f50190g != null) {
                    this.f50193e.f50190g.c(this.f50193e.f50186c.getText().toString());
                }
                if (this.f50193e.f50191h == null || this.f50193e.f50191h.f50326d || this.f50193e.f50190g == null) {
                    return;
                }
                this.f50193e.f50190g.a();
                this.f50193e.m("");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50194e;

        /* renamed from: d.a.n0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1109a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f50195e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f50196f;

            public RunnableC1109a(b bVar, Editable editable) {
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
                this.f50196f = bVar;
                this.f50195e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f50195e.toString())) {
                        this.f50196f.f50194e.f50188e.setEnabled(false);
                    } else if (this.f50196f.f50194e.f50188e.isEnabled()) {
                    } else {
                        this.f50196f.f50194e.f50188e.setEnabled(true);
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
            this.f50194e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f50194e.f50190g != null) {
                    this.f50194e.f50190g.e(editable.toString());
                }
                this.f50194e.f50188e.post(new RunnableC1109a(this, editable));
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
        public final /* synthetic */ a f50197a;

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
            this.f50197a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f50197a.f50191h == null || this.f50197a.f50191h.f50327e != i2 || this.f50197a.f50186c == null || !this.f50197a.f50189f) {
                    return false;
                }
                if (this.f50197a.f50190g != null) {
                    this.f50197a.f50190g.c(this.f50197a.f50186c.getText().toString());
                }
                if (this.f50197a.f50191h.f50326d || this.f50197a.f50190g == null) {
                    return true;
                }
                this.f50197a.f50190g.a();
                this.f50197a.m("");
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
        public final /* synthetic */ a f50198e;

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
            this.f50198e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50198e.f50188e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.h.u.c f50199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50200f;

        public e(a aVar, d.a.n0.h.u.c cVar) {
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
            this.f50200f = aVar;
            this.f50199e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f50200f.f50186c.getText().length() <= this.f50199e.f50323a.length()) {
                        length = this.f50200f.f50186c.getText().length();
                    } else {
                        length = this.f50199e.f50323a.length();
                    }
                    this.f50200f.f50186c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f45831a) {
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
        public final /* synthetic */ String f50201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50202f;

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
            this.f50202f = aVar;
            this.f50201e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50202f.f50186c.setSelection(this.f50201e.length());
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
        this.f50189f = false;
        this.f50192i = new View$OnClickListenerC1108a(this);
        this.j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.n0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f50184a = relativeLayout;
        this.f50185b = (EditText) relativeLayout.findViewById(d.a.n0.f.e.ai_games_virtual_input_et);
        this.f50187d = (RelativeLayout) this.f50184a.findViewById(d.a.n0.f.e.ai_games_real_input_container);
        this.f50186c = (EditText) this.f50184a.findViewById(d.a.n0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f50184a.findViewById(d.a.n0.f.e.ai_games_input_send_btn);
        this.f50188e = button;
        button.setOnClickListener(this.f50192i);
        this.f50186c.addTextChangedListener(this.j);
        this.f50186c.setOnEditorActionListener(this.k);
        this.f50188e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50184a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50189f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f50186c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f50189f = false;
            this.f50185b.setVisibility(8);
            this.f50187d.setVisibility(8);
            a.f fVar = this.f50190g;
            if (fVar == null || (editText2 = this.f50186c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f50190g = fVar;
        }
    }

    public void j(d.a.n0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f50191h = cVar;
            if (this.f50186c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f50323a)) {
                this.f50186c.setText(cVar.f50323a);
                if (cVar.f50324b > 0) {
                    if (!TextUtils.isEmpty(cVar.f50323a) && cVar.f50323a.length() > cVar.f50324b) {
                        cVar.f50324b = cVar.f50323a.length();
                    }
                    this.f50186c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f50324b)});
                }
                this.f50186c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f50186c.setText("");
            }
            this.f50188e.setEnabled(!TextUtils.isEmpty(cVar.f50323a));
            if (cVar.f50325c) {
                this.f50186c.setMinLines(1);
                this.f50186c.setInputType(131073);
                this.f50188e.setText(cVar.f50328f);
                return;
            }
            this.f50186c.setMaxLines(1);
            this.f50186c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f50187d.setVisibility(0);
            this.f50186c.setFocusableInTouchMode(true);
            this.f50186c.requestFocus();
            this.f50185b.setVisibility(8);
            this.f50189f = true;
            a.f fVar = this.f50190g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f50189f) {
                return false;
            }
            this.f50185b.setVisibility(0);
            this.f50187d.setVisibility(8);
            this.f50185b.setFocusableInTouchMode(true);
            this.f50185b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f50185b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f50189f || (editText = this.f50186c) == null) {
                return false;
            }
            editText.setText(str);
            this.f50186c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}
