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
/* loaded from: classes13.dex */
public class StatFsHelper {
    private static StatFsHelper lIL;
    private static final long lIM = TimeUnit.MINUTES.toMillis(2);
    private volatile File lIO;
    private volatile File lIQ;
    @GuardedBy("lock")
    private long lIR;
    private volatile StatFs lIN = null;
    private volatile StatFs lIP = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dkX() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (lIL == null) {
                lIL = new StatFsHelper();
            }
            statFsHelper = lIL;
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
                    this.lIO = Environment.getDataDirectory();
                    this.lIQ = Environment.getExternalStorageDirectory();
                    dkZ();
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
        dkY();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.lIN : this.lIP;
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

    private void dkY() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.lIR > lIM) {
                    dkZ();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dkZ() {
        this.lIN = a(this.lIN, this.lIO);
        this.lIP = a(this.lIP, this.lIQ);
        this.lIR = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = OT(file.getAbsolutePath());
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

    protected static StatFs OT(String str) {
        return new StatFs(str);
    }
}
