package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class BaseMediaObject implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MULITI_IMAGE = 6;
    public static final int MEDIA_TYPE_SOURCE_VIDEO = 7;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public BaseMediaObject() {
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

    public boolean checkArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.actionUrl;
            if (str != null && str.length() <= 512) {
                String str2 = this.identify;
                if (str2 != null && str2.length() <= 512) {
                    byte[] bArr = this.thumbData;
                    if (bArr != null && bArr.length <= 32768) {
                        String str3 = this.title;
                        if (str3 != null && str3.length() <= 512) {
                            String str4 = this.description;
                            if (str4 == null || str4.length() > 1024) {
                                LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
                                return false;
                            }
                            return true;
                        }
                        LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkArgs fail, thumbData is invalid,size is ");
                    byte[] bArr2 = this.thumbData;
                    sb.append(bArr2 != null ? bArr2.length : -1);
                    sb.append("! more then 32768.");
                    LogUtil.e("Weibo.BaseMediaObject", sb.toString());
                    return false;
                }
                LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
                return false;
            }
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract int getObjType();

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0005 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: android.graphics.Bitmap$CompressFormat */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 85, byteArrayOutputStream);
                    this.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    byteArrayOutputStream2 = compressFormat;
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e.printStackTrace();
                    LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                        byteArrayOutputStream2 = byteArrayOutputStream2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    public abstract BaseMediaObject toExtraMediaObject(String str);

    public abstract String toExtraMediaString();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeString(this.actionUrl);
            parcel.writeString(this.schema);
            parcel.writeString(this.identify);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeByteArray(this.thumbData);
        }
    }

    public BaseMediaObject(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }
}
