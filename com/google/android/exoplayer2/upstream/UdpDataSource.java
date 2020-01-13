package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: classes5.dex */
public final class UdpDataSource implements e {
    private final q<? super UdpDataSource> mEV;
    private boolean mEW;
    private final int mGf;
    private final byte[] mGg;
    private final DatagramPacket mGh;
    private DatagramSocket mGi;
    private MulticastSocket mGj;
    private InetAddress mGk;
    private InetSocketAddress mGl;
    private int mGm;
    private Uri uri;

    /* loaded from: classes5.dex */
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
            this.mGk = InetAddress.getByName(host);
            this.mGl = new InetSocketAddress(this.mGk, port);
            if (this.mGk.isMulticastAddress()) {
                this.mGj = new MulticastSocket(this.mGl);
                this.mGj.joinGroup(this.mGk);
                this.mGi = this.mGj;
            } else {
                this.mGi = new DatagramSocket(this.mGl);
            }
            try {
                this.mGi.setSoTimeout(this.mGf);
                this.mEW = true;
                if (this.mEV != null) {
                    this.mEV.a(this, gVar);
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
        if (this.mGm == 0) {
            try {
                this.mGi.receive(this.mGh);
                this.mGm = this.mGh.getLength();
                if (this.mEV != null) {
                    this.mEV.h(this, this.mGm);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mGh.getLength() - this.mGm;
        int min = Math.min(this.mGm, i2);
        System.arraycopy(this.mGg, length, bArr, i, min);
        this.mGm -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mGj != null) {
            try {
                this.mGj.leaveGroup(this.mGk);
            } catch (IOException e) {
            }
            this.mGj = null;
        }
        if (this.mGi != null) {
            this.mGi.close();
            this.mGi = null;
        }
        this.mGk = null;
        this.mGl = null;
        this.mGm = 0;
        if (this.mEW) {
            this.mEW = false;
            if (this.mEV != null) {
                this.mEV.bz(this);
            }
        }
    }
}
