package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class l extends AsyncTask<String, Void, List<Bitmap>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76313a;

    /* renamed from: b  reason: collision with root package name */
    public InsideNotificationItem f76314b;

    /* renamed from: c  reason: collision with root package name */
    public long f76315c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76316d;

    /* renamed from: e  reason: collision with root package name */
    public int f76317e;

    public l(Context context, InsideNotificationItem insideNotificationItem, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, insideNotificationItem, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76317e = 0;
        this.f76313a = context;
        this.f76314b = insideNotificationItem;
        this.f76315c = j2;
        this.f76316d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (r5 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        if (r5 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r6 = null;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Bitmap> doInBackground(String... strArr) {
        InterceptResult invokeL;
        InputStream inputStream;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, strArr)) == null) {
            this.f76317e = ClientConfigManagerImpl.getInstance(this.f76313a).getNotifyStyle();
            InputStream inputStream2 = null;
            if (!this.f76316d) {
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
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        p.c("ImageDownTask", "onPostExecute");
        if (this.f76314b != null) {
            w.b().a("com.vivo.push.notify_key", this.f76315c);
            NotifyAdapterUtil.pushNotification(this.f76313a, list2, this.f76314b, this.f76315c, this.f76317e);
        }
    }
}
