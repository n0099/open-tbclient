package com.facebook.imagepipeline.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DynamicValueConfig mDynamicValueConfig;

    /* renamed from: com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultDynamicValueConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int getGoodEnoughScanNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public List<Integer> getScansToDecode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Collections.EMPTY_LIST : (List) invokeV.objValue;
        }

        public /* synthetic */ DefaultDynamicValueConfig(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig(null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((DynamicValueConfig) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int getNextScanNumberToDecode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<Integer> scansToDecode = this.mDynamicValueConfig.getScansToDecode();
            if (scansToDecode == null || scansToDecode.isEmpty()) {
                return i2 + 1;
            }
            for (int i3 = 0; i3 < scansToDecode.size(); i3++) {
                if (scansToDecode.get(i3).intValue() > i2) {
                    return scansToDecode.get(i3).intValue();
                }
            }
            return Integer.MAX_VALUE;
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public QualityInfo getQualityInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            return ImmutableQualityInfo.of(i2, i2 >= this.mDynamicValueConfig.getGoodEnoughScanNumber(), false);
        }
        return (QualityInfo) invokeI.objValue;
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dynamicValueConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(dynamicValueConfig);
    }
}
