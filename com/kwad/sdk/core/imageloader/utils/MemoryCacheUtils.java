package com.kwad.sdk.core.imageloader.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public final class MemoryCacheUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URI_AND_SIZE_SEPARATOR = "_";
    public static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";
    public transient /* synthetic */ FieldHolder $fh;

    public MemoryCacheUtils() {
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

    public static Comparator<String> createFuzzyKeyComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Comparator<String>() { // from class: com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_"))) : invokeLL.intValue;
            }
        } : (Comparator) invokeV.objValue;
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCache memoryCache) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, memoryCache)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : memoryCache.keys()) {
                if (str2.startsWith(str)) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<DecodedResult> findCachedBitmapsForImageUri(String str, MemoryCache memoryCache) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, memoryCache)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : memoryCache.keys()) {
                if (str2.startsWith(str)) {
                    arrayList.add(memoryCache.get(str2));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static String generateKey(String str, ImageSize imageSize) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, imageSize)) == null) {
            return str + "_" + imageSize.getWidth() + "x" + imageSize.getHeight();
        }
        return (String) invokeLL.objValue;
    }

    public static void removeFromCache(String str, MemoryCache memoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, memoryCache) == null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str2 : memoryCache.keys()) {
                if (str2.startsWith(str)) {
                    arrayList.add(str2);
                }
            }
            for (String str3 : arrayList) {
                memoryCache.remove(str3);
            }
        }
    }
}
