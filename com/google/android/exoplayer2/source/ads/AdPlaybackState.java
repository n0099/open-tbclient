package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class AdPlaybackState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] adCounts;
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public long adResumePositionUs;
    public final Uri[][] adUris;
    public final int[] adsLoadedCounts;
    public final int[] adsPlayedCounts;
    public long contentDurationUs;

    public AdPlaybackState(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adGroupTimesUs = jArr;
        int length = jArr.length;
        this.adGroupCount = length;
        this.adsPlayedCounts = new int[length];
        int[] iArr = new int[length];
        this.adCounts = iArr;
        Arrays.fill(iArr, -1);
        Uri[][] uriArr = new Uri[this.adGroupCount];
        this.adUris = uriArr;
        Arrays.fill(uriArr, new Uri[0]);
        this.adsLoadedCounts = new int[jArr.length];
        this.contentDurationUs = C.TIME_UNSET;
    }

    public void addAdUri(int i, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, uri) == null) {
            Uri[][] uriArr = this.adUris;
            int length = uriArr[i].length;
            uriArr[i] = (Uri[]) Arrays.copyOf(uriArr[i], length + 1);
            this.adUris[i][length] = uri;
            int[] iArr = this.adsLoadedCounts;
            iArr[i] = iArr[i] + 1;
        }
    }

    public AdPlaybackState copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (AdPlaybackState) invokeV.objValue;
        }
        Uri[][] uriArr = new Uri[this.adGroupTimesUs.length];
        int i = 0;
        while (true) {
            Uri[][] uriArr2 = this.adUris;
            if (i < uriArr2.length) {
                uriArr[i] = (Uri[]) Arrays.copyOf(uriArr2[i], uriArr2[i].length);
                i++;
            } else {
                return new AdPlaybackState(Arrays.copyOf(this.adGroupTimesUs, this.adGroupCount), Arrays.copyOf(this.adCounts, this.adGroupCount), Arrays.copyOf(this.adsLoadedCounts, this.adGroupCount), Arrays.copyOf(this.adsPlayedCounts, this.adGroupCount), uriArr, this.contentDurationUs, this.adResumePositionUs);
            }
        }
    }

    public void playedAd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.adResumePositionUs = 0L;
            int[] iArr = this.adsPlayedCounts;
            iArr[i] = iArr[i] + 1;
        }
    }

    public void playedAdGroup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.adResumePositionUs = 0L;
            int[] iArr = this.adCounts;
            if (iArr[i] == -1) {
                iArr[i] = 0;
            }
            this.adsPlayedCounts[i] = this.adCounts[i];
        }
    }

    public void setAdCount(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.adCounts[i] = i2;
        }
    }

    public void setAdResumePositionUs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.adResumePositionUs = j;
        }
    }

    public AdPlaybackState(long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, Uri[][] uriArr, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, iArr, iArr2, iArr3, uriArr, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.adGroupTimesUs = jArr;
        this.adCounts = iArr;
        this.adsLoadedCounts = iArr2;
        this.adsPlayedCounts = iArr3;
        this.adUris = uriArr;
        this.contentDurationUs = j;
        this.adResumePositionUs = j2;
        this.adGroupCount = jArr.length;
    }
}
