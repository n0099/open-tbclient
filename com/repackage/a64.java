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
import com.repackage.d02;
import com.repackage.t64;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class a64 extends a02 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
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
    public t64 T0;
    public BDLocation U0;
    public boolean V0;
    public ArrayList<String> W0;
    public float X0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public a(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public b(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
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
                    this.a.M0.setText(R.string.obfuscated_res_0x7f0f14b0);
                    return;
                }
                if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a64 a64Var = this.a;
                    if (address == null) {
                        address = a64Var.getResources().getString(R.string.obfuscated_res_0x7f0f14b0);
                    }
                    a64Var.K0 = address;
                    this.a.N0.setText(this.a.K0);
                }
                if (this.a.M0 != null && TextUtils.isEmpty(this.a.J0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a64 a64Var2 = this.a;
                    if (sematicDescription == null) {
                        sematicDescription = a64Var2.getResources().getString(R.string.obfuscated_res_0x7f0f14b0);
                    }
                    a64Var2.J0 = sematicDescription;
                    this.a.M0.setText(this.a.J0);
                }
                ux1.i("map", "mAddress +" + this.a.K0 + " mName" + this.a.J0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public c(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public d(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a64 a64Var = this.a;
                a64Var.f3(a64Var.R0, 1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public e(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
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

    /* loaded from: classes5.dex */
    public class f implements t64.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public f(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        @Override // com.repackage.t64.b
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755904846, "Lcom/repackage/a64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755904846, "Lcom/repackage/a64;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public a64() {
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

    public static a64 q3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            a64 a64Var = new a64();
            if (bundle != null) {
                a64Var.i1(bundle);
            }
            a54.a();
            return a64Var;
        }
        return (a64) invokeL.objValue;
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0);
            hm2.U().u(new va2("sharebtn", hashMap));
        }
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
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

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o3();
            this.m0.t(bk2.M().a(), G1());
        }
    }

    public boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    @Override // com.repackage.a02, com.baidu.searchbox.widget.SlideInterceptor
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
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09132d);
            this.L0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091333);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091332);
        }
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cb8);
            this.S0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f09033c);
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
            this.m0 = new z64(getContext(), this.l0, 12, bk2.K(), new dg3());
            new kq2(this.m0, this).z();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ux1.i("map", "onMapLoaded");
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
                this.J0 = getResources().getString(R.string.obfuscated_res_0x7f0f14af);
            }
        }
        this.G0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.G0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.I0 = (Marker) this.G0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018c)).title(TextUtils.isEmpty(this.J0) ? "" : this.J0).anchor(0.5f, 0.5f));
        ux1.i("map", "show marker");
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
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00c2, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f09161d);
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
        d02 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (V = hm2.U().V()) == null) {
            return;
        }
        d02.b i = V.i("navigateTo");
        i.n(d02.g, d02.i);
        i.j(this);
        i.b();
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            t64 t64Var = new t64(hm2.U().getActivity(), this.G0);
            this.T0 = t64Var;
            t64Var.n(true);
            this.T0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            ux1.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008a, viewGroup, false);
            T1(inflate);
            w2(Y1());
            I2(false);
            n3(inflate);
            l3(inflate);
            v3();
            m3(inflate);
            u2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f0197));
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
            t64 t64Var = this.T0;
            if (t64Var != null) {
                t64Var.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.F0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }
}
