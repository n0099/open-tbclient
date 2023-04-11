package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.Packer;
/* loaded from: classes9.dex */
public class InstallController {
    public IStatisAPI statisAPI;

    public InstallController(IStatisAPI iStatisAPI) {
        this.statisAPI = iStatisAPI;
    }

    public void sendInstallationReportIfNotYet(final Context context) {
        InstUtil.InstInfo instInfo = InstUtil.getInstInfo(context);
        if (!instInfo.isReport) {
            this.statisAPI.reportInstall(instInfo.type, new Packer.OnSavedListener() { // from class: com.yy.hiidostatis.defs.controller.InstallController.1
                @Override // com.yy.hiidostatis.message.Packer.OnSavedListener
                public void onSaved(boolean z) {
                    L.debug("InstallController", "report Install %b", Boolean.valueOf(z));
                    if (z) {
                        InstUtil.save(context);
                    }
                }
            });
        }
    }

    /* loaded from: classes9.dex */
    public static class InstUtil {
        public static final String INVALID_VERSIONNAME = "";
        public static final int INVALID_VERSIONNO = -1;
        public static final Object KEY = InstUtil.class;
        public static final String PREF_KEY_VERSION_NAME = "PREF_KEY_VERSION_NAME";
        public static final String PREF_KEY_VERSION_NO = "PREF_KEY_VERSION_NO";
        public static final int TYPE_INSTALL = 1;
        public static final int TYPE_UPDATE = 0;
        public static InstInfo instInfo;

        /* loaded from: classes9.dex */
        public static class InstInfo {
            public boolean isReport;
            public int type;
        }

        public static InstInfo getInstInfo(Context context) {
            InstInfo instInfo2 = instInfo;
            if (instInfo2 != null) {
                return instInfo2;
            }
            synchronized (KEY) {
                if (instInfo != null) {
                    return instInfo;
                }
                InstInfo init = init(context);
                instInfo = init;
                return init;
            }
        }

        public static void save(Context context) {
            getInstInfo(context).isReport = true;
            int versionNo = ArdUtil.getVersionNo(context);
            String versionName = ArdUtil.getVersionName(context);
            DefaultPreference.getPreference().setPrefInt(context, PREF_KEY_VERSION_NO, versionNo);
            DefaultPreference.getPreference().setPrefString(context, PREF_KEY_VERSION_NAME, versionName);
        }

        public static InstInfo init(Context context) {
            boolean z;
            int i;
            InstInfo instInfo2 = new InstInfo();
            try {
                int prefInt = DefaultPreference.getPreference().getPrefInt(context, PREF_KEY_VERSION_NO, -1);
                String prefString = DefaultPreference.getPreference().getPrefString(context, PREF_KEY_VERSION_NAME, "");
                int versionNo = ArdUtil.getVersionNo(context);
                String versionName = ArdUtil.getVersionName(context);
                if (prefInt != -1 && !prefString.equals("") && prefInt == versionNo && prefString.equals(versionName)) {
                    z = true;
                } else {
                    z = false;
                }
                instInfo2.isReport = z;
                if (prefInt == -1 && prefString.equals("")) {
                    i = 1;
                } else {
                    i = 0;
                }
                instInfo2.type = i;
            } catch (Throwable th) {
                L.debug("InstallController", "init exception = %s", th);
            }
            return instInfo2;
        }
    }
}
