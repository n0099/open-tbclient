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
/* loaded from: classes3.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTENT_LENGTH_LIMIT = 10485760;
    public static final String TAG = "MicroMsg.SDK.WXFileObject";
    public transient /* synthetic */ FieldHolder $fh;
    public int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
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
        this.contentLengthLimit = 10485760;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
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
        this.contentLengthLimit = 10485760;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
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
        this.contentLengthLimit = 10485760;
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
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bArr = this.fileData;
            if ((bArr == null || bArr.length == 0) && ((str = this.filePath) == null || str.length() == 0)) {
                str2 = "checkArgs fail, both arguments is null";
            } else {
                byte[] bArr2 = this.fileData;
                if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
                    String str3 = this.filePath;
                    if (str3 == null || getFileSize(str3) <= this.contentLengthLimit) {
                        return true;
                    }
                    str2 = "checkArgs fail, fileSize is too large";
                } else {
                    str2 = "checkArgs fail, fileData is too large";
                }
            }
            Log.e("MicroMsg.SDK.WXFileObject", str2);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putByteArray("_wxfileobject_fileData", this.fileData);
            bundle.putString("_wxfileobject_filePath", this.filePath);
        }
    }

    public void setContentLengthLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.contentLengthLimit = i2;
        }
    }

    public void setFileData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            this.fileData = bArr;
        }
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.filePath = str;
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            this.fileData = bundle.getByteArray("_wxfileobject_fileData");
            this.filePath = bundle.getString("_wxfileobject_filePath");
        }
    }
}
