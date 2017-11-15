package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.ak;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c {
    private ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);
    private Adler32 c = new Adler32();
    private e d = new e();
    private InputStream e;
    private f f;
    private volatile boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputStream inputStream, f fVar) {
        this.e = new BufferedInputStream(inputStream);
        this.f = fVar;
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.e.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void d() {
        boolean z = false;
        this.g = false;
        b c = c();
        if ("CONN".equals(c.a())) {
            b.f b = b.f.b(c.k());
            if (b.e()) {
                this.f.a(b.d());
                z = true;
            }
            if (b.h()) {
                b.C0164b i = b.i();
                b bVar = new b();
                bVar.a("SYNC", "CONF");
                bVar.a(i.c(), (String) null);
                this.f.a(bVar);
            }
            com.xiaomi.channel.commonutils.logger.b.a("[Slim] CONN: host = " + b.f());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        while (!this.g) {
            b c2 = c();
            this.f.n();
            switch (c2.m()) {
                case 1:
                    this.f.a(c2);
                    break;
                case 2:
                    if (!"SECMSG".equals(c2.a()) || !TextUtils.isEmpty(c2.b())) {
                        this.f.a(c2);
                        break;
                    } else {
                        try {
                            this.f.b(this.d.a(c2.d(ak.a().b(Integer.valueOf(c2.c()).toString(), c2.j()).i), this.f));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.a("[Slim] Parse packet from Blob " + c2.toString() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f.b(this.d.a(c2.k(), this.f));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.a("[Slim] Parse packet from Blob " + c2.toString() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.a("[Slim] unknow blob type " + ((int) c2.m()));
                    break;
            }
        }
    }

    private ByteBuffer e() {
        if (this.a.capacity() > 4096) {
            this.a = ByteBuffer.allocate(2048);
        }
        this.a.clear();
        a(this.a, b.n());
        int c = b.c(this.a.asReadOnlyBuffer());
        if (c > 32768) {
            throw new IOException("Blob size too large");
        }
        if (c + 4 > this.a.remaining()) {
            ByteBuffer allocate = ByteBuffer.allocate(b.n() + c);
            allocate.put(this.a.array(), 0, this.a.arrayOffset() + this.a.position());
            this.a = allocate;
        }
        a(this.a, c);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        int i = this.b.getInt();
        this.c.reset();
        this.c.update(this.a.array(), 0, this.a.position());
        if (i != ((int) this.c.getValue())) {
            com.xiaomi.channel.commonutils.logger.b.a("CRC = " + ((int) this.c.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            d();
        } catch (IOException e) {
            if (!this.g) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.g = true;
    }

    b c() {
        IOException iOException;
        int i;
        try {
            ByteBuffer e = e();
            int position = e.position();
            try {
                e.flip();
                b b = b.b(e);
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + b.a() + ";chid=" + b.c() + ";len=" + position + "}");
                return b;
            } catch (IOException e2) {
                i = position;
                iOException = e2;
                if (i == 0) {
                    i = this.a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.a.array();
                if (i > b.n()) {
                    i = b.n();
                }
                com.xiaomi.channel.commonutils.logger.b.a(append.append(com.xiaomi.channel.commonutils.misc.d.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e3) {
            iOException = e3;
            i = 0;
        }
    }
}
