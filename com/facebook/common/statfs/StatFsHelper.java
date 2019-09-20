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
    private static StatFsHelper kds;
    private static final long kdt = TimeUnit.MINUTES.toMillis(2);
    private volatile File kdv;
    private volatile File kdx;
    @GuardedBy("lock")
    private long kdy;
    private volatile StatFs kdu = null;
    private volatile StatFs kdw = null;
    private volatile boolean mInitialized = false;
    private final Lock kdz = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cGh() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (kds == null) {
                kds = new StatFsHelper();
            }
            statFsHelper = kds;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.kdz.lock();
            try {
                if (!this.mInitialized) {
                    this.kdv = Environment.getDataDirectory();
                    this.kdx = Environment.getExternalStorageDirectory();
                    cGj();
                    this.mInitialized = true;
                }
            } finally {
                this.kdz.unlock();
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
        cGi();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.kdu : this.kdw;
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

    private void cGi() {
        if (this.kdz.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.kdy > kdt) {
                    cGj();
                }
            } finally {
                this.kdz.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cGj() {
        this.kdu = a(this.kdu, this.kdv);
        this.kdw = a(this.kdw, this.kdx);
        this.kdy = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Ik(file.getAbsolutePath());
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

    protected static StatFs Ik(String str) {
        return new StatFs(str);
    }
}
