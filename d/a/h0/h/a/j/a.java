package d.a.h0.h.a.j;

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
import com.baidu.swan.impl.map.location.FlipperFrameLayout;
import com.baidu.swan.impl.map.location.LocationDetailAdapter;
import com.baidu.swan.impl.map.location.LocationItemDecoration;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.h0;
import d.a.h0.a.z0.f;
import d.a.h0.h.a.j.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.a.h0.a.e0.l.c implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, d.a.h0.h.a.j.b, e.b {
    public static final int b1 = h0.f(20.0f);
    public ImageView A0;
    public FrameLayout B0;
    public FrameLayout C0;
    public View D0;
    public View E0;
    public TextView K0;
    public ImageView L0;
    public View M0;
    public GeoCoder N0;
    public BaiduMap O0;
    public TextureMapView P0;
    public Marker Q0;
    public BitmapDescriptor R0;
    public c S0;
    public List<c> T0;
    public e U0;
    public LocationDetailAdapter V0;
    public d W0;
    public boolean X0;
    public boolean Y0;
    public b Z0;
    public SelectedLocationInfo a1;
    public RecyclerView y0;
    public FrameLayout z0;

    /* renamed from: d.a.h0.h.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0980a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f46992e;

        public RunnableC0980a(ReverseGeoCodeResult reverseGeoCodeResult) {
            this.f46992e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.R2(this.f46992e);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a H2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.c1(bundle);
        }
        return aVar;
    }

    public final void B2() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.L0, "translationY", 0.0f, -b1, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public final void C2() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.onBackPressed();
        }
        this.Z0 = null;
    }

    public final void D2(LatLng latLng) {
        this.N0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.E0(i2, strArr, iArr);
        if (i2 == 3001) {
            if (iArr.length > 0 && iArr[0] == -1) {
                d.a.h0.a.q1.b.f.d.e(f.V().getActivity(), R.string.aiapps_location_permission_fail).C();
            } else if (iArr.length <= 0 || iArr[0] != 0) {
            } else {
                P2();
            }
        }
    }

    public final void E2(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.T0 = new ArrayList(11);
        this.y0 = (RecyclerView) view.findViewById(R.id.location_list);
        this.A0 = (ImageView) view.findViewById(R.id.float_btn);
        this.z0 = (FrameLayout) view.findViewById(R.id.float_container);
        this.D0 = view.findViewById(R.id.cancel);
        this.E0 = view.findViewById(R.id.search);
        this.K0 = (TextView) view.findViewById(R.id.finish);
        this.L0 = (ImageView) view.findViewById(R.id.center_ding);
        this.B0 = (FrameLayout) view.findViewById(R.id.list_container);
        this.C0 = (FrameLayout) view.findViewById(R.id.map_container);
        this.M0 = view.findViewById(R.id.loading_progress);
        this.P0 = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.A0.setOnClickListener(this);
        this.K0.setOnClickListener(this);
        this.E0.setOnClickListener(this);
        this.D0.setOnClickListener(this);
        this.N0 = GeoCoder.newInstance();
        this.O0 = this.P0.getMap();
        this.N0.setOnGetGeoCodeResultListener(this);
        this.O0.setOnMapLoadedCallback(this);
        this.O0.setOnMapStatusChangeListener(this);
        this.y0.setLayoutManager(new LinearLayoutManager(f.V().getActivity()));
        LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.V().getActivity(), this.y0, this, false);
        this.V0 = locationDetailAdapter;
        this.y0.setAdapter(locationDetailAdapter);
        this.y0.addItemDecoration(new LocationItemDecoration(f.V().getActivity(), true));
        d dVar = new d(this.B0, this.C0, this.z0);
        this.W0 = dVar;
        ((FlipperFrameLayout) this.B0).setViewFlipper(dVar);
    }

    public final void F2() {
        this.O0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.O0.getUiSettings().setRotateGesturesEnabled(false);
        this.P0.showZoomControls(false);
        this.P0.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (G2()) {
            return;
        }
        P2();
    }

    public final boolean G2() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (f.V().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (arrayList.size() > 0) {
                a1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        K2(17);
        return false;
    }

    public final void I2(LatLng latLng, boolean z, boolean z2) {
        N2(true);
        D2(latLng);
        J2();
        if (z) {
            B2();
            if (this.W0.d()) {
                this.W0.e(false);
            }
        }
        if (z2) {
            this.y0.smoothScrollToPosition(0);
        }
    }

    public final void J2() {
        Marker marker = this.Q0;
        if (marker != null) {
            marker.remove();
            this.Q0 = null;
        }
    }

    public final void K2(int i2) {
        b bVar = this.Z0;
        if (bVar == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.S0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f46994a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.Z0.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
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

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
    }

    public final void L2(boolean z) {
        if (this.A0 != null) {
            this.A0.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    public void M2(b bVar) {
        this.Z0 = bVar;
    }

    public final void N2(boolean z) {
        if (z) {
            this.T0.clear();
            this.V0.setData(this.T0);
        }
        this.M0.setVisibility(z ? 0 : 8);
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

    public final void P2() {
        e eVar = new e(d.a.h0.a.z0.f.V().getActivity(), this.O0);
        this.U0 = eVar;
        eVar.n(true);
        this.U0.k(this);
        N2(true);
    }

    public final void Q2(c cVar) {
        if (cVar == null || cVar.f46994a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f46994a.city);
        d.a.h0.h.a.j.g.a I2 = d.a.h0.h.a.j.g.a.I2(bundle);
        I2.e1(this, 1);
        I2.O2();
    }

    public final void R2(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        SelectedLocationInfo selectedLocationInfo = this.a1;
        if (selectedLocationInfo != null) {
            poiInfo.name = selectedLocationInfo.mName;
            SelectedLocationInfo selectedLocationInfo2 = this.a1;
            poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
            poiInfo.address = this.a1.mAddress;
            this.a1 = null;
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
        this.T0.clear();
        this.T0.add(cVar);
        this.T0.addAll(c.a(reverseGeoCodeResult.getPoiList()));
        this.V0.setData(this.T0);
        this.S0 = cVar;
        if (this.T0.size() > 0) {
            N2(false);
        }
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

    @Override // d.a.h0.h.a.j.e.b
    public void b(BDLocation bDLocation) {
        D2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // d.a.h0.h.a.j.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        if (cVar == null || (poiInfo = cVar.f46994a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.S0 = cVar;
        this.O0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        J2();
        if (this.R0 == null) {
            this.R0 = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
        }
        if (!cVar.f46996c) {
            this.Q0 = (Marker) this.O0.addOverlay(new MarkerOptions().position(cVar.f46994a.location).zIndex(88).icon(this.R0));
        }
        if (cVar.f46996c) {
            return;
        }
        L2(false);
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void m0(int i2, int i3, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        super.m0(i2, i3, intent);
        if (intent == null || i2 != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
            return;
        }
        double d2 = selectedLocationInfo.mLatitude;
        double d3 = selectedLocationInfo.mLongitude;
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            return;
        }
        this.a1 = selectedLocationInfo;
        LatLng latLng = new LatLng(d2, d3);
        this.O0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.Y0 = true;
        I2(latLng, false, true);
        L2(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            e eVar = this.U0;
            if (eVar == null || eVar.i() == null) {
                return;
            }
            BDLocation i2 = this.U0.i();
            LatLng latLng = new LatLng(i2.getLatitude(), i2.getLongitude());
            this.O0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            J2();
            if (this.Y0) {
                I2(latLng, true, true);
                this.Y0 = false;
            }
            L2(true);
        } else if (view.getId() == R.id.finish) {
            K2(16);
            C2();
        } else if (view.getId() == R.id.search) {
            Q2(this.S0);
        } else if (view.getId() == R.id.cancel) {
            K2(17);
            C2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.P0.onDestroy();
        }
        this.N0.destroy();
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
            return;
        }
        this.y0.postDelayed(new RunnableC0980a(reverseGeoCodeResult), 150L);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        D2(this.O0.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.X0) {
            I2(mapStatus.target, true, true);
            L2(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        boolean z = false;
        boolean z2 = i2 == 1;
        this.X0 = z2;
        this.Y0 = (z2 || this.Y0) ? true : true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.P0.onPause();
        e eVar = this.U0;
        if (eVar != null) {
            eVar.n(false);
        }
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.P0.onResume();
        e eVar = this.U0;
        if (eVar != null) {
            eVar.n(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.h0.h.a.a.a();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        E2(inflate);
        F2();
        if (K1()) {
            inflate = N1(inflate);
            o1(-1);
        }
        return u1(inflate, this);
    }
}
