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
    private static StatFsHelper pzM;
    private static final long pzN = TimeUnit.MINUTES.toMillis(2);
    private volatile File pzP;
    private volatile File pzR;
    @GuardedBy("lock")
    private long pzS;
    private volatile StatFs pzO = null;
    private volatile StatFs pzQ = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes6.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper esY() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (pzM == null) {
                pzM = new StatFsHelper();
            }
            statFsHelper = pzM;
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
                    this.pzP = Environment.getDataDirectory();
                    this.pzR = Environment.getExternalStorageDirectory();
                    eta();
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
        esZ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.pzO : this.pzQ;
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

    private void esZ() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.pzS > pzN) {
                    eta();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void eta() {
        this.pzO = a(this.pzO, this.pzP);
        this.pzQ = a(this.pzQ, this.pzR);
        this.pzS = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Zy(file.getAbsolutePath());
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

    protected static StatFs Zy(String str) {
        return new StatFs(str);
    }
}
