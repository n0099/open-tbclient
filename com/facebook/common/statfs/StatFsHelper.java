package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.l;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class StatFsHelper {
    private static StatFsHelper pBR;
    private static final long pBS = TimeUnit.MINUTES.toMillis(2);
    private volatile File pBU;
    private volatile File pBW;
    @GuardedBy("lock")
    private long pBX;
    private volatile StatFs pBT = null;
    private volatile StatFs pBV = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes4.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper eth() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (pBR == null) {
                pBR = new StatFsHelper();
            }
            statFsHelper = pBR;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.lock.lock();
            try {
                if (!this.mInitialized) {
                    this.pBU = Environment.getDataDirectory();
                    this.pBW = Environment.getExternalStorageDirectory();
                    etj();
                    this.mInitialized = true;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        ensureInitialized();
        long a2 = a(storageType);
        return a2 <= 0 || a2 < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        ensureInitialized();
        eti();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.pBT : this.pBV;
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

    private void eti() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.pBX > pBS) {
                    etj();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void etj() {
        this.pBT = a(this.pBT, this.pBU);
        this.pBV = a(this.pBV, this.pBW);
        this.pBX = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = ZE(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.s(th);
        }
    }

    protected static StatFs ZE(String str) {
        return new StatFs(str);
    }
}
