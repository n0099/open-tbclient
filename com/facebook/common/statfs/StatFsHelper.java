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
    private static StatFsHelper lKE;
    private static final long lKF = TimeUnit.MINUTES.toMillis(2);
    private volatile File lKH;
    private volatile File lKJ;
    @GuardedBy("lock")
    private long lKK;
    private volatile StatFs lKG = null;
    private volatile StatFs lKI = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dlx() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lKE == null) {
                lKE = new StatFsHelper();
            }
            statFsHelper = lKE;
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
                    this.lKH = Environment.getDataDirectory();
                    this.lKJ = Environment.getExternalStorageDirectory();
                    dlz();
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
        dly();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lKG : this.lKI;
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

    private void dly() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lKK > lKF) {
                    dlz();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dlz() {
        this.lKG = a(this.lKG, this.lKH);
        this.lKI = a(this.lKI, this.lKJ);
        this.lKK = SystemClock.uptimeMillis();
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
