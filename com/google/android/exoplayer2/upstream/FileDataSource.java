package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.h0.e;
import d.f.b.a.h0.g;
import d.f.b.a.h0.p;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class FileDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p<? super FileDataSource> f32817a;

    /* renamed from: b  reason: collision with root package name */
    public RandomAccessFile f32818b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f32819c;

    /* renamed from: d  reason: collision with root package name */
    public long f32820d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32821e;

    /* loaded from: classes6.dex */
    public static class FileDataSourceException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileDataSourceException(IOException iOException) {
            super(iOException);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iOException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public FileDataSource(p<? super FileDataSource> pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32817a = pVar;
    }

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws FileDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                this.f32819c = gVar.f73280a;
                RandomAccessFile randomAccessFile = new RandomAccessFile(gVar.f73280a.getPath(), r.f7745a);
                this.f32818b = randomAccessFile;
                randomAccessFile.seek(gVar.f73283d);
                long length = gVar.f73284e == -1 ? this.f32818b.length() - gVar.f73283d : gVar.f73284e;
                this.f32820d = length;
                if (length >= 0) {
                    this.f32821e = true;
                    p<? super FileDataSource> pVar = this.f32817a;
                    if (pVar != null) {
                        pVar.d(this, gVar);
                    }
                    return this.f32820d;
                }
                throw new EOFException();
            } catch (IOException e2) {
                throw new FileDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws FileDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32819c = null;
            try {
                try {
                    if (this.f32818b != null) {
                        this.f32818b.close();
                    }
                } catch (IOException e2) {
                    throw new FileDataSourceException(e2);
                }
            } finally {
                this.f32818b = null;
                if (this.f32821e) {
                    this.f32821e = false;
                    p<? super FileDataSource> pVar = this.f32817a;
                    if (pVar != null) {
                        pVar.b(this);
                    }
                }
            }
        }
    }

    @Override // d.f.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32819c : (Uri) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws FileDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j = this.f32820d;
            if (j == 0) {
                return -1;
            }
            try {
                int read = this.f32818b.read(bArr, i2, (int) Math.min(j, i3));
                if (read > 0) {
                    this.f32820d -= read;
                    p<? super FileDataSource> pVar = this.f32817a;
                    if (pVar != null) {
                        pVar.a(this, read);
                    }
                }
                return read;
            } catch (IOException e2) {
                throw new FileDataSourceException(e2);
            }
        }
        return invokeLII.intValue;
    }
}
