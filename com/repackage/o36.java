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
import com.repackage.f56;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class o36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public int c;
    public Context d;
    public f56 e;
    public d f;
    public m56 g;
    public boolean h;
    public f56.d i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes6.dex */
    public class a implements f56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o36 a;

        public a(o36 o36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o36Var;
        }

        @Override // com.repackage.f56.d
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o36 a;

        public b(o36 o36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g.r()) {
                return;
            }
            if (view2 == this.a.a) {
                if (this.a.e == null) {
                    this.a.e = new f56(this.a.d);
                    this.a.e.setOnDismissListener(this.a.k);
                    this.a.e.l(this.a.i);
                    this.a.e.m(this.a.b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h36(this.a.d.getString(R.string.obfuscated_res_0x7f0f09e2), 2));
                arrayList.add(new h36(this.a.d.getString(R.string.obfuscated_res_0x7f0f14d0), 1));
                this.a.e.k(arrayList, this.a.c);
                this.a.e.o(this.a.a);
            }
            this.a.h = true;
            o36 o36Var = this.a;
            o36Var.t(o36Var.h);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o36 a;

        public c(o36 o36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o36Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h = false;
                o36 o36Var = this.a;
                o36Var.t(o36Var.h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i);
    }

    public o36(Context context, int i, int i2, m56 m56Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), m56Var};
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
        this.g = m56Var;
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
        f56 f56Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (f56Var = this.e) == null) {
            return;
        }
        f56Var.i();
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
            f56 f56Var = this.e;
            if (f56Var == null || !this.h) {
                return;
            }
            f56Var.j();
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && o() && (textView = this.a) != null) {
            int i = this.c;
            if (i == 1) {
                textView.setText(R.string.obfuscated_res_0x7f0f14d0);
            } else if (i == 2) {
                textView.setText(R.string.obfuscated_res_0x7f0f09e2);
            }
            this.a.setOnClickListener(this.j);
            t(this.h);
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            int i = z ? R.drawable.obfuscated_res_0x7f080923 : R.drawable.icon_pure_unfold12_svg;
            m56 m56Var = this.g;
            b36 n = m56Var != null ? m56Var.n() : null;
            if (n != null && n.a) {
                m56 m56Var2 = this.g;
                if (m56Var2 != null && m56Var2.t()) {
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
