package com.googlecode.mp4parser.authoring.builder;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class TwoSecondIntersectionFinder implements FragmentIntersectionFinder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int fragmentLength;
    public Movie movie;

    public TwoSecondIntersectionFinder(Movie movie, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movie, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fragmentLength = 2;
        this.movie = movie;
        this.fragmentLength = i2;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, track)) == null) {
            double d2 = 0.0d;
            for (Track track2 : this.movie.getTracks()) {
                double duration = track2.getDuration() / track2.getTrackMetaData().getTimescale();
                if (d2 < duration) {
                    d2 = duration;
                }
            }
            int i2 = 1;
            int ceil = ((int) Math.ceil(d2 / this.fragmentLength)) - 1;
            int i3 = ceil < 1 ? 1 : ceil;
            long[] jArr = new long[i3];
            Arrays.fill(jArr, -1L);
            int i4 = 0;
            jArr[0] = 1;
            long j = 0;
            long[] sampleDurations = track.getSampleDurations();
            int length = sampleDurations.length;
            int i5 = 0;
            while (i4 < length) {
                long j2 = sampleDurations[i4];
                int timescale = ((int) ((j / track.getTrackMetaData().getTimescale()) / this.fragmentLength)) + i2;
                if (timescale >= i3) {
                    break;
                }
                i5++;
                jArr[timescale] = i5;
                j += j2;
                i4++;
                i3 = i3;
                i2 = 1;
            }
            long j3 = i5 + i2;
            for (int i6 = i3 - i2; i6 >= 0; i6--) {
                if (jArr[i6] == -1) {
                    jArr[i6] = j3;
                }
                j3 = jArr[i6];
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }
}
