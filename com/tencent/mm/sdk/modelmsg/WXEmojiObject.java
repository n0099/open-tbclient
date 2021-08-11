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
import java.io.File;
/* loaded from: classes10.dex */
public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTENT_LENGTH_LIMIT = 10485760;
    public static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
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
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.emojiData = bArr;
    }

    private int getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            File file = new File(str);
            if (file.exists()) {
                return (int) file.length();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bArr = this.emojiData;
            if ((bArr == null || bArr.length == 0) && ((str = this.emojiPath) == null || str.length() == 0)) {
                str2 = "checkArgs fail, both arguments is null";
            } else {
                byte[] bArr2 = this.emojiData;
                if (bArr2 == null || bArr2.length <= 10485760) {
                    String str3 = this.emojiPath;
                    if (str3 == null || getFileSize(str3) <= 10485760) {
                        return true;
                    }
                    str2 = "checkArgs fail, emojiSize is too large";
                } else {
                    str2 = "checkArgs fail, emojiData is too large";
                }
            }
            a.a("MicroMsg.SDK.WXEmojiObject", str2);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
            bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
        }
    }

    public void setEmojiData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            this.emojiData = bArr;
        }
    }

    public void setEmojiPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.emojiPath = str;
        }
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 8;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
            this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
        }
    }
}
