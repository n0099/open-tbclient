package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import c.i.b.a.h0.e;
import c.i.b.a.h0.g;
import c.i.b.a.h0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public final class AssetDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f70538a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super AssetDataSource> f70539b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f70540c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f70541d;

    /* renamed from: e  reason: collision with root package name */
    public long f70542e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70543f;

    /* loaded from: classes9.dex */
    public static final class AssetDataSourceException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetDataSourceException(IOException iOException) {
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

    public AssetDataSource(Context context, p<? super AssetDataSource> pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70538a = context.getAssets();
        this.f70539b = pVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws AssetDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.f33729a;
                this.f70540c = uri;
                String path = uri.getPath();
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                InputStream open = this.f70538a.open(path, 1);
                this.f70541d = open;
                if (open.skip(gVar.f33732d) >= gVar.f33732d) {
                    if (gVar.f33733e != -1) {
                        this.f70542e = gVar.f33733e;
                    } else {
                        long available = this.f70541d.available();
                        this.f70542e = available;
                        if (available == 2147483647L) {
                            this.f70542e = -1L;
                        }
                    }
                    this.f70543f = true;
                    p<? super AssetDataSource> pVar = this.f70539b;
                    if (pVar != null) {
                        pVar.d(this, gVar);
                    }
                    return this.f70542e;
                }
                throw new EOFException();
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws AssetDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70540c = null;
            try {
                try {
                    if (this.f70541d != null) {
                        this.f70541d.close();
                    }
                } catch (IOException e2) {
                    throw new AssetDataSourceException(e2);
                }
            } finally {
                this.f70541d = null;
                if (this.f70543f) {
                    this.f70543f = false;
                    p<? super AssetDataSource> pVar = this.f70539b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70540c : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f70542e;
            if (j2 == 0) {
                return -1;
            }
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new AssetDataSourceException(e2);
                }
            }
            int read = this.f70541d.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f70542e == -1) {
                    return -1;
                }
                throw new AssetDataSourceException(new EOFException());
            }
            long j3 = this.f70542e;
            if (j3 != -1) {
                this.f70542e = j3 - read;
            }
            p<? super AssetDataSource> pVar = this.f70539b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
