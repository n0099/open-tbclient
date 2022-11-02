package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
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
/* loaded from: classes7.dex */
public final class ContentDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AssetFileDescriptor assetFileDescriptor;
    public long bytesRemaining;
    public FileInputStream inputStream;
    public final TransferListener<? super ContentDataSource> listener;
    public boolean opened;
    public final ContentResolver resolver;
    public Uri uri;

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentDataSource(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (TransferListener) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ContentDataSource(Context context, TransferListener<? super ContentDataSource> transferListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transferListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.resolver = context.getContentResolver();
        this.listener = transferListener;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws ContentDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.uri = null;
            try {
                try {
                    if (this.inputStream != null) {
                        this.inputStream.close();
                    }
                    this.inputStream = null;
                    try {
                        try {
                            if (this.assetFileDescriptor != null) {
                                this.assetFileDescriptor.close();
                            }
                        } catch (IOException e) {
                            throw new ContentDataSourceException(e);
                        }
                    } finally {
                        this.assetFileDescriptor = null;
                        if (this.opened) {
                            this.opened = false;
                            TransferListener<? super ContentDataSource> transferListener = this.listener;
                            if (transferListener != null) {
                                transferListener.onTransferEnd(this);
                            }
                        }
                    }
                } catch (IOException e2) {
                    throw new ContentDataSourceException(e2);
                }
            } catch (Throwable th) {
                this.inputStream = null;
                try {
                    try {
                        if (this.assetFileDescriptor != null) {
                            this.assetFileDescriptor.close();
                        }
                        this.assetFileDescriptor = null;
                        if (this.opened) {
                            this.opened = false;
                            TransferListener<? super ContentDataSource> transferListener2 = this.listener;
                            if (transferListener2 != null) {
                                transferListener2.onTransferEnd(this);
                            }
                        }
                        throw th;
                    } catch (IOException e3) {
                        throw new ContentDataSourceException(e3);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener<? super ContentDataSource> transferListener3 = this.listener;
                        if (transferListener3 != null) {
                            transferListener3.onTransferEnd(this);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.uri;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws ContentDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            try {
                Uri uri = dataSpec.uri;
                this.uri = uri;
                AssetFileDescriptor openAssetFileDescriptor = this.resolver.openAssetFileDescriptor(uri, "r");
                this.assetFileDescriptor = openAssetFileDescriptor;
                if (openAssetFileDescriptor != null) {
                    this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                    long startOffset = this.assetFileDescriptor.getStartOffset();
                    long skip = this.inputStream.skip(dataSpec.position + startOffset) - startOffset;
                    if (skip == dataSpec.position) {
                        long j = -1;
                        if (dataSpec.length != -1) {
                            this.bytesRemaining = dataSpec.length;
                        } else {
                            long length = this.assetFileDescriptor.getLength();
                            if (length == -1) {
                                FileChannel channel = this.inputStream.getChannel();
                                long size = channel.size();
                                if (size != 0) {
                                    j = size - channel.position();
                                }
                                this.bytesRemaining = j;
                            } else {
                                this.bytesRemaining = length - skip;
                            }
                        }
                        this.opened = true;
                        TransferListener<? super ContentDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferStart(this, dataSpec);
                        }
                        return this.bytesRemaining;
                    }
                    throw new EOFException();
                }
                throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            }
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            long j = this.bytesRemaining;
            if (j == 0) {
                return -1;
            }
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new ContentDataSourceException(e);
                }
            }
            int read = this.inputStream.read(bArr, i, i2);
            if (read == -1) {
                if (this.bytesRemaining == -1) {
                    return -1;
                }
                throw new ContentDataSourceException(new EOFException());
            }
            long j2 = this.bytesRemaining;
            if (j2 != -1) {
                this.bytesRemaining = j2 - read;
            }
            TransferListener<? super ContentDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onBytesTransferred(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
