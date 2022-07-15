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
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTENT_LENGTH_LIMIT = 10485760;
    public static final int EXTINFO_LENGTH_LIMIT = 2048;
    public static final int PATH_LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public transient /* synthetic */ FieldHolder $fh;
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
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

    public WXAppExtendObject(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.extInfo = str;
        this.fileData = bArr;
    }

    private int getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? d.getFileSize(str) : invokeL.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        InterceptResult invokeV;
        String str;
        byte[] bArr;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str3 = this.extInfo;
            if ((str3 == null || str3.length() == 0) && (((str = this.filePath) == null || str.length() == 0) && ((bArr = this.fileData) == null || bArr.length == 0))) {
                str2 = "checkArgs fail, all arguments is null";
            } else {
                String str4 = this.extInfo;
                if (str4 == null || str4.length() <= 2048) {
                    String str5 = this.filePath;
                    if (str5 == null || str5.length() <= 10240) {
                        String str6 = this.filePath;
                        if (str6 == null || getFileSize(str6) <= 10485760) {
                            byte[] bArr2 = this.fileData;
                            if (bArr2 == null || bArr2.length <= 10485760) {
                                return true;
                            }
                            str2 = "checkArgs fail, fileData is too large";
                        } else {
                            str2 = "checkArgs fail, fileSize is too large";
                        }
                    } else {
                        str2 = "checkArgs fail, filePath is invalid";
                    }
                } else {
                    str2 = "checkArgs fail, extInfo is invalid";
                }
            }
            Log.e("MicroMsg.SDK.WXAppExtendObject", str2);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("_wxappextendobject_extInfo", this.extInfo);
            bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
            bundle.putString("_wxappextendobject_filePath", this.filePath);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.extInfo = bundle.getString("_wxappextendobject_extInfo");
            this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
            this.filePath = bundle.getString("_wxappextendobject_filePath");
        }
    }
}
