package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationFooterViewHolder;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rz1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class y54 extends oz1 implements t54, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText F0;
    public View G0;
    public TextView H0;
    public RecyclerView I0;
    public LocationDetailAdapter J0;
    public LinearLayoutManager K0;
    public List<u54> L0;
    public PoiSearch M0;
    public InputMethodManager N0;
    public int O0;
    public int P0;
    public String Q0;
    public boolean R0;
    public boolean S0;
    public String T0;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;

        public a(y54 y54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y54Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int Z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (Z2 = this.a.Z2()) >= 0 && Z2 + 1 == this.a.J0.getItemCount()) {
                    this.a.a3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;

        public b(y54 y54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y54Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y54 y54Var = this.a;
                y54Var.g3(y54Var.F0, true);
            }
        }
    }

    public y54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M0 = null;
        this.O0 = 0;
        this.P0 = 0;
        this.T0 = Address.Builder.BEI_JING;
    }

    public static y54 c3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            y54 y54Var = new y54();
            if (bundle != null) {
                y54Var.j1(bundle);
            }
            return y54Var;
        }
        return (y54) invokeL.objValue;
    }

    @Override // com.repackage.oz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.oz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
        }
    }

    public final void X2() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (activity = this.c0) == null) {
            return;
        }
        activity.onBackPressed();
    }

    public final View Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int Z2 = Z2();
            if (Z2 == -1) {
                return null;
            }
            return this.K0.findViewByPosition(Z2);
        }
        return (View) invokeV.objValue;
    }

    public final int Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinearLayoutManager linearLayoutManager = this.K0;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void a3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.R0) {
            return;
        }
        if (this.O0 < this.P0) {
            j3(this.Q0);
            this.R0 = true;
            return;
        }
        d3();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editable) == null) {
            if (editable != null && editable.length() > 0) {
                this.S0 = false;
                this.O0 = 0;
                this.P0 = 0;
                String obj = editable.toString();
                this.Q0 = obj;
                j3(obj);
                return;
            }
            this.L0.clear();
            this.J0.setData(this.L0);
            this.Q0 = "";
            this.O0 = 0;
            this.P0 = 0;
            this.S0 = true;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.L0 = new ArrayList(11);
            if (p() != null) {
                String string = p().getString("city");
                if (TextUtils.isEmpty(string)) {
                    string = Address.Builder.BEI_JING;
                }
                this.T0 = string;
            }
            this.F0 = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f091cd5);
            this.I0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09136a);
            this.G0 = view2.findViewById(R.id.obfuscated_res_0x7f0915e8);
            this.H0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090476);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(vl2.U().getActivity());
            this.K0 = linearLayoutManager;
            this.I0.setLayoutManager(linearLayoutManager);
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(vl2.U().getActivity(), this.I0, this);
            this.J0 = locationDetailAdapter;
            this.I0.setAdapter(locationDetailAdapter);
            this.I0.addItemDecoration(new LocationItemDecoration(vl2.U().getActivity()));
            this.I0.setOnTouchListener(this);
            this.H0.setOnClickListener(this);
            PoiSearch newInstance = PoiSearch.newInstance();
            this.M0 = newInstance;
            newInstance.setOnGetPoiSearchResultListener(this);
            this.F0.addTextChangedListener(this);
            this.F0.setOnFocusChangeListener(this);
            this.F0.setOnKeyListener(this);
            this.F0.requestFocus();
            this.I0.addOnScrollListener(new a(this));
            this.F0.postDelayed(new b(this), 100L);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // com.repackage.oz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        View Y2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (Y2 = Y2()) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.I0.getChildViewHolder(Y2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    @Override // com.repackage.t54
    public void e(u54 u54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, u54Var) == null) {
            Intent intent = new Intent();
            PoiInfo poiInfo = u54Var.a;
            if (poiInfo != null && poiInfo.location != null) {
                intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
            }
            f3(intent);
            X2();
        }
    }

    @Override // com.repackage.oz1
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || TextUtils.isEmpty(this.Q0)) {
            return;
        }
        this.O0 = 0;
        j3(this.Q0);
        g3(this.F0, false);
    }

    public final void f3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || I() == null) {
            return;
        }
        I().q0(J(), 0, intent);
    }

    public void g3(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, view2, z) == null) {
            if (this.N0 == null) {
                this.N0 = (InputMethodManager) vl2.U().getActivity().getApplicationContext().getSystemService("input_method");
            }
            InputMethodManager inputMethodManager = this.N0;
            if (inputMethodManager == null) {
                return;
            }
            if (z) {
                inputMethodManager.showSoftInput(view2, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0);
            }
        }
    }

    public void h3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.G0.setVisibility(z ? 0 : 8);
        }
    }

    public void i3() {
        rz1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (V = vl2.U().V()) == null) {
            return;
        }
        rz1.b i = V.i("navigateTo");
        i.n(rz1.g, rz1.i);
        i.j(this);
        i.b();
    }

    @Override // com.repackage.oz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.oz1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public final void j3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.M0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.T0).keyword(str).pageCapacity(13).pageNum(this.O0));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090476) {
            X2();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, view2, z) == null) {
            g3(this.F0, z);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, poiDetailResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, poiDetailSearchResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, poiIndoorResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, poiResult) == null) {
            boolean z = false;
            this.R0 = false;
            if (this.S0) {
                return;
            }
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.P0 = poiResult.getTotalPageNum();
                if (this.O0 == 0) {
                    this.L0.clear();
                }
                this.L0.addAll(u54.a(poiResult.getAllPoi()));
                this.J0.g(this.L0, this.Q0);
                this.O0++;
            } else {
                if (this.O0 == 0) {
                    this.P0 = 0;
                    this.L0.clear();
                    this.J0.setData(this.L0);
                }
                d3();
            }
            if (this.O0 == 0 && this.L0.size() == 0) {
                z = true;
            }
            h3(z);
            if (this.L0.size() <= 0) {
                d3();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048603, this, view2, i, keyEvent)) == null) {
            if (i == 66) {
                e3();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048604, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, view2, motionEvent)) == null) {
            g3(this.F0, false);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            o44.a();
            SDKInitializer.setCoordType(CoordType.GCJ02);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0084, viewGroup, false);
            b3(inflate);
            if (T1()) {
                inflate = W1(inflate);
                w1(-1);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.y0();
            this.M0.destroy();
        }
    }
}
