package org.apache.http.entity.mime.content;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class AbstractContentBody implements ContentBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mediaType;
    public final String mimeType;
    public final String subType;

    public AbstractContentBody(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str != null) {
            this.mimeType = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                this.mediaType = str.substring(0, indexOf);
                this.subType = str.substring(indexOf + 1);
                return;
            }
            this.mediaType = str;
            this.subType = null;
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mediaType : (String) invokeV.objValue;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mimeType : (String) invokeV.objValue;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subType : (String) invokeV.objValue;
    }
}
