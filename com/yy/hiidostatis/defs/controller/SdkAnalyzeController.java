package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SdkAnalyzeController {
    public static final String PACKAGE_NAME = "%PACKAGE_NAME%";
    public static final String PREF_KEY_SDK_ANALYZE_REPORT_DATE = "PREF_KEY_SDK_ANALYZE_REPORT_DATE";
    public IConfigAPI mConfigAPI;
    public IStatisAPI statisAPI;

    public SdkAnalyzeController(IStatisAPI iStatisAPI, IConfigAPI iConfigAPI) {
        this.statisAPI = iStatisAPI;
        this.mConfigAPI = iConfigAPI;
    }

    private void startSdkAnalyzeReport(final Context context, final long j) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.SdkAnalyzeController.1
            /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z;
                String formatDate = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
                if (DefaultPreference.getPreference().getPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, "").equals(formatDate)) {
                    L.debug("SdkAnalyzeController", "sdk Analyze is reported today[%s]，so not report again!", formatDate);
                    return;
                }
                JSONObject sdkListConfig = SdkAnalyzeController.this.mConfigAPI.getSdkListConfig(context, true);
                if (sdkListConfig != null) {
                    try {
                    } catch (JSONException e) {
                        L.debug("SdkAnalyzeController", "get json.enable exception: %s", e);
                    }
                    if (sdkListConfig.has("enable")) {
                        if ("1".equals(sdkListConfig.get("enable") + "")) {
                            z = true;
                            L.debug("SdkAnalyzeController", "sdkAnalyze enable is %b", Boolean.valueOf(z));
                            if (z) {
                                JSONArray jSONArray = null;
                                try {
                                    jSONArray = sdkListConfig.getJSONArray("sdkListConfig");
                                } catch (JSONException e2) {
                                    L.debug("SdkAnalyzeController", "get json.sdkListConfig exception: %s", e2);
                                }
                                if (jSONArray == null || jSONArray.length() == 0) {
                                    L.debug("SdkAnalyzeController", "get sdkListJsonArray is null!", new Object[0]);
                                } else {
                                    SdkAnalyzeController.this.reportSdkList(context, j, jSONArray);
                                }
                            }
                            DefaultPreference.getPreference().setPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
                        }
                    }
                }
                z = false;
                L.debug("SdkAnalyzeController", "sdkAnalyze enable is %b", Boolean.valueOf(z));
                if (z) {
                }
                DefaultPreference.getPreference().setPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
            }
        }, 16000L);
    }

    public void reportSdkAnalyze(Context context, long j) {
        startSdkAnalyzeReport(context, j);
    }

    private String getSdkList(Context context, JSONArray jSONArray) {
        String string;
        String str;
        String str2;
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                string = jSONObject.getString("sdkName");
                str = null;
                if (jSONObject.has("sdkFileName")) {
                    str2 = jSONObject.getString("sdkFileName");
                } else {
                    str2 = null;
                }
                if (jSONObject.has("sdkClassName")) {
                    str3 = jSONObject.getString("sdkClassName");
                } else {
                    str3 = null;
                }
                if (jSONObject.has("sdkConfigKey")) {
                    str = jSONObject.getString("sdkConfigKey");
                }
            } catch (JSONException e) {
                e = e;
            }
            if (Util.empty(ArdUtil.getMetaDataParam(context, str)) && !Util.isExistClass(str3)) {
                try {
                } catch (JSONException e2) {
                    e = e2;
                    L.debug("SdkAnalyzeController", "getSdkList exception: %s", e);
                }
                if (!isExistFile(context, str2)) {
                }
            }
            stringBuffer.append(string);
            stringBuffer.append("|");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        L.debug("SdkAnalyzeController", "sdklist length=%d,sdklist bypes length=%d", Integer.valueOf(stringBuffer.toString().length()), Integer.valueOf(stringBuffer.toString().getBytes().length));
        L.debug("SdkAnalyzeController", "sdklist=%s", stringBuffer.toString());
        return stringBuffer.toString();
    }

    private boolean isExistFile(Context context, String str) {
        if (context != null && !Util.empty(str)) {
            try {
                String replaceAll = str.replaceAll(PACKAGE_NAME, context.getPackageName());
                boolean exists = new File(replaceAll).exists();
                L.debug(this, "fileName:%s,newFileName:%s,isExist:%b", str, replaceAll, Boolean.valueOf(exists));
                return exists;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSdkList(Context context, long j, JSONArray jSONArray) {
        this.statisAPI.reportSdkList(j, getSdkList(context, jSONArray));
    }
}
