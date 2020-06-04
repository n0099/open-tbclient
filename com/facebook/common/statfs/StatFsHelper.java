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
    private static StatFsHelper mne;
    private static final long mnf = TimeUnit.MINUTES.toMillis(2);
    private volatile File mnh;
    private volatile File mnj;
    @GuardedBy("lock")
    private long mnk;
    private volatile StatFs mng = null;
    private volatile StatFs mni = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes13.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper duV() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (mne == null) {
                mne = new StatFsHelper();
            }
            statFsHelper = mne;
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
                    this.mnh = Environment.getDataDirectory();
                    this.mnj = Environment.getExternalStorageDirectory();
                    duX();
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
        duW();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.mng : this.mni;
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

    private void duW() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mnk > mnf) {
                    duX();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void duX() {
        this.mng = a(this.mng, this.mnh);
        this.mni = a(this.mni, this.mnj);
        this.mnk = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = PT(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.y(th);
        }
    }

    protected static StatFs PT(String str) {
        return new StatFs(str);
    }
}
