package com.google.android.exoplayer2;

import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes4.dex */
public final class DefaultLoadControl implements LoadControl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ABOVE_HIGH_WATERMARK = 0;
    public static final int BELOW_LOW_WATERMARK = 2;
    public static final int BETWEEN_WATERMARKS = 1;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 30000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public transient /* synthetic */ FieldHolder $fh;
    public final DefaultAllocator allocator;
    public final long bufferForPlaybackAfterRebufferUs;
    public final long bufferForPlaybackUs;
    public boolean isBuffering;
    public final long maxBufferUs;
    public final long minBufferUs;
    public final PriorityTaskManager priorityTaskManager;
    public int targetBufferSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((DefaultAllocator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getBufferTimeState(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j)) == null) {
            if (j > this.maxBufferUs) {
                return 0;
            }
            return j < this.minBufferUs ? 2 : 1;
        }
        return invokeJ.intValue;
    }

    private void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            this.targetBufferSize = 0;
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager != null && this.isBuffering) {
                priorityTaskManager.remove(0);
            }
            this.isBuffering = false;
            if (z) {
                this.allocator.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.allocator : (Allocator) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            reset(false);
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            reset(true);
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            reset(true);
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, rendererArr, trackGroupArray, trackSelectionArray) == null) {
            this.targetBufferSize = 0;
            for (int i = 0; i < rendererArr.length; i++) {
                if (trackSelectionArray.get(i) != null) {
                    this.targetBufferSize += Util.getDefaultBufferSize(rendererArr[i].getTrackType());
                }
            }
            this.allocator.setTargetBufferSize(this.targetBufferSize);
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            int bufferTimeState = getBufferTimeState(j);
            boolean z = true;
            boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
            boolean z3 = this.isBuffering;
            if (bufferTimeState != 2 && (bufferTimeState != 1 || !z3 || z2)) {
                z = false;
            }
            this.isBuffering = z;
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager != null && z != z3) {
                if (z) {
                    priorityTaskManager.add(0);
                } else {
                    priorityTaskManager.remove(0);
                }
            }
            return this.isBuffering;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            long j2 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
            return j2 <= 0 || j >= j2;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, 30000, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, 5000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultAllocator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DefaultAllocator) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, long j, long j2) {
        this(defaultAllocator, i, i2, j, j2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultAllocator, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DefaultAllocator) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (PriorityTaskManager) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, long j, long j2, PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultAllocator, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), priorityTaskManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.allocator = defaultAllocator;
        this.minBufferUs = i * 1000;
        this.maxBufferUs = i2 * 1000;
        this.bufferForPlaybackUs = j * 1000;
        this.bufferForPlaybackAfterRebufferUs = j2 * 1000;
        this.priorityTaskManager = priorityTaskManager;
    }
}
