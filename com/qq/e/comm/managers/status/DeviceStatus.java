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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public class DeviceStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f36296a;

    /* renamed from: b  reason: collision with root package name */
    public String f36297b;

    /* renamed from: c  reason: collision with root package name */
    public int f36298c;

    /* renamed from: d  reason: collision with root package name */
    public int f36299d;

    /* renamed from: e  reason: collision with root package name */
    public int f36300e;

    /* renamed from: f  reason: collision with root package name */
    public String f36301f;

    /* renamed from: g  reason: collision with root package name */
    public String f36302g;

    /* renamed from: h  reason: collision with root package name */
    public String f36303h;

    /* renamed from: i  reason: collision with root package name */
    public String f36304i;
    public String j;
    public volatile String k;
    public volatile String l;
    public volatile float m;
    public final String model = Build.MODEL;
    public Context n;

    public DeviceStatus(Context context) {
        this.n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f36300e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f36298c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f36299d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        a();
    }

    private int a(float f2, int i2) {
        return (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (i2 / f2) : i2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x003b: INVOKE  (r2v4 double A[REMOVE]) = (r0v4 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x004d: INVOKE  (r2v5 double A[REMOVE]) = (r0v4 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    private void a() {
        final LocationManager locationManager;
        try {
            if (GlobalSetting.isAgreePrivacyStrategyNonNull() && (locationManager = (LocationManager) this.n.getSystemService("location")) != null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(2);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                String bestProvider = locationManager.getBestProvider(criteria, true);
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lastKnownLocation.getLatitude());
                    this.k = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(lastKnownLocation.getLongitude());
                    this.l = sb2.toString();
                    this.m = lastKnownLocation.getAccuracy();
                } else {
                    locationManager.requestLocationUpdates(bestProvider, 2000L, 7000.0f, new LocationListener() { // from class: com.qq.e.comm.managers.status.DeviceStatus.1
                        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0007: INVOKE  (r2v0 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
                        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x001c: INVOKE  (r2v1 double A[REMOVE]) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
                        @Override // android.location.LocationListener
                        public void onLocationChanged(Location location) {
                            try {
                                DeviceStatus deviceStatus = DeviceStatus.this;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(location.getLatitude());
                                deviceStatus.k = sb3.toString();
                                DeviceStatus deviceStatus2 = DeviceStatus.this;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(location.getLongitude());
                                deviceStatus2.l = sb4.toString();
                                locationManager.removeUpdates(this);
                            } catch (Throwable unused) {
                            }
                        }

                        @Override // android.location.LocationListener
                        public void onProviderDisabled(String str) {
                        }

                        @Override // android.location.LocationListener
                        public void onProviderEnabled(String str) {
                        }

                        @Override // android.location.LocationListener
                        public void onStatusChanged(String str, int i2, Bundle bundle) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
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
        try {
            networkInfo = ((ConnectivityManager) this.n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        int type = networkInfo.getType();
        String str = type != 0 ? type != 1 ? "unknow" : IAdRequestParam.WIFI : Config.EVENT_PATH_MAPPING;
        this.f36304i = str;
        return str;
    }

    public int getDeviceDensity() {
        return this.f36300e;
    }

    public int getDeviceHeight() {
        return this.f36299d;
    }

    public int getDeviceWidth() {
        return this.f36298c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v11 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v3 int)] */
    public Map<String, String> getLacAndCeilId() {
        int i2;
        GsmCellLocation gsmCellLocation;
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

    public String getLanguage() {
        if (this.f36297b == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.f36297b = lowerCase;
            if (lowerCase.length() == 0) {
                this.f36297b = "en";
            }
        }
        return this.f36297b;
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
        int i2;
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

    public String getOS() {
        return "android";
    }

    public String getOperator() {
        try {
            this.f36302g = ((TelephonyManager) this.n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
        }
        return this.f36302g;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v6 int)] */
    public String getPhoneNet() {
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
                this.f36303h = sb.toString();
            }
        } catch (Exception unused) {
        }
        return this.f36303h;
    }

    public String getPlainDid() {
        if (StringUtil.isEmpty(this.j)) {
            if (this.n.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1 && GlobalSetting.isAgreePrivacyStrategyNonNull()) {
                try {
                    this.j = ((TelephonyManager) this.n.getSystemService("phone")).getDeviceId();
                } catch (Exception e2) {
                    GDTLogger.d("Get imei encounter error: " + e2.getMessage());
                }
                return StringUtil.isEmpty(this.j) ? "" : this.j;
            }
            return "";
        }
        return this.j;
    }

    public String getScreenOrientation() {
        this.f36301f = this.n.getResources().getConfiguration().orientation == 2 ? "l" : "p";
        return this.f36301f;
    }

    public String getUid() {
        if (GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1) {
            if (this.f36296a == null) {
                String string = Settings.Secure.getString(this.n.getContentResolver(), IAdRequestParam.ANDROID_ID);
                this.f36296a = string != null ? Md5Util.encode(string) : "";
            }
            return this.f36296a;
        }
        return "";
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }
}
