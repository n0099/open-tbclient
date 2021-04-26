package d.a.h0.h.a.j.g;

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
import com.baidu.swan.impl.map.location.LocationDetailAdapter;
import com.baidu.swan.impl.map.location.LocationFooterViewHolder;
import com.baidu.swan.impl.map.location.LocationItemDecoration;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import d.a.h0.a.e0.l.c;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.z0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends c implements d.a.h0.h.a.j.b, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public TextView A0;
    public RecyclerView B0;
    public LocationDetailAdapter C0;
    public LinearLayoutManager D0;
    public List<d.a.h0.h.a.j.c> E0;
    public InputMethodManager L0;
    public String O0;
    public boolean P0;
    public boolean Q0;
    public EditText y0;
    public View z0;
    public PoiSearch K0 = null;
    public int M0 = 0;
    public int N0 = 0;
    public String R0 = Address.Builder.BEI_JING;

    /* renamed from: d.a.h0.h.a.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0984a extends RecyclerView.OnScrollListener {
        public C0984a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int F2;
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && (F2 = a.this.F2()) >= 0 && F2 + 1 == a.this.C0.getItemCount()) {
                a.this.G2();
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
            aVar.M2(aVar.y0, true);
        }
    }

    public static a I2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.c1(bundle);
        }
        return aVar;
    }

    public final void D2() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public final View E2() {
        int F2 = F2();
        if (F2 == -1) {
            return null;
        }
        return this.D0.findViewByPosition(F2);
    }

    public final int F2() {
        LinearLayoutManager linearLayoutManager = this.D0;
        if (linearLayoutManager != null) {
            return linearLayoutManager.findLastVisibleItemPosition();
        }
        return -1;
    }

    public void G2() {
        if (this.P0) {
            return;
        }
        if (this.M0 < this.N0) {
            P2(this.O0);
            this.P0 = true;
            return;
        }
        J2();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void H2(View view) {
        this.E0 = new ArrayList(11);
        if (i() != null) {
            String string = i().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = Address.Builder.BEI_JING;
            }
            this.R0 = string;
        }
        this.y0 = (EditText) view.findViewById(R.id.search_text);
        this.B0 = (RecyclerView) view.findViewById(R.id.location_list);
        this.z0 = view.findViewById(R.id.no_result_tip);
        this.A0 = (TextView) view.findViewById(R.id.cancel_search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(f.V().getActivity());
        this.D0 = linearLayoutManager;
        this.B0.setLayoutManager(linearLayoutManager);
        LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.V().getActivity(), this.B0, this);
        this.C0 = locationDetailAdapter;
        this.B0.setAdapter(locationDetailAdapter);
        this.B0.addItemDecoration(new LocationItemDecoration(f.V().getActivity()));
        this.B0.setOnTouchListener(this);
        this.A0.setOnClickListener(this);
        PoiSearch newInstance = PoiSearch.newInstance();
        this.K0 = newInstance;
        newInstance.setOnGetPoiSearchResultListener(this);
        this.y0.addTextChangedListener(this);
        this.y0.setOnFocusChangeListener(this);
        this.y0.setOnKeyListener(this);
        this.y0.requestFocus();
        this.B0.addOnScrollListener(new C0984a());
        this.y0.postDelayed(new b(), 100L);
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        return false;
    }

    public final void J2() {
        View E2 = E2();
        if (E2 == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.B0.getChildViewHolder(E2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    public final void K2() {
        if (TextUtils.isEmpty(this.O0)) {
            return;
        }
        this.M0 = 0;
        P2(this.O0);
        M2(this.y0, false);
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
    }

    public final void L2(Intent intent) {
        if (H() == null) {
            return;
        }
        H().m0(L(), 0, intent);
    }

    public void M2(View view, boolean z) {
        if (this.L0 == null) {
            this.L0 = (InputMethodManager) f.V().getActivity().getApplicationContext().getSystemService("input_method");
        }
        InputMethodManager inputMethodManager = this.L0;
        if (inputMethodManager == null) {
            return;
        }
        if (z) {
            inputMethodManager.showSoftInput(view, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void N2(boolean z) {
        this.z0.setVisibility(z ? 0 : 8);
    }

    public void O2() {
        d.a.h0.a.e0.l.f W = f.V().W();
        if (W != null) {
            f.b i2 = W.i("navigateTo");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.j(this);
            i2.b();
        }
    }

    public final void P2(String str) {
        this.K0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.R0).keyword(str).pageCapacity(13).pageNum(this.M0));
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return true;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            this.Q0 = false;
            this.M0 = 0;
            this.N0 = 0;
            String obj = editable.toString();
            this.O0 = obj;
            P2(obj);
            return;
        }
        this.E0.clear();
        this.C0.setData(this.E0);
        this.O0 = "";
        this.M0 = 0;
        this.N0 = 0;
        this.Q0 = true;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // d.a.h0.h.a.j.b
    public void c(d.a.h0.h.a.j.c cVar) {
        Intent intent = new Intent();
        PoiInfo poiInfo = cVar.f46994a;
        if (poiInfo != null && poiInfo.location != null) {
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        L2(intent);
        D2();
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            D2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.K0.destroy();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        M2(this.y0, z);
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
        this.P0 = false;
        if (this.Q0) {
            return;
        }
        if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.N0 = poiResult.getTotalPageNum();
            if (this.M0 == 0) {
                this.E0.clear();
            }
            this.E0.addAll(d.a.h0.h.a.j.c.a(poiResult.getAllPoi()));
            this.C0.f(this.E0, this.O0);
            this.M0++;
        } else {
            if (this.M0 == 0) {
                this.N0 = 0;
                this.E0.clear();
                this.C0.setData(this.E0);
            }
            J2();
        }
        if (this.M0 == 0 && this.E0.size() == 0) {
            z = true;
        }
        N2(z);
        if (this.E0.size() <= 0) {
            J2();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 == 66) {
            K2();
            return true;
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        M2(this.y0, false);
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.h0.h.a.a.a();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        H2(inflate);
        if (K1()) {
            inflate = N1(inflate);
            o1(-1);
        }
        return u1(inflate, this);
    }
}
