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
    private static StatFsHelper lRY;
    private static final long lRZ = TimeUnit.MINUTES.toMillis(2);
    private volatile File lSb;
    private volatile File lSd;
    @GuardedBy("lock")
    private long lSe;
    private volatile StatFs lSa = null;
    private volatile StatFs lSc = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dnq() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lRY == null) {
                lRY = new StatFsHelper();
            }
            statFsHelper = lRY;
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
                    this.lSb = Environment.getDataDirectory();
                    this.lSd = Environment.getExternalStorageDirectory();
                    dnt();
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
        dnr();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lSa : this.lSc;
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

    private void dnr() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lSe > lRZ) {
                    dnt();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dnt() {
        this.lSa = a(this.lSa, this.lSb);
        this.lSc = a(this.lSc, this.lSd);
        this.lSe = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Ob(file.getAbsolutePath());
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

    protected static StatFs Ob(String str) {
        return new StatFs(str);
    }
}
