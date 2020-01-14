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
    private final q<? super UdpDataSource> mFa;
    private boolean mFb;
    private final int mGk;
    private final byte[] mGl;
    private final DatagramPacket mGm;
    private DatagramSocket mGn;
    private MulticastSocket mGo;
    private InetAddress mGp;
    private InetSocketAddress mGq;
    private int mGr;
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
            this.mGp = InetAddress.getByName(host);
            this.mGq = new InetSocketAddress(this.mGp, port);
            if (this.mGp.isMulticastAddress()) {
                this.mGo = new MulticastSocket(this.mGq);
                this.mGo.joinGroup(this.mGp);
                this.mGn = this.mGo;
            } else {
                this.mGn = new DatagramSocket(this.mGq);
            }
            try {
                this.mGn.setSoTimeout(this.mGk);
                this.mFb = true;
                if (this.mFa != null) {
                    this.mFa.a(this, gVar);
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
        if (this.mGr == 0) {
            try {
                this.mGn.receive(this.mGm);
                this.mGr = this.mGm.getLength();
                if (this.mFa != null) {
                    this.mFa.h(this, this.mGr);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mGm.getLength() - this.mGr;
        int min = Math.min(this.mGr, i2);
        System.arraycopy(this.mGl, length, bArr, i, min);
        this.mGr -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mGo != null) {
            try {
                this.mGo.leaveGroup(this.mGp);
            } catch (IOException e) {
            }
            this.mGo = null;
        }
        if (this.mGn != null) {
            this.mGn.close();
            this.mGn = null;
        }
        this.mGp = null;
        this.mGq = null;
        this.mGr = 0;
        if (this.mFb) {
            this.mFb = false;
            if (this.mFa != null) {
                this.mFa.bz(this);
            }
        }
    }
}
