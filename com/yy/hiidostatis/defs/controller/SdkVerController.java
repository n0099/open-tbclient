package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SdkVerController {
    public static boolean mIsShowSdkUpdate;
    public IConfigAPI mConfigApi;

    public SdkVerController(IConfigAPI iConfigAPI) {
        this.mConfigApi = iConfigAPI;
    }

    public void startSdkVerCheck(final Context context) {
        if (!mIsShowSdkUpdate) {
            if (L.isLogOn()) {
                ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.SdkVerController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2;
                        try {
                            JSONObject sdkVer = SdkVerController.this.mConfigApi.getSdkVer(context, true);
                            if (sdkVer == null) {
                                return;
                            }
                            String str3 = "";
                            if (!sdkVer.has("isUpdate")) {
                                str = "";
                            } else {
                                str = sdkVer.getString("isUpdate");
                            }
                            if ("1".equals(str)) {
                                if (!sdkVer.has("ver")) {
                                    str2 = "";
                                } else {
                                    str2 = sdkVer.getString("ver");
                                }
                                if (sdkVer.has("changeLog")) {
                                    str3 = sdkVer.getString("changeLog");
                                }
                                if (!Util.empty(str2) && !Util.empty(str3)) {
                                    L.debug("SdkVerController", "统计SDK有新版本啦，欢迎使用新版本：V%s 。\n更新日志：\n%s", str2, str3);
                                }
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
}
