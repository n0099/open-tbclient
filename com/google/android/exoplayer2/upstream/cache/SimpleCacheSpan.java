package com.google.android.exoplayer2.upstream.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class SimpleCacheSpan extends CacheSpan {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern CACHE_FILE_PATTERN_V1;
    public static final Pattern CACHE_FILE_PATTERN_V2;
    public static final Pattern CACHE_FILE_PATTERN_V3;
    public static final String SUFFIX = ".v3.exo";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1722060284, "Lcom/google/android/exoplayer2/upstream/cache/SimpleCacheSpan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1722060284, "Lcom/google/android/exoplayer2/upstream/cache/SimpleCacheSpan;");
                return;
            }
        }
        CACHE_FILE_PATTERN_V1 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
        CACHE_FILE_PATTERN_V2 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
        CACHE_FILE_PATTERN_V3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleCacheSpan(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), (File) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static SimpleCacheSpan createCacheEntry(File file, CachedContentIndex cachedContentIndex) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, cachedContentIndex)) == null) {
            String name = file.getName();
            if (!name.endsWith(SUFFIX)) {
                file = upgradeFile(file, cachedContentIndex);
                if (file == null) {
                    return null;
                }
                name = file.getName();
            }
            File file2 = file;
            Matcher matcher = CACHE_FILE_PATTERN_V3.matcher(name);
            if (matcher.matches()) {
                long length = file2.length();
                String keyForId = cachedContentIndex.getKeyForId(Integer.parseInt(matcher.group(1)));
                if (keyForId == null) {
                    return null;
                }
                return new SimpleCacheSpan(keyForId, Long.parseLong(matcher.group(2)), length, Long.parseLong(matcher.group(3)), file2);
            }
            return null;
        }
        return (SimpleCacheSpan) invokeLL.objValue;
    }

    public static SimpleCacheSpan createClosedHole(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? new SimpleCacheSpan(str, j, j2, C.TIME_UNSET, null) : (SimpleCacheSpan) invokeCommon.objValue;
    }

    public static SimpleCacheSpan createLookup(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j)) == null) ? new SimpleCacheSpan(str, j, -1L, C.TIME_UNSET, null) : (SimpleCacheSpan) invokeLJ.objValue;
    }

    public static SimpleCacheSpan createOpenHole(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) ? new SimpleCacheSpan(str, j, -1L, C.TIME_UNSET, null) : (SimpleCacheSpan) invokeLJ.objValue;
    }

    public static File getCacheFile(File file, int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{file, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return new File(file, i + "." + j + "." + j2 + SUFFIX);
        }
        return (File) invokeCommon.objValue;
    }

    public static File upgradeFile(File file, CachedContentIndex cachedContentIndex) {
        InterceptResult invokeLL;
        String group;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, cachedContentIndex)) == null) {
            String name = file.getName();
            Matcher matcher = CACHE_FILE_PATTERN_V2.matcher(name);
            if (matcher.matches()) {
                group = Util.unescapeFileName(matcher.group(1));
                if (group == null) {
                    return null;
                }
            } else {
                matcher = CACHE_FILE_PATTERN_V1.matcher(name);
                if (!matcher.matches()) {
                    return null;
                }
                group = matcher.group(1);
            }
            File cacheFile = getCacheFile(file.getParentFile(), cachedContentIndex.assignIdForKey(group), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
            if (file.renameTo(cacheFile)) {
                return cacheFile;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public SimpleCacheSpan copyWithUpdatedLastAccessTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Assertions.checkState(this.isCached);
            long currentTimeMillis = System.currentTimeMillis();
            return new SimpleCacheSpan(this.key, this.position, this.length, currentTimeMillis, getCacheFile(this.file.getParentFile(), i, this.position, currentTimeMillis));
        }
        return (SimpleCacheSpan) invokeI.objValue;
    }
}
