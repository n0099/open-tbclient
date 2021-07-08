package com.facebook.cache.disk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class DiskCacheConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mBaseDirectoryName;
    public final Supplier<File> mBaseDirectoryPathSupplier;
    public final CacheErrorLogger mCacheErrorLogger;
    public final CacheEventListener mCacheEventListener;
    public final Context mContext;
    public final long mDefaultSizeLimit;
    public final DiskTrimmableRegistry mDiskTrimmableRegistry;
    public final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    public final boolean mIndexPopulateAtStartupEnabled;
    public final long mLowDiskSpaceSizeLimit;
    public final long mMinimumSizeLimit;
    public final int mVersion;

    /* renamed from: com.facebook.cache.disk.DiskCacheConfig$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mBaseDirectoryName;
        public Supplier<File> mBaseDirectoryPathSupplier;
        public CacheErrorLogger mCacheErrorLogger;
        public CacheEventListener mCacheEventListener;
        @Nullable
        public final Context mContext;
        public DiskTrimmableRegistry mDiskTrimmableRegistry;
        public EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
        public boolean mIndexPopulateAtStartupEnabled;
        public long mMaxCacheSize;
        public long mMaxCacheSizeOnLowDiskSpace;
        public long mMaxCacheSizeOnVeryLowDiskSpace;
        public int mVersion;

        public /* synthetic */ Builder(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        public DiskCacheConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Preconditions.checkState((this.mBaseDirectoryPathSupplier == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
                if (this.mBaseDirectoryPathSupplier == null && this.mContext != null) {
                    this.mBaseDirectoryPathSupplier = new Supplier<File>(this) { // from class: com.facebook.cache.disk.DiskCacheConfig.Builder.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Builder this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.facebook.common.internal.Supplier
                        public File get() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.mContext.getApplicationContext().getCacheDir() : (File) invokeV2.objValue;
                        }
                    };
                }
                return new DiskCacheConfig(this, null);
            }
            return (DiskCacheConfig) invokeV.objValue;
        }

        public Builder setBaseDirectoryName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mBaseDirectoryName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBaseDirectoryPath(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
                this.mBaseDirectoryPathSupplier = Suppliers.of(file);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBaseDirectoryPathSupplier(Supplier<File> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, supplier)) == null) {
                this.mBaseDirectoryPathSupplier = supplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCacheErrorLogger(CacheErrorLogger cacheErrorLogger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cacheErrorLogger)) == null) {
                this.mCacheErrorLogger = cacheErrorLogger;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCacheEventListener(CacheEventListener cacheEventListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cacheEventListener)) == null) {
                this.mCacheEventListener = cacheEventListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry diskTrimmableRegistry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, diskTrimmableRegistry)) == null) {
                this.mDiskTrimmableRegistry = diskTrimmableRegistry;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier entryEvictionComparatorSupplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, entryEvictionComparatorSupplier)) == null) {
                this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIndexPopulateAtStartupEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mIndexPopulateAtStartupEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMaxCacheSize(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                this.mMaxCacheSize = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setMaxCacheSizeOnLowDiskSpace(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                this.mMaxCacheSizeOnLowDiskSpace = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setMaxCacheSizeOnVeryLowDiskSpace(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
                this.mMaxCacheSizeOnVeryLowDiskSpace = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setVersion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.mVersion = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder(@Nullable Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVersion = 1;
            this.mBaseDirectoryName = "image_cache";
            this.mMaxCacheSize = 41943040L;
            this.mMaxCacheSizeOnLowDiskSpace = Config.FULL_TRACE_LOG_LIMIT;
            this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
            this.mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
            this.mContext = context;
        }
    }

    public /* synthetic */ DiskCacheConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder newBuilder(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Builder(context, null) : (Builder) invokeL.objValue;
    }

    public String getBaseDirectoryName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBaseDirectoryName : (String) invokeV.objValue;
    }

    public Supplier<File> getBaseDirectoryPathSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBaseDirectoryPathSupplier : (Supplier) invokeV.objValue;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCacheErrorLogger : (CacheErrorLogger) invokeV.objValue;
    }

    public CacheEventListener getCacheEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheEventListener : (CacheEventListener) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public long getDefaultSizeLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDefaultSizeLimit : invokeV.longValue;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDiskTrimmableRegistry : (DiskTrimmableRegistry) invokeV.objValue;
    }

    public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEntryEvictionComparatorSupplier : (EntryEvictionComparatorSupplier) invokeV.objValue;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIndexPopulateAtStartupEnabled : invokeV.booleanValue;
    }

    public long getLowDiskSpaceSizeLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLowDiskSpaceSizeLimit : invokeV.longValue;
    }

    public long getMinimumSizeLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMinimumSizeLimit : invokeV.longValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVersion : invokeV.intValue;
    }

    public DiskCacheConfig(Builder builder) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        DiskTrimmableRegistry diskTrimmableRegistry;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVersion = builder.mVersion;
        this.mBaseDirectoryName = (String) Preconditions.checkNotNull(builder.mBaseDirectoryName);
        this.mBaseDirectoryPathSupplier = (Supplier) Preconditions.checkNotNull(builder.mBaseDirectoryPathSupplier);
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        this.mEntryEvictionComparatorSupplier = (EntryEvictionComparatorSupplier) Preconditions.checkNotNull(builder.mEntryEvictionComparatorSupplier);
        if (builder.mCacheErrorLogger != null) {
            cacheErrorLogger = builder.mCacheErrorLogger;
        } else {
            cacheErrorLogger = NoOpCacheErrorLogger.getInstance();
        }
        this.mCacheErrorLogger = cacheErrorLogger;
        if (builder.mCacheEventListener != null) {
            cacheEventListener = builder.mCacheEventListener;
        } else {
            cacheEventListener = NoOpCacheEventListener.getInstance();
        }
        this.mCacheEventListener = cacheEventListener;
        if (builder.mDiskTrimmableRegistry != null) {
            diskTrimmableRegistry = builder.mDiskTrimmableRegistry;
        } else {
            diskTrimmableRegistry = NoOpDiskTrimmableRegistry.getInstance();
        }
        this.mDiskTrimmableRegistry = diskTrimmableRegistry;
        this.mContext = builder.mContext;
        this.mIndexPopulateAtStartupEnabled = builder.mIndexPopulateAtStartupEnabled;
    }
}
