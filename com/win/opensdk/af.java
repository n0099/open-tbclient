package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes14.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public Handler f8107a;
    public int b = 0;
    public int c = 0;
    public final /* synthetic */ aj qkJ;

    public af(aj ajVar) {
        this.qkJ = ajVar;
        if (Looper.myLooper() != null) {
            this.f8107a = new ac(this, ajVar);
        }
    }

    public void b(Message message) {
        Handler handler = this.f8107a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            a(message);
        }
    }

    public Message m(int i, Object obj) {
        Handler handler = this.f8107a;
        if (handler != null) {
            return handler.obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public void a(Message message) {
        int i = message.what;
        if (i == 1) {
            K k = (K) ((Object[]) message.obj)[0];
            this.qkJ.qkK.a();
        } else if (i == 3) {
            this.qkJ.qkK.b();
        } else if (i == 5) {
            this.qkJ.qkK.a(((Integer) ((Object[]) message.obj)[0]).intValue());
        } else if (i == 7) {
            this.qkJ.qkK.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [43=4] */
    public void a(InputStream inputStream) {
        boolean z = true;
        this.b = 0;
        try {
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.qkJ.c));
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (!this.qkJ.f) {
                            b(m(7, null));
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                            this.b = read + this.b;
                            if (this.qkJ.f8110a + this.b < this.qkJ.g + this.qkJ.f8110a) {
                                this.c = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.qkJ.f8110a + this.b) / ((float) (this.qkJ.g + this.qkJ.f8110a)))) * 100.0f);
                                if (i % 30 == 0 || this.c == 100) {
                                    b(m(5, new Object[]{Integer.valueOf(this.c)}));
                                }
                            }
                            i++;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.qkJ.f = false;
                    if (!z) {
                        b(m(3, null));
                    }
                    inputStream.close();
                } catch (IOException e) {
                    this.qkJ.f = false;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                b(m(7, null));
                this.qkJ.f = false;
                e2.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    this.qkJ.f = false;
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
