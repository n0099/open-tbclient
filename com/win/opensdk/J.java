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
    public Handler f40072a;

    /* renamed from: b  reason: collision with root package name */
    public int f40073b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f40074c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ L f40075d;

    public J(L l) {
        this.f40075d = l;
        if (Looper.myLooper() != null) {
            this.f40072a = new I(this, l);
        }
    }

    public Message a(int i, Object obj) {
        Handler handler = this.f40072a;
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
            this.f40075d.f40095d.a();
        } else if (i == 3) {
            this.f40075d.f40095d.b();
        } else if (i == 5) {
            this.f40075d.f40095d.a(((Integer) ((Object[]) message.obj)[0]).intValue());
        } else if (i != 7) {
        } else {
            this.f40075d.f40095d.c();
        }
    }

    public void b(Message message) {
        Handler handler = this.f40072a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            a(message);
        }
    }

    public void a(InputStream inputStream) {
        boolean z;
        this.f40073b = 0;
        try {
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f40075d.f40094c));
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        z = true;
                        if (read == -1) {
                            z = false;
                            break;
                        } else if (this.f40075d.f40097f) {
                            fileOutputStream.write(bArr, 0, read);
                            int i2 = this.f40073b + read;
                            this.f40073b = i2;
                            if (this.f40075d.f40092a + i2 < this.f40075d.f40098g + this.f40075d.f40092a) {
                                int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f40075d.f40092a + i2) / ((float) (this.f40075d.f40098g + this.f40075d.f40092a)))) * 100.0f);
                                this.f40074c = parseFloat;
                                if (i % 30 == 0 || parseFloat == 100) {
                                    b(a(5, new Object[]{Integer.valueOf(this.f40074c)}));
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
                    this.f40075d.f40097f = false;
                    if (!z) {
                        b(a(3, null));
                    }
                    inputStream.close();
                } catch (Exception e2) {
                    b(a(7, null));
                    this.f40075d.f40097f = false;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                this.f40075d.f40097f = false;
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    this.f40075d.f40097f = false;
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
