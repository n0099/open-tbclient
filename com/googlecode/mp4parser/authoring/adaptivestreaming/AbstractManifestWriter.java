package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public abstract class AbstractManifestWriter implements ManifestWriter {
    private static final Logger LOG = Logger.getLogger(AbstractManifestWriter.class.getName());
    protected long[] audioFragmentsDurations;
    private FragmentIntersectionFinder intersectionFinder;
    protected long[] videoFragmentsDurations;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractManifestWriter(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public long[] calculateFragmentDurations(Track track, Movie movie) {
        long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
        long[] jArr = new long[sampleNumbers.length];
        long[] sampleDurations = track.getSampleDurations();
        int length = sampleDurations.length;
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            long j = sampleDurations[i3];
            int i4 = i + 1;
            int i5 = i;
            int i6 = i2;
            int i7 = i5;
            while (i7 < i4) {
                if (i6 != sampleNumbers.length - 1 && i7 == sampleNumbers[i6 + 1]) {
                    i6++;
                }
                jArr[i6] = jArr[i6] + j;
                i7++;
            }
            i3++;
            int i8 = i7;
            i2 = i6;
            i = i8;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public long getBitrate(Track track) {
        long j = 0;
        Iterator<Sample> it = track.getSamples().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().getSize() + j2;
            } else {
                return ((long) (j2 / (track.getDuration() / track.getTrackMetaData().getTimescale()))) * 8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long[] checkFragmentsAlign(long[] jArr, long[] jArr2) throws IOException {
        if (jArr != null && jArr.length != 0) {
            long[] jArr3 = new long[jArr.length - 1];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length - 1);
            long[] jArr4 = new long[jArr2.length - 1];
            System.arraycopy(jArr2, 0, jArr4, 0, jArr2.length - 1);
            if (!Arrays.equals(jArr4, jArr3)) {
                String str = String.valueOf(String.valueOf("") + jArr.length) + "Reference     :  [";
                for (int i = 0; i < jArr.length; i++) {
                    str = String.valueOf(str) + String.format("%10d,", Long.valueOf(jArr[i]));
                }
                LOG.warning(String.valueOf(str) + "]");
                String str2 = String.valueOf(String.valueOf("") + jArr2.length) + "Current       :  [";
                for (int i2 = 0; i2 < jArr2.length; i2++) {
                    str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(jArr2[i2]));
                }
                LOG.warning(String.valueOf(str2) + "]");
                throw new IOException("Track does not have the same fragment borders as its predecessor.");
            }
        }
        return jArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFormat(AbstractSampleEntry abstractSampleEntry) {
        String type = abstractSampleEntry.getType();
        if (type.equals(VisualSampleEntry.TYPE_ENCRYPTED) || type.equals(AudioSampleEntry.TYPE_ENCRYPTED) || type.equals(VisualSampleEntry.TYPE_ENCRYPTED)) {
            return ((OriginalFormatBox) abstractSampleEntry.getBoxes(OriginalFormatBox.class, true).get(0)).getDataFormat();
        }
        return type;
    }
}
