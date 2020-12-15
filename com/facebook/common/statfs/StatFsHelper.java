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
/* loaded from: classes19.dex */
public class StatFsHelper {
    private static StatFsHelper pcr;
    private static final long pcs = TimeUnit.MINUTES.toMillis(2);
    private volatile File pcu;
    private volatile File pcw;
    @GuardedBy("lock")
    private long pcx;
    private volatile StatFs pct = null;
    private volatile StatFs pcv = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes19.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper eqi() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (pcr == null) {
                pcr = new StatFsHelper();
            }
            statFsHelper = pcr;
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
                    this.pcu = Environment.getDataDirectory();
                    this.pcw = Environment.getExternalStorageDirectory();
                    eqk();
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
        eqj();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.pct : this.pcv;
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

    private void eqj() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.pcx > pcs) {
                    eqk();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void eqk() {
        this.pct = a(this.pct, this.pcu);
        this.pcv = a(this.pcv, this.pcw);
        this.pcx = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Zi(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.v(th);
        }
    }

    protected static StatFs Zi(String str) {
        return new StatFs(str);
    }
}
