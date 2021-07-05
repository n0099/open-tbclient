package d.a.q0.h.o0.f;

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
import d.a.q0.a.k;
import d.a.q0.h.u.a;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f53486a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f53487b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f53488c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f53489d;

    /* renamed from: e  reason: collision with root package name */
    public Button f53490e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53491f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f53492g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h.u.c f53493h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53494i;
    public TextWatcher j;
    public TextView.OnEditorActionListener k;

    /* renamed from: d.a.q0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1159a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53495e;

        public View$OnClickListenerC1159a(a aVar) {
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
            this.f53495e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f53495e.f53488c != null && this.f53495e.f53491f) {
                if (this.f53495e.f53492g != null) {
                    this.f53495e.f53492g.c(this.f53495e.f53488c.getText().toString());
                }
                if (this.f53495e.f53493h == null || this.f53495e.f53493h.f53628d || this.f53495e.f53492g == null) {
                    return;
                }
                this.f53495e.f53492g.a();
                this.f53495e.m("");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53496e;

        /* renamed from: d.a.q0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1160a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f53497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f53498f;

            public RunnableC1160a(b bVar, Editable editable) {
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
                this.f53498f = bVar;
                this.f53497e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f53497e.toString())) {
                        this.f53498f.f53496e.f53490e.setEnabled(false);
                    } else if (this.f53498f.f53496e.f53490e.isEnabled()) {
                    } else {
                        this.f53498f.f53496e.f53490e.setEnabled(true);
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
            this.f53496e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f53496e.f53492g != null) {
                    this.f53496e.f53492g.e(editable.toString());
                }
                this.f53496e.f53490e.post(new RunnableC1160a(this, editable));
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

    /* loaded from: classes8.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53499a;

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
            this.f53499a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f53499a.f53493h == null || this.f53499a.f53493h.f53629e != i2 || this.f53499a.f53488c == null || !this.f53499a.f53491f) {
                    return false;
                }
                if (this.f53499a.f53492g != null) {
                    this.f53499a.f53492g.c(this.f53499a.f53488c.getText().toString());
                }
                if (this.f53499a.f53493h.f53628d || this.f53499a.f53492g == null) {
                    return true;
                }
                this.f53499a.f53492g.a();
                this.f53499a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53500e;

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
            this.f53500e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53500e.f53490e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.u.c f53501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53502f;

        public e(a aVar, d.a.q0.h.u.c cVar) {
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
            this.f53502f = aVar;
            this.f53501e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f53502f.f53488c.getText().length() <= this.f53501e.f53625a.length()) {
                        length = this.f53502f.f53488c.getText().length();
                    } else {
                        length = this.f53501e.f53625a.length();
                    }
                    this.f53502f.f53488c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f49133a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53504f;

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
            this.f53504f = aVar;
            this.f53503e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53504f.f53488c.setSelection(this.f53503e.length());
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
        this.f53491f = false;
        this.f53494i = new View$OnClickListenerC1159a(this);
        this.j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.q0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f53486a = relativeLayout;
        this.f53487b = (EditText) relativeLayout.findViewById(d.a.q0.f.e.ai_games_virtual_input_et);
        this.f53489d = (RelativeLayout) this.f53486a.findViewById(d.a.q0.f.e.ai_games_real_input_container);
        this.f53488c = (EditText) this.f53486a.findViewById(d.a.q0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f53486a.findViewById(d.a.q0.f.e.ai_games_input_send_btn);
        this.f53490e = button;
        button.setOnClickListener(this.f53494i);
        this.f53488c.addTextChangedListener(this.j);
        this.f53488c.setOnEditorActionListener(this.k);
        this.f53490e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53486a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53491f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f53488c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f53491f = false;
            this.f53487b.setVisibility(8);
            this.f53489d.setVisibility(8);
            a.f fVar = this.f53492g;
            if (fVar == null || (editText2 = this.f53488c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f53492g = fVar;
        }
    }

    public void j(d.a.q0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f53493h = cVar;
            if (this.f53488c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f53625a)) {
                this.f53488c.setText(cVar.f53625a);
                if (cVar.f53626b > 0) {
                    if (!TextUtils.isEmpty(cVar.f53625a) && cVar.f53625a.length() > cVar.f53626b) {
                        cVar.f53626b = cVar.f53625a.length();
                    }
                    this.f53488c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f53626b)});
                }
                this.f53488c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f53488c.setText("");
            }
            this.f53490e.setEnabled(!TextUtils.isEmpty(cVar.f53625a));
            if (cVar.f53627c) {
                this.f53488c.setMinLines(1);
                this.f53488c.setInputType(131073);
                this.f53490e.setText(cVar.f53630f);
                return;
            }
            this.f53488c.setMaxLines(1);
            this.f53488c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f53489d.setVisibility(0);
            this.f53488c.setFocusableInTouchMode(true);
            this.f53488c.requestFocus();
            this.f53487b.setVisibility(8);
            this.f53491f = true;
            a.f fVar = this.f53492g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f53491f) {
                return false;
            }
            this.f53487b.setVisibility(0);
            this.f53489d.setVisibility(8);
            this.f53487b.setFocusableInTouchMode(true);
            this.f53487b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f53487b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f53491f || (editText = this.f53488c) == null) {
                return false;
            }
            editText.setText(str);
            this.f53488c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}
