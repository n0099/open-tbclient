package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class TrackGroup {
    public final Format[] formats;
    public int hashCode;
    public final int length;

    public TrackGroup(Format... formatArr) {
        boolean z;
        if (formatArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats)) {
            return true;
        }
        return false;
    }

    public Format getFormat(int i) {
        return this.formats[i];
    }

    public int indexOf(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i < formatArr.length) {
                if (format == formatArr[i]) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }
}
