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
    private static StatFsHelper kaV;
    private static final long kaW = TimeUnit.MINUTES.toMillis(2);
    private volatile File kaY;
    private volatile File kba;
    @GuardedBy("lock")
    private long kbb;
    private volatile StatFs kaX = null;
    private volatile StatFs kaZ = null;
    private volatile boolean mInitialized = false;
    private final Lock kbc = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cFt() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (kaV == null) {
                kaV = new StatFsHelper();
            }
            statFsHelper = kaV;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.kbc.lock();
            try {
                if (!this.mInitialized) {
                    this.kaY = Environment.getDataDirectory();
                    this.kba = Environment.getExternalStorageDirectory();
                    cFv();
                    this.mInitialized = true;
                }
            } finally {
                this.kbc.unlock();
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
        cFu();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.kaX : this.kaZ;
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

    private void cFu() {
        if (this.kbc.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.kbb > kaW) {
                    cFv();
                }
            } finally {
                this.kbc.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cFv() {
        this.kaX = a(this.kaX, this.kaY);
        this.kaZ = a(this.kaZ, this.kba);
        this.kbb = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = HK(file.getAbsolutePath());
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

    protected static StatFs HK(String str) {
        return new StatFs(str);
    }
}
