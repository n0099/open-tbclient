package com.repackage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i54;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m54 implements l54, r54, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public o54 e;
    public List<n54> f;
    public List<n54> g;
    public List<List<n54>> h;
    public l54 i;
    public r54 j;
    public View.OnKeyListener k;
    public c l;
    public i54 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        public a(m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m54Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            m54 m54Var;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (m54Var = this.a).l) == null) {
                return;
            }
            cVar.a(m54Var, false);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i54.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m54 a;

        public b(m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m54Var;
        }

        @Override // com.repackage.i54.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(m54 m54Var, boolean z);
    }

    public m54(Context context, View view2, int i, i54 i54Var, @Nullable h54 h54Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), i54Var, h54Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.o = -1;
        this.p = false;
        if (i < 0) {
            return;
        }
        this.c = context;
        this.d = i;
        this.m = i54Var;
        this.p = i54Var.a();
        List<n54> b2 = p54.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        o54 o54Var = new o54(this.c, view2, h54Var);
        this.e = o54Var;
        o54Var.J(new a(this));
    }

    public void A(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            int i = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
            if (i < 0) {
                return;
            }
            for (n54 n54Var : this.g) {
                if (n54Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + n54Var.e());
                    n54Var.o(valueOf.longValue() > 0 ? 1 : 0);
                    n54Var.n(valueOf.longValue());
                }
            }
        }
    }

    public final n54 B(n54 n54Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n54Var, z)) == null) {
            if (n54Var == null) {
                return null;
            }
            n54Var.q(z ? R.string.obfuscated_res_0x7f0f00f2 : R.string.obfuscated_res_0x7f0f00f5);
            n54Var.m(z ? R.drawable.obfuscated_res_0x7f0800e2 : R.drawable.obfuscated_res_0x7f0800f5);
            return n54Var;
        }
        return (n54) invokeLZ.objValue;
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            B(i(5), z);
            v();
            this.e.S();
            k();
        }
    }

    @Override // com.repackage.r54
    public boolean a(n54 n54Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, n54Var)) == null) {
            if (r(n54Var) && !this.a) {
                g(true);
            }
            r54 r54Var = this.j;
            if (r54Var != null) {
                return r54Var.a(n54Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.l54
    public boolean b(View view2, n54 n54Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, n54Var)) == null) {
            if (n54Var.i()) {
                if (r(n54Var)) {
                    g(true);
                }
                l54 l54Var = this.i;
                if (l54Var != null) {
                    return l54Var.b(view2, n54Var);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d(int i, int i2) {
        n54 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            boolean z = false;
            for (n54 n54Var : this.f) {
                if (n54Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = p54.a(i)) == null) {
                return;
            }
            int size = this.f.size();
            if (i2 <= 0) {
                i2 = 0;
            } else if (i2 >= size) {
                i2 = size;
            }
            this.f.add(i2, a2);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            g(true);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e.T(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public n54 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                n54 n54Var = this.f.get(i2);
                if (n54Var != null && n54Var.c() == i) {
                    n54Var.n(0L);
                    n54Var.p(this);
                    return n54Var;
                }
            }
            return null;
        }
        return (n54) invokeI.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o54 o54Var = this.e;
            return o54Var != null && o54Var.y();
        }
        return invokeV.booleanValue;
    }

    public void k() {
        o54 o54Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (o54Var = this.e) == null) {
            return;
        }
        o54Var.V();
    }

    public final void l(int i) {
        n54 i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (i2 = i(i)) != null && i2.j()) {
            this.g.add(i2);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || this.f == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            if (this.f.get(i3).c() == i) {
                i2 = i3;
            }
        }
        if (i2 > -1) {
            this.f.remove(i2);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e.W(i);
        }
    }

    public void o(l54 l54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, l54Var) == null) {
            this.i = l54Var;
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048592, this, view2, i, keyEvent)) == null) {
            View.OnKeyListener onKeyListener = this.k;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view2, i, keyEvent);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
        }
    }

    public final boolean r(n54 n54Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, n54Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            t(z, 0);
        }
    }

    public void t(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            u(z, i, null, false);
        }
    }

    public void u(boolean z, int i, View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), view2, Boolean.valueOf(z2)}) == null) {
            if (j()) {
                g(true);
                return;
            }
            y(z, i);
            v();
            this.e.X(this.h, view2, z2, this.b);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h.clear();
            if (this.m.a()) {
                this.h.add(this.g);
                return;
            }
            int size = this.g.size();
            if (size > 0 && size <= 5) {
                this.h.add(this.g);
            } else if (size > 5 && size <= 10) {
                int i = this.a ? 5 : this.o;
                this.h.add(this.g.subList(0, i));
                this.h.add(this.g.subList(i, size));
            } else if (size > 10) {
                int ceil = this.a ? (int) Math.ceil(size / 2.0f) : this.o;
                this.h.add(this.g.subList(0, ceil));
                this.h.add(this.g.subList(ceil, size));
            }
        }
    }

    public final n54 w(n54 n54Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, n54Var, i)) == null) {
            if (n54Var == null) {
                return null;
            }
            if (i == 2) {
                n54Var.q(R.string.obfuscated_res_0x7f0f00f1);
                n54Var.m(R.drawable.obfuscated_res_0x7f0800dc);
                return n54Var;
            } else if (i == 1) {
                n54Var.q(R.string.obfuscated_res_0x7f0f00f3);
                n54Var.m(R.drawable.obfuscated_res_0x7f0800d4);
                return n54Var;
            } else if (i == 0) {
                return null;
            } else {
                return n54Var;
            }
        }
        return (n54) invokeLI.objValue;
    }

    public final void y(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.f == null) {
            return;
        }
        this.g.clear();
        l(41);
        n54 w = w(i(38), i);
        if (w != null && w.j()) {
            this.g.add(w);
        }
        l(48);
        l(45);
        l(4);
        l(101);
        n54 i2 = i(35);
        if (i2 != null && i2.j()) {
            this.g.add(i2);
        }
        l(39);
        l(42);
        l(9);
        if (!this.a) {
            this.o = this.g.size() - 1;
        }
        l(37);
        if (this.n) {
            l(43);
        }
        n54 B = B(i(5), z);
        if (B != null && B.j()) {
            this.g.add(B);
        }
        l(46);
        l(47);
        l(51);
        l(49);
        l(50);
        i54 i54Var = this.m;
        if (i54Var != null) {
            i54Var.f(this.d, this.f, new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<n54> b2 = p54.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        v();
        k();
    }
}
