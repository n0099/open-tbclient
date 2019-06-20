package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.k;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class StatFsHelper {
    private static StatFsHelper jSL;
    private static final long jSM = TimeUnit.MINUTES.toMillis(2);
    private volatile File jSO;
    private volatile File jSQ;
    @GuardedBy("lock")
    private long jSR;
    private volatile StatFs jSN = null;
    private volatile StatFs jSP = null;
    private volatile boolean mInitialized = false;
    private final Lock jSS = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cBX() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jSL == null) {
                jSL = new StatFsHelper();
            }
            statFsHelper = jSL;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.jSS.lock();
            try {
                if (!this.mInitialized) {
                    this.jSO = Environment.getDataDirectory();
                    this.jSQ = Environment.getExternalStorageDirectory();
                    cBZ();
                    this.mInitialized = true;
                }
            } finally {
                this.jSS.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        ensureInitialized();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        ensureInitialized();
        cBY();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jSN : this.jSP;
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return availableBlocks * blockSize;
        }
        return 0L;
    }

    private void cBY() {
        if (this.jSS.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jSR > jSM) {
                    cBZ();
                }
            } finally {
                this.jSS.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cBZ() {
        this.jSN = a(this.jSN, this.jSO);
        this.jSP = a(this.jSP, this.jSQ);
        this.jSR = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = GP(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.r(th);
        }
    }

    protected static StatFs GP(String str) {
        return new StatFs(str);
    }
}
