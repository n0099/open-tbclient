package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes8.dex */
public class e extends k {
    public final h a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.b f54832b;

    /* renamed from: c  reason: collision with root package name */
    public b f54833c;

    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
        super(hVar, bVar);
        this.f54832b = bVar;
        this.a = hVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j2) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = a(bArr, j2, 8192);
            if (a == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a);
                j2 += a;
            }
        }
    }

    private boolean a(d dVar) {
        long a = this.a.a();
        return (((a > 0L ? 1 : (a == 0L ? 0 : -1)) > 0) && dVar.f54831c && ((float) dVar.f54830b) > ((float) this.f54832b.a()) + (((float) a) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String c2 = this.a.c();
        boolean z = !TextUtils.isEmpty(c2);
        long a = this.f54832b.d() ? this.f54832b.a() : this.a.a();
        boolean z2 = a >= 0;
        long j2 = dVar.f54831c ? a - dVar.f54830b : a;
        boolean z3 = z2 && dVar.f54831c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f54831c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f54830b), Long.valueOf(a - 1), Long.valueOf(a)) : "");
        sb.append(z ? a("Content-Type: %s\n", c2) : "");
        sb.append(StringUtils.LF);
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) {
        h hVar = new h(this.a);
        try {
            hVar.a((int) j2);
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

    @Override // com.kwad.sdk.core.videocache.k
    public void a(int i2) {
        b bVar = this.f54833c;
        if (bVar != null) {
            bVar.a(this.f54832b.a, this.a.d(), i2);
        }
    }

    public void a(b bVar) {
        this.f54833c = bVar;
    }

    public void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.f54830b;
        if (a(dVar)) {
            a(bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }
}
