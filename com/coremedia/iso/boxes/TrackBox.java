package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.List;
/* loaded from: classes4.dex */
public class TrackBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "trak";
    public transient /* synthetic */ FieldHolder $fh;
    public SampleTableBox sampleTableBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public MediaBox getMediaBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof MediaBox) {
                    return (MediaBox) box;
                }
            }
            return null;
        }
        return (MediaBox) invokeV.objValue;
    }

    public SampleTableBox getSampleTableBox() {
        InterceptResult invokeV;
        MediaInformationBox mediaInformationBox;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SampleTableBox sampleTableBox = this.sampleTableBox;
            if (sampleTableBox != null) {
                return sampleTableBox;
            }
            MediaBox mediaBox = getMediaBox();
            if (mediaBox == null || (mediaInformationBox = mediaBox.getMediaInformationBox()) == null) {
                return null;
            }
            SampleTableBox sampleTableBox2 = mediaInformationBox.getSampleTableBox();
            this.sampleTableBox = sampleTableBox2;
            return sampleTableBox2;
        }
        return (SampleTableBox) invokeV.objValue;
    }

    public TrackHeaderBox getTrackHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof TrackHeaderBox) {
                    return (TrackHeaderBox) box;
                }
            }
            return null;
        }
        return (TrackHeaderBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.BasicContainer, com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            super.setBoxes(list);
            this.sampleTableBox = null;
        }
    }
}
