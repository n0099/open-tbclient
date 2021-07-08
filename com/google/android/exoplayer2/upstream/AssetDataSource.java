package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class AssetDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f32914a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super AssetDataSource> f32915b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f32916c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f32917d;

    /* renamed from: e  reason: collision with root package name */
    public long f32918e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32919f;

    /* loaded from: classes5.dex */
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
        this.f32914a = context.getAssets();
        this.f32915b = pVar;
    }

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws AssetDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.f70383a;
                this.f32916c = uri;
                String path = uri.getPath();
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                InputStream open = this.f32914a.open(path, 1);
                this.f32917d = open;
                if (open.skip(gVar.f70386d) >= gVar.f70386d) {
                    if (gVar.f70387e != -1) {
                        this.f32918e = gVar.f70387e;
                    } else {
                        long available = this.f32917d.available();
                        this.f32918e = available;
                        if (available == 2147483647L) {
                            this.f32918e = -1L;
                        }
                    }
                    this.f32919f = true;
                    p<? super AssetDataSource> pVar = this.f32915b;
                    if (pVar != null) {
                        pVar.d(this, gVar);
                    }
                    return this.f32918e;
                }
                throw new EOFException();
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws AssetDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32916c = null;
            try {
                try {
                    if (this.f32917d != null) {
                        this.f32917d.close();
                    }
                } catch (IOException e2) {
                    throw new AssetDataSourceException(e2);
                }
            } finally {
                this.f32917d = null;
                if (this.f32919f) {
                    this.f32919f = false;
                    p<? super AssetDataSource> pVar = this.f32915b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32916c : (Uri) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j = this.f32918e;
            if (j == 0) {
                return -1;
            }
            if (j != -1) {
                try {
                    i3 = (int) Math.min(j, i3);
                } catch (IOException e2) {
                    throw new AssetDataSourceException(e2);
                }
            }
            int read = this.f32917d.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f32918e == -1) {
                    return -1;
                }
                throw new AssetDataSourceException(new EOFException());
            }
            long j2 = this.f32918e;
            if (j2 != -1) {
                this.f32918e = j2 - read;
            }
            p<? super AssetDataSource> pVar = this.f32915b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
