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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void addAdUri(int i2, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, uri) == null) {
            Uri[][] uriArr = this.adUris;
            int length = uriArr[i2].length;
            uriArr[i2] = (Uri[]) Arrays.copyOf(uriArr[i2], length + 1);
            this.adUris[i2][length] = uri;
            int[] iArr = this.adsLoadedCounts;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public AdPlaybackState copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (AdPlaybackState) invokeV.objValue;
        }
        Uri[][] uriArr = new Uri[this.adGroupTimesUs.length];
        int i2 = 0;
        while (true) {
            Uri[][] uriArr2 = this.adUris;
            if (i2 < uriArr2.length) {
                uriArr[i2] = (Uri[]) Arrays.copyOf(uriArr2[i2], uriArr2[i2].length);
                i2++;
            } else {
                return new AdPlaybackState(Arrays.copyOf(this.adGroupTimesUs, this.adGroupCount), Arrays.copyOf(this.adCounts, this.adGroupCount), Arrays.copyOf(this.adsLoadedCounts, this.adGroupCount), Arrays.copyOf(this.adsPlayedCounts, this.adGroupCount), uriArr, this.contentDurationUs, this.adResumePositionUs);
            }
        }
    }

    public void playedAd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.adResumePositionUs = 0L;
            int[] iArr = this.adsPlayedCounts;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public void playedAdGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.adResumePositionUs = 0L;
            int[] iArr = this.adCounts;
            if (iArr[i2] == -1) {
                iArr[i2] = 0;
            }
            this.adsPlayedCounts[i2] = this.adCounts[i2];
        }
    }

    public void setAdCount(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.adCounts[i2] = i3;
        }
    }

    public void setAdResumePositionUs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.adResumePositionUs = j2;
        }
    }

    public AdPlaybackState(long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, Uri[][] uriArr, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, iArr, iArr2, iArr3, uriArr, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.contentDurationUs = j2;
        this.adResumePositionUs = j3;
        this.adGroupCount = jArr.length;
    }
}
