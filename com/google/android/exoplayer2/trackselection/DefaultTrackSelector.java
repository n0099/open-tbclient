package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    public static final int[] NO_TRACKS;
    public static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public final TrackSelection.Factory adaptiveTrackSelectionFactory;
    public final AtomicReference<Parameters> paramsReference;

    /* loaded from: classes4.dex */
    public static final class AudioConfigurationTuple {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.channelCount = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || AudioConfigurationTuple.class != obj.getClass()) {
                    return false;
                }
                AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
                return this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = ((this.channelCount * 31) + this.sampleRate) * 31;
                String str = this.mimeType;
                return i + (str != null ? str.hashCode() : 0);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bitrate;
        public final int channelCount;
        public final int defaultSelectionFlagScore;
        public final int matchLanguageScore;
        public final Parameters parameters;
        public final int sampleRate;
        public final int withinRendererCapabilitiesScore;

        public AudioTrackScore(Format format, Parameters parameters, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, parameters, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parameters = parameters;
            this.withinRendererCapabilitiesScore = DefaultTrackSelector.isSupported(i, false) ? 1 : 0;
            this.matchLanguageScore = DefaultTrackSelector.formatHasLanguage(format, parameters.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) != 0 ? 1 : 0;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || AudioTrackScore.class != obj.getClass()) {
                    return false;
                }
                AudioTrackScore audioTrackScore = (AudioTrackScore) obj;
                return this.withinRendererCapabilitiesScore == audioTrackScore.withinRendererCapabilitiesScore && this.matchLanguageScore == audioTrackScore.matchLanguageScore && this.defaultSelectionFlagScore == audioTrackScore.defaultSelectionFlagScore && this.channelCount == audioTrackScore.channelCount && this.sampleRate == audioTrackScore.sampleRate && this.bitrate == audioTrackScore.bitrate;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((((((((this.withinRendererCapabilitiesScore * 31) + this.matchLanguageScore) * 31) + this.defaultSelectionFlagScore) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(AudioTrackScore audioTrackScore) {
            InterceptResult invokeL;
            int compareInts;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, audioTrackScore)) == null) {
                int i = this.withinRendererCapabilitiesScore;
                int i2 = audioTrackScore.withinRendererCapabilitiesScore;
                if (i != i2) {
                    return DefaultTrackSelector.compareInts(i, i2);
                }
                int i3 = this.matchLanguageScore;
                int i4 = audioTrackScore.matchLanguageScore;
                if (i3 != i4) {
                    return DefaultTrackSelector.compareInts(i3, i4);
                }
                int i5 = this.defaultSelectionFlagScore;
                int i6 = audioTrackScore.defaultSelectionFlagScore;
                if (i5 != i6) {
                    return DefaultTrackSelector.compareInts(i5, i6);
                }
                if (this.parameters.forceLowestBitrate) {
                    return DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
                }
                int i7 = i != 1 ? -1 : 1;
                int i8 = this.channelCount;
                int i9 = audioTrackScore.channelCount;
                if (i8 != i9) {
                    compareInts = DefaultTrackSelector.compareInts(i8, i9);
                } else {
                    int i10 = this.sampleRate;
                    int i11 = audioTrackScore.sampleRate;
                    compareInts = i10 != i11 ? DefaultTrackSelector.compareInts(i10, i11) : DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                }
                return i7 * compareInts;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Parameters {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Parameters() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Boolean) objArr[8]).booleanValue(), ((Boolean) objArr[9]).booleanValue(), ((Integer) objArr[10]).intValue(), ((Integer) objArr[11]).intValue(), ((Boolean) objArr[12]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Parameters.class != obj.getClass()) {
                    return false;
                }
                Parameters parameters = (Parameters) obj;
                return this.forceLowestBitrate == parameters.forceLowestBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (((((((((((((((((((((((this.preferredAudioLanguage.hashCode() * 31) + this.preferredTextLanguage.hashCode()) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
            }
            return invokeV.intValue;
        }

        public Parameters withAllowMixedMimeAdaptiveness(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? z == this.allowMixedMimeAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, z, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeZ.objValue;
        }

        public Parameters withAllowNonSeamlessAdaptiveness(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? z == this.allowNonSeamlessAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, z, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeZ.objValue;
        }

        public Parameters withExceedRendererCapabilitiesIfNecessary(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? z == this.exceedRendererCapabilitiesIfNecessary ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, z, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeZ.objValue;
        }

        public Parameters withExceedVideoConstraintsIfNecessary(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) ? z == this.exceedVideoConstraintsIfNecessary ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, z, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeZ.objValue;
        }

        public Parameters withForceLowestBitrate(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? z == this.forceLowestBitrate ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, z, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeZ.objValue;
        }

        public Parameters withMaxVideoBitrate(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i == this.maxVideoBitrate ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, i, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange) : (Parameters) invokeI.objValue;
        }

        public Parameters withMaxVideoSize(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
                if (i == this.maxVideoWidth && i2 == this.maxVideoHeight) {
                    return this;
                }
                return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, i, i2, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
            }
            return (Parameters) invokeII.objValue;
        }

        public Parameters withMaxVideoSizeSd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? withMaxVideoSize(1279, 719) : (Parameters) invokeV.objValue;
        }

        public Parameters withPreferredAudioLanguage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                String normalizeLanguageCode = Util.normalizeLanguageCode(str);
                return TextUtils.equals(normalizeLanguageCode, this.preferredAudioLanguage) ? this : new Parameters(normalizeLanguageCode, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
            }
            return (Parameters) invokeL.objValue;
        }

        public Parameters withPreferredTextLanguage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                String normalizeLanguageCode = Util.normalizeLanguageCode(str);
                return TextUtils.equals(normalizeLanguageCode, this.preferredTextLanguage) ? this : new Parameters(this.preferredAudioLanguage, normalizeLanguageCode, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
            }
            return (Parameters) invokeL.objValue;
        }

        public Parameters withViewportSize(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (i == this.viewportWidth && i2 == this.viewportHeight) {
                    if (z == this.viewportOrientationMayChange) {
                        return this;
                    }
                    return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i, i2, z);
                }
                return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i, i2, z);
            }
            return (Parameters) invokeCommon.objValue;
        }

        public Parameters withViewportSizeFromContext(Context context, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, context, z)) == null) {
                Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
                return withViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z);
            }
            return (Parameters) invokeLZ.objValue;
        }

        public Parameters withoutVideoSizeConstraints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? withMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE) : (Parameters) invokeV.objValue;
        }

        public Parameters withoutViewportSizeConstraints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? withViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true) : (Parameters) invokeV.objValue;
        }

        public Parameters(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1982261022, "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1982261022, "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;");
                return;
            }
        }
        NO_TRACKS = new int[0];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TrackSelection.Factory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int compareFormatValues(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            if (i == -1) {
                return i2 == -1 ? 0 : -1;
            } else if (i2 == -1) {
                return 1;
            } else {
                return i - i2;
            }
        }
        return invokeII.intValue;
    }

    public static int compareInts(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            if (i > i2) {
                return 1;
            }
            return i2 > i ? -1 : 0;
        }
        return invokeII.intValue;
    }

    public static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{trackGroup, iArr, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list}) == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                int intValue = list.get(size).intValue();
                if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                    list.remove(size);
                }
            }
        }
    }

    public static boolean formatHasLanguage(Format format, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, format, str)) == null) ? str != null && TextUtils.equals(str, Util.normalizeLanguageCode(format.language)) : invokeLL.booleanValue;
    }

    public static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, trackGroup, iArr, audioConfigurationTuple)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i2), iArr[i2], audioConfigurationTuple)) {
                    i++;
                }
            }
            return i;
        }
        return invokeLLL.intValue;
    }

    public static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z) {
        InterceptResult invokeLLZ;
        int adaptiveAudioTrackCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, trackGroup, iArr, z)) == null) {
            HashSet hashSet = new HashSet();
            AudioConfigurationTuple audioConfigurationTuple = null;
            int i = 0;
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(format.channelCount, format.sampleRate, z ? null : format.sampleMimeType);
                if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i) {
                    i = adaptiveAudioTrackCount;
                    audioConfigurationTuple = audioConfigurationTuple2;
                }
            }
            if (i > 1) {
                int[] iArr2 = new int[i];
                int i3 = 0;
                for (int i4 = 0; i4 < trackGroup.length; i4++) {
                    if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i4), iArr[i4], audioConfigurationTuple)) {
                        iArr2[i3] = i4;
                        i3++;
                    }
                }
                return iArr2;
            }
            return NO_TRACKS;
        }
        return (int[]) invokeLLZ.objValue;
    }

    public static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{trackGroup, iArr, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list})) == null) {
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = list.get(i6).intValue();
                if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                    i5++;
                }
            }
            return i5;
        }
        return invokeCommon.intValue;
    }

    public static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        InterceptResult invokeCommon;
        String str;
        int adaptiveVideoTrackCountForMimeType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{trackGroup, iArr, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z2)})) == null) {
            if (trackGroup.length < 2) {
                return NO_TRACKS;
            }
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i5, i6, z2);
            if (viewportFilteredTrackIndices.size() < 2) {
                return NO_TRACKS;
            }
            if (z) {
                str = null;
            } else {
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
            }
            filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, viewportFilteredTrackIndices);
            return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
        }
        return (int[]) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0011, code lost:
        if ((r7 > r8) != (r5 > r6)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (z) {
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
        return (Point) invokeCommon.objValue;
    }

    public static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{trackGroup, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
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
        return (List) invokeCommon.objValue;
    }

    public static boolean isSupported(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int i2 = i & 7;
            return i2 == 4 || (z && i2 == 3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSupportedAdaptiveAudioTrack(Format format, int i, AudioConfigurationTuple audioConfigurationTuple) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65552, null, format, i, audioConfigurationTuple)) == null) {
            if (isSupported(i, false) && format.channelCount == audioConfigurationTuple.channelCount && format.sampleRate == audioConfigurationTuple.sampleRate) {
                String str = audioConfigurationTuple.mimeType;
                return str == null || TextUtils.equals(str, format.sampleMimeType);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{format, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (!isSupported(i, false) || (i & i2) == 0) {
                return false;
            }
            if (str == null || Util.areEqual(format.sampleMimeType, str)) {
                int i6 = format.width;
                if (i6 == -1 || i6 <= i3) {
                    int i7 = format.height;
                    if (i7 == -1 || i7 <= i4) {
                        int i8 = format.bitrate;
                        return i8 == -1 || i8 <= i5;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65554, null, rendererCapabilities, trackGroupArray, iArr, parameters, factory)) == null) {
            int i = parameters.allowNonSeamlessAdaptiveness ? 24 : 16;
            boolean z = parameters.allowMixedMimeAdaptiveness && (rendererCapabilities.supportsMixedMimeTypeAdaptation() & i) != 0;
            for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
                TrackGroup trackGroup = trackGroupArray.get(i2);
                int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i2], z, i, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
                if (adaptiveVideoTracksForGroup.length > 0) {
                    return factory.createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
                }
            }
            return null;
        }
        return (TrackSelection) invokeLLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
        if (compareFormatValues(r2.bitrate, r10) < 0) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSelection selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        InterceptResult invokeLLL;
        int compareFormatValues;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, trackGroupArray, iArr, parameters)) == null) {
            TrackGroupArray trackGroupArray2 = trackGroupArray;
            int i4 = -1;
            int i5 = 0;
            TrackGroup trackGroup = null;
            int i6 = 0;
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            while (i5 < trackGroupArray2.length) {
                TrackGroup trackGroup2 = trackGroupArray2.get(i5);
                List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
                int[] iArr2 = iArr[i5];
                int i10 = 0;
                while (i10 < trackGroup2.length) {
                    if (isSupported(iArr2[i10], parameters.exceedRendererCapabilitiesIfNecessary)) {
                        Format format = trackGroup2.getFormat(i10);
                        boolean z = true;
                        boolean z2 = viewportFilteredTrackIndices.contains(Integer.valueOf(i10)) && ((i = format.width) == i4 || i <= parameters.maxVideoWidth) && (((i2 = format.height) == i4 || i2 <= parameters.maxVideoHeight) && ((i3 = format.bitrate) == i4 || i3 <= parameters.maxVideoBitrate));
                        if (z2 || parameters.exceedVideoConstraintsIfNecessary) {
                            int i11 = z2 ? 2 : 1;
                            boolean isSupported = isSupported(iArr2[i10], false);
                            if (isSupported) {
                                i11 += 1000;
                            }
                            boolean z3 = i11 > i7;
                            if (i11 == i7) {
                                if (!parameters.forceLowestBitrate) {
                                    int pixelCount = format.getPixelCount();
                                    if (pixelCount != i8) {
                                        compareFormatValues = compareFormatValues(pixelCount, i8);
                                    } else {
                                        compareFormatValues = compareFormatValues(format.bitrate, i9);
                                    }
                                    if (isSupported) {
                                    }
                                    z = false;
                                    z3 = z;
                                }
                            }
                            if (z3) {
                                i9 = format.bitrate;
                                i8 = format.getPixelCount();
                                trackGroup = trackGroup2;
                                i6 = i10;
                                i7 = i11;
                            }
                        }
                    }
                    i10++;
                    i4 = -1;
                }
                i5++;
                trackGroupArray2 = trackGroupArray;
                i4 = -1;
            }
            if (trackGroup == null) {
                return null;
            }
            return new FixedTrackSelection(trackGroup, i6);
        }
        return (TrackSelection) invokeLLL.objValue;
    }

    public Parameters getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.paramsReference.get() : (Parameters) invokeV.objValue;
    }

    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trackGroupArray, iArr, parameters, factory)) == null) {
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
        return (TrackSelection) invokeLLLL.objValue;
    }

    public TrackSelection selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), trackGroupArray, iArr, parameters})) == null) {
            TrackGroup trackGroup = null;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
                TrackGroup trackGroup2 = trackGroupArray.get(i4);
                int[] iArr2 = iArr[i4];
                for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                    if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                        int i6 = (trackGroup2.getFormat(i5).selectionFlags & 1) != 0 ? 2 : 1;
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
        return (TrackSelection) invokeCommon.objValue;
    }

    public TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, trackGroupArray, iArr, parameters)) == null) {
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
                        boolean z = (format.selectionFlags & 1) != 0;
                        boolean z2 = (format.selectionFlags & 2) != 0;
                        if (formatHasLanguage(format, parameters.preferredTextLanguage)) {
                            i5 = z ? 6 : !z2 ? 5 : 4;
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
        return (TrackSelection) invokeLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, rendererCapabilitiesArr, trackGroupArrayArr, iArr)) == null) {
            int length = rendererCapabilitiesArr.length;
            TrackSelection[] trackSelectionArr = new TrackSelection[length];
            Parameters parameters = this.paramsReference.get();
            boolean z = false;
            int i = 0;
            boolean z2 = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (2 == rendererCapabilitiesArr[i].getTrackType()) {
                    if (!z) {
                        trackSelectionArr[i] = selectVideoTrack(rendererCapabilitiesArr[i], trackGroupArrayArr[i], iArr[i], parameters, this.adaptiveTrackSelectionFactory);
                        z = trackSelectionArr[i] != null;
                    }
                    z2 |= trackGroupArrayArr[i].length > 0;
                }
                i++;
            }
            boolean z3 = false;
            boolean z4 = false;
            for (int i2 = 0; i2 < length; i2++) {
                int trackType = rendererCapabilitiesArr[i2].getTrackType();
                if (trackType != 1) {
                    if (trackType != 2) {
                        if (trackType != 3) {
                            trackSelectionArr[i2] = selectOtherTrack(rendererCapabilitiesArr[i2].getTrackType(), trackGroupArrayArr[i2], iArr[i2], parameters);
                        } else if (!z4) {
                            trackSelectionArr[i2] = selectTextTrack(trackGroupArrayArr[i2], iArr[i2], parameters);
                            z4 = trackSelectionArr[i2] != null;
                        }
                    }
                } else if (!z3) {
                    trackSelectionArr[i2] = selectAudioTrack(trackGroupArrayArr[i2], iArr[i2], parameters, z2 ? null : this.adaptiveTrackSelectionFactory);
                    z3 = trackSelectionArr[i2] != null;
                }
            }
            return trackSelectionArr;
        }
        return (TrackSelection[]) invokeLLL.objValue;
    }

    public TrackSelection selectVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, rendererCapabilities, trackGroupArray, iArr, parameters, factory)) == null) {
            TrackSelection selectAdaptiveVideoTrack = (parameters.forceLowestBitrate || factory == null) ? null : selectAdaptiveVideoTrack(rendererCapabilities, trackGroupArray, iArr, parameters, factory);
            return selectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : selectAdaptiveVideoTrack;
        }
        return (TrackSelection) invokeLLLLL.objValue;
    }

    public void setParameters(Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, parameters) == null) {
            Assertions.checkNotNull(parameters);
            if (this.paramsReference.getAndSet(parameters).equals(parameters)) {
                return;
            }
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this(new AdaptiveTrackSelection.Factory(bandwidthMeter));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bandwidthMeter};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TrackSelection.Factory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public DefaultTrackSelector(TrackSelection.Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {factory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.adaptiveTrackSelectionFactory = factory;
        this.paramsReference = new AtomicReference<>(new Parameters());
    }
}
