package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class DeviceManagerV2 {
    public static final /* synthetic */ DeviceManagerV2[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_MAGIC1 = "!qazxsw@v2";
    public static final String KEY_MAGIC2 = "#edcvfr$v2";
    public static final Object LOCK;
    public static final String SETTING_KEY = "HdSdkBBAVip";
    public static final DeviceManagerV2 instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Device mDi;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1560053601, "Lcom/yy/hiidostatis/inner/util/hdid/DeviceManagerV2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1560053601, "Lcom/yy/hiidostatis/inner/util/hdid/DeviceManagerV2;");
                return;
            }
        }
        DeviceManagerV2 deviceManagerV2 = new DeviceManagerV2(Transition.MATCH_INSTANCE_STR, 0);
        instance = deviceManagerV2;
        $VALUES = new DeviceManagerV2[]{deviceManagerV2};
        LOCK = FilenameFilter.class;
    }

    public DeviceManagerV2(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDi = null;
    }

    private String d2s(Device device) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, device)) == null) {
            if (device.json == null) {
                device.json = new JSONObject();
            }
            putString(device.json, "hdid", device.hdid);
            putString(device.json, "type", device.type);
            putString(device.json, "imei", device.imei);
            putString(device.json, BaseStatisContent.MAC, device.mac);
            putString(device.json, BaseStatisContent.ARID, device.arid);
            JSONObject jSONObject = device.json;
            putString(jSONObject, "key", key(device.hdid + device.imei + device.mac));
            putLong(device.json, "crtTime", device.crtTime);
            return device.json.toString();
        }
        return (String) invokeL.objValue;
    }

    private Device getInner(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            try {
                String readFile = FileUtil.readFile(getInnerPath(context));
                if (readFile != null) {
                    return s2d(Coder.decryptDES(readFile, "!qazxsw@v2#edcvfr$v2"));
                }
                return null;
            } catch (Throwable th) {
                L.debug(this, "getInner exception = %s", th);
                return null;
            }
        }
        return (Device) invokeL.objValue;
    }

    private String getInnerPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(context.getFilesDir().getAbsolutePath());
                stringBuffer.append(File.separator);
                stringBuffer.append("hdid_v2");
                String stringBuffer2 = stringBuffer.toString();
                stringBuffer.setLength(0);
                return stringBuffer2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private long getLong(JSONObject jSONObject, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{jSONObject, str, Long.valueOf(j2)})) == null) {
            if (jSONObject == null || !jSONObject.has(str)) {
                return j2;
            }
            try {
                return jSONObject.getLong(str);
            } catch (JSONException e2) {
                L.debug(this, e2.getMessage(), new Object[0]);
                return j2;
            }
        }
        return invokeCommon.longValue;
    }

    private String getSdpm(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
            boolean checkPermissions = ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append(checkPermissions ? 4 : 0);
            sb.append("");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private Device getSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                String string = Settings.System.getString(context.getContentResolver(), SETTING_KEY);
                if (string != null) {
                    return s2d(Coder.decryptDES(string, KEY_MAGIC2));
                }
                return null;
            } catch (Throwable th) {
                L.debug(this, "getSetting exception = %s", th);
                return null;
            }
        }
        return (Device) invokeL.objValue;
    }

    private String getString(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, jSONObject, str)) == null) {
            if (jSONObject != null && jSONObject.has(str)) {
                try {
                    return jSONObject.getString(str);
                } catch (JSONException e2) {
                    L.debug(this, e2.getMessage(), new Object[0]);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    private Device initDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            Device inner = getInner(context);
            Device setting = getSetting(context);
            if (inner != null) {
                inner.hFrom = 4;
                if (setting == null) {
                    saveSetting(context, inner);
                    L.debug(this, "saveSetting", new Object[0]);
                }
                DeviceManager.instance.syncAll(context, inner);
                return inner;
            } else if (setting != null) {
                setting.hFrom = 6;
                saveInner(context, setting);
                L.debug(this, "saveInner", new Object[0]);
                DeviceManager.instance.syncAll(context, setting);
                return setting;
            } else {
                L.debug(this, "saveInner,saveOut1,saveSetting", new Object[0]);
                Device device = DeviceManager.instance.getDevice(context);
                saveInner(context, device);
                saveSetting(context, device);
                return device;
            }
        }
        return (Device) invokeL.objValue;
    }

    private String key(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            try {
                return Coder.encryptMD5(str + KEY_MAGIC1 + KEY_MAGIC2);
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private boolean putLong(JSONObject jSONObject, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{jSONObject, str, Long.valueOf(j2)})) == null) {
            try {
                jSONObject.put(str, j2);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean putString(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, jSONObject, str, str2)) == null) {
            try {
                jSONObject.put(str, str2);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private Device s2d(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                L.debug(this, e2.getMessage(), new Object[0]);
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            String string = getString(jSONObject, "hdid");
            String string2 = getString(jSONObject, "type");
            String string3 = getString(jSONObject, "imei");
            String string4 = getString(jSONObject, BaseStatisContent.MAC);
            if (key(string + string3 + string4).equals(getString(jSONObject, "key"))) {
                Device device = new Device();
                device.json = jSONObject;
                device.hdid = string;
                device.imei = string3;
                device.mac = string4;
                device.type = string2;
                device.arid = getString(jSONObject, BaseStatisContent.ARID);
                device.crtTime = getLong(jSONObject, "crtTime", 0L);
                return device;
            }
            L.debug("DeviceProxy", "verify fail. %s", str + "");
            return null;
        }
        return (Device) invokeL.objValue;
    }

    private void saveInner(Context context, Device device) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, context, device) == null) {
            try {
                FileUtil.saveFile(getInnerPath(context), Coder.encryptDES(d2s(device), "!qazxsw@v2#edcvfr$v2"));
            } catch (Throwable th) {
                L.debug(this, "saveInner exception = %s", th);
            }
        }
    }

    private void saveSetting(Context context, Device device) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, this, context, device) == null) && ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                Settings.System.putString(context.getContentResolver(), SETTING_KEY, Coder.encryptDES(d2s(device), KEY_MAGIC2));
            } catch (Throwable th) {
                L.debug(this, "saveSetting exception = %s", th);
            }
        }
    }

    public static DeviceManagerV2 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? (DeviceManagerV2) Enum.valueOf(DeviceManagerV2.class, str) : (DeviceManagerV2) invokeL.objValue;
    }

    public static DeviceManagerV2[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? (DeviceManagerV2[]) $VALUES.clone() : (DeviceManagerV2[]) invokeV.objValue;
    }

    public Device getDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Device device = this.mDi;
            if (device != null) {
                return device;
            }
            synchronized (LOCK) {
                if (this.mDi != null) {
                    return this.mDi;
                }
                Device initDevice = initDevice(context);
                this.mDi = initDevice;
                initDevice.sdPermission = getSdpm(context);
                return this.mDi;
            }
        }
        return (Device) invokeL.objValue;
    }
}
