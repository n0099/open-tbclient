package d.a.n0.j.r;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.j.d;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f50557a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f50558b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f50559c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f50560d;

    /* renamed from: e  reason: collision with root package name */
    public b f50561e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f50562f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f50563g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50564h;

    /* loaded from: classes7.dex */
    public class a extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50565a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50565a = cVar;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null) {
                    this.f50565a.m();
                    return;
                }
                this.f50565a.f50558b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
                if (this.f50565a.f50559c != null) {
                    this.f50565a.f50559c.remove();
                    this.f50565a.f50559c = null;
                }
                MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(this.f50565a.f50560d).anchor(0.5f, 0.5f);
                c cVar = this.f50565a;
                cVar.f50559c = (Marker) cVar.f50558b.addOverlay(anchor);
                if (this.f50565a.f50563g == null) {
                    MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                    if (this.f50565a.f50561e != null) {
                        this.f50565a.f50561e.a(bDLocation);
                    }
                }
                this.f50565a.f50563g = bDLocation;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50564h = false;
        this.f50557a = context;
        this.f50558b = baiduMap;
    }

    public BDLocation i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50563g : (BDLocation) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f50562f == null) {
            LocationClient locationClient = new LocationClient(this.f50557a.getApplicationContext());
            this.f50562f = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f50562f.setLocOption(locationClientOption);
            this.f50560d = BitmapDescriptorFactory.fromResource(d.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f50561e = bVar;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f50564h) {
            return;
        }
        j();
        LocationClient locationClient = this.f50562f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f50562f.start();
        this.f50564h = true;
    }

    public final void m() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f50564h && (locationClient = this.f50562f) != null && locationClient.isStarted()) {
            this.f50562f.stop();
            this.f50564h = false;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                l();
            } else {
                m();
            }
        }
    }
}
