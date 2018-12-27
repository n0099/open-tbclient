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
    private static StatFsHelper ijC;
    private static final long ijD = TimeUnit.MINUTES.toMillis(2);
    private volatile File ijF;
    private volatile File ijH;
    @GuardedBy("lock")
    private long ijI;
    private volatile StatFs ijE = null;
    private volatile StatFs ijG = null;
    private volatile boolean iiy = false;
    private final Lock ijJ = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bUn() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ijC == null) {
                ijC = new StatFsHelper();
            }
            statFsHelper = ijC;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bUo() {
        if (!this.iiy) {
            this.ijJ.lock();
            try {
                if (!this.iiy) {
                    this.ijF = Environment.getDataDirectory();
                    this.ijH = Environment.getExternalStorageDirectory();
                    bUq();
                    this.iiy = true;
                }
            } finally {
                this.ijJ.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        bUo();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        bUo();
        bUp();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ijE : this.ijG;
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

    private void bUp() {
        if (this.ijJ.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.ijI > ijD) {
                    bUq();
                }
            } finally {
                this.ijJ.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bUq() {
        this.ijE = a(this.ijE, this.ijF);
        this.ijG = a(this.ijG, this.ijH);
        this.ijI = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = zj(file.getAbsolutePath());
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

    protected static StatFs zj(String str) {
        return new StatFs(str);
    }
}
