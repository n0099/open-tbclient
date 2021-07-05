package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(File file) {
        super(file);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((File) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    public InputStream a(File file, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
            File file2 = new File(file, UriUtil.LOCAL_RESOURCE_SCHEME + File.separator + str);
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "NormalFileLoader, file:", file2.getAbsolutePath());
                return new FileInputStream(file2.getCanonicalFile());
            }
            throw new IOException("file not found");
        }
        return (InputStream) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    public boolean b(File file, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, str)) == null) {
            return new File(file, UriUtil.LOCAL_RESOURCE_SCHEME + File.separator + str).exists();
        }
        return invokeLL.booleanValue;
    }
}
