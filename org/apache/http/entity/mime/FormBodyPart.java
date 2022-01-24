package org.apache.http.entity.mime;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.entity.mime.content.ContentBody;
/* loaded from: classes5.dex */
public class FormBodyPart {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentBody body;
    public final Header header;
    public final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, contentBody};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (contentBody != null) {
            this.name = str;
            this.body = contentBody;
            this.header = new Header();
            generateContentDisp(contentBody);
            generateContentType(contentBody);
            generateTransferEncoding(contentBody);
            return;
        }
        throw new IllegalArgumentException("Body may not be null");
    }

    public void addField(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (str != null) {
                this.header.addField(new MinimalField(str, str2));
                return;
            }
            throw new IllegalArgumentException("Field name may not be null");
        }
    }

    public void generateContentDisp(ContentBody contentBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentBody) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=\"");
            sb.append(getName());
            sb.append("\"");
            if (contentBody.getFilename() != null) {
                sb.append("; filename=\"");
                sb.append(contentBody.getFilename());
                sb.append("\"");
            }
            addField("Content-Disposition", sb.toString());
        }
    }

    public void generateContentType(ContentBody contentBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentBody) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(contentBody.getMimeType());
            if (contentBody.getCharset() != null) {
                sb.append("; charset=");
                sb.append(contentBody.getCharset());
            }
            addField("Content-Type", sb.toString());
        }
    }

    public void generateTransferEncoding(ContentBody contentBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, contentBody) == null) {
            addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
        }
    }

    public ContentBody getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.body : (ContentBody) invokeV.objValue;
    }

    public Header getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.header : (Header) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
