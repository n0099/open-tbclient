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
public class J {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39687a;

    /* renamed from: b  reason: collision with root package name */
    public int f39688b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f39689c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ L f39690d;

    public J(L l) {
        this.f39690d = l;
        if (Looper.myLooper() != null) {
            this.f39687a = new I(this, l);
        }
    }

    public Message a(int i, Object obj) {
        Handler handler = this.f39687a;
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
            this.f39690d.f39710d.a();
        } else if (i == 3) {
            this.f39690d.f39710d.b();
        } else if (i == 5) {
            this.f39690d.f39710d.a(((Integer) ((Object[]) message.obj)[0]).intValue());
        } else if (i != 7) {
        } else {
            this.f39690d.f39710d.c();
        }
    }

    public void b(Message message) {
        Handler handler = this.f39687a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            a(message);
        }
    }

    public void a(InputStream inputStream) {
        boolean z;
        this.f39688b = 0;
        try {
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f39690d.f39709c));
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        z = true;
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (this.f39690d.f39712f) {
                            fileOutputStream.write(bArr, 0, read);
                            int i2 = this.f39688b + read;
                            this.f39688b = i2;
                            if (this.f39690d.f39707a + i2 < this.f39690d.f39713g + this.f39690d.f39707a) {
                                int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f39690d.f39707a + i2) / ((float) (this.f39690d.f39713g + this.f39690d.f39707a)))) * 100.0f);
                                this.f39689c = parseFloat;
                                if (i % 30 == 0 || parseFloat == 100) {
                                    b(a(5, new Object[]{Integer.valueOf(this.f39689c)}));
                                }
                            }
                            i++;
                        } else {
                            b(a(7, null));
                            break;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f39690d.f39712f = false;
                    if (!z) {
                        b(a(3, null));
                    }
                    inputStream.close();
                } catch (Exception e2) {
                    b(a(7, null));
                    this.f39690d.f39712f = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                this.f39690d.f39712f = false;
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    this.f39690d.f39712f = false;
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
