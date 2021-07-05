package com.kwad.sdk.contentalliance.profile.home;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class ProfileHomeParam implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6152648276167879373L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthorIcon;
    public long mAuthorId;
    public String mAuthorName;
    public long mCurrentPhotoId;
    public long mEntryScene;

    public ProfileHomeParam() {
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

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.mEntryScene == 0 || this.mAuthorId == 0) ? false : true : invokeV.booleanValue;
    }
}
