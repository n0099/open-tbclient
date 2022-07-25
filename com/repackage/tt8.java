package com.repackage;

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
/* loaded from: classes7.dex */
public class tt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public LinearLayout c;
    public TextView d;
    public View e;
    public TextView f;
    public String g;
    public List<b> h;
    public e i;
    public c j;
    public boolean k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public a(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public tt8 b;
        public View c;
        public TextView d;
        public View e;
        public String f;
        public int g;
        public d h;
        public boolean i;
        public boolean j;
        public final View.OnClickListener k;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.h != null) {
                        this.a.h.onClick();
                    }
                    if (this.a.b == null || this.a.b.c() == null) {
                        return;
                    }
                    this.a.b.c().a(this.a.a, view2);
                }
            }
        }

        public b(String str, tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = 17;
            this.i = true;
            this.k = new a(this);
            this.f = str;
            this.b = tt8Var;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            tt8 tt8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tt8Var = this.b) == null || tt8Var.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d015b, this.b.d(), false);
            this.c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f77);
            this.d = textView;
            textView.setText(this.f);
            this.d.setGravity(this.g);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0907c8);
            this.e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.h = dVar;
                e();
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
        void a(int i, View view2);
    }

    public tt8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d015c, (ViewGroup) null);
        this.b = inflate;
        this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0906c0);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0920be);
        this.e = this.b.findViewById(R.id.obfuscated_res_0x7f0920d0);
        this.h = new ArrayList();
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090770);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.g)) {
                this.d.setText(this.g);
                this.e.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            }
            if (this.j != null) {
                this.f.setOnClickListener(new a(this));
            }
            e();
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
            List<b> list = this.h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.g) && (textView = this.d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.h.get(0)) == null || bVar.j) {
                    return;
                }
                bVar.j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.h = list;
        this.c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }
}
