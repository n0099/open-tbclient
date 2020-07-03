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
    private static StatFsHelper mJe;
    private static final long mJf = TimeUnit.MINUTES.toMillis(2);
    private volatile File mJh;
    private volatile File mJj;
    @GuardedBy("lock")
    private long mJk;
    private volatile StatFs mJg = null;
    private volatile StatFs mJi = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dzy() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (mJe == null) {
                mJe = new StatFsHelper();
            }
            statFsHelper = mJe;
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
                    this.mJh = Environment.getDataDirectory();
                    this.mJj = Environment.getExternalStorageDirectory();
                    dzA();
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
        dzz();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.mJg : this.mJi;
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

    private void dzz() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mJk > mJf) {
                    dzA();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dzA() {
        this.mJg = a(this.mJg, this.mJh);
        this.mJi = a(this.mJi, this.mJj);
        this.mJk = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = QF(file.getAbsolutePath());
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

    protected static StatFs QF(String str) {
        return new StatFs(str);
    }
}
