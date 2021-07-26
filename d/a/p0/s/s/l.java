package d.a.p0.s.s;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f53584a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f53585b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f53586c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f53587d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f53588e;

    /* renamed from: f  reason: collision with root package name */
    public View f53589f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53590g;

    /* renamed from: h  reason: collision with root package name */
    public View f53591h;

    /* renamed from: i  reason: collision with root package name */
    public String f53592i;
    public SpannableStringBuilder j;
    public List<? extends k> k;
    public e l;
    public c m;
    public boolean n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f53593e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53593e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53593e.m.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f53594e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53594e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53594e.m.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface e {
        void onItemClick(l lVar, int i2, View view);
    }

    public l(Context context) {
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
        this.n = false;
        if (context == null) {
            return;
        }
        this.f53584a = context;
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(List<? extends k> list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        i();
        this.k = list;
        this.f53586c.removeAllViews();
        this.f53587d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((h) list.get(0)).f() == -1;
            if (((h) list.get(1)).f() == -2) {
                z2 = true;
                this.f53589f.setVisibility(!z ? 0 : 8);
                int i2 = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i2 > 4;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    h hVar = (h) list.get(i3);
                    hVar.k(z3);
                    hVar.e();
                    if (hVar != null) {
                        if (i3 < i2) {
                            this.f53586c.addView(hVar.getView());
                        } else {
                            this.f53587d.addView(hVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f53589f.setVisibility(!z ? 0 : 8);
        if (z) {
        }
        if (list.size() - i2 > 4) {
        }
        while (i3 < list.size()) {
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p();
            if (this.m != null) {
                this.f53590g.setOnClickListener(new b(this));
            }
            j();
            return this.f53585b;
        }
        return (View) invokeV.objValue;
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53584a : (Context) invokeV.objValue;
    }

    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (e) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53585b : (View) invokeV.objValue;
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53586c : (ViewGroup) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f53584a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.f53585b = roundLinearLayout;
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f53586c = (LinearLayout) this.f53585b.findViewById(R.id.content_view);
            this.f53588e = (EMTextView) this.f53585b.findViewById(R.id.title);
            View findViewById = this.f53585b.findViewById(R.id.title_divide_line);
            this.f53589f = findViewById;
            findViewById.setVisibility(8);
            this.f53591h = this.f53585b.findViewById(R.id.dialog_header);
            this.k = new ArrayList();
            this.f53590g = (TextView) this.f53585b.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f53584a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
            this.f53585b = roundLinearLayout;
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f53586c = (LinearLayout) this.f53585b.findViewById(R.id.content_view);
            this.f53587d = (LinearLayout) this.f53585b.findViewById(R.id.content_view_second);
            this.f53588e = (EMTextView) this.f53585b.findViewById(R.id.title);
            View findViewById = this.f53585b.findViewById(R.id.title_divide_line);
            this.f53589f = findViewById;
            findViewById.setVisibility(8);
            this.f53591h = this.f53585b.findViewById(R.id.dialog_header);
            this.k = new ArrayList();
            this.f53590g = (TextView) this.f53585b.findViewById(R.id.dialog_bottom_cancel_button);
            int k = (d.a.d.e.p.l.k(this.f53584a) - (h.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.f53586c.getLayoutParams()).leftMargin = k;
            ((LinearLayout.LayoutParams) this.f53586c.getLayoutParams()).rightMargin = k;
            ((FrameLayout.LayoutParams) this.f53587d.getLayoutParams()).leftMargin = k;
            ((FrameLayout.LayoutParams) this.f53587d.getLayoutParams()).rightMargin = k;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.n) {
                SkinManager.setBackgroundColor(this.f53589f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.f53588e, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f53589f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundResource(this.f53588e, R.color.CAM_X0209);
            SkinManager.setBackgroundResource(this.f53591h, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f53590g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f53590g, R.color.CAM_X0107);
            List<? extends k> list = this.k;
            if (list != null) {
                for (k kVar : list) {
                    kVar.a();
                }
            }
        }
    }

    public void k(List<? extends k> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.k = list;
        this.f53586c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k kVar = list.get(i2);
            if (kVar != null) {
                this.f53586c.addView(kVar.getView());
            }
        }
    }

    public void l(List<? extends k> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                k(list);
            }
        }
    }

    public void m(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.m = cVar;
            if (cVar == null || (textView = this.f53590g) == null) {
                return;
            }
            textView.setOnClickListener(new a(this));
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void o(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, spannableStringBuilder) == null) {
            this.j = spannableStringBuilder;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!StringUtils.isNull(this.f53592i)) {
                this.f53588e.setVisibility(0);
                this.f53588e.setText(this.f53592i);
            } else if (this.j != null) {
                this.f53588e.setVisibility(0);
                this.f53588e.setText(this.j);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f53592i = str;
        }
    }
}
