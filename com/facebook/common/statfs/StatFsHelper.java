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
    private static StatFsHelper oCk;
    private static final long oCl = TimeUnit.MINUTES.toMillis(2);
    private volatile File oCn;
    private volatile File oCp;
    @GuardedBy("lock")
    private long oCq;
    private volatile StatFs oCm = null;
    private volatile StatFs oCo = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes6.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper egF() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (oCk == null) {
                oCk = new StatFsHelper();
            }
            statFsHelper = oCk;
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
                    this.oCn = Environment.getDataDirectory();
                    this.oCp = Environment.getExternalStorageDirectory();
                    egH();
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
        egG();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.oCm : this.oCo;
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

    private void egG() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.oCq > oCl) {
                    egH();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void egH() {
        this.oCm = a(this.oCm, this.oCn);
        this.oCo = a(this.oCo, this.oCp);
        this.oCq = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Xy(file.getAbsolutePath());
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

    protected static StatFs Xy(String str) {
        return new StatFs(str);
    }
}
