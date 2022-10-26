package com.qq.e.comm.managers.status;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class DeviceStatus {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public AtomicInteger k;
    public Context l;
    public final String model;

    public DeviceStatus(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.model = Build.MODEL;
        this.l = context.getApplicationContext();
        a(context);
    }

    private int a(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) ? (this.l.getApplicationInfo().flags & 8192) != 0 ? (int) (i / f) : i : invokeCommon.intValue;
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
                networkInfo = ((ConnectivityManager) this.l.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (networkInfo == null) {
                return null;
            }
            int type = networkInfo.getType();
            String str = type != 0 ? type != 1 ? "unknow" : "wi" : Config.EVENT_PATH_MAPPING;
            this.h = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int getDeviceDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }

    public int getDeviceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.intValue;
    }

    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = "";
            if (GlobalSetting.isAgreePrivacyStrategy()) {
                String str2 = this.i;
                if (str2 != null) {
                    return str2;
                }
                if (GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1 && hasReadPhoneStatePermission()) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) this.l.getSystemService("phone");
                        String deviceId = telephonyManager == null ? null : ApiReplaceUtil.getDeviceId(telephonyManager);
                        this.i = deviceId;
                        if (deviceId != null) {
                            str = deviceId;
                        }
                        this.i = str;
                    } catch (Exception e) {
                        GDTLogger.d("Get imei encounter error: " + e.getMessage());
                    }
                    return this.i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.intValue;
    }

    public Map getLacAndCeilId() {
        InterceptResult invokeV;
        int i;
        GsmCellLocation gsmCellLocation;
        int cid;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String operator = getOperator();
            HashMap hashMap = new HashMap();
            if (GDTADManager.getInstance().getSM().getInteger("cellon", 1) == 1 && this.l.checkCallingOrSelfPermission(h.h) == 0 && !StringUtil.isEmpty(operator) && !com.baidu.android.common.others.lang.StringUtil.NULL_STRING.equalsIgnoreCase(operator)) {
                int i3 = 0;
                try {
                    if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                        TelephonyManager telephonyManager = (TelephonyManager) this.l.getSystemService("phone");
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof CdmaCellLocation) {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            i2 = cdmaCellLocation.getNetworkId();
                            cid = cdmaCellLocation.getBaseStationId();
                        } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                            i = 0;
                            hashMap.put("lac", i3 + "");
                            hashMap.put("cellid", "" + i);
                        } else {
                            int lac = gsmCellLocation.getLac();
                            cid = gsmCellLocation.getCid();
                            i2 = lac;
                        }
                        int i4 = cid;
                        i3 = i2;
                        i = i4;
                        hashMap.put("lac", i3 + "");
                        hashMap.put("cellid", "" + i);
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
            if (this.a == null) {
                String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
                this.a = lowerCase;
                if (lowerCase.length() == 0) {
                    this.a = "en";
                }
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public NetworkType getNetworkType() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String dataNet = getDataNet();
            if (dataNet == null || !dataNet.equals("wi")) {
                try {
                    i = Integer.parseInt(getPhoneNet());
                } catch (NumberFormatException unused) {
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
        return (NetworkType) invokeV.objValue;
    }

    public String getOS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "android" : (String) invokeV.objValue;
    }

    public String getOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                this.f = ((TelephonyManager) this.l.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused) {
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String getPhoneNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                    if (networkType == 0) {
                        networkType = activeNetworkInfo.getSubtype();
                    }
                    this.g = "" + networkType;
                }
            } catch (Exception unused) {
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.e = this.l.getResources().getConfiguration().orientation == 2 ? "l" : "p";
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                this.j = true;
                return true;
            }
            if (this.k == null) {
                this.k = new AtomicInteger(GDTADManager.getInstance().getSM().getInteger("rpspc", Integer.MAX_VALUE));
            }
            if (this.k.getAndDecrement() > 0) {
                this.j = this.l.checkSelfPermission(h.c) == 0;
            }
            return this.j;
        }
        return invokeV.booleanValue;
    }

    private void a(Context context) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (getVersion() > 3) {
                i = displayMetrics.densityDpi;
            } else {
                i = 120;
            }
            this.d = i;
            if (getVersion() > 3) {
                i2 = a(displayMetrics.density, displayMetrics.widthPixels);
            } else {
                i2 = displayMetrics.widthPixels;
            }
            this.b = i2;
            if (getVersion() > 3) {
                i3 = a(displayMetrics.density, displayMetrics.heightPixels);
            } else {
                i3 = displayMetrics.heightPixels;
            }
            this.c = i3;
        }
    }
}
