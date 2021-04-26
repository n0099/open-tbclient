package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class C {

    /* renamed from: a  reason: collision with root package name */
    public Handler f37613a;

    /* renamed from: b  reason: collision with root package name */
    public int f37614b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f37615c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ E f37616d;

    public C(E e2) {
        this.f37616d = e2;
        if (Looper.myLooper() != null) {
            this.f37613a = new B(this, e2);
        }
    }

    public Message a(int i2, Object obj) {
        Handler handler = this.f37613a;
        if (handler != null) {
            return handler.obtainMessage(i2, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.obj = obj;
        return obtain;
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            D d2 = (D) ((Object[]) message.obj)[0];
            this.f37616d.f37637d.a();
        } else if (i2 == 3) {
            this.f37616d.f37637d.b();
        } else if (i2 == 5) {
            this.f37616d.f37637d.a(((Integer) ((Object[]) message.obj)[0]).intValue());
        } else if (i2 != 7) {
        } else {
            this.f37616d.f37637d.c();
        }
    }

    public void b(Message message) {
        Handler handler = this.f37613a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            a(message);
        }
    }

    public void a(InputStream inputStream) {
        boolean z;
        this.f37614b = 0;
        try {
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f37616d.f37636c));
                    int i2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        z = true;
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (this.f37616d.f37639f) {
                            fileOutputStream.write(bArr, 0, read);
                            int i3 = this.f37614b + read;
                            this.f37614b = i3;
                            if (this.f37616d.f37634a + i3 < this.f37616d.f37640g + this.f37616d.f37634a) {
                                int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f37616d.f37634a + i3) / ((float) (this.f37616d.f37640g + this.f37616d.f37634a)))) * 100.0f);
                                this.f37615c = parseFloat;
                                if (i2 % 30 == 0 || parseFloat == 100) {
                                    b(a(5, new Object[]{Integer.valueOf(this.f37615c)}));
                                }
                            }
                            i2++;
                        } else {
                            b(a(7, null));
                            break;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f37616d.f37639f = false;
                    if (!z) {
                        b(a(3, null));
                    }
                    inputStream.close();
                } catch (Exception e2) {
                    b(a(7, null));
                    this.f37616d.f37639f = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                this.f37616d.f37639f = false;
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    this.f37616d.f37639f = false;
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
