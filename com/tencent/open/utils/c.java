package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f76425c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76426a;

    /* renamed from: b  reason: collision with root package name */
    public d f76427b;

    /* renamed from: d  reason: collision with root package name */
    public long f76428d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f76429e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Activity> f76430f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f76431g;

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76431g = new Runnable(this) { // from class: com.tencent.open.utils.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f76433a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f76433a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    SLog.v("AsynLoadImg", "saveFileRunnable:");
                    String str = "share_qq_" + l.f(this.f76433a.f76426a) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                    String str2 = c.f76425c + str;
                    File file = new File(str2);
                    Message obtainMessage = this.f76433a.f76429e.obtainMessage();
                    if (!file.exists()) {
                        Bitmap a2 = c.a(this.f76433a.f76426a);
                        if (a2 != null) {
                            z = this.f76433a.a(a2, str);
                        } else {
                            SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                            z = false;
                        }
                        if (z) {
                            obtainMessage.arg1 = 0;
                            obtainMessage.obj = str2;
                        } else {
                            obtainMessage.arg1 = 1;
                        }
                        SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - this.f76433a.f76428d));
                    } else {
                        obtainMessage.arg1 = 0;
                        obtainMessage.obj = str2;
                        SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - this.f76433a.f76428d));
                    }
                    this.f76433a.f76429e.sendMessage(obtainMessage);
                }
            }
        };
        this.f76430f = new WeakReference<>(activity);
        this.f76429e = new Handler(this, activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f76432a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f76432a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                    if (message.arg1 == 0) {
                        this.f76432a.f76427b.a(message.arg1, (String) message.obj);
                    } else {
                        this.f76432a.f76427b.a(message.arg1, (String) null);
                    }
                }
            }
        };
    }

    public void a(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            SLog.v("AsynLoadImg", "--save---");
            if (str != null && !str.equals("")) {
                if (!l.a()) {
                    dVar.a(2, (String) null);
                    return;
                }
                if (this.f76430f.get() != null) {
                    Activity activity = this.f76430f.get();
                    File h2 = l.h(activity, "Images");
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (h2 == null) {
                        SLog.e("AsynLoadImg", "externalImageFile is null");
                        dVar.a(2, (String) null);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i.c(activity) ? h2.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb.append("/tmp/");
                    f76425c = sb.toString();
                }
                this.f76428d = System.currentTimeMillis();
                this.f76426a = str;
                this.f76427b = dVar;
                new Thread(this.f76431g).start();
                return;
            }
            dVar.a(1, (String) null);
        }
    }

    public boolean a(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, str)) == null) {
            String str2 = f76425c;
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    SLog.v("AsynLoadImg", "saveFile:" + str);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
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
                SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
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
        return invokeLL.booleanValue;
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            SLog.v("AsynLoadImg", "getbitmap:" + str);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                SLog.v("AsynLoadImg", "image download finished." + str);
                return decodeStream;
            } catch (IOException e2) {
                e2.printStackTrace();
                SLog.v("AsynLoadImg", "getbitmap bmp fail---");
                return null;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                SLog.v("AsynLoadImg", "getbitmap bmp fail---");
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }
}
