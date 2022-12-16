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
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes8.dex */
public class CroppedTrack extends AbstractTrack {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int fromSample;
    public Track origTrack;
    public int toSample;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(11060590, "Lcom/googlecode/mp4parser/authoring/tracks/CroppedTrack;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(11060590, "Lcom/googlecode/mp4parser/authoring/tracks/CroppedTrack;");
        }
    }

    public CroppedTrack(Track track, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {track, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.origTrack = track;
        this.fromSample = (int) j;
        this.toSample = (int) j2;
    }

    public static List<CompositionTimeToSample.Entry> getCompositionTimeEntries(List<CompositionTimeToSample.Entry> list, long j, long j2) {
        InterceptResult invokeCommon;
        CompositionTimeToSample.Entry next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (list != null && !list.isEmpty()) {
                long j3 = 0;
                ListIterator<CompositionTimeToSample.Entry> listIterator = list.listIterator();
                ArrayList arrayList = new ArrayList();
                while (true) {
                    next = listIterator.next();
                    if (next.getCount() + j3 > j) {
                        break;
                    }
                    j3 += next.getCount();
                }
                if (next.getCount() + j3 >= j2) {
                    arrayList.add(new CompositionTimeToSample.Entry((int) (j2 - j), next.getOffset()));
                    return arrayList;
                }
                arrayList.add(new CompositionTimeToSample.Entry((int) ((next.getCount() + j3) - j), next.getOffset()));
                int count = next.getCount();
                while (true) {
                    j3 += count;
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    next = listIterator.next();
                    if (next.getCount() + j3 >= j2) {
                        break;
                    }
                    arrayList.add(next);
                    count = next.getCount();
                }
                arrayList.add(new CompositionTimeToSample.Entry((int) (j2 - j3), next.getOffset()));
                return arrayList;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static List<TimeToSampleBox.Entry> getDecodingTimeEntries(List<TimeToSampleBox.Entry> list, long j, long j2) {
        InterceptResult invokeCommon;
        TimeToSampleBox.Entry next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{list, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (list != null && !list.isEmpty()) {
                long j3 = 0;
                ListIterator<TimeToSampleBox.Entry> listIterator = list.listIterator();
                LinkedList linkedList = new LinkedList();
                while (true) {
                    next = listIterator.next();
                    if (next.getCount() + j3 > j) {
                        break;
                    }
                    j3 += next.getCount();
                }
                if (next.getCount() + j3 >= j2) {
                    linkedList.add(new TimeToSampleBox.Entry(j2 - j, next.getDelta()));
                    return linkedList;
                }
                linkedList.add(new TimeToSampleBox.Entry((next.getCount() + j3) - j, next.getDelta()));
                long count = next.getCount();
                while (true) {
                    j3 += count;
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    next = listIterator.next();
                    if (next.getCount() + j3 >= j2) {
                        break;
                    }
                    linkedList.add(next);
                    count = next.getCount();
                }
                linkedList.add(new TimeToSampleBox.Entry(j2 - j3, next.getDelta()));
                return linkedList;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getCompositionTimeEntries(this.origTrack.getCompositionTimeEntries(), this.fromSample, this.toSample);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.origTrack.getHandler();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.origTrack.getMediaHeaderBox();
        }
        return (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.origTrack.getSampleDescriptionBox();
        }
        return (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        InterceptResult invokeV;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                int i = this.toSample - this.fromSample;
                jArr = new long[i];
                System.arraycopy(this.origTrack.getSampleDurations(), this.fromSample, jArr, 0, i);
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.origTrack.getSamples().subList(this.fromSample, this.toSample);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.origTrack.getSubsampleInformationBox();
        }
        return (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.origTrack.getTrackMetaData();
        }
        return (TrackMetaData) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.origTrack.getSampleDependencies() != null && !this.origTrack.getSampleDependencies().isEmpty()) {
                return this.origTrack.getSampleDependencies().subList(this.fromSample, this.toSample);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (this.origTrack.getSyncSamples() != null) {
                    long[] syncSamples = this.origTrack.getSyncSamples();
                    int length = syncSamples.length;
                    int i = 0;
                    while (i < syncSamples.length && syncSamples[i] < this.fromSample) {
                        i++;
                    }
                    while (length > 0 && this.toSample < syncSamples[length - 1]) {
                        length--;
                    }
                    long[] copyOfRange = Arrays.copyOfRange(this.origTrack.getSyncSamples(), i, length);
                    for (int i2 = 0; i2 < copyOfRange.length; i2++) {
                        copyOfRange[i2] = copyOfRange[i2] - this.fromSample;
                    }
                    return copyOfRange;
                }
                return null;
            }
        }
        return (long[]) invokeV.objValue;
    }
}
