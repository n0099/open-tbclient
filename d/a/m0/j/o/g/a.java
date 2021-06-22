package d.a.m0.j.o.g;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import d.a.m0.a.h0.g.d;
import d.a.m0.a.h0.g.g;
import d.a.m0.j.e;
import d.a.m0.j.f;
import d.a.m0.j.o.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d implements d.a.m0.j.o.b, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public EditText C0;
    public View D0;
    public TextView E0;
    public RecyclerView F0;
    public LocationDetailAdapter G0;
    public LinearLayoutManager H0;
    public List<c> I0;
    public InputMethodManager K0;
    public String N0;
    public boolean O0;
    public boolean P0;
    public PoiSearch J0 = null;
    public int L0 = 0;
    public int M0 = 0;
    public String Q0 = Address.Builder.BEI_JING;

    /* renamed from: d.a.m0.j.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1131a extends RecyclerView.OnScrollListener {
        public C1131a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int M2;
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && (M2 = a.this.M2()) >= 0 && M2 + 1 == a.this.G0.getItemCount()) {
                a.this.N2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.T2(aVar.C0, true);
        }
    }

    public static a P2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.j1(bundle);
        }
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.m0.j.a.a();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(f.ai_apps_location_search, viewGroup, false);
        O2(inflate);
        if (P1()) {
            inflate = S1(inflate);
            u1(-1);
        }
        return A1(inflate, this);
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        return false;
    }

    public final void K2() {
        Activity activity = this.k0;
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public final View L2() {
        int M2 = M2();
        if (M2 == -1) {
            return null;
        }
        return this.H0.findViewByPosition(M2);
    }

    public final int M2() {
        LinearLayoutManager linearLayoutManager = this.H0;
        if (linearLayoutManager != null) {
            return linearLayoutManager.findLastVisibleItemPosition();
        }
        return -1;
    }

    public void N2() {
        if (this.O0) {
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(d.a.m0.a.g1.f.V().getActivity());
        this.H0 = linearLayoutManager;
        this.F0.setLayoutManager(linearLayoutManager);
        LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(d.a.m0.a.g1.f.V().getActivity(), this.F0, this);
        this.G0 = locationDetailAdapter;
        this.F0.setAdapter(locationDetailAdapter);
        this.F0.addItemDecoration(new LocationItemDecoration(d.a.m0.a.g1.f.V().getActivity()));
        this.F0.setOnTouchListener(this);
        this.E0.setOnClickListener(this);
        PoiSearch newInstance = PoiSearch.newInstance();
        this.J0 = newInstance;
        newInstance.setOnGetPoiSearchResultListener(this);
        this.C0.addTextChangedListener(this);
        this.C0.setOnFocusChangeListener(this);
        this.C0.setOnKeyListener(this);
        this.C0.requestFocus();
        this.F0.addOnScrollListener(new C1131a());
        this.C0.postDelayed(new b(), 100L);
    }

    @Override // d.a.m0.a.h0.g.d
    public void Q1(View view) {
    }

    public final void Q2() {
        View L2 = L2();
        if (L2 == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.F0.getChildViewHolder(L2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    public final void R2() {
        if (TextUtils.isEmpty(this.N0)) {
            return;
        }
        this.L0 = 0;
        W2(this.N0);
        T2(this.C0, false);
    }

    public final void S2(Intent intent) {
        if (P() == null) {
            return;
        }
        P().v0(R(), 0, intent);
    }

    public void T2(View view, boolean z) {
        if (this.K0 == null) {
            this.K0 = (InputMethodManager) d.a.m0.a.g1.f.V().getActivity().getApplicationContext().getSystemService("input_method");
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

    public void U2(boolean z) {
        this.D0.setVisibility(z ? 0 : 8);
    }

    public void V2() {
        g W = d.a.m0.a.g1.f.V().W();
        if (W != null) {
            g.b i2 = W.i("navigateTo");
            i2.n(g.f45860g, g.f45862i);
            i2.j(this);
            i2.b();
        }
    }

    public final void W2(String str) {
        this.J0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.Q0).keyword(str).pageCapacity(13).pageNum(this.L0));
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
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

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // d.a.m0.j.o.b
    public void c(c cVar) {
        Intent intent = new Intent();
        PoiInfo poiInfo = cVar.f51677a;
        if (poiInfo != null && poiInfo.location != null) {
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        S2(intent);
        K2();
    }

    @Override // d.a.m0.a.h0.g.d
    public void e2() {
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.cancel_search) {
            K2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.J0.destroy();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        T2(this.C0, z);
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
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

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 == 66) {
            R2();
            return true;
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        T2(this.C0, false);
        return false;
    }
}
