package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes7.dex */
public class WXEmojiSharedObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public transient /* synthetic */ FieldHolder $fh;
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject() {
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

    public WXEmojiSharedObject(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.thumburl = str;
        this.packageflag = i2;
        this.packageid = str2;
        this.url = str3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.packageid) || TextUtils.isEmpty(this.thumburl) || TextUtils.isEmpty(this.url) || this.packageflag == -1) {
                Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
            bundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
            bundle.putString("_wxemojisharedobject_packageid", this.packageid);
            bundle.putString("_wxemojisharedobject_url", this.url);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 15;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
            this.packageflag = bundle.getInt("_wxwebpageobject_packageflag");
            this.packageid = bundle.getString("_wxwebpageobject_packageid");
            this.url = bundle.getString("_wxwebpageobject_url");
        }
    }
}
