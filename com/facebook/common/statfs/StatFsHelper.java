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
    private static StatFsHelper hXu;
    private static final long hXv = TimeUnit.MINUTES.toMillis(2);
    @GuardedBy("lock")
    private long hXA;
    private volatile File hXx;
    private volatile File hXz;
    private volatile StatFs hXw = null;
    private volatile StatFs hXy = null;
    private volatile boolean hWq = false;
    private final Lock hXB = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bRW() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (hXu == null) {
                hXu = new StatFsHelper();
            }
            statFsHelper = hXu;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bRX() {
        if (!this.hWq) {
            this.hXB.lock();
            try {
                if (!this.hWq) {
                    this.hXx = Environment.getDataDirectory();
                    this.hXz = Environment.getExternalStorageDirectory();
                    bRZ();
                    this.hWq = true;
                }
            } finally {
                this.hXB.unlock();
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
        StatFs statFs = storageType == StorageType.INTERNAL ? this.hXw : this.hXy;
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
        if (this.hXB.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.hXA > hXv) {
                    bRZ();
                }
            } finally {
                this.hXB.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bRZ() {
        this.hXw = a(this.hXw, this.hXx);
        this.hXy = a(this.hXy, this.hXz);
        this.hXA = SystemClock.uptimeMillis();
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
