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
    private static StatFsHelper kaK;
    private static final long kaL = TimeUnit.MINUTES.toMillis(2);
    private volatile File kaN;
    private volatile File kaP;
    @GuardedBy("lock")
    private long kaQ;
    private volatile StatFs kaM = null;
    private volatile StatFs kaO = null;
    private volatile boolean mInitialized = false;
    private final Lock kaR = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cDd() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (kaK == null) {
                kaK = new StatFsHelper();
            }
            statFsHelper = kaK;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.kaR.lock();
            try {
                if (!this.mInitialized) {
                    this.kaN = Environment.getDataDirectory();
                    this.kaP = Environment.getExternalStorageDirectory();
                    cDf();
                    this.mInitialized = true;
                }
            } finally {
                this.kaR.unlock();
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
        cDe();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.kaM : this.kaO;
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

    private void cDe() {
        if (this.kaR.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.kaQ > kaL) {
                    cDf();
                }
            } finally {
                this.kaR.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cDf() {
        this.kaM = a(this.kaM, this.kaN);
        this.kaO = a(this.kaO, this.kaP);
        this.kaQ = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = GB(file.getAbsolutePath());
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

    protected static StatFs GB(String str) {
        return new StatFs(str);
    }
}
