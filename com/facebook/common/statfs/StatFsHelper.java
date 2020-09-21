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
/* loaded from: classes17.dex */
public class StatFsHelper {
    private static StatFsHelper nvy;
    private static final long nvz = TimeUnit.MINUTES.toMillis(2);
    private volatile File nvB;
    private volatile File nvD;
    @GuardedBy("lock")
    private long nvE;
    private volatile StatFs nvA = null;
    private volatile StatFs nvC = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes17.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dSW() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (nvy == null) {
                nvy = new StatFsHelper();
            }
            statFsHelper = nvy;
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
                    this.nvB = Environment.getDataDirectory();
                    this.nvD = Environment.getExternalStorageDirectory();
                    dSY();
                    this.mInitialized = true;
                }
            } finally {
                this.lock.unlock();
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
        dSX();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.nvA : this.nvC;
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

    private void dSX() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.nvE > nvz) {
                    dSY();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dSY() {
        this.nvA = a(this.nvA, this.nvB);
        this.nvC = a(this.nvC, this.nvD);
        this.nvE = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = UX(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.v(th);
        }
    }

    protected static StatFs UX(String str) {
        return new StatFs(str);
    }
}
