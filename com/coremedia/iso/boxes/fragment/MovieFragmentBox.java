package com.coremedia.iso.boxes.fragment;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MovieFragmentBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "moof";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieFragmentBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DataSource getFileChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataSource : (DataSource) invokeV.objValue;
    }

    public List<Long> getSyncSamples(SampleDependencyTypeBox sampleDependencyTypeBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sampleDependencyTypeBox)) == null) {
            ArrayList arrayList = new ArrayList();
            long j2 = 1;
            for (SampleDependencyTypeBox.Entry entry : sampleDependencyTypeBox.getEntries()) {
                if (entry.getSampleDependsOn() == 2) {
                    arrayList.add(Long.valueOf(j2));
                }
                j2++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public int getTrackCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getBoxes(TrackFragmentBox.class, false).size() : invokeV.intValue;
    }

    public List<TrackFragmentHeaderBox> getTrackFragmentHeaderBoxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getBoxes(TrackFragmentHeaderBox.class, true) : (List) invokeV.objValue;
    }

    public long[] getTrackNumbers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List boxes = getBoxes(TrackFragmentBox.class, false);
            long[] jArr = new long[boxes.size()];
            for (int i2 = 0; i2 < boxes.size(); i2++) {
                jArr[i2] = ((TrackFragmentBox) boxes.get(i2)).getTrackFragmentHeaderBox().getTrackId();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    public List<TrackRunBox> getTrackRunBoxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getBoxes(TrackRunBox.class, true) : (List) invokeV.objValue;
    }
}
