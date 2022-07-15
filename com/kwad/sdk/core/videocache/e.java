package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class e extends j {
    public final h a;
    public final com.kwad.sdk.core.videocache.kwai.b b;
    public b c;

    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
        super(hVar, bVar);
        this.b = bVar;
        this.a = hVar;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = a(bArr, j, 8192);
            if (a == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a);
                j += a;
            }
        }
    }

    private boolean a(d dVar) {
        long a = this.a.a();
        return (((a > 0L ? 1 : (a == 0L ? 0 : -1)) > 0) && dVar.c && ((float) dVar.b) > ((float) this.b.a()) + (((float) a) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String c = this.a.c();
        boolean z = !TextUtils.isEmpty(c);
        long a = this.b.d() ? this.b.a() : this.a.a();
        boolean z2 = a >= 0;
        long j = dVar.c ? a - dVar.b : a;
        boolean z3 = z2 && dVar.c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.b), Long.valueOf(a - 1), Long.valueOf(a)) : "");
        sb.append(z ? a("Content-Type: %s\n", c) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) {
        h hVar = new h(this.a);
        try {
            hVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a = hVar.a(bArr);
                if (a == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a);
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.kwad.sdk.core.videocache.j
    public final void a(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.a, i);
        }
    }

    public final void a(b bVar) {
        this.c = bVar;
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.b;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
