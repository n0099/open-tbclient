package d.a.q0.u0.p1.f;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.a4.i;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64189a;

    /* renamed from: b  reason: collision with root package name */
    public View f64190b;

    /* renamed from: c  reason: collision with root package name */
    public View f64191c;

    /* renamed from: d  reason: collision with root package name */
    public View f64192d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64193e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64194f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64195g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f64196h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f64197i;
    public SpanGroupEditText j;
    public View.OnClickListener k;
    public e l;
    public boolean m;

    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64198e;

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
            this.f64198e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                d.a.q0.u0.p1.f.a.R(this.f64198e.f64193e, editable.toString().length(), 30);
                if (this.f64198e.l != null) {
                    this.f64198e.l.a();
                }
                if (this.f64198e.m) {
                    d.a.p0.s.u.c.d(this.f64198e.f64197i).t(R.color.CAM_X0105);
                    d.a.p0.s.u.c.d(this.f64198e.j).t(R.color.CAM_X0105);
                    this.f64198e.m = false;
                }
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

    /* renamed from: d.a.q0.u0.p1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1717b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64199e;

        /* renamed from: d.a.q0.u0.p1.f.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1717b c1717b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1717b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public C1717b(b bVar) {
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
            this.f64199e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                d.a.q0.u0.p1.f.a.R(this.f64199e.f64195g, editable.toString().length(), 1000);
                if (this.f64199e.l != null) {
                    this.f64199e.l.a();
                }
                if (this.f64199e.m) {
                    d.a.p0.s.u.c.d(this.f64199e.f64197i).t(R.color.CAM_X0105);
                    d.a.p0.s.u.c.d(this.f64199e.j).t(R.color.CAM_X0105);
                    this.f64199e.m = false;
                }
                if (this.f64199e.j.getLineCount() > 6) {
                    this.f64199e.j.setOnTouchListener(new a(this));
                } else {
                    this.f64199e.j.setOnTouchListener(null);
                }
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64200e;

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
            this.f64200e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                l.K(this.f64200e.f64189a, this.f64200e.f64197i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64201e;

        public d(b bVar) {
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
            this.f64201e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                l.K(this.f64201e.f64189a, this.f64201e.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
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
        this.f64189a = context;
        n();
    }

    public final String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? d.a.q0.u0.p1.e.a.d(i2 + 1) : (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64190b == null) {
            return;
        }
        d.a.p0.s.u.c.d(this.f64191c).f(R.color.CAM_X0204);
        d.a.p0.s.u.c.d(this.f64192d).f(R.color.CAM_X0210);
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f64194f);
        d2.t(R.color.CAM_X0107);
        d2.y(R.string.F_X02);
        d.a.p0.s.u.c.d(this.f64193e).t(R.color.CAM_X0111);
        this.f64196h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f64197i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f64197i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            i.e(this.f64197i, R.drawable.edittext_cursor);
            i.e(this.j, R.drawable.edittext_cursor);
            return;
        }
        i.e(this.f64197i, R.drawable.edittext_cursor_1);
        i.e(this.j, R.drawable.edittext_cursor_1);
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64197i : (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64190b : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f64189a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
            this.f64190b = inflate;
            this.f64191c = inflate.findViewById(R.id.item_divider);
            this.f64194f = (TextView) this.f64190b.findViewById(R.id.item_title_index);
            this.f64196h = (ImageView) this.f64190b.findViewById(R.id.item_del);
            this.f64197i = (EditText) this.f64190b.findViewById(R.id.item_title);
            this.f64193e = (TextView) this.f64190b.findViewById(R.id.item_title_number);
            this.f64192d = this.f64190b.findViewById(R.id.titile_divider);
            this.j = (SpanGroupEditText) this.f64190b.findViewById(R.id.item_content);
            this.f64195g = (TextView) this.f64190b.findViewById(R.id.item_content_number);
            d.a.q0.u0.p1.f.a.R(this.f64193e, 0, 30);
            d.a.q0.u0.p1.f.a.R(this.f64195g, 0, 1000);
            this.f64197i.addTextChangedListener(new a(this));
            this.j.addTextChangedListener(new C1717b(this));
            this.f64197i.setOnClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            j();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.k = onClickListener;
            this.f64196h.setOnClickListener(onClickListener);
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void q(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f64196h) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void s(int i2) {
        EditText editText;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (editText = this.f64197i) == null || (context = this.f64189a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f64194f) == null) {
            return;
        }
        textView.setText(String.format(this.f64189a.getString(R.string.forum_rule_title_index), i(i2)));
    }
}
