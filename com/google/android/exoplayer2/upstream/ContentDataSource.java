package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes3.dex */
public final class ContentDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super ContentDataSource> f54390b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f54391c;

    /* renamed from: d  reason: collision with root package name */
    public AssetFileDescriptor f54392d;

    /* renamed from: e  reason: collision with root package name */
    public FileInputStream f54393e;

    /* renamed from: f  reason: collision with root package name */
    public long f54394f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54395g;

    /* loaded from: classes3.dex */
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
        this.a = context.getContentResolver();
        this.f54390b = pVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws ContentDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.a;
                this.f54391c = uri;
                AssetFileDescriptor openAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, "r");
                this.f54392d = openAssetFileDescriptor;
                if (openAssetFileDescriptor != null) {
                    this.f54393e = new FileInputStream(this.f54392d.getFileDescriptor());
                    long startOffset = this.f54392d.getStartOffset();
                    long skip = this.f54393e.skip(gVar.f29657d + startOffset) - startOffset;
                    if (skip == gVar.f29657d) {
                        long j2 = -1;
                        if (gVar.f29658e != -1) {
                            this.f54394f = gVar.f29658e;
                        } else {
                            long length = this.f54392d.getLength();
                            if (length == -1) {
                                FileChannel channel = this.f54393e.getChannel();
                                long size = channel.size();
                                if (size != 0) {
                                    j2 = size - channel.position();
                                }
                                this.f54394f = j2;
                            } else {
                                this.f54394f = length - skip;
                            }
                        }
                        this.f54395g = true;
                        p<? super ContentDataSource> pVar = this.f54390b;
                        if (pVar != null) {
                            pVar.d(this, gVar);
                        }
                        return this.f54394f;
                    }
                    throw new EOFException();
                }
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f54391c);
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
            this.f54391c = null;
            try {
                try {
                    if (this.f54393e != null) {
                        this.f54393e.close();
                    }
                    this.f54393e = null;
                    try {
                        try {
                            if (this.f54392d != null) {
                                this.f54392d.close();
                            }
                        } catch (IOException e2) {
                            throw new ContentDataSourceException(e2);
                        }
                    } finally {
                        this.f54392d = null;
                        if (this.f54395g) {
                            this.f54395g = false;
                            p<? super ContentDataSource> pVar = this.f54390b;
                            if (pVar != null) {
                                pVar.b(this);
                            }
                        }
                    }
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } catch (Throwable th) {
                this.f54393e = null;
                try {
                    try {
                        if (this.f54392d != null) {
                            this.f54392d.close();
                        }
                        this.f54392d = null;
                        if (this.f54395g) {
                            this.f54395g = false;
                            p<? super ContentDataSource> pVar2 = this.f54390b;
                            if (pVar2 != null) {
                                pVar2.b(this);
                            }
                        }
                        throw th;
                    } catch (IOException e4) {
                        throw new ContentDataSourceException(e4);
                    }
                } finally {
                    this.f54392d = null;
                    if (this.f54395g) {
                        this.f54395g = false;
                        p<? super ContentDataSource> pVar3 = this.f54390b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54391c : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f54394f;
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
            int read = this.f54393e.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f54394f == -1) {
                    return -1;
                }
                throw new ContentDataSourceException(new EOFException());
            }
            long j3 = this.f54394f;
            if (j3 != -1) {
                this.f54394f = j3 - read;
            }
            p<? super ContentDataSource> pVar = this.f54390b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
