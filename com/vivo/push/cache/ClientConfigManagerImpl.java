package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class ClientConfigManagerImpl implements e {
    private static final Object SLOCK = new Object();
    private static final String TAG = "ClientConfigManager";
    private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    private a mAppConfigSettings;
    private Context mContext;
    private f mPushConfigSettings;

    private ClientConfigManagerImpl(Context context) {
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

    public boolean isEnablePush() {
        prepareAppConfig();
        com.vivo.push.model.a c = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c != null) {
            return "1".equals(c.b());
        }
        return true;
    }

    private void prepareAppConfig() {
        if (this.mAppConfigSettings == null) {
            this.mAppConfigSettings = new a(this.mContext);
        } else {
            this.mAppConfigSettings.c();
        }
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    @Override // com.vivo.push.cache.e
    public boolean isInBlackList(long j) {
        String[] split;
        String c = preparePushConfigSettings().c("BL");
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        for (String str : c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            try {
                if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j) {
                    return true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int getNotifyStyle() {
        try {
            String c = preparePushConfigSettings().c("DPL");
            if (TextUtils.isEmpty(c)) {
                return 0;
            }
            try {
                return Integer.parseInt(c);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCancleBroadcastReceiver() {
        int parseInt;
        String c = preparePushConfigSettings().c("PSM");
        if (!TextUtils.isEmpty(c)) {
            try {
                parseInt = Integer.parseInt(c);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return (parseInt & 4) == 0;
        }
        parseInt = 0;
        if ((parseInt & 4) == 0) {
        }
    }

    private f preparePushConfigSettings() {
        if (this.mPushConfigSettings == null) {
            this.mPushConfigSettings = new f(this.mContext);
        } else {
            this.mPushConfigSettings.c();
        }
        return this.mPushConfigSettings;
    }

    @Override // com.vivo.push.cache.e
    public String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return a.a(this.mAppConfigSettings.b());
    }

    public boolean isDebug(int i) {
        return a.a(i);
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
            String[] split = valueByKey.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str : split) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception e) {
                }
            }
        }
        p.d(TAG, " initWhiteLogList " + hashSet);
        return hashSet;
    }

    public Set<String> getBlackEventList() {
        return null;
    }
}
