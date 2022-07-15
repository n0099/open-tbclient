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
import com.repackage.g64;
import com.repackage.qz1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class n54 extends nz1 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
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
    public g64 T0;
    public BDLocation U0;
    public boolean V0;
    public ArrayList<String> W0;
    public float X0;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public a(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public b(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
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
                    this.a.M0.setText(R.string.obfuscated_res_0x7f0f14cb);
                    return;
                }
                if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    n54 n54Var = this.a;
                    if (address == null) {
                        address = n54Var.getResources().getString(R.string.obfuscated_res_0x7f0f14cb);
                    }
                    n54Var.K0 = address;
                    this.a.N0.setText(this.a.K0);
                }
                if (this.a.M0 != null && TextUtils.isEmpty(this.a.J0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    n54 n54Var2 = this.a;
                    if (sematicDescription == null) {
                        sematicDescription = n54Var2.getResources().getString(R.string.obfuscated_res_0x7f0f14cb);
                    }
                    n54Var2.J0 = sematicDescription;
                    this.a.M0.setText(this.a.J0);
                }
                hx1.i("map", "mAddress +" + this.a.K0 + " mName" + this.a.J0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public c(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public d(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n54 n54Var = this.a;
                n54Var.g3(n54Var.R0, 1.0f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public e(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
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
    public class f implements g64.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;

        public f(n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n54Var;
        }

        @Override // com.repackage.g64.b
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755518524, "Lcom/repackage/n54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755518524, "Lcom/repackage/n54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public n54() {
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

    public static n54 r3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            n54 n54Var = new n54();
            if (bundle != null) {
                n54Var.j1(bundle);
            }
            n44.a();
            return n54Var;
        }
        return (n54) invokeL.objValue;
    }

    @Override // com.repackage.nz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0);
            ul2.U().u(new ia2("sharebtn", hashMap));
        }
    }

    @Override // com.repackage.nz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g3(View view2, float f2) {
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

    public void h3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.P0) != null && popupWindow.x()) {
            this.P0.r();
        }
    }

    public BDLocation i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.U0 : (BDLocation) invokeV.objValue;
    }

    @Override // com.repackage.nz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.nz1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p3();
            this.m0.t(oj2.M().a(), H1());
        }
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public List<String> k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.W0 : (List) invokeV.objValue;
    }

    public BaiduMap l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.G0 : (BaiduMap) invokeV.objValue;
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.R0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09138c);
            this.L0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091392);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091391);
        }
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c75);
            this.S0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09033d);
            this.F0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.G0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.F0.showZoomControls(false);
            this.G0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.G0.setOnMapLoadedCallback(this);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hx1.i("map", "onMapLoaded");
            s3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, marker)) == null) {
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

    public void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.m0 == null) {
            this.m0 = new m64(getContext(), this.l0, 12, oj2.K(), new qf3());
            new xp2(this.m0, this).z();
        }
    }

    public final void q3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, latLng) == null) {
            this.O0 = GeoCoder.newInstance();
            this.O0.setOnGetGeoCodeResultListener(new b(this));
            this.O0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public final void s3() {
        Bundle p;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (p = p()) == null || p.size() <= 0) {
            return;
        }
        this.H0 = p.getString("slaveId");
        double d2 = p.getDouble("latitude");
        double d3 = p.getDouble("longitude");
        double d4 = p.getDouble("scale");
        this.J0 = p.getString("name");
        this.K0 = p.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        if (TextUtils.isEmpty(this.J0)) {
            if (TextUtils.isEmpty(this.K0)) {
                q3(latLng);
            } else {
                this.J0 = getResources().getString(R.string.obfuscated_res_0x7f0f14ca);
            }
        }
        this.G0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.G0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.I0 = (Marker) this.G0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018b)).title(TextUtils.isEmpty(this.J0) ? "" : this.J0).anchor(0.5f, 0.5f));
        hx1.i("map", "show marker");
        if (!TextUtils.isEmpty(this.J0) && (textView2 = this.M0) != null) {
            textView2.setText(this.J0);
        }
        if (!TextUtils.isEmpty(this.K0) && (textView = this.N0) != null) {
            textView.setText(this.K0);
        }
        this.W0 = p.getStringArrayList("ignoredApps");
    }

    public void t3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void u3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.P0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00bd, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f09166d);
            this.Q0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.P0 = popupWindow2;
            popupWindow2.E(inflate);
            this.P0.M(-1);
            this.P0.G(-2);
            this.P0.F(true);
            this.P0.J(true);
            this.P0.B(R.style.obfuscated_res_0x7f10013c);
            this.P0.O(this.R0, 80, 0, 0);
            this.P0.I(new d(this));
            g3(this.R0, this.X0);
        }
    }

    public void v3() {
        qz1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (V = ul2.U().V()) == null) {
            return;
        }
        qz1.b i = V.i("navigateTo");
        i.n(qz1.g, qz1.i);
        i.j(this);
        i.b();
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            g64 g64Var = new g64(ul2.U().getActivity(), this.G0);
            this.T0 = g64Var;
            g64Var.n(true);
            this.T0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            hx1.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0085, viewGroup, false);
            U1(inflate);
            x2(Z1());
            J2(false);
            o3(inflate);
            m3(inflate);
            w3();
            n3(inflate);
            v2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f019a));
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.y0();
            GeoCoder geoCoder = this.O0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            g64 g64Var = this.T0;
            if (g64Var != null) {
                g64Var.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.F0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }
}
