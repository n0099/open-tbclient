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
    private static StatFsHelper jzR;
    private static final long jzS = TimeUnit.MINUTES.toMillis(2);
    private volatile File jzU;
    private volatile File jzW;
    @GuardedBy("lock")
    private long jzX;
    private volatile StatFs jzT = null;
    private volatile StatFs jzV = null;
    private volatile boolean mInitialized = false;
    private final Lock jzY = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper ctZ() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jzR == null) {
                jzR = new StatFsHelper();
            }
            statFsHelper = jzR;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void cua() {
        if (!this.mInitialized) {
            this.jzY.lock();
            try {
                if (!this.mInitialized) {
                    this.jzU = Environment.getDataDirectory();
                    this.jzW = Environment.getExternalStorageDirectory();
                    cuc();
                    this.mInitialized = true;
                }
            } finally {
                this.jzY.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        cua();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        cua();
        cub();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jzT : this.jzV;
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

    private void cub() {
        if (this.jzY.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jzX > jzS) {
                    cuc();
                }
            } finally {
                this.jzY.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cuc() {
        this.jzT = a(this.jzT, this.jzU);
        this.jzV = a(this.jzV, this.jzW);
        this.jzX = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Fs(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.s(th);
        }
    }

    protected static StatFs Fs(String str) {
        return new StatFs(str);
    }
}
