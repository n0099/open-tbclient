package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.ABTestConstants;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes7.dex */
public enum DeviceManager {
    instance;
    
    public static final String KEY_MAGIC1 = "!qazxsw@";
    public static final String KEY_MAGIC2 = "#edcvfr$";
    public static final Object LOCK = DeviceManager.class;
    public static final String NULL_STRING = "-";
    public Device mDi = null;

    DeviceManager() {
    }

    private Device createNewDevice(Context context) {
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

    private String d2s(Device device) {
        String str = TextUtils.isEmpty(device.imei) ? "-" : device.imei;
        String str2 = TextUtils.isEmpty(device.mac) ? "-" : device.mac;
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

    private String getUniqueId() {
        try {
            return Coder.encryptMD5(UUID.randomUUID().toString() + System.currentTimeMillis() + System.nanoTime() + new Random().nextInt(ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT));
        } catch (Throwable unused) {
            return UUID.randomUUID().toString().replace("-", "");
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

    private Device s2d(String str) {
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

    private void saveInner(Context context, Device device) {
        try {
            FileUtil.saveFile(getInnerPath(context), Coder.encryptDES(d2s(device), "!qazxsw@#edcvfr$"));
        } catch (Throwable th) {
            L.debug(this, "saveInner exception = %s", th);
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

    public void syncAll(Context context, Device device) {
        if (getInner(context) == null) {
            saveInner(context, device);
            L.debug(this, "syncAll", new Object[0]);
        }
    }
}
