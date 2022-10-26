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
/* loaded from: classes7.dex */
public final class CachedContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TreeSet cachedSpans;
    public final int id;
    public final String key;
    public long length;

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
        this.cachedSpans = new TreeSet();
    }

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

    public SimpleCacheSpan getSpan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) this.cachedSpans.floor(createLookup);
            if (simpleCacheSpan != null && simpleCacheSpan.position + simpleCacheSpan.length > j) {
                return simpleCacheSpan;
            }
            SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan) this.cachedSpans.ceiling(createLookup);
            if (simpleCacheSpan2 == null) {
                return SimpleCacheSpan.createOpenHole(this.key, j);
            }
            return SimpleCacheSpan.createClosedHole(this.key, j, simpleCacheSpan2.position - j);
        }
        return (SimpleCacheSpan) invokeJ.objValue;
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

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, simpleCacheSpan) == null) {
            this.cachedSpans.add(simpleCacheSpan);
        }
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

    public void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataOutputStream) == null) {
            dataOutputStream.writeInt(this.id);
            dataOutputStream.writeUTF(this.key);
            dataOutputStream.writeLong(this.length);
        }
    }

    public long getCachedBytes(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            SimpleCacheSpan span = getSpan(j);
            if (span.isHoleSpan()) {
                if (span.isOpenEnded()) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = span.length;
                }
                return -Math.min(j3, j2);
            }
            long j4 = j + j2;
            long j5 = span.position + span.length;
            if (j5 < j4) {
                for (SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                    long j6 = simpleCacheSpan.position;
                    if (j6 > j5) {
                        break;
                    }
                    j5 = Math.max(j5, j6 + simpleCacheSpan.length);
                    if (j5 >= j4) {
                        break;
                    }
                }
            }
            return Math.min(j5 - j, j2);
        }
        return invokeCommon.longValue;
    }

    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.length;
        }
        return invokeV.longValue;
    }

    public TreeSet getSpans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cachedSpans;
        }
        return (TreeSet) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.cachedSpans.isEmpty();
        }
        return invokeV.booleanValue;
    }
}
