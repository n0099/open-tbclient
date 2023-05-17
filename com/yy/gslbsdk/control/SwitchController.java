package com.yy.gslbsdk.control;

import android.preference.PreferenceManager;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
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
            if (!readCache()) {
                return false;
            }
            this.mInit.set(true);
            return true;
        }
    }

    public boolean switchGslb() {
        if (!init()) {
            return true;
        }
        int i = this.mSwitchHttp.get();
        int i2 = this.mSwitchCache.get();
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            return false;
        } else if (i2 == 0 || i2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean readCache() {
        try {
            int i = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).getInt(SHARED_KEY, 1);
            if (i != 0 && i != 1 && i != -1) {
                LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController readCache, switchCache is illegal. switchCache: %d", Integer.valueOf(i)));
                return false;
            }
            this.mSwitchCache.compareAndSet(0, i);
            return true;
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
            return false;
        }
    }

    private boolean writeCache() {
        int i = this.mSwitchHttp.get();
        if (i != 0 && i != 1 && i != -1) {
            LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController writeCache, switchHttp is illegal. switchCache: %d", Integer.valueOf(i)));
            return false;
        } else if (i == 0) {
            return false;
        } else {
            try {
                PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).edit().putInt(SHARED_KEY, i).apply();
                return true;
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
                return false;
            }
        }
    }

    public boolean deal(int i) {
        if (i == -1) {
            this.mSwitchHttp.compareAndSet(0, -1);
        } else {
            this.mSwitchHttp.compareAndSet(0, 1);
        }
        return writeCache();
    }
}
