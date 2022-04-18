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
import com.repackage.k64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o64 implements n64, t64, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public q64 e;
    public List<p64> f;
    public List<p64> g;
    public List<List<p64>> h;
    public n64 i;
    public t64 j;
    public View.OnKeyListener k;
    public c l;
    public k64 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o64 a;

        public a(o64 o64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o64Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            o64 o64Var;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (o64Var = this.a).l) == null) {
                return;
            }
            cVar.a(o64Var, false);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements k64.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o64 a;

        public b(o64 o64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o64Var;
        }

        @Override // com.repackage.k64.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(o64 o64Var, boolean z);
    }

    public o64(Context context, View view2, int i, k64 k64Var, @Nullable j64 j64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), k64Var, j64Var};
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
        this.m = k64Var;
        this.p = k64Var.a();
        List<p64> b2 = r64.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        q64 q64Var = new q64(this.c, view2, j64Var);
        this.e = q64Var;
        q64Var.J(new a(this));
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
            for (p64 p64Var : this.g) {
                if (p64Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + p64Var.e());
                    p64Var.o(valueOf.longValue() > 0 ? 1 : 0);
                    p64Var.n(valueOf.longValue());
                }
            }
        }
    }

    public final p64 B(p64 p64Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p64Var, z)) == null) {
            if (p64Var == null) {
                return null;
            }
            p64Var.q(z ? R.string.obfuscated_res_0x7f0f00ef : R.string.obfuscated_res_0x7f0f00f2);
            p64Var.m(z ? R.drawable.obfuscated_res_0x7f0800e2 : R.drawable.obfuscated_res_0x7f0800f5);
            return p64Var;
        }
        return (p64) invokeLZ.objValue;
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

    @Override // com.repackage.t64
    public boolean a(p64 p64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, p64Var)) == null) {
            if (r(p64Var) && !this.a) {
                g(true);
            }
            t64 t64Var = this.j;
            if (t64Var != null) {
                return t64Var.a(p64Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.n64
    public boolean b(View view2, p64 p64Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, p64Var)) == null) {
            if (p64Var.i()) {
                if (r(p64Var)) {
                    g(true);
                }
                n64 n64Var = this.i;
                if (n64Var != null) {
                    return n64Var.b(view2, p64Var);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d(int i, int i2) {
        p64 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            boolean z = false;
            for (p64 p64Var : this.f) {
                if (p64Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = r64.a(i)) == null) {
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

    public p64 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                p64 p64Var = this.f.get(i2);
                if (p64Var != null && p64Var.c() == i) {
                    p64Var.n(0L);
                    p64Var.p(this);
                    return p64Var;
                }
            }
            return null;
        }
        return (p64) invokeI.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            q64 q64Var = this.e;
            return q64Var != null && q64Var.y();
        }
        return invokeV.booleanValue;
    }

    public void k() {
        q64 q64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (q64Var = this.e) == null) {
            return;
        }
        q64Var.V();
    }

    public final void l(int i) {
        p64 i2;
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

    public void o(n64 n64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, n64Var) == null) {
            this.i = n64Var;
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

    public final boolean r(p64 p64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, p64Var)) == null) {
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
            x(z, i);
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

    public final p64 w(p64 p64Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, p64Var, i)) == null) {
            if (p64Var == null) {
                return null;
            }
            if (i == 2) {
                p64Var.q(R.string.obfuscated_res_0x7f0f00ee);
                p64Var.m(R.drawable.obfuscated_res_0x7f0800dc);
                return p64Var;
            } else if (i == 1) {
                p64Var.q(R.string.obfuscated_res_0x7f0f00f0);
                p64Var.m(R.drawable.obfuscated_res_0x7f0800d4);
                return p64Var;
            } else if (i == 0) {
                return null;
            } else {
                return p64Var;
            }
        }
        return (p64) invokeLI.objValue;
    }

    public final void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.f == null) {
            return;
        }
        this.g.clear();
        l(41);
        p64 w = w(i(38), i);
        if (w != null && w.j()) {
            this.g.add(w);
        }
        l(48);
        l(45);
        l(4);
        l(101);
        p64 i2 = i(35);
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
        p64 B = B(i(5), z);
        if (B != null && B.j()) {
            this.g.add(B);
        }
        l(46);
        l(47);
        l(51);
        l(49);
        l(50);
        k64 k64Var = this.m;
        if (k64Var != null) {
            k64Var.f(this.d, this.f, new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<p64> b2 = r64.b(this.d);
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
