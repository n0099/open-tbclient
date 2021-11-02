package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ABTestConstants;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.Random;
import java.util.UUID;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class DeviceManager {
    public static final /* synthetic */ DeviceManager[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_MAGIC1 = "!qazxsw@";
    public static final String KEY_MAGIC2 = "#edcvfr$";
    public static final Object LOCK;
    public static final String NULL_STRING = "-";
    public static final DeviceManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Device mDi;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1261957189, "Lcom/yy/hiidostatis/inner/util/hdid/DeviceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1261957189, "Lcom/yy/hiidostatis/inner/util/hdid/DeviceManager;");
                return;
            }
        }
        DeviceManager deviceManager = new DeviceManager(Transition.MATCH_INSTANCE_STR, 0);
        instance = deviceManager;
        $VALUES = new DeviceManager[]{deviceManager};
        LOCK = DeviceManager.class;
    }

    public DeviceManager(String str, int i2) {
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

    private Device createNewDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            String str = "";
            Device device = new Device();
            device.imei = ArdUtil.getImei(context);
            device.mac = ArdUtil.getMacAddrV23(context);
            device.arid = ArdUtil.getAndroidId(context);
            device.crtTime = System.currentTimeMillis();
            try {
                boolean isValidArid = isValidArid(device.arid);
                boolean isValidMac = isValidMac(device.mac);
                if (!isValidArid && !isValidMac) {
                    device.type = "0";
                    device.hdid = getUniqueId();
                    return device;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(isValidArid | (isValidMac ? 2 : 0));
                sb.append("");
                device.type = sb.toString();
                String str2 = device.arid == null ? "" : device.arid;
                if (device.mac != null) {
                    str = device.mac;
                }
                device.hdid = Coder.encryptMD5(str2 + "_" + str);
                return device;
            } catch (Throwable unused) {
                device.type = "0";
                device.hdid = getUniqueId();
                return device;
            }
        }
        return (Device) invokeL.objValue;
    }

    private String d2s(Device device) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, device)) == null) {
            String str = TextUtils.isEmpty(device.imei) ? "-" : device.imei;
            String str2 = TextUtils.isEmpty(device.mac) ? "-" : device.mac;
            return String.format("%s,%s,%s,%s", device.hdid, str, str2, key(device.hdid + str + str2));
        }
        return (String) invokeL.objValue;
    }

    private Device getInner(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                String readFile = FileUtil.readFile(getInnerPath(context));
                if (readFile != null) {
                    return s2d(Coder.decryptDES(readFile, "!qazxsw@#edcvfr$"));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(context.getFilesDir().getAbsolutePath());
                stringBuffer.append(File.separator);
                stringBuffer.append("hdid.bck");
                String stringBuffer2 = stringBuffer.toString();
                stringBuffer.setLength(0);
                return stringBuffer2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            try {
                return Coder.encryptMD5(UUID.randomUUID().toString() + System.currentTimeMillis() + System.nanoTime() + new Random().nextInt(ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT));
            } catch (Throwable unused) {
                return UUID.randomUUID().toString().replace("-", "");
            }
        }
        return (String) invokeV.objValue;
    }

    private Device initDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            Device inner = getInner(context);
            if (inner != null) {
                inner.hFrom = 1;
                return inner;
            }
            Device createNewDevice = createNewDevice(context);
            createNewDevice.hFrom = 0;
            saveInner(context, createNewDevice);
            L.debug(this, "others,createNewDevice,saveInner", new Object[0]);
            return createNewDevice;
        }
        return (Device) invokeL.objValue;
    }

    private boolean isValidArid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    private boolean isValidMac(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) ? ArdUtil.isValidMac(str) : invokeL.booleanValue;
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

    private Device s2d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = str.split(",", -1);
            if (split.length >= 4) {
                if (key(split[0] + split[1] + split[2]).equals(split[3])) {
                    Device device = new Device();
                    device.hdid = split[0];
                    device.imei = "-".equals(split[1]) ? null : split[1];
                    device.mac = "-".equals(split[2]) ? null : split[2];
                    return device;
                }
                L.debug("DeviceProxy", "verify fail. %s", str + "");
                return null;
            }
            return null;
        }
        return (Device) invokeL.objValue;
    }

    private void saveInner(Context context, Device device) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, context, device) == null) {
            try {
                FileUtil.saveFile(getInnerPath(context), Coder.encryptDES(d2s(device), "!qazxsw@#edcvfr$"));
            } catch (Throwable th) {
                L.debug(this, "saveInner exception = %s", th);
            }
        }
    }

    public static DeviceManager valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? (DeviceManager) Enum.valueOf(DeviceManager.class, str) : (DeviceManager) invokeL.objValue;
    }

    public static DeviceManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? (DeviceManager[]) $VALUES.clone() : (DeviceManager[]) invokeV.objValue;
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
                return initDevice;
            }
        }
        return (Device) invokeL.objValue;
    }

    public void syncAll(Context context, Device device) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, device) == null) && getInner(context) == null) {
            saveInner(context, device);
            L.debug(this, "syncAll", new Object[0]);
        }
    }
}
