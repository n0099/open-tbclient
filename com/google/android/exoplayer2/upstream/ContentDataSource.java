package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes9.dex */
public final class ContentDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f70544a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super ContentDataSource> f70545b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f70546c;

    /* renamed from: d  reason: collision with root package name */
    public AssetFileDescriptor f70547d;

    /* renamed from: e  reason: collision with root package name */
    public FileInputStream f70548e;

    /* renamed from: f  reason: collision with root package name */
    public long f70549f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70550g;

    /* loaded from: classes9.dex */
    public static class ContentDataSourceException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentDataSourceException(IOException iOException) {
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

    public ContentDataSource(Context context, p<? super ContentDataSource> pVar) {
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
        this.f70544a = context.getContentResolver();
        this.f70545b = pVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws ContentDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.f33729a;
                this.f70546c = uri;
                AssetFileDescriptor openAssetFileDescriptor = this.f70544a.openAssetFileDescriptor(uri, r.f42346a);
                this.f70547d = openAssetFileDescriptor;
                if (openAssetFileDescriptor != null) {
                    this.f70548e = new FileInputStream(this.f70547d.getFileDescriptor());
                    long startOffset = this.f70547d.getStartOffset();
                    long skip = this.f70548e.skip(gVar.f33732d + startOffset) - startOffset;
                    if (skip == gVar.f33732d) {
                        long j2 = -1;
                        if (gVar.f33733e != -1) {
                            this.f70549f = gVar.f33733e;
                        } else {
                            long length = this.f70547d.getLength();
                            if (length == -1) {
                                FileChannel channel = this.f70548e.getChannel();
                                long size = channel.size();
                                if (size != 0) {
                                    j2 = size - channel.position();
                                }
                                this.f70549f = j2;
                            } else {
                                this.f70549f = length - skip;
                            }
                        }
                        this.f70550g = true;
                        p<? super ContentDataSource> pVar = this.f70545b;
                        if (pVar != null) {
                            pVar.d(this, gVar);
                        }
                        return this.f70549f;
                    }
                    throw new EOFException();
                }
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f70546c);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // c.i.b.a.h0.e
    public void close() throws ContentDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70546c = null;
            try {
                try {
                    if (this.f70548e != null) {
                        this.f70548e.close();
                    }
                    this.f70548e = null;
                    try {
                        try {
                            if (this.f70547d != null) {
                                this.f70547d.close();
                            }
                        } catch (IOException e2) {
                            throw new ContentDataSourceException(e2);
                        }
                    } finally {
                        this.f70547d = null;
                        if (this.f70550g) {
                            this.f70550g = false;
                            p<? super ContentDataSource> pVar = this.f70545b;
                            if (pVar != null) {
                                pVar.b(this);
                            }
                        }
                    }
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } catch (Throwable th) {
                this.f70548e = null;
                try {
                    try {
                        if (this.f70547d != null) {
                            this.f70547d.close();
                        }
                        this.f70547d = null;
                        if (this.f70550g) {
                            this.f70550g = false;
                            p<? super ContentDataSource> pVar2 = this.f70545b;
                            if (pVar2 != null) {
                                pVar2.b(this);
                            }
                        }
                        throw th;
                    } catch (IOException e4) {
                        throw new ContentDataSourceException(e4);
                    }
                } finally {
                    this.f70547d = null;
                    if (this.f70550g) {
                        this.f70550g = false;
                        p<? super ContentDataSource> pVar3 = this.f70545b;
                        if (pVar3 != null) {
                            pVar3.b(this);
                        }
                    }
                }
            }
        }
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70546c : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f70549f;
            if (j2 == 0) {
                return -1;
            }
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new ContentDataSourceException(e2);
                }
            }
            int read = this.f70548e.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f70549f == -1) {
                    return -1;
                }
                throw new ContentDataSourceException(new EOFException());
            }
            long j3 = this.f70549f;
            if (j3 != -1) {
                this.f70549f = j3 - read;
            }
            p<? super ContentDataSource> pVar = this.f70545b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
