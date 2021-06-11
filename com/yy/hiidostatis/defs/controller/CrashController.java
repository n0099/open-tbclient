package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.yy.hiidostatis.defs.handler.CrashHandler;
import com.yy.hiidostatis.defs.interf.IOnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.hdid.ClientIdProxy;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.hdid.UuidManager;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CrashController {
    public static final int EXPIRES_DAY = 5;
    public static final String PREF_NAME = "hd_crash_pref";
    public Context mContext;
    public CrashHandler mCrashHandler;
    public OnCrashListener mOnCrashListener;
    public IOnStatisListener mOnStatisListener;
    public IStatisAPI mStatisAPI;
    public Preference mPreference = new Preference(PREF_NAME);
    public boolean mIsSpecialDo = false;

    /* loaded from: classes7.dex */
    public interface OnCrashListener {
        void handler(JSONObject jSONObject);
    }

    public CrashController(Context context, IStatisAPI iStatisAPI, IOnStatisListener iOnStatisListener, OnCrashListener onCrashListener) {
        this.mContext = context;
        this.mStatisAPI = iStatisAPI;
        this.mOnStatisListener = iOnStatisListener;
        this.mOnCrashListener = onCrashListener;
    }

    private void clearInfo(String str) {
        try {
            this.mPreference.clearKey(this.mContext, str);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    private boolean delFile(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean doExpire(JSONObject jSONObject) {
        try {
            if (Util.daysBetween(Long.parseLong(jSONObject.getString("time")) * 1000, Util.wallTimeMillis()) > 5) {
                String string = jSONObject.getString("crashid");
                L.warn("CrashController", "del expires crash data: crashId = %s", string);
                clearInfo(string);
                delFile(jSONObject.getString("dpath"));
                delFile(jSONObject.getString("lpath"));
                return true;
            }
        } catch (Throwable th) {
            L.debug("CrashController", "deal expires error,%s", th);
        }
        return false;
    }

    private synchronized void doFlushCache() {
        if (!this.mIsSpecialDo && Build.VERSION.SDK_INT >= 21) {
            this.mIsSpecialDo = true;
            doSpecial();
        }
        Map<String, ?> all = getAll();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(all == null ? 0 : all.size());
        L.brief("all crash size = %d", objArr);
        if (all != null && all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                JSONObject jSONObject = new JSONObject((String) entry.getValue());
                L.brief("get crashid = %s", key);
                if (!doExpire(jSONObject)) {
                    if (!report(jSONObject)) {
                        break;
                    }
                    clearInfo(key);
                    delFile(jSONObject.getString("dpath"));
                    delFile(jSONObject.getString("lpath"));
                    L.brief("del crashid = %s", key);
                }
            }
        }
    }

    private boolean doReport(String str, Map<String, String> map, Map<String, String> map2, int i2) {
        HttpUtil.HttpResp postFileByUrlConn;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 >= i2) {
                break;
            }
            try {
                postFileByUrlConn = HttpUtil.postFileByUrlConn(str, map, map2);
            } catch (Throwable th) {
                Object[] objArr = new Object[2];
                objArr[z ? 1 : 0] = Integer.valueOf(i4);
                objArr[1] = th;
                L.debug(this, "doReport exception. tryTimes=%d exception=%s", objArr);
            }
            if (postFileByUrlConn.isSucceed) {
                Object[] objArr2 = new Object[2];
                objArr2[z ? 1 : 0] = Integer.valueOf(i4);
                objArr2[1] = Integer.valueOf(postFileByUrlConn.statusCode);
                L.debug(this, "doReport succeed.tryTimes:%d,statusCode:%d,", objArr2);
                z = postFileByUrlConn.isSucceed;
                break;
            }
            Object[] objArr3 = new Object[3];
            objArr3[z ? 1 : 0] = Integer.valueOf(i4);
            objArr3[1] = Integer.valueOf(postFileByUrlConn.statusCode);
            objArr3[2] = postFileByUrlConn.reason + "";
            L.warn(this, "doReport failed.tryTimes:%d,statusCode:%d,reason:%s", objArr3);
            i3 = i4;
        }
        return z;
    }

    private void doSpecial() {
        File[] listFiles;
        try {
            for (File file : new File(this.mCrashHandler.getDmpPath()).listFiles(new FilenameFilter() { // from class: com.yy.hiidostatis.defs.controller.CrashController.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return (str == null || str.startsWith("J-") || !str.endsWith(".dmp")) ? false : true;
                }
            })) {
                String absolutePath = file.getAbsolutePath();
                String replace = absolutePath.replace(".dmp", ".log");
                if (!FileUtil.isExist(replace)) {
                    String valueOf = String.valueOf(Util.millisToSec(file.lastModified()));
                    L.brief("timetime = %s", valueOf);
                    FileUtil.writeFile(replace, "");
                    saveInfo(fillInfo(2, valueOf, absolutePath, replace));
                }
            }
        } catch (Throwable th) {
            L.debug(this, "doSpecial exception.%s", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject fillInfo(int i2, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            try {
                str = String.valueOf(Util.wallTimeSec());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        jSONObject.put("act", "mbsdkhdcrash");
        jSONObject.put("time", str);
        jSONObject.put("key", CommonFiller.calKey("mbsdkhdcrash", str));
        jSONObject.put("lpath", str3);
        jSONObject.put("dpath", str2);
        jSONObject.put("crashid", parseCrashId(str2));
        jSONObject.put("ctyp", i2);
        jSONObject.put("uid", this.mOnStatisListener.getCurrentUid());
        jSONObject.put("app", this.mStatisAPI.getOption().getAppId());
        jSONObject.put("appkey", this.mStatisAPI.getOption().getAppkey());
        jSONObject.put("ver", this.mStatisAPI.getOption().getVer());
        jSONObject.put("from", this.mStatisAPI.getOption().getFrom());
        jSONObject.put(BaseStatisContent.SESSIONID, this.mStatisAPI.getSession());
        jSONObject.put(BaseStatisContent.SDKVER, HdStatisConfig.getConfig(this.mStatisAPI.getOption().getAppkey()).getSdkVer());
        jSONObject.put("imei", CommonFiller.getIMEI(this.mContext));
        jSONObject.put("mac", CommonFiller.getMacAddr(this.mContext));
        jSONObject.put(BaseStatisContent.SJP, ArdUtil.getSjp(this.mContext));
        jSONObject.put("sjm", ArdUtil.getSjm(this.mContext));
        jSONObject.put("sys", 2);
        jSONObject.put("mbos", ArdUtil.getOS());
        jSONObject.put(BaseStatisContent.MBL, ArdUtil.getLang());
        jSONObject.put(BaseStatisContent.NTM, ArdUtil.getNtm(this.mContext));
        jSONObject.put("net", ArdUtil.getNetworkTypeNew(this.mContext));
        jSONObject.put(BaseStatisContent.SR, ArdUtil.getScreenResolution(this.mContext));
        jSONObject.put("rot", ArdUtil.isRoot() ? 1 : 0);
        jSONObject.put("tram", ArdUtil.getTotalMemory(this.mContext));
        jSONObject.put("trom", ArdUtil.getTotalInternalStorgeSize());
        jSONObject.put("tsd", 0);
        jSONObject.put("aram", ArdUtil.getAvailMemory(this.mContext));
        jSONObject.put("arom", ArdUtil.getAvailInternalStorgeSize());
        jSONObject.put("asd", 0);
        jSONObject.put(BaseStatisContent.ARID, CommonFiller.getAndroidId(this.mContext));
        jSONObject.put(BaseStatisContent.OPID, ClientIdProxy.getClientId(this.mContext));
        jSONObject.put("hdid", DeviceProxy.getHdid(this.mContext));
        jSONObject.put(BaseStatisContent.IMC, ArdUtil.getImei(this.mContext) + "," + CommonFiller.getMacAddr(this.mContext));
        jSONObject.put(BaseStatisContent.IMSI, ArdUtil.getImsi(this.mContext));
        jSONObject.put(BaseStatisContent.IDFV, UuidManager.fetchUUid(this.mContext));
        jSONObject.put(BaseStatisContent.GUID, StringUtil.geneGuid());
        jSONObject.put("rtyp", 1);
        Long launchTime = this.mStatisAPI.getLaunchTime();
        if (launchTime != null) {
            jSONObject.put("ltime", (System.currentTimeMillis() - launchTime.longValue()) / 1000);
        }
        jSONObject.put("cpage", DefaultPreference.getPreference().getPrefString(this.mContext, HdStatisConfig.PREF_CPAGE, null));
        jSONObject.put("cpkg", ArdUtil.getPackageName(this.mContext));
        jSONObject.put("cthread", ProcessUtil.getCurProcessName(this.mContext) + "#" + Process.myTid());
        return jSONObject;
    }

    private Map<String, ?> getAll() {
        return this.mPreference.getAll(this.mContext);
    }

    private String parseCrashId(String str) {
        return new File(str).getName().replaceAll(".dmp", "");
    }

    private String parseJsonFilePath(String str) {
        return str.replaceAll(".dmp", ".json");
    }

    private String parseZipFilePath(String str) {
        return str.replaceAll(".dmp", ".zip");
    }

    private boolean report(JSONObject jSONObject) throws Exception {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInfo(JSONObject jSONObject) {
        try {
            this.mPreference.setPrefString(this.mContext, jSONObject.getString("crashid"), jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void flushCache() {
    }

    public void startCrashMonitor() {
        if (this.mCrashHandler != null) {
            L.warn(this, "crash monitor has been started.", new Object[0]);
            return;
        }
        CrashHandler crashHandler = new CrashHandler(this.mContext, this.mStatisAPI, this.mOnStatisListener, new CrashHandler.OnHandlerListener() { // from class: com.yy.hiidostatis.defs.controller.CrashController.1
            @Override // com.yy.hiidostatis.defs.handler.CrashHandler.OnHandlerListener
            public void handler(int i2, String str, String str2) {
                JSONObject fillInfo = CrashController.this.fillInfo(i2, null, str, str2);
                CrashController.this.saveInfo(fillInfo);
                CrashController.this.flushCache();
                if (CrashController.this.mOnCrashListener != null) {
                    CrashController.this.mOnCrashListener.handler(fillInfo);
                }
            }
        });
        this.mCrashHandler = crashHandler;
        crashHandler.init();
        flushCache();
        L.debug(this, "crash monitor start", new Object[0]);
    }
}
