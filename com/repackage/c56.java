package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i76;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public int c;
    public Context d;
    public i76 e;
    public d f;
    public p76 g;
    public boolean h;
    public i76.d i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes5.dex */
    public class a implements i76.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c56 a;

        public a(c56 c56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c56Var;
        }

        @Override // com.repackage.i76.d
        public void onItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.c = i;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i == 1 ? 2 : 1));
                this.a.s();
                if (this.a.f != null) {
                    this.a.f.a(this.a.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c56 a;

        public b(c56 c56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g.r()) {
                return;
            }
            if (view2 == this.a.a) {
                if (this.a.e == null) {
                    this.a.e = new i76(this.a.d);
                    this.a.e.setOnDismissListener(this.a.k);
                    this.a.e.l(this.a.i);
                    this.a.e.m(this.a.b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new s46(this.a.d.getString(R.string.obfuscated_res_0x7f0f09d5), 2));
                arrayList.add(new s46(this.a.d.getString(R.string.obfuscated_res_0x7f0f1492), 1));
                this.a.e.k(arrayList, this.a.c);
                this.a.e.o(this.a.a);
            }
            this.a.h = true;
            c56 c56Var = this.a;
            c56Var.t(c56Var.h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c56 a;

        public c(c56 c56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c56Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h = false;
                c56 c56Var = this.a;
                c56Var.t(c56Var.h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    public c56(Context context, int i, int i2, p76 p76Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), p76Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.d = context;
        this.c = i;
        this.b = i2;
        this.g = p76Var;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.c;
            return i == 2 || i == 1;
        }
        return invokeV.booleanValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public void q() {
        i76 i76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i76Var = this.e) == null) {
            return;
        }
        i76Var.i();
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i);
                if (this.a != null) {
                    t(this.h);
                }
            }
            i76 i76Var = this.e;
            if (i76Var == null || !this.h) {
                return;
            }
            i76Var.j();
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && o() && (textView = this.a) != null) {
            int i = this.c;
            if (i == 1) {
                textView.setText(R.string.obfuscated_res_0x7f0f1492);
            } else if (i == 2) {
                textView.setText(R.string.obfuscated_res_0x7f0f09d5);
            }
            this.a.setOnClickListener(this.j);
            t(this.h);
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            int i = z ? R.drawable.obfuscated_res_0x7f080905 : R.drawable.icon_pure_unfold12_svg;
            p76 p76Var = this.g;
            m46 n = p76Var != null ? p76Var.n() : null;
            if (n != null && n.a) {
                p76 p76Var2 = this.g;
                if (p76Var2 != null && p76Var2.t()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                    this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
            this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && o()) {
            this.c = i;
            s();
        }
    }

    public void v(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f = dVar;
        }
    }

    public void w(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.a = textView;
        }
    }
}
