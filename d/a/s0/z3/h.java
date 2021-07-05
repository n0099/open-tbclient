package d.a.s0.z3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f69958a;

    /* renamed from: b  reason: collision with root package name */
    public View f69959b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f69960c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f69961d;

    /* renamed from: e  reason: collision with root package name */
    public View f69962e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f69963f;

    /* renamed from: g  reason: collision with root package name */
    public String f69964g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f69965h;

    /* renamed from: i  reason: collision with root package name */
    public f f69966i;
    public d j;
    public g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f69967e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69967e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f69967e.l) {
                    this.f69967e.m.setChecked(false);
                    this.f69967e.n.setChecked(false);
                    this.f69967e.o.setChecked(false);
                    this.f69967e.p.setChecked(false);
                    this.f69967e.r = 1;
                } else if (view == this.f69967e.m) {
                    this.f69967e.l.setChecked(true);
                    this.f69967e.n.setChecked(false);
                    this.f69967e.o.setChecked(false);
                    this.f69967e.p.setChecked(false);
                    this.f69967e.r = 2;
                } else if (view == this.f69967e.n) {
                    this.f69967e.l.setChecked(true);
                    this.f69967e.m.setChecked(true);
                    this.f69967e.o.setChecked(false);
                    this.f69967e.p.setChecked(false);
                    this.f69967e.r = 3;
                } else if (view == this.f69967e.o) {
                    this.f69967e.l.setChecked(true);
                    this.f69967e.m.setChecked(true);
                    this.f69967e.n.setChecked(true);
                    this.f69967e.p.setChecked(false);
                    this.f69967e.r = 4;
                } else if (view == this.f69967e.p) {
                    this.f69967e.l.setChecked(true);
                    this.f69967e.m.setChecked(true);
                    this.f69967e.n.setChecked(true);
                    this.f69967e.o.setChecked(true);
                    this.f69967e.r = 5;
                }
                if (this.f69967e.k != null) {
                    this.f69967e.k.onClick(this.f69967e.r);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f69968e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69968e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f69968e.j.onClick();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f69969a;

        /* renamed from: b  reason: collision with root package name */
        public h f69970b;

        /* renamed from: c  reason: collision with root package name */
        public View f69971c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f69972d;

        /* renamed from: e  reason: collision with root package name */
        public View f69973e;

        /* renamed from: f  reason: collision with root package name */
        public String f69974f;

        /* renamed from: g  reason: collision with root package name */
        public int f69975g;

        /* renamed from: h  reason: collision with root package name */
        public e f69976h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f69977i;
        public final View.OnClickListener j;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69978e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69978e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f69978e.f69976h != null) {
                        this.f69978e.f69976h.onClick();
                    }
                    if (this.f69978e.f69970b == null || this.f69978e.f69970b.l() == null) {
                        return;
                    }
                    this.f69978e.f69970b.l().onItemClick(this.f69978e.f69969a);
                }
            }
        }

        public c(String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69975g = 17;
            this.f69977i = true;
            this.j = new a(this);
            this.f69974f = str;
            this.f69970b = hVar;
            this.f69969a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69971c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f69972d) == null) {
                return;
            }
            textView.setOnClickListener(this.j);
        }

        public final void f() {
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f69970b) == null || hVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f69970b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f69970b.m(), false);
            this.f69971c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f69972d = textView;
            textView.setText(this.f69974f);
            this.f69972d.setGravity(this.f69975g);
            View findViewById = this.f69971c.findViewById(R.id.divider_line);
            this.f69973e = findViewById;
            if (this.f69977i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f69972d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f69972d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f69973e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f69976h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes9.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void onClick(int i2);
    }

    public h(Context context) {
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
        this.s = new a(this);
        if (context == null) {
            return;
        }
        this.f69958a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f69959b = inflate;
        this.f69960c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f69961d = (TextView) this.f69959b.findViewById(R.id.title);
        this.f69962e = this.f69959b.findViewById(R.id.title_divide_line);
        this.f69965h = new ArrayList();
        this.f69963f = (TextView) this.f69959b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f69959b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f69959b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f69959b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f69959b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f69959b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f69959b.findViewById(R.id.comment_grade);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f69964g)) {
                this.f69961d.setText(this.f69964g);
            } else {
                this.f69961d.setVisibility(8);
            }
            if (this.j != null) {
                this.f69963f.setOnClickListener(new b(this));
            }
            n();
            return this.f69959b;
        }
        return (View) invokeV.objValue;
    }

    public Context k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69958a : (Context) invokeV.objValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69966i : (f) invokeV.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69960c : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f69961d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f69961d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f69962e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f69963f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f69963f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f69965h;
            if (list != null) {
                for (c cVar : list) {
                    cVar.g();
                }
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f69963f.setVisibility(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l.setEnabled(z);
            this.m.setEnabled(z);
            this.n.setEnabled(z);
            this.o.setEnabled(z);
            this.p.setEnabled(z);
        }
    }

    public void q(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            this.q.setPadding(i2, i3, i4, i5);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 == 1) {
                this.l.setChecked(true);
                this.m.setChecked(false);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 2) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 3) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 4) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(false);
            } else if (i2 != 5) {
            } else {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(true);
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.q.setVisibility(i2);
        }
    }

    public void t(List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        this.f69965h = list;
        this.f69960c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f69960c.addView(cVar.d());
            }
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void v(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.k = gVar;
        }
    }

    public void w(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f69961d.setPadding(i2, i3, i4, i5);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f69961d.setTextSize(0, l.g(this.f69958a, i2));
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f69964g = str;
        }
    }
}
