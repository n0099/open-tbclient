package com.yy.hiidostatis.inner;

import android.content.Context;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GeneralConfigTool {
    public static final String KEY_CODE = "code";
    public static final String KEY_CODE_STATUS_NOT_MODIFIED = "2";
    public static final String KEY_CODE_STATUS_SUCCESS = "1";
    public static final String KEY_DATA = "data";
    public static final String KEY_LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String KEY_MAGIC = "HiidoData";
    public static final String KEY_MSG = "msg";
    public static final String KEY_TIME = "time";
    public static final long MAX_CACHE_TIME = 86400000;
    public static final String PRFKEY_SRV_TM = "PRFKEY_SRV_TM";
    public static Preference preference = new Preference("hdcommon_config_cache_pref", true);
    public String URL_CONFIG_SERVER;
    public AbstractConfig mConfig;
    public Context mContext;

    public AbstractConfig getConfig() {
        return this.mConfig;
    }

    public String getSrvTime() {
        try {
            return DefaultPreference.getPreference().getPrefString(this.mContext, PRFKEY_SRV_TM, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public GeneralConfigTool(Context context, AbstractConfig abstractConfig) {
        this.mContext = context;
        this.mConfig = abstractConfig;
        this.URL_CONFIG_SERVER = abstractConfig.getUrlConfigServer();
    }

    private void addLastModifyTimeToParams(String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject;
        if (!Util.empty(str)) {
            if (new JSONObject(str).has(KEY_LAST_MODIFIED_TIME)) {
                String str2 = jSONObject.get(KEY_LAST_MODIFIED_TIME) + "";
                if (!Util.empty(str2)) {
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put(KEY_LAST_MODIFIED_TIME, str2);
                }
            }
        }
    }

    private String assblyCacheKey(String str, Map<String, String> map) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.URL_CONFIG_SERVER);
        if (str == null) {
            str = "";
        }
        stringBuffer.append(str);
        stringBuffer.append("?");
        if (map != null && map.size() > 0) {
            Iterator it = new TreeSet(map.keySet()).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                stringBuffer.append(str2);
                stringBuffer.append("=");
                stringBuffer.append(map.get(str2));
                stringBuffer.append("&");
            }
        }
        return Coder.encryptMD5(stringBuffer.toString());
    }

    private String assblyUrl(String str) {
        String str2 = this.URL_CONFIG_SERVER;
        if (str != null) {
            return str2 + str;
        }
        return str2;
    }

    public void setSrvTime(String str) {
        try {
            String srvTime = getSrvTime();
            if (srvTime == null || (str != null && Long.parseLong(str) > Long.parseLong(srvTime))) {
                DefaultPreference.getPreference().setPrefString(this.mContext, PRFKEY_SRV_TM, str);
            }
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    public void setmConfig(AbstractConfig abstractConfig) {
        this.mConfig = abstractConfig;
    }

    private String parseData(JSONObject jSONObject, boolean z) throws Exception {
        if ("1".equals(jSONObject.getString("code"))) {
            String string = jSONObject.getString("data");
            if (!Util.empty(string)) {
                if (z) {
                    String string2 = jSONObject.getString("time");
                    setSrvTime(string2);
                    String substring = Coder.encryptMD5(string2 + "HiidoData").toLowerCase().substring(0, 8);
                    L.verbose("GeneralConfigTool", "key is %s", substring);
                    L.verbose("GeneralConfigTool", "data before decrypt  is %s", string);
                    String decryptDES = Coder.decryptDES(string, substring);
                    L.verbose("GeneralConfigTool", "data after decrypt  is %s", decryptDES);
                    return decryptDES;
                }
                L.verbose("GeneralConfigTool", "data without decrypt  is %s", string);
                return string;
            }
            return string;
        }
        L.error("GeneralConfigTool", "http get fail! code is %s,msg is %s", jSONObject.getString("code"), jSONObject.getString("msg"));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:14:0x002a, B:16:0x003f, B:17:0x0046, B:19:0x004e, B:23:0x0071, B:20:0x005b, B:22:0x0063, B:13:0x0021), top: B:28:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:14:0x002a, B:16:0x003f, B:17:0x0046, B:19:0x004e, B:23:0x0071, B:20:0x005b, B:22:0x0063, B:13:0x0021), top: B:28:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:14:0x002a, B:16:0x003f, B:17:0x0046, B:19:0x004e, B:23:0x0071, B:20:0x005b, B:22:0x0063, B:13:0x0021), top: B:28:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String get(String str, Map<String, String> map, Context context, boolean z) {
        String str2;
        String str3;
        JSONObject jSONObject;
        String string;
        String assblyUrl = assblyUrl(str);
        try {
            str2 = assblyCacheKey(str, map);
            try {
                str3 = preference.getPrefString(context, str2, null);
                try {
                    addLastModifyTimeToParams(str3, map);
                } catch (Throwable th) {
                    th = th;
                    try {
                        L.debug("GeneralConfigTool", "get cache exception %s", th);
                        String str4 = HttpUtil.get(assblyUrl, map);
                        jSONObject = new JSONObject(str4);
                        string = jSONObject.getString("code");
                        if (jSONObject.has("time")) {
                        }
                        if (!"1".equals(string)) {
                        }
                        return parseData(jSONObject, z);
                    } catch (Throwable th2) {
                        L.error("GeneralConfigTool", "http get [%s] error! %s", assblyUrl, th2);
                        return null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                str3 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            str2 = null;
            str3 = null;
        }
        String str42 = HttpUtil.get(assblyUrl, map);
        jSONObject = new JSONObject(str42);
        string = jSONObject.getString("code");
        if (jSONObject.has("time")) {
            setSrvTime(jSONObject.getString("time"));
        }
        if (!"1".equals(string)) {
            L.verbose("GeneralConfigTool", "data is modified", new Object[0]);
            preference.setPrefString(context, str2, str42);
        } else if ("2".equals(string)) {
            L.verbose("GeneralConfigTool", "data is not modified,so get the cache data [%s]", str3);
            jSONObject = new JSONObject(str3);
        }
        return parseData(jSONObject, z);
    }

    public synchronized String getCache(String str, Map<String, String> map, Context context, boolean z) throws Exception {
        String prefString;
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis();
        String assblyCacheKey = assblyCacheKey(str, map);
        String str3 = "prefKeyTime_" + assblyCacheKey;
        String str4 = "prefKeyData_" + assblyCacheKey;
        long prefLong = preference.getPrefLong(context, str3, 0L);
        prefString = preference.getPrefString(context, str4, "");
        L.brief("prefKeyTime:%s", Long.valueOf(prefLong));
        L.brief("prefKeyData:%s", prefString);
        if (currentTimeMillis - prefLong <= 86400000) {
            L.verbose("GeneralConfigTool", "get cache success,result is %s", prefString);
            str2 = prefString;
        }
        if (Util.empty(str2)) {
            str2 = get(str, map, context, z);
            if (str2 != null) {
                L.debug("GeneralConfigTool", "get remote success,result is %s", str2);
                preference.setPrefLong(context, str3, currentTimeMillis);
                preference.setPrefString(context, str4, str2);
            } else {
                L.verbose("GeneralConfigTool", "get cache because get remote is null", str2);
            }
        }
        prefString = str2;
        return prefString;
    }
}
