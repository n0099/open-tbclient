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
/* loaded from: classes6.dex */
public final class l extends AsyncTask<String, Void, List<Bitmap>> {
    private Context a;
    private InsideNotificationItem b;
    private long c;
    private boolean d;
    private int e = 0;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        p.c("ImageDownTask", "onPostExecute");
        if (this.b == null) {
            return;
        }
        w.b().a("com.vivo.push.notify_key", this.c);
        NotifyAdapterUtil.pushNotification(this.a, list2, this.b, this.c, this.e);
    }

    public l(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z) {
        this.a = context;
        this.b = insideNotificationItem;
        this.c = j;
        this.d = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [72=5, 74=4, 77=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<Bitmap> doInBackground(String... strArr) {
        InputStream inputStream;
        Bitmap bitmap;
        InputStream inputStream2;
        int i = 0;
        InputStream inputStream3 = null;
        this.e = ClientConfigManagerImpl.getInstance(this.a).getNotifyStyle();
        if (!this.d) {
            p.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return arrayList;
            }
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
                                inputStream2 = inputStream;
                            } catch (Throwable th) {
                                inputStream3 = inputStream;
                                th = th;
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Exception e) {
                                    }
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e2) {
                            p.a("ImageDownTask", "MalformedURLException");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    bitmap = null;
                                } catch (Exception e3) {
                                    bitmap = null;
                                }
                                arrayList.add(bitmap);
                                i = i2 + 1;
                            }
                            bitmap = null;
                            arrayList.add(bitmap);
                            i = i2 + 1;
                        } catch (IOException e4) {
                            p.a("ImageDownTask", "IOException");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    bitmap = null;
                                } catch (Exception e5) {
                                    bitmap = null;
                                }
                                arrayList.add(bitmap);
                                i = i2 + 1;
                            }
                            bitmap = null;
                            arrayList.add(bitmap);
                            i = i2 + 1;
                        }
                    } else {
                        inputStream2 = null;
                        bitmap = null;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e6) {
                        }
                    }
                } catch (MalformedURLException e7) {
                    inputStream = null;
                } catch (IOException e8) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmap);
            } else if (i2 == 0) {
                arrayList.add(null);
            }
            i = i2 + 1;
        }
    }
}
