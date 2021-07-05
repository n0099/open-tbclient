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
/* loaded from: classes7.dex */
public class WXEmojiPageSharedObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public transient /* synthetic */ FieldHolder $fh;
    public String desc;
    public String iconUrl;
    public int pageType;
    public String secondUrl;
    public int tid;
    public String title;
    public int type;
    public String url;

    public WXEmojiPageSharedObject() {
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

    public WXEmojiPageSharedObject(int i2, int i3, String str, String str2, String str3, String str4, int i4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4, Integer.valueOf(i4), str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tid = i3;
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
        this.secondUrl = str4;
        this.pageType = i4;
        this.url = str5;
        this.type = i2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d.b(this.title) || d.b(this.iconUrl)) {
                Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, title or iconUrl is invalid");
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
            bundle.putInt("_wxemojisharedobject_tid", this.tid);
            bundle.putString("_wxemojisharedobject_title", this.title);
            bundle.putString("_wxemojisharedobject_desc", this.desc);
            bundle.putString("_wxemojisharedobject_iconurl", this.iconUrl);
            bundle.putString("_wxemojisharedobject_secondurl", this.secondUrl);
            bundle.putInt("_wxemojisharedobject_pagetype", this.pageType);
            bundle.putString("_wxwebpageobject_url", this.url);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.tid = bundle.getInt("_wxemojisharedobject_tid");
            this.title = bundle.getString("_wxemojisharedobject_title");
            this.desc = bundle.getString("_wxemojisharedobject_desc");
            this.iconUrl = bundle.getString("_wxemojisharedobject_iconurl");
            this.secondUrl = bundle.getString("_wxemojisharedobject_secondurl");
            this.pageType = bundle.getInt("_wxemojisharedobject_pagetype");
            this.url = bundle.getString("_wxwebpageobject_url");
        }
    }
}
