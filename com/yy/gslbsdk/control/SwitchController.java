package com.yy.gslbsdk.control;

import android.preference.PreferenceManager;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class SwitchController {
    public static final int HTTPS_LEVEL_CLOSE_SWITCH = -1;
    public static final int HTTPS_LEVEL_OPEN_SWITCH = 1;
    public static final String SHARED_KEY = "gslb_switch";
    public static final int SWITCH_CLOSE = -1;
    public static final int SWITCH_OPEN = 1;
    public static final int SWITCH_UNKNOWN = 0;
    public static final String TAG = "SwitchController";
    public static SwitchController sInstance;
    public AtomicInteger mSwitchCache = new AtomicInteger(0);
    public AtomicInteger mSwitchHttp = new AtomicInteger(0);
    public AtomicBoolean mInit = new AtomicBoolean(false);

    public static SwitchController getInstance() {
        if (sInstance == null) {
            sInstance = new SwitchController();
        }
        return sInstance;
    }

    private boolean init() {
        if (this.mInit.get()) {
            return true;
        }
        synchronized (this.mInit) {
            if (this.mInit.get()) {
                return true;
            }
            if (readCache()) {
                this.mInit.set(true);
                return true;
            }
            return false;
        }
    }

    private boolean readCache() {
        try {
            int i2 = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).getInt(SHARED_KEY, 1);
            if (i2 == 0 || i2 == 1 || i2 == -1) {
                this.mSwitchCache.compareAndSet(0, i2);
                return true;
            }
            LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController readCache, switchCache is illegal. switchCache: %d", Integer.valueOf(i2)));
            return false;
        } catch (Exception e2) {
            LogTools.printWarning(TAG, e2);
            return false;
        }
    }

    private boolean writeCache() {
        int i2 = this.mSwitchHttp.get();
        if (i2 != 0 && i2 != 1 && i2 != -1) {
            LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController writeCache, switchHttp is illegal. switchCache: %d", Integer.valueOf(i2)));
            return false;
        } else if (i2 == 0) {
            return false;
        } else {
            try {
                PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).edit().putInt(SHARED_KEY, i2).apply();
                return true;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return false;
            }
        }
    }

    public boolean deal(int i2) {
        if (i2 == -1) {
            this.mSwitchHttp.compareAndSet(0, -1);
        } else {
            this.mSwitchHttp.compareAndSet(0, 1);
        }
        return writeCache();
    }

    public boolean switchGslb() {
        if (init()) {
            int i2 = this.mSwitchHttp.get();
            int i3 = this.mSwitchCache.get();
            return i2 != 0 ? i2 == 1 : i3 == 0 || i3 == 1;
        }
        return true;
    }
}
