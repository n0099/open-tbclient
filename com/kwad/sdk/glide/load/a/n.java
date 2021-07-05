package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class n extends l<InputStream> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final UriMatcher f37817a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85330783, "Lcom/kwad/sdk/glide/load/a/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85330783, "Lcom/kwad/sdk/glide/load/a/n;");
                return;
            }
        }
        f37817a = new UriMatcher(-1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentResolver, uri};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ContentResolver) objArr2[0], (Uri) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, uri, contentResolver)) == null) ? contentResolver.openInputStream(uri) : (InputStream) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.l
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uri, contentResolver)) == null) {
            InputStream c2 = c(uri, contentResolver);
            if (c2 != null) {
                return c2;
            }
            throw new FileNotFoundException("InputStream is null for " + uri);
        }
        return (InputStream) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.l
    public void a(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            inputStream.close();
        }
    }
}
