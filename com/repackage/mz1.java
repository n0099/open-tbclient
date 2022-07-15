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
import com.repackage.lz2;
import com.repackage.m53;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class mz1 extends nz1 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean J0;
    public static String K0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter F0;
    public final List<h53> G0;
    public FrameLayout H0;
    public boolean I0;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz1 a;

        public a(mz1 mz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.I0 = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz1 a;

        public b(mz1 mz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.I0 = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h53 a;
        public final /* synthetic */ mz1 b;

        public c(mz1 mz1Var, h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var, h53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz1Var;
            this.a = h53Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.d3().e0().z(mz1.K0, true);
                this.b.h3(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements af3<Map<String, h53>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz1 a;

        public d(mz1 mz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Map<String, h53> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || (activity = this.a.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            pz2.b(this.a.H0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, h53> entry : map.entrySet()) {
                h53 value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.d && value.b() && "2".equals(value.e) && !"snsapi_base".equals(value.b)) {
                    this.a.G0.add(value);
                }
            }
            this.a.j3();
            this.a.F0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz1 a;

        public e(mz1 mz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public h53 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (h53) this.a.G0.get(i) : (h53) invokeI.objValue;
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
                    view2 = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d00ce, null);
                    g gVar = new g(this.a);
                    gVar.b = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f0905e2);
                    gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920bc);
                    view2.setTag(gVar);
                }
                g gVar2 = (g) view2.getTag();
                h53 item = getItem(i);
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

    /* loaded from: classes6.dex */
    public class f implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h53 a;
        public final /* synthetic */ mz1 b;

        public f(mz1 mz1Var, h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var, h53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz1Var;
            this.a = h53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) || (activity = this.b.getActivity()) == null) {
                return;
            }
            pz2.b(this.b.H0);
            if (k53Var != null && k53Var.c()) {
                this.b.i3(this.a, k53Var.a.b);
            } else {
                zz2.f(activity, R.string.obfuscated_res_0x7f0f01be).G();
            }
            this.b.I0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public CheckBox b;
        public final /* synthetic */ mz1 c;

        public g(mz1 mz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mz1Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755482099, "Lcom/repackage/mz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755482099, "Lcom/repackage/mz1;");
                return;
            }
        }
        J0 = rg1.a;
        K0 = "pref_close_scope_alert_showed";
    }

    public mz1() {
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

    public static mz1 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new mz1() : (mz1) invokeV.objValue;
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i0 = null;
            super.B0();
        }
    }

    @Override // com.repackage.nz1
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
            e3();
        }
    }

    @Override // com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            V1(view2);
            t2(-1);
            C2(-16777216);
            v2(G(R.string.obfuscated_res_0x7f0f040d));
            x2(true);
            J2(false);
        }
    }

    public final void b3(h53 h53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, h53Var, z) == null) {
            h03 d3 = d3();
            if (d3 == null) {
                this.I0 = false;
                return;
            }
            pz2.g(getActivity(), this.H0);
            d3.e0().d(getActivity(), h53Var.b, false, z, true, new f(this, h53Var));
        }
    }

    @Override // com.repackage.nz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final BaseAdapter c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public h03 d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ul2.U().D() : (h03) invokeV.objValue;
    }

    @Override // com.repackage.nz1
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            pz2.g(getActivity(), this.H0);
            this.G0.clear();
            this.F0.notifyDataSetChanged();
            fs2.h(new d(this));
        }
    }

    public final void g3(h53 h53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, h53Var) == null) {
            lz2.a aVar = new lz2.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f01c1);
            aVar.v(R.string.obfuscated_res_0x7f0f01c0);
            aVar.n(new pf3());
            aVar.O(R.string.obfuscated_res_0x7f0f01bf, new c(this, h53Var));
            aVar.B(R.string.obfuscated_res_0x7f0f010d, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void h3(h53 h53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, h53Var) == null) {
            b3(h53Var, !h53Var.a());
        }
    }

    public final void i3(h53 h53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, h53Var, z) == null) {
            h53Var.j = z ? 1 : -1;
            this.F0.notifyDataSetChanged();
        }
    }

    @Override // com.repackage.nz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.nz1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void j3() {
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (U = U()) == null) {
            return;
        }
        boolean isEmpty = this.G0.isEmpty();
        TextView textView = (TextView) U.findViewById(R.id.obfuscated_res_0x7f0920b7);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(H(R.string.obfuscated_res_0x7f0f01c2, d3().Z()));
        }
        View findViewById = U.findViewById(R.id.obfuscated_res_0x7f090dd8);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) U.findViewById(R.id.obfuscated_res_0x7f090893);
        if (isEmpty) {
            textView2.setText(H(R.string.obfuscated_res_0x7f0f01bd, d3().Z()));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.I0) {
            return;
        }
        h53 h53Var = this.G0.get(i);
        this.I0 = true;
        if (h53Var.a() && !d3().e0().m(K0, false)) {
            g3(h53Var);
            return;
        }
        f53.k("onItemClick : " + h53Var, Boolean.FALSE);
        h3(h53Var);
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onPause()");
            }
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            H2(1);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onResume()");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            super.r0(activity);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.u0(bundle);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00cd, viewGroup, false);
            U1(inflate);
            this.H0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0906a0);
            this.F0 = c3();
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090179);
            listView.setAdapter((ListAdapter) this.F0);
            listView.setOnItemClickListener(this);
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.y0();
            h03 d3 = d3();
            if (d3 != null) {
                d3.e0().v();
            }
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
            }
        }
    }
}
