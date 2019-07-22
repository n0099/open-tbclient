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
    private static StatFsHelper jZP;
    private static final long jZQ = TimeUnit.MINUTES.toMillis(2);
    private volatile File jZS;
    private volatile File jZU;
    @GuardedBy("lock")
    private long jZV;
    private volatile StatFs jZR = null;
    private volatile StatFs jZT = null;
    private volatile boolean mInitialized = false;
    private final Lock jZW = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cEY() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jZP == null) {
                jZP = new StatFsHelper();
            }
            statFsHelper = jZP;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.jZW.lock();
            try {
                if (!this.mInitialized) {
                    this.jZS = Environment.getDataDirectory();
                    this.jZU = Environment.getExternalStorageDirectory();
                    cFa();
                    this.mInitialized = true;
                }
            } finally {
                this.jZW.unlock();
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
        cEZ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jZR : this.jZT;
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

    private void cEZ() {
        if (this.jZW.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jZV > jZQ) {
                    cFa();
                }
            } finally {
                this.jZW.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cFa() {
        this.jZR = a(this.jZR, this.jZS);
        this.jZT = a(this.jZT, this.jZU);
        this.jZV = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = HJ(file.getAbsolutePath());
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

    protected static StatFs HJ(String str) {
        return new StatFs(str);
    }
}
