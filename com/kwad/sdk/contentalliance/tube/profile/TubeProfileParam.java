package com.kwad.sdk.contentalliance.tube.profile;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class TubeProfileParam implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5238032101385027454L;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public long mEntryScene;
    public PhotoInfo.TubeEpisode mTubeEpisode;

    public TubeProfileParam() {
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

    public long getTubeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PhotoInfo.TubeEpisode tubeEpisode = this.mTubeEpisode;
            if (tubeEpisode != null) {
                return tubeEpisode.tubeId;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.mEntryScene == 0 || this.mTubeEpisode == null) ? false : true : invokeV.booleanValue;
    }
}
