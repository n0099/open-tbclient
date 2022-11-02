package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ApplicationSoSource extends SoSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context applicationContext;
    public int flags;
    public DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.applicationContext = context;
        }
        this.flags = i;
        this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), i);
    }

    public static File getNativeLibDirFromContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return new File(context.getApplicationInfo().nativeLibraryDir);
        }
        return (File) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            this.soSource.addToLdLibraryPath(collection);
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.soSource.getLibraryDependencies(str);
        }
        return (String[]) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.soSource.getLibraryPath(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.soSource.prepare(i);
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return this.soSource.unpackLibrary(str);
        }
        return (File) invokeL.objValue;
    }

    public boolean checkAndMaybeUpdate() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            File file = this.soSource.soDirectory;
            Context updatedContext = getUpdatedContext();
            File nativeLibDirFromContext = getNativeLibDirFromContext(updatedContext);
            if (!file.equals(nativeLibDirFromContext)) {
                Log.d("SoLoader", "Native library directory updated from " + file + " to " + nativeLibDirFromContext);
                int i = this.flags | 1;
                this.flags = i;
                DirectorySoSource directorySoSource = new DirectorySoSource(nativeLibDirFromContext, i);
                this.soSource = directorySoSource;
                directorySoSource.prepare(this.flags);
                this.applicationContext = updatedContext;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Context getUpdatedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.soSource.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, str, i, threadPolicy)) == null) {
            return this.soSource.loadLibrary(str, i, threadPolicy);
        }
        return invokeLIL.intValue;
    }
}
