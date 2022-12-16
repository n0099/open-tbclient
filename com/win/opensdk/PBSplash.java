package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.image.gif2.GifImageView;
import com.win.opensdk.views.CircleProgressbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes8.dex */
public class PBSplash implements A {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isdpl;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public D b;
    public Bitmap c;
    public CircleProgressbar d;
    public PBSplashListener e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public File l;
    public byte[] m;
    public u n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public y v;
    public Handler w;

    public PBSplash(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = 5000;
        this.h = 6;
        this.i = false;
        this.j = false;
        this.k = false;
        this.o = null;
        this.q = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = new y(this);
        this.w = new z(this, Looper.getMainLooper());
        this.a = context;
        try {
            Z1.b(context, 0.0f);
            Z1.c(context, 0.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = new D(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.w.a(android.graphics.Bitmap):void, com.win.opensdk.w.a(com.win.opensdk.k0):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.i = z;
        return z;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            D d = this.b;
            if (d == null || this.c == null) {
                D d2 = this.b;
                if (d2 == null || this.m == null) {
                    return false;
                }
                return d2.c();
            }
            return d.c();
        }
        return invokeV.booleanValue;
    }

    public void setLoadTimeOut(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            Z1.a(this.a, j);
        }
    }

    public void show(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, viewGroup, view2) == null) {
            this.s = view2;
            show(viewGroup);
        }
    }

    public final void a(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.t > 0.0f && i > 0) {
            try {
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09275b);
                relativeLayout.removeAllViews();
                if (this.s != null) {
                    relativeLayout.addView(this.s);
                }
                View findViewById = view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09275e);
                float a = M.a(this.a, this.t);
                float c = M.c(this.a) / 2.0f;
                if (a < c) {
                    a = c;
                }
                float a2 = M.a(this.a, this.u);
                float f = this.a.getResources().getDisplayMetrics().widthPixels / 2.0f;
                if (a2 < f) {
                    a2 = f;
                }
                findViewById.setLayoutParams(new LinearLayout.LayoutParams((int) a2, (int) a));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(View view2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            F1 f1 = this.b.a;
            if (f1 != null && f1.b()) {
                j = f1.c.getCountdown();
            } else {
                j = 0;
            }
            CircleProgressbar circleProgressbar = (CircleProgressbar) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09275d);
            this.d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.d.setInCircleColor(Color.parseColor(this.a.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1643)));
            this.d.setProgressColor(Color.parseColor(this.a.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1642)));
            this.d.setProgressLineWidth(this.h);
            this.d.setProgressType(s2.b);
            CircleProgressbar circleProgressbar2 = this.d;
            if (j <= 0) {
                j = this.g;
            }
            circleProgressbar2.setTimeMillis(j);
            this.d.a();
            this.d.a(1, this.v);
            this.f = false;
            this.d.setOnClickListener(new x(this));
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(M.a(this.a) + File.separator + "win" + File.separator + M.c(str) + ".gif");
                this.p = file;
                if (file != null && file.exists()) {
                    if (this.e != null && !this.j && this.e != null) {
                        File file2 = this.p;
                        byte[] bArr = null;
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            fileInputStream.close();
                            byteArrayOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                            if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        this.m = bArr;
                        if (bArr != null) {
                            this.e.onLoaded();
                            this.i = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(true);
                }
                u uVar = new u(this, str);
                this.n = uVar;
                uVar.execute(str);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void show(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!M.e(this.a)) {
                PBSplashListener pBSplashListener = this.e;
                if (pBSplashListener != null) {
                    pBSplashListener.onDisplayError(PBError.NO_NETWORK);
                }
            } else if (!isReady()) {
                PBSplashListener pBSplashListener2 = this.e;
                if (pBSplashListener2 != null) {
                    pBSplashListener2.onDisplayError(PBError.NO_LOAD);
                }
            } else if (this.b.b().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0960, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09275a);
                a(inflate);
                imageView.setVisibility(0);
                b(inflate);
                imageView.setImageBitmap(this.c);
                this.o = this.l;
                this.b.a(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0960, viewGroup);
                a(inflate2);
                GifImageView gifImageView = (GifImageView) inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092752);
                gifImageView.setVisibility(0);
                byte[] bArr = this.m;
                if (bArr != null) {
                    gifImageView.setBytes(bArr);
                    gifImageView.b();
                    this.q = this.p;
                }
                b(inflate2);
                this.b.a(viewGroup, null);
            }
        }
    }

    public final void b(String str) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(M.a(this.a) + File.separator + "win" + File.separator + M.c(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (file.exists()) {
                if (this.e != null && !this.j) {
                    File file2 = this.l;
                    if (file2.exists() && !file2.isDirectory()) {
                        bitmap = BitmapFactory.decodeFile(file2.getAbsolutePath());
                    } else {
                        bitmap = null;
                    }
                    this.c = bitmap;
                    this.e.onLoaded();
                    this.i = true;
                    return;
                }
                return;
            }
            new m0(new w(this, compressFormat)).a(str, false);
        }
    }

    public void destroy() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Info info = null;
                if (this.c != null) {
                    this.c.recycle();
                    this.c = null;
                    File file2 = this.o;
                    if (file2 != null) {
                        try {
                            File file3 = new File(file2.getPath());
                            if (file3.exists() && file3.isFile()) {
                                file3.delete();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.m != null && (file = this.q) != null) {
                    try {
                        File file4 = new File(file.getPath());
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.w != null) {
                    this.w.removeCallbacksAndMessages(null);
                    this.w = null;
                }
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(false);
                    this.n = null;
                }
                if (this.b != null) {
                    F1 f1 = this.b.a;
                    if (f1 != null && f1.b()) {
                        info = f1.c;
                    }
                    if (info != null) {
                        e1.a(this.a).a(new f1(info)).a();
                    }
                    this.b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void load() {
        long j;
        r1 r1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!M.e(this.a)) {
                PBSplashListener pBSplashListener = this.e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.b != null) {
                this.i = false;
                this.j = false;
                this.k = false;
                isdpl = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    if (Z1.r(this.a) >= Z1.d(this.a)) {
                        j = Z1.r(this.a);
                    } else {
                        j = Z1.d(this.a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    j = 2000;
                }
                handler.sendMessageDelayed(obtain, j);
                F1 f1 = this.b.a;
                if (f1 != null && (r1Var = f1.b) != null) {
                    r1Var.b();
                }
            }
        }
    }

    public void setExpressViewAcceptedSize(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.t = f2;
            this.u = f;
            if (f > 0.0f) {
                try {
                    float a = M.a(this.a, this.u);
                    float f3 = this.a.getResources().getDisplayMetrics().widthPixels / 2.0f;
                    if (a < f3) {
                        a = f3;
                    }
                    Z1.c(this.a, a);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (f2 > 0.0f) {
                float a2 = M.a(this.a, this.t);
                float c = M.c(this.a) / 2.0f;
                if (a2 < c) {
                    a2 = c;
                }
                Z1.b(this.a, a2);
            }
        }
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pBSplashListener) == null) {
            this.e = pBSplashListener;
            this.b.b = new t(this);
        }
    }
}
