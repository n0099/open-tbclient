package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f34002a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34003b;

    public a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34002a = context.getApplicationContext();
        this.f34003b = str;
    }

    @Nullable
    private File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            File file = new File(this.f34002a.getCacheDir(), a(str, FileExtension.Json, false));
            if (file.exists()) {
                return file;
            }
            File file2 = new File(this.f34002a.getCacheDir(), a(str, FileExtension.Zip, false));
            if (file2.exists()) {
                return file2;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static String a(String str, FileExtension fileExtension, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, fileExtension, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("lottie_cache_");
            sb.append(str.replaceAll("\\W+", ""));
            sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                File a2 = a(this.f34003b);
                if (a2 == null) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(a2);
                FileExtension fileExtension = a2.getAbsolutePath().endsWith(".zip") ? FileExtension.Zip : FileExtension.Json;
                c.a("Cache hit for " + this.f34003b + " at " + a2.getAbsolutePath());
                return new Pair<>(fileExtension, fileInputStream);
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        return (Pair) invokeV.objValue;
    }

    public File a(InputStream inputStream, FileExtension fileExtension) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, fileExtension)) != null) {
            return (File) invokeLL.objValue;
        }
        File file = new File(this.f34002a.getCacheDir(), a(this.f34003b, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } finally {
            inputStream.close();
        }
    }

    public void a(FileExtension fileExtension) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fileExtension) == null) {
            File file = new File(this.f34002a.getCacheDir(), a(this.f34003b, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(XAdSimpleImageLoader.TEMP_SUFFIX, ""));
            boolean renameTo = file.renameTo(file2);
            c.a("Copying temp file to real file (" + file2 + SmallTailInfo.EMOTION_SUFFIX);
            if (renameTo) {
                return;
            }
            c.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }
}
