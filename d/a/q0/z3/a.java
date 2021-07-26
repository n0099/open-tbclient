package d.a.q0.z3;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67393a;

    /* renamed from: b  reason: collision with root package name */
    public View f67394b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f67395c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67396d;

    /* renamed from: e  reason: collision with root package name */
    public View f67397e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f67398f;

    /* renamed from: g  reason: collision with root package name */
    public String f67399g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f67400h;

    /* renamed from: i  reason: collision with root package name */
    public e f67401i;
    public c j;
    public boolean k;

    /* renamed from: d.a.q0.z3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1873a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67402e;

        public View$OnClickListenerC1873a(a aVar) {
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
            this.f67402e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f67402e.j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f67403a;

        /* renamed from: b  reason: collision with root package name */
        public a f67404b;

        /* renamed from: c  reason: collision with root package name */
        public View f67405c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67406d;

        /* renamed from: e  reason: collision with root package name */
        public View f67407e;

        /* renamed from: f  reason: collision with root package name */
        public String f67408f;

        /* renamed from: g  reason: collision with root package name */
        public int f67409g;

        /* renamed from: h  reason: collision with root package name */
        public d f67410h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f67411i;
        public boolean j;
        public final View.OnClickListener k;

        /* renamed from: d.a.q0.z3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1874a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f67412e;

            public View$OnClickListenerC1874a(b bVar) {
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
                this.f67412e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f67412e.f67410h != null) {
                        this.f67412e.f67410h.onClick();
                    }
                    if (this.f67412e.f67404b == null || this.f67412e.f67404b.d() == null) {
                        return;
                    }
                    this.f67412e.f67404b.d().a(this.f67412e.f67403a, view);
                }
            }
        }

        public b(String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67409g = 17;
            this.f67411i = true;
            this.k = new View$OnClickListenerC1874a(this);
            this.f67408f = str;
            this.f67404b = aVar;
            this.f67403a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67405c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f67406d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f67404b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f67404b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f67404b.e(), false);
            this.f67405c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f67406d = textView;
            textView.setText(this.f67408f);
            this.f67406d.setGravity(this.f67409g);
            View findViewById = this.f67405c.findViewById(R.id.divider_line);
            this.f67407e = findViewById;
            if (this.f67411i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f67406d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f67406d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f67407e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f67410h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2, View view);
    }

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
        if (context == null) {
            return;
        }
        this.f67393a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f67394b = inflate;
        this.f67395c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f67396d = (TextView) this.f67394b.findViewById(R.id.title);
        this.f67397e = this.f67394b.findViewById(R.id.title_divide_line);
        this.f67400h = new ArrayList();
        this.f67398f = (TextView) this.f67394b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f67399g)) {
                this.f67396d.setText(this.f67399g);
                this.f67397e.setVisibility(0);
            } else {
                this.f67396d.setVisibility(8);
                this.f67397e.setVisibility(8);
            }
            if (this.j != null) {
                this.f67398f.setOnClickListener(new View$OnClickListenerC1873a(this));
            }
            f();
            return this.f67394b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67393a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67401i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67395c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f67394b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f67396d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f67396d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f67397e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f67398f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f67398f, R.color.CAM_X0107);
            List<b> list = this.f67400h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f67399g) && (textView = this.f67396d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f67396d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f67400h) > 0) {
                    b bVar2 = this.f67400h.get(0);
                    if (bVar2.j) {
                        return;
                    }
                    bVar2.j = true;
                    bVar2.g();
                }
            }
        }
    }

    public void g(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f67400h = list;
        this.f67395c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f67395c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f67399g = str;
        }
    }
}
