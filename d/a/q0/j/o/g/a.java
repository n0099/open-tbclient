package d.a.q0.j.o.g;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.g.d;
import d.a.q0.a.h0.g.g;
import d.a.q0.j.e;
import d.a.q0.j.f;
import d.a.q0.j.o.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d implements d.a.q0.j.o.b, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText C0;
    public View D0;
    public TextView E0;
    public RecyclerView F0;
    public LocationDetailAdapter G0;
    public LinearLayoutManager H0;
    public List<c> I0;
    public PoiSearch J0;
    public InputMethodManager K0;
    public int L0;
    public int M0;
    public String N0;
    public boolean O0;
    public boolean P0;
    public String Q0;

    /* renamed from: d.a.q0.j.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1191a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53847a;

        public C1191a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53847a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int M2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && (M2 = this.f53847a.M2()) >= 0 && M2 + 1 == this.f53847a.G0.getItemCount()) {
                    this.f53847a.N2();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53848e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53848e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f53848e;
                aVar.T2(aVar.C0, true);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J0 = null;
        this.L0 = 0;
        this.M0 = 0;
        this.Q0 = Address.Builder.BEI_JING;
    }

    public static a P2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.j1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            d.a.q0.j.a.a();
            SDKInitializer.setCoordType(CoordType.GCJ02);
            View inflate = layoutInflater.inflate(f.ai_apps_location_search, viewGroup, false);
            O2(inflate);
            if (P1()) {
                inflate = S1(inflate);
                u1(-1);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K2() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (activity = this.k0) == null) {
            return;
        }
        activity.onBackPressed();
    }

    public final View L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int M2 = M2();
            if (M2 == -1) {
                return null;
            }
            return this.H0.findViewByPosition(M2);
        }
        return (View) invokeV.objValue;
    }

    public final int M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinearLayoutManager linearLayoutManager = this.H0;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.O0) {
            return;
        }
        if (this.L0 < this.M0) {
            W2(this.N0);
            this.O0 = true;
            return;
        }
        Q2();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void O2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.I0 = new ArrayList(11);
            if (n() != null) {
                String string = n().getString("city");
                if (TextUtils.isEmpty(string)) {
                    string = Address.Builder.BEI_JING;
                }
                this.Q0 = string;
            }
            this.C0 = (EditText) view.findViewById(e.search_text);
            this.F0 = (RecyclerView) view.findViewById(e.location_list);
            this.D0 = view.findViewById(e.no_result_tip);
            this.E0 = (TextView) view.findViewById(e.cancel_search);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(d.a.q0.a.g1.f.V().getActivity());
            this.H0 = linearLayoutManager;
            this.F0.setLayoutManager(linearLayoutManager);
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(d.a.q0.a.g1.f.V().getActivity(), this.F0, this);
            this.G0 = locationDetailAdapter;
            this.F0.setAdapter(locationDetailAdapter);
            this.F0.addItemDecoration(new LocationItemDecoration(d.a.q0.a.g1.f.V().getActivity()));
            this.F0.setOnTouchListener(this);
            this.E0.setOnClickListener(this);
            PoiSearch newInstance = PoiSearch.newInstance();
            this.J0 = newInstance;
            newInstance.setOnGetPoiSearchResultListener(this);
            this.C0.addTextChangedListener(this);
            this.C0.setOnFocusChangeListener(this);
            this.C0.setOnKeyListener(this);
            this.C0.requestFocus();
            this.F0.addOnScrollListener(new C1191a(this));
            this.C0.postDelayed(new b(this), 100L);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
        }
    }

    public final void Q2() {
        View L2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (L2 = L2()) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.F0.getChildViewHolder(L2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || TextUtils.isEmpty(this.N0)) {
            return;
        }
        this.L0 = 0;
        W2(this.N0);
        T2(this.C0, false);
    }

    public final void S2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, intent) == null) || P() == null) {
            return;
        }
        P().v0(R(), 0, intent);
    }

    public void T2(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view, z) == null) {
            if (this.K0 == null) {
                this.K0 = (InputMethodManager) d.a.q0.a.g1.f.V().getActivity().getApplicationContext().getSystemService("input_method");
            }
            InputMethodManager inputMethodManager = this.K0;
            if (inputMethodManager == null) {
                return;
            }
            if (z) {
                inputMethodManager.showSoftInput(view, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public void U2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.D0.setVisibility(z ? 0 : 8);
        }
    }

    public void V2() {
        g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (W = d.a.q0.a.g1.f.V().W()) == null) {
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(g.f48010g, g.f48012i);
        i2.j(this);
        i2.b();
    }

    public final void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.J0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.Q0).keyword(str).pageCapacity(13).pageNum(this.L0));
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editable) == null) {
            if (editable != null && editable.length() > 0) {
                this.P0 = false;
                this.L0 = 0;
                this.M0 = 0;
                String obj = editable.toString();
                this.N0 = obj;
                W2(obj);
                return;
            }
            this.I0.clear();
            this.G0.setData(this.I0);
            this.N0 = "";
            this.L0 = 0;
            this.M0 = 0;
            this.P0 = true;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // d.a.q0.j.o.b
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            Intent intent = new Intent();
            PoiInfo poiInfo = cVar.f53821a;
            if (poiInfo != null && poiInfo.location != null) {
                intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
            }
            S2(intent);
            K2();
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view) == null) && view.getId() == e.cancel_search) {
            K2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            this.J0.destroy();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, view, z) == null) {
            T2(this.C0, z);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, poiDetailResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, poiDetailSearchResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, poiIndoorResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, poiResult) == null) {
            boolean z = false;
            this.O0 = false;
            if (this.P0) {
                return;
            }
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.M0 = poiResult.getTotalPageNum();
                if (this.L0 == 0) {
                    this.I0.clear();
                }
                this.I0.addAll(c.a(poiResult.getAllPoi()));
                this.G0.p(this.I0, this.N0);
                this.L0++;
            } else {
                if (this.L0 == 0) {
                    this.M0 = 0;
                    this.I0.clear();
                    this.G0.setData(this.I0);
                }
                Q2();
            }
            if (this.L0 == 0 && this.I0.size() == 0) {
                z = true;
            }
            U2(z);
            if (this.I0.size() <= 0) {
                Q2();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, view, i2, keyEvent)) == null) {
            if (i2 == 66) {
                R2();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048606, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, view, motionEvent)) == null) {
            T2(this.C0, false);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
