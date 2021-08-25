package com.qq.e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.f;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class DeviceStatus {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f75193a;

    /* renamed from: b  reason: collision with root package name */
    public String f75194b;

    /* renamed from: c  reason: collision with root package name */
    public int f75195c;

    /* renamed from: d  reason: collision with root package name */
    public int f75196d;

    /* renamed from: e  reason: collision with root package name */
    public int f75197e;

    /* renamed from: f  reason: collision with root package name */
    public String f75198f;

    /* renamed from: g  reason: collision with root package name */
    public String f75199g;

    /* renamed from: h  reason: collision with root package name */
    public String f75200h;

    /* renamed from: i  reason: collision with root package name */
    public String f75201i;

    /* renamed from: j  reason: collision with root package name */
    public String f75202j;
    public volatile String k;
    public volatile String l;
    public volatile float m;
    public final String model;
    public Context n;

    public DeviceStatus(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.model = Build.MODEL;
        this.n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f75197e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f75195c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f75196d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        a();
    }

    private int a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (i2 / f2) : i2 : invokeCommon.intValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x003f: INVOKE  (r2v4 double A[REMOVE]) = (r0v5 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0051: INVOKE  (r2v5 double A[REMOVE]) = (r0v5 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    private void a() {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                if (GlobalSetting.isLocationAllowed() && (locationManager = (LocationManager) this.n.getSystemService("location")) != null) {
                    Criteria criteria = new Criteria();
                    criteria.setAccuracy(2);
                    criteria.setAltitudeRequired(false);
                    criteria.setBearingRequired(false);
                    criteria.setCostAllowed(true);
                    criteria.setPowerRequirement(1);
                    String bestProvider = locationManager.getBestProvider(criteria, true);
                    Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    if (lastKnownLocation == null) {
                        locationManager.requestLocationUpdates(bestProvider, 2000L, 7000.0f, new LocationListener(this, locationManager) { // from class: com.qq.e.comm.managers.status.DeviceStatus.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ LocationManager f75203a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ DeviceStatus f75204b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, locationManager};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f75204b = this;
                                this.f75203a = locationManager;
                            }

                            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x000b: INVOKE  (r2v0 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
                            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0020: INVOKE  (r2v1 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
                            @Override // android.location.LocationListener
                            public void onLocationChanged(Location location) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, location) == null) {
                                    try {
                                        DeviceStatus deviceStatus = this.f75204b;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(location.getLatitude());
                                        deviceStatus.k = sb.toString();
                                        DeviceStatus deviceStatus2 = this.f75204b;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(location.getLongitude());
                                        deviceStatus2.l = sb2.toString();
                                        this.f75203a.removeUpdates(this);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }

                            @Override // android.location.LocationListener
                            public void onProviderDisabled(String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                }
                            }

                            @Override // android.location.LocationListener
                            public void onProviderEnabled(String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                                }
                            }

                            @Override // android.location.LocationListener
                            public void onStatusChanged(String str, int i2, Bundle bundle) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, str, i2, bundle) == null) {
                                }
                            }
                        });
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(lastKnownLocation.getLatitude());
                    this.k = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(lastKnownLocation.getLongitude());
                    this.l = sb2.toString();
                    this.m = lastKnownLocation.getAccuracy();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Carrier getCarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String operator = getOperator();
            if (operator != null) {
                if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                    return Carrier.CMCC;
                }
                if (operator.equals("46001") || operator.equals("46006")) {
                    return Carrier.UNICOM;
                }
                if (operator.equals("46003") || operator.equals("46005")) {
                    return Carrier.TELECOM;
                }
            }
            return Carrier.UNKNOWN;
        }
        return (Carrier) invokeV.objValue;
    }

    public String getDataNet() {
        InterceptResult invokeV;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                networkInfo = ((ConnectivityManager) this.n.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (networkInfo == null) {
                return null;
            }
            int type = networkInfo.getType();
            String str = type != 0 ? type != 1 ? "unknow" : IAdRequestParam.WIFI : "ed";
            this.f75201i = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int getDeviceDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75197e : invokeV.intValue;
    }

    public int getDeviceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75196d : invokeV.intValue;
    }

    public int getDeviceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75195c : invokeV.intValue;
    }

    public String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String plainDid = getPlainDid();
            return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v4 int)] */
    public Map<String, String> getLacAndCeilId() {
        InterceptResult invokeV;
        int i2;
        GsmCellLocation gsmCellLocation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String operator = getOperator();
            HashMap hashMap = new HashMap();
            if (this.n.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !com.baidu.android.common.others.lang.StringUtil.NULL_STRING.equalsIgnoreCase(operator)) {
                int i3 = 0;
                try {
                    if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                        TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService("phone");
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof CdmaCellLocation) {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            i3 = cdmaCellLocation.getNetworkId();
                            i2 = cdmaCellLocation.getBaseStationId();
                        } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                            i2 = 0;
                        } else {
                            i3 = gsmCellLocation.getLac();
                            i2 = gsmCellLocation.getCid();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(i3);
                        hashMap.put("lac", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i2);
                        hashMap.put("cellid", sb2.toString());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f75194b == null) {
                String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
                this.f75194b = lowerCase;
                if (lowerCase.length() == 0) {
                    this.f75194b = f.f39388a;
                }
            }
            return this.f75194b;
        }
        return (String) invokeV.objValue;
    }

    public String getLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String getLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public float getLocationAccuracy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.floatValue;
    }

    public NetworkType getNetworkType() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String dataNet = getDataNet();
            if (dataNet == null || !dataNet.equals(IAdRequestParam.WIFI)) {
                try {
                    i2 = Integer.parseInt(getPhoneNet());
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                switch (i2) {
                    case 1:
                    case 2:
                    case 16:
                        return NetworkType.NET_2G;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 14:
                    case 17:
                        return NetworkType.NET_3G;
                    case 13:
                    case 15:
                    case 18:
                    case 19:
                    case 20:
                        return NetworkType.NET_4G;
                    default:
                        return NetworkType.UNKNOWN;
                }
            }
            return NetworkType.WIFI;
        }
        return (NetworkType) invokeV.objValue;
    }

    public String getOS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "android" : (String) invokeV.objValue;
    }

    public String getOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                this.f75199g = ((TelephonyManager) this.n.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused) {
            }
            return this.f75199g;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v8 int)] */
    public String getPhoneNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                    if (networkType == 0) {
                        networkType = activeNetworkInfo.getSubtype();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(networkType);
                    this.f75200h = sb.toString();
                }
            } catch (Exception unused) {
            }
            return this.f75200h;
        }
        return (String) invokeV.objValue;
    }

    public String getPlainDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (StringUtil.isEmpty(this.f75202j)) {
                if (this.n.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1 && GlobalSetting.isAgreePrivacyStrategyNonNull()) {
                    try {
                        this.f75202j = ((TelephonyManager) this.n.getSystemService("phone")).getDeviceId();
                    } catch (Exception e2) {
                        GDTLogger.d("Get imei encounter error: " + e2.getMessage());
                    }
                    return StringUtil.isEmpty(this.f75202j) ? "" : this.f75202j;
                }
                return "";
            }
            return this.f75202j;
        }
        return (String) invokeV.objValue;
    }

    public String getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f75198f = this.n.getResources().getConfiguration().orientation == 2 ? "l" : "p";
            return this.f75198f;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1) {
                if (this.f75193a == null) {
                    String string = Settings.Secure.getString(this.n.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    this.f75193a = string != null ? Md5Util.encode(string) : "";
                }
                return this.f75193a;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Exception unused) {
                return 3;
            }
        }
        return invokeV.intValue;
    }
}
