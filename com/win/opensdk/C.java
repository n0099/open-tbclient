package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class C {

    /* renamed from: a  reason: collision with root package name */
    public Handler f40569a;

    /* renamed from: b  reason: collision with root package name */
    public int f40570b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f40571c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ E f40572d;

    public C(E e2) {
        this.f40572d = e2;
        if (Looper.myLooper() != null) {
            this.f40569a = new B(this, e2);
        }
    }

    public Message a(int i2, Object obj) {
        Handler handler = this.f40569a;
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
            this.f40572d.f40593d.a();
        } else if (i2 == 3) {
            this.f40572d.f40593d.b();
        } else if (i2 == 5) {
            this.f40572d.f40593d.a(((Integer) ((Object[]) message.obj)[0]).intValue());
        } else if (i2 != 7) {
        } else {
            this.f40572d.f40593d.c();
        }
    }

    public void b(Message message) {
        Handler handler = this.f40569a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            a(message);
        }
    }

    public void a(InputStream inputStream) {
        boolean z;
        this.f40570b = 0;
        try {
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f40572d.f40592c));
                    int i2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        z = true;
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (this.f40572d.f40595f) {
                            fileOutputStream.write(bArr, 0, read);
                            int i3 = this.f40570b + read;
                            this.f40570b = i3;
                            if (this.f40572d.f40590a + i3 < this.f40572d.f40596g + this.f40572d.f40590a) {
                                int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f40572d.f40590a + i3) / ((float) (this.f40572d.f40596g + this.f40572d.f40590a)))) * 100.0f);
                                this.f40571c = parseFloat;
                                if (i2 % 30 == 0 || parseFloat == 100) {
                                    b(a(5, new Object[]{Integer.valueOf(this.f40571c)}));
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
                    this.f40572d.f40595f = false;
                    if (!z) {
                        b(a(3, null));
                    }
                    inputStream.close();
                } catch (Exception e2) {
                    b(a(7, null));
                    this.f40572d.f40595f = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                this.f40572d.f40595f = false;
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    this.f40572d.f40595f = false;
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
