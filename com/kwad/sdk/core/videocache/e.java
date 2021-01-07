package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final h f9785a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.core.videocache.a.b f9786b;
    private b c;

    public e(h hVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(hVar, bVar);
        this.f9786b = bVar;
        this.f9785a = hVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j, bArr.length);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j += a2;
            }
        }
    }

    private boolean a(d dVar) {
        long a2 = this.f9785a.a();
        return (((a2 > 0L ? 1 : (a2 == 0L ? 0 : -1)) > 0) && dVar.c && ((float) dVar.f9783b) > ((float) this.f9786b.a()) + (((float) a2) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String c = this.f9785a.c();
        boolean z = !TextUtils.isEmpty(c);
        long a2 = this.f9786b.d() ? this.f9786b.a() : this.f9785a.a();
        boolean z2 = a2 >= 0;
        return (dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? a("Content-Length: %d\n", Long.valueOf(dVar.c ? a2 - dVar.f9783b : a2)) : "") + (z2 && dVar.c ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f9783b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "") + (z ? a("Content-Type: %s\n", c) : "") + "\n";
    }

    private void b(OutputStream outputStream, long j) {
        h hVar = new h(this.f9785a);
        try {
            hVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = hVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                } else {
                    outputStream.write(bArr, 0, a2);
                    j += a2;
                }
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.kwad.sdk.core.videocache.k
    protected void a(int i) {
        if (this.c != null) {
            this.c.a(this.f9786b.f9773a, this.f9785a.d(), i);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.f9783b;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
