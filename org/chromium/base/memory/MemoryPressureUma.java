package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;
/* loaded from: classes2.dex */
public class MemoryPressureUma implements ComponentCallbacks2 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static MemoryPressureUma sInstance;
    public final String mHistogramName;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Notification {
        public static final int NUM_ENTRIES = 9;
        public static final int ON_LOW_MEMORY = 8;
        public static final int TRIM_MEMORY_BACKGROUND = 3;
        public static final int TRIM_MEMORY_COMPLETE = 1;
        public static final int TRIM_MEMORY_MODERATE = 2;
        public static final int TRIM_MEMORY_RUNNING_CRITICAL = 5;
        public static final int TRIM_MEMORY_RUNNING_LOW = 6;
        public static final int TRIM_MEMORY_RUNNING_MODERATE = 7;
        public static final int TRIM_MEMORY_UI_HIDDEN = 4;
        public static final int UNKNOWN_TRIM_LEVEL = 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public static void initializeForBrowser() {
        initializeInstance("Browser");
    }

    public static void initializeForChildService() {
        initializeInstance("ChildService");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        record(8);
    }

    public MemoryPressureUma(String str) {
        this.mHistogramName = "Android.MemoryPressureNotification." + str;
    }

    public static void initializeInstance(String str) {
        ThreadUtils.assertOnUiThread();
        sInstance = new MemoryPressureUma(str);
        ContextUtils.getApplicationContext().registerComponentCallbacks(sInstance);
    }

    private void record(int i) {
        RecordHistogram.recordEnumeratedHistogram(this.mHistogramName, i, 9);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i != 5) {
            if (i != 10) {
                if (i != 15) {
                    if (i != 20) {
                        if (i != 40) {
                            if (i != 60) {
                                if (i != 80) {
                                    record(0);
                                    return;
                                } else {
                                    record(1);
                                    return;
                                }
                            }
                            record(2);
                            return;
                        }
                        record(3);
                        return;
                    }
                    record(4);
                    return;
                }
                record(5);
                return;
            }
            record(6);
            return;
        }
        record(7);
    }
}
