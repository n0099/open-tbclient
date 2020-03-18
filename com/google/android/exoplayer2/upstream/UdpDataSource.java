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
    private final q<? super UdpDataSource> mHA;
    private boolean mHB;
    private final int mIN;
    private final byte[] mIO;
    private final DatagramPacket mIP;
    private DatagramSocket mIQ;
    private MulticastSocket mIR;
    private InetAddress mIS;
    private InetSocketAddress mIT;
    private int mIU;
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
            this.mIS = InetAddress.getByName(host);
            this.mIT = new InetSocketAddress(this.mIS, port);
            if (this.mIS.isMulticastAddress()) {
                this.mIR = new MulticastSocket(this.mIT);
                this.mIR.joinGroup(this.mIS);
                this.mIQ = this.mIR;
            } else {
                this.mIQ = new DatagramSocket(this.mIT);
            }
            try {
                this.mIQ.setSoTimeout(this.mIN);
                this.mHB = true;
                if (this.mHA != null) {
                    this.mHA.a(this, gVar);
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
        if (this.mIU == 0) {
            try {
                this.mIQ.receive(this.mIP);
                this.mIU = this.mIP.getLength();
                if (this.mHA != null) {
                    this.mHA.h(this, this.mIU);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.mIP.getLength() - this.mIU;
        int min = Math.min(this.mIU, i2);
        System.arraycopy(this.mIO, length, bArr, i, min);
        this.mIU -= min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() {
        this.uri = null;
        if (this.mIR != null) {
            try {
                this.mIR.leaveGroup(this.mIS);
            } catch (IOException e) {
            }
            this.mIR = null;
        }
        if (this.mIQ != null) {
            this.mIQ.close();
            this.mIQ = null;
        }
        this.mIS = null;
        this.mIT = null;
        this.mIU = 0;
        if (this.mHB) {
            this.mHB = false;
            if (this.mHA != null) {
                this.mHA.bB(this);
            }
        }
    }
}
