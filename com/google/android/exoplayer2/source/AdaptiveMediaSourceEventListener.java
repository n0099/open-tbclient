package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface AdaptiveMediaSourceEventListener {

    /* loaded from: classes7.dex */
    public static final class EventDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler handler;
        public final AdaptiveMediaSourceEventListener listener;
        public final long mediaTimeOffsetMs;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EventDispatcher(Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
            this(handler, adaptiveMediaSourceEventListener, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, adaptiveMediaSourceEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Handler) objArr2[0], (AdaptiveMediaSourceEventListener) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long adjustMediaTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j)) == null) {
                long usToMs = C.usToMs(j);
                return usToMs == C.TIME_UNSET ? C.TIME_UNSET : this.mediaTimeOffsetMs + usToMs;
            }
            return invokeJ.longValue;
        }

        public EventDispatcher copyWithMediaTimeOffsetMs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? new EventDispatcher(this.handler, this.listener, j) : (EventDispatcher) invokeJ.objValue;
        }

        public void downstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), format, Integer.valueOf(i2), obj, Long.valueOf(j)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, i, format, i2, obj, j) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ long val$mediaTimeUs;
                public final /* synthetic */ Format val$trackFormat;
                public final /* synthetic */ Object val$trackSelectionData;
                public final /* synthetic */ int val$trackSelectionReason;
                public final /* synthetic */ int val$trackType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), format, Integer.valueOf(i2), obj, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$trackType = i;
                    this.val$trackFormat = format;
                    this.val$trackSelectionReason = i2;
                    this.val$trackSelectionData = obj;
                    this.val$mediaTimeUs = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onDownstreamFormatChanged(this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, this.this$0.adjustMediaTime(this.val$mediaTimeUs));
                    }
                }
            });
        }

        public void loadCanceled(DataSpec dataSpec, int i, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{dataSpec, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                loadCanceled(dataSpec, i, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3);
            }
        }

        public void loadCompleted(DataSpec dataSpec, int i, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{dataSpec, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                loadCompleted(dataSpec, i, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3);
            }
        }

        public void loadError(DataSpec dataSpec, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{dataSpec, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iOException, Boolean.valueOf(z)}) == null) {
                loadError(dataSpec, i, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3, iOException, z);
            }
        }

        public void loadStarted(DataSpec dataSpec, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{dataSpec, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                loadStarted(dataSpec, i, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j);
            }
        }

        public void upstreamDiscarded(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, i, j, j2) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ long val$mediaEndTimeUs;
                public final /* synthetic */ long val$mediaStartTimeUs;
                public final /* synthetic */ int val$trackType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$trackType = i;
                    this.val$mediaStartTimeUs = j;
                    this.val$mediaEndTimeUs = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onUpstreamDiscarded(this.val$trackType, this.this$0.adjustMediaTime(this.val$mediaStartTimeUs), this.this$0.adjustMediaTime(this.val$mediaEndTimeUs));
                    }
                }
            });
        }

        public EventDispatcher(Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, adaptiveMediaSourceEventListener, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.handler = adaptiveMediaSourceEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = adaptiveMediaSourceEventListener;
            this.mediaTimeOffsetMs = j;
        }

        public void loadCanceled(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ long val$bytesLoaded;
                public final /* synthetic */ DataSpec val$dataSpec;
                public final /* synthetic */ int val$dataType;
                public final /* synthetic */ long val$elapsedRealtimeMs;
                public final /* synthetic */ long val$loadDurationMs;
                public final /* synthetic */ long val$mediaEndTimeUs;
                public final /* synthetic */ long val$mediaStartTimeUs;
                public final /* synthetic */ Format val$trackFormat;
                public final /* synthetic */ Object val$trackSelectionData;
                public final /* synthetic */ int val$trackSelectionReason;
                public final /* synthetic */ int val$trackType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataSpec = dataSpec;
                    this.val$dataType = i;
                    this.val$trackType = i2;
                    this.val$trackFormat = format;
                    this.val$trackSelectionReason = i3;
                    this.val$trackSelectionData = obj;
                    this.val$mediaStartTimeUs = j;
                    this.val$mediaEndTimeUs = j2;
                    this.val$elapsedRealtimeMs = j3;
                    this.val$loadDurationMs = j4;
                    this.val$bytesLoaded = j5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onLoadCanceled(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, this.this$0.adjustMediaTime(this.val$mediaStartTimeUs), this.this$0.adjustMediaTime(this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs, this.val$loadDurationMs, this.val$bytesLoaded);
                    }
                }
            });
        }

        public void loadCompleted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ long val$bytesLoaded;
                public final /* synthetic */ DataSpec val$dataSpec;
                public final /* synthetic */ int val$dataType;
                public final /* synthetic */ long val$elapsedRealtimeMs;
                public final /* synthetic */ long val$loadDurationMs;
                public final /* synthetic */ long val$mediaEndTimeUs;
                public final /* synthetic */ long val$mediaStartTimeUs;
                public final /* synthetic */ Format val$trackFormat;
                public final /* synthetic */ Object val$trackSelectionData;
                public final /* synthetic */ int val$trackSelectionReason;
                public final /* synthetic */ int val$trackType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataSpec = dataSpec;
                    this.val$dataType = i;
                    this.val$trackType = i2;
                    this.val$trackFormat = format;
                    this.val$trackSelectionReason = i3;
                    this.val$trackSelectionData = obj;
                    this.val$mediaStartTimeUs = j;
                    this.val$mediaEndTimeUs = j2;
                    this.val$elapsedRealtimeMs = j3;
                    this.val$loadDurationMs = j4;
                    this.val$bytesLoaded = j5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onLoadCompleted(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, this.this$0.adjustMediaTime(this.val$mediaStartTimeUs), this.this$0.adjustMediaTime(this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs, this.val$loadDurationMs, this.val$bytesLoaded);
                    }
                }
            });
        }

        public void loadError(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5, iOException, z) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ long val$bytesLoaded;
                public final /* synthetic */ DataSpec val$dataSpec;
                public final /* synthetic */ int val$dataType;
                public final /* synthetic */ long val$elapsedRealtimeMs;
                public final /* synthetic */ IOException val$error;
                public final /* synthetic */ long val$loadDurationMs;
                public final /* synthetic */ long val$mediaEndTimeUs;
                public final /* synthetic */ long val$mediaStartTimeUs;
                public final /* synthetic */ Format val$trackFormat;
                public final /* synthetic */ Object val$trackSelectionData;
                public final /* synthetic */ int val$trackSelectionReason;
                public final /* synthetic */ int val$trackType;
                public final /* synthetic */ boolean val$wasCanceled;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataSpec = dataSpec;
                    this.val$dataType = i;
                    this.val$trackType = i2;
                    this.val$trackFormat = format;
                    this.val$trackSelectionReason = i3;
                    this.val$trackSelectionData = obj;
                    this.val$mediaStartTimeUs = j;
                    this.val$mediaEndTimeUs = j2;
                    this.val$elapsedRealtimeMs = j3;
                    this.val$loadDurationMs = j4;
                    this.val$bytesLoaded = j5;
                    this.val$error = iOException;
                    this.val$wasCanceled = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onLoadError(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, this.this$0.adjustMediaTime(this.val$mediaStartTimeUs), this.this$0.adjustMediaTime(this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs, this.val$loadDurationMs, this.val$bytesLoaded, this.val$error, this.val$wasCanceled);
                    }
                }
            });
        }

        public void loadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.listener == null) {
                return;
            }
            this.handler.post(new Runnable(this, dataSpec, i, i2, format, i3, obj, j, j2, j3) { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventDispatcher this$0;
                public final /* synthetic */ DataSpec val$dataSpec;
                public final /* synthetic */ int val$dataType;
                public final /* synthetic */ long val$elapsedRealtimeMs;
                public final /* synthetic */ long val$mediaEndTimeUs;
                public final /* synthetic */ long val$mediaStartTimeUs;
                public final /* synthetic */ Format val$trackFormat;
                public final /* synthetic */ Object val$trackSelectionData;
                public final /* synthetic */ int val$trackSelectionReason;
                public final /* synthetic */ int val$trackType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r4;
                        Object[] objArr = {this, dataSpec, Integer.valueOf(i), Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataSpec = dataSpec;
                    this.val$dataType = i;
                    this.val$trackType = i2;
                    this.val$trackFormat = format;
                    this.val$trackSelectionReason = i3;
                    this.val$trackSelectionData = obj;
                    this.val$mediaStartTimeUs = j;
                    this.val$mediaEndTimeUs = j2;
                    this.val$elapsedRealtimeMs = j3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.listener.onLoadStarted(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, this.this$0.adjustMediaTime(this.val$mediaStartTimeUs), this.this$0.adjustMediaTime(this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs);
                    }
                }
            });
        }
    }

    void onDownstreamFormatChanged(int i, Format format, int i2, Object obj, long j);

    void onLoadCanceled(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadCompleted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadError(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void onLoadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void onUpstreamDiscarded(int i, long j, long j2);
}
