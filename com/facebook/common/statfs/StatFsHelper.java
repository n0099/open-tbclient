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
/* loaded from: classes12.dex */
public class StatFsHelper {
    private static StatFsHelper lHZ;
    private static final long lIa = TimeUnit.MINUTES.toMillis(2);
    private volatile File lIc;
    private volatile File lIe;
    @GuardedBy("lock")
    private long lIf;
    private volatile StatFs lIb = null;
    private volatile StatFs lId = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes12.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper djI() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lHZ == null) {
                lHZ = new StatFsHelper();
            }
            statFsHelper = lHZ;
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
                    this.lIc = Environment.getDataDirectory();
                    this.lIe = Environment.getExternalStorageDirectory();
                    djK();
                    this.mInitialized = true;
                }
            } finally {
                this.lock.unlock();
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
        djJ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lIb : this.lId;
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

    private void djJ() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lIf > lIa) {
                    djK();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void djK() {
        this.lIb = a(this.lIb, this.lIc);
        this.lId = a(this.lId, this.lIe);
        this.lIf = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = OG(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.u(th);
        }
    }

    protected static StatFs OG(String str) {
        return new StatFs(str);
    }
}
