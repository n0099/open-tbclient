package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
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
/* loaded from: classes7.dex */
public class DirectorySoSource extends SoSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.soDirectory = file;
        this.flags = i;
    }

    public static String[] getDependencies(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", file.getName(), PreferencesUtil.RIGHT_MOUNT);
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

    public static void loadDependencies(File file, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, file, i, threadPolicy) == null) {
            String[] dependencies = getDependencies(file);
            Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(dependencies));
            for (String str : dependencies) {
                if (!str.startsWith("/")) {
                    SoLoader.loadLibraryBySoName(str, i | 1, threadPolicy);
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
    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            File file = new File(this.soDirectory, str);
            if (file.exists()) {
                return getDependencies(file);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            File file = new File(this.soDirectory, str);
            if (file.exists()) {
                return file.getCanonicalPath();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            File file = new File(this.soDirectory, str);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, str, i, threadPolicy)) == null) {
            return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return invokeLIL.intValue;
    }

    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048580, this, str, i, file, threadPolicy)) == null) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
                return 0;
            }
            Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
            if ((i & 1) != 0 && (this.flags & 2) != 0) {
                Log.d("SoLoader", str + " loaded implicitly");
                return 2;
            }
            if ((this.flags & 1) != 0) {
                loadDependencies(file2, i, threadPolicy);
            } else {
                Log.d("SoLoader", "Not resolving dependencies for " + str);
            }
            try {
                SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i);
                return 1;
            } catch (UnsatisfiedLinkError e) {
                if (e.getMessage().contains("bad ELF magic")) {
                    Log.d("SoLoader", "Corrupted lib file detected");
                    return 3;
                }
                throw e;
            }
        }
        return invokeLILL.intValue;
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                name = String.valueOf(this.soDirectory.getCanonicalPath());
            } catch (IOException unused) {
                name = this.soDirectory.getName();
            }
            return getClass().getName() + "[root = " + name + " flags = " + this.flags + ']';
        }
        return (String) invokeV.objValue;
    }
}
