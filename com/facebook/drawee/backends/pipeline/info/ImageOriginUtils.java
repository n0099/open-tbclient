package com.facebook.drawee.backends.pipeline.info;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
/* loaded from: classes4.dex */
public class ImageOriginUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageOriginUtils() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int mapProducerNameToImageOrigin(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            switch (str.hashCode()) {
                case -1914072202:
                    if (str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1683996557:
                    if (str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1579985851:
                    if (str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1307634203:
                    if (str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224383234:
                    if (str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 656304759:
                    if (str.equals("DiskCacheProducer")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 957714404:
                    if (str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1019542023:
                    if (str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1721672898:
                    if (str.equals(DataFetchProducer.PRODUCER_NAME)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1793127518:
                    if (str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 2113652014:
                    if (str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    return 5;
                case 2:
                    return 4;
                case 3:
                    return 3;
                case 4:
                    return 2;
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                    return 6;
                default:
                    return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String toString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown" : "local" : "memory_bitmap" : "memory_encoded" : "disk" : "network" : (String) invokeI.objValue;
    }
}
