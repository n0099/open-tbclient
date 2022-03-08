package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes8.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTENT_LENGTH_LIMIT = 10485760;
    public static final int PATH_LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXImageObject";
    public static final int URL_LENGTH_LIMIT = 10240;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
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

    public WXImageObject(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
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
        this.imageData = bArr;
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
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bArr = this.imageData;
            if ((bArr == null || bArr.length == 0) && (((str = this.imagePath) == null || str.length() == 0) && ((str2 = this.imageUrl) == null || str2.length() == 0))) {
                str3 = "checkArgs fail, all arguments are null";
            } else {
                byte[] bArr2 = this.imageData;
                if (bArr2 == null || bArr2.length <= 10485760) {
                    String str4 = this.imagePath;
                    if (str4 == null || str4.length() <= 10240) {
                        String str5 = this.imagePath;
                        if (str5 == null || getFileSize(str5) <= 10485760) {
                            String str6 = this.imageUrl;
                            if (str6 == null || str6.length() <= 10240) {
                                return true;
                            }
                            str3 = "checkArgs fail, url is invalid";
                        } else {
                            str3 = "checkArgs fail, image content is too large";
                        }
                    } else {
                        str3 = "checkArgs fail, path is invalid";
                    }
                } else {
                    str3 = "checkArgs fail, content is too large";
                }
            }
            a.a("MicroMsg.SDK.WXImageObject", str3);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putByteArray("_wximageobject_imageData", this.imageData);
            bundle.putString("_wximageobject_imagePath", this.imagePath);
            bundle.putString("_wximageobject_imageUrl", this.imageUrl);
        }
    }

    public void setImagePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.imagePath = str;
        }
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.imageData = bundle.getByteArray("_wximageobject_imageData");
            this.imagePath = bundle.getString("_wximageobject_imagePath");
            this.imageUrl = bundle.getString("_wximageobject_imageUrl");
        }
    }
}
