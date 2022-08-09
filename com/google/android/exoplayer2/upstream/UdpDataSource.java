package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: classes5.dex */
public final class UdpDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEAFULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public InetAddress address;
    public final TransferListener<? super UdpDataSource> listener;
    public MulticastSocket multicastSocket;
    public boolean opened;
    public final DatagramPacket packet;
    public final byte[] packetBuffer;
    public int packetRemaining;
    public DatagramSocket socket;
    public InetSocketAddress socketAddress;
    public final int socketTimeoutMillis;
    public Uri uri;

    /* loaded from: classes5.dex */
    public static final class UdpDataSourceException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UdpDataSourceException(IOException iOException) {
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
    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener) {
        this(transferListener, 2000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transferListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TransferListener) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.uri = null;
            MulticastSocket multicastSocket = this.multicastSocket;
            if (multicastSocket != null) {
                try {
                    multicastSocket.leaveGroup(this.address);
                } catch (IOException unused) {
                }
                this.multicastSocket = null;
            }
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket != null) {
                datagramSocket.close();
                this.socket = null;
            }
            this.address = null;
            this.socketAddress = null;
            this.packetRemaining = 0;
            if (this.opened) {
                this.opened = false;
                TransferListener<? super UdpDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd(this);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uri : (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws UdpDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            String host = uri.getHost();
            int port = this.uri.getPort();
            try {
                this.address = InetAddress.getByName(host);
                this.socketAddress = new InetSocketAddress(this.address, port);
                if (this.address.isMulticastAddress()) {
                    MulticastSocket multicastSocket = new MulticastSocket(this.socketAddress);
                    this.multicastSocket = multicastSocket;
                    multicastSocket.joinGroup(this.address);
                    this.socket = this.multicastSocket;
                } else {
                    this.socket = new DatagramSocket(this.socketAddress);
                }
                try {
                    this.socket.setSoTimeout(this.socketTimeoutMillis);
                    this.opened = true;
                    TransferListener<? super UdpDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferStart(this, dataSpec);
                        return -1L;
                    }
                    return -1L;
                } catch (SocketException e) {
                    throw new UdpDataSourceException(e);
                }
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2);
            }
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            if (this.packetRemaining == 0) {
                try {
                    this.socket.receive(this.packet);
                    int length = this.packet.getLength();
                    this.packetRemaining = length;
                    TransferListener<? super UdpDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onBytesTransferred(this, length);
                    }
                } catch (IOException e) {
                    throw new UdpDataSourceException(e);
                }
            }
            int length2 = this.packet.getLength();
            int i3 = this.packetRemaining;
            int min = Math.min(i3, i2);
            System.arraycopy(this.packetBuffer, length2 - i3, bArr, i, min);
            this.packetRemaining -= min;
            return min;
        }
        return invokeLII.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener, int i) {
        this(transferListener, i, 8000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transferListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TransferListener) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transferListener, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.listener = transferListener;
        this.socketTimeoutMillis = i2;
        this.packetBuffer = new byte[i];
        this.packet = new DatagramPacket(this.packetBuffer, 0, i);
    }
}
