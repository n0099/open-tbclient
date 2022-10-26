package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class Representation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long REVISION_ID_DEFAULT = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String baseUrl;
    public final String contentId;
    public final Format format;
    public final List inbandEventStreams;
    public final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    /* renamed from: com.google.android.exoplayer2.source.dash.manifest.Representation$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract String getCacheKey();

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    /* loaded from: classes7.dex */
    public class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SegmentBase.MultiSegmentBase segmentBase;

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public String getCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (DashSegmentIndex) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public RangedUri getIndexUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (RangedUri) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiSegmentRepresentation(String str, long j, Format format, String str2, SegmentBase.MultiSegmentBase multiSegmentBase, List list) {
            super(str, j, format, str2, multiSegmentBase, list, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), format, str2, multiSegmentBase, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Long) objArr2[1]).longValue(), (Format) objArr2[2], (String) objArr2[3], (SegmentBase) objArr2[4], (List) objArr2[5], (AnonymousClass1) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.segmentBase = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
                return this.segmentBase.getSegmentDurationUs(i, j);
            }
            return invokeCommon.longValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentNum(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                return this.segmentBase.getSegmentNum(j, j2);
            }
            return invokeCommon.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getFirstSegmentNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.segmentBase.getFirstSegmentNum();
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.segmentBase.isExplicit();
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentCount(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                return this.segmentBase.getSegmentCount(j);
            }
            return invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public RangedUri getSegmentUrl(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return this.segmentBase.getSegmentUrl(this, i);
            }
            return (RangedUri) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                return this.segmentBase.getSegmentTimeUs(i);
            }
            return invokeI.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public class SingleSegmentRepresentation extends Representation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String cacheKey;
        public final long contentLength;
        public final RangedUri indexUri;
        public final SingleSegmentIndex segmentIndex;
        public final Uri uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(String str, long j, Format format, String str2, SegmentBase.SingleSegmentBase singleSegmentBase, List list, String str3, long j2) {
            super(str, j, format, str2, singleSegmentBase, list, null);
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {str, Long.valueOf(j), format, str2, singleSegmentBase, list, str3, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Long) objArr2[1]).longValue(), (Format) objArr2[2], (String) objArr2[3], (SegmentBase) objArr2[4], (List) objArr2[5], (AnonymousClass1) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uri = Uri.parse(str2);
            this.indexUri = singleSegmentBase.getIndex();
            if (str3 != null) {
                str4 = str3;
            } else if (str != null) {
                str4 = str + "." + format.id + "." + j;
            } else {
                str4 = null;
            }
            this.cacheKey = str4;
            this.contentLength = j2;
            this.segmentIndex = this.indexUri == null ? new SingleSegmentIndex(new RangedUri(null, 0L, j2)) : null;
        }

        public static SingleSegmentRepresentation newInstance(String str, long j, Format format, String str2, long j2, long j3, long j4, long j5, List list, String str3, long j6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), format, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), list, str3, Long.valueOf(j6)})) == null) {
                return new SingleSegmentRepresentation(str, j, format, str2, new SegmentBase.SingleSegmentBase(new RangedUri(null, j2, (j3 - j2) + 1), 1L, 0L, j4, (j5 - j4) + 1), list, str3, j6);
            }
            return (SingleSegmentRepresentation) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public String getCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.cacheKey;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.segmentIndex;
            }
            return (DashSegmentIndex) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public RangedUri getIndexUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.indexUri;
            }
            return (RangedUri) invokeV.objValue;
        }
    }

    public Representation(String str, long j, Format format, String str2, SegmentBase segmentBase, List list) {
        List unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), format, str2, segmentBase, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contentId = str;
        this.revisionId = j;
        this.format = format;
        this.baseUrl = str2;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.inbandEventStreams = unmodifiableList;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public /* synthetic */ Representation(String str, long j, Format format, String str2, SegmentBase segmentBase, List list, AnonymousClass1 anonymousClass1) {
        this(str, j, format, str2, segmentBase, list);
    }

    public static Representation newInstance(String str, long j, Format format, String str2, SegmentBase segmentBase) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), format, str2, segmentBase})) == null) {
            return newInstance(str, j, format, str2, segmentBase, null);
        }
        return (Representation) invokeCommon.objValue;
    }

    public static Representation newInstance(String str, long j, Format format, String str2, SegmentBase segmentBase, List list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Long.valueOf(j), format, str2, segmentBase, list})) == null) {
            return newInstance(str, j, format, str2, segmentBase, list, null);
        }
        return (Representation) invokeCommon.objValue;
    }

    public static Representation newInstance(String str, long j, Format format, String str2, SegmentBase segmentBase, List list, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j), format, str2, segmentBase, list, str3})) == null) {
            if (segmentBase instanceof SegmentBase.SingleSegmentBase) {
                return new SingleSegmentRepresentation(str, j, format, str2, (SegmentBase.SingleSegmentBase) segmentBase, list, str3, -1L);
            }
            if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
                return new MultiSegmentRepresentation(str, j, format, str2, (SegmentBase.MultiSegmentBase) segmentBase, list);
            }
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
        return (Representation) invokeCommon.objValue;
    }

    public RangedUri getInitializationUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.initializationUri;
        }
        return (RangedUri) invokeV.objValue;
    }
}
