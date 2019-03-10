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
    private static StatFsHelper jAF;
    private static final long jAG = TimeUnit.MINUTES.toMillis(2);
    private volatile File jAI;
    private volatile File jAK;
    @GuardedBy("lock")
    private long jAL;
    private volatile StatFs jAH = null;
    private volatile StatFs jAJ = null;
    private volatile boolean mInitialized = false;
    private final Lock jAM = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper cud() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (jAF == null) {
                jAF = new StatFsHelper();
            }
            statFsHelper = jAF;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void cue() {
        if (!this.mInitialized) {
            this.jAM.lock();
            try {
                if (!this.mInitialized) {
                    this.jAI = Environment.getDataDirectory();
                    this.jAK = Environment.getExternalStorageDirectory();
                    cug();
                    this.mInitialized = true;
                }
            } finally {
                this.jAM.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        cue();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        cue();
        cuf();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.jAH : this.jAJ;
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

    private void cuf() {
        if (this.jAM.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.jAL > jAG) {
                    cug();
                }
            } finally {
                this.jAM.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void cug() {
        this.jAH = a(this.jAH, this.jAI);
        this.jAJ = a(this.jAJ, this.jAK);
        this.jAL = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = FE(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw k.s(th);
        }
    }

    protected static StatFs FE(String str) {
        return new StatFs(str);
    }
}
