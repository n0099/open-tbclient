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
    private static StatFsHelper hXv;
    private static final long hXw = TimeUnit.MINUTES.toMillis(2);
    private volatile File hXA;
    @GuardedBy("lock")
    private long hXB;
    private volatile File hXy;
    private volatile StatFs hXx = null;
    private volatile StatFs hXz = null;
    private volatile boolean hWr = false;
    private final Lock hXC = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bRW() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (hXv == null) {
                hXv = new StatFsHelper();
            }
            statFsHelper = hXv;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bRX() {
        if (!this.hWr) {
            this.hXC.lock();
            try {
                if (!this.hWr) {
                    this.hXy = Environment.getDataDirectory();
                    this.hXA = Environment.getExternalStorageDirectory();
                    bRZ();
                    this.hWr = true;
                }
            } finally {
                this.hXC.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        bRX();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        bRX();
        bRY();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.hXx : this.hXz;
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

    private void bRY() {
        if (this.hXC.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.hXB > hXw) {
                    bRZ();
                }
            } finally {
                this.hXC.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bRZ() {
        this.hXx = a(this.hXx, this.hXy);
        this.hXz = a(this.hXz, this.hXA);
        this.hXB = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = yy(file.getAbsolutePath());
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

    protected static StatFs yy(String str) {
        return new StatFs(str);
    }
}
