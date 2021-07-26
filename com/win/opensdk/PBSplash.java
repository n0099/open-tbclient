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
/* loaded from: classes6.dex */
public class PBSplash implements B {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isdpl;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public Context f39635a;

    /* renamed from: b */
    public E f39636b;

    /* renamed from: c */
    public Bitmap f39637c;

    /* renamed from: d */
    public CircleProgressbar f39638d;

    /* renamed from: e */
    public PBSplashListener f39639e;

    /* renamed from: f */
    public boolean f39640f;

    /* renamed from: g */
    public int f39641g;

    /* renamed from: h */
    public int f39642h;

    /* renamed from: i */
    public boolean f39643i;
    public boolean j;
    public boolean k;
    public File l;
    public byte[] m;
    public v n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public z v;
    public Handler w;

    public PBSplash(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39640f = false;
        this.f39641g = 5000;
        this.f39642h = 6;
        this.f39643i = false;
        this.j = false;
        this.k = false;
        this.o = null;
        this.q = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = new z(this);
        this.w = new A(this, Looper.getMainLooper());
        this.f39635a = context;
        try {
            U1.b(context, 0.0f);
            U1.c(context, 0.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f39636b = new E(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.x.a(android.graphics.Bitmap):void, com.win.opensdk.x.a(com.win.opensdk.l0):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.f39643i = z;
        return z;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(N.a(this.f39635a) + File.separator + "win" + File.separator + N.c(str) + ".gif");
                this.p = file;
                if (file == null || !file.exists()) {
                    if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                        this.n.cancel(true);
                    }
                    v vVar = new v(this, str);
                    this.n = vVar;
                    vVar.execute(str);
                } else if (this.f39639e == null || this.j || this.f39639e == null) {
                } else {
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
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.m = bArr;
                    if (bArr != null) {
                        this.f39639e.onLoaded();
                        this.f39643i = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(N.a(this.f39635a) + File.separator + "win" + File.separator + N.c(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (!file.exists()) {
                new n0(new x(this, compressFormat)).a(str, false);
            } else if (this.f39639e == null || this.j) {
            } else {
                File file2 = this.l;
                this.f39637c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
                this.f39639e.onLoaded();
                this.f39643i = true;
            }
        }
    }

    public void destroy() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Info info = null;
                if (this.f39637c != null) {
                    this.f39637c.recycle();
                    this.f39637c = null;
                    File file2 = this.o;
                    if (file2 != null) {
                        try {
                            File file3 = new File(file2.getPath());
                            if (file3.exists() && file3.isFile()) {
                                file3.delete();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.m != null && (file = this.q) != null) {
                    try {
                        File file4 = new File(file.getPath());
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
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
                if (this.f39636b != null) {
                    A1 a1 = this.f39636b.f39563a;
                    if (a1 != null && a1.b()) {
                        info = a1.f39541c;
                    }
                    if (info != null) {
                        Z0.a(this.f39635a).a(new a1(info)).a();
                    }
                    this.f39636b.a();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            E e2 = this.f39636b;
            if (e2 == null || this.f39637c == null) {
                E e3 = this.f39636b;
                if (e3 == null || this.m == null) {
                    return false;
                }
                return e3.c();
            }
            return e2.c();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        long j;
        m1 m1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!N.e(this.f39635a)) {
                PBSplashListener pBSplashListener = this.f39639e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f39636b != null) {
                this.f39643i = false;
                this.j = false;
                this.k = false;
                isdpl = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    j = U1.q(this.f39635a) >= U1.d(this.f39635a) ? U1.q(this.f39635a) : U1.d(this.f39635a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 2000;
                }
                handler.sendMessageDelayed(obtain, j);
                A1 a1 = this.f39636b.f39563a;
                if (a1 == null || (m1Var = a1.f39540b) == null) {
                    return;
                }
                m1Var.b();
            }
        }
    }

    public void setExpressViewAcceptedSize(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.t = f3;
            this.u = f2;
            if (f2 > 0.0f) {
                try {
                    float a2 = N.a(this.f39635a, this.u);
                    float f4 = this.f39635a.getResources().getDisplayMetrics().widthPixels / 2.0f;
                    if (a2 < f4) {
                        a2 = f4;
                    }
                    U1.c(this.f39635a, a2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (f3 > 0.0f) {
                float a3 = N.a(this.f39635a, this.t);
                float c2 = N.c(this.f39635a) / 2.0f;
                if (a3 < c2) {
                    a3 = c2;
                }
                U1.b(this.f39635a, a3);
            }
        }
    }

    public void setLoadTimeOut(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            U1.a(this.f39635a, j);
        }
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pBSplashListener) == null) {
            this.f39639e = pBSplashListener;
            this.f39636b.f39564b = new u(this);
        }
    }

    public void show(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!N.e(this.f39635a)) {
                PBSplashListener pBSplashListener = this.f39639e;
                if (pBSplashListener != null) {
                    pBSplashListener.onDisplayError(PBError.NO_NETWORK);
                }
            } else if (!isReady()) {
                PBSplashListener pBSplashListener2 = this.f39639e;
                if (pBSplashListener2 != null) {
                    pBSplashListener2.onDisplayError(PBError.NO_LOAD);
                }
            } else if (this.f39636b.b().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.f39635a).inflate(R.layout.win_layout_win_splash, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.win_splash_iv);
                a(inflate);
                imageView.setVisibility(0);
                b(inflate);
                imageView.setImageBitmap(this.f39637c);
                this.o = this.l;
                this.f39636b.a(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.f39635a).inflate(R.layout.win_layout_win_splash, viewGroup);
                a(inflate2);
                GifImageView gifImageView = (GifImageView) inflate2.findViewById(R.id.win_gifImageView);
                gifImageView.setVisibility(0);
                byte[] bArr = this.m;
                if (bArr != null) {
                    gifImageView.setBytes(bArr);
                    gifImageView.b();
                    this.q = this.p;
                }
                b(inflate2);
                this.f39636b.a(viewGroup, null);
            }
        }
    }

    public void show(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, viewGroup, view) == null) {
            this.s = view;
            show(viewGroup);
        }
    }

    public final void a(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.t <= 0.0f || i2 <= 0) {
            return;
        }
        try {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.win_splash_logo);
            relativeLayout.removeAllViews();
            if (this.s != null) {
                relativeLayout.addView(this.s);
            }
            View findViewById = view.findViewById(R.id.win_splash_view);
            float a2 = N.a(this.f39635a, this.t);
            float c2 = N.c(this.f39635a) / 2.0f;
            if (a2 < c2) {
                a2 = c2;
            }
            float a3 = N.a(this.f39635a, this.u);
            float f2 = this.f39635a.getResources().getDisplayMetrics().widthPixels / 2.0f;
            if (a3 < f2) {
                a3 = f2;
            }
            findViewById.setLayoutParams(new LinearLayout.LayoutParams((int) a3, (int) a2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            A1 a1 = this.f39636b.f39563a;
            long countdown = (a1 == null || !a1.b()) ? 0L : a1.f39541c.getCountdown();
            CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.win_splash_skip);
            this.f39638d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.f39638d.setInCircleColor(Color.parseColor(this.f39635a.getString(R.string.win_cyclecolor)));
            this.f39638d.setProgressColor(Color.parseColor(this.f39635a.getString(R.string.win_cyc_process_color)));
            this.f39638d.setProgressLineWidth(this.f39642h);
            this.f39638d.setProgressType(m2.f39882b);
            CircleProgressbar circleProgressbar2 = this.f39638d;
            if (countdown <= 0) {
                countdown = this.f39641g;
            }
            circleProgressbar2.setTimeMillis(countdown);
            this.f39638d.a();
            this.f39638d.a(1, this.v);
            this.f39640f = false;
            this.f39638d.setOnClickListener(new y(this));
        }
    }
}
