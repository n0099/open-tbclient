package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.AbstractContainerBox;
/* loaded from: classes6.dex */
public class MediaInformationBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "minf";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaInformationBox() {
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

    public AbstractMediaHeaderBox getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof AbstractMediaHeaderBox) {
                    return (AbstractMediaHeaderBox) box;
                }
            }
            return null;
        }
        return (AbstractMediaHeaderBox) invokeV.objValue;
    }

    public SampleTableBox getSampleTableBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof SampleTableBox) {
                    return (SampleTableBox) box;
                }
            }
            return null;
        }
        return (SampleTableBox) invokeV.objValue;
    }
}
