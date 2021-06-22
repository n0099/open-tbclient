package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class l extends AsyncTask<String, Void, List<Bitmap>> {

    /* renamed from: a  reason: collision with root package name */
    public Context f40501a;

    /* renamed from: b  reason: collision with root package name */
    public InsideNotificationItem f40502b;

    /* renamed from: c  reason: collision with root package name */
    public long f40503c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40504d;

    /* renamed from: e  reason: collision with root package name */
    public int f40505e = 0;

    public l(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z) {
        this.f40501a = context;
        this.f40502b = insideNotificationItem;
        this.f40503c = j;
        this.f40504d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        if (r5 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
        if (r5 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        r6 = null;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Bitmap> doInBackground(String... strArr) {
        InputStream inputStream;
        Bitmap bitmap;
        this.f40505e = ClientConfigManagerImpl.getInstance(this.f40501a).getNotifyStyle();
        InputStream inputStream2 = null;
        if (!this.f40504d) {
            p.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            p.d("ImageDownTask", "imgUrl=" + str + " i=" + i2);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    p.c("ImageDownTask", "code=" + responseCode);
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmap = BitmapFactory.decodeStream(inputStream);
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (MalformedURLException unused2) {
                            p.a("ImageDownTask", "MalformedURLException");
                        } catch (IOException unused3) {
                            p.a("ImageDownTask", "IOException");
                        }
                    } else {
                        inputStream = null;
                        bitmap = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                } catch (MalformedURLException unused5) {
                    inputStream = null;
                } catch (IOException unused6) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmap);
            } else if (i2 == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        p.c("ImageDownTask", "onPostExecute");
        if (this.f40502b != null) {
            w.b().a("com.vivo.push.notify_key", this.f40503c);
            NotifyAdapterUtil.pushNotification(this.f40501a, list2, this.f40502b, this.f40503c, this.f40505e);
        }
    }
}
