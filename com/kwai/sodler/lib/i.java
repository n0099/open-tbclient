package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class i extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a(Set<File> set) {
        com.kwai.sodler.lib.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, set) == null) || (bVar = this.f37151f) == null || bVar.f37175h.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> hashMap = this.f37151f.f37175h;
        for (File file : set) {
            String f2 = com.kwai.sodler.lib.c.a.f(file);
            String str = hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(f2, str)) {
                b(set);
                throw new PluginError.LoadError(new Exception(file.getName() + "Md5 check error,find " + f2 + ",except " + str), 4008);
            }
        }
    }

    private void b(Set<File> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, set) == null) {
            for (File file : set) {
                com.kwai.sodler.lib.c.a.a(file);
            }
        }
    }

    public Set<File> a(Context context, File file, File file2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, file, file2)) == null) {
            a.b("Sodler.simple.SoLib", "Install plugin so libs, destDir = " + file2);
            HashSet hashSet = new HashSet();
            if (!file2.exists() || file2.list().length <= 0) {
                File file3 = new File(file2.getParentFile(), this.f37148c.d());
                com.kwai.sodler.lib.c.a.e(file3);
                Set<String> a2 = com.kwai.sodler.lib.c.c.a(file, file3);
                if (a2 != null) {
                    for (String str : a2) {
                        File a3 = com.kwai.sodler.lib.c.c.a(context, file3, str, file2);
                        if (a3 != null) {
                            hashSet.add(a3);
                        }
                    }
                    com.kwai.sodler.lib.c.a.a(file3);
                }
                return hashSet;
            }
            return hashSet;
        }
        return (Set) invokeLLL.objValue;
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            a.b("Sodler.simple.SoLib", "Install plugin so libs.");
            File file = new File(str);
            a(file);
            try {
                File b2 = b(file);
                this.f37146a = b2;
                try {
                    a(a(context, file, b2));
                    synchronized (Runtime.getRuntime()) {
                        com.kwai.sodler.lib.ext.d.a(getClass().getClassLoader(), this.f37146a);
                    }
                    super.a(context, str);
                } catch (IOException e2) {
                    throw new PluginError.LoadError(e2, 4004);
                }
            } catch (IOException e3) {
                throw new PluginError.LoadError(e3, 4003);
            }
        }
    }

    public File b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            File file2 = new File(file.getParentFile(), this.f37148c.c());
            com.kwai.sodler.lib.c.a.e(file2);
            return file2;
        }
        return (File) invokeL.objValue;
    }
}
