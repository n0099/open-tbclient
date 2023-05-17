package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FileFilter;
import java.util.UUID;
/* loaded from: classes10.dex */
public class UuidManager {
    public static String mDataPath;
    public static Object LOCK_KEY = FileFilter.class;
    public static String MAGIC_KEY = "!QAZXSW@#E";
    public static String SETTING_KEY = "HdSdkBBAUuid";
    public static String mUuid = null;

    public static String fetchUUid(Context context) {
        String str = mUuid;
        if (str != null) {
            return str;
        }
        synchronized (LOCK_KEY) {
            if (mUuid != null) {
                return mUuid;
            }
            String readUUid = readUUid(getDataPath(context));
            String setting = getSetting(context);
            if (readUUid != null) {
                L.debug("UuidManager", "uuid from data", new Object[0]);
                mUuid = readUUid;
                if (setting == null) {
                    saveSetting(context, readUUid);
                }
                return mUuid;
            } else if (setting != null) {
                L.debug("UuidManager", "uuid from setting", new Object[0]);
                mUuid = setting;
                saveUUid(getDataPath(context), mUuid);
                return mUuid;
            } else {
                L.debug("UuidManager", "uuid createNew", new Object[0]);
                mUuid = UUID.randomUUID().toString().replace("-", "");
                saveUUid(getDataPath(context), mUuid);
                saveSetting(context, mUuid);
                return mUuid;
            }
        }
    }

    public static String getDataPath(Context context) {
        if (mDataPath == null) {
            mDataPath = String.format("%s%s%s", context.getFilesDir().getAbsolutePath(), File.separator, "hduuid_v1");
        }
        L.verbose("UuidManager", "data uuid path:%s", mDataPath);
        return mDataPath;
    }

    public static String getSetting(Context context) {
        try {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            String string = ApiReplaceUtil.getString(context.getContentResolver(), SETTING_KEY);
            if (string != null) {
                return Coder.decryptDES(string, MAGIC_KEY);
            }
            return null;
        } catch (Throwable th) {
            L.debug("UuidManager", "getSetting throwable %s", th);
            return null;
        }
    }

    public static String readUUid(String str) {
        try {
            return Coder.decryptDES(FileUtil.readFile(str), MAGIC_KEY);
        } catch (Throwable th) {
            th.printStackTrace();
            L.debug("UuidManager", "readUUid throwable %s", th);
            return null;
        }
    }

    public static void saveSetting(Context context, String str) {
        if (ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                Settings.System.putString(context.getContentResolver(), SETTING_KEY, Coder.encryptDES(str, MAGIC_KEY));
            } catch (Throwable th) {
                L.debug("UuidManager", "saveSetting throwable %s", th);
            }
        }
    }

    public static void saveUUid(String str, String str2) {
        try {
            FileUtil.saveFile(str, Coder.encryptDES(str2, MAGIC_KEY));
        } catch (Throwable th) {
            L.debug("UuidManager", "saveUUid throwable %s", th);
        }
    }
}
