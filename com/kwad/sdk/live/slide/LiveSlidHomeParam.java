package com.kwad.sdk.live.slide;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class LiveSlidHomeParam implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LIVE_SLIDE_HOME_PARAM = "KEY_LIVE_SLIDE_HOME_PARAM";
    public static final long serialVersionUID = 4515368475377582488L;
    public transient /* synthetic */ FieldHolder $fh;
    public long mEnterScene;
    public boolean mIsFromLiveSquare;
    public int mSelectedPosition;

    public LiveSlidHomeParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
