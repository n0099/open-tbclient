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
/* loaded from: classes11.dex */
public class StatFsHelper {
    private static StatFsHelper lEB;
    private static final long lEC = TimeUnit.MINUTES.toMillis(2);
    private volatile File lEE;
    private volatile File lEG;
    @GuardedBy("lock")
    private long lEH;
    private volatile StatFs lED = null;
    private volatile StatFs lEF = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes11.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper diH() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lEB == null) {
                lEB = new StatFsHelper();
            }
            statFsHelper = lEB;
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
                    this.lEE = Environment.getDataDirectory();
                    this.lEG = Environment.getExternalStorageDirectory();
                    diJ();
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
        diI();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lED : this.lEF;
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

    private void diI() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lEH > lEC) {
                    diJ();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void diJ() {
        this.lED = a(this.lED, this.lEE);
        this.lEF = a(this.lEF, this.lEG);
        this.lEH = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Ow(file.getAbsolutePath());
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

    protected static StatFs Ow(String str) {
        return new StatFs(str);
    }
}
