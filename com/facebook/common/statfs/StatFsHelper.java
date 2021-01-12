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
/* loaded from: classes14.dex */
public class StatFsHelper {
    private static StatFsHelper ppb;
    private static final long ppc = TimeUnit.MINUTES.toMillis(2);
    private volatile File ppe;
    private volatile File ppg;
    @GuardedBy("lock")
    private long pph;
    private volatile StatFs ppd = null;
    private volatile StatFs ppf = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes14.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper eqx() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ppb == null) {
                ppb = new StatFsHelper();
            }
            statFsHelper = ppb;
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
                    this.ppe = Environment.getDataDirectory();
                    this.ppg = Environment.getExternalStorageDirectory();
                    eqz();
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
        eqy();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ppd : this.ppf;
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

    private void eqy() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.pph > ppc) {
                    eqz();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void eqz() {
        this.ppd = a(this.ppd, this.ppe);
        this.ppf = a(this.ppf, this.ppg);
        this.pph = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Yk(file.getAbsolutePath());
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

    protected static StatFs Yk(String str) {
        return new StatFs(str);
    }
}
