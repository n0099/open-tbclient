package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.p;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class ClientConfigManagerImpl implements e {
    public static final Object SLOCK = new Object();
    public static final String TAG = "ClientConfigManager";
    public static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    public a mAppConfigSettings;
    public Context mContext;
    public f mPushConfigSettings;

    public ClientConfigManagerImpl(Context context) {
        this.mContext = context.getApplicationContext();
        this.mAppConfigSettings = new a(this.mContext);
        this.mPushConfigSettings = new f(this.mContext);
    }

    public static ClientConfigManagerImpl getInstance(Context context) {
        if (sClientConfigManagerImpl == null) {
            synchronized (SLOCK) {
                if (sClientConfigManagerImpl == null) {
                    sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
                }
            }
        }
        return sClientConfigManagerImpl;
    }

    private void prepareAppConfig() {
        a aVar = this.mAppConfigSettings;
        if (aVar == null) {
            this.mAppConfigSettings = new a(this.mContext);
        } else {
            aVar.c();
        }
    }

    private f preparePushConfigSettings() {
        f fVar = this.mPushConfigSettings;
        if (fVar == null) {
            this.mPushConfigSettings = new f(this.mContext);
        } else {
            fVar.c();
        }
        return this.mPushConfigSettings;
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public Set<String> getBlackEventList() {
        return null;
    }

    public int getNotifyStyle() {
        try {
            String c2 = preparePushConfigSettings().c("DPL");
            if (!TextUtils.isEmpty(c2)) {
                try {
                    return Integer.parseInt(c2);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
        }
        return 0;
    }

    public String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public String getValueByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mPushConfigSettings.c();
        return this.mPushConfigSettings.c(str);
    }

    public Set<Long> getWhiteLogList() {
        HashSet hashSet = new HashSet();
        String valueByKey = getValueByKey("WLL");
        if (!TextUtils.isEmpty(valueByKey)) {
            for (String str : valueByKey.split(",")) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception unused) {
                }
            }
        }
        p.d(TAG, " initWhiteLogList " + hashSet);
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCancleBroadcastReceiver() {
        int parseInt;
        String c2 = preparePushConfigSettings().c("PSM");
        if (!TextUtils.isEmpty(c2)) {
            try {
                parseInt = Integer.parseInt(c2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return (parseInt & 4) == 0;
        }
        parseInt = 0;
        if ((parseInt & 4) == 0) {
        }
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return a.a(this.mAppConfigSettings.b());
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        com.vivo.push.model.a c2 = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c2 != null) {
            return "1".equals(c2.b());
        }
        return true;
    }

    @Override // com.vivo.push.cache.e
    public boolean isInBlackList(long j) {
        String[] split;
        String c2 = preparePushConfigSettings().c("BL");
        if (!TextUtils.isEmpty(c2)) {
            for (String str : c2.split(",")) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j) {
                        return true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isDebug(int i) {
        return a.a(i);
    }
}
