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
    private final q<? super UdpDataSource> mFJ;
    private boolean mFK;
    private final int mGS;
    private final byte[] mGT;
    private final DatagramPacket mGU;
    private DatagramSocket mGV;
    private MulticastSocket mGW;
    private InetAddress mGX;
    private InetSocketAddress mGY;
    private int mGZ;
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
            this.mGX = InetAddress.getByName(host);
            this.mGY = new InetSocketAddress(this.mGX, port);
            if (this.mGX.isMulticastAddress()) {
                this.mGW = new MulticastSocket(this.mGY);
                this.mGW.joinGroup(this.mGX);
                this.mGV = this.mGW;
            } else {
                this.mGV = new DatagramSocket(this.mGY);
            }
            try {
                this.mGV.setSoTimeout(this.mGS);
                this.mFK = true;
                if (this.mFJ != null) {
                    this.mFJ.a(this, gVar);
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
        if (this.mGZ == 0) {
            try {
                this.mGV.receive(this.mGU);
                this.mGZ = this.mGU.getLength();
                if (this.mFJ != null) {
                    this.mFJ.h(this, this.mGZ);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mGU.getLength() - this.mGZ;
        int min = Math.min(this.mGZ, i2);
        System.arraycopy(this.mGT, length, bArr, i, min);
        this.mGZ -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mGW != null) {
            try {
                this.mGW.leaveGroup(this.mGX);
            } catch (IOException e) {
            }
            this.mGW = null;
        }
        if (this.mGV != null) {
            this.mGV.close();
            this.mGV = null;
        }
        this.mGX = null;
        this.mGY = null;
        this.mGZ = 0;
        if (this.mFK) {
            this.mFK = false;
            if (this.mFJ != null) {
                this.mFJ.bB(this);
            }
        }
    }
}
