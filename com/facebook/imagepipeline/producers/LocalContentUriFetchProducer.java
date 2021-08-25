package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    public static final String[] PROJECTION;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver mContentResolver;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1927661474, "Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1927661474, "Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;");
                return;
            }
        }
        PROJECTION = new String[]{"_id", "_data"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory, contentResolver};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Executor) objArr2[0], (PooledByteBufferFactory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContentResolver = contentResolver;
    }

    @Nullable
    private EncodedImage getCameraImage(Uri uri) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.getCount() == 0) {
                    return null;
                }
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("_data"));
                if (string != null) {
                    return getEncodedImage(new FileInputStream(string), getLength(string));
                }
                return null;
            } finally {
                query.close();
            }
        }
        return (EncodedImage) invokeL.objValue;
    }

    public static int getLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return -1;
            }
            return (int) new File(str).length();
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        InterceptResult invokeL;
        EncodedImage cameraImage;
        InputStream createInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageRequest)) == null) {
            Uri sourceUri = imageRequest.getSourceUri();
            if (!UriUtil.isLocalContactUri(sourceUri)) {
                return (!UriUtil.isLocalCameraUri(sourceUri) || (cameraImage = getCameraImage(sourceUri)) == null) ? getEncodedImage(this.mContentResolver.openInputStream(sourceUri), -1) : cameraImage;
            }
            if (sourceUri.toString().endsWith("/photo")) {
                createInputStream = this.mContentResolver.openInputStream(sourceUri);
            } else if (sourceUri.toString().endsWith("/display_photo")) {
                try {
                    createInputStream = this.mContentResolver.openAssetFileDescriptor(sourceUri, r.f42169a).createInputStream();
                } catch (IOException unused) {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
            } else {
                InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, sourceUri);
                if (openContactPhotoInputStream == null) {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
                createInputStream = openContactPhotoInputStream;
            }
            return getEncodedImage(createInputStream, -1);
        }
        return (EncodedImage) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PRODUCER_NAME : (String) invokeV.objValue;
    }
}
