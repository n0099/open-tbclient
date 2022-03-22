package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class SlidingPercentile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Comparator<Sample> INDEX_COMPARATOR;
    public static final int MAX_RECYCLED_SAMPLES = 5;
    public static final int SORT_ORDER_BY_INDEX = 1;
    public static final int SORT_ORDER_BY_VALUE = 0;
    public static final int SORT_ORDER_NONE = -1;
    public static final Comparator<Sample> VALUE_COMPARATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentSortOrder;
    public final int maxWeight;
    public int nextSampleIndex;
    public int recycledSampleCount;
    public final Sample[] recycledSamples;
    public final ArrayList<Sample> samples;
    public int totalWeight;

    /* loaded from: classes6.dex */
    public static class Sample {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int index;
        public float value;
        public int weight;

        public Sample() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-944189953, "Lcom/google/android/exoplayer2/util/SlidingPercentile;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-944189953, "Lcom/google/android/exoplayer2/util/SlidingPercentile;");
                return;
            }
        }
        INDEX_COMPARATOR = new Comparator<Sample>() { // from class: com.google.android.exoplayer2.util.SlidingPercentile.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Sample sample, Sample sample2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, sample, sample2)) == null) ? sample.index - sample2.index : invokeLL.intValue;
            }
        };
        VALUE_COMPARATOR = new Comparator<Sample>() { // from class: com.google.android.exoplayer2.util.SlidingPercentile.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Sample sample, Sample sample2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, sample, sample2)) == null) {
                    float f2 = sample.value;
                    float f3 = sample2.value;
                    if (f2 < f3) {
                        return -1;
                    }
                    return f3 < f2 ? 1 : 0;
                }
                return invokeLL.intValue;
            }
        };
    }

    public SlidingPercentile(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxWeight = i;
        this.recycledSamples = new Sample[5];
        this.samples = new ArrayList<>();
        this.currentSortOrder = -1;
    }

    private void ensureSortedByIndex() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.currentSortOrder == 1) {
            return;
        }
        Collections.sort(this.samples, INDEX_COMPARATOR);
        this.currentSortOrder = 1;
    }

    private void ensureSortedByValue() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.currentSortOrder == 0) {
            return;
        }
        Collections.sort(this.samples, VALUE_COMPARATOR);
        this.currentSortOrder = 0;
    }

    public void addSample(int i, float f2) {
        Sample sample;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) != null) {
            return;
        }
        ensureSortedByIndex();
        int i2 = this.recycledSampleCount;
        if (i2 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i3 = i2 - 1;
            this.recycledSampleCount = i3;
            sample = sampleArr[i3];
        } else {
            sample = new Sample();
        }
        int i4 = this.nextSampleIndex;
        this.nextSampleIndex = i4 + 1;
        sample.index = i4;
        sample.weight = i;
        sample.value = f2;
        this.samples.add(sample);
        this.totalWeight += i;
        while (true) {
            int i5 = this.totalWeight;
            int i6 = this.maxWeight;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            Sample sample2 = this.samples.get(0);
            int i8 = sample2.weight;
            if (i8 <= i7) {
                this.totalWeight -= i8;
                this.samples.remove(0);
                int i9 = this.recycledSampleCount;
                if (i9 < 5) {
                    Sample[] sampleArr2 = this.recycledSamples;
                    this.recycledSampleCount = i9 + 1;
                    sampleArr2[i9] = sample2;
                }
            } else {
                sample2.weight = i8 - i7;
                this.totalWeight -= i7;
            }
        }
    }

    public float getPercentile(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            ensureSortedByValue();
            float f3 = f2 * this.totalWeight;
            int i = 0;
            for (int i2 = 0; i2 < this.samples.size(); i2++) {
                Sample sample = this.samples.get(i2);
                i += sample.weight;
                if (i >= f3) {
                    return sample.value;
                }
            }
            if (this.samples.isEmpty()) {
                return Float.NaN;
            }
            ArrayList<Sample> arrayList = this.samples;
            return arrayList.get(arrayList.size() - 1).value;
        }
        return invokeF.floatValue;
    }
}
