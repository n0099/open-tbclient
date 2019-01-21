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
    private static StatFsHelper ikK;
    private static final long ikL = TimeUnit.MINUTES.toMillis(2);
    private volatile File ikN;
    private volatile File ikP;
    @GuardedBy("lock")
    private long ikQ;
    private volatile StatFs ikM = null;
    private volatile StatFs ikO = null;
    private volatile boolean ijG = false;
    private final Lock ikR = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bUV() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ikK == null) {
                ikK = new StatFsHelper();
            }
            statFsHelper = ikK;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bUW() {
        if (!this.ijG) {
            this.ikR.lock();
            try {
                if (!this.ijG) {
                    this.ikN = Environment.getDataDirectory();
                    this.ikP = Environment.getExternalStorageDirectory();
                    bUY();
                    this.ijG = true;
                }
            } finally {
                this.ikR.unlock();
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
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ikM : this.ikO;
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
        if (this.ikR.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.ikQ > ikL) {
                    bUY();
                }
            } finally {
                this.ikR.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bUY() {
        this.ikM = a(this.ikM, this.ikN);
        this.ikO = a(this.ikO, this.ikP);
        this.ikQ = SystemClock.uptimeMillis();
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
