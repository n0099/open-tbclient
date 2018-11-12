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
    private static StatFsHelper hZf;
    private static final long hZg = TimeUnit.MINUTES.toMillis(2);
    private volatile File hZi;
    private volatile File hZk;
    @GuardedBy("lock")
    private long hZl;
    private volatile StatFs hZh = null;
    private volatile StatFs hZj = null;
    private volatile boolean hYb = false;
    private final Lock hZm = new ReentrantLock();

    /* loaded from: classes2.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper bRr() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (hZf == null) {
                hZf = new StatFsHelper();
            }
            statFsHelper = hZf;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void bRs() {
        if (!this.hYb) {
            this.hZm.lock();
            try {
                if (!this.hYb) {
                    this.hZi = Environment.getDataDirectory();
                    this.hZk = Environment.getExternalStorageDirectory();
                    bRu();
                    this.hYb = true;
                }
            } finally {
                this.hZm.unlock();
            }
        }
    }

    public boolean a(StorageType storageType, long j) {
        bRs();
        long a = a(storageType);
        return a <= 0 || a < j;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long a(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        bRs();
        bRt();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.hZh : this.hZj;
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

    private void bRt() {
        if (this.hZm.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.hZl > hZg) {
                    bRu();
                }
            } finally {
                this.hZm.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void bRu() {
        this.hZh = a(this.hZh, this.hZi);
        this.hZj = a(this.hZj, this.hZk);
        this.hZl = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = yD(file.getAbsolutePath());
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

    protected static StatFs yD(String str) {
        return new StatFs(str);
    }
}
