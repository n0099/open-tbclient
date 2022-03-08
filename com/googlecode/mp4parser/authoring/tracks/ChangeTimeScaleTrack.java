package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class ChangeTimeScaleTrack implements Track {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CompositionTimeToSample.Entry> ctts;
    public long[] decodingTimes;
    public Track source;
    public long timeScale;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168031772, "Lcom/googlecode/mp4parser/authoring/tracks/ChangeTimeScaleTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1168031772, "Lcom/googlecode/mp4parser/authoring/tracks/ChangeTimeScaleTrack;");
                return;
            }
        }
        LOG = Logger.getLogger(ChangeTimeScaleTrack.class.getName());
    }

    public ChangeTimeScaleTrack(Track track, long j2, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {track, Long.valueOf(j2), jArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = track;
        this.timeScale = j2;
        double timescale = j2 / track.getTrackMetaData().getTimescale();
        this.ctts = adjustCtts(track.getCompositionTimeEntries(), timescale);
        this.decodingTimes = adjustTts(track.getSampleDurations(), timescale, jArr, getTimes(track, jArr, j2));
    }

    public static List<CompositionTimeToSample.Entry> adjustCtts(List<CompositionTimeToSample.Entry> list, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, Double.valueOf(d2)})) == null) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (CompositionTimeToSample.Entry entry : list) {
                    arrayList.add(new CompositionTimeToSample.Entry(entry.getCount(), (int) Math.round(entry.getOffset() * d2)));
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static long[] adjustTts(long[] jArr, double d2, long[] jArr2, long[] jArr3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jArr, Double.valueOf(d2), jArr2, jArr3})) == null) {
            long[] jArr4 = new long[jArr.length];
            long j2 = 0;
            int i2 = 1;
            while (i2 <= jArr.length) {
                int i3 = i2 - 1;
                long round = Math.round(jArr[i3] * d2);
                int i4 = i2 + 1;
                int binarySearch = Arrays.binarySearch(jArr2, i4);
                if (binarySearch >= 0 && jArr3[binarySearch] != j2) {
                    long j3 = jArr3[binarySearch] - (j2 + round);
                    LOG.finest(String.format("Sample %d %d / %d - correct by %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(jArr3[binarySearch]), Long.valueOf(j3)));
                    round += j3;
                }
                j2 += round;
                jArr4[i3] = round;
                i2 = i4;
            }
            return jArr4;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static long[] getTimes(Track track, long[] jArr, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{track, jArr, Long.valueOf(j2)})) != null) {
            return (long[]) invokeCommon.objValue;
        }
        long[] jArr2 = new long[jArr.length];
        long j3 = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            long j4 = i3;
            if (j4 > jArr[jArr.length - 1]) {
                return jArr2;
            }
            if (j4 == jArr[i2]) {
                jArr2[i2] = (j3 * j2) / track.getTrackMetaData().getTimescale();
                i2++;
            }
            j3 += track.getSampleDurations()[i3 - 1];
            i3++;
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ctts : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = 0;
            for (long j3 : this.decodingTimes) {
                j2 += j3;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.source.getHandler() : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.source.getMediaHeaderBox() : (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.source.getSampleDependencies() : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.source.getSampleDescriptionBox() : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.decodingTimes : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.source.getSamples() : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.source.getSubsampleInformationBox() : (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.source.getSyncSamples() : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TrackMetaData trackMetaData = (TrackMetaData) this.source.getTrackMetaData().clone();
            trackMetaData.setTimescale(this.timeScale);
            return trackMetaData;
        }
        return (TrackMetaData) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "ChangeTimeScaleTrack{source=" + this.source + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
