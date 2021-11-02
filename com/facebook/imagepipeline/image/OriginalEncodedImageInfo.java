package com.facebook.imagepipeline.image;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class OriginalEncodedImageInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final OriginalEncodedImageInfo EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Object mCallerContext;
    public final int mHeight;
    @Nullable
    public final EncodedImageOrigin mOrigin;
    public final int mSize;
    @Nullable
    public final Uri mUri;
    public final int mWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020320838, "Lcom/facebook/imagepipeline/image/OriginalEncodedImageInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1020320838, "Lcom/facebook/imagepipeline/image/OriginalEncodedImageInfo;");
                return;
            }
        }
        EMPTY = new OriginalEncodedImageInfo();
    }

    public OriginalEncodedImageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUri = null;
        this.mOrigin = EncodedImageOrigin.NOT_SET;
        this.mCallerContext = null;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSize = -1;
    }

    @Nullable
    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCallerContext : invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    public EncodedImageOrigin getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOrigin : (EncodedImageOrigin) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSize : invokeV.intValue;
    }

    @Nullable
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUri : (Uri) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    public OriginalEncodedImageInfo(Uri uri, EncodedImageOrigin encodedImageOrigin, @Nullable Object obj, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, encodedImageOrigin, obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUri = uri;
        this.mOrigin = encodedImageOrigin;
        this.mCallerContext = obj;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mSize = i4;
    }
}
