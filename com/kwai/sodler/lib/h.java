package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.o;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes8.dex */
public class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str) {
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

    private Set a(Context context, File file, File file2) {
        InterceptResult invokeLLL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, context, file, file2)) == null) {
            new StringBuilder("Install plugin so libs, destDir = ").append(file2);
            HashSet hashSet = new HashSet();
            if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
                for (String str : list) {
                    hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
                }
                return hashSet;
            }
            File file3 = new File(file2.getParentFile(), this.axi.FB());
            o.U(file3);
            for (String str2 : com.kwai.sodler.lib.d.c.h(file, file3)) {
                new StringBuilder("extractSoLib, soName = ").append(str2);
                File a = com.kwai.sodler.lib.d.c.a(file3, str2, file2);
                if (a != null) {
                    hashSet.add(a);
                }
            }
            o.O(file3);
            return hashSet;
        }
        return (Set) invokeLLL.objValue;
    }

    private File ag(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) {
            File file2 = new File(file.getParentFile(), this.axi.FA());
            o.U(file2);
            return file2;
        }
        return (File) invokeL.objValue;
    }

    private void d(Set set) {
        com.kwai.sodler.lib.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, set) == null) || (bVar = this.aya) == null || bVar.ayF.size() <= 0 || set == null) {
            return;
        }
        HashMap hashMap = this.aya.ayF;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String Y = ab.Y(file);
            String str = (String) hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(Y, str)) {
                e(set);
                throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + Y + ",except " + str), 4008);
            }
        }
    }

    public static void e(Set set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, set) == null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                o.O((File) it.next());
            }
        }
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void ad(Context context, String str) {
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            super.ad(context, str);
            File file = new File(str);
            try {
                File ag = ag(file);
                this.axU = ag;
                try {
                    try {
                        d(a(context, file, ag));
                        com.kwai.sodler.lib.c.b bVar = this.aya;
                        if (bVar == null || (classLoader = bVar.ayI) == null) {
                            classLoader = getClass().getClassLoader();
                        }
                        synchronized (Runtime.getRuntime()) {
                            com.kwai.sodler.lib.ext.d.c(classLoader, this.axU);
                        }
                    } catch (PluginError.LoadError e) {
                        o.O(file);
                        throw e;
                    }
                } catch (IOException e2) {
                    throw new PluginError.LoadError(e2, 4004);
                }
            } catch (IOException e3) {
                throw new PluginError.LoadError(e3, 4003);
            }
        }
    }
}
