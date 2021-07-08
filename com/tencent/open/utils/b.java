package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f38997c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38998a;

    /* renamed from: b  reason: collision with root package name */
    public c f38999b;

    /* renamed from: d  reason: collision with root package name */
    public long f39000d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f39001e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f39002f;

    public b(Activity activity) {
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
        this.f39002f = new Runnable(this) { // from class: com.tencent.open.utils.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f39004a;

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
                this.f39004a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
                    String str = "share_qq_" + j.f(this.f39004a.f38998a) + ".jpg";
                    String str2 = b.f38997c + str;
                    File file = new File(str2);
                    Message obtainMessage = this.f39004a.f39001e.obtainMessage();
                    if (!file.exists()) {
                        Bitmap a2 = b.a(this.f39004a.f38998a);
                        if (a2 != null) {
                            z = this.f39004a.a(a2, str);
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
                        com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - this.f39004a.f39000d));
                    } else {
                        obtainMessage.arg1 = 0;
                        obtainMessage.obj = str2;
                        com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - this.f39004a.f39000d));
                    }
                    this.f39004a.f39001e.sendMessage(obtainMessage);
                }
            }
        };
        this.f39001e = new Handler(this, activity.getMainLooper()) { // from class: com.tencent.open.utils.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f39003a;

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
                this.f39003a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
                    if (message.arg1 == 0) {
                        this.f39003a.f38999b.a(message.arg1, (String) message.obj);
                    } else {
                        this.f39003a.f38999b.a(message.arg1, (String) null);
                    }
                }
            }
        };
    }

    public void a(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            com.tencent.open.a.f.a("AsynLoadImg", "--save---");
            if (str != null && !str.equals("")) {
                if (!j.b()) {
                    cVar.a(2, (String) null);
                    return;
                }
                f38997c = Environment.getExternalStorageDirectory() + "/tmp/";
                this.f39000d = System.currentTimeMillis();
                this.f38998a = str;
                this.f38999b = cVar;
                new Thread(this.f39002f).start();
                return;
            }
            cVar.a(1, (String) null);
        }
    }

    public boolean a(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, str)) == null) {
            String str2 = f38997c;
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFile:" + str);
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
        return invokeLL.booleanValue;
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }
}
