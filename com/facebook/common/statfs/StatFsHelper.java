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
    private static StatFsHelper kbB;
    private static final long kbC = TimeUnit.MINUTES.toMillis(2);
    private volatile File kbE;
    private volatile File kbG;
    @GuardedBy("lock")
    private long kbH;
    private volatile StatFs kbD = null;
    private volatile StatFs kbF = null;
    private volatile boolean mInitialized = false;
    private final Lock kbI = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cDf() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (kbB == null) {
                kbB = new StatFsHelper();
            }
            statFsHelper = kbB;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.kbI.lock();
            try {
                if (!this.mInitialized) {
                    this.kbE = Environment.getDataDirectory();
                    this.kbG = Environment.getExternalStorageDirectory();
                    cDh();
                    this.mInitialized = true;
                }
            } finally {
                this.kbI.unlock();
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
        cDg();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.kbD : this.kbF;
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

    private void cDg() {
        if (this.kbI.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.kbH > kbC) {
                    cDh();
                }
            } finally {
                this.kbI.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cDh() {
        this.kbD = a(this.kbD, this.kbE);
        this.kbF = a(this.kbF, this.kbG);
        this.kbH = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = GB(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.q(th);
        }
    }

    protected static StatFs GB(String str) {
        return new StatFs(str);
    }
}
