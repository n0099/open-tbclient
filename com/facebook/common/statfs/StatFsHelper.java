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
/* loaded from: classes3.dex */
public class StatFsHelper {
    private static StatFsHelper ptx;
    private static final long pty = TimeUnit.MINUTES.toMillis(2);
    private volatile File ptA;
    private volatile File ptC;
    @GuardedBy("lock")
    private long ptD;
    private volatile StatFs ptz = null;
    private volatile StatFs ptB = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes3.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper euk() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ptx == null) {
                ptx = new StatFsHelper();
            }
            statFsHelper = ptx;
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
                    this.ptA = Environment.getDataDirectory();
                    this.ptC = Environment.getExternalStorageDirectory();
                    eum();
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
        eul();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ptz : this.ptB;
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

    private void eul() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.ptD > pty) {
                    eum();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void eum() {
        this.ptz = a(this.ptz, this.ptA);
        this.ptB = a(this.ptB, this.ptC);
        this.ptD = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Zt(file.getAbsolutePath());
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

    protected static StatFs Zt(String str) {
        return new StatFs(str);
    }
}
