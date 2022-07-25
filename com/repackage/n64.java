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
import com.repackage.j64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n64 implements m64, s64, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public p64 e;
    public List<o64> f;
    public List<o64> g;
    public List<List<o64>> h;
    public m64 i;
    public s64 j;
    public View.OnKeyListener k;
    public c l;
    public j64 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n64 a;

        public a(n64 n64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n64Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            n64 n64Var;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (n64Var = this.a).l) == null) {
                return;
            }
            cVar.a(n64Var, false);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements j64.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n64 a;

        public b(n64 n64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n64Var;
        }

        @Override // com.repackage.j64.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.k(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(n64 n64Var, boolean z);
    }

    public n64(Context context, View view2, int i, j64 j64Var, @Nullable i64 i64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), j64Var, i64Var};
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
        this.m = j64Var;
        this.p = j64Var.a();
        List<o64> b2 = q64.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        p64 p64Var = new p64(this.c, view2, i64Var);
        this.e = p64Var;
        p64Var.I(new a(this));
    }

    public final o64 A(o64 o64Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, o64Var, z)) == null) {
            if (o64Var == null) {
                return null;
            }
            o64Var.q(z ? R.string.obfuscated_res_0x7f0f00f4 : R.string.obfuscated_res_0x7f0f00f7);
            o64Var.m(z ? R.drawable.obfuscated_res_0x7f0800e1 : R.drawable.obfuscated_res_0x7f0800f4);
            return o64Var;
        }
        return (o64) invokeLZ.objValue;
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            A(h(5), z);
            v();
            this.e.S();
            j();
        }
    }

    @Override // com.repackage.s64
    public boolean a(o64 o64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o64Var)) == null) {
            if (q(o64Var) && !this.a) {
                g(true);
            }
            s64 s64Var = this.j;
            if (s64Var != null) {
                return s64Var.a(o64Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.m64
    public boolean b(View view2, o64 o64Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, o64Var)) == null) {
            if (o64Var.i()) {
                if (q(o64Var)) {
                    g(true);
                }
                m64 m64Var = this.i;
                if (m64Var != null) {
                    return m64Var.b(view2, o64Var);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d(int i, int i2) {
        o64 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            boolean z = false;
            for (o64 o64Var : this.f) {
                if (o64Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = q64.a(i)) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d = i;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g(true);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e.T(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public o64 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                o64 o64Var = this.f.get(i2);
                if (o64Var != null && o64Var.c() == i) {
                    o64Var.n(0L);
                    o64Var.p(this);
                    return o64Var;
                }
            }
            return null;
        }
        return (o64) invokeI.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            p64 p64Var = this.e;
            return p64Var != null && p64Var.x();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (p64Var = this.e) == null) {
            return;
        }
        p64Var.V();
    }

    public final void k(int i) {
        o64 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (h = h(i)) != null && h.j()) {
            this.g.add(h);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.f == null) {
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

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.e.W(i);
        }
    }

    public void n(m64 m64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, m64Var) == null) {
            this.i = m64Var;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b = i;
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

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
        }
    }

    public final boolean q(o64 o64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, o64Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            t(z, 0);
        }
    }

    public void t(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            u(z, i, null, false);
        }
    }

    public void u(boolean z, int i, View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), view2, Boolean.valueOf(z2)}) == null) {
            if (i()) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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

    public final o64 w(o64 o64Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, o64Var, i)) == null) {
            if (o64Var == null) {
                return null;
            }
            if (i == 2) {
                o64Var.q(R.string.obfuscated_res_0x7f0f00f3);
                o64Var.m(R.drawable.obfuscated_res_0x7f0800db);
                return o64Var;
            } else if (i == 1) {
                o64Var.q(R.string.obfuscated_res_0x7f0f00f5);
                o64Var.m(R.drawable.obfuscated_res_0x7f0800d3);
                return o64Var;
            } else if (i == 0) {
                return null;
            } else {
                return o64Var;
            }
        }
        return (o64) invokeLI.objValue;
    }

    public final void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.f == null) {
            return;
        }
        this.g.clear();
        k(41);
        o64 w = w(h(38), i);
        if (w != null && w.j()) {
            this.g.add(w);
        }
        k(48);
        k(45);
        k(4);
        k(101);
        o64 h = h(35);
        if (h != null && h.j()) {
            this.g.add(h);
        }
        k(39);
        k(42);
        k(9);
        if (!this.a) {
            this.o = this.g.size() - 1;
        }
        k(37);
        if (this.n) {
            k(43);
        }
        o64 A = A(h(5), z);
        if (A != null && A.j()) {
            this.g.add(A);
        }
        k(46);
        k(47);
        k(51);
        k(49);
        k(50);
        j64 j64Var = this.m;
        if (j64Var != null) {
            j64Var.f(this.d, this.f, new b(this));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<o64> b2 = q64.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        v();
        j();
    }

    public void z(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            int i = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
            if (i < 0) {
                return;
            }
            for (o64 o64Var : this.g) {
                if (o64Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + o64Var.e());
                    o64Var.o(valueOf.longValue() > 0 ? 1 : 0);
                    o64Var.n(valueOf.longValue());
                }
            }
        }
    }
}
