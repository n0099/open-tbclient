package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.k;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class StatFsHelper {
    private static StatFsHelper jAx;
    private static final long jAy = TimeUnit.MINUTES.toMillis(2);
    private volatile File jAA;
    private volatile File jAC;
    @GuardedBy("lock")
    private long jAD;
    private volatile StatFs jAz = null;
    private volatile StatFs jAB = null;
    private volatile boolean mInitialized = false;
    private final Lock jAE = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cug() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jAx == null) {
                jAx = new StatFsHelper();
            }
            statFsHelper = jAx;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void cuh() {
        if (!this.mInitialized) {
            this.jAE.lock();
            try {
                if (!this.mInitialized) {
                    this.jAA = Environment.getDataDirectory();
                    this.jAC = Environment.getExternalStorageDirectory();
                    cuj();
                    this.mInitialized = true;
                }
            } finally {
                this.jAE.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        cuh();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        cuh();
        cui();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jAz : this.jAB;
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

    private void cui() {
        if (this.jAE.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jAD > jAy) {
                    cuj();
                }
            } finally {
                this.jAE.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cuj() {
        this.jAz = a(this.jAz, this.jAA);
        this.jAB = a(this.jAB, this.jAC);
        this.jAD = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = FC(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.s(th);
        }
    }

    protected static StatFs FC(String str) {
        return new StatFs(str);
    }
}
