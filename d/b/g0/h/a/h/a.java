package d.b.g0.h.a.h;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.impl.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.k;
import d.b.g0.h.a.m.c;
import d.b.g0.i.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.e0.l.c implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public String A0 = "";
    public Marker B0;
    public String C0;
    public String D0;
    public ImageView E0;
    public TextView K0;
    public TextView L0;
    public GeoCoder M0;
    public PopupWindow N0;
    public OpenLocationBottomMenu O0;
    public View P0;
    public ImageView Q0;
    public d.b.g0.h.a.m.c R0;
    public BDLocation S0;
    public boolean T0;
    public ArrayList<String> U0;
    public TextureMapView y0;
    public BaiduMap z0;

    /* renamed from: d.b.g0.h.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1019a implements View.OnClickListener {
        public View$OnClickListenerC1019a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a3();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OnGetGeoCoderResultListener {
        public b() {
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                a.this.K0.setText(R.string.unknown_location_info);
                return;
            }
            if (a.this.L0 != null && TextUtils.isEmpty(a.this.D0)) {
                String address = reverseGeoCodeResult.getAddress();
                a aVar = a.this;
                if (address == null) {
                    address = aVar.u().getString(R.string.unknown_location_info);
                }
                aVar.D0 = address;
                a.this.L0.setText(a.this.D0);
            }
            if (a.this.K0 != null && TextUtils.isEmpty(a.this.C0)) {
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                a aVar2 = a.this;
                if (sematicDescription == null) {
                    sematicDescription = aVar2.u().getString(R.string.unknown_location_info);
                }
                aVar2.C0 = sematicDescription;
                a.this.K0.setText(a.this.C0);
            }
            d.b.g0.a.c0.c.g("map", "mAddress +" + a.this.D0 + " mName" + a.this.C0);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.M2();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PopupWindow.b {
        public d() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            a.this.Z2(1.0f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.R0 == null || a.this.R0.i() == null) {
                return;
            }
            BDLocation i = a.this.R0.i();
            a.this.z0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.b {
        public f() {
        }

        @Override // d.b.g0.h.a.m.c.b
        public void b(BDLocation bDLocation) {
            a.this.S0 = bDLocation;
        }
    }

    static {
        boolean z = k.f45443a;
    }

    public static a W2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.d1(bundle);
        }
        d.b.g0.h.a.a.a();
        return aVar;
    }

    public void M2() {
        PopupWindow popupWindow = this.N0;
        if (popupWindow == null || !popupWindow.u()) {
            return;
        }
        this.N0.n();
    }

    public BDLocation N2() {
        return this.S0;
    }

    public boolean O2() {
        return this.T0;
    }

    public List<String> P2() {
        return this.U0;
    }

    public BaiduMap Q2() {
        return this.z0;
    }

    public final void R2(View view) {
        this.P0 = view;
        ImageView imageView = (ImageView) view.findViewById(R.id.location_icon_path);
        this.E0 = imageView;
        imageView.setOnClickListener(new View$OnClickListenerC1019a());
        this.K0 = (TextView) view.findViewById(R.id.location_text_position);
        this.L0 = (TextView) view.findViewById(R.id.location_text_address);
    }

    public final void S2(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.goMyPoint);
        this.Q0 = imageView;
        imageView.setOnClickListener(new e());
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    public final void T2(View view) {
        TextureMapView textureMapView = (TextureMapView) view.findViewById(R.id.bdMapView);
        this.y0 = textureMapView;
        BaiduMap map = textureMapView.getMap();
        this.z0 = map;
        map.getUiSettings().setRotateGesturesEnabled(false);
        this.y0.showZoomControls(false);
        this.z0.getUiSettings().setOverlookingGesturesEnabled(false);
        this.z0.setOnMapLoadedCallback(this);
    }

    public void U2() {
        if (this.j0 == null) {
            this.j0 = new n(l(), this.i0, 12, d.b.g0.a.w0.a.y(), new d.b.g0.a.j2.g.b());
            new d.b.g0.a.c1.a(this.j0, this).z();
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    public final void V2(LatLng latLng) {
        this.M0 = GeoCoder.newInstance();
        this.M0.setOnGetGeoCodeResultListener(new b());
        this.M0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    public final void X2() {
        TextView textView;
        TextView textView2;
        Bundle j = j();
        if (j == null || j.size() <= 0) {
            return;
        }
        this.A0 = j.getString("slaveId");
        double d2 = j.getDouble("latitude");
        double d3 = j.getDouble("longitude");
        double d4 = j.getDouble("scale");
        this.C0 = j.getString("name");
        this.D0 = j.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        V2(latLng);
        this.z0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.z0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.B0 = (Marker) this.z0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding)).title(TextUtils.isEmpty(this.C0) ? "" : this.C0).anchor(0.5f, 0.5f));
        d.b.g0.a.c0.c.g("map", "show marker");
        if (!TextUtils.isEmpty(this.C0) && (textView2 = this.K0) != null) {
            textView2.setText(this.C0);
        }
        if (!TextUtils.isEmpty(this.D0) && (textView = this.L0) != null) {
            textView.setText(this.D0);
        }
        this.U0 = j.getStringArrayList("ignoredApps");
    }

    public void Y2(boolean z) {
        this.T0 = z;
    }

    public final void Z2(float f2) {
        if (f() == null) {
            return;
        }
        Window window = f().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f2;
        window.setAttributes(attributes);
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
        U2();
        this.j0.q(d.b.g0.a.w0.a.z().a(), z1());
    }

    public final void a3() {
        FragmentActivity f2 = f();
        if (f2 == null) {
            return;
        }
        PopupWindow popupWindow = this.N0;
        if (popupWindow == null || !popupWindow.u()) {
            View inflate = View.inflate(f2, R.layout.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c());
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.openlocation_popmenu);
            this.O0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(f2);
            this.N0 = popupWindow2;
            popupWindow2.B(inflate);
            this.N0.K(-1);
            this.N0.F(-2);
            this.N0.z(new BitmapDrawable());
            this.N0.E(true);
            this.N0.I(true);
            this.N0.y(R.style.OpenLocationBottomMenuPopupStyle);
            this.N0.M(this.P0, 80, 0, 0);
            this.N0.G(new d());
            Z2(0.3f);
        }
    }

    public void b3() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W != null) {
            f.b i = W.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
            i.j(this);
            i.b();
        }
    }

    public final void c3() {
        d.b.g0.h.a.m.c cVar = new d.b.g0.h.a.m.c(d.b.g0.a.z0.f.V().getActivity(), this.z0);
        this.R0 = cVar;
        cVar.n(true);
        this.R0.k(new f());
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GeoCoder geoCoder = this.M0;
        if (geoCoder != null) {
            geoCoder.destroy();
        }
        OpenLocationBottomMenu.l();
        d.b.g0.h.a.m.c cVar = this.R0;
        if (cVar != null) {
            cVar.n(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.y0.onDestroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        d.b.g0.a.c0.c.g("map", "onMapLoaded");
        X2();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.B0 && !TextUtils.isEmpty(this.C0)) {
            LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
            linearLayout.setOrientation(1);
            TextView textView = new TextView(AppRuntime.getAppContext());
            textView.setText(this.C0);
            textView.setTextSize(18.0f);
            TextView textView2 = new TextView(AppRuntime.getAppContext());
            textView2.setText(this.D0);
            textView2.setTextSize(15.0f);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            this.z0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.g0.a.c0.c.g("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(R.layout.ai_apps_map_show_location_fragment, viewGroup, false);
        M1(inflate);
        k2(R1());
        u2(false);
        T2(inflate);
        R2(inflate);
        c3();
        S2(inflate);
        i2(AppRuntime.getAppContext().getResources().getString(R.string.aiapps_map_open_location_title));
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }

    @Override // d.b.g0.a.e0.l.c
    public void x2() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.A0);
        d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b("sharebtn", hashMap));
    }
}
