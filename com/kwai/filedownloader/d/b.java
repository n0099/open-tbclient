package com.kwai.filedownloader.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class b implements com.kwai.filedownloader.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BufferedOutputStream awH;
    public final RandomAccessFile awI;
    public final FileDescriptor fd;

    /* loaded from: classes8.dex */
    public static class a implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.kwai.filedownloader.e.c.e
        public final com.kwai.filedownloader.d.a ae(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? new b(file) : (com.kwai.filedownloader.d.a) invokeL.objValue;
        }
    }

    public b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.awI = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.awH = new BufferedOutputStream(new FileOutputStream(this.awI.getFD()));
    }

    @Override // com.kwai.filedownloader.d.a
    public final void EI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.awH.flush();
            this.fd.sync();
        }
    }

    @Override // com.kwai.filedownloader.d.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.awH.close();
            this.awI.close();
        }
    }

    @Override // com.kwai.filedownloader.d.a
    public final void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.awI.seek(j);
        }
    }

    @Override // com.kwai.filedownloader.d.a
    public final void setLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.awI.setLength(j);
        }
    }

    @Override // com.kwai.filedownloader.d.a
    public final void write(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i, i2) == null) {
            this.awH.write(bArr, 0, i2);
        }
    }
}
