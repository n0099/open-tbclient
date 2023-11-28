package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public enum DeviceManagerV2 {
    instance;
    
    public static final String KEY_MAGIC1 = "!qazxsw@v2";
    public static final String KEY_MAGIC2 = "#edcvfr$v2";
    public static final Object LOCK = FilenameFilter.class;
    public static final String SETTING_KEY = "HdSdkBBAVip";
    public Device mDi = null;

    DeviceManagerV2() {
    }

    private String getString(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
                L.debug(this, e.getMessage(), new Object[0]);
            }
        }
        return null;
    }

    private void saveInner(Context context, Device device) {
        try {
            FileUtil.saveFile(getInnerPath(context), Coder.encryptDES(d2s(device), "!qazxsw@v2#edcvfr$v2"));
        } catch (Throwable th) {
            L.debug(this, "saveInner exception = %s", th);
        }
    }

    private void saveSetting(Context context, Device device) {
        if (ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS")) {
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

    private String d2s(Device device) {
        if (device.json == null) {
            device.json = new JSONObject();
        }
        putString(device.json, "hdid", device.hdid);
        putString(device.json, "type", device.type);
        putString(device.json, "imei", device.imei);
        putString(device.json, "mac", device.mac);
        putString(device.json, BaseStatisContent.ARID, device.arid);
        JSONObject jSONObject = device.json;
        putString(jSONObject, "key", key(device.hdid + device.imei + device.mac));
        putLong(device.json, "crtTime", device.crtTime);
        return device.json.toString();
    }

    private Device s2d(String str) {
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            L.debug(this, e.getMessage(), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        String string = getString(jSONObject, "hdid");
        String string2 = getString(jSONObject, "type");
        String string3 = getString(jSONObject, "imei");
        String string4 = getString(jSONObject, "mac");
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

    private Device getInner(Context context) {
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

    private String getInnerPath(Context context) {
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

    private String getSdpm(Context context) {
        int i;
        boolean checkPermissions = ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS");
        StringBuilder sb = new StringBuilder();
        if (checkPermissions) {
            i = 4;
        } else {
            i = 0;
        }
        sb.append(i);
        sb.append("");
        return sb.toString();
    }

    private Device getSetting(Context context) {
        try {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            String string = ApiReplaceUtil.getString(context.getContentResolver(), SETTING_KEY);
            if (string != null) {
                return s2d(Coder.decryptDES(string, KEY_MAGIC2));
            }
            return null;
        } catch (Throwable th) {
            L.debug(this, "getSetting exception = %s", th);
            return null;
        }
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
            initDevice.sdPermission = getSdpm(context);
            return this.mDi;
        }
    }

    private long getLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException e) {
                L.debug(this, e.getMessage(), new Object[0]);
                return j;
            }
        }
        return j;
    }

    private boolean putLong(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private boolean putString(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private Device initDevice(Context context) {
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
}
