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
/* loaded from: classes3.dex */
public final class i implements Runnable {

    /* renamed from: case  reason: not valid java name */
    private String f56case;

    /* renamed from: java  reason: collision with other field name */
    private String f57java;
    private long qjJ;
    boolean qjq;
    private bt qld;
    private int java = 0;
    private a qle = new a();

    /* renamed from: com.win.opensdk.i$case  reason: invalid class name */
    /* loaded from: classes3.dex */
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
        this.qjq = false;
        this.f57java = str;
        this.f56case = str2;
        this.qld = btVar;
        this.qjq = true;
    }

    /* loaded from: classes3.dex */
    public class a {
        private Handler qkv;
        private int java = 0;

        /* renamed from: case  reason: not valid java name */
        private int f58case = 0;

        public a() {
            if (Looper.myLooper() != null) {
                this.qkv = new Handler() { // from class: com.win.opensdk.i.a.1
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        a.this.X(message);
                    }
                };
            }
        }

        private void eIX() {
            Y(m(7, null));
        }

        protected final void X(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    i.this.qld.a();
                    return;
                case 2:
                case 4:
                case 6:
                default:
                    return;
                case 3:
                    i.this.qld.eIY();
                    return;
                case 5:
                    i.this.qld.Sf(((Integer) ((Object[]) message.obj)[0]).intValue());
                    return;
                case 7:
                    i.this.qld.eIX();
                    return;
            }
        }

        final void Y(Message message) {
            if (this.qkv != null) {
                this.qkv.sendMessage(message);
            } else {
                X(message);
            }
        }

        final Message m(int i, Object obj) {
            if (this.qkv != null) {
                return this.qkv.obtainMessage(i, obj);
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            return obtain;
        }

        final void M(InputStream inputStream) {
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
                        } else if (i.this.qjq) {
                            fileOutputStream.write(bArr, 0, read);
                            this.java = read + this.java;
                            if (i.this.java + this.java < i.this.qjJ + i.this.java) {
                                this.f58case = (int) (Float.parseFloat(new DecimalFormat("0.00").format((i.this.java + this.java) / ((float) (i.this.qjJ + i.this.java)))) * 100.0f);
                                if (i % 30 == 0 || this.f58case == 100) {
                                    Y(m(5, new Object[]{Integer.valueOf(this.f58case)}));
                                }
                            }
                            i++;
                        } else {
                            eIX();
                            break;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    i.this.qjq = false;
                    if (!z) {
                        Y(m(3, null));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            i.this.qjq = false;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    eIX();
                    i.this.qjq = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            i.this.qjq = false;
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        i.this.qjq = false;
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
                    this.qjJ = httpURLConnection.getContentLength();
                    if (!Thread.currentThread().isInterrupted()) {
                        if (this.qle != null && this.qjJ > 10) {
                            this.qle.M(httpURLConnection.getInputStream());
                        } else if (this.qld != null) {
                            this.qld.a();
                        }
                    }
                } catch (IOException e) {
                    if (!Thread.currentThread().isInterrupted()) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            if (this.qle != null) {
                a aVar = this.qle;
                aVar.Y(aVar.m(1, new Object[]{Ccase.Socket}));
            }
        }
    }
}
