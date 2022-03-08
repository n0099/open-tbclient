package com.google.android.exoplayer2.source.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes7.dex */
public final class ChunkedTrackBlacklistUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public static final String TAG = "ChunkedTrackBlacklist";
    public transient /* synthetic */ FieldHolder $fh;

    public ChunkedTrackBlacklistUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i2, Exception exc) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, trackSelection, i2, exc)) == null) ? maybeBlacklistTrack(trackSelection, i2, exc, 60000L) : invokeLIL.booleanValue;
    }

    public static boolean shouldBlacklist(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) {
            if (exc instanceof HttpDataSource.InvalidResponseCodeException) {
                int i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
                return i2 == 404 || i2 == 410;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i2, Exception exc, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{trackSelection, Integer.valueOf(i2), exc, Long.valueOf(j2)})) == null) {
            if (shouldBlacklist(exc)) {
                boolean blacklist = trackSelection.blacklist(i2, j2);
                int i3 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
                if (blacklist) {
                    String str = "Blacklisted: duration=" + j2 + ", responseCode=" + i3 + ", format=" + trackSelection.getFormat(i2);
                } else {
                    String str2 = "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i3 + ", format=" + trackSelection.getFormat(i2);
                }
                return blacklist;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
