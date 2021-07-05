package d.a.s0.z3;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f69912a;

    /* renamed from: b  reason: collision with root package name */
    public View f69913b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f69914c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f69915d;

    /* renamed from: e  reason: collision with root package name */
    public View f69916e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f69917f;

    /* renamed from: g  reason: collision with root package name */
    public String f69918g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f69919h;

    /* renamed from: i  reason: collision with root package name */
    public e f69920i;
    public c j;
    public boolean k;

    /* renamed from: d.a.s0.z3.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1909a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f69921e;

        public View$OnClickListenerC1909a(a aVar) {
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
            this.f69921e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f69921e.j.onClick();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f69922a;

        /* renamed from: b  reason: collision with root package name */
        public a f69923b;

        /* renamed from: c  reason: collision with root package name */
        public View f69924c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f69925d;

        /* renamed from: e  reason: collision with root package name */
        public View f69926e;

        /* renamed from: f  reason: collision with root package name */
        public String f69927f;

        /* renamed from: g  reason: collision with root package name */
        public int f69928g;

        /* renamed from: h  reason: collision with root package name */
        public d f69929h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f69930i;
        public boolean j;
        public final View.OnClickListener k;

        /* renamed from: d.a.s0.z3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1910a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f69931e;

            public View$OnClickListenerC1910a(b bVar) {
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
                this.f69931e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f69931e.f69929h != null) {
                        this.f69931e.f69929h.onClick();
                    }
                    if (this.f69931e.f69923b == null || this.f69931e.f69923b.d() == null) {
                        return;
                    }
                    this.f69931e.f69923b.d().a(this.f69931e.f69922a, view);
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
            this.f69928g = 17;
            this.f69930i = true;
            this.k = new View$OnClickListenerC1910a(this);
            this.f69927f = str;
            this.f69923b = aVar;
            this.f69922a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69924c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f69925d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f69923b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f69923b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f69923b.e(), false);
            this.f69924c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f69925d = textView;
            textView.setText(this.f69927f);
            this.f69925d.setGravity(this.f69928g);
            View findViewById = this.f69924c.findViewById(R.id.divider_line);
            this.f69926e = findViewById;
            if (this.f69930i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f69925d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f69925d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f69926e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f69929h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes9.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes9.dex */
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
        this.f69912a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f69913b = inflate;
        this.f69914c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f69915d = (TextView) this.f69913b.findViewById(R.id.title);
        this.f69916e = this.f69913b.findViewById(R.id.title_divide_line);
        this.f69919h = new ArrayList();
        this.f69917f = (TextView) this.f69913b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f69918g)) {
                this.f69915d.setText(this.f69918g);
                this.f69916e.setVisibility(0);
            } else {
                this.f69915d.setVisibility(8);
                this.f69916e.setVisibility(8);
            }
            if (this.j != null) {
                this.f69917f.setOnClickListener(new View$OnClickListenerC1909a(this));
            }
            f();
            return this.f69913b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69912a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69920i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69914c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f69913b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f69915d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f69915d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f69916e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f69917f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f69917f, R.color.CAM_X0107);
            List<b> list = this.f69919h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f69918g) && (textView = this.f69915d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f69915d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f69919h) > 0) {
                    b bVar2 = this.f69919h.get(0);
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
        this.f69919h = list;
        this.f69914c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f69914c.addView(bVar.d());
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
            this.f69918g = str;
        }
    }
}
