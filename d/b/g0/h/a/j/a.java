package d.b.g0.h.a.j;

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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.z0.f;
import d.b.g0.h.a.j.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.e0.l.c implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, d.b.g0.h.a.j.b, e.b {
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

    /* renamed from: d.b.g0.h.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1009a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f48769e;

        public RunnableC1009a(ReverseGeoCodeResult reverseGeoCodeResult) {
            this.f48769e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.S2(this.f48769e);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    public static a I2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.d1(bundle);
        }
        return aVar;
    }

    public final void C2() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.L0, "translationY", 0.0f, -b1, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public final void D2() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.onBackPressed();
        }
        this.Z0 = null;
    }

    public final void E2(LatLng latLng) {
        this.N0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void F0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.F0(i, strArr, iArr);
        if (i == 3001) {
            if (iArr.length > 0 && iArr[0] == -1) {
                d.b.g0.a.q1.b.f.d.e(f.V().getActivity(), R.string.aiapps_location_permission_fail).C();
            } else if (iArr.length <= 0 || iArr[0] != 0) {
            } else {
                Q2();
            }
        }
    }

    public final void F2(View view) {
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

    public final void G2() {
        this.O0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
        this.O0.getUiSettings().setRotateGesturesEnabled(false);
        this.P0.showZoomControls(false);
        this.P0.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (H2()) {
            return;
        }
        Q2();
    }

    public final boolean H2() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (f.V().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (arrayList.size() > 0) {
                b1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                return true;
            }
        }
        return false;
    }

    public final void J2(LatLng latLng, boolean z, boolean z2) {
        O2(true);
        E2(latLng);
        K2();
        if (z) {
            C2();
            if (this.W0.d()) {
                this.W0.e(false);
            }
        }
        if (z2) {
            this.y0.smoothScrollToPosition(0);
        }
    }

    public final void K2() {
        Marker marker = this.Q0;
        if (marker != null) {
            marker.remove();
            this.Q0 = null;
        }
    }

    public final void L2(int i) {
        b bVar = this.Z0;
        if (bVar == null) {
            return;
        }
        switch (i) {
            case 16:
                c cVar = this.S0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f48771a;
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

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
    }

    public final void M2(boolean z) {
        if (this.A0 != null) {
            this.A0.setImageResource(z ? R.drawable.aiapps_location_go_my_point_selected : R.drawable.aiapps_location_go_my_point);
        }
    }

    public void N2(b bVar) {
        this.Z0 = bVar;
    }

    public final void O2(boolean z) {
        if (z) {
            this.T0.clear();
            this.V0.setData(this.T0);
        }
        this.M0.setVisibility(z ? 0 : 8);
    }

    public void P2() {
        d.b.g0.a.e0.l.f W = f.V().W();
        if (W != null) {
            f.b i = W.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44013g, d.b.g0.a.e0.l.f.i);
            i.j(this);
            i.b();
        }
    }

    public final void Q2() {
        e eVar = new e(d.b.g0.a.z0.f.V().getActivity(), this.O0);
        this.U0 = eVar;
        eVar.n(true);
        this.U0.k(this);
        O2(true);
    }

    public final void R2(c cVar) {
        if (cVar == null || cVar.f48771a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f48771a.city);
        d.b.g0.h.a.j.g.a J2 = d.b.g0.h.a.j.g.a.J2(bundle);
        J2.f1(this, 1);
        J2.P2();
    }

    public final void S2(ReverseGeoCodeResult reverseGeoCodeResult) {
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
            O2(false);
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
    }

    @Override // d.b.g0.h.a.j.e.b
    public void b(BDLocation bDLocation) {
        E2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // d.b.g0.h.a.j.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        if (cVar == null || (poiInfo = cVar.f48771a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.S0 = cVar;
        this.O0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        K2();
        if (this.R0 == null) {
            this.R0 = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_selected);
        }
        if (!cVar.f48773c) {
            this.Q0 = (Marker) this.O0.addOverlay(new MarkerOptions().position(cVar.f48771a.location).zIndex(88).icon(this.R0));
        }
        if (cVar.f48773c) {
            return;
        }
        M2(false);
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.float_btn) {
            e eVar = this.U0;
            if (eVar == null || eVar.i() == null) {
                return;
            }
            BDLocation i = this.U0.i();
            LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
            this.O0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            K2();
            if (this.Y0) {
                J2(latLng, true, true);
                this.Y0 = false;
            }
            M2(true);
        } else if (view.getId() == R.id.finish) {
            L2(16);
            D2();
        } else if (view.getId() == R.id.search) {
            R2(this.S0);
        } else if (view.getId() == R.id.cancel) {
            L2(17);
            D2();
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
        this.y0.postDelayed(new RunnableC1009a(reverseGeoCodeResult), 150L);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        E2(this.O0.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.X0) {
            J2(mapStatus.target, true, true);
            M2(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        boolean z2 = i == 1;
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

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.P0.onResume();
        e eVar = this.U0;
        if (eVar != null) {
            eVar.n(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void p0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        super.p0(i, i2, intent);
        if (intent == null || i != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
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
        J2(latLng, false, true);
        M2(false);
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        L2(17);
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.g0.h.a.a.a();
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_choose, viewGroup, false);
        F2(inflate);
        G2();
        if (L1()) {
            inflate = O1(inflate);
            p1(-1);
        }
        return v1(inflate, this);
    }
}
