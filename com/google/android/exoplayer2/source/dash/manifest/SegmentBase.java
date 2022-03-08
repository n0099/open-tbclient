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
        public MultiSegmentBase(RangedUri rangedUri, long j2, long j3, int i2, long j4, List<SegmentTimelineElement> list) {
            super(rangedUri, j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {rangedUri, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startNumber = i2;
            this.duration = j4;
            this.segmentTimeline = list;
        }

        public int getFirstSegmentNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.startNumber : invokeV.intValue;
        }

        public abstract int getSegmentCount(long j2);

        public final long getSegmentDurationUs(int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    return (list.get(i2 - this.startNumber).duration * 1000000) / this.timescale;
                }
                int segmentCount = getSegmentCount(j2);
                return (segmentCount == -1 || i2 != (getFirstSegmentNum() + segmentCount) + (-1)) ? (this.duration * 1000000) / this.timescale : j2 - getSegmentTimeUs(i2);
            }
            return invokeCommon.longValue;
        }

        public int getSegmentNum(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                int firstSegmentNum = getFirstSegmentNum();
                int segmentCount = getSegmentCount(j3);
                if (segmentCount == 0) {
                    return firstSegmentNum;
                }
                if (this.segmentTimeline == null) {
                    int i2 = this.startNumber + ((int) (j2 / ((this.duration * 1000000) / this.timescale)));
                    return i2 < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? i2 : Math.min(i2, (firstSegmentNum + segmentCount) - 1);
                }
                int i3 = (segmentCount + firstSegmentNum) - 1;
                int i4 = firstSegmentNum;
                while (i4 <= i3) {
                    int i5 = ((i3 - i4) / 2) + i4;
                    int i6 = (getSegmentTimeUs(i5) > j2 ? 1 : (getSegmentTimeUs(i5) == j2 ? 0 : -1));
                    if (i6 < 0) {
                        i4 = i5 + 1;
                    } else if (i6 <= 0) {
                        return i5;
                    } else {
                        i3 = i5 - 1;
                    }
                }
                return i4 == firstSegmentNum ? i4 : i3;
            }
            return invokeCommon.intValue;
        }

        public final long getSegmentTimeUs(int i2) {
            InterceptResult invokeI;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    j2 = list.get(i2 - this.startNumber).startTime - this.presentationTimeOffset;
                } else {
                    j2 = (i2 - this.startNumber) * this.duration;
                }
                return Util.scaleLargeTimestamp(j2, 1000000L, this.timescale);
            }
            return invokeI.longValue;
        }

        public abstract RangedUri getSegmentUrl(Representation representation, int i2);

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
        public SegmentList(RangedUri rangedUri, long j2, long j3, int i2, long j4, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j2, j3, i2, j4, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {rangedUri, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        public int getSegmentCount(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.mediaSegments.size() : invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, representation, i2)) == null) ? this.mediaSegments.get(i2 - this.startNumber) : (RangedUri) invokeLI.objValue;
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
        public SegmentTemplate(RangedUri rangedUri, long j2, long j3, int i2, long j4, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, j2, j3, i2, j4, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {rangedUri, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, urlTemplate, urlTemplate2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        public int getSegmentCount(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    return list.size();
                }
                if (j2 != C.TIME_UNSET) {
                    return (int) Util.ceilDivide(j2, (this.duration * 1000000) / this.timescale);
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i2) {
            InterceptResult invokeLI;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, representation, i2)) == null) {
                List<SegmentTimelineElement> list = this.segmentTimeline;
                if (list != null) {
                    j2 = list.get(i2 - this.startNumber).startTime;
                } else {
                    j2 = (i2 - this.startNumber) * this.duration;
                }
                long j3 = j2;
                UrlTemplate urlTemplate = this.mediaTemplate;
                Format format = representation.format;
                return new RangedUri(urlTemplate.buildUri(format.id, i2, format.bitrate, j3), 0L, -1L);
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

        public SegmentTimelineElement(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startTime = j2;
            this.duration = j3;
        }
    }

    public SegmentBase(RangedUri rangedUri, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rangedUri, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initialization = rangedUri;
        this.timescale = j2;
        this.presentationTimeOffset = j3;
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
        public SingleSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
            super(rangedUri, j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {rangedUri, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RangedUri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.indexStart = j4;
            this.indexLength = j5;
        }

        public RangedUri getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.indexLength;
                if (j2 <= 0) {
                    return null;
                }
                return new RangedUri(null, this.indexStart, j2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
