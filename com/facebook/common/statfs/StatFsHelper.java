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
    private static StatFsHelper jSI;
    private static final long jSJ = TimeUnit.MINUTES.toMillis(2);
    private volatile File jSL;
    private volatile File jSN;
    @GuardedBy("lock")
    private long jSO;
    private volatile StatFs jSK = null;
    private volatile StatFs jSM = null;
    private volatile boolean mInitialized = false;
    private final Lock jSP = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cBY() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jSI == null) {
                jSI = new StatFsHelper();
            }
            statFsHelper = jSI;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.jSP.lock();
            try {
                if (!this.mInitialized) {
                    this.jSL = Environment.getDataDirectory();
                    this.jSN = Environment.getExternalStorageDirectory();
                    cCa();
                    this.mInitialized = true;
                }
            } finally {
                this.jSP.unlock();
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
        cBZ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jSK : this.jSM;
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

    private void cBZ() {
        if (this.jSP.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jSO > jSJ) {
                    cCa();
                }
            } finally {
                this.jSP.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cCa() {
        this.jSK = a(this.jSK, this.jSL);
        this.jSM = a(this.jSM, this.jSN);
        this.jSO = SystemClock.uptimeMillis();
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
