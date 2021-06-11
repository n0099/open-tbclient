package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.fsg.face.base.b.c;
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
/* loaded from: classes7.dex */
public class SdkAnalyzeController {
    public static final String PACKAGE_NAME = "%PACKAGE_NAME%";
    public static final String PREF_KEY_SDK_ANALYZE_REPORT_DATE = "PREF_KEY_SDK_ANALYZE_REPORT_DATE";
    public IConfigAPI mConfigAPI;
    public IStatisAPI statisAPI;

    public SdkAnalyzeController(IStatisAPI iStatisAPI, IConfigAPI iConfigAPI) {
        this.statisAPI = iStatisAPI;
        this.mConfigAPI = iConfigAPI;
    }

    private String getSdkList(Context context, JSONArray jSONArray) {
        JSONObject jSONObject;
        String string;
        String string2;
        String string3;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                jSONObject = jSONArray.getJSONObject(i2);
                string = jSONObject.getString("sdkName");
                string2 = jSONObject.has("sdkFileName") ? jSONObject.getString("sdkFileName") : null;
                string3 = jSONObject.has("sdkClassName") ? jSONObject.getString("sdkClassName") : null;
            } catch (JSONException e2) {
                e = e2;
            }
            if (Util.empty(ArdUtil.getMetaDataParam(context, jSONObject.has("sdkConfigKey") ? jSONObject.getString("sdkConfigKey") : null)) && !Util.isExistClass(string3)) {
                try {
                } catch (JSONException e3) {
                    e = e3;
                    L.debug("SdkAnalyzeController", "getSdkList exception: %s", e);
                }
                if (!isExistFile(context, string2)) {
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
                if (!DefaultPreference.getPreference().getPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, "").equals(formatDate)) {
                    JSONObject sdkListConfig = SdkAnalyzeController.this.mConfigAPI.getSdkListConfig(context, true);
                    if (sdkListConfig != null) {
                        try {
                        } catch (JSONException e2) {
                            L.debug("SdkAnalyzeController", "get json.enable exception: %s", e2);
                        }
                        if (sdkListConfig.has(c.l)) {
                            if ("1".equals(sdkListConfig.get(c.l) + "")) {
                                z = true;
                                L.debug("SdkAnalyzeController", "sdkAnalyze enable is %b", Boolean.valueOf(z));
                                if (z) {
                                    JSONArray jSONArray = null;
                                    try {
                                        jSONArray = sdkListConfig.getJSONArray("sdkListConfig");
                                    } catch (JSONException e3) {
                                        L.debug("SdkAnalyzeController", "get json.sdkListConfig exception: %s", e3);
                                    }
                                    if (jSONArray != null && jSONArray.length() != 0) {
                                        SdkAnalyzeController.this.reportSdkList(context, j, jSONArray);
                                    } else {
                                        L.debug("SdkAnalyzeController", "get sdkListJsonArray is null!", new Object[0]);
                                    }
                                }
                                DefaultPreference.getPreference().setPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
                                return;
                            }
                        }
                    }
                    z = false;
                    L.debug("SdkAnalyzeController", "sdkAnalyze enable is %b", Boolean.valueOf(z));
                    if (z) {
                    }
                    DefaultPreference.getPreference().setPrefString(context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
                    return;
                }
                L.debug("SdkAnalyzeController", "sdk Analyze is reported today[%s]，so not report again!", formatDate);
            }
        }, 16000L);
    }

    public void reportSdkAnalyze(Context context, long j) {
        startSdkAnalyzeReport(context, j);
    }
}
