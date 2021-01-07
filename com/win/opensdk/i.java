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
    private String f57case;

    /* renamed from: java  reason: collision with other field name */
    private String f58java;
    private long qdF;
    boolean qdm;
    private bt qeZ;
    private int java = 0;
    private a qfa = new a();

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
        this.qdm = false;
        this.f58java = str;
        this.f57case = str2;
        this.qeZ = btVar;
        this.qdm = true;
    }

    /* loaded from: classes4.dex */
    public class a {
        private Handler qer;
        private int java = 0;

        /* renamed from: case  reason: not valid java name */
        private int f59case = 0;

        public a() {
            if (Looper.myLooper() != null) {
                this.qer = new Handler() { // from class: com.win.opensdk.i.a.1
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        a.this.X(message);
                    }
                };
            }
        }

        private void eKp() {
            Y(m(7, null));
        }

        protected final void X(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    i.this.qeZ.a();
                    return;
                case 2:
                case 4:
                case 6:
                default:
                    return;
                case 3:
                    i.this.qeZ.eKq();
                    return;
                case 5:
                    i.this.qeZ.Tq(((Integer) ((Object[]) message.obj)[0]).intValue());
                    return;
                case 7:
                    i.this.qeZ.eKp();
                    return;
            }
        }

        final void Y(Message message) {
            if (this.qer != null) {
                this.qer.sendMessage(message);
            } else {
                X(message);
            }
        }

        final Message m(int i, Object obj) {
            if (this.qer != null) {
                return this.qer.obtainMessage(i, obj);
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
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(i.this.f57case));
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (i.this.qdm) {
                            fileOutputStream.write(bArr, 0, read);
                            this.java = read + this.java;
                            if (i.this.java + this.java < i.this.qdF + i.this.java) {
                                this.f59case = (int) (Float.parseFloat(new DecimalFormat("0.00").format((i.this.java + this.java) / ((float) (i.this.qdF + i.this.java)))) * 100.0f);
                                if (i % 30 == 0 || this.f59case == 100) {
                                    Y(m(5, new Object[]{Integer.valueOf(this.f59case)}));
                                }
                            }
                            i++;
                        } else {
                            eKp();
                            break;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    i.this.qdm = false;
                    if (!z) {
                        Y(m(3, null));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            i.this.qdm = false;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    eKp();
                    i.this.qdm = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            i.this.qdm = false;
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        i.this.qdm = false;
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
                    URL url = new URL(this.f58java);
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
                    this.qdF = httpURLConnection.getContentLength();
                    if (!Thread.currentThread().isInterrupted()) {
                        if (this.qfa != null && this.qdF > 10) {
                            this.qfa.P(httpURLConnection.getInputStream());
                        } else if (this.qeZ != null) {
                            this.qeZ.a();
                        }
                    }
                } catch (IOException e) {
                    if (!Thread.currentThread().isInterrupted()) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            if (this.qfa != null) {
                a aVar = this.qfa;
                aVar.Y(aVar.m(1, new Object[]{Ccase.Socket}));
            }
        }
    }
}
