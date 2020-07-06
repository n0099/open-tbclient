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
/* loaded from: classes13.dex */
public class StatFsHelper {
    private static StatFsHelper mJh;
    private static final long mJi = TimeUnit.MINUTES.toMillis(2);
    private volatile File mJk;
    private volatile File mJm;
    @GuardedBy("lock")
    private long mJn;
    private volatile StatFs mJj = null;
    private volatile StatFs mJl = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dzC() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (mJh == null) {
                mJh = new StatFsHelper();
            }
            statFsHelper = mJh;
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
                    this.mJk = Environment.getDataDirectory();
                    this.mJm = Environment.getExternalStorageDirectory();
                    dzE();
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
        dzD();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.mJj : this.mJl;
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

    private void dzD() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mJn > mJi) {
                    dzE();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dzE() {
        this.mJj = a(this.mJj, this.mJk);
        this.mJl = a(this.mJl, this.mJm);
        this.mJn = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = QG(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.y(th);
        }
    }

    protected static StatFs QG(String str) {
        return new StatFs(str);
    }
}
