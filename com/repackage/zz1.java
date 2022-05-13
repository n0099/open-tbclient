package com.repackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yz2;
import com.repackage.z53;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class zz1 extends a02 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean J0;
    public static String K0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter F0;
    public final List<u53> G0;
    public FrameLayout H0;
    public boolean I0;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz1 a;

        public a(zz1 zz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.I0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz1 a;

        public b(zz1 zz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.I0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u53 a;
        public final /* synthetic */ zz1 b;

        public c(zz1 zz1Var, u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var, u53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zz1Var;
            this.a = u53Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.c3().d0().z(zz1.K0, true);
                this.b.g3(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nf3<Map<String, u53>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz1 a;

        public d(zz1 zz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Map<String, u53> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || (activity = this.a.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c03.b(this.a.H0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, u53> entry : map.entrySet()) {
                u53 value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.d && value.b() && "2".equals(value.e) && !"snsapi_base".equals(value.b)) {
                    this.a.G0.add(value);
                }
            }
            this.a.i3();
            this.a.F0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz1 a;

        public e(zz1 zz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public u53 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (u53) this.a.G0.get(i) : (u53) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.G0.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? getItem(i).hashCode() : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null || !(view2.getTag() instanceof g)) {
                    view2 = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d00d3, null);
                    g gVar = new g(this.a);
                    gVar.b = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f090608);
                    gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092071);
                    view2.setTag(gVar);
                }
                g gVar2 = (g) view2.getTag();
                u53 item = getItem(i);
                String str = TextUtils.isEmpty(item.g) ? item.f : item.g;
                TextView textView = gVar2.a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.b.setChecked(item.a());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u53 a;
        public final /* synthetic */ zz1 b;

        public f(zz1 zz1Var, u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var, u53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zz1Var;
            this.a = u53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) || (activity = this.b.getActivity()) == null) {
                return;
            }
            c03.b(this.b.H0);
            if (x53Var != null && x53Var.c()) {
                this.b.h3(this.a, x53Var.a.b);
            } else {
                m03.f(activity, R.string.obfuscated_res_0x7f0f01bb).G();
            }
            this.b.I0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public CheckBox b;
        public final /* synthetic */ zz1 c;

        public g(zz1 zz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zz1Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755094816, "Lcom/repackage/zz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755094816, "Lcom/repackage/zz1;");
                return;
            }
        }
        J0 = eh1.a;
        K0 = "pref_close_scope_alert_showed";
    }

    public zz1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.G0 = new ArrayList();
        this.I0 = false;
    }

    public static zz1 e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new zz1() : (zz1) invokeV.objValue;
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i0 = null;
            super.C0();
        }
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            d3();
        }
    }

    @Override // com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            U1(view2);
            s2(-1);
            B2(-16777216);
            u2(H(R.string.obfuscated_res_0x7f0f0410));
            w2(true);
            I2(false);
        }
    }

    public final void a3(u53 u53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, u53Var, z) == null) {
            u03 c3 = c3();
            if (c3 == null) {
                this.I0 = false;
                return;
            }
            c03.g(getActivity(), this.H0);
            c3.d0().d(getActivity(), u53Var.b, false, z, true, new f(this, u53Var));
        }
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final BaseAdapter b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public u03 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? hm2.U().D() : (u03) invokeV.objValue;
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c03.g(getActivity(), this.H0);
            this.G0.clear();
            this.F0.notifyDataSetChanged();
            ss2.h(new d(this));
        }
    }

    public final void f3(u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, u53Var) == null) {
            yz2.a aVar = new yz2.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f01be);
            aVar.v(R.string.obfuscated_res_0x7f0f01bd);
            aVar.n(new cg3());
            aVar.O(R.string.obfuscated_res_0x7f0f01bc, new c(this, u53Var));
            aVar.B(R.string.obfuscated_res_0x7f0f010a, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void g3(u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, u53Var) == null) {
            a3(u53Var, !u53Var.a());
        }
    }

    public final void h3(u53 u53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, u53Var, z) == null) {
            u53Var.j = z ? 1 : -1;
            this.F0.notifyDataSetChanged();
        }
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void i3() {
        View S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (S = S()) == null) {
            return;
        }
        boolean isEmpty = this.G0.isEmpty();
        TextView textView = (TextView) S.findViewById(R.id.obfuscated_res_0x7f09206c);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(I(R.string.obfuscated_res_0x7f0f01bf, c3().Y()));
        }
        View findViewById = S.findViewById(R.id.obfuscated_res_0x7f090e14);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) S.findViewById(R.id.obfuscated_res_0x7f0908bb);
        if (isEmpty) {
            textView2.setText(I(R.string.obfuscated_res_0x7f0f01ba, c3().Y()));
        }
    }

    @Override // com.repackage.a02, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.I0) {
            return;
        }
        u53 u53Var = this.G0.get(i);
        this.I0 = true;
        if (u53Var.a() && !c3().d0().m(K0, false)) {
            f3(u53Var);
            return;
        }
        s53.k("onItemClick : " + u53Var, Boolean.FALSE);
        g3(u53Var);
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onPause()");
            }
        }
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            G2(1);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onResume()");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            super.s0(activity);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.v0(bundle);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00d2, viewGroup, false);
            T1(inflate);
            this.H0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0906cd);
            this.F0 = b3();
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f09017b);
            listView.setAdapter((ListAdapter) this.F0);
            listView.setOnItemClickListener(this);
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.z0();
            u03 c3 = c3();
            if (c3 != null) {
                c3.d0().v();
            }
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
            }
        }
    }
}
