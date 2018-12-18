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
    private static StatFsHelper igs;
    private static final long igt = TimeUnit.MINUTES.toMillis(2);
    private volatile File igv;
    private volatile File igx;
    @GuardedBy("lock")
    private long igy;
    private volatile StatFs igu = null;
    private volatile StatFs igw = null;
    private volatile boolean ifo = false;
    private final Lock igz = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bTw() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (igs == null) {
                igs = new StatFsHelper();
            }
            statFsHelper = igs;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bTx() {
        if (!this.ifo) {
            this.igz.lock();
            try {
                if (!this.ifo) {
                    this.igv = Environment.getDataDirectory();
                    this.igx = Environment.getExternalStorageDirectory();
                    bTz();
                    this.ifo = true;
                }
            } finally {
                this.igz.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        bTx();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        bTx();
        bTy();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.igu : this.igw;
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

    private void bTy() {
        if (this.igz.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.igy > igt) {
                    bTz();
                }
            } finally {
                this.igz.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bTz() {
        this.igu = a(this.igu, this.igv);
        this.igw = a(this.igw, this.igx);
        this.igy = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = zg(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.r(th);
        }
    }

    protected static StatFs zg(String str) {
        return new StatFs(str);
    }
}
