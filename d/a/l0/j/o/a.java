package d.a.l0.j.o;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.swan.map.location.FlipperFrameLayout;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.v2.n0;
import d.a.l0.j.f;
import d.a.l0.j.g;
import d.a.l0.j.o.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.h0.g.d implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, d.a.l0.j.o.b, e.b {
    public static final int a1 = n0.g(20.0f);
    public FrameLayout A0;
    public FrameLayout B0;
    public View C0;
    public View D0;
    public TextView E0;
    public ImageView F0;
    public View G0;
    public GeoCoder M0;
    public BaiduMap N0;
    public TextureMapView O0;
    public Marker P0;
    public BitmapDescriptor Q0;
    public c R0;
    public List<c> S0;
    public e T0;
    public LocationDetailAdapter U0;
    public d V0;
    public boolean W0;
    public boolean X0;
    public b Y0;
    public SelectedLocationInfo Z0;
    public RecyclerView x0;
    public FrameLayout y0;
    public ImageView z0;

    /* renamed from: d.a.l0.j.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1126a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f51567e;

        public RunnableC1126a(ReverseGeoCodeResult reverseGeoCodeResult) {
            this.f51567e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.Y2(this.f51567e);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a O2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.j1(bundle);
        }
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.l0.j.a.a();
        View inflate = layoutInflater.inflate(f.ai_apps_location_choose, viewGroup, false);
        L2(inflate);
        M2();
        if (P1()) {
            inflate = S1(inflate);
            u1(-1);
        }
        return A1(inflate, this);
    }

    public final void I2() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F0, "translationY", 0.0f, -a1, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public final void J2() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.onBackPressed();
        }
        this.Y0 = null;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        R2(17);
        return false;
    }

    public final void K2(LatLng latLng) {
        this.M0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.L0(i2, strArr, iArr);
        if (i2 == 3001) {
            if (iArr.length > 0 && iArr[0] == -1) {
                d.a.l0.a.z1.b.f.e.f(d.a.l0.a.g1.f.V().getActivity(), g.aiapps_location_permission_fail).F();
            } else if (iArr.length <= 0 || iArr[0] != 0) {
            } else {
                W2();
            }
        }
    }

    public final void L2(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.S0 = new ArrayList(11);
        this.x0 = (RecyclerView) view.findViewById(d.a.l0.j.e.location_list);
        this.z0 = (ImageView) view.findViewById(d.a.l0.j.e.float_btn);
        this.y0 = (FrameLayout) view.findViewById(d.a.l0.j.e.float_container);
        this.C0 = view.findViewById(d.a.l0.j.e.cancel);
        this.D0 = view.findViewById(d.a.l0.j.e.search);
        this.E0 = (TextView) view.findViewById(d.a.l0.j.e.finish);
        this.F0 = (ImageView) view.findViewById(d.a.l0.j.e.center_ding);
        this.A0 = (FrameLayout) view.findViewById(d.a.l0.j.e.list_container);
        this.B0 = (FrameLayout) view.findViewById(d.a.l0.j.e.map_container);
        this.G0 = view.findViewById(d.a.l0.j.e.loading_progress);
        this.O0 = (TextureMapView) view.findViewById(d.a.l0.j.e.bdMapView);
        this.z0.setOnClickListener(this);
        this.E0.setOnClickListener(this);
        this.D0.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.M0 = GeoCoder.newInstance();
        this.N0 = this.O0.getMap();
        this.M0.setOnGetGeoCodeResultListener(this);
        this.N0.setOnMapLoadedCallback(this);
        this.N0.setOnMapStatusChangeListener(this);
        this.x0.setLayoutManager(new LinearLayoutManager(d.a.l0.a.g1.f.V().getActivity()));
        LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(d.a.l0.a.g1.f.V().getActivity(), this.x0, this, false);
        this.U0 = locationDetailAdapter;
        this.x0.setAdapter(locationDetailAdapter);
        this.x0.addItemDecoration(new LocationItemDecoration(d.a.l0.a.g1.f.V().getActivity(), true));
        d dVar = new d(this.A0, this.B0, this.y0);
        this.V0 = dVar;
        ((FlipperFrameLayout) this.A0).setViewFlipper(dVar);
    }

    public final void M2() {
        this.N0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.N0.getUiSettings().setRotateGesturesEnabled(false);
        this.O0.showZoomControls(false);
        this.O0.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (N2()) {
            return;
        }
        W2();
    }

    public final boolean N2() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (d.a.l0.a.g1.f.V().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (arrayList.size() > 0) {
                h1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                return true;
            }
        }
        return false;
    }

    public final void P2(LatLng latLng, boolean z, boolean z2) {
        U2(true);
        K2(latLng);
        Q2();
        if (z) {
            I2();
            if (this.V0.d()) {
                this.V0.e(false);
            }
        }
        if (z2) {
            this.x0.smoothScrollToPosition(0);
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public void Q1(View view) {
    }

    public final void Q2() {
        Marker marker = this.P0;
        if (marker != null) {
            marker.remove();
            this.P0 = null;
        }
    }

    public final void R2(int i2) {
        b bVar = this.Y0;
        if (bVar == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.R0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f51569a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.Y0.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                    return;
                }
                return;
            case 17:
                bVar.onCancel();
                return;
            case 18:
                bVar.onError();
                return;
            default:
                return;
        }
    }

    public final void S2(boolean z) {
        if (this.z0 != null) {
            this.z0.setImageResource(z ? d.a.l0.j.d.aiapps_location_go_my_point_selected : d.a.l0.j.d.aiapps_location_go_my_point);
        }
    }

    public void T2(b bVar) {
        this.Y0 = bVar;
    }

    public final void U2(boolean z) {
        if (z) {
            this.S0.clear();
            this.U0.setData(this.S0);
        }
        this.G0.setVisibility(z ? 0 : 8);
    }

    public void V2() {
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W != null) {
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.l0.a.h0.g.g.f45752g, d.a.l0.a.h0.g.g.f45754i);
            i2.j(this);
            i2.b();
        }
    }

    public final void W2() {
        e eVar = new e(d.a.l0.a.g1.f.V().getActivity(), this.N0);
        this.T0 = eVar;
        eVar.n(true);
        this.T0.k(this);
        U2(true);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    public final void X2(c cVar) {
        if (cVar == null || cVar.f51569a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f51569a.city);
        d.a.l0.j.o.g.a P2 = d.a.l0.j.o.g.a.P2(bundle);
        P2.l1(this, 1);
        P2.V2();
    }

    public final void Y2(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        SelectedLocationInfo selectedLocationInfo = this.Z0;
        if (selectedLocationInfo != null) {
            poiInfo.name = selectedLocationInfo.mName;
            SelectedLocationInfo selectedLocationInfo2 = this.Z0;
            poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
            poiInfo.address = this.Z0.mAddress;
            this.Z0 = null;
            z = false;
        } else {
            String address = reverseGeoCodeResult.getAddress();
            String sematicDescription = reverseGeoCodeResult.getSematicDescription();
            if (TextUtils.isEmpty(address)) {
                address = "[位置]";
            }
            poiInfo.name = address;
            poiInfo.location = reverseGeoCodeResult.getLocation();
            poiInfo.address = sematicDescription;
            ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
            if (addressDetail != null) {
                poiInfo.city = addressDetail.city;
            }
            z = true;
        }
        c cVar = new c(poiInfo, true, z);
        this.S0.clear();
        this.S0.add(cVar);
        this.S0.addAll(c.a(reverseGeoCodeResult.getPoiList()));
        this.U0.setData(this.S0);
        this.R0 = cVar;
        if (this.S0.size() > 0) {
            U2(false);
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.l0.j.o.e.b
    public void a(BDLocation bDLocation) {
        K2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // d.a.l0.j.o.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        if (cVar == null || (poiInfo = cVar.f51569a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.R0 = cVar;
        this.N0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        Q2();
        if (this.Q0 == null) {
            this.Q0 = BitmapDescriptorFactory.fromResource(d.a.l0.j.d.aiapps_location_selected);
        }
        if (!cVar.f51571c) {
            this.P0 = (Marker) this.N0.addOverlay(new MarkerOptions().position(cVar.f51569a.location).zIndex(88).icon(this.Q0));
        }
        if (cVar.f51571c) {
            return;
        }
        S2(false);
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.l0.j.e.float_btn) {
            e eVar = this.T0;
            if (eVar == null || eVar.i() == null) {
                return;
            }
            BDLocation i2 = this.T0.i();
            LatLng latLng = new LatLng(i2.getLatitude(), i2.getLongitude());
            this.N0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            Q2();
            if (this.X0) {
                P2(latLng, true, true);
                this.X0 = false;
            }
            S2(true);
        } else if (view.getId() == d.a.l0.j.e.finish) {
            R2(16);
            J2();
        } else if (view.getId() == d.a.l0.j.e.search) {
            X2(this.R0);
        } else if (view.getId() == d.a.l0.j.e.cancel) {
            R2(17);
            J2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.O0.onDestroy();
        }
        this.M0.destroy();
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
            return;
        }
        this.x0.postDelayed(new RunnableC1126a(reverseGeoCodeResult), 150L);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        K2(this.N0.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.W0) {
            P2(mapStatus.target, true, true);
            S2(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        boolean z = false;
        boolean z2 = i2 == 1;
        this.W0 = z2;
        this.X0 = (z2 || this.X0) ? true : true;
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.O0.onPause();
        e eVar = this.T0;
        if (eVar != null) {
            eVar.n(false);
        }
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.O0.onResume();
        e eVar = this.T0;
        if (eVar != null) {
            eVar.n(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(int i2, int i3, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        super.v0(i2, i3, intent);
        if (intent == null || i2 != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
            return;
        }
        double d2 = selectedLocationInfo.mLatitude;
        double d3 = selectedLocationInfo.mLongitude;
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            return;
        }
        this.Z0 = selectedLocationInfo;
        LatLng latLng = new LatLng(d2, d3);
        this.N0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.X0 = true;
        P2(latLng, false, true);
        S2(false);
    }
}
