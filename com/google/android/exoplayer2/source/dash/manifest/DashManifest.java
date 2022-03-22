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
/* loaded from: classes6.dex */
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

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), utcTimingElement, uri, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.availabilityStartTime = j;
        this.duration = j2;
        this.minBufferTime = j3;
        this.dynamic = z;
        this.minUpdatePeriod = j4;
        this.timeShiftBufferDepth = j5;
        this.suggestedPresentationDelay = j6;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<RepresentationKey> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, linkedList)) == null) {
            RepresentationKey poll = linkedList.poll();
            int i = poll.periodIndex;
            ArrayList<AdaptationSet> arrayList = new ArrayList<>();
            do {
                int i2 = poll.adaptationSetIndex;
                AdaptationSet adaptationSet = list.get(i2);
                List<Representation> list2 = adaptationSet.representations;
                ArrayList arrayList2 = new ArrayList();
                do {
                    arrayList2.add(list2.get(poll.representationIndex));
                    poll = linkedList.poll();
                    if (poll.periodIndex != i) {
                        break;
                    }
                } while (poll.adaptationSetIndex == i2);
                arrayList.add(new AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.supplementalProperties));
            } while (poll.periodIndex == i);
            linkedList.addFirst(poll);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final DashManifest copy(List<RepresentationKey> list) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            LinkedList linkedList = new LinkedList(list);
            Collections.sort(linkedList);
            linkedList.add(new RepresentationKey(-1, -1, -1));
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            int i = 0;
            while (true) {
                int periodCount = getPeriodCount();
                j = C.TIME_UNSET;
                if (i >= periodCount) {
                    break;
                }
                if (((RepresentationKey) linkedList.peek()).periodIndex != i) {
                    long periodDurationMs = getPeriodDurationMs(i);
                    if (periodDurationMs != C.TIME_UNSET) {
                        j2 += periodDurationMs;
                    }
                } else {
                    Period period = getPeriod(i);
                    arrayList.add(new Period(period.id, period.startMs - j2, copyAdaptationSets(period.adaptationSets, linkedList)));
                }
                i++;
            }
            long j3 = this.duration;
            if (j3 != C.TIME_UNSET) {
                j = j3 - j2;
            }
            return new DashManifest(this.availabilityStartTime, j, this.minBufferTime, this.dynamic, this.minUpdatePeriod, this.timeShiftBufferDepth, this.suggestedPresentationDelay, this.utcTiming, this.location, arrayList);
        }
        return (DashManifest) invokeL.objValue;
    }

    public final Period getPeriod(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.periods.get(i) : (Period) invokeI.objValue;
    }

    public final int getPeriodCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.periods.size() : invokeV.intValue;
    }

    public final long getPeriodDurationMs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == this.periods.size() - 1) {
                long j = this.duration;
                return j == C.TIME_UNSET ? C.TIME_UNSET : j - this.periods.get(i).startMs;
            }
            return this.periods.get(i + 1).startMs - this.periods.get(i).startMs;
        }
        return invokeI.longValue;
    }

    public final long getPeriodDurationUs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? C.msToUs(getPeriodDurationMs(i)) : invokeI.longValue;
    }
}
