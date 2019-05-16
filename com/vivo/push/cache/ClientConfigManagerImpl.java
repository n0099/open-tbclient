package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.m;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
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
        com.vivo.push.model.a b = this.mAppConfigSettings.b(this.mContext.getPackageName());
        if (b != null) {
            return "1".equals(b.b());
        }
        return true;
    }

    public void enablePush() {
        com.vivo.push.model.a b = this.mAppConfigSettings.b(this.mContext.getPackageName());
        if (b != null) {
            b.a("1");
            this.mAppConfigSettings.a(b);
            return;
        }
        this.mAppConfigSettings.a((a) new com.vivo.push.model.a(this.mContext.getPackageName(), "1"));
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public void disablePush() {
        com.vivo.push.model.a b = this.mAppConfigSettings.b(this.mContext.getPackageName());
        if (b != null) {
            b.a("0");
            this.mAppConfigSettings.a(b);
            return;
        }
        this.mAppConfigSettings.a((a) new com.vivo.push.model.a(this.mContext.getPackageName(), "0"));
    }

    @Override // com.vivo.push.cache.e
    public boolean isInBlackList(long j) {
        String[] split;
        String b = preparePushConfigSettings().b("BL");
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        for (String str : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isShowBigPic() {
        int i;
        String b;
        try {
            b = preparePushConfigSettings().b("SBP");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 1;
        }
        if (!TextUtils.isEmpty(b)) {
            try {
                i = Integer.parseInt(b);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return i != 1;
        }
        i = 1;
        if (i != 1) {
        }
    }

    public int getNotifyStyle() {
        try {
            String b = preparePushConfigSettings().b("DPL");
            if (TextUtils.isEmpty(b)) {
                return 0;
            }
            try {
                return Integer.parseInt(b);
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
        String b = preparePushConfigSettings().b("PSM");
        if (!TextUtils.isEmpty(b)) {
            try {
                parseInt = Integer.parseInt(b);
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
        return preparePushConfigSettings().b("CSPT");
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
        return this.mPushConfigSettings.b(str);
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
        m.d(TAG, " initWhiteLogList " + hashSet);
        return hashSet;
    }
}
