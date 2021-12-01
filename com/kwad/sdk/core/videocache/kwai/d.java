package com.kwad.sdk.core.videocache.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.videocache.kwai.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int a(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i2 < 0) {
                    return -1;
                }
                return i2 == 0 ? 0 : 1;
            }
            return invokeCommon.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? a(file.lastModified(), file2.lastModified()) : invokeLL.intValue;
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, file) == null) {
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
                }
            } else if (file.isDirectory()) {
            } else {
                throw new IOException("File " + file + " is not directory!");
            }
        }
    }

    public static List<File> b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            LinkedList linkedList = new LinkedList();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                List<File> asList = Arrays.asList(listFiles);
                Collections.sort(asList, new a(null));
                return asList;
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, file) == null) && file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.d.a.d("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    public static void d(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            long length = file.length();
            if (length == 0) {
                e(file);
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            long j2 = length - 1;
            randomAccessFile.seek(j2);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j2);
            randomAccessFile.write(readByte);
            randomAccessFile.close();
        }
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) {
            if (file.delete() && file.createNewFile()) {
                return;
            }
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
