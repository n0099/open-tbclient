package com.repackage;

import android.content.Context;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.webkit.WebViewAssetLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class ci4 implements WebViewAssetLoader.PathHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final File a;

    public ci4(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = new File(bi4.a(file));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e);
        }
    }

    @Override // androidx.webkit.WebViewAssetLoader.PathHandler
    @NonNull
    @WorkerThread
    public WebResourceResponse handle(@NonNull String str) {
        InterceptResult invokeL;
        File b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                b = bi4.b(this.a, str);
            } catch (IOException e) {
                Log.e("ExtStoragePathHandler", "Error opening the requested path: " + str, e);
            }
            if (b != null) {
                return new WebResourceResponse(bi4.c(str), null, bi4.e(b));
            }
            Log.e("ExtStoragePathHandler", String.format("The requested file: %s is outside the mounted directory: %s", str, this.a));
            return new WebResourceResponse(null, null, null);
        }
        return (WebResourceResponse) invokeL.objValue;
    }
}
