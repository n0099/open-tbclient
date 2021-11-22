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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.h;
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
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class DeviceStatus {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68953a;

    /* renamed from: b  reason: collision with root package name */
    public String f68954b;

    /* renamed from: c  reason: collision with root package name */
    public int f68955c;

    /* renamed from: d  reason: collision with root package name */
    public int f68956d;

    /* renamed from: e  reason: collision with root package name */
    public int f68957e;

    /* renamed from: f  reason: collision with root package name */
    public String f68958f;

    /* renamed from: g  reason: collision with root package name */
    public String f68959g;

    /* renamed from: h  reason: collision with root package name */
    public String f68960h;

    /* renamed from: i  reason: collision with root package name */
    public String f68961i;
    public String j;
    public boolean k;
    public AtomicInteger l;
    public volatile String m;
    public final String model;
    public volatile String n;
    public volatile float o;
    public Context p;

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
        this.p = context.getApplicationContext();
        a(context);
    }

    private int a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? (this.p.getApplicationInfo().flags & 8192) != 0 ? (int) (i2 / f2) : i2 : invokeCommon.intValue;
    }

    private void a(Context context) {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.f68957e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
            this.f68955c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
            this.f68956d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
            try {
                if (GlobalSetting.isLocationAllowed() && (locationManager = (LocationManager) this.p.getSystemService("location")) != null) {
                    Criteria criteria = new Criteria();
                    criteria.setAccuracy(2);
                    criteria.setAltitudeRequired(false);
                    criteria.setBearingRequired(false);
                    criteria.setCostAllowed(true);
                    criteria.setPowerRequirement(1);
                    String bestProvider = locationManager.getBestProvider(criteria, true);
                    Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    if (lastKnownLocation != null) {
                        this.m = "" + lastKnownLocation.getLatitude();
                        this.n = "" + lastKnownLocation.getLongitude();
                        this.o = lastKnownLocation.getAccuracy();
                    } else {
                        locationManager.requestLocationUpdates(bestProvider, 2000L, 7000.0f, new LocationListener(this, locationManager) { // from class: com.qq.e.comm.managers.status.DeviceStatus.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LocationManager f68962a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ DeviceStatus f68963b;

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
                                this.f68963b = this;
                                this.f68962a = locationManager;
                            }

                            @Override // android.location.LocationListener
                            public void onLocationChanged(Location location) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, location) == null) {
                                    try {
                                        DeviceStatus deviceStatus = this.f68963b;
                                        deviceStatus.m = "" + location.getLatitude();
                                        DeviceStatus deviceStatus2 = this.f68963b;
                                        deviceStatus2.n = "" + location.getLongitude();
                                        this.f68962a.removeUpdates(this);
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
                    }
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
                networkInfo = ((ConnectivityManager) this.p.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (networkInfo == null) {
                return null;
            }
            int type = networkInfo.getType();
            String str = type != 0 ? type != 1 ? "unknow" : IAdRequestParam.WIFI : "ed";
            this.f68961i = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int getDeviceDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68957e : invokeV.intValue;
    }

    public int getDeviceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68956d : invokeV.intValue;
    }

    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = "";
            if (GlobalSetting.isAgreePrivacyStrategy()) {
                String str2 = this.j;
                if (str2 != null) {
                    return str2;
                }
                if (GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1 && hasReadPhoneStatePermission()) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) this.p.getSystemService("phone");
                        String deviceId = telephonyManager == null ? null : telephonyManager.getDeviceId();
                        this.j = deviceId;
                        if (deviceId != null) {
                            str = deviceId;
                        }
                        this.j = str;
                    } catch (Exception e2) {
                        GDTLogger.d("Get imei encounter error: " + e2.getMessage());
                    }
                    return this.j;
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getDeviceIdMD5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String deviceId = getDeviceId();
            return TextUtils.isEmpty(deviceId) ? "" : Md5Util.encode(deviceId.toLowerCase());
        }
        return (String) invokeV.objValue;
    }

    public int getDeviceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68955c : invokeV.intValue;
    }

    public Map<String, String> getLacAndCeilId() {
        InterceptResult invokeV;
        int i2;
        GsmCellLocation gsmCellLocation;
        int cid;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String operator = getOperator();
            HashMap hashMap = new HashMap();
            if (this.p.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !com.baidu.android.common.others.lang.StringUtil.NULL_STRING.equalsIgnoreCase(operator)) {
                int i4 = 0;
                try {
                    if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                        TelephonyManager telephonyManager = (TelephonyManager) this.p.getSystemService("phone");
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof CdmaCellLocation) {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            i3 = cdmaCellLocation.getNetworkId();
                            cid = cdmaCellLocation.getBaseStationId();
                        } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                            i2 = 0;
                            hashMap.put("lac", i4 + "");
                            hashMap.put("cellid", "" + i2);
                        } else {
                            int lac = gsmCellLocation.getLac();
                            cid = gsmCellLocation.getCid();
                            i3 = lac;
                        }
                        int i5 = cid;
                        i4 = i3;
                        i2 = i5;
                        hashMap.put("lac", i4 + "");
                        hashMap.put("cellid", "" + i2);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f68954b == null) {
                String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
                this.f68954b = lowerCase;
                if (lowerCase.length() == 0) {
                    this.f68954b = h.f38333a;
                }
            }
            return this.f68954b;
        }
        return (String) invokeV.objValue;
    }

    public String getLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public String getLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public float getLocationAccuracy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : invokeV.floatValue;
    }

    public NetworkType getNetworkType() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "android" : (String) invokeV.objValue;
    }

    public String getOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                this.f68959g = ((TelephonyManager) this.p.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused) {
            }
            return this.f68959g;
        }
        return (String) invokeV.objValue;
    }

    public String getPhoneNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                    if (networkType == 0) {
                        networkType = activeNetworkInfo.getSubtype();
                    }
                    this.f68960h = "" + networkType;
                }
            } catch (Exception unused) {
            }
            return this.f68960h;
        }
        return (String) invokeV.objValue;
    }

    public String getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f68958f = this.p.getResources().getConfiguration().orientation == 2 ? "l" : "p";
            return this.f68958f;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1) {
                if (this.f68953a == null) {
                    String string = Settings.Secure.getString(this.p.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    this.f68953a = string != null ? Md5Util.encode(string) : "";
                }
                return this.f68953a;
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

    public boolean hasReadPhoneStatePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.l == null) {
                this.l = new AtomicInteger(GDTADManager.getInstance().getSM().getInteger("rpspc", Integer.MAX_VALUE));
            }
            if (this.l.getAndDecrement() > 0) {
                this.k = this.p.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }
}
