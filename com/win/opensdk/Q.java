package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes10.dex */
public class Q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f76686a;

    /* renamed from: b  reason: collision with root package name */
    public int f76687b;

    /* renamed from: c  reason: collision with root package name */
    public int f76688c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ T f76689d;

    public Q(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76689d = t;
        this.f76687b = 0;
        this.f76688c = 0;
        if (Looper.myLooper() != null) {
            this.f76686a = new P(this, t);
        }
    }

    public Message a(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, obj)) == null) {
            Handler handler = this.f76686a;
            if (handler != null) {
                return handler.obtainMessage(i2, obj);
            }
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = obj;
            return obtain;
        }
        return (Message) invokeIL.objValue;
    }

    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                S s = (S) ((Object[]) message.obj)[0];
                this.f76689d.f76720d.a();
            } else if (i2 == 3) {
                this.f76689d.f76720d.b();
            } else if (i2 == 5) {
                this.f76689d.f76720d.a(((Integer) ((Object[]) message.obj)[0]).intValue());
            } else if (i2 != 7) {
            } else {
                this.f76689d.f76720d.c();
            }
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Handler handler = this.f76686a;
            if (handler != null) {
                handler.sendMessage(message);
            } else {
                a(message);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cc -> B:49:0x00d3). Please submit an issue!!! */
    public void a(InputStream inputStream) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            this.f76687b = 0;
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f76689d.f76719c));
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            z = true;
                            if (read == -1) {
                                z = false;
                                break;
                            } else if (this.f76689d.f76722f) {
                                fileOutputStream.write(bArr, 0, read);
                                int i3 = this.f76687b + read;
                                this.f76687b = i3;
                                if (this.f76689d.f76717a + i3 < this.f76689d.f76723g + this.f76689d.f76717a) {
                                    int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f76689d.f76717a + i3) / ((float) (this.f76689d.f76723g + this.f76689d.f76717a)))) * 100.0f);
                                    this.f76688c = parseFloat;
                                    if (i2 % 30 == 0 || parseFloat == 100) {
                                        b(a(5, new Object[]{Integer.valueOf(this.f76688c)}));
                                    }
                                }
                                i2++;
                            } else {
                                b(a(7, null));
                                break;
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f76689d.f76722f = false;
                        if (!z) {
                            b(a(3, null));
                        }
                        inputStream.close();
                    } catch (Exception e2) {
                        b(a(7, null));
                        this.f76689d.f76722f = false;
                        e2.printStackTrace();
                        if (inputStream == null) {
                            return;
                        }
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            this.f76689d.f76722f = false;
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                this.f76689d.f76722f = false;
                e4.printStackTrace();
            }
        }
    }
}
