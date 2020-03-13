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
    private final q<? super UdpDataSource> mFU;
    private boolean mFV;
    private final int mHd;
    private final byte[] mHe;
    private final DatagramPacket mHf;
    private DatagramSocket mHg;
    private MulticastSocket mHh;
    private InetAddress mHi;
    private InetSocketAddress mHj;
    private int mHk;
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
            this.mHi = InetAddress.getByName(host);
            this.mHj = new InetSocketAddress(this.mHi, port);
            if (this.mHi.isMulticastAddress()) {
                this.mHh = new MulticastSocket(this.mHj);
                this.mHh.joinGroup(this.mHi);
                this.mHg = this.mHh;
            } else {
                this.mHg = new DatagramSocket(this.mHj);
            }
            try {
                this.mHg.setSoTimeout(this.mHd);
                this.mFV = true;
                if (this.mFU != null) {
                    this.mFU.a(this, gVar);
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
        if (this.mHk == 0) {
            try {
                this.mHg.receive(this.mHf);
                this.mHk = this.mHf.getLength();
                if (this.mFU != null) {
                    this.mFU.h(this, this.mHk);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mHf.getLength() - this.mHk;
        int min = Math.min(this.mHk, i2);
        System.arraycopy(this.mHe, length, bArr, i, min);
        this.mHk -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mHh != null) {
            try {
                this.mHh.leaveGroup(this.mHi);
            } catch (IOException e) {
            }
            this.mHh = null;
        }
        if (this.mHg != null) {
            this.mHg.close();
            this.mHg = null;
        }
        this.mHi = null;
        this.mHj = null;
        this.mHk = 0;
        if (this.mFV) {
            this.mFV = false;
            if (this.mFU != null) {
                this.mFU.bB(this);
            }
        }
    }
}
