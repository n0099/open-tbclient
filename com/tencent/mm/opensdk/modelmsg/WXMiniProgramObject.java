package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes8.dex */
public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    public static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public transient /* synthetic */ FieldHolder $fh;
    public int disableforward;
    public int miniprogramType;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public WXMiniProgramObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.miniprogramType = 0;
        this.disableforward = 0;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d.b(this.webpageUrl)) {
                str = "webPageUrl is null";
            } else if (d.b(this.userName)) {
                str = "userName is null";
            } else {
                int i2 = this.miniprogramType;
                if (i2 >= 0 && i2 <= 2) {
                    return true;
                }
                str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
            }
            Log.e(TAG, str);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
            bundle.putString("_wxminiprogram_username", this.userName);
            bundle.putString("_wxminiprogram_path", this.path);
            bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
            bundle.putInt("_wxminiprogram_type", this.miniprogramType);
            bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 36;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
            this.userName = bundle.getString("_wxminiprogram_username");
            this.path = bundle.getString("_wxminiprogram_path");
            this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
            this.miniprogramType = bundle.getInt("_wxminiprogram_type");
            this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
        }
    }
}
