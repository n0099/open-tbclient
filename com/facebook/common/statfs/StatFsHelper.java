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
    private static StatFsHelper lIY;
    private static final long lIZ = TimeUnit.MINUTES.toMillis(2);
    private volatile File lJb;
    private volatile File lJd;
    @GuardedBy("lock")
    private long lJe;
    private volatile StatFs lJa = null;
    private volatile StatFs lJc = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dla() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lIY == null) {
                lIY = new StatFsHelper();
            }
            statFsHelper = lIY;
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
                    this.lJb = Environment.getDataDirectory();
                    this.lJd = Environment.getExternalStorageDirectory();
                    dlc();
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
        dlb();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lJa : this.lJc;
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

    private void dlb() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lJe > lIZ) {
                    dlc();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dlc() {
        this.lJa = a(this.lJa, this.lJb);
        this.lJc = a(this.lJc, this.lJd);
        this.lJe = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = OU(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.t(th);
        }
    }

    protected static StatFs OU(String str) {
        return new StatFs(str);
    }
}
