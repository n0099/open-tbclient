package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import b.h.b.a.h0.e;
import b.h.b.a.h0.g;
import b.h.b.a.h0.p;
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
/* loaded from: classes11.dex */
public final class ContentDataSource implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f63954a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super ContentDataSource> f63955b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f63956c;

    /* renamed from: d  reason: collision with root package name */
    public AssetFileDescriptor f63957d;

    /* renamed from: e  reason: collision with root package name */
    public FileInputStream f63958e;

    /* renamed from: f  reason: collision with root package name */
    public long f63959f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63960g;

    /* loaded from: classes11.dex */
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
        this.f63954a = context.getContentResolver();
        this.f63955b = pVar;
    }

    @Override // b.h.b.a.h0.e
    public long a(g gVar) throws ContentDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Uri uri = gVar.f33387a;
                this.f63956c = uri;
                AssetFileDescriptor openAssetFileDescriptor = this.f63954a.openAssetFileDescriptor(uri, r.f41000a);
                this.f63957d = openAssetFileDescriptor;
                if (openAssetFileDescriptor != null) {
                    this.f63958e = new FileInputStream(this.f63957d.getFileDescriptor());
                    long startOffset = this.f63957d.getStartOffset();
                    long skip = this.f63958e.skip(gVar.f33390d + startOffset) - startOffset;
                    if (skip == gVar.f33390d) {
                        long j = -1;
                        if (gVar.f33391e != -1) {
                            this.f63959f = gVar.f33391e;
                        } else {
                            long length = this.f63957d.getLength();
                            if (length == -1) {
                                FileChannel channel = this.f63958e.getChannel();
                                long size = channel.size();
                                if (size != 0) {
                                    j = size - channel.position();
                                }
                                this.f63959f = j;
                            } else {
                                this.f63959f = length - skip;
                            }
                        }
                        this.f63960g = true;
                        p<? super ContentDataSource> pVar = this.f63955b;
                        if (pVar != null) {
                            pVar.d(this, gVar);
                        }
                        return this.f63959f;
                    }
                    throw new EOFException();
                }
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f63956c);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // b.h.b.a.h0.e
    public void close() throws ContentDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f63956c = null;
            try {
                try {
                    if (this.f63958e != null) {
                        this.f63958e.close();
                    }
                    this.f63958e = null;
                    try {
                        try {
                            if (this.f63957d != null) {
                                this.f63957d.close();
                            }
                        } catch (IOException e2) {
                            throw new ContentDataSourceException(e2);
                        }
                    } finally {
                        this.f63957d = null;
                        if (this.f63960g) {
                            this.f63960g = false;
                            p<? super ContentDataSource> pVar = this.f63955b;
                            if (pVar != null) {
                                pVar.b(this);
                            }
                        }
                    }
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } catch (Throwable th) {
                this.f63958e = null;
                try {
                    try {
                        if (this.f63957d != null) {
                            this.f63957d.close();
                        }
                        this.f63957d = null;
                        if (this.f63960g) {
                            this.f63960g = false;
                            p<? super ContentDataSource> pVar2 = this.f63955b;
                            if (pVar2 != null) {
                                pVar2.b(this);
                            }
                        }
                        throw th;
                    } catch (IOException e4) {
                        throw new ContentDataSourceException(e4);
                    }
                } finally {
                    this.f63957d = null;
                    if (this.f63960g) {
                        this.f63960g = false;
                        p<? super ContentDataSource> pVar3 = this.f63955b;
                        if (pVar3 != null) {
                            pVar3.b(this);
                        }
                    }
                }
            }
        }
    }

    @Override // b.h.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63956c : (Uri) invokeV.objValue;
    }

    @Override // b.h.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            long j = this.f63959f;
            if (j == 0) {
                return -1;
            }
            if (j != -1) {
                try {
                    i3 = (int) Math.min(j, i3);
                } catch (IOException e2) {
                    throw new ContentDataSourceException(e2);
                }
            }
            int read = this.f63958e.read(bArr, i2, i3);
            if (read == -1) {
                if (this.f63959f == -1) {
                    return -1;
                }
                throw new ContentDataSourceException(new EOFException());
            }
            long j2 = this.f63959f;
            if (j2 != -1) {
                this.f63959f = j2 - read;
            }
            p<? super ContentDataSource> pVar = this.f63955b;
            if (pVar != null) {
                pVar.a(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
