package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.AbstractContainerBox;
/* loaded from: classes6.dex */
public class SampleTableBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "stbl";
    public transient /* synthetic */ FieldHolder $fh;
    public SampleToChunkBox sampleToChunkBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SampleTableBox() {
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

    public ChunkOffsetBox getChunkOffsetBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof ChunkOffsetBox) {
                    return (ChunkOffsetBox) box;
                }
            }
            return null;
        }
        return (ChunkOffsetBox) invokeV.objValue;
    }

    public CompositionTimeToSample getCompositionTimeToSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof CompositionTimeToSample) {
                    return (CompositionTimeToSample) box;
                }
            }
            return null;
        }
        return (CompositionTimeToSample) invokeV.objValue;
    }

    public SampleDependencyTypeBox getSampleDependencyTypeBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof SampleDependencyTypeBox) {
                    return (SampleDependencyTypeBox) box;
                }
            }
            return null;
        }
        return (SampleDependencyTypeBox) invokeV.objValue;
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof SampleDescriptionBox) {
                    return (SampleDescriptionBox) box;
                }
            }
            return null;
        }
        return (SampleDescriptionBox) invokeV.objValue;
    }

    public SampleSizeBox getSampleSizeBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof SampleSizeBox) {
                    return (SampleSizeBox) box;
                }
            }
            return null;
        }
        return (SampleSizeBox) invokeV.objValue;
    }

    public SampleToChunkBox getSampleToChunkBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SampleToChunkBox sampleToChunkBox = this.sampleToChunkBox;
            if (sampleToChunkBox != null) {
                return sampleToChunkBox;
            }
            for (Box box : getBoxes()) {
                if (box instanceof SampleToChunkBox) {
                    SampleToChunkBox sampleToChunkBox2 = (SampleToChunkBox) box;
                    this.sampleToChunkBox = sampleToChunkBox2;
                    return sampleToChunkBox2;
                }
            }
            return null;
        }
        return (SampleToChunkBox) invokeV.objValue;
    }

    public SyncSampleBox getSyncSampleBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof SyncSampleBox) {
                    return (SyncSampleBox) box;
                }
            }
            return null;
        }
        return (SyncSampleBox) invokeV.objValue;
    }

    public TimeToSampleBox getTimeToSampleBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof TimeToSampleBox) {
                    return (TimeToSampleBox) box;
                }
            }
            return null;
        }
        return (TimeToSampleBox) invokeV.objValue;
    }
}
