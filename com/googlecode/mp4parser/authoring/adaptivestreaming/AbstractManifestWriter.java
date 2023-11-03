package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import java.util.logging.Logger;
/* loaded from: classes10.dex */
public abstract class AbstractManifestWriter implements ManifestWriter {
    public static final Logger LOG = Logger.getLogger(AbstractManifestWriter.class.getName());
    public long[] audioFragmentsDurations;
    public FragmentIntersectionFinder intersectionFinder;
    public long[] videoFragmentsDurations;

    public AbstractManifestWriter(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public String getFormat(AbstractSampleEntry abstractSampleEntry) {
        String type = abstractSampleEntry.getType();
        if (type.equals(VisualSampleEntry.TYPE_ENCRYPTED) || type.equals(AudioSampleEntry.TYPE_ENCRYPTED) || type.equals(VisualSampleEntry.TYPE_ENCRYPTED)) {
            return ((OriginalFormatBox) abstractSampleEntry.getBoxes(OriginalFormatBox.class, true).get(0)).getDataFormat();
        }
        return type;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public long[] calculateFragmentDurations(Track track, Movie movie) {
        long[] sampleDurations;
        long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
        long[] jArr = new long[sampleNumbers.length];
        int i = 0;
        int i2 = 1;
        for (long j : track.getSampleDurations()) {
            int i3 = i2 + 1;
            while (i2 < i3) {
                if (i != sampleNumbers.length - 1) {
                    int i4 = i + 1;
                    if (i2 == sampleNumbers[i4]) {
                        i = i4;
                    }
                }
                jArr[i] = jArr[i] + j;
                i2++;
            }
        }
        return jArr;
    }

    public long[] checkFragmentsAlign(long[] jArr, long[] jArr2) throws IOException {
        if (jArr != null && jArr.length != 0) {
            long[] jArr3 = new long[jArr.length - 1];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length - 1);
            long[] jArr4 = new long[jArr2.length - 1];
            System.arraycopy(jArr2, 0, jArr4, 0, jArr2.length - 1);
            if (!Arrays.equals(jArr4, jArr3)) {
                StringBuilder sb = new StringBuilder(String.valueOf("" + jArr.length));
                sb.append("Reference     :  [");
                String sb2 = sb.toString();
                for (long j : jArr) {
                    sb2 = String.valueOf(sb2) + String.format("%10d,", Long.valueOf(j));
                }
                LOG.warning(String.valueOf(sb2) + PreferencesUtil.RIGHT_MOUNT);
                StringBuilder sb3 = new StringBuilder(String.valueOf("" + jArr2.length));
                sb3.append("Current       :  [");
                String sb4 = sb3.toString();
                for (long j2 : jArr2) {
                    sb4 = String.valueOf(sb4) + String.format("%10d,", Long.valueOf(j2));
                }
                LOG.warning(String.valueOf(sb4) + PreferencesUtil.RIGHT_MOUNT);
                throw new IOException("Track does not have the same fragment borders as its predecessor.");
            }
        }
        return jArr2;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public long getBitrate(Track track) {
        long j = 0;
        for (Sample sample : track.getSamples()) {
            j += sample.getSize();
        }
        return ((long) (j / (track.getDuration() / track.getTrackMetaData().getTimescale()))) * 8;
    }
}
