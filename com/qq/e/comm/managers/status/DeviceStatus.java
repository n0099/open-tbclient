package com.qq.e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.statistics.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes15.dex */
public class DeviceStatus {

    /* renamed from: a  reason: collision with root package name */
    private String f11565a;

    /* renamed from: b  reason: collision with root package name */
    private String f11566b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private volatile String k;
    private volatile String l;
    private volatile float m;
    public final String model = Build.MODEL;
    private Context n;

    public DeviceStatus(Context context) {
        this.n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        a();
    }

    private int a(float f, int i) {
        return (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (i / f) : i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0037: INVOKE  (r4v1 double A[REMOVE]) = (r2v6 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x004a: INVOKE  (r4v2 double A[REMOVE]) = (r2v6 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    private void a() {
        try {
            final LocationManager locationManager = (LocationManager) this.n.getSystemService(Headers.LOCATION);
            if (locationManager == null) {
                return;
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                String bestProvider = locationManager.getBestProvider(criteria, true);
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null) {
                    this.k = new StringBuilder().append(lastKnownLocation.getLatitude()).toString();
                    this.l = new StringBuilder().append(lastKnownLocation.getLongitude()).toString();
                    this.m = lastKnownLocation.getAccuracy();
                } else {
                    try {
                        locationManager.requestLocationUpdates(bestProvider, 2000L, 7000.0f, new LocationListener() { // from class: com.qq.e.comm.managers.status.DeviceStatus.1
                            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0007: INVOKE  (r2v0 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
                            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x001d: INVOKE  (r2v1 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
                            @Override // android.location.LocationListener
                            public void onLocationChanged(Location location) {
                                try {
                                    DeviceStatus.this.k = new StringBuilder().append(location.getLatitude()).toString();
                                    DeviceStatus.this.l = new StringBuilder().append(location.getLongitude()).toString();
                                    locationManager.removeUpdates(this);
                                } catch (Throwable th) {
                                }
                            }

                            @Override // android.location.LocationListener
                            public void onProviderDisabled(String str) {
                            }

                            @Override // android.location.LocationListener
                            public void onProviderEnabled(String str) {
                            }

                            @Override // android.location.LocationListener
                            public void onStatusChanged(String str, int i, Bundle bundle) {
                            }
                        });
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
        }
    }

    public Carrier getCarrier() {
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

    public String getDataNet() {
        NetworkInfo networkInfo;
        String str;
        try {
            networkInfo = ((ConnectivityManager) this.n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        switch (networkInfo.getType()) {
            case 0:
                str = Config.EVENT_PATH_MAPPING;
                break;
            case 1:
                str = IXAdRequestInfo.WIFI;
                break;
            default:
                str = "unknow";
                break;
        }
        this.i = str;
        return this.i;
    }

    public int getDeviceDensity() {
        return this.e;
    }

    public int getDeviceHeight() {
        return this.d;
    }

    public int getDeviceWidth() {
        return this.c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v11 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v12 int)] */
    public Map<String, String> getLacAndCeilId() {
        int i;
        int i2;
        GsmCellLocation gsmCellLocation;
        String operator = getOperator();
        HashMap hashMap = new HashMap();
        if (this.n.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !"null".equalsIgnoreCase(operator)) {
            try {
                if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int networkId = cdmaCellLocation.getNetworkId();
                        i = cdmaCellLocation.getBaseStationId();
                        i2 = networkId;
                    } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                        i = 0;
                        i2 = 0;
                    } else {
                        int lac = gsmCellLocation.getLac();
                        i = gsmCellLocation.getCid();
                        i2 = lac;
                    }
                    hashMap.put("lac", new StringBuilder().append(i2).toString());
                    hashMap.put("cellid", new StringBuilder().append(i).toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.f11566b == null) {
            this.f11566b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.f11566b.length() == 0) {
                this.f11566b = h.f1945a;
            }
        }
        return this.f11566b;
    }

    public String getLat() {
        return this.k;
    }

    public String getLng() {
        return this.l;
    }

    public float getLocationAccuracy() {
        return this.m;
    }

    public NetworkType getNetworkType() {
        int i;
        String dataNet = getDataNet();
        if (dataNet == null || !dataNet.equals(IXAdRequestInfo.WIFI)) {
            try {
                i = Integer.parseInt(getPhoneNet());
            } catch (NumberFormatException e) {
                i = 0;
            }
            switch (i) {
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

    public String getOS() {
        return HttpConstants.OS_TYPE_VALUE;
    }

    public String getOperator() {
        try {
            this.g = ((TelephonyManager) this.n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
        }
        return this.g;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v11 int)] */
    public String getPhoneNet() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                if (networkType == 0) {
                    networkType = activeNetworkInfo.getSubtype();
                }
                this.h = new StringBuilder().append(networkType).toString();
            }
        } catch (Exception e) {
        }
        return this.h;
    }

    public String getPlainDid() {
        if (StringUtil.isEmpty(this.j)) {
            if (this.n.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1) {
                try {
                    this.j = ((TelephonyManager) this.n.getSystemService("phone")).getDeviceId();
                } catch (Exception e) {
                    GDTLogger.d("Get imei encounter error: " + e.getMessage());
                }
                return StringUtil.isEmpty(this.j) ? "" : this.j;
            }
            return "";
        }
        return this.j;
    }

    public String getScreenOrientation() {
        if (this.n.getResources().getConfiguration().orientation == 2) {
            this.f = "l";
        } else {
            this.f = "p";
        }
        return this.f;
    }

    public String getUid() {
        if (GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1) {
            if (this.f11565a == null) {
                String string = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
                this.f11565a = string == null ? "" : Md5Util.encode(string);
            }
            return this.f11565a;
        }
        return "";
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e) {
            return 3;
        }
    }
}
