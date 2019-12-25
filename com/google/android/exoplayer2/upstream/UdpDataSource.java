package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: classes4.dex */
public final class UdpDataSource implements e {
    private final q<? super UdpDataSource> mBd;
    private boolean mBe;
    private final int mCn;
    private final byte[] mCo;
    private final DatagramPacket mCp;
    private DatagramSocket mCq;
    private MulticastSocket mCr;
    private InetAddress mCs;
    private InetSocketAddress mCt;
    private int mCu;
    private Uri uri;

    /* loaded from: classes4.dex */
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
            this.mCs = InetAddress.getByName(host);
            this.mCt = new InetSocketAddress(this.mCs, port);
            if (this.mCs.isMulticastAddress()) {
                this.mCr = new MulticastSocket(this.mCt);
                this.mCr.joinGroup(this.mCs);
                this.mCq = this.mCr;
            } else {
                this.mCq = new DatagramSocket(this.mCt);
            }
            try {
                this.mCq.setSoTimeout(this.mCn);
                this.mBe = true;
                if (this.mBd != null) {
                    this.mBd.a(this, gVar);
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
        if (this.mCu == 0) {
            try {
                this.mCq.receive(this.mCp);
                this.mCu = this.mCp.getLength();
                if (this.mBd != null) {
                    this.mBd.h(this, this.mCu);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mCp.getLength() - this.mCu;
        int min = Math.min(this.mCu, i2);
        System.arraycopy(this.mCo, length, bArr, i, min);
        this.mCu -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mCr != null) {
            try {
                this.mCr.leaveGroup(this.mCs);
            } catch (IOException e) {
            }
            this.mCr = null;
        }
        if (this.mCq != null) {
            this.mCq.close();
            this.mCq = null;
        }
        this.mCs = null;
        this.mCt = null;
        this.mCu = 0;
        if (this.mBe) {
            this.mBe = false;
            if (this.mBd != null) {
                this.mBd.by(this);
            }
        }
    }
}
