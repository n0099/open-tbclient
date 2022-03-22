package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.List;
/* loaded from: classes6.dex */
public class MovieBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "moov";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieBox() {
        super("moov");
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

    public MovieHeaderBox getMovieHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (Box box : getBoxes()) {
                if (box instanceof MovieHeaderBox) {
                    return (MovieHeaderBox) box;
                }
            }
            return null;
        }
        return (MovieHeaderBox) invokeV.objValue;
    }

    public int getTrackCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getBoxes(TrackBox.class).size() : invokeV.intValue;
    }

    public long[] getTrackNumbers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List boxes = getBoxes(TrackBox.class);
            long[] jArr = new long[boxes.size()];
            for (int i = 0; i < boxes.size(); i++) {
                jArr[i] = ((TrackBox) boxes.get(i)).getTrackHeaderBox().getTrackId();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }
}
