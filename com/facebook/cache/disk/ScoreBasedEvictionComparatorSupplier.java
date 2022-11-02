package com.facebook.cache.disk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.internal.VisibleForTesting;
/* loaded from: classes7.dex */
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float mAgeWeight;
    public final float mSizeWeight;

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAgeWeight = f;
        this.mSizeWeight = f2;
    }

    @VisibleForTesting
    public float calculateScore(DiskStorage.Entry entry, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, entry, j)) == null) {
            return (this.mAgeWeight * ((float) (j - entry.getTimestamp()))) + (this.mSizeWeight * ((float) entry.getSize()));
        }
        return invokeLJ.floatValue;
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new EntryEvictionComparator(this) { // from class: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public long now;
                public final /* synthetic */ ScoreBasedEvictionComparatorSupplier this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.now = System.currentTimeMillis();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, entry, entry2)) == null) {
                        float calculateScore = this.this$0.calculateScore(entry, this.now);
                        float calculateScore2 = this.this$0.calculateScore(entry2, this.now);
                        if (calculateScore < calculateScore2) {
                            return 1;
                        }
                        if (calculateScore2 == calculateScore) {
                            return 0;
                        }
                        return -1;
                    }
                    return invokeLL.intValue;
                }
            };
        }
        return (EntryEvictionComparator) invokeV.objValue;
    }
}
