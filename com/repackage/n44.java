package com.repackage;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g54;
import com.repackage.qy1;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class n44 extends ny1 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView F0;
    public BaiduMap G0;
    public String H0;
    public Marker I0;
    public String J0;
    public String K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public GeoCoder O0;
    public PopupWindow P0;
    public OpenLocationBottomMenu Q0;
    public View R0;
    public ImageView S0;
    public g54 T0;
    public BDLocation U0;
    public boolean V0;
    public ArrayList<String> W0;
    public float X0;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public a(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public b(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    this.a.M0.setText(R.string.obfuscated_res_0x7f0f14c4);
                    return;
                }
                if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    n44 n44Var = this.a;
                    if (address == null) {
                        address = n44Var.getResources().getString(R.string.obfuscated_res_0x7f0f14c4);
                    }
                    n44Var.K0 = address;
                    this.a.N0.setText(this.a.K0);
                }
                if (this.a.M0 != null && TextUtils.isEmpty(this.a.J0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    n44 n44Var2 = this.a;
                    if (sematicDescription == null) {
                        sematicDescription = n44Var2.getResources().getString(R.string.obfuscated_res_0x7f0f14c4);
                    }
                    n44Var2.J0 = sematicDescription;
                    this.a.M0.setText(this.a.J0);
                }
                hw1.i("map", "mAddress +" + this.a.K0 + " mName" + this.a.J0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public c(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public d(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n44 n44Var = this.a;
                n44Var.f3(n44Var.R0, 1.0f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public e(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.T0 == null || this.a.T0.i() == null) {
                return;
            }
            BDLocation i = this.a.T0.i();
            this.a.G0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements g54.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public f(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // com.repackage.g54.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.a.U0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755519485, "Lcom/repackage/n44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755519485, "Lcom/repackage/n44;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public n44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = "";
        this.X0 = 0.5f;
    }

    public static n44 q3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            n44 n44Var = new n44();
            if (bundle != null) {
                n44Var.i1(bundle);
            }
            n34.a();
            return n44Var;
        }
        return (n44) invokeL.objValue;
    }

    @Override // com.repackage.ny1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0);
            uk2.U().u(new i92("sharebtn", hashMap));
        }
    }

    @Override // com.repackage.ny1
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f3(View view2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048580, this, view2, f2) == null) || view2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getRootView();
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (Float.valueOf(f2).equals(Float.valueOf(1.0f))) {
            overlay.clear();
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        overlay.add(colorDrawable);
    }

    public void g3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.P0) != null && popupWindow.y()) {
            this.P0.s();
        }
    }

    public BDLocation h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.U0 : (BDLocation) invokeV.objValue;
    }

    @Override // com.repackage.ny1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o3();
            this.m0.t(oi2.M().a(), G1());
        }
    }

    public boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    @Override // com.repackage.ny1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<String> j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.W0 : (List) invokeV.objValue;
    }

    public BaiduMap k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.G0 : (BaiduMap) invokeV.objValue;
    }

    public final void l3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.R0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912ef);
            this.L0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f5);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f4);
        }
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c7c);
            this.S0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090338);
            this.F0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.G0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.F0.showZoomControls(false);
            this.G0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.G0.setOnMapLoadedCallback(this);
        }
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.m0 == null) {
            this.m0 = new m54(getContext(), this.l0, 12, oi2.K(), new qe3());
            new xo2(this.m0, this).z();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hw1.i("map", "onMapLoaded");
            r3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, marker)) == null) {
            if (marker == this.I0 && !TextUtils.isEmpty(this.J0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.J0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.K0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.G0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, latLng) == null) {
            this.O0 = GeoCoder.newInstance();
            this.O0.setOnGetGeoCodeResultListener(new b(this));
            this.O0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public final void r3() {
        Bundle q;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (q = q()) == null || q.size() <= 0) {
            return;
        }
        this.H0 = q.getString("slaveId");
        double d2 = q.getDouble("latitude");
        double d3 = q.getDouble("longitude");
        double d4 = q.getDouble(AnimationProperty.SCALE);
        this.J0 = q.getString("name");
        this.K0 = q.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        if (TextUtils.isEmpty(this.J0)) {
            if (TextUtils.isEmpty(this.K0)) {
                p3(latLng);
            } else {
                this.J0 = getResources().getString(R.string.obfuscated_res_0x7f0f14c3);
            }
        }
        this.G0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.G0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.I0 = (Marker) this.G0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018c)).title(TextUtils.isEmpty(this.J0) ? "" : this.J0).anchor(0.5f, 0.5f));
        hw1.i("map", "show marker");
        if (!TextUtils.isEmpty(this.J0) && (textView2 = this.M0) != null) {
            textView2.setText(this.J0);
        }
        if (!TextUtils.isEmpty(this.K0) && (textView = this.N0) != null) {
            textView.setText(this.K0);
        }
        this.W0 = q.getStringArrayList("ignoredApps");
    }

    public void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void t3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.P0;
        if (popupWindow == null || !popupWindow.y()) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00be, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f0915d2);
            this.Q0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.P0 = popupWindow2;
            popupWindow2.F(inflate);
            this.P0.M(-1);
            this.P0.H(-2);
            this.P0.G(true);
            this.P0.K(true);
            this.P0.C(R.style.obfuscated_res_0x7f10013b);
            this.P0.O(this.R0, 80, 0, 0);
            this.P0.J(new d(this));
            f3(this.R0, this.X0);
        }
    }

    public void u3() {
        qy1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (V = uk2.U().V()) == null) {
            return;
        }
        qy1.b i = V.i("navigateTo");
        i.n(qy1.g, qy1.i);
        i.j(this);
        i.b();
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            g54 g54Var = new g54(uk2.U().getActivity(), this.G0);
            this.T0 = g54Var;
            g54Var.n(true);
            this.T0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            hw1.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0086, viewGroup, false);
            T1(inflate);
            w2(Y1());
            I2(false);
            n3(inflate);
            l3(inflate);
            v3();
            m3(inflate);
            u2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f0198));
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.z0();
            GeoCoder geoCoder = this.O0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            g54 g54Var = this.T0;
            if (g54Var != null) {
                g54Var.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.F0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }
}
