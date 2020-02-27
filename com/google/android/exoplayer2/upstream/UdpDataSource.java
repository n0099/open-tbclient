package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: classes6.dex */
public final class UdpDataSource implements e {
    private final q<? super UdpDataSource> mFH;
    private boolean mFI;
    private final int mGQ;
    private final byte[] mGR;
    private final DatagramPacket mGS;
    private DatagramSocket mGT;
    private MulticastSocket mGU;
    private InetAddress mGV;
    private InetSocketAddress mGW;
    private int mGX;
    private Uri uri;

    /* loaded from: classes6.dex */
    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws UdpDataSourceException {
        this.uri = gVar.uri;
        String host = this.uri.getHost();
        int port = this.uri.getPort();
        try {
            this.mGV = InetAddress.getByName(host);
            this.mGW = new InetSocketAddress(this.mGV, port);
            if (this.mGV.isMulticastAddress()) {
                this.mGU = new MulticastSocket(this.mGW);
                this.mGU.joinGroup(this.mGV);
                this.mGT = this.mGU;
            } else {
                this.mGT = new DatagramSocket(this.mGW);
            }
            try {
                this.mGT.setSoTimeout(this.mGQ);
                this.mFI = true;
                if (this.mFH != null) {
                    this.mFH.a(this, gVar);
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

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.mGX == 0) {
            try {
                this.mGT.receive(this.mGS);
                this.mGX = this.mGS.getLength();
                if (this.mFH != null) {
                    this.mFH.h(this, this.mGX);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mGS.getLength() - this.mGX;
        int min = Math.min(this.mGX, i2);
        System.arraycopy(this.mGR, length, bArr, i, min);
        this.mGX -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mGU != null) {
            try {
                this.mGU.leaveGroup(this.mGV);
            } catch (IOException e) {
            }
            this.mGU = null;
        }
        if (this.mGT != null) {
            this.mGT.close();
            this.mGT = null;
        }
        this.mGV = null;
        this.mGW = null;
        this.mGX = 0;
        if (this.mFI) {
            this.mFI = false;
            if (this.mFH != null) {
                this.mFH.bB(this);
            }
        }
    }
}
