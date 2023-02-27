package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class StatFsHelper {
    public static final long DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES = 1048576000;
    public static final long DEFAULT_DISK_RED_LEVEL_IN_BYTES = 104857600;
    public static final int DEFAULT_DISK_RED_LEVEL_IN_MB = 100;
    public static final long DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES = 419430400;
    public static final int DEFAULT_DISK_YELLOW_LEVEL_IN_MB = 400;
    public static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
    public static StatFsHelper sStatsFsHelper;
    public volatile File mExternalPath;
    public volatile File mInternalPath;
    @GuardedBy("lock")
    public long mLastRestatTime;
    @Nullable
    public volatile StatFs mInternalStatFs = null;
    @Nullable
    public volatile StatFs mExternalStatFs = null;
    public volatile boolean mInitialized = false;
    public final Lock lock = new ReentrantLock();

    /* loaded from: classes7.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.lock.lock();
            try {
                if (!this.mInitialized) {
                    this.mInternalPath = Environment.getDataDirectory();
                    this.mExternalPath = Environment.getExternalStorageDirectory();
                    updateStats();
                    this.mInitialized = true;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public static synchronized StatFsHelper getInstance() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (sStatsFsHelper == null) {
                sStatsFsHelper = new StatFsHelper();
            }
            statFsHelper = sStatsFsHelper;
        }
        return statFsHelper;
    }

    private void maybeUpdateStats() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS) {
                    updateStats();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void updateStats() {
        this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
        this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
        this.mLastRestatTime = SystemClock.uptimeMillis();
    }

    public boolean isHighSpaceCondition() {
        if (getAvailableStorageSpace(StorageType.INTERNAL) > DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES) {
            return true;
        }
        return false;
    }

    public boolean isLowSpaceCondition() {
        if (getAvailableStorageSpace(StorageType.INTERNAL) < DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES) {
            return true;
        }
        return false;
    }

    public boolean isVeryLowSpaceCondition() {
        if (getAvailableStorageSpace(StorageType.INTERNAL) < 104857600) {
            return true;
        }
        return false;
    }

    public void resetStats() {
        if (this.lock.tryLock()) {
            try {
                ensureInitialized();
                updateStats();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public static StatFs createStatFs(String str) {
        return new StatFs(str);
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getAvailableStorageSpace(StorageType storageType) {
        StatFs statFs;
        long blockSize;
        long availableBlocks;
        ensureInitialized();
        maybeUpdateStats();
        if (storageType == StorageType.INTERNAL) {
            statFs = this.mInternalStatFs;
        } else {
            statFs = this.mExternalStatFs;
        }
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        }
        return 0L;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getFreeStorageSpace(StorageType storageType) {
        StatFs statFs;
        long blockSize;
        long freeBlocks;
        ensureInitialized();
        maybeUpdateStats();
        if (storageType == StorageType.INTERNAL) {
            statFs = this.mInternalStatFs;
        } else {
            statFs = this.mExternalStatFs;
        }
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                freeBlocks = statFs.getFreeBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                freeBlocks = statFs.getFreeBlocks();
            }
            return blockSize * freeBlocks;
        }
        return -1L;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getTotalStorageSpace(StorageType storageType) {
        StatFs statFs;
        long blockSize;
        long blockCount;
        ensureInitialized();
        maybeUpdateStats();
        if (storageType == StorageType.INTERNAL) {
            statFs = this.mInternalStatFs;
        } else {
            statFs = this.mExternalStatFs;
        }
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        }
        return -1L;
    }

    @Nullable
    private StatFs updateStatsHelper(@Nullable StatFs statFs, @Nullable File file) {
        StatFs statFs2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = createStatFs(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            statFs2 = statFs;
            return statFs2;
        } catch (IllegalArgumentException unused) {
            return statFs2;
        } catch (Throwable th) {
            throw Throwables.propagate(th);
        }
    }

    public boolean testLowDiskSpace(StorageType storageType, long j) {
        ensureInitialized();
        long availableStorageSpace = getAvailableStorageSpace(storageType);
        if (availableStorageSpace <= 0 || availableStorageSpace < j) {
            return true;
        }
        return false;
    }
}
