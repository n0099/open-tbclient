package com.facebook.soloader;

import android.os.StrictMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class DirectorySoSource extends SoSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.soDirectory = file;
        this.flags = i2;
    }

    public static String[] getDependencies(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + file.getName() + PreferencesUtil.RIGHT_MOUNT);
            }
            try {
                return MinElf.extract_DT_NEEDED(file);
            } finally {
                if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.endSection();
                }
            }
        }
        return (String[]) invokeL.objValue;
    }

    private void loadDependencies(File file, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, this, file, i2, threadPolicy) == null) {
            String str = "Loading lib dependencies: " + Arrays.toString(dependencies);
            for (String str2 : getDependencies(file)) {
                if (!str2.startsWith("/")) {
                    SoLoader.loadLibraryBySoName(str2, i2 | 1, threadPolicy);
                }
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            collection.add(this.soDirectory.getAbsolutePath());
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, threadPolicy)) == null) ? loadLibraryFrom(str, i2, this.soDirectory, threadPolicy) : invokeLIL.intValue;
    }

    public int loadLibraryFrom(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, file, threadPolicy)) == null) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                String str2 = str + " not found on " + file.getCanonicalPath();
                return 0;
            }
            String str3 = str + " found on " + file.getCanonicalPath();
            if ((i2 & 1) != 0 && (this.flags & 2) != 0) {
                String str4 = str + " loaded implicitly";
                return 2;
            }
            if ((this.flags & 1) != 0) {
                loadDependencies(file2, i2, threadPolicy);
            } else {
                String str5 = "Not resolving dependencies for " + str;
            }
            try {
                SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i2);
                return 1;
            } catch (UnsatisfiedLinkError e2) {
                if (e2.getMessage().contains("bad ELF magic")) {
                    return 3;
                }
                throw e2;
            }
        }
        return invokeLILL.intValue;
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                name = String.valueOf(this.soDirectory.getCanonicalPath());
            } catch (IOException unused) {
                name = this.soDirectory.getName();
            }
            return getClass().getName() + "[root = " + name + " flags = " + this.flags + ']';
        }
        return (String) invokeV.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            File file = new File(this.soDirectory, str);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }
}
