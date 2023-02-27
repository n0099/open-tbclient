package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class AdPlaybackState {
    public final int[] adCounts;
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public long adResumePositionUs;
    public final Uri[][] adUris;
    public final int[] adsLoadedCounts;
    public final int[] adsPlayedCounts;
    public long contentDurationUs;

    public AdPlaybackState(long[] jArr) {
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

    public void playedAd(int i) {
        this.adResumePositionUs = 0L;
        int[] iArr = this.adsPlayedCounts;
        iArr[i] = iArr[i] + 1;
    }

    public void playedAdGroup(int i) {
        this.adResumePositionUs = 0L;
        int[] iArr = this.adCounts;
        if (iArr[i] == -1) {
            iArr[i] = 0;
        }
        this.adsPlayedCounts[i] = this.adCounts[i];
    }

    public void setAdResumePositionUs(long j) {
        this.adResumePositionUs = j;
    }

    public AdPlaybackState(long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, Uri[][] uriArr, long j, long j2) {
        this.adGroupTimesUs = jArr;
        this.adCounts = iArr;
        this.adsLoadedCounts = iArr2;
        this.adsPlayedCounts = iArr3;
        this.adUris = uriArr;
        this.contentDurationUs = j;
        this.adResumePositionUs = j2;
        this.adGroupCount = jArr.length;
    }

    public void addAdUri(int i, Uri uri) {
        Uri[][] uriArr = this.adUris;
        int length = uriArr[i].length;
        uriArr[i] = (Uri[]) Arrays.copyOf(uriArr[i], length + 1);
        this.adUris[i][length] = uri;
        int[] iArr = this.adsLoadedCounts;
        iArr[i] = iArr[i] + 1;
    }

    public void setAdCount(int i, int i2) {
        this.adCounts[i] = i2;
    }

    public AdPlaybackState copy() {
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
}
