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
    private static StatFsHelper jSH;
    private static final long jSI = TimeUnit.MINUTES.toMillis(2);
    private volatile File jSK;
    private volatile File jSM;
    @GuardedBy("lock")
    private long jSN;
    private volatile StatFs jSJ = null;
    private volatile StatFs jSL = null;
    private volatile boolean mInitialized = false;
    private final Lock jSO = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cBW() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jSH == null) {
                jSH = new StatFsHelper();
            }
            statFsHelper = jSH;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.jSO.lock();
            try {
                if (!this.mInitialized) {
                    this.jSK = Environment.getDataDirectory();
                    this.jSM = Environment.getExternalStorageDirectory();
                    cBY();
                    this.mInitialized = true;
                }
            } finally {
                this.jSO.unlock();
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
        cBX();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jSJ : this.jSL;
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

    private void cBX() {
        if (this.jSO.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jSN > jSI) {
                    cBY();
                }
            } finally {
                this.jSO.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cBY() {
        this.jSJ = a(this.jSJ, this.jSK);
        this.jSL = a(this.jSL, this.jSM);
        this.jSN = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = GN(file.getAbsolutePath());
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

    protected static StatFs GN(String str) {
        return new StatFs(str);
    }
}
