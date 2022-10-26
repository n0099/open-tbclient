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
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class k extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public InsideNotificationItem b;
    public long c;
    public boolean d;
    public int e;
    public r.a f;

    public k(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, insideNotificationItem, Long.valueOf(j), Boolean.valueOf(z), aVar};
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
        this.f = aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        List list = (List) obj;
        super.onPostExecute(list);
        p.c("ImageDownTask", "onPostExecute");
        com.vivo.push.m.c(new l(this, list));
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
    public List doInBackground(String... strArr) {
        InterceptResult invokeL;
        InputStream inputStream;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, strArr)) == null) {
            this.e = this.b.getNotifyDisplayStatus();
            InputStream inputStream2 = null;
            if (!this.d) {
                p.d("ImageDownTask", "bitmap is not display by forbid net");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                p.d("ImageDownTask", "imgUrl=" + str + " i=" + i);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        p.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
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
                } else if (i == 0) {
                    arrayList.add(null);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
