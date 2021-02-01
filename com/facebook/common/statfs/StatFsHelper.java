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
/* loaded from: classes6.dex */
public class StatFsHelper {
    private static StatFsHelper pzm;
    private static final long pzn = TimeUnit.MINUTES.toMillis(2);
    private volatile File pzp;
    private volatile File pzr;
    @GuardedBy("lock")
    private long pzs;
    private volatile StatFs pzo = null;
    private volatile StatFs pzq = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes6.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper esQ() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (pzm == null) {
                pzm = new StatFsHelper();
            }
            statFsHelper = pzm;
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
                    this.pzp = Environment.getDataDirectory();
                    this.pzr = Environment.getExternalStorageDirectory();
                    esS();
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
        esR();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.pzo : this.pzq;
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

    private void esR() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.pzs > pzn) {
                    esS();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void esS() {
        this.pzo = a(this.pzo, this.pzp);
        this.pzq = a(this.pzq, this.pzr);
        this.pzs = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Zm(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.s(th);
        }
    }

    protected static StatFs Zm(String str) {
        return new StatFs(str);
    }
}
