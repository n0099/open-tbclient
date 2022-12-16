package com.googlecode.mp4parser.authoring;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.util.Matrix;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class Movie {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix matrix;
    public List<Track> tracks;

    public Movie() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
    }

    public Matrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.matrix;
        }
        return (Matrix) invokeV.objValue;
    }

    public List<Track> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.tracks;
        }
        return (List) invokeV.objValue;
    }

    public Movie(List<Track> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
        this.tracks = list;
    }

    public Track getTrackByTrackId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            for (Track track : this.tracks) {
                if (track.getTrackMetaData().getTrackId() == j) {
                    return track;
                }
            }
            return null;
        }
        return (Track) invokeJ.objValue;
    }

    public static long gcd(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 == 0) {
                return j;
            }
            return gcd(j2, j % j2);
        }
        return invokeCommon.longValue;
    }

    public void addTrack(Track track) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, track) == null) {
            if (getTrackByTrackId(track.getTrackMetaData().getTrackId()) != null) {
                track.getTrackMetaData().setTrackId(getNextTrackId());
            }
            this.tracks.add(track);
        }
    }

    public void setMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, matrix) == null) {
            this.matrix = matrix;
        }
    }

    public void setTracks(List<Track> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.tracks = list;
        }
    }

    public long getNextTrackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = 0;
            for (Track track : this.tracks) {
                if (j < track.getTrackMetaData().getTrackId()) {
                    j = track.getTrackMetaData().getTrackId();
                }
            }
            return j + 1;
        }
        return invokeV.longValue;
    }

    public long getTimescale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long timescale = getTracks().iterator().next().getTrackMetaData().getTimescale();
            for (Track track : getTracks()) {
                timescale = gcd(track.getTrackMetaData().getTimescale(), timescale);
            }
            return timescale;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = "Movie{ ";
            for (Track track : this.tracks) {
                str = String.valueOf(str) + "track_" + track.getTrackMetaData().getTrackId() + " (" + track.getHandler() + ") ";
            }
            return String.valueOf(str) + '}';
        }
        return (String) invokeV.objValue;
    }
}
