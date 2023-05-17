package com.kwai.sodler.lib.kwai.kwai;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginClassLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public final class b extends BaseDexClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClassLoader axD;
    public final List<String> axE;
    public final List<String> axF;
    public final ClassLoader axG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader, str, file, str2, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.axG = classLoader;
        this.axE = list;
        this.axF = list2;
        while (true) {
            this.axD = classLoader;
            if (this.axD.getParent() == null) {
                Log.i(PluginClassLoader.TAG, "mParent is " + this.axD.getClass().getName());
                return;
            }
            classLoader = this.axD.getParent();
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String findLibrary = super.findLibrary(str);
            if (TextUtils.isEmpty(findLibrary) && (this.axG instanceof BaseDexClassLoader)) {
                StringBuilder sb = new StringBuilder("load so ");
                sb.append(str);
                sb.append(" from parent");
                return ((BaseDexClassLoader) this.axG).findLibrary(str);
            }
            return findLibrary;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            List<String> list = this.axE;
            if (list != null && list.contains(str)) {
                Log.i(PluginClassLoader.TAG, "loadClass " + str + " from host by interface");
                return super.loadClass(str, z);
            }
            List<String> list2 = this.axF;
            if (list2 != null) {
                Iterator<String> it = list2.iterator();
                while (it.hasNext()) {
                    if (str.startsWith(it.next() + ".")) {
                        return super.loadClass(str, z);
                    }
                }
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                return findClass(str);
            } catch (ClassNotFoundException e) {
                try {
                    return getParent().loadClass(str);
                } catch (ClassNotFoundException e2) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        e2.addSuppressed(e);
                    }
                    throw e2;
                }
            }
        }
        return (Class) invokeLZ.objValue;
    }
}
