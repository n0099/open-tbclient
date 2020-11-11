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
/* loaded from: classes6.dex */
public class StatFsHelper {
    private static StatFsHelper oLD;
    private static final long oLE = TimeUnit.MINUTES.toMillis(2);
    private volatile File oLG;
    private volatile File oLI;
    @GuardedBy("lock")
    private long oLJ;
    private volatile StatFs oLF = null;
    private volatile StatFs oLH = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes6.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper eku() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (oLD == null) {
                oLD = new StatFsHelper();
            }
            statFsHelper = oLD;
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
                    this.oLG = Environment.getDataDirectory();
                    this.oLI = Environment.getExternalStorageDirectory();
                    ekw();
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
        ekv();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.oLF : this.oLH;
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

    private void ekv() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.oLJ > oLE) {
                    ekw();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void ekw() {
        this.oLF = a(this.oLF, this.oLG);
        this.oLH = a(this.oLH, this.oLI);
        this.oLJ = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Yc(file.getAbsolutePath());
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

    protected static StatFs Yc(String str) {
        return new StatFs(str);
    }
}
