package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import c.i.b.a.h0.e;
import c.i.b.a.h0.g;
import c.i.b.a.h0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes9.dex */
public final class FileDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p<? super FileDataSource> f70017a;

    /* renamed from: b  reason: collision with root package name */
    public RandomAccessFile f70018b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f70019c;

    /* renamed from: d  reason: collision with root package name */
    public long f70020d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70021e;

    /* loaded from: classes9.dex */
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
        this.f70017a = pVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws FileDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                this.f70019c = gVar.f33593a;
                RandomAccessFile randomAccessFile = new RandomAccessFile(gVar.f33593a.getPath(), r.f42169a);
                this.f70018b = randomAccessFile;
                randomAccessFile.seek(gVar.f33596d);
                long length = gVar.f33597e == -1 ? this.f70018b.length() - gVar.f33596d : gVar.f33597e;
                this.f70020d = length;
                if (length >= 0) {
                    this.f70021e = true;
                    p<? super FileDataSource> pVar = this.f70017a;
                    if (pVar != null) {
                        pVar.d(this, gVar);
                    }
                    return this.f70020d;
                }
                throw new EOFException();
            } catch (IOException e2) {
                throw new FileDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws FileDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70019c = null;
            try {
                try {
                    if (this.f70018b != null) {
                        this.f70018b.close();
                    }
                } catch (IOException e2) {
                    throw new FileDataSourceException(e2);
                }
            } finally {
                this.f70018b = null;
                if (this.f70021e) {
                    this.f70021e = false;
                    p<? super FileDataSource> pVar = this.f70017a;
                    if (pVar != null) {
                        pVar.b(this);
                    }
                }
            }
        }
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70019c : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws FileDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f70020d;
            if (j2 == 0) {
                return -1;
            }
            try {
                int read = this.f70018b.read(bArr, i2, (int) Math.min(j2, i3));
                if (read > 0) {
                    this.f70020d -= read;
                    p<? super FileDataSource> pVar = this.f70017a;
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
