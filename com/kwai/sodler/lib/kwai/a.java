package com.kwai.sodler.lib.kwai;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.kwai.kwai.b;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class a extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b g;
    public Resources h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private b a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, file, file2)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                if (!file.canRead()) {
                    file.setReadable(true);
                }
                if (!file.canWrite()) {
                    file.setWritable(true);
                }
                if (!file.canRead() || !file.canWrite()) {
                    file = null;
                }
            }
            com.kwai.sodler.lib.kwai.kwai.a aVar = com.kwai.sodler.lib.kwai.kwai.a.a;
            String absolutePath = file2.getAbsolutePath();
            String absolutePath2 = this.a.getAbsolutePath();
            com.kwai.sodler.lib.c.b bVar = this.f;
            return new b(aVar, absolutePath, file, absolutePath2, bVar.k, bVar.j);
        }
        return (b) invokeLL.objValue;
    }

    private File a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) {
            File file2 = new File(file.getParentFile(), this.c.c());
            o.i(file2);
            return file2;
        }
        return (File) invokeL.objValue;
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.h, com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            super.a(context, str);
            File file = new File(str);
            try {
                this.g = a(a(file), file);
                try {
                    this.h = com.kwai.sodler.lib.kwai.a.a.a(context, context.getResources(), str);
                    StringBuilder sb = new StringBuilder("Install plugin mClassLoader: ");
                    sb.append(this.g);
                    sb.append(", mResources: ");
                    sb.append(this.h);
                } catch (Exception e) {
                    Log.getStackTraceString(e);
                    throw new PluginError.LoadError(e, 4006);
                }
            } catch (IOException e2) {
                throw new PluginError.LoadError(e2, 4002);
            }
        }
    }

    public final Resources b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (Resources) invokeV.objValue;
    }
}
