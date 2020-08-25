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
/* loaded from: classes9.dex */
public class StatFsHelper {
    private static StatFsHelper nlg;
    private static final long nlh = TimeUnit.MINUTES.toMillis(2);
    private volatile File nlj;
    private volatile File nll;
    @GuardedBy("lock")
    private long nlm;
    private volatile StatFs nli = null;
    private volatile StatFs nlk = null;
    private volatile boolean mInitialized = false;
    private final Lock lock = new ReentrantLock();

    /* loaded from: classes9.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper dOP() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (nlg == null) {
                nlg = new StatFsHelper();
            }
            statFsHelper = nlg;
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
                    this.nlj = Environment.getDataDirectory();
                    this.nll = Environment.getExternalStorageDirectory();
                    dOR();
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
        dOQ();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.nli : this.nlk;
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

    private void dOQ() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.nlm > nlh) {
                    dOR();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void dOR() {
        this.nli = a(this.nli, this.nlj);
        this.nlk = a(this.nlk, this.nll);
        this.nlm = SystemClock.uptimeMillis();
    }

    private StatFs a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = Uv(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            return statFs;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Throwable th) {
            throw l.v(th);
        }
    }

    protected static StatFs Uv(String str) {
        return new StatFs(str);
    }
}
