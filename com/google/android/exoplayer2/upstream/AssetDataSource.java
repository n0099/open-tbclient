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
    public final AssetManager f70503a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super AssetDataSource> f70504b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f70505c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f70506d;

    /* renamed from: e  reason: collision with root package name */
    public long f70507e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70508f;

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
        this.f70503a = context.getAssets();
        this.f70504b = pVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws AssetDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.f33725a;
                this.f70505c = uri;
                String path = uri.getPath();
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                InputStream open = this.f70503a.open(path, 1);
                this.f70506d = open;
                if (open.skip(gVar.f33728d) >= gVar.f33728d) {
                    if (gVar.f33729e != -1) {
                        this.f70507e = gVar.f33729e;
                    } else {
                        long available = this.f70506d.available();
                        this.f70507e = available;
                        if (available == 2147483647L) {
                            this.f70507e = -1L;
                        }
                    }
                    this.f70508f = true;
                    p<? super AssetDataSource> pVar = this.f70504b;
                    if (pVar != null) {
                        pVar.d(this, gVar);
                    }
                    return this.f70507e;
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
            this.f70505c = null;
            try {
                try {
                    if (this.f70506d != null) {
                        this.f70506d.close();
                    }
                } catch (IOException e2) {
                    throw new AssetDataSourceException(e2);
                }
            } finally {
                this.f70506d = null;
                if (this.f70508f) {
                    this.f70508f = false;
                    p<? super AssetDataSource> pVar = this.f70504b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70505c : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f70507e;
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
            int read = this.f70506d.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f70507e == -1) {
                    return -1;
                }
                throw new AssetDataSourceException(new EOFException());
            }
            long j3 = this.f70507e;
            if (j3 != -1) {
                this.f70507e = j3 - read;
            }
            p<? super AssetDataSource> pVar = this.f70504b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
