package d.a.l0.j.m;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.j.g;
import d.a.l0.j.h;
import d.a.l0.j.r.c;
import d.a.l0.k.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.h0.g.d implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public Marker A0;
    public String B0;
    public String C0;
    public ImageView D0;
    public TextView E0;
    public TextView K0;
    public GeoCoder L0;
    public PopupWindow M0;
    public OpenLocationBottomMenu N0;
    public View O0;
    public ImageView P0;
    public d.a.l0.j.r.c Q0;
    public BDLocation R0;
    public boolean S0;
    public ArrayList<String> T0;
    public TextureMapView x0;
    public BaiduMap y0;
    public String z0 = "";

    /* renamed from: d.a.l0.j.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1068a implements View.OnClickListener {
        public View$OnClickListenerC1068a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g3();
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
                a.this.E0.setText(g.unknown_location_info);
                return;
            }
            if (a.this.K0 != null && TextUtils.isEmpty(a.this.C0)) {
                String address = reverseGeoCodeResult.getAddress();
                a aVar = a.this;
                if (address == null) {
                    address = aVar.z().getString(g.unknown_location_info);
                }
                aVar.C0 = address;
                a.this.K0.setText(a.this.C0);
            }
            if (a.this.E0 != null && TextUtils.isEmpty(a.this.B0)) {
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                a aVar2 = a.this;
                if (sematicDescription == null) {
                    sematicDescription = aVar2.z().getString(g.unknown_location_info);
                }
                aVar2.B0 = sematicDescription;
                a.this.E0.setText(a.this.B0);
            }
            d.a.l0.a.e0.d.g("map", "mAddress +" + a.this.C0 + " mName" + a.this.B0);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.S2();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PopupWindow.b {
        public d() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            a.this.f3(1.0f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Q0 == null || a.this.Q0.i() == null) {
                return;
            }
            BDLocation i2 = a.this.Q0.i();
            a.this.y0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i2.getLatitude(), i2.getLongitude())));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.b {
        public f() {
        }

        @Override // d.a.l0.j.r.c.b
        public void a(BDLocation bDLocation) {
            a.this.R0 = bDLocation;
        }
    }

    static {
        boolean z = k.f43199a;
    }

    public static a c3(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.j1(bundle);
        }
        d.a.l0.j.a.a();
        return aVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.l0.a.e0.d.g("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(d.a.l0.j.f.ai_apps_map_show_location_fragment, viewGroup, false);
        Q1(inflate);
        p2(V1());
        z2(false);
        Z2(inflate);
        X2(inflate);
        i3();
        Y2(inflate);
        n2(AppRuntime.getAppContext().getResources().getString(g.aiapps_map_open_location_title));
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    @Override // d.a.l0.a.h0.g.d
    public void C2() {
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.z0);
        d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("sharebtn", hashMap));
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        return false;
    }

    public void S2() {
        PopupWindow popupWindow = this.M0;
        if (popupWindow == null || !popupWindow.x()) {
            return;
        }
        this.M0.r();
    }

    public BDLocation T2() {
        return this.R0;
    }

    public boolean U2() {
        return this.S0;
    }

    public List<String> V2() {
        return this.T0;
    }

    public BaiduMap W2() {
        return this.y0;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    public final void X2(View view) {
        this.O0 = view;
        ImageView imageView = (ImageView) view.findViewById(d.a.l0.j.e.location_icon_path);
        this.D0 = imageView;
        imageView.setOnClickListener(new View$OnClickListenerC1068a());
        this.E0 = (TextView) view.findViewById(d.a.l0.j.e.location_text_position);
        this.K0 = (TextView) view.findViewById(d.a.l0.j.e.location_text_address);
    }

    public final void Y2(View view) {
        ImageView imageView = (ImageView) view.findViewById(d.a.l0.j.e.goMyPoint);
        this.P0 = imageView;
        imageView.setOnClickListener(new e());
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    public final void Z2(View view) {
        TextureMapView textureMapView = (TextureMapView) view.findViewById(d.a.l0.j.e.bdMapView);
        this.x0 = textureMapView;
        BaiduMap map = textureMapView.getMap();
        this.y0 = map;
        map.getUiSettings().setRotateGesturesEnabled(false);
        this.x0.showZoomControls(false);
        this.y0.getUiSettings().setOverlookingGesturesEnabled(false);
        this.y0.setOnMapLoadedCallback(this);
    }

    public void a3() {
        if (this.j0 == null) {
            this.j0 = new n(q(), this.i0, 12, d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
            new d.a.l0.a.j1.a(this.j0, this).z();
        }
    }

    public final void b3(LatLng latLng) {
        this.L0 = GeoCoder.newInstance();
        this.L0.setOnGetGeoCodeResultListener(new b());
        this.L0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    public final void d3() {
        TextView textView;
        TextView textView2;
        Bundle n = n();
        if (n == null || n.size() <= 0) {
            return;
        }
        this.z0 = n.getString("slaveId");
        double d2 = n.getDouble("latitude");
        double d3 = n.getDouble("longitude");
        double d4 = n.getDouble("scale");
        this.B0 = n.getString("name");
        this.C0 = n.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        b3(latLng);
        this.y0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.y0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.A0 = (Marker) this.y0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(d.a.l0.j.d.aiapps_location_ding)).title(TextUtils.isEmpty(this.B0) ? "" : this.B0).anchor(0.5f, 0.5f));
        d.a.l0.a.e0.d.g("map", "show marker");
        if (!TextUtils.isEmpty(this.B0) && (textView2 = this.E0) != null) {
            textView2.setText(this.B0);
        }
        if (!TextUtils.isEmpty(this.C0) && (textView = this.K0) != null) {
            textView.setText(this.C0);
        }
        this.T0 = n.getStringArrayList("ignoredApps");
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
        a3();
        this.j0.q(d.a.l0.a.c1.a.H().a(), E1());
    }

    public void e3(boolean z) {
        this.S0 = z;
    }

    public final void f3(float f2) {
        if (h() == null) {
            return;
        }
        Window window = h().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f2;
        window.setAttributes(attributes);
    }

    public final void g3() {
        FragmentActivity h2 = h();
        if (h2 == null) {
            return;
        }
        PopupWindow popupWindow = this.M0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(h2, d.a.l0.j.f.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c());
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(d.a.l0.j.e.openlocation_popmenu);
            this.N0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(h2);
            this.M0 = popupWindow2;
            popupWindow2.H(inflate);
            this.M0.O(-1);
            this.M0.J(-2);
            this.M0.F(new BitmapDrawable());
            this.M0.I(true);
            this.M0.M(true);
            this.M0.B(h.OpenLocationBottomMenuPopupStyle);
            this.M0.Q(this.O0, 80, 0, 0);
            this.M0.L(new d());
            f3(0.3f);
        }
    }

    public void h3() {
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W != null) {
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.l0.a.h0.g.g.f42076g, d.a.l0.a.h0.g.g.f42078i);
            i2.j(this);
            i2.b();
        }
    }

    public final void i3() {
        d.a.l0.j.r.c cVar = new d.a.l0.j.r.c(d.a.l0.a.g1.f.V().getActivity(), this.y0);
        this.Q0 = cVar;
        cVar.n(true);
        this.Q0.k(new f());
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GeoCoder geoCoder = this.L0;
        if (geoCoder != null) {
            geoCoder.destroy();
        }
        OpenLocationBottomMenu.l();
        d.a.l0.j.r.c cVar = this.Q0;
        if (cVar != null) {
            cVar.n(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.x0.onDestroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        d.a.l0.a.e0.d.g("map", "onMapLoaded");
        d3();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.A0 && !TextUtils.isEmpty(this.B0)) {
            LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
            linearLayout.setOrientation(1);
            TextView textView = new TextView(AppRuntime.getAppContext());
            textView.setText(this.B0);
            textView.setTextSize(18.0f);
            TextView textView2 = new TextView(AppRuntime.getAppContext());
            textView2.setText(this.C0);
            textView2.setTextSize(15.0f);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            this.y0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }
}
