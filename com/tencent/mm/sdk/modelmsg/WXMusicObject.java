package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
/* loaded from: classes7.dex */
public class WXMusicObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public transient /* synthetic */ FieldHolder $fh;
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    public WXMusicObject() {
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

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str3 = this.musicUrl;
            if ((str3 == null || str3.length() == 0) && ((str = this.musicLowBandUrl) == null || str.length() == 0)) {
                str2 = "both arguments are null";
            } else {
                String str4 = this.musicUrl;
                if (str4 == null || str4.length() <= 10240) {
                    String str5 = this.musicLowBandUrl;
                    if (str5 == null || str5.length() <= 10240) {
                        return true;
                    }
                    str2 = "checkArgs fail, musicLowBandUrl is too long";
                } else {
                    str2 = "checkArgs fail, musicUrl is too long";
                }
            }
            a.a("MicroMsg.SDK.WXMusicObject", str2);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
            bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
            bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
            bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        }
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
            this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
            this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
            this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
        }
    }
}
