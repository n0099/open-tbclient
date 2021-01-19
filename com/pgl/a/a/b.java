package com.pgl.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidubce.AbstractBceClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.cookie.SM;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: b  reason: collision with root package name */
    private Context f11383b;
    private String c;
    private int d;
    private int e;
    private byte[] f;
    private HandlerThread m;
    private Handler n;

    /* renamed from: a  reason: collision with root package name */
    public String f11382a = "";
    private int g = -1;
    private byte[] h = null;
    private int i = 10000;
    private int j = 1;
    private int k = 0;
    private boolean l = false;
    private boolean o = false;
    private HttpURLConnection pPX = null;

    public b(Context context, String str) {
        str = (str == null || str.length() <= 0) ? "" : "";
        this.f11383b = context;
        this.c = str;
    }

    private void a(int i) {
        String str;
        switch (i) {
            case 1:
                str = "POST";
                break;
            case 2:
                str = "GET";
                break;
            case 3:
                str = HttpPut.METHOD_NAME;
                break;
            case 4:
                str = HttpDelete.METHOD_NAME;
                break;
            case 5:
                str = HttpHead.METHOD_NAME;
                break;
            case 6:
                str = HttpTrace.METHOD_NAME;
                break;
            default:
                str = "GET";
                break;
        }
        this.pPX.setRequestMethod(str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        /*
            r4 = this;
            r2 = 1
            r1 = 0
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = r4.f11382a     // Catch: java.lang.Throwable -> L9a
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9a
            boolean r3 = r4.o     // Catch: java.lang.Throwable -> L9a
            if (r3 == 0) goto L91
            java.lang.String r3 = "TLS"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch: java.lang.Throwable -> L9a
            javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch: java.lang.Throwable -> L9a
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r3)     // Catch: java.lang.Throwable -> L9a
            java.net.Proxy r3 = java.net.Proxy.NO_PROXY     // Catch: java.lang.Throwable -> L9a
            java.net.URLConnection r0 = r0.openConnection(r3)     // Catch: java.lang.Throwable -> L9a
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L9a
            r4.pPX = r0     // Catch: java.lang.Throwable -> L9a
        L25:
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> L9a
            int r3 = r4.i     // Catch: java.lang.Throwable -> L9a
            r0.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L9a
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> L9a
            int r3 = r4.i     // Catch: java.lang.Throwable -> L9a
            r0.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L9a
            int r0 = r4.d     // Catch: java.lang.Throwable -> L9a
            r4.a(r0)     // Catch: java.lang.Throwable -> L9a
            int r0 = r4.e     // Catch: java.lang.Throwable -> L9a
            r4.b(r0)     // Catch: java.lang.Throwable -> L9a
            byte[] r0 = r4.f     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L5d
            byte[] r0 = r4.f     // Catch: java.lang.Throwable -> L9a
            int r0 = r0.length     // Catch: java.lang.Throwable -> L9a
            if (r0 <= 0) goto L5d
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> L9a
            r3 = 1
            r0.setDoOutput(r3)     // Catch: java.lang.Throwable -> L9a
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> L9a
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch: java.lang.Throwable -> L9a
            byte[] r3 = r4.f     // Catch: java.lang.Throwable -> L9a
            r0.write(r3)     // Catch: java.lang.Throwable -> L9a
            r0.flush()     // Catch: java.lang.Throwable -> L9a
            r0.close()     // Catch: java.lang.Throwable -> L9a
        L5d:
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> L9a
            r0.connect()     // Catch: java.lang.Throwable -> L9a
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> Lab
            int r0 = r0.getResponseCode()     // Catch: java.lang.Throwable -> Lab
            r4.g = r0     // Catch: java.lang.Throwable -> Lab
            java.net.HttpURLConnection r0 = r4.pPX     // Catch: java.lang.Throwable -> Lab
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> Lab
            byte[] r3 = r4.a(r0)     // Catch: java.lang.Throwable -> Lcc
            r4.h = r3     // Catch: java.lang.Throwable -> Lcc
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Throwable -> L9a
        L7b:
            java.net.HttpURLConnection r0 = r4.pPX
            if (r0 == 0) goto Lce
            java.net.HttpURLConnection r0 = r4.pPX
            r0.disconnect()
            r4.pPX = r1
            r0 = r2
        L87:
            if (r0 == 0) goto L90
            int r1 = r4.g
            byte[] r2 = r4.h
            r4.f(r1, r2)
        L90:
            return r0
        L91:
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L9a
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L9a
            r4.pPX = r0     // Catch: java.lang.Throwable -> L9a
            goto L25
        L9a:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb3
            r0 = 0
            java.net.HttpURLConnection r2 = r4.pPX
            if (r2 == 0) goto L87
            java.net.HttpURLConnection r2 = r4.pPX
            r2.disconnect()
            r4.pPX = r1
            goto L87
        Lab:
            r0 = move-exception
            r0 = r1
        Lad:
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Throwable -> L9a
            goto L7b
        Lb3:
            r0 = move-exception
            java.net.HttpURLConnection r2 = r4.pPX
            if (r2 == 0) goto Lbf
            java.net.HttpURLConnection r2 = r4.pPX
            r2.disconnect()
            r4.pPX = r1
        Lbf:
            throw r0
        Lc0:
            r0 = move-exception
            r2 = r0
            r3 = r1
        Lc3:
            if (r3 == 0) goto Lc8
            r3.close()     // Catch: java.lang.Throwable -> L9a
        Lc8:
            throw r2     // Catch: java.lang.Throwable -> L9a
        Lc9:
            r2 = move-exception
            r3 = r0
            goto Lc3
        Lcc:
            r3 = move-exception
            goto Lad
        Lce:
            r0 = r2
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.a.a.b.a():boolean");
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private void b(int i) {
        String str;
        switch (i) {
            case 1:
                str = AbstractBceClient.DEFAULT_CONTENT_TYPE;
                break;
            case 2:
                str = "application/octet-stream";
                break;
            default:
                str = "";
                break;
        }
        if (str.length() > 0) {
            this.pPX.addRequestProperty("Content-Type", str);
        }
        this.pPX.addRequestProperty(SM.COOKIE, "sessionid=" + this.c);
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.pPX.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9");
            } else {
                this.pPX.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
            }
        } catch (Throwable th) {
        }
    }

    private void c(int i, int i2, byte[] bArr) {
        this.d = i;
        this.e = i2;
        this.f = bArr;
    }

    static /* synthetic */ int g(b bVar) {
        int i = bVar.k;
        bVar.k = i + 1;
        return i;
    }

    public synchronized void d(int i, int i2, byte[] bArr) {
        if (!this.l) {
            this.j = 2;
            c(i, i2, bArr);
            this.l = true;
            this.k = 0;
            this.m = new HandlerThread("request");
            this.m.start();
            this.n = new Handler(this.m.getLooper(), new Handler.Callback() { // from class: com.pgl.a.a.b.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (b.this.k >= b.this.j) {
                        b.this.l = false;
                        b.this.k = 0;
                        b.this.m.quit();
                        return false;
                    } else if (!b.this.a()) {
                        b.this.n.sendEmptyMessageDelayed(1, b.this.i * 1);
                        b.g(b.this);
                        return false;
                    } else {
                        b.this.l = false;
                        b.this.k = 0;
                        b.this.m.quit();
                        return true;
                    }
                }
            });
            this.n.sendEmptyMessage(1);
        }
    }

    public abstract boolean f(int i, byte[] bArr);
}
