package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class e extends j {
    public final h aeq;
    public final com.kwad.sdk.core.videocache.kwai.b aer;
    public b aes;

    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
        super(hVar, bVar);
        this.aer = bVar;
        this.aeq = hVar;
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
        long length = this.aeq.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aep && ((float) dVar.aeo) > ((float) this.aer.vJ()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String vS = this.aeq.vS();
        boolean z = !TextUtils.isEmpty(vS);
        long vJ = this.aer.isCompleted() ? this.aer.vJ() : this.aeq.length();
        boolean z2 = vJ >= 0;
        long j = dVar.aep ? vJ - dVar.aeo : vJ;
        boolean z3 = z2 && dVar.aep;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.aep ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aeo), Long.valueOf(vJ - 1), Long.valueOf(vJ)) : "");
        sb.append(z ? format("Content-Type: %s\n", vS) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) {
        h hVar = new h(this.aeq);
        try {
            hVar.I((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = hVar.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            hVar.close();
        }
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.aes = bVar;
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.aeo;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    @Override // com.kwad.sdk.core.videocache.j
    public final void aZ(int i) {
        b bVar = this.aes;
        if (bVar != null) {
            bVar.a(this.aer.file, i);
        }
    }
}
