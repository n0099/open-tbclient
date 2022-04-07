package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.HeadImgs;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class wj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public TiebaPlusInfo b;

    public wj8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public TiebaPlusInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (TiebaPlusInfo) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void c(BusinessPromot businessPromot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, businessPromot) == null) {
            this.a = businessPromot.is_download.booleanValue();
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
            builder.app_company = businessPromot.download_developer;
            builder.title = businessPromot.download_appname;
            builder.app_privacy = businessPromot.download_privacy_policy;
            builder.download_url = businessPromot.download_url;
            builder.app_icon = businessPromot.download_img;
            builder.app_version = businessPromot.download_version;
            builder.app_power = businessPromot.download_user_power;
            builder.app_package = businessPromot.download_package_name;
            builder.app_id = businessPromot.download_appid;
            builder.item_id = businessPromot.download_item_id;
            this.b = builder.build(true);
        }
    }

    public void d(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, headImgs) == null) {
            this.a = headImgs.download_is_thirdpage.intValue() == 1;
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
            builder.app_company = headImgs.download_developer;
            builder.title = headImgs.download_appname;
            builder.app_privacy = headImgs.download_privacy_policy;
            builder.download_url = headImgs.download_url;
            builder.app_icon = headImgs.download_img;
            builder.app_version = headImgs.download_version;
            builder.app_power = headImgs.download_user_power;
            builder.app_package = headImgs.download_package_name;
            builder.app_id = headImgs.download_appid;
            builder.item_id = String.valueOf(headImgs.download_item_id);
            this.b = builder.build(true);
        }
    }
}
