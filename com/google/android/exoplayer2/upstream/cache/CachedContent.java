package com.google.android.exoplayer2.upstream.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public final class CachedContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TreeSet<SimpleCacheSpan> cachedSpans;
    public final int id;
    public final String key;
    public long length;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedContent(DataInputStream dataInputStream) throws IOException {
        this(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readLong());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataInputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, simpleCacheSpan) == null) {
            this.cachedSpans.add(simpleCacheSpan);
        }
    }

    public long getCachedBytes(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            SimpleCacheSpan span = getSpan(j);
            if (span.isHoleSpan()) {
                return -Math.min(span.isOpenEnded() ? Long.MAX_VALUE : span.length, j2);
            }
            long j3 = j + j2;
            long j4 = span.position + span.length;
            if (j4 < j3) {
                for (SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                    long j5 = simpleCacheSpan.position;
                    if (j5 > j4) {
                        break;
                    }
                    j4 = Math.max(j4, j5 + simpleCacheSpan.length);
                    if (j4 >= j3) {
                        break;
                    }
                }
            }
            return Math.min(j4 - j, j2);
        }
        return invokeCommon.longValue;
    }

    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.length : invokeV.longValue;
    }

    public SimpleCacheSpan getSpan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
            SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
            if (floor == null || floor.position + floor.length <= j) {
                SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
                if (ceiling == null) {
                    return SimpleCacheSpan.createOpenHole(this.key, j);
                }
                return SimpleCacheSpan.createClosedHole(this.key, j, ceiling.position - j);
            }
            return floor;
        }
        return (SimpleCacheSpan) invokeJ.objValue;
    }

    public TreeSet<SimpleCacheSpan> getSpans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cachedSpans : (TreeSet) invokeV.objValue;
    }

    public int headerHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = this.length;
            return (((this.id * 31) + this.key.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cachedSpans.isEmpty() : invokeV.booleanValue;
    }

    public boolean removeSpan(CacheSpan cacheSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cacheSpan)) == null) {
            if (this.cachedSpans.remove(cacheSpan)) {
                cacheSpan.file.delete();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.length = j;
        }
    }

    public SimpleCacheSpan touch(SimpleCacheSpan simpleCacheSpan) throws Cache.CacheException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, simpleCacheSpan)) == null) {
            Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
            SimpleCacheSpan copyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id);
            if (simpleCacheSpan.file.renameTo(copyWithUpdatedLastAccessTime.file)) {
                this.cachedSpans.add(copyWithUpdatedLastAccessTime);
                return copyWithUpdatedLastAccessTime;
            }
            throw new Cache.CacheException("Renaming of " + simpleCacheSpan.file + " to " + copyWithUpdatedLastAccessTime.file + " failed.");
        }
        return (SimpleCacheSpan) invokeL.objValue;
    }

    public void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataOutputStream) == null) {
            dataOutputStream.writeInt(this.id);
            dataOutputStream.writeUTF(this.key);
            dataOutputStream.writeLong(this.length);
        }
    }

    public CachedContent(int i, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = i;
        this.key = str;
        this.length = j;
        this.cachedSpans = new TreeSet<>();
    }
}
