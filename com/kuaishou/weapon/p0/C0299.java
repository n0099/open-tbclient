package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʻˉ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0299 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ʻˉ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0300 implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ String f21;

        public C0300(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21 = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() || file.getName().toLowerCase().contains(this.f21) : invokeL.booleanValue;
        }
    }

    public C0299() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        r0.add(r3);
     */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<File> m157(File file, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, file, str, i)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] listFiles = file.listFiles(new C0300(str));
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        File file2 = listFiles[i2];
                        if (file2.isFile()) {
                            break;
                        }
                        int i3 = i + 1;
                        arrayList.addAll(m157(file2, str, i));
                        i2++;
                        i = i3;
                    }
                }
            } catch (Throwable unused) {
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m158(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m159(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? m157(context.getFilesDir(), str, 0).size() > 0 : invokeLL.booleanValue;
    }
}
