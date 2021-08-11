package com.facebook.cache.disk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mBaseDirectoryName;
    public final Supplier<File> mBaseDirectoryPathSupplier;
    public final CacheErrorLogger mCacheErrorLogger;
    @VisibleForTesting
    public volatile State mCurrentState;
    public final int mVersion;

    @VisibleForTesting
    /* loaded from: classes9.dex */
    public static class State {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final DiskStorage delegate;
        @Nullable
        public final File rootDirectory;

        @VisibleForTesting
        public State(@Nullable File file, @Nullable DiskStorage diskStorage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, diskStorage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(810244181, "Lcom/facebook/cache/disk/DynamicDefaultDiskStorage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(810244181, "Lcom/facebook/cache/disk/DynamicDefaultDiskStorage;");
                return;
            }
        }
        TAG = DynamicDefaultDiskStorage.class;
    }

    public DynamicDefaultDiskStorage(int i2, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), supplier, str, cacheErrorLogger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mVersion = i2;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
        this.mCurrentState = new State(null, null);
    }

    private void createStorage() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            File file = new File(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
            createRootDirectoryIfNecessary(file);
            this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
        }
    }

    private boolean shouldCreateNewStorage() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            State state = this.mCurrentState;
            return state.delegate == null || (file = state.rootDirectory) == null || !file.exists();
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            get().clearAll();
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) ? get().contains(str, obj) : invokeLL.booleanValue;
    }

    @VisibleForTesting
    public void createRootDirectoryIfNecessary(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
            try {
                FileUtils.mkdirs(file);
                FLog.d(TAG, "Created cache directory %s", file.getAbsolutePath());
            } catch (FileUtils.CreateDirectoryException e2) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", e2);
                throw e2;
            }
        }
    }

    @VisibleForTesting
    public void deleteOldStorageIfNecessary() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mCurrentState.delegate == null || this.mCurrentState.rootDirectory == null) {
            return;
        }
        FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }

    @VisibleForTesting
    public synchronized DiskStorage get() throws IOException {
        InterceptResult invokeV;
        DiskStorage diskStorage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (shouldCreateNewStorage()) {
                    deleteOldStorageIfNecessary();
                    createStorage();
                }
                diskStorage = (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);
            }
            return diskStorage;
        }
        return (DiskStorage) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? get().getDumpInfo() : (DiskStorage.DiskDumpInfo) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? get().getEntries() : (Collection) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String str, Object obj) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, obj)) == null) ? get().getResource(str, obj) : (BinaryResource) invokeLL.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return get().getStorageName();
            } catch (IOException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, obj)) == null) ? get().insert(str, obj) : (DiskStorage.Inserter) invokeLL.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return get().isEnabled();
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                return get().isExternal();
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                get().purgeUnexpectedResources();
            } catch (IOException e2) {
                FLog.e(TAG, "purgeUnexpectedResources", e2);
            }
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, entry)) == null) ? get().remove(entry) : invokeL.longValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, obj)) == null) ? get().touch(str, obj) : invokeLL.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? get().remove(str) : invokeL.longValue;
    }
}
