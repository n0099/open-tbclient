package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class SdkAnalyzeController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PACKAGE_NAME = "%PACKAGE_NAME%";
    public static final String PREF_KEY_SDK_ANALYZE_REPORT_DATE = "PREF_KEY_SDK_ANALYZE_REPORT_DATE";
    public transient /* synthetic */ FieldHolder $fh;
    public IConfigAPI mConfigAPI;
    public IStatisAPI statisAPI;

    public SdkAnalyzeController(IStatisAPI iStatisAPI, IConfigAPI iConfigAPI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStatisAPI, iConfigAPI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.statisAPI = iStatisAPI;
        this.mConfigAPI = iConfigAPI;
    }

    private String getSdkList(Context context, JSONArray jSONArray) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        String string;
        String string2;
        String string3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, jSONArray)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject = jSONArray.getJSONObject(i);
                    string = jSONObject.getString("sdkName");
                    string2 = jSONObject.has("sdkFileName") ? jSONObject.getString("sdkFileName") : null;
                    string3 = jSONObject.has("sdkClassName") ? jSONObject.getString("sdkClassName") : null;
                } catch (JSONException e) {
                    e = e;
                }
                if (Util.empty(ArdUtil.getMetaDataParam(context, jSONObject.has("sdkConfigKey") ? jSONObject.getString("sdkConfigKey") : null)) && !Util.isExistClass(string3)) {
                    try {
                    } catch (JSONException e2) {
                        e = e2;
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
        return (String) invokeLL.objValue;
    }

    private boolean isExistFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSdkList(Context context, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Long.valueOf(j), jSONArray}) == null) {
            this.statisAPI.reportSdkList(j, getSdkList(context, jSONArray));
        }
    }

    private void startSdkAnalyzeReport(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65542, this, context, j) == null) {
            ThreadPool.getPool().execute(new Runnable(this, context, j) { // from class: com.yy.hiidostatis.defs.controller.SdkAnalyzeController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkAnalyzeController this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$uid = j;
                }

                /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String formatDate = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
                        if (!DefaultPreference.getPreference().getPrefString(this.val$context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, "").equals(formatDate)) {
                            JSONObject sdkListConfig = this.this$0.mConfigAPI.getSdkListConfig(this.val$context, true);
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
                                            if (jSONArray != null && jSONArray.length() != 0) {
                                                this.this$0.reportSdkList(this.val$context, this.val$uid, jSONArray);
                                            } else {
                                                L.debug("SdkAnalyzeController", "get sdkListJsonArray is null!", new Object[0]);
                                            }
                                        }
                                        DefaultPreference.getPreference().setPrefString(this.val$context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
                                        return;
                                    }
                                }
                            }
                            z = false;
                            L.debug("SdkAnalyzeController", "sdkAnalyze enable is %b", Boolean.valueOf(z));
                            if (z) {
                            }
                            DefaultPreference.getPreference().setPrefString(this.val$context, SdkAnalyzeController.PREF_KEY_SDK_ANALYZE_REPORT_DATE, formatDate);
                            return;
                        }
                        L.debug("SdkAnalyzeController", "sdk Analyze is reported today[%s]，so not report again!", formatDate);
                    }
                }
            }, 16000L);
        }
    }

    public void reportSdkAnalyze(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, context, j) == null) {
            startSdkAnalyzeReport(context, j);
        }
    }
}
