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
    private static StatFsHelper jAm;
    private static final long jAn = TimeUnit.MINUTES.toMillis(2);
    private volatile File jAp;
    private volatile File jAr;
    @GuardedBy("lock")
    private long jAs;
    private volatile StatFs jAo = null;
    private volatile StatFs jAq = null;
    private volatile boolean mInitialized = false;
    private final Lock jAt = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper ctT() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jAm == null) {
                jAm = new StatFsHelper();
            }
            statFsHelper = jAm;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ctU() {
        if (!this.mInitialized) {
            this.jAt.lock();
            try {
                if (!this.mInitialized) {
                    this.jAp = Environment.getDataDirectory();
                    this.jAr = Environment.getExternalStorageDirectory();
                    ctW();
                    this.mInitialized = true;
                }
            } finally {
                this.jAt.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        ctU();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        ctU();
        ctV();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jAo : this.jAq;
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

    private void ctV() {
        if (this.jAt.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jAs > jAn) {
                    ctW();
                }
            } finally {
                this.jAt.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void ctW() {
        this.jAo = a(this.jAo, this.jAp);
        this.jAq = a(this.jAq, this.jAr);
        this.jAs = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = FB(file.getAbsolutePath());
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

    protected static StatFs FB(String str) {
        return new StatFs(str);
    }
}
