package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, trackSelection, i, exc)) == null) {
            return maybeBlacklistTrack(trackSelection, i, exc, 60000L);
        }
        return invokeLIL.booleanValue;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{trackSelection, Integer.valueOf(i), exc, Long.valueOf(j)})) == null) {
            if (shouldBlacklist(exc)) {
                boolean blacklist = trackSelection.blacklist(i, j);
                int i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
                if (blacklist) {
                    Log.w(TAG, "Blacklisted: duration=" + j + ", responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
                } else {
                    Log.w(TAG, "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
                }
                return blacklist;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean shouldBlacklist(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) {
            if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
                return false;
            }
            int i = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
            if (i != 404 && i != 410) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
