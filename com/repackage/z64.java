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
import com.repackage.v64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z64 implements y64, e74, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public b74 e;
    public List<a74> f;
    public List<a74> g;
    public List<List<a74>> h;
    public y64 i;
    public e74 j;
    public View.OnKeyListener k;
    public c l;
    public v64 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes7.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z64 a;

        public a(z64 z64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z64Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            z64 z64Var;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (z64Var = this.a).l) == null) {
                return;
            }
            cVar.a(z64Var, false);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements v64.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z64 a;

        public b(z64 z64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z64Var;
        }

        @Override // com.repackage.v64.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(z64 z64Var, boolean z);
    }

    public z64(Context context, View view2, int i, v64 v64Var, @Nullable u64 u64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), v64Var, u64Var};
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
        this.m = v64Var;
        this.p = v64Var.a();
        List<a74> b2 = c74.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        b74 b74Var = new b74(this.c, view2, u64Var);
        this.e = b74Var;
        b74Var.J(new a(this));
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
            for (a74 a74Var : this.g) {
                if (a74Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + a74Var.e());
                    a74Var.o(valueOf.longValue() > 0 ? 1 : 0);
                    a74Var.n(valueOf.longValue());
                }
            }
        }
    }

    public final a74 B(a74 a74Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a74Var, z)) == null) {
            if (a74Var == null) {
                return null;
            }
            a74Var.q(z ? R.string.obfuscated_res_0x7f0f00f1 : R.string.obfuscated_res_0x7f0f00f4);
            a74Var.m(z ? R.drawable.obfuscated_res_0x7f0800e2 : R.drawable.obfuscated_res_0x7f0800f5);
            return a74Var;
        }
        return (a74) invokeLZ.objValue;
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

    @Override // com.repackage.e74
    public boolean a(a74 a74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, a74Var)) == null) {
            if (r(a74Var) && !this.a) {
                g(true);
            }
            e74 e74Var = this.j;
            if (e74Var != null) {
                return e74Var.a(a74Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.y64
    public boolean b(View view2, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, a74Var)) == null) {
            if (a74Var.i()) {
                if (r(a74Var)) {
                    g(true);
                }
                y64 y64Var = this.i;
                if (y64Var != null) {
                    return y64Var.b(view2, a74Var);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d(int i, int i2) {
        a74 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            boolean z = false;
            for (a74 a74Var : this.f) {
                if (a74Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = c74.a(i)) == null) {
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

    public a74 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                a74 a74Var = this.f.get(i2);
                if (a74Var != null && a74Var.c() == i) {
                    a74Var.n(0L);
                    a74Var.p(this);
                    return a74Var;
                }
            }
            return null;
        }
        return (a74) invokeI.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b74 b74Var = this.e;
            return b74Var != null && b74Var.y();
        }
        return invokeV.booleanValue;
    }

    public void k() {
        b74 b74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (b74Var = this.e) == null) {
            return;
        }
        b74Var.V();
    }

    public final void l(int i) {
        a74 i2;
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

    public void o(y64 y64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, y64Var) == null) {
            this.i = y64Var;
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

    public final boolean r(a74 a74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, a74Var)) == null) {
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

    public final a74 w(a74 a74Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, a74Var, i)) == null) {
            if (a74Var == null) {
                return null;
            }
            if (i == 2) {
                a74Var.q(R.string.obfuscated_res_0x7f0f00f0);
                a74Var.m(R.drawable.obfuscated_res_0x7f0800dc);
                return a74Var;
            } else if (i == 1) {
                a74Var.q(R.string.obfuscated_res_0x7f0f00f2);
                a74Var.m(R.drawable.obfuscated_res_0x7f0800d4);
                return a74Var;
            } else if (i == 0) {
                return null;
            } else {
                return a74Var;
            }
        }
        return (a74) invokeLI.objValue;
    }

    public final void y(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.f == null) {
            return;
        }
        this.g.clear();
        l(41);
        a74 w = w(i(38), i);
        if (w != null && w.j()) {
            this.g.add(w);
        }
        l(48);
        l(45);
        l(4);
        l(101);
        a74 i2 = i(35);
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
        a74 B = B(i(5), z);
        if (B != null && B.j()) {
            this.g.add(B);
        }
        l(46);
        l(47);
        l(51);
        l(49);
        l(50);
        v64 v64Var = this.m;
        if (v64Var != null) {
            v64Var.f(this.d, this.f, new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<a74> b2 = c74.b(this.d);
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
