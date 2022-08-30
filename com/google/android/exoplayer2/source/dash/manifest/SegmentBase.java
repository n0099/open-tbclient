package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class SegmentBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RangedUri initialization;
    public final long presentationTimeOffset;
    public final long timescale;

    /* loaded from: classes7.dex */
    public static abstract class MultiSegmentBase extends SegmentBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long duration;
        public final List<SegmentTimelineElement> segmentTimeline;
        public final int startNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {rangedUri, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startNumber = i;
            this.duration = j3;
            this.segmentTimeline = list;
        }

        public int getFirstSegmentNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.startNumber : invokeV.intValue;
        }

        public abstract int getSegmentCount(long j);

        public final long getSegmentDurationUs(int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    return (list.get(i - this.startNumber).duration * 1000000) / this.timescale;
                }
                int segmentCount = getSegmentCount(j);
                return (segmentCount == -1 || i != (getFirstSegmentNum() + segmentCount) + (-1)) ? (this.duration * 1000000) / this.timescale : j - getSegmentTimeUs(i);
            }
            return invokeCommon.longValue;
        }

        public int getSegmentNum(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                int firstSegmentNum = getFirstSegmentNum();
                int segmentCount = getSegmentCount(j2);
                if (segmentCount == 0) {
                    return firstSegmentNum;
                }
                if (this.segmentTimeline == null) {
                    int i = this.startNumber + ((int) (j / ((this.duration * 1000000) / this.timescale)));
                    return i < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? i : Math.min(i, (firstSegmentNum + segmentCount) - 1);
                }
                int i2 = (segmentCount + firstSegmentNum) - 1;
                int i3 = firstSegmentNum;
                while (i3 <= i2) {
                    int i4 = ((i2 - i3) / 2) + i3;
                    int i5 = (getSegmentTimeUs(i4) > j ? 1 : (getSegmentTimeUs(i4) == j ? 0 : -1));
                    if (i5 < 0) {
                        i3 = i4 + 1;
                    } else if (i5 <= 0) {
                        return i4;
                    } else {
                        i2 = i4 - 1;
                    }
                }
                return i3 == firstSegmentNum ? i3 : i2;
            }
            return invokeCommon.intValue;
        }

        public final long getSegmentTimeUs(int i) {
            InterceptResult invokeI;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    j = list.get(i - this.startNumber).startTime - this.presentationTimeOffset;
                } else {
                    j = (i - this.startNumber) * this.duration;
                }
                return Util.scaleLargeTimestamp(j, 1000000L, this.timescale);
            }
            return invokeI.longValue;
        }

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public boolean isExplicit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.segmentTimeline != null : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SegmentList extends MultiSegmentBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<RangedUri> mediaSegments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j, j2, i, j3, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {rangedUri, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (List) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mediaSegments = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.mediaSegments.size() : invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, representation, i)) == null) ? this.mediaSegments.get(i - this.startNumber) : (RangedUri) invokeLI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SegmentTemplate extends MultiSegmentBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final UrlTemplate initializationTemplate;
        public final UrlTemplate mediaTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, i, j3, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {rangedUri, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), list, urlTemplate, urlTemplate2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (List) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public RangedUri getInitialization(Representation representation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, representation)) == null) {
                UrlTemplate urlTemplate = this.initializationTemplate;
                if (urlTemplate != null) {
                    Format format = representation.format;
                    return new RangedUri(urlTemplate.buildUri(format.id, 0, format.bitrate, 0L), 0L, -1L);
                }
                return super.getInitialization(representation);
            }
            return (RangedUri) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    return list.size();
                }
                if (j != C.TIME_UNSET) {
                    return (int) Util.ceilDivide(j, (this.duration * 1000000) / this.timescale);
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            InterceptResult invokeLI;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, representation, i)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    j = list.get(i - this.startNumber).startTime;
                } else {
                    j = (i - this.startNumber) * this.duration;
                }
                long j2 = j;
                UrlTemplate urlTemplate = this.mediaTemplate;
                Format format = representation.format;
                return new RangedUri(urlTemplate.buildUri(format.id, i, format.bitrate, j2), 0L, -1L);
            }
            return (RangedUri) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SegmentTimelineElement {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long duration;
        public final long startTime;

        public SegmentTimelineElement(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startTime = j;
            this.duration = j2;
        }
    }

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rangedUri, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, representation)) == null) ? this.initialization : (RangedUri) invokeL.objValue;
    }

    public long getPresentationTimeOffsetUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000L, this.timescale) : invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public static class SingleSegmentBase extends SegmentBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long indexLength;
        public final long indexStart;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {rangedUri, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public RangedUri getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.indexLength;
                if (j <= 0) {
                    return null;
                }
                return new RangedUri(null, this.indexStart, j);
            }
            return (RangedUri) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((RangedUri) objArr[0], ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue(), ((Long) objArr[4]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
