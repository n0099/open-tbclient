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
/* loaded from: classes14.dex */
public class StatFsHelper {
    private static StatFsHelper ppc;
    private static final long ppd = TimeUnit.MINUTES.toMillis(2);
    private volatile File ppf;
    private volatile File pph;
    @GuardedBy("lock")
    private long ppj;
    private volatile StatFs ppe = null;
    private volatile StatFs ppg = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes14.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper eqx() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (ppc == null) {
                ppc = new StatFsHelper();
            }
            statFsHelper = ppc;
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
                    this.ppf = Environment.getDataDirectory();
                    this.pph = Environment.getExternalStorageDirectory();
                    eqz();
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
        eqy();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.ppe : this.ppg;
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

    private void eqy() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.ppj > ppd) {
                    eqz();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void eqz() {
        this.ppe = a(this.ppe, this.ppf);
        this.ppg = a(this.ppg, this.pph);
        this.ppj = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Yl(file.getAbsolutePath());
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

    protected static StatFs Yl(String str) {
        return new StatFs(str);
    }
}
