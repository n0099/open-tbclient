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
import com.repackage.c76;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class m56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public Context c;
    public c76 d;
    public d e;
    public j76 f;
    public boolean g;
    public c76.d h;
    public View.OnClickListener i;
    public PopupWindow.OnDismissListener j;

    /* loaded from: classes6.dex */
    public class a implements c76.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        public a(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // com.repackage.c76.d
        public void onItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.b = i;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i == 1 ? 2 : 1));
                this.a.r();
                if (this.a.e != null) {
                    this.a.e.a(this.a.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        public b(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f.r()) {
                return;
            }
            if (view2 == this.a.a) {
                if (this.a.d == null) {
                    this.a.d = new c76(this.a.c);
                    this.a.d.setOnDismissListener(this.a.j);
                    this.a.d.l(this.a.h);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new f56(this.a.c.getString(R.string.obfuscated_res_0x7f0f09d4), 2));
                arrayList.add(new f56(this.a.c.getString(R.string.obfuscated_res_0x7f0f14d7), 1));
                this.a.d.k(arrayList, this.a.b);
                this.a.d.n(this.a.a);
            }
            this.a.g = true;
            m56 m56Var = this.a;
            m56Var.s(m56Var.g);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        public c(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g = false;
                m56 m56Var = this.a;
                m56Var.s(m56Var.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i);
    }

    public m56(Context context, int i, int i2, j76 j76Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), j76Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
        this.c = context;
        this.b = i;
        this.f = j76Var;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.b;
            return i == 2 || i == 1;
        }
        return invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }

    public void p() {
        c76 c76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c76Var = this.d) == null) {
            return;
        }
        c76Var.i();
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (n()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i);
                if (this.a != null) {
                    s(this.g);
                }
            }
            c76 c76Var = this.d;
            if (c76Var == null || !this.g) {
                return;
            }
            c76Var.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && n() && (textView = this.a) != null) {
            int i = this.b;
            if (i == 1) {
                textView.setText(R.string.obfuscated_res_0x7f0f14d7);
            } else if (i == 2) {
                textView.setText(R.string.obfuscated_res_0x7f0f09d4);
            }
            this.a.setOnClickListener(this.i);
            s(this.g);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            int i = z ? R.drawable.obfuscated_res_0x7f080914 : R.drawable.icon_pure_unfold12_svg;
            j76 j76Var = this.f;
            z46 n = j76Var != null ? j76Var.n() : null;
            if (n != null && n.a) {
                j76 j76Var2 = this.f;
                if (j76Var2 != null && j76Var2.t()) {
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

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && n()) {
            this.b = i;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.a = textView;
        }
    }
}
