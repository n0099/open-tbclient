package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class SegmentBase {
    public final RangedUri initialization;
    public final long presentationTimeOffset;
    public final long timescale;

    /* loaded from: classes9.dex */
    public static abstract class MultiSegmentBase extends SegmentBase {
        public final long duration;
        public final List<SegmentTimelineElement> segmentTimeline;
        public final int startNumber;

        public abstract int getSegmentCount(long j);

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.startNumber = i;
            this.duration = j3;
            this.segmentTimeline = list;
        }

        public int getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            if (this.segmentTimeline != null) {
                return true;
            }
            return false;
        }

        public final long getSegmentDurationUs(int i, long j) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get(i - this.startNumber).duration * 1000000) / this.timescale;
            }
            int segmentCount = getSegmentCount(j);
            if (segmentCount != -1 && i == (getFirstSegmentNum() + segmentCount) - 1) {
                return j - getSegmentTimeUs(i);
            }
            return (this.duration * 1000000) / this.timescale;
        }

        public int getSegmentNum(long j, long j2) {
            int firstSegmentNum = getFirstSegmentNum();
            int segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                int i = this.startNumber + ((int) (j / ((this.duration * 1000000) / this.timescale)));
                if (i >= firstSegmentNum) {
                    if (segmentCount == -1) {
                        return i;
                    }
                    return Math.min(i, (firstSegmentNum + segmentCount) - 1);
                }
                return firstSegmentNum;
            }
            int i2 = (segmentCount + firstSegmentNum) - 1;
            int i3 = firstSegmentNum;
            while (i3 <= i2) {
                int i4 = ((i2 - i3) / 2) + i3;
                int i5 = (getSegmentTimeUs(i4) > j ? 1 : (getSegmentTimeUs(i4) == j ? 0 : -1));
                if (i5 < 0) {
                    i3 = i4 + 1;
                } else if (i5 > 0) {
                    i2 = i4 - 1;
                } else {
                    return i4;
                }
            }
            if (i3 == firstSegmentNum) {
                return i3;
            }
            return i2;
        }

        public final long getSegmentTimeUs(int i) {
            long j;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j = list.get(i - this.startNumber).startTime - this.presentationTimeOffset;
            } else {
                j = (i - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j, 1000000L, this.timescale);
        }
    }

    /* loaded from: classes9.dex */
    public static class SegmentList extends MultiSegmentBase {
        public final List<RangedUri> mediaSegments;

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }

        public SegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j, j2, i, j3, list);
            this.mediaSegments = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            return this.mediaSegments.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            return this.mediaSegments.get(i - this.startNumber);
        }
    }

    /* loaded from: classes9.dex */
    public static class SegmentTemplate extends MultiSegmentBase {
        public final UrlTemplate initializationTemplate;
        public final UrlTemplate mediaTemplate;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, i, j3, list);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                Format format = representation.format;
                return new RangedUri(urlTemplate.buildUri(format.id, 0, format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return list.size();
            }
            if (j != C.TIME_UNSET) {
                return (int) Util.ceilDivide(j, (this.duration * 1000000) / this.timescale);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, int i) {
            long j;
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
    }

    /* loaded from: classes9.dex */
    public static class SegmentTimelineElement {
        public final long duration;
        public final long startTime;

        public SegmentTimelineElement(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }
    }

    /* loaded from: classes9.dex */
    public static class SingleSegmentBase extends SegmentBase {
        public final long indexLength;
        public final long indexStart;

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public RangedUri getIndex() {
            long j = this.indexLength;
            if (j <= 0) {
                return null;
            }
            return new RangedUri(null, this.indexStart, j);
        }

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }
    }

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000L, this.timescale);
    }
}
