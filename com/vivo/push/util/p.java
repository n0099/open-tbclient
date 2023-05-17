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
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class p extends AsyncTask<String, Void, List<Bitmap>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public InsideNotificationItem b;
    public long c;
    public boolean d;
    public int e;
    public NotifyArriveCallbackByUser f;
    public u.a g;

    public p(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, u.a aVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, insideNotificationItem, Long.valueOf(j), Boolean.valueOf(z), aVar, notifyArriveCallbackByUser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.a = context;
        this.b = insideNotificationItem;
        this.c = j;
        this.d = z;
        this.g = aVar;
        this.f = notifyArriveCallbackByUser;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        u.c("ImageDownTask", "onPostExecute");
        com.vivo.push.m.c(new q(this, list2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r5 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r5 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, strArr)) == null) {
            this.e = this.b.getNotifyDisplayStatus();
            InputStream inputStream2 = null;
            if (!this.d) {
                u.d("ImageDownTask", "bitmap is not display by forbid net");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                u.d("ImageDownTask", "imgUrl=" + str + " i=" + i);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        u.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
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
                                u.a("ImageDownTask", "MalformedURLException");
                            } catch (IOException unused3) {
                                u.a("ImageDownTask", "IOException");
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
                } else if (i == 0) {
                    arrayList.add(null);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
