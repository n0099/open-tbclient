package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* loaded from: classes6.dex */
public class e extends k {

    /* renamed from: a  reason: collision with root package name */
    public final h f34464a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f34465b;

    /* renamed from: c  reason: collision with root package name */
    public b f34466c;

    public e(h hVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(hVar, bVar);
        this.f34465b = bVar;
        this.f34464a = hVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j, 8192);
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
        long a2 = this.f34464a.a();
        return (((a2 > 0L ? 1 : (a2 == 0L ? 0 : -1)) > 0) && dVar.f34462c && ((float) dVar.f34461b) > ((float) this.f34465b.a()) + (((float) a2) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String c2 = this.f34464a.c();
        boolean z = !TextUtils.isEmpty(c2);
        long a2 = this.f34465b.d() ? this.f34465b.a() : this.f34464a.a();
        boolean z2 = a2 >= 0;
        long j = dVar.f34462c ? a2 - dVar.f34461b : a2;
        boolean z3 = z2 && dVar.f34462c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f34462c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f34461b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        sb.append(z ? a("Content-Type: %s\n", c2) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) {
        h hVar = new h(this.f34464a);
        try {
            hVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = hVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a2);
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.kwad.sdk.core.videocache.k
    public void a(int i) {
        b bVar = this.f34466c;
        if (bVar != null) {
            bVar.a(this.f34465b.f34445a, this.f34464a.d(), i);
        }
    }

    public void a(b bVar) {
        this.f34466c = bVar;
    }

    public void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.f34461b;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
