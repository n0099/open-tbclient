package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    public static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    public static final int[] NO_TRACKS = new int[0];
    public static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    public final TrackSelection.Factory adaptiveTrackSelectionFactory;
    public final AtomicReference<Parameters> paramsReference;

    public static int compareFormatValues(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    public static int compareInts(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static boolean isSupported(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    /* loaded from: classes9.dex */
    public static final class AudioConfigurationTuple {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i, int i2, String str) {
            this.channelCount = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioConfigurationTuple.class != obj.getClass()) {
                return false;
            }
            AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
            if (this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = ((this.channelCount * 31) + this.sampleRate) * 31;
            String str = this.mimeType;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            return i2 + i;
        }
    }

    /* loaded from: classes9.dex */
    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        public final int bitrate;
        public final int channelCount;
        public final int defaultSelectionFlagScore;
        public final int matchLanguageScore;
        public final Parameters parameters;
        public final int sampleRate;
        public final int withinRendererCapabilitiesScore;

        public AudioTrackScore(Format format, Parameters parameters, int i) {
            this.parameters = parameters;
            this.withinRendererCapabilitiesScore = DefaultTrackSelector.isSupported(i, false) ? 1 : 0;
            this.matchLanguageScore = DefaultTrackSelector.formatHasLanguage(format, parameters.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) != 0 ? 1 : 0;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(AudioTrackScore audioTrackScore) {
            int compareInts;
            int i = this.withinRendererCapabilitiesScore;
            int i2 = audioTrackScore.withinRendererCapabilitiesScore;
            if (i == i2) {
                int i3 = this.matchLanguageScore;
                int i4 = audioTrackScore.matchLanguageScore;
                if (i3 == i4) {
                    int i5 = this.defaultSelectionFlagScore;
                    int i6 = audioTrackScore.defaultSelectionFlagScore;
                    if (i5 == i6) {
                        if (!this.parameters.forceLowestBitrate) {
                            int i7 = 1;
                            if (i != 1) {
                                i7 = -1;
                            }
                            int i8 = this.channelCount;
                            int i9 = audioTrackScore.channelCount;
                            if (i8 == i9) {
                                int i10 = this.sampleRate;
                                int i11 = audioTrackScore.sampleRate;
                                compareInts = i10 != i11 ? DefaultTrackSelector.compareInts(i10, i11) : DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                            } else {
                                compareInts = DefaultTrackSelector.compareInts(i8, i9);
                            }
                            return i7 * compareInts;
                        }
                        return DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
                    }
                    return DefaultTrackSelector.compareInts(i5, i6);
                }
                return DefaultTrackSelector.compareInts(i3, i4);
            }
            return DefaultTrackSelector.compareInts(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioTrackScore.class != obj.getClass()) {
                return false;
            }
            AudioTrackScore audioTrackScore = (AudioTrackScore) obj;
            if (this.withinRendererCapabilitiesScore == audioTrackScore.withinRendererCapabilitiesScore && this.matchLanguageScore == audioTrackScore.matchLanguageScore && this.defaultSelectionFlagScore == audioTrackScore.defaultSelectionFlagScore && this.channelCount == audioTrackScore.channelCount && this.sampleRate == audioTrackScore.sampleRate && this.bitrate == audioTrackScore.bitrate) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.withinRendererCapabilitiesScore * 31) + this.matchLanguageScore) * 31) + this.defaultSelectionFlagScore) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Parameters {
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceLowestBitrate;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final String preferredAudioLanguage;
        public final String preferredTextLanguage;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        public Parameters() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Parameters withMaxVideoSizeSd() {
            return withMaxVideoSize(1279, 719);
        }

        public Parameters withoutVideoSizeConstraints() {
            return withMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Parameters withoutViewportSizeConstraints() {
            return withViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Parameters(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            this.preferredAudioLanguage = str;
            this.preferredTextLanguage = str2;
            this.forceLowestBitrate = z;
            this.allowMixedMimeAdaptiveness = z2;
            this.allowNonSeamlessAdaptiveness = z3;
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoBitrate = i3;
            this.exceedVideoConstraintsIfNecessary = z4;
            this.exceedRendererCapabilitiesIfNecessary = z5;
            this.viewportWidth = i4;
            this.viewportHeight = i5;
            this.viewportOrientationMayChange = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (this.forceLowestBitrate == parameters.forceLowestBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.preferredAudioLanguage.hashCode() * 31) + this.preferredTextLanguage.hashCode()) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }

        public Parameters withAllowMixedMimeAdaptiveness(boolean z) {
            if (z == this.allowMixedMimeAdaptiveness) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, z, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withAllowNonSeamlessAdaptiveness(boolean z) {
            if (z == this.allowNonSeamlessAdaptiveness) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, z, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withExceedRendererCapabilitiesIfNecessary(boolean z) {
            if (z == this.exceedRendererCapabilitiesIfNecessary) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, z, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withExceedVideoConstraintsIfNecessary(boolean z) {
            if (z == this.exceedVideoConstraintsIfNecessary) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, z, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withForceLowestBitrate(boolean z) {
            if (z == this.forceLowestBitrate) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, z, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withMaxVideoBitrate(int i) {
            if (i == this.maxVideoBitrate) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, i, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withPreferredAudioLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            if (TextUtils.equals(normalizeLanguageCode, this.preferredAudioLanguage)) {
                return this;
            }
            return new Parameters(normalizeLanguageCode, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withPreferredTextLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            if (TextUtils.equals(normalizeLanguageCode, this.preferredTextLanguage)) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, normalizeLanguageCode, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withMaxVideoSize(int i, int i2) {
            if (i == this.maxVideoWidth && i2 == this.maxVideoHeight) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, i, i2, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public Parameters withViewportSizeFromContext(Context context, boolean z) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return withViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z);
        }

        public Parameters withViewportSize(int i, int i2, boolean z) {
            if (i == this.viewportWidth && i2 == this.viewportHeight) {
                if (z == this.viewportOrientationMayChange) {
                    return this;
                }
                return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i, i2, z);
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i, i2, z);
        }
    }

    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
    }

    public Parameters getParameters() {
        return this.paramsReference.get();
    }

    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.paramsReference = new AtomicReference<>(new Parameters());
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.paramsReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    public static boolean formatHasLanguage(Format format, String str) {
        if (str != null && TextUtils.equals(str, Util.normalizeLanguageCode(format.language))) {
            return true;
        }
        return false;
    }

    public static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    public static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = list.get(i6).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    public static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i = 0;
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i2), iArr[i2], audioConfigurationTuple)) {
                i++;
            }
        }
        return i;
    }

    public static boolean isSupportedAdaptiveAudioTrack(Format format, int i, AudioConfigurationTuple audioConfigurationTuple) {
        if (!isSupported(i, false) || format.channelCount != audioConfigurationTuple.channelCount || format.sampleRate != audioConfigurationTuple.sampleRate) {
            return false;
        }
        String str = audioConfigurationTuple.mimeType;
        if (str != null && !TextUtils.equals(str, format.sampleMimeType)) {
            return false;
        }
        return true;
    }

    public static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z) {
        String str;
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        AudioConfigurationTuple audioConfigurationTuple = null;
        int i = 0;
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            Format format = trackGroup.getFormat(i2);
            int i3 = format.channelCount;
            int i4 = format.sampleRate;
            if (z) {
                str = null;
            } else {
                str = format.sampleMimeType;
            }
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(i3, i4, str);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i) {
                i = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i > 1) {
            int[] iArr2 = new int[i];
            int i5 = 0;
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i6), iArr[i6], audioConfigurationTuple)) {
                    iArr2[i5] = i6;
                    i5++;
                }
            }
            return iArr2;
        }
        return NO_TRACKS;
    }

    public static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        int adaptiveVideoTrackCountForMimeType;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i5, i6, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < viewportFilteredTrackIndices.size(); i8++) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i8).intValue()).sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, i4, viewportFilteredTrackIndices)) > i7) {
                    i7 = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        } else {
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, viewportFilteredTrackIndices);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        return Util.toArray(viewportFilteredTrackIndices);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000d, code lost:
        if (r1 != r3) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        if (z) {
            boolean z3 = true;
            if (i3 > i4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i <= i2) {
                z3 = false;
            }
        }
        i2 = i;
        i = i2;
        int i5 = i3 * i;
        int i6 = i4 * i2;
        if (i5 >= i6) {
            return new Point(i2, Util.ceilDivide(i6, i3));
        }
        return new Point(Util.ceilDivide(i5, i4), i);
    }

    public TrackSelection selectVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackSelection trackSelection;
        if (!parameters.forceLowestBitrate && factory != null) {
            trackSelection = selectAdaptiveVideoTrack(rendererCapabilities, trackGroupArray, iArr, parameters, factory);
        } else {
            trackSelection = null;
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, parameters);
        }
        return trackSelection;
    }

    public static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i4 = 0; i4 < trackGroup.length; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                Format format = trackGroup.getFormat(i6);
                int i7 = format.width;
                if (i7 > 0 && (i3 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, i7, i3);
                    int i8 = format.width;
                    int i9 = format.height;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (maxVideoSizeInViewport.x * 0.98f)) && i9 >= ((int) (maxVideoSizeInViewport.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        AudioTrackScore audioTrackScore = null;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i4), parameters, iArr2[i4]);
                    if (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0) {
                        i = i3;
                        i2 = i4;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray.get(i);
        if (!parameters.forceLowestBitrate && factory != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i], parameters.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                return factory.createTrackSelection(trackGroup2, adaptiveAudioTracks);
            }
        }
        return new FixedTrackSelection(trackGroup2, i2);
    }

    public static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!isSupported(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i6 = format.width;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        int i7 = format.height;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = format.bitrate;
        if (i8 != -1 && i8 > i5) {
            return false;
        }
        return true;
    }

    public static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i;
        boolean z;
        if (parameters.allowNonSeamlessAdaptiveness) {
            i = 24;
        } else {
            i = 16;
        }
        if (parameters.allowMixedMimeAdaptiveness && (rendererCapabilities.supportsMixedMimeTypeAdaptation() & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i2], z, i, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return factory.createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        if (compareFormatValues(r2.bitrate, r10) < 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSelection selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        boolean z;
        int i;
        boolean z2;
        int compareFormatValues;
        int i2;
        int i3;
        int i4;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int i5 = -1;
        int i6 = 0;
        TrackGroup trackGroup = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        while (i6 < trackGroupArray2.length) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i6);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            int[] iArr2 = iArr[i6];
            int i11 = 0;
            while (i11 < trackGroup2.length) {
                if (isSupported(iArr2[i11], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i11);
                    boolean z3 = true;
                    if (viewportFilteredTrackIndices.contains(Integer.valueOf(i11)) && (((i2 = format.width) == i5 || i2 <= parameters.maxVideoWidth) && (((i3 = format.height) == i5 || i3 <= parameters.maxVideoHeight) && ((i4 = format.bitrate) == i5 || i4 <= parameters.maxVideoBitrate)))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z || parameters.exceedVideoConstraintsIfNecessary) {
                        if (z) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                        boolean isSupported = isSupported(iArr2[i11], false);
                        if (isSupported) {
                            i += 1000;
                        }
                        if (i > i8) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i == i8) {
                            if (!parameters.forceLowestBitrate) {
                                int pixelCount = format.getPixelCount();
                                if (pixelCount != i9) {
                                    compareFormatValues = compareFormatValues(pixelCount, i9);
                                } else {
                                    compareFormatValues = compareFormatValues(format.bitrate, i10);
                                }
                                if (isSupported) {
                                }
                                z3 = false;
                                z2 = z3;
                            }
                        }
                        if (z2) {
                            i10 = format.bitrate;
                            i9 = format.getPixelCount();
                            trackGroup = trackGroup2;
                            i7 = i11;
                            i8 = i;
                        }
                    }
                }
                i11++;
                i5 = -1;
            }
            i6++;
            trackGroupArray2 = trackGroupArray;
            i5 = -1;
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i7);
    }

    public TrackSelection selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        boolean z;
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i6 = 1;
                    if ((trackGroup2.getFormat(i5).selectionFlags & 1) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i6 = 2;
                    }
                    if (isSupported(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i3) {
                        trackGroup = trackGroup2;
                        i2 = i5;
                        i3 = i6;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    public TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        TrackGroup trackGroup = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i4);
                    int i5 = 1;
                    if ((format.selectionFlags & 1) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((format.selectionFlags & 2) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (formatHasLanguage(format, parameters.preferredTextLanguage)) {
                        if (z) {
                            i5 = 6;
                        } else if (!z2) {
                            i5 = 5;
                        } else {
                            i5 = 4;
                        }
                    } else if (z) {
                        i5 = 3;
                    } else if (z2) {
                        if (formatHasLanguage(format, parameters.preferredAudioLanguage)) {
                            i5 = 2;
                        }
                    }
                    if (isSupported(iArr2[i4], false)) {
                        i5 += 1000;
                    }
                    if (i5 > i2) {
                        trackGroup = trackGroup2;
                        i = i4;
                        i2 = i5;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i);
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException {
        TrackSelection.Factory factory;
        int length = rendererCapabilitiesArr.length;
        TrackSelection[] trackSelectionArr = new TrackSelection[length];
        Parameters parameters = this.paramsReference.get();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            if (i >= length) {
                break;
            }
            if (2 == rendererCapabilitiesArr[i].getTrackType()) {
                if (!z) {
                    trackSelectionArr[i] = selectVideoTrack(rendererCapabilitiesArr[i], trackGroupArrayArr[i], iArr[i], parameters, this.adaptiveTrackSelectionFactory);
                    if (trackSelectionArr[i] != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (trackGroupArrayArr[i].length <= 0) {
                    z3 = false;
                }
                z2 |= z3;
            }
            i++;
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i2 = 0; i2 < length; i2++) {
            int trackType = rendererCapabilitiesArr[i2].getTrackType();
            if (trackType != 1) {
                if (trackType != 2) {
                    if (trackType != 3) {
                        trackSelectionArr[i2] = selectOtherTrack(rendererCapabilitiesArr[i2].getTrackType(), trackGroupArrayArr[i2], iArr[i2], parameters);
                    } else if (!z5) {
                        trackSelectionArr[i2] = selectTextTrack(trackGroupArrayArr[i2], iArr[i2], parameters);
                        if (trackSelectionArr[i2] != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                }
            } else if (!z4) {
                TrackGroupArray trackGroupArray = trackGroupArrayArr[i2];
                int[][] iArr2 = iArr[i2];
                if (z2) {
                    factory = null;
                } else {
                    factory = this.adaptiveTrackSelectionFactory;
                }
                trackSelectionArr[i2] = selectAudioTrack(trackGroupArray, iArr2, parameters, factory);
                if (trackSelectionArr[i2] != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
        }
        return trackSelectionArr;
    }
}
