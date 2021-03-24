package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f39297c;

    /* renamed from: a  reason: collision with root package name */
    public String f39298a;

    /* renamed from: b  reason: collision with root package name */
    public c f39299b;

    /* renamed from: d  reason: collision with root package name */
    public long f39300d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f39301e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f39302f = new Runnable() { // from class: com.tencent.open.utils.b.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + j.f(b.this.f39298a) + ".jpg";
            String str2 = b.f39297c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.f39301e.obtainMessage();
            if (!file.exists()) {
                Bitmap a2 = b.a(b.this.f39298a);
                if (a2 != null) {
                    z = b.this.a(a2, str);
                } else {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.f39300d));
            } else {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.f39300d));
            }
            b.this.f39301e.sendMessage(obtainMessage);
        }
    };

    public b(Activity activity) {
        this.f39301e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    b.this.f39299b.a(message.arg1, (String) message.obj);
                } else {
                    b.this.f39299b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, c cVar) {
        com.tencent.open.a.f.a("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!j.b()) {
                cVar.a(2, (String) null);
                return;
            }
            f39297c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.f39300d = System.currentTimeMillis();
            this.f39298a = str;
            this.f39299b = cVar;
            new Thread(this.f39302f).start();
            return;
        }
        cVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = f39297c;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                com.tencent.open.a.f.a("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            com.tencent.open.a.f.b("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Bitmap a(String str) {
        com.tencent.open.a.f.a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            com.tencent.open.a.f.a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
