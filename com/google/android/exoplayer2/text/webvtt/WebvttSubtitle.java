package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class WebvttSubtitle implements Subtitle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long[] cueTimesUs;
    public final List<WebvttCue> cues;
    public final int numCues;
    public final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cues = list;
        int size = list.size();
        this.numCues = size;
        this.cueTimesUs = new long[size * 2];
        for (int i3 = 0; i3 < this.numCues; i3++) {
            WebvttCue webvttCue = list.get(i3);
            int i4 = i3 * 2;
            long[] jArr = this.cueTimesUs;
            jArr[i4] = webvttCue.startTime;
            jArr[i4 + 1] = webvttCue.endTime;
        }
        long[] jArr2 = this.cueTimesUs;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.sortedCueTimesUs = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            SpannableStringBuilder spannableStringBuilder = null;
            WebvttCue webvttCue = null;
            ArrayList arrayList = null;
            for (int i = 0; i < this.numCues; i++) {
                long[] jArr = this.cueTimesUs;
                int i2 = i * 2;
                if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    WebvttCue webvttCue2 = this.cues.get(i);
                    if (!webvttCue2.isNormalCue()) {
                        arrayList.add(webvttCue2);
                    } else if (webvttCue == null) {
                        webvttCue = webvttCue2;
                    } else if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(webvttCue.text).append((CharSequence) "\n").append(webvttCue2.text);
                    } else {
                        spannableStringBuilder.append((CharSequence) "\n").append(webvttCue2.text);
                    }
                }
            }
            if (spannableStringBuilder != null) {
                arrayList.add(new WebvttCue(spannableStringBuilder));
            } else if (webvttCue != null) {
                arrayList.add(webvttCue);
            }
            return arrayList != null ? arrayList : Collections.emptyList();
        }
        return (List) invokeJ.objValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Assertions.checkArgument(i >= 0);
            Assertions.checkArgument(i < this.sortedCueTimesUs.length);
            return this.sortedCueTimesUs[i];
        }
        return invokeI.longValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sortedCueTimesUs.length : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j, false, false);
            if (binarySearchCeil < this.sortedCueTimesUs.length) {
                return binarySearchCeil;
            }
            return -1;
        }
        return invokeJ.intValue;
    }
}
