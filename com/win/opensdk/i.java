package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public final class i implements Runnable {

    /* renamed from: case  reason: not valid java name */
    private String f56case;

    /* renamed from: java  reason: collision with other field name */
    private String f57java;
    boolean qbE;
    private long qbX;
    private bt qdr;
    private int java = 0;
    private a qds = new a();

    /* renamed from: com.win.opensdk.i$case  reason: invalid class name */
    /* loaded from: classes4.dex */
    public enum Ccase {
        UnknownHost,
        Socket,
        SocketTimeout,
        ConnectTimeout,
        IO,
        HttpResponse,
        JSON,
        Interrupted
    }

    public i(String str, String str2, bt btVar) {
        this.qbE = false;
        this.f57java = str;
        this.f56case = str2;
        this.qdr = btVar;
        this.qbE = true;
    }

    /* loaded from: classes4.dex */
    public class a {
        private Handler qcJ;
        private int java = 0;

        /* renamed from: case  reason: not valid java name */
        private int f58case = 0;

        public a() {
            if (Looper.myLooper() != null) {
                this.qcJ = new Handler() { // from class: com.win.opensdk.i.a.1
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        a.this.X(message);
                    }
                };
            }
        }

        private void eJL() {
            Y(m(7, null));
        }

        protected final void X(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    i.this.qdr.a();
                    return;
                case 2:
                case 4:
                case 6:
                default:
                    return;
                case 3:
                    i.this.qdr.eJM();
                    return;
                case 5:
                    i.this.qdr.Ta(((Integer) ((Object[]) message.obj)[0]).intValue());
                    return;
                case 7:
                    i.this.qdr.eJL();
                    return;
            }
        }

        final void Y(Message message) {
            if (this.qcJ != null) {
                this.qcJ.sendMessage(message);
            } else {
                X(message);
            }
        }

        final Message m(int i, Object obj) {
            if (this.qcJ != null) {
                return this.qcJ.obtainMessage(i, obj);
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            return obtain;
        }

        final void P(InputStream inputStream) {
            boolean z = true;
            this.java = 0;
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(i.this.f56case));
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (i.this.qbE) {
                            fileOutputStream.write(bArr, 0, read);
                            this.java = read + this.java;
                            if (i.this.java + this.java < i.this.qbX + i.this.java) {
                                this.f58case = (int) (Float.parseFloat(new DecimalFormat("0.00").format((i.this.java + this.java) / ((float) (i.this.qbX + i.this.java)))) * 100.0f);
                                if (i % 30 == 0 || this.f58case == 100) {
                                    Y(m(5, new Object[]{Integer.valueOf(this.f58case)}));
                                }
                            }
                            i++;
                        } else {
                            eJL();
                            break;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    i.this.qbE = false;
                    if (!z) {
                        Y(m(3, null));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            i.this.qbE = false;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    eJL();
                    i.this.qbE = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            i.this.qbE = false;
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        i.this.qbE = false;
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        try {
            if (!Thread.currentThread().isInterrupted()) {
                try {
                    URL url = new URL(this.f57java);
                    if (url.toString().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                        httpURLConnection = (HttpsURLConnection) url.openConnection();
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    }
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + this.java + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.connect();
                    this.qbX = httpURLConnection.getContentLength();
                    if (!Thread.currentThread().isInterrupted()) {
                        if (this.qds != null && this.qbX > 10) {
                            this.qds.P(httpURLConnection.getInputStream());
                        } else if (this.qdr != null) {
                            this.qdr.a();
                        }
                    }
                } catch (IOException e) {
                    if (!Thread.currentThread().isInterrupted()) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            if (this.qds != null) {
                a aVar = this.qds;
                aVar.Y(aVar.m(1, new Object[]{Ccase.Socket}));
            }
        }
    }
}
