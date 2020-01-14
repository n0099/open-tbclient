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
/* loaded from: classes12.dex */
public class StatFsHelper {
    private static StatFsHelper lIe;
    private static final long lIf = TimeUnit.MINUTES.toMillis(2);
    private volatile File lIh;
    private volatile File lIj;
    @GuardedBy("lock")
    private long lIk;
    private volatile StatFs lIg = null;
    private volatile StatFs lIi = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes12.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper djK() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lIe == null) {
                lIe = new StatFsHelper();
            }
            statFsHelper = lIe;
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
                    this.lIh = Environment.getDataDirectory();
                    this.lIj = Environment.getExternalStorageDirectory();
                    djM();
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
        djL();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lIg : this.lIi;
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

    private void djL() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lIk > lIf) {
                    djM();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void djM() {
        this.lIg = a(this.lIg, this.lIh);
        this.lIi = a(this.lIi, this.lIj);
        this.lIk = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = OG(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.u(th);
        }
    }

    protected static StatFs OG(String str) {
        return new StatFs(str);
    }
}
