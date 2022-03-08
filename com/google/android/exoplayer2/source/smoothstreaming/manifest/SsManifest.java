package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes7.dex */
public class SsManifest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UNSET_LOOKAHEAD = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    /* loaded from: classes7.dex */
    public static class ProtectionElement {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] data;
        public final UUID uuid;

        public ProtectionElement(UUID uuid, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uuid, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsManifest(int i2, int i3, long j2, long j3, long j4, int i4, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this(i2, i3, j3 == 0 ? -9223372036854775807L : Util.scaleLargeTimestamp(j3, 1000000L, j2), j4 != 0 ? Util.scaleLargeTimestamp(j4, 1000000L, j2) : C.TIME_UNSET, i4, z, protectionElement, streamElementArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), Boolean.valueOf(z), protectionElement, streamElementArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue(), (ProtectionElement) objArr2[6], (StreamElement[]) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final SsManifest copy(List<TrackKey> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            LinkedList linkedList = new LinkedList(list);
            Collections.sort(linkedList);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            StreamElement streamElement = null;
            int i2 = 0;
            while (i2 < linkedList.size()) {
                TrackKey trackKey = (TrackKey) linkedList.get(i2);
                StreamElement streamElement2 = this.streamElements[trackKey.streamElementIndex];
                if (streamElement2 != streamElement && streamElement != null) {
                    arrayList.add(streamElement.copy((Format[]) arrayList2.toArray(new Format[0])));
                    arrayList2.clear();
                }
                arrayList2.add(streamElement2.formats[trackKey.trackIndex]);
                i2++;
                streamElement = streamElement2;
            }
            if (streamElement != null) {
                arrayList.add(streamElement.copy((Format[]) arrayList2.toArray(new Format[0])));
            }
            return new SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (StreamElement[]) arrayList.toArray(new StreamElement[0]));
        }
        return (SsManifest) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static class StreamElement {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String URL_PLACEHOLDER_BITRATE_1 = "{bitrate}";
        public static final String URL_PLACEHOLDER_BITRATE_2 = "{Bitrate}";
        public static final String URL_PLACEHOLDER_START_TIME_1 = "{start time}";
        public static final String URL_PLACEHOLDER_START_TIME_2 = "{start_time}";
        public transient /* synthetic */ FieldHolder $fh;
        public final String baseUri;
        public final int chunkCount;
        public final List<Long> chunkStartTimes;
        public final long[] chunkStartTimesUs;
        public final String chunkTemplate;
        public final int displayHeight;
        public final int displayWidth;
        public final Format[] formats;
        public final String language;
        public final long lastChunkDurationUs;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, formatArr, list, Util.scaleLargeTimestamps(list, 1000000L, j2), Util.scaleLargeTimestamp(j3, 1000000L, j2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3], ((Long) objArr2[4]).longValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), ((Integer) objArr2[8]).intValue(), ((Integer) objArr2[9]).intValue(), (String) objArr2[10], (Format[]) objArr2[11], (List) objArr2[12], (long[]) objArr2[13], ((Long) objArr2[14]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Uri buildRequestUri(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                Assertions.checkState(this.formats != null);
                Assertions.checkState(this.chunkStartTimes != null);
                Assertions.checkState(i3 < this.chunkStartTimes.size());
                String num = Integer.toString(this.formats[i2].bitrate);
                String l = this.chunkStartTimes.get(i3).toString();
                return UriUtil.resolveToUri(this.baseUri, this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE_1, num).replace(URL_PLACEHOLDER_BITRATE_2, num).replace(URL_PLACEHOLDER_START_TIME_1, l).replace(URL_PLACEHOLDER_START_TIME_2, l));
            }
            return (Uri) invokeII.objValue;
        }

        public StreamElement copy(Format[] formatArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, formatArr)) == null) ? new StreamElement(this.baseUri, this.chunkTemplate, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.chunkStartTimes, this.chunkStartTimesUs, this.lastChunkDurationUs) : (StreamElement) invokeL.objValue;
        }

        public long getChunkDurationUs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 == this.chunkCount - 1) {
                    return this.lastChunkDurationUs;
                }
                long[] jArr = this.chunkStartTimesUs;
                return jArr[i2 + 1] - jArr[i2];
            }
            return invokeI.longValue;
        }

        public int getChunkIndex(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? Util.binarySearchFloor(this.chunkStartTimesUs, j2, true, true) : invokeJ.intValue;
        }

        public long getStartTimeUs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.chunkStartTimesUs[i2] : invokeI.longValue;
        }

        public StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, jArr, Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.baseUri = str;
            this.chunkTemplate = str2;
            this.type = i2;
            this.subType = str3;
            this.timescale = j2;
            this.name = str4;
            this.maxWidth = i3;
            this.maxHeight = i4;
            this.displayWidth = i5;
            this.displayHeight = i6;
            this.language = str5;
            this.formats = formatArr;
            this.chunkStartTimes = list;
            this.chunkStartTimesUs = jArr;
            this.lastChunkDurationUs = j3;
            this.chunkCount = list.size();
        }
    }

    public SsManifest(int i2, int i3, long j2, long j3, int i4, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Boolean.valueOf(z), protectionElement, streamElementArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.majorVersion = i2;
        this.minorVersion = i3;
        this.durationUs = j2;
        this.dvrWindowLengthUs = j3;
        this.lookAheadCount = i4;
        this.isLive = z;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
    }
}
