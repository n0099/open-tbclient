package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qy1;
import com.repackage.v44;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r44 extends ny1 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, s44, v44.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int d1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView F0;
    public FrameLayout G0;
    public ImageView H0;
    public FrameLayout I0;
    public FrameLayout J0;
    public View K0;
    public View L0;
    public TextView M0;
    public ImageView N0;
    public View O0;
    public GeoCoder P0;
    public BaiduMap Q0;
    public TextureMapView R0;
    public Marker S0;
    public BitmapDescriptor T0;
    public t44 U0;
    public List<t44> V0;
    public v44 W0;
    public LocationDetailAdapter X0;
    public u44 Y0;
    public boolean Z0;
    public boolean a1;
    public b b1;
    public SelectedLocationInfo c1;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ r44 b;

        public a(r44 r44Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r44Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r44Var;
            this.a = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k3(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400321, "Lcom/repackage/r44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400321, "Lcom/repackage/r44;");
                return;
            }
        }
        d1 = yc3.g(20.0f);
    }

    public r44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static r44 a3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            r44 r44Var = new r44();
            if (bundle != null) {
                r44Var.i1(bundle);
            }
            return r44Var;
        }
        return (r44) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
            super.J0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    zy2.f(uk2.U().getActivity(), R.string.obfuscated_res_0x7f0f0197).G();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    i3();
                }
            }
        }
    }

    @Override // com.repackage.ny1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, AnimationProperty.TRANSLATE_Y, 0.0f, -d1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Activity activity = this.i0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.b1 = null;
        }
    }

    public final void W2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public final void X2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.V0 = new ArrayList(11);
            this.F0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0912f1);
            this.H0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909af);
            this.G0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909b0);
            this.K0 = view2.findViewById(R.id.obfuscated_res_0x7f09048b);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f091c01);
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090984);
            this.N0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905d0);
            this.I0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091240);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091362);
            this.O0 = view2.findViewById(R.id.obfuscated_res_0x7f0912da);
            this.R0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090338);
            this.H0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.K0.setOnClickListener(this);
            this.P0 = GeoCoder.newInstance();
            this.Q0 = this.R0.getMap();
            this.P0.setOnGetGeoCodeResultListener(this);
            this.Q0.setOnMapLoadedCallback(this);
            this.Q0.setOnMapStatusChangeListener(this);
            this.F0.setLayoutManager(new LinearLayoutManager(uk2.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(uk2.U().getActivity(), this.F0, this, false);
            this.X0 = locationDetailAdapter;
            this.F0.setAdapter(locationDetailAdapter);
            this.F0.addItemDecoration(new LocationItemDecoration(uk2.U().getActivity(), true));
            u44 u44Var = new u44(this.I0, this.J0, this.G0);
            this.Y0 = u44Var;
            ((FlipperFrameLayout) this.I0).setViewFlipper(u44Var);
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.Q0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.Q0.getUiSettings().setRotateGesturesEnabled(false);
            this.R0.showZoomControls(false);
            this.R0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (Z2()) {
                return;
            }
            i3();
        }
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (uk2.U().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (arrayList.size() > 0) {
                    requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v44.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bDLocation) == null) {
            W2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    @Override // com.repackage.ny1
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            g3(true);
            W2(latLng);
            c3();
            if (z) {
                U2();
                if (this.Y0.d()) {
                    this.Y0.e(false);
                }
            }
            if (z2) {
                this.F0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // com.repackage.s44
    public void c(t44 t44Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, t44Var) == null) || t44Var == null || (poiInfo = t44Var.a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.U0 = t44Var;
        this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        c3();
        if (this.T0 == null) {
            this.T0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080198);
        }
        if (!t44Var.c) {
            this.S0 = (Marker) this.Q0.addOverlay(new MarkerOptions().position(t44Var.a.location).zIndex(88).icon(this.T0));
        }
        if (t44Var.c) {
            return;
        }
        e3(false);
    }

    public final void c3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (marker = this.S0) == null) {
            return;
        }
        marker.remove();
        this.S0 = null;
    }

    @Override // com.repackage.ny1
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (bVar = this.b1) == null) {
            return;
        }
        switch (i) {
            case 16:
                t44 t44Var = this.U0;
                if (t44Var != null) {
                    PoiInfo poiInfo = t44Var.a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.b1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
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

    public final void e3(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.H0 == null) {
            return;
        }
        this.H0.setImageResource(z ? R.drawable.obfuscated_res_0x7f08018e : R.drawable.obfuscated_res_0x7f08018d);
    }

    public void f3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.b1 = bVar;
        }
    }

    public final void g3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.V0.clear();
                this.X0.setData(this.V0);
            }
            this.O0.setVisibility(z ? 0 : 8);
        }
    }

    public void h3() {
        qy1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (V = uk2.U().V()) == null) {
            return;
        }
        qy1.b i = V.i("navigateTo");
        i.n(qy1.g, qy1.i);
        i.j(this);
        i.b();
    }

    @Override // com.repackage.ny1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            v44 v44Var = new v44(uk2.U().getActivity(), this.Q0);
            this.W0 = v44Var;
            v44Var.n(true);
            this.W0.k(this);
            g3(true);
        }
    }

    @Override // com.repackage.ny1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j3(t44 t44Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, t44Var) == null) || t44Var == null || t44Var.a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", t44Var.a.city);
        x44 b3 = x44.b3(bundle);
        b3.k1(this, 1);
        b3.h3();
    }

    public final void k3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.c1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.c1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.c1.mAddress;
                this.c1 = null;
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
            t44 t44Var = new t44(poiInfo, true, z);
            this.V0.clear();
            this.V0.add(t44Var);
            this.V0.addAll(t44.a(reverseGeoCodeResult.getPoiList()));
            this.X0.setData(this.V0);
            this.U0 = t44Var;
            if (this.V0.size() > 0) {
                g3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0909af) {
                v44 v44Var = this.W0;
                if (v44Var == null || v44Var.i() == null) {
                    return;
                }
                BDLocation i = this.W0.i();
                LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                this.Q0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                c3();
                if (this.a1) {
                    b3(latLng, true, true);
                    this.a1 = false;
                }
                e3(true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090984) {
                d3(16);
                V2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091c01) {
                j3(this.U0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09048b) {
                d3(17);
                V2();
            }
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.F0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            W2(this.Q0.getMapStatus().target);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, mapStatus) == null) && this.Z0) {
            b3(mapStatus.target, true, true);
            e3(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, mapStatus, i) == null) {
            boolean z = false;
            boolean z2 = i == 1;
            this.Z0 = z2;
            this.a1 = (z2 || this.a1) ? true : true;
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.R0.onPause();
            v44 v44Var = this.W0;
            if (v44Var != null) {
                v44Var.n(false);
            }
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.R0.onResume();
            v44 v44Var = this.W0;
            if (v44Var != null) {
                v44Var.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, intent) == null) {
            super.r0(i, i2, intent);
            if (intent == null || i != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d = selectedLocationInfo.mLatitude;
            double d2 = selectedLocationInfo.mLongitude;
            if (Double.isNaN(d) || Double.isNaN(d2)) {
                return;
            }
            this.c1 = selectedLocationInfo;
            LatLng latLng = new LatLng(d, d2);
            this.Q0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.a1 = true;
            b3(latLng, false, true);
            e3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            n34.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0082, viewGroup, false);
            X2(inflate);
            Y2();
            if (S1()) {
                inflate = V1(inflate);
                v1(-1);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.z0();
            if (Build.VERSION.SDK_INT > 19) {
                this.R0.onDestroy();
            }
            this.P0.destroy();
        }
    }
}
