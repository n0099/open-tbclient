package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
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
/* loaded from: classes9.dex */
public class SsManifest {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    /* loaded from: classes9.dex */
    public static class ProtectionElement {
        public final byte[] data;
        public final UUID uuid;

        public ProtectionElement(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes9.dex */
    public static class StreamElement {
        public static final String URL_PLACEHOLDER_BITRATE_1 = "{bitrate}";
        public static final String URL_PLACEHOLDER_BITRATE_2 = "{Bitrate}";
        public static final String URL_PLACEHOLDER_START_TIME_1 = "{start time}";
        public static final String URL_PLACEHOLDER_START_TIME_2 = "{start_time}";
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

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, Util.scaleLargeTimestamps(list, 1000000L, j), Util.scaleLargeTimestamp(j2, 1000000L, j));
        }

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.baseUri = str;
            this.chunkTemplate = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.chunkStartTimes = list;
            this.chunkStartTimesUs = jArr;
            this.lastChunkDurationUs = j2;
            this.chunkCount = list.size();
        }

        public Uri buildRequestUri(int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            if (this.formats != null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            if (this.chunkStartTimes != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            if (i2 >= this.chunkStartTimes.size()) {
                z3 = false;
            }
            Assertions.checkState(z3);
            String num = Integer.toString(this.formats[i].bitrate);
            String l = this.chunkStartTimes.get(i2).toString();
            return UriUtil.resolveToUri(this.baseUri, this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE_1, num).replace(URL_PLACEHOLDER_BITRATE_2, num).replace(URL_PLACEHOLDER_START_TIME_1, l).replace(URL_PLACEHOLDER_START_TIME_2, l));
        }

        public StreamElement copy(Format[] formatArr) {
            return new StreamElement(this.baseUri, this.chunkTemplate, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.chunkStartTimes, this.chunkStartTimesUs, this.lastChunkDurationUs);
        }

        public long getChunkDurationUs(int i) {
            if (i == this.chunkCount - 1) {
                return this.lastChunkDurationUs;
            }
            long[] jArr = this.chunkStartTimesUs;
            return jArr[i + 1] - jArr[i];
        }

        public int getChunkIndex(long j) {
            return Util.binarySearchFloor(this.chunkStartTimesUs, j, true, true);
        }

        public long getStartTimeUs(int i) {
            return this.chunkStartTimesUs[i];
        }
    }

    public SsManifest(int i, int i2, long j, long j2, int i3, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.durationUs = j;
        this.dvrWindowLengthUs = j2;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this(i, i2, r9, j3 != 0 ? Util.scaleLargeTimestamp(j3, 1000000L, j) : r0, i3, z, protectionElement, streamElementArr);
        long scaleLargeTimestamp;
        long j4 = C.TIME_UNSET;
        if (j2 == 0) {
            scaleLargeTimestamp = -9223372036854775807L;
        } else {
            scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000000L, j);
        }
    }

    public final SsManifest copy(List<TrackKey> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StreamElement streamElement = null;
        int i = 0;
        while (i < linkedList.size()) {
            TrackKey trackKey = (TrackKey) linkedList.get(i);
            StreamElement streamElement2 = this.streamElements[trackKey.streamElementIndex];
            if (streamElement2 != streamElement && streamElement != null) {
                arrayList.add(streamElement.copy((Format[]) arrayList2.toArray(new Format[0])));
                arrayList2.clear();
            }
            arrayList2.add(streamElement2.formats[trackKey.trackIndex]);
            i++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList.add(streamElement.copy((Format[]) arrayList2.toArray(new Format[0])));
        }
        return new SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (StreamElement[]) arrayList.toArray(new StreamElement[0]));
    }
}
