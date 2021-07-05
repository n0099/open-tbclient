package d.a.q0.j.o;

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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.v2.n0;
import d.a.q0.j.f;
import d.a.q0.j.g;
import d.a.q0.j.o.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.h0.g.d implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, d.a.q0.j.o.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView C0;
    public FrameLayout D0;
    public ImageView E0;
    public FrameLayout F0;
    public FrameLayout G0;
    public View H0;
    public View I0;
    public TextView J0;
    public ImageView K0;
    public View L0;
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

    /* renamed from: d.a.q0.j.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1189a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f53819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53820f;

        public RunnableC1189a(a aVar, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53820f = aVar;
            this.f53819e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53820f.Y2(this.f53819e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1092927530, "Ld/a/q0/j/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1092927530, "Ld/a/q0/j/o/a;");
                return;
            }
        }
        a1 = n0.g(20.0f);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a O2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
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
            View inflate = layoutInflater.inflate(f.ai_apps_location_choose, viewGroup, false);
            L2(inflate);
            M2();
            if (P1()) {
                inflate = S1(inflate);
                u1(-1);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.K0, "translationY", 0.0f, -a1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Activity activity = this.k0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.Y0 = null;
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            R2(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, latLng) == null) {
            this.M0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, strArr, iArr) == null) {
            super.L0(i2, strArr, iArr);
            if (i2 == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    d.a.q0.a.z1.b.f.e.f(d.a.q0.a.g1.f.V().getActivity(), g.aiapps_location_permission_fail).F();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    W2();
                }
            }
        }
    }

    public final void L2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.S0 = new ArrayList(11);
            this.C0 = (RecyclerView) view.findViewById(d.a.q0.j.e.location_list);
            this.E0 = (ImageView) view.findViewById(d.a.q0.j.e.float_btn);
            this.D0 = (FrameLayout) view.findViewById(d.a.q0.j.e.float_container);
            this.H0 = view.findViewById(d.a.q0.j.e.cancel);
            this.I0 = view.findViewById(d.a.q0.j.e.search);
            this.J0 = (TextView) view.findViewById(d.a.q0.j.e.finish);
            this.K0 = (ImageView) view.findViewById(d.a.q0.j.e.center_ding);
            this.F0 = (FrameLayout) view.findViewById(d.a.q0.j.e.list_container);
            this.G0 = (FrameLayout) view.findViewById(d.a.q0.j.e.map_container);
            this.L0 = view.findViewById(d.a.q0.j.e.loading_progress);
            this.O0 = (TextureMapView) view.findViewById(d.a.q0.j.e.bdMapView);
            this.E0.setOnClickListener(this);
            this.J0.setOnClickListener(this);
            this.I0.setOnClickListener(this);
            this.H0.setOnClickListener(this);
            this.M0 = GeoCoder.newInstance();
            this.N0 = this.O0.getMap();
            this.M0.setOnGetGeoCodeResultListener(this);
            this.N0.setOnMapLoadedCallback(this);
            this.N0.setOnMapStatusChangeListener(this);
            this.C0.setLayoutManager(new LinearLayoutManager(d.a.q0.a.g1.f.V().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(d.a.q0.a.g1.f.V().getActivity(), this.C0, this, false);
            this.U0 = locationDetailAdapter;
            this.C0.setAdapter(locationDetailAdapter);
            this.C0.addItemDecoration(new LocationItemDecoration(d.a.q0.a.g1.f.V().getActivity(), true));
            d dVar = new d(this.F0, this.G0, this.D0);
            this.V0 = dVar;
            ((FlipperFrameLayout) this.F0).setViewFlipper(dVar);
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.N0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.N0.getUiSettings().setRotateGesturesEnabled(false);
            this.O0.showZoomControls(false);
            this.O0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (N2()) {
                return;
            }
            W2();
        }
    }

    public final boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (d.a.q0.a.g1.f.V().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (arrayList.size() > 0) {
                    h1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P2(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
                this.C0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
        }
    }

    public final void Q2() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (marker = this.P0) == null) {
            return;
        }
        marker.remove();
        this.P0 = null;
    }

    public final void R2(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (bVar = this.Y0) == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.R0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f53821a;
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.E0 == null) {
            return;
        }
        this.E0.setImageResource(z ? d.a.q0.j.d.aiapps_location_go_my_point_selected : d.a.q0.j.d.aiapps_location_go_my_point);
    }

    public void T2(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.Y0 = bVar;
        }
    }

    public final void U2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.S0.clear();
                this.U0.setData(this.S0);
            }
            this.L0.setVisibility(z ? 0 : 8);
        }
    }

    public void V2() {
        d.a.q0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (W = d.a.q0.a.g1.f.V().W()) == null) {
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(d.a.q0.a.h0.g.g.f48010g, d.a.q0.a.h0.g.g.f48012i);
        i2.j(this);
        i2.b();
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            e eVar = new e(d.a.q0.a.g1.f.V().getActivity(), this.N0);
            this.T0 = eVar;
            eVar.n(true);
            this.T0.k(this);
            U2(true);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X2(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) || cVar == null || cVar.f53821a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f53821a.city);
        d.a.q0.j.o.g.a P2 = d.a.q0.j.o.g.a.P2(bundle);
        P2.l1(this, 1);
        P2.V2();
    }

    public final void Y2(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, reverseGeoCodeResult) == null) {
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
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.j.o.e.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bDLocation) == null) {
            K2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    @Override // d.a.q0.j.o.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) || cVar == null || (poiInfo = cVar.f53821a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.R0 = cVar;
        this.N0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        Q2();
        if (this.Q0 == null) {
            this.Q0 = BitmapDescriptorFactory.fromResource(d.a.q0.j.d.aiapps_location_selected);
        }
        if (!cVar.f53823c) {
            this.P0 = (Marker) this.N0.addOverlay(new MarkerOptions().position(cVar.f53821a.location).zIndex(88).icon(this.Q0));
        }
        if (cVar.f53823c) {
            return;
        }
        S2(false);
    }

    @Override // d.a.q0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            if (view.getId() == d.a.q0.j.e.float_btn) {
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
            } else if (view.getId() == d.a.q0.j.e.finish) {
                R2(16);
                J2();
            } else if (view.getId() == d.a.q0.j.e.search) {
                X2(this.R0);
            } else if (view.getId() == d.a.q0.j.e.cancel) {
                R2(17);
                J2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            if (Build.VERSION.SDK_INT > 19) {
                this.O0.onDestroy();
            }
            this.M0.destroy();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.C0.postDelayed(new RunnableC1189a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            K2(this.N0.getMapStatus().target);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, mapStatus) == null) && this.W0) {
            P2(mapStatus.target, true, true);
            S2(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, mapStatus, i2) == null) {
            boolean z = false;
            boolean z2 = i2 == 1;
            this.W0 = z2;
            this.X0 = (z2 || this.X0) ? true : true;
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            this.O0.onPause();
            e eVar = this.T0;
            if (eVar != null) {
                eVar.n(false);
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onResume();
            this.O0.onResume();
            e eVar = this.T0;
            if (eVar != null) {
                eVar.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(int i2, int i3, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, intent) == null) {
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
}
