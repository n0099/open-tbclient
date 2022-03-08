package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class DashManifest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long availabilityStartTime;
    public final long duration;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTime;
    public final long minUpdatePeriod;
    public final List<Period> periods;
    public final long suggestedPresentationDelay;
    public final long timeShiftBufferDepth;
    public final UtcTimingElement utcTiming;

    public DashManifest(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), utcTimingElement, uri, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.availabilityStartTime = j2;
        this.duration = j3;
        this.minBufferTime = j4;
        this.dynamic = z;
        this.minUpdatePeriod = j5;
        this.timeShiftBufferDepth = j6;
        this.suggestedPresentationDelay = j7;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<RepresentationKey> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, linkedList)) == null) {
            RepresentationKey poll = linkedList.poll();
            int i2 = poll.periodIndex;
            ArrayList<AdaptationSet> arrayList = new ArrayList<>();
            do {
                int i3 = poll.adaptationSetIndex;
                AdaptationSet adaptationSet = list.get(i3);
                List<Representation> list2 = adaptationSet.representations;
                ArrayList arrayList2 = new ArrayList();
                do {
                    arrayList2.add(list2.get(poll.representationIndex));
                    poll = linkedList.poll();
                    if (poll.periodIndex != i2) {
                        break;
                    }
                } while (poll.adaptationSetIndex == i3);
                arrayList.add(new AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.supplementalProperties));
            } while (poll.periodIndex == i2);
            linkedList.addFirst(poll);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final DashManifest copy(List<RepresentationKey> list) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            LinkedList linkedList = new LinkedList(list);
            Collections.sort(linkedList);
            linkedList.add(new RepresentationKey(-1, -1, -1));
            ArrayList arrayList = new ArrayList();
            long j3 = 0;
            int i2 = 0;
            while (true) {
                int periodCount = getPeriodCount();
                j2 = C.TIME_UNSET;
                if (i2 >= periodCount) {
                    break;
                }
                if (((RepresentationKey) linkedList.peek()).periodIndex != i2) {
                    long periodDurationMs = getPeriodDurationMs(i2);
                    if (periodDurationMs != C.TIME_UNSET) {
                        j3 += periodDurationMs;
                    }
                } else {
                    Period period = getPeriod(i2);
                    arrayList.add(new Period(period.id, period.startMs - j3, copyAdaptationSets(period.adaptationSets, linkedList)));
                }
                i2++;
            }
            long j4 = this.duration;
            if (j4 != C.TIME_UNSET) {
                j2 = j4 - j3;
            }
            return new DashManifest(this.availabilityStartTime, j2, this.minBufferTime, this.dynamic, this.minUpdatePeriod, this.timeShiftBufferDepth, this.suggestedPresentationDelay, this.utcTiming, this.location, arrayList);
        }
        return (DashManifest) invokeL.objValue;
    }

    public final Period getPeriod(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.periods.get(i2) : (Period) invokeI.objValue;
    }

    public final int getPeriodCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.periods.size() : invokeV.intValue;
    }

    public final long getPeriodDurationMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == this.periods.size() - 1) {
                long j2 = this.duration;
                return j2 == C.TIME_UNSET ? C.TIME_UNSET : j2 - this.periods.get(i2).startMs;
            }
            return this.periods.get(i2 + 1).startMs - this.periods.get(i2).startMs;
        }
        return invokeI.longValue;
    }

    public final long getPeriodDurationUs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? C.msToUs(getPeriodDurationMs(i2)) : invokeI.longValue;
    }
}
