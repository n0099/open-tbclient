package com.ss.android.socialbase.downloader.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class e implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BufferedOutputStream f69646a;

    /* renamed from: b  reason: collision with root package name */
    public FileDescriptor f69647b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f69648c;

    public e(File file, int i2) throws BaseException {
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
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f69648c = randomAccessFile;
            this.f69647b = randomAccessFile.getFD();
            if (i2 > 0) {
                if (i2 < 8192) {
                    i2 = 8192;
                } else if (i2 > 131072) {
                    i2 = 131072;
                }
                this.f69646a = new BufferedOutputStream(new FileOutputStream(this.f69648c.getFD()), i2);
                return;
            }
            this.f69646a = new BufferedOutputStream(new FileOutputStream(this.f69648c.getFD()));
        } catch (IOException e2) {
            throw new BaseException((int) ScanCodeConstant.B_SAO_C_NORMAL_AUTH_SERVICE_TYPE, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
            this.f69646a.write(bArr, i2, i3);
        }
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bufferedOutputStream = this.f69646a) == null) {
            return;
        }
        bufferedOutputStream.flush();
    }

    public void c() throws IOException {
        FileDescriptor fileDescriptor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fileDescriptor = this.f69647b) == null) {
            return;
        }
        fileDescriptor.sync();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f.a(this.f69648c, this.f69646a);
        }
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BufferedOutputStream bufferedOutputStream = this.f69646a;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
            }
            FileDescriptor fileDescriptor = this.f69647b;
            if (fileDescriptor != null) {
                fileDescriptor.sync();
            }
        }
    }

    public void b(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f69648c.setLength(j);
        }
    }

    public void a(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f69648c.seek(j);
        }
    }
}
