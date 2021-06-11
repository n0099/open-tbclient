package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SdkVerController {
    public static boolean mIsShowSdkUpdate = false;
    public IConfigAPI mConfigApi;

    public SdkVerController(IConfigAPI iConfigAPI) {
        this.mConfigApi = iConfigAPI;
    }

    public void startSdkVerCheck(final Context context) {
        if (mIsShowSdkUpdate) {
            return;
        }
        if (L.isLogOn()) {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.SdkVerController.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject sdkVer = SdkVerController.this.mConfigApi.getSdkVer(context, true);
                        if (sdkVer == null) {
                            return;
                        }
                        if ("1".equals(sdkVer.has("isUpdate") ? sdkVer.getString("isUpdate") : "")) {
                            String string = sdkVer.has("ver") ? sdkVer.getString("ver") : "";
                            String string2 = sdkVer.has("changeLog") ? sdkVer.getString("changeLog") : "";
                            if (Util.empty(string) || Util.empty(string2)) {
                                return;
                            }
                            L.debug("SdkVerController", "统计SDK有新版本啦，欢迎使用新版本：V%s 。\n更新日志：\n%s", string, string2);
                        }
                    } catch (Throwable th) {
                        L.debug("SdkVerController", "get startSdkVerCheck exception: %s", th);
                    }
                }
            });
        }
        mIsShowSdkUpdate = true;
    }
}
