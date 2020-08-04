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
    private static StatFsHelper mRm;
    private static final long mRn = TimeUnit.MINUTES.toMillis(2);
    private volatile File mRp;
    private volatile File mRr;
    @GuardedBy("lock")
    private long mRs;
    private volatile StatFs mRo = null;
    private volatile StatFs mRq = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes12.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dCP() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (mRm == null) {
                mRm = new StatFsHelper();
            }
            statFsHelper = mRm;
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
                    this.mRp = Environment.getDataDirectory();
                    this.mRr = Environment.getExternalStorageDirectory();
                    dCR();
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
        dCQ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.mRo : this.mRq;
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

    private void dCQ() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mRs > mRn) {
                    dCR();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dCR() {
        this.mRo = a(this.mRo, this.mRp);
        this.mRq = a(this.mRq, this.mRr);
        this.mRs = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Rr(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.x(th);
        }
    }

    protected static StatFs Rr(String str) {
        return new StatFs(str);
    }
}
