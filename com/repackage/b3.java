package com.repackage;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import com.badlogic.gdx.Files;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class b3 implements k2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final AssetManager c;
    public d3 d;

    public b3(AssetManager assetManager, ContextWrapper contextWrapper, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, contextWrapper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.c = assetManager;
        String absolutePath = contextWrapper.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        this.b = absolutePath;
        if (z) {
            this.a = h(contextWrapper);
        } else {
            this.a = null;
        }
    }

    @Override // com.badlogic.gdx.Files
    public h3 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            j2 j2Var = new j2(this.c, str, Files.FileType.Internal);
            return this.d != null ? g(j2Var, str) : j2Var;
        }
        return (h3) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.repackage.k2
    public d3 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (d3) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public h3 d(String str, Files.FileType fileType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, fileType)) == null) {
            j2 j2Var = new j2(fileType == Files.FileType.Internal ? this.c : null, str, fileType);
            return (this.d == null || fileType != Files.FileType.Internal) ? j2Var : g(j2Var, str);
        }
        return (h3) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public h3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new j2((AssetManager) null, str, Files.FileType.Classpath) : (h3) invokeL.objValue;
    }

    public final h3 g(h3 h3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, h3Var, str)) == null) {
            try {
                this.c.open(str).close();
                return h3Var;
            } catch (Exception unused) {
                z2 z2Var = new z2(str);
                return (z2Var.x() && !z2Var.c()) ? h3Var : z2Var;
            }
        }
        return (h3) invokeLL.objValue;
    }

    public String h(ContextWrapper contextWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, contextWrapper)) == null) {
            File externalFilesDir = contextWrapper.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                String absolutePath = externalFilesDir.getAbsolutePath();
                if (absolutePath.endsWith("/")) {
                    return absolutePath;
                }
                return absolutePath + "/";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
