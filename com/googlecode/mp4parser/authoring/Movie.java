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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
    }

    public static long gcd(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j3 == 0 ? j2 : gcd(j3, j2 % j3) : invokeCommon.longValue;
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

    public Matrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.matrix : (Matrix) invokeV.objValue;
    }

    public long getNextTrackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = 0;
            for (Track track : this.tracks) {
                if (j2 < track.getTrackMetaData().getTrackId()) {
                    j2 = track.getTrackMetaData().getTrackId();
                }
            }
            return j2 + 1;
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

    public Track getTrackByTrackId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            for (Track track : this.tracks) {
                if (track.getTrackMetaData().getTrackId() == j2) {
                    return track;
                }
            }
            return null;
        }
        return (Track) invokeJ.objValue;
    }

    public List<Track> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tracks : (List) invokeV.objValue;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = "Movie{ ";
            for (Track track : this.tracks) {
                str = String.valueOf(str) + "track_" + track.getTrackMetaData().getTrackId() + " (" + track.getHandler() + ") ";
            }
            return String.valueOf(str) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public Movie(List<Track> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
        this.tracks = list;
    }
}
