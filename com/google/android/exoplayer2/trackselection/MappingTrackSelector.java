package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class MappingTrackSelector extends TrackSelector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MappedTrackInfo currentMappedTrackInfo;
    public final SparseBooleanArray rendererDisabledFlags;
    public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
    public int tunnelingAudioSessionId;

    /* loaded from: classes7.dex */
    public static final class SelectionOverride {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TrackSelection.Factory factory;
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(TrackSelection.Factory factory, int i2, int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {factory, Integer.valueOf(i2), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.factory = factory;
            this.groupIndex = i2;
            this.tracks = iArr;
            this.length = iArr.length;
        }

        public boolean containsTrack(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                for (int i3 : this.tracks) {
                    if (i3 == i2) {
                        return true;
                    }
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        public TrackSelection createTrackSelection(TrackGroupArray trackGroupArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trackGroupArray)) == null) ? this.factory.createTrackSelection(trackGroupArray.get(this.groupIndex), this.tracks) : (TrackSelection) invokeL.objValue;
        }
    }

    public MappingTrackSelector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.selectionOverrides = new SparseArray<>();
        this.rendererDisabledFlags = new SparseBooleanArray();
        this.tunnelingAudioSessionId = 0;
    }

    private boolean[] determineEnabledRenderers(RendererCapabilities[] rendererCapabilitiesArr, TrackSelection[] trackSelectionArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, rendererCapabilitiesArr, trackSelectionArr)) == null) {
            int length = trackSelectionArr.length;
            boolean[] zArr = new boolean[length];
            for (int i2 = 0; i2 < length; i2++) {
                zArr[i2] = !this.rendererDisabledFlags.get(i2) && (rendererCapabilitiesArr[i2].getTrackType() == 5 || trackSelectionArr[i2] != null);
            }
            return zArr;
        }
        return (boolean[]) invokeLL.objValue;
    }

    public static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, rendererCapabilitiesArr, trackGroup)) == null) {
            int length = rendererCapabilitiesArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < rendererCapabilitiesArr.length; i3++) {
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i3];
                for (int i4 = 0; i4 < trackGroup.length; i4++) {
                    int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i4)) & 7;
                    if (supportsFormat > i2) {
                        if (supportsFormat == 4) {
                            return i3;
                        }
                        length = i3;
                        i2 = supportsFormat;
                    }
                }
            }
            return length;
        }
        return invokeLL.intValue;
    }

    public static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, rendererCapabilities, trackGroup)) == null) {
            int[] iArr = new int[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                iArr[i2] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i2));
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rendererCapabilitiesArr)) == null) {
            int length = rendererCapabilitiesArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = rendererCapabilitiesArr[i2].supportsMixedMimeTypeAdaptation();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static void maybeConfigureRenderersForTunneling(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{rendererCapabilitiesArr, trackGroupArrayArr, iArr, rendererConfigurationArr, trackSelectionArr, Integer.valueOf(i2)}) == null) || i2 == 0) {
            return;
        }
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < rendererCapabilitiesArr.length; i5++) {
            int trackType = rendererCapabilitiesArr[i5].getTrackType();
            TrackSelection trackSelection = trackSelectionArr[i5];
            if ((trackType == 1 || trackType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i5], trackGroupArrayArr[i5], trackSelection)) {
                if (trackType == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i5;
                } else if (i3 != -1) {
                    z = false;
                    break;
                } else {
                    i3 = i5;
                }
            }
        }
        z = true;
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(i2);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    public static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, iArr, trackGroupArray, trackSelection)) == null) {
            if (trackSelection == null) {
                return false;
            }
            int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
            for (int i2 = 0; i2 < trackSelection.length(); i2++) {
                if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i2)] & 32) != 32) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void clearSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, trackGroupArray) == null) && (map = this.selectionOverrides.get(i2)) != null && map.containsKey(trackGroupArray)) {
            map.remove(trackGroupArray);
            if (map.isEmpty()) {
                this.selectionOverrides.remove(i2);
            }
            invalidate();
        }
    }

    public final void clearSelectionOverrides(int i2) {
        Map<TrackGroupArray, SelectionOverride> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (map = this.selectionOverrides.get(i2)) == null || map.isEmpty()) {
            return;
        }
        this.selectionOverrides.remove(i2);
        invalidate();
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.currentMappedTrackInfo : (MappedTrackInfo) invokeV.objValue;
    }

    public final boolean getRendererDisabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.rendererDisabledFlags.get(i2) : invokeI.booleanValue;
    }

    public final SelectionOverride getSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, trackGroupArray)) == null) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i2);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }
        return (SelectionOverride) invokeIL.objValue;
    }

    public final boolean hasSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, trackGroupArray)) == null) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i2);
            return map != null && map.containsKey(trackGroupArray);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.currentMappedTrackInfo = (MappedTrackInfo) obj;
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rendererCapabilitiesArr, trackGroupArray)) == null) {
            int[] iArr = new int[rendererCapabilitiesArr.length + 1];
            int length = rendererCapabilitiesArr.length + 1;
            TrackGroup[][] trackGroupArr = new TrackGroup[length];
            int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = trackGroupArray.length;
                trackGroupArr[i2] = new TrackGroup[i3];
                iArr2[i2] = new int[i3];
            }
            int[] mixedMimeTypeAdaptationSupport = getMixedMimeTypeAdaptationSupport(rendererCapabilitiesArr);
            for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
                TrackGroup trackGroup = trackGroupArray.get(i4);
                int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
                int[] formatSupport = findRenderer == rendererCapabilitiesArr.length ? new int[trackGroup.length] : getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
                int i5 = iArr[findRenderer];
                trackGroupArr[findRenderer][i5] = trackGroup;
                iArr2[findRenderer][i5] = formatSupport;
                iArr[findRenderer] = iArr[findRenderer] + 1;
            }
            TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
            int[] iArr3 = new int[rendererCapabilitiesArr.length];
            for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
                int i7 = iArr[i6];
                trackGroupArrayArr[i6] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[i6], i7));
                iArr2[i6] = (int[][]) Arrays.copyOf(iArr2[i6], i7);
                iArr3[i6] = rendererCapabilitiesArr[i6].getTrackType();
            }
            TrackGroupArray trackGroupArray2 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length]));
            TrackSelection[] selectTracks = selectTracks(rendererCapabilitiesArr, trackGroupArrayArr, iArr2);
            int i8 = 0;
            while (true) {
                if (i8 >= rendererCapabilitiesArr.length) {
                    break;
                }
                if (this.rendererDisabledFlags.get(i8)) {
                    selectTracks[i8] = null;
                } else {
                    TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i8];
                    if (hasSelectionOverride(i8, trackGroupArray3)) {
                        SelectionOverride selectionOverride = this.selectionOverrides.get(i8).get(trackGroupArray3);
                        selectTracks[i8] = selectionOverride != null ? selectionOverride.createTrackSelection(trackGroupArray3) : null;
                    }
                }
                i8++;
            }
            boolean[] determineEnabledRenderers = determineEnabledRenderers(rendererCapabilitiesArr, selectTracks);
            MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupport, iArr2, trackGroupArray2);
            RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCapabilitiesArr.length];
            for (int i9 = 0; i9 < rendererCapabilitiesArr.length; i9++) {
                rendererConfigurationArr[i9] = determineEnabledRenderers[i9] ? RendererConfiguration.DEFAULT : null;
            }
            maybeConfigureRenderersForTunneling(rendererCapabilitiesArr, trackGroupArrayArr, iArr2, rendererConfigurationArr, selectTracks, this.tunnelingAudioSessionId);
            return new TrackSelectorResult(trackGroupArray, determineEnabledRenderers, new TrackSelectionArray(selectTracks), mappedTrackInfo, rendererConfigurationArr);
        }
        return (TrackSelectorResult) invokeLL.objValue;
    }

    public abstract TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException;

    public final void setRendererDisabled(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.rendererDisabledFlags.get(i2) == z) {
            return;
        }
        this.rendererDisabledFlags.put(i2, z);
        invalidate();
    }

    public final void setSelectionOverride(int i2, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, trackGroupArray, selectionOverride) == null) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i2);
            if (map == null) {
                map = new HashMap<>();
                this.selectionOverrides.put(i2, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return;
            }
            map.put(trackGroupArray, selectionOverride);
            invalidate();
        }
    }

    public void setTunnelingAudioSessionId(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.tunnelingAudioSessionId == i2) {
            return;
        }
        this.tunnelingAudioSessionId = i2;
        invalidate();
    }

    public final void clearSelectionOverrides() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.selectionOverrides.size() == 0) {
            return;
        }
        this.selectionOverrides.clear();
        invalidate();
    }

    /* loaded from: classes7.dex */
    public static final class MappedTrackInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[][][] formatSupport;
        public final int length;
        public final int[] mixedMimeTypeAdaptiveSupport;
        public final int[] rendererTrackTypes;
        public final TrackGroupArray[] trackGroups;
        public final TrackGroupArray unassociatedTrackGroups;

        public MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, trackGroupArrayArr, iArr2, iArr3, trackGroupArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.rendererTrackTypes = iArr;
            this.trackGroups = trackGroupArrayArr;
            this.formatSupport = iArr3;
            this.mixedMimeTypeAdaptiveSupport = iArr2;
            this.unassociatedTrackGroups = trackGroupArray;
            this.length = trackGroupArrayArr.length;
        }

        public int getAdaptiveSupport(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.trackGroups[i2].get(i3).length;
                int[] iArr = new int[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i4; i6++) {
                    int trackFormatSupport = getTrackFormatSupport(i2, i3, i6);
                    if (trackFormatSupport == 4 || (z && trackFormatSupport == 3)) {
                        iArr[i5] = i6;
                        i5++;
                    }
                }
                return getAdaptiveSupport(i2, i3, Arrays.copyOf(iArr, i5));
            }
            return invokeCommon.intValue;
        }

        public int getRendererSupport(int i2) {
            InterceptResult invokeI;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int[][] iArr = this.formatSupport[i2];
                int i4 = 0;
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    for (int i6 = 0; i6 < iArr[i5].length; i6++) {
                        int i7 = iArr[i5][i6] & 7;
                        if (i7 == 3) {
                            i3 = 2;
                        } else if (i7 == 4) {
                            return 3;
                        } else {
                            i3 = 1;
                        }
                        i4 = Math.max(i4, i3);
                    }
                }
                return i4;
            }
            return invokeI.intValue;
        }

        public int getTrackFormatSupport(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i2, i3, i4)) == null) ? this.formatSupport[i2][i3][i4] & 7 : invokeIII.intValue;
        }

        public TrackGroupArray getTrackGroups(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.trackGroups[i2] : (TrackGroupArray) invokeI.objValue;
        }

        public int getTrackTypeRendererSupport(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.length; i4++) {
                    if (this.rendererTrackTypes[i4] == i2) {
                        i3 = Math.max(i3, getRendererSupport(i4));
                    }
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public TrackGroupArray getUnassociatedTrackGroups() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.unassociatedTrackGroups : (TrackGroupArray) invokeV.objValue;
        }

        public int getAdaptiveSupport(int i2, int i3, int[] iArr) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, iArr)) == null) {
                int i4 = 0;
                String str = null;
                boolean z = false;
                int i5 = 0;
                int i6 = 16;
                while (i4 < iArr.length) {
                    String str2 = this.trackGroups[i2].get(i3).getFormat(iArr[i4]).sampleMimeType;
                    int i7 = i5 + 1;
                    if (i5 == 0) {
                        str = str2;
                    } else {
                        z |= !Util.areEqual(str, str2);
                    }
                    i6 = Math.min(i6, this.formatSupport[i2][i3][i4] & 24);
                    i4++;
                    i5 = i7;
                }
                return z ? Math.min(i6, this.mixedMimeTypeAdaptiveSupport[i2]) : i6;
            }
            return invokeIIL.intValue;
        }
    }
}
