package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExceptionCode;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes2.dex */
public enum DeviceManager {
    instance;
    
    public static final String KEY_MAGIC1 = "!qazxsw@";
    public static final String KEY_MAGIC2 = "#edcvfr$";
    public static final Object LOCK = DeviceManager.class;
    public static final String NULL_STRING = "-";
    public Device mDi = null;

    DeviceManager() {
    }

    private void saveInner(Context context, Device device) {
        try {
            FileUtil.saveFile(getInnerPath(context), Coder.encryptDES(d2s(device), "!qazxsw@#edcvfr$"));
        } catch (Throwable th) {
            L.debug(this, "saveInner exception = %s", th);
        }
    }

    public void syncAll(Context context, Device device) {
        if (getInner(context) == null) {
            saveInner(context, device);
            L.debug(this, "syncAll", new Object[0]);
        }
    }

    private Device createNewDevice(Context context) {
        int i;
        String str;
        String str2 = "";
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
            if (isValidMac) {
                i = 2;
            } else {
                i = 0;
            }
            sb.append(isValidArid | i);
            sb.append("");
            device.type = sb.toString();
            if (device.arid == null) {
                str = "";
            } else {
                str = device.arid;
            }
            if (device.mac != null) {
                str2 = device.mac;
            }
            device.hdid = Coder.encryptMD5(str + "_" + str2);
            return device;
        } catch (Throwable unused) {
            device.type = "0";
            device.hdid = getUniqueId();
            return device;
        }
    }

    private Device s2d(String str) {
        String str2;
        String str3 = null;
        if (str == null) {
            return null;
        }
        String[] split = str.split(",", -1);
        if (split.length < 4) {
            return null;
        }
        if (key(split[0] + split[1] + split[2]).equals(split[3])) {
            Device device = new Device();
            device.hdid = split[0];
            if ("-".equals(split[1])) {
                str2 = null;
            } else {
                str2 = split[1];
            }
            device.imei = str2;
            if (!"-".equals(split[2])) {
                str3 = split[2];
            }
            device.mac = str3;
            return device;
        }
        L.debug("DeviceProxy", "verify fail. %s", str + "");
        return null;
    }

    private String d2s(Device device) {
        String str;
        String str2 = "-";
        if (TextUtils.isEmpty(device.imei)) {
            str = "-";
        } else {
            str = device.imei;
        }
        if (!TextUtils.isEmpty(device.mac)) {
            str2 = device.mac;
        }
        return String.format("%s,%s,%s,%s", device.hdid, str, str2, key(device.hdid + str + str2));
    }

    private Device getInner(Context context) {
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

    private String getInnerPath(Context context) {
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

    private Device initDevice(Context context) {
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

    private boolean isValidArid(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean isValidMac(String str) {
        return ArdUtil.isValidMac(str);
    }

    private String key(String str) {
        try {
            return Coder.encryptMD5(str + KEY_MAGIC1 + KEY_MAGIC2);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            return "";
        }
    }

    public Device getDevice(Context context) {
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

    private String getUniqueId() {
        try {
            return Coder.encryptMD5(UUID.randomUUID().toString() + System.currentTimeMillis() + System.nanoTime() + new Random().nextInt(ExceptionCode.CRASH_EXCEPTION));
        } catch (Throwable unused) {
            return UUID.randomUUID().toString().replace("-", "");
        }
    }
}
