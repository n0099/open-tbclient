package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class e extends k {
    public final p aAO;
    public final com.kwad.sdk.core.videocache.a.b aAP;
    public b aAQ;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aAP = bVar;
        this.aAO = pVar;
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[1024];
        while (true) {
            int a = a(bArr, j, 1024);
            if (a == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, a);
                j += a;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean a(d dVar) {
        boolean z;
        long length = this.aAO.length();
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        long Ff = this.aAP.Ff();
        if (!z || !dVar.aAN || ((float) dVar.aAM) <= ((float) Ff) + (((float) length) * 0.2f)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.videocache.k
    public final void cU(int i) {
        b bVar = this.aAQ;
        if (bVar != null) {
            bVar.a(this.aAP.file, i);
        }
    }

    private String b(d dVar) {
        long length;
        boolean z;
        long j;
        boolean z2;
        String str;
        String str2;
        String str3;
        String Fp = this.aAO.Fp();
        boolean z3 = !TextUtils.isEmpty(Fp);
        if (this.aAP.isCompleted()) {
            length = this.aAP.Ff();
        } else {
            length = this.aAO.length();
        }
        if (length >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (dVar.aAN) {
            j = length - dVar.aAM;
        } else {
            j = length;
        }
        if (z && dVar.aAN) {
            z2 = true;
        } else {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder();
        if (dVar.aAN) {
            str = "HTTP/1.1 206 PARTIAL CONTENT\n";
        } else {
            str = "HTTP/1.1 200 OK\n";
        }
        sb.append(str);
        sb.append("Accept-Ranges: bytes\n");
        String str4 = "";
        if (!z) {
            str2 = "";
        } else {
            str2 = format("Content-Length: %d\n", Long.valueOf(j));
        }
        sb.append(str2);
        if (!z2) {
            str3 = "";
        } else {
            str3 = format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aAM), Long.valueOf(length - 1), Long.valueOf(length));
        }
        sb.append(str3);
        if (z3) {
            str4 = format("Content-Type: %s\n", Fp);
        }
        sb.append(str4);
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: all -> 0x0037, LOOP:0: B:11:0x0024->B:13:0x002b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:10:0x001d, B:11:0x0024, B:13:0x002b, B:14:0x0030), top: B:20:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(OutputStream outputStream, long j) {
        p jVar;
        byte[] bArr;
        int read;
        p pVar = this.aAO;
        try {
            if (pVar instanceof h) {
                jVar = new h((h) pVar);
            } else {
                if (pVar instanceof j) {
                    jVar = new j((j) pVar);
                }
                pVar.al((int) j);
                bArr = new byte[1024];
                while (true) {
                    read = pVar.read(bArr);
                    if (read == -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            }
            pVar.al((int) j);
            bArr = new byte[1024];
            while (true) {
                read = pVar.read(bArr);
                if (read == -1) {
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            pVar.close();
        }
        pVar = jVar;
    }

    public final void a(b bVar) {
        this.aAQ = bVar;
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.aAM;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
