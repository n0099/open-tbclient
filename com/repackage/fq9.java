package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.Q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public int b;
    public int c;
    public final /* synthetic */ sq9 d;

    public fq9(sq9 sq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = sq9Var;
        this.b = 0;
        this.c = 0;
        if (Looper.myLooper() != null) {
            this.a = new cq9(this, sq9Var);
        }
    }

    public Message a(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, obj)) == null) {
            Handler handler = this.a;
            if (handler != null) {
                return handler.obtainMessage(i, obj);
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            return obtain;
        }
        return (Message) invokeIL.objValue;
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i = message.what;
            if (i == 1) {
                Q q = (Q) ((Object[]) message.obj)[0];
                this.d.d.a();
            } else if (i == 3) {
                this.d.d.c();
            } else if (i == 5) {
                this.d.d.b(((Integer) ((Object[]) message.obj)[0]).intValue());
            } else if (i != 7) {
            } else {
                this.d.d.d();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cc -> B:49:0x00d3). Please submit an issue!!! */
    public void c(InputStream inputStream) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            this.b = 0;
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.d.c));
                        int i = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            z = true;
                            if (read == -1) {
                                z = false;
                                break;
                            } else if (this.d.f) {
                                fileOutputStream.write(bArr, 0, read);
                                int i2 = this.b + read;
                                this.b = i2;
                                if (this.d.a + i2 < this.d.g + this.d.a) {
                                    int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.d.a + i2) / ((float) (this.d.g + this.d.a)))) * 100.0f);
                                    this.c = parseFloat;
                                    if (i % 30 == 0 || parseFloat == 100) {
                                        d(a(5, new Object[]{Integer.valueOf(this.c)}));
                                    }
                                }
                                i++;
                            } else {
                                d(a(7, null));
                                break;
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.d.f = false;
                        if (!z) {
                            d(a(3, null));
                        }
                        inputStream.close();
                    } catch (Exception e) {
                        d(a(7, null));
                        this.d.f = false;
                        e.printStackTrace();
                        if (inputStream == null) {
                            return;
                        }
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            this.d.f = false;
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                this.d.f = false;
                e3.printStackTrace();
            }
        }
    }

    public void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.sendMessage(message);
            } else {
                b(message);
            }
        }
    }
}
