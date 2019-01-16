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
    private static StatFsHelper ikJ;
    private static final long ikK = TimeUnit.MINUTES.toMillis(2);
    private volatile File ikM;
    private volatile File ikO;
    @GuardedBy("lock")
    private long ikP;
    private volatile StatFs ikL = null;
    private volatile StatFs ikN = null;
    private volatile boolean ijF = false;
    private final Lock ikQ = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bUV() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ikJ == null) {
                ikJ = new StatFsHelper();
            }
            statFsHelper = ikJ;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bUW() {
        if (!this.ijF) {
            this.ikQ.lock();
            try {
                if (!this.ijF) {
                    this.ikM = Environment.getDataDirectory();
                    this.ikO = Environment.getExternalStorageDirectory();
                    bUY();
                    this.ijF = true;
                }
            } finally {
                this.ikQ.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        bUW();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        bUW();
        bUX();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ikL : this.ikN;
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

    private void bUX() {
        if (this.ikQ.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.ikP > ikK) {
                    bUY();
                }
            } finally {
                this.ikQ.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bUY() {
        this.ikL = a(this.ikL, this.ikM);
        this.ikN = a(this.ikN, this.ikO);
        this.ikP = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = zz(file.getAbsolutePath());
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

    protected static StatFs zz(String str) {
        return new StatFs(str);
    }
}
