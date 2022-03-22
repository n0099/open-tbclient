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

    public TwoSecondIntersectionFinder(Movie movie, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movie, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fragmentLength = 2;
        this.movie = movie;
        this.fragmentLength = i;
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
            int i = 1;
            int ceil = ((int) Math.ceil(d2 / this.fragmentLength)) - 1;
            int i2 = ceil < 1 ? 1 : ceil;
            long[] jArr = new long[i2];
            Arrays.fill(jArr, -1L);
            int i3 = 0;
            jArr[0] = 1;
            long j = 0;
            long[] sampleDurations = track.getSampleDurations();
            int length = sampleDurations.length;
            int i4 = 0;
            while (i3 < length) {
                long j2 = sampleDurations[i3];
                int timescale = ((int) ((j / track.getTrackMetaData().getTimescale()) / this.fragmentLength)) + i;
                if (timescale >= i2) {
                    break;
                }
                i4++;
                jArr[timescale] = i4;
                j += j2;
                i3++;
                i2 = i2;
                i = 1;
            }
            long j3 = i4 + i;
            for (int i5 = i2 - i; i5 >= 0; i5--) {
                if (jArr[i5] == -1) {
                    jArr[i5] = j3;
                }
                j3 = jArr[i5];
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }
}
