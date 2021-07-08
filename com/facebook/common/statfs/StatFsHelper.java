package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class StatFsHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES = 419430400;
    public static final int DEFAULT_DISK_YELLOW_LEVEL_IN_MB = 400;
    public static final long RESTAT_INTERVAL_MS;
    public static StatFsHelper sStatsFsHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock lock;
    public volatile File mExternalPath;
    @Nullable
    public volatile StatFs mExternalStatFs;
    public volatile boolean mInitialized;
    public volatile File mInternalPath;
    @Nullable
    public volatile StatFs mInternalStatFs;
    @GuardedBy("lock")
    public long mLastRestatTime;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class StorageType {
        public static final /* synthetic */ StorageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StorageType EXTERNAL;
        public static final StorageType INTERNAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-37732414, "Lcom/facebook/common/statfs/StatFsHelper$StorageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-37732414, "Lcom/facebook/common/statfs/StatFsHelper$StorageType;");
                    return;
                }
            }
            INTERNAL = new StorageType("INTERNAL", 0);
            StorageType storageType = new StorageType("EXTERNAL", 1);
            EXTERNAL = storageType;
            $VALUES = new StorageType[]{INTERNAL, storageType};
        }

        public StorageType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static StorageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (StorageType) Enum.valueOf(StorageType.class, str) : (StorageType) invokeL.objValue;
        }

        public static StorageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (StorageType[]) $VALUES.clone() : (StorageType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1229243597, "Lcom/facebook/common/statfs/StatFsHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1229243597, "Lcom/facebook/common/statfs/StatFsHelper;");
                return;
            }
        }
        RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2L);
    }

    public StatFsHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInternalStatFs = null;
        this.mExternalStatFs = null;
        this.mInitialized = false;
        this.lock = new ReentrantLock();
    }

    public static StatFs createStatFs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new StatFs(str) : (StatFs) invokeL.objValue;
    }

    private void ensureInitialized() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mInitialized) {
            return;
        }
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

    public static synchronized StatFsHelper getInstance() {
        InterceptResult invokeV;
        StatFsHelper statFsHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (StatFsHelper.class) {
                if (sStatsFsHelper == null) {
                    sStatsFsHelper = new StatFsHelper();
                }
                statFsHelper = sStatsFsHelper;
            }
            return statFsHelper;
        }
        return (StatFsHelper) invokeV.objValue;
    }

    private void maybeUpdateStats() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.lock.tryLock()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
            this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
            this.mLastRestatTime = SystemClock.uptimeMillis();
        }
    }

    @Nullable
    private StatFs updateStatsHelper(@Nullable StatFs statFs, @Nullable File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, statFs, file)) == null) {
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
        return (StatFs) invokeLL.objValue;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getAvailableStorageSpace(StorageType storageType) {
        InterceptResult invokeL;
        long blockSize;
        long availableBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, storageType)) == null) {
            ensureInitialized();
            maybeUpdateStats();
            StatFs statFs = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
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
        return invokeL.longValue;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getFreeStorageSpace(StorageType storageType) {
        InterceptResult invokeL;
        long blockSize;
        long freeBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, storageType)) == null) {
            ensureInitialized();
            maybeUpdateStats();
            StatFs statFs = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
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
        return invokeL.longValue;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getTotalStorageSpace(StorageType storageType) {
        InterceptResult invokeL;
        long blockSize;
        long blockCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, storageType)) == null) {
            ensureInitialized();
            maybeUpdateStats();
            StatFs statFs = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
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
        return invokeL.longValue;
    }

    public void resetStats() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.lock.tryLock()) {
            try {
                ensureInitialized();
                updateStats();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean testLowDiskSpace(StorageType storageType, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, storageType, j)) == null) {
            ensureInitialized();
            long availableStorageSpace = getAvailableStorageSpace(storageType);
            return availableStorageSpace <= 0 || availableStorageSpace < j;
        }
        return invokeLJ.booleanValue;
    }
}
