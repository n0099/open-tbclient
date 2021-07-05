package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.load.a<ByteBuffer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer, file, eVar)) == null) {
            try {
                com.kwad.sdk.glide.g.a.a(byteBuffer, file);
                return true;
            } catch (IOException e2) {
                if (Log.isLoggable(ByteBufferEncoder.TAG, 3)) {
                    Log.d(ByteBufferEncoder.TAG, "Failed to write data", e2);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
