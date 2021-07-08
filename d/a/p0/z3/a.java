package d.a.p0.z3;

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
    public Context f66715a;

    /* renamed from: b  reason: collision with root package name */
    public View f66716b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f66717c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66718d;

    /* renamed from: e  reason: collision with root package name */
    public View f66719e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66720f;

    /* renamed from: g  reason: collision with root package name */
    public String f66721g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f66722h;

    /* renamed from: i  reason: collision with root package name */
    public e f66723i;
    public c j;
    public boolean k;

    /* renamed from: d.a.p0.z3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1868a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66724e;

        public View$OnClickListenerC1868a(a aVar) {
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
            this.f66724e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66724e.j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f66725a;

        /* renamed from: b  reason: collision with root package name */
        public a f66726b;

        /* renamed from: c  reason: collision with root package name */
        public View f66727c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66728d;

        /* renamed from: e  reason: collision with root package name */
        public View f66729e;

        /* renamed from: f  reason: collision with root package name */
        public String f66730f;

        /* renamed from: g  reason: collision with root package name */
        public int f66731g;

        /* renamed from: h  reason: collision with root package name */
        public d f66732h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f66733i;
        public boolean j;
        public final View.OnClickListener k;

        /* renamed from: d.a.p0.z3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1869a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f66734e;

            public View$OnClickListenerC1869a(b bVar) {
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
                this.f66734e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f66734e.f66732h != null) {
                        this.f66734e.f66732h.onClick();
                    }
                    if (this.f66734e.f66726b == null || this.f66734e.f66726b.d() == null) {
                        return;
                    }
                    this.f66734e.f66726b.d().a(this.f66734e.f66725a, view);
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
            this.f66731g = 17;
            this.f66733i = true;
            this.k = new View$OnClickListenerC1869a(this);
            this.f66730f = str;
            this.f66726b = aVar;
            this.f66725a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66727c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f66728d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f66726b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f66726b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f66726b.e(), false);
            this.f66727c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f66728d = textView;
            textView.setText(this.f66730f);
            this.f66728d.setGravity(this.f66731g);
            View findViewById = this.f66727c.findViewById(R.id.divider_line);
            this.f66729e = findViewById;
            if (this.f66733i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f66728d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f66728d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f66729e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f66732h = dVar;
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
        this.f66715a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f66716b = inflate;
        this.f66717c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f66718d = (TextView) this.f66716b.findViewById(R.id.title);
        this.f66719e = this.f66716b.findViewById(R.id.title_divide_line);
        this.f66722h = new ArrayList();
        this.f66720f = (TextView) this.f66716b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f66721g)) {
                this.f66718d.setText(this.f66721g);
                this.f66719e.setVisibility(0);
            } else {
                this.f66718d.setVisibility(8);
                this.f66719e.setVisibility(8);
            }
            if (this.j != null) {
                this.f66720f.setOnClickListener(new View$OnClickListenerC1868a(this));
            }
            f();
            return this.f66716b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66715a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66723i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66717c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f66716b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f66718d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f66718d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f66719e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f66720f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f66720f, R.color.CAM_X0107);
            List<b> list = this.f66722h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f66721g) && (textView = this.f66718d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f66718d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f66722h) > 0) {
                    b bVar2 = this.f66722h.get(0);
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
        this.f66722h = list;
        this.f66717c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f66717c.addView(bVar.d());
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
            this.f66721g = str;
        }
    }
}
