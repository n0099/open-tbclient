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
import org.json.JSONException;
/* loaded from: classes6.dex */
public class PBSplash implements n {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isdpl;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public Context f39442a;

    /* renamed from: b */
    public q f39443b;

    /* renamed from: c */
    public Bitmap f39444c;

    /* renamed from: d */
    public CircleProgressbar f39445d;

    /* renamed from: e */
    public PBSplashListener f39446e;

    /* renamed from: f */
    public boolean f39447f;

    /* renamed from: g */
    public int f39448g;

    /* renamed from: h */
    public int f39449h;

    /* renamed from: i */
    public boolean f39450i;
    public boolean j;
    public boolean k;
    public File l;
    public byte[] m;
    public h n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public l v;
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
        this.f39447f = false;
        this.f39448g = 5000;
        this.f39449h = 6;
        this.f39450i = false;
        this.j = false;
        this.k = false;
        this.o = null;
        this.q = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = new l(this);
        this.w = new m(this, Looper.getMainLooper());
        this.f39442a = context;
        try {
            s1.a(context, 0.0f);
            s1.b(context, 0.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f39443b = new q(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j.a(com.win.opensdk.O):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.f39450i = z;
        return z;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(z.a(this.f39442a) + File.separator + "win" + File.separator + z.c(str) + ".gif");
                this.p = file;
                if (file == null || !file.exists()) {
                    if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                        this.n.cancel(true);
                    }
                    h hVar = new h(this, str);
                    this.n = hVar;
                    hVar.execute(str);
                } else if (this.f39446e == null || this.j || this.f39446e == null) {
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
                        this.f39446e.onLoaded();
                        this.f39450i = true;
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
            File file = new File(z.a(this.f39442a) + File.separator + "win" + File.separator + z.c(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (!file.exists()) {
                Q q = new Q(new j(this, compressFormat));
                if (q.f39455b.contains(str)) {
                    return;
                }
                new M(q, str, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else if (this.f39446e == null || this.j) {
            } else {
                File file2 = this.l;
                this.f39444c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
                this.f39446e.onLoaded();
                this.f39450i = true;
            }
        }
    }

    public void destroy() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Info info = null;
                if (this.f39444c != null) {
                    this.f39444c.recycle();
                    this.f39444c = null;
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
                if (this.f39443b != null) {
                    Y0 y0 = this.f39443b.f39633a;
                    if (y0 != null && y0.b()) {
                        info = y0.f39522c;
                    }
                    if (info != null) {
                        w0 a2 = x0.a(this.f39442a);
                        try {
                            a2.f39697b = x0.a("ao", new y0(info));
                        } catch (JSONException unused) {
                        }
                        a2.a();
                    }
                    this.f39443b.a();
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
            q qVar = this.f39443b;
            if (qVar == null || this.f39444c == null) {
                q qVar2 = this.f39443b;
                if (qVar2 == null || this.m == null) {
                    return false;
                }
                return qVar2.c();
            }
            return qVar.c();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        long j;
        K0 k0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!z.e(this.f39442a)) {
                PBSplashListener pBSplashListener = this.f39446e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f39443b != null) {
                this.f39450i = false;
                this.j = false;
                this.k = false;
                isdpl = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    j = s1.p(this.f39442a) >= s1.d(this.f39442a) ? s1.p(this.f39442a) : s1.d(this.f39442a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 2000;
                }
                handler.sendMessageDelayed(obtain, j);
                Y0 y0 = this.f39443b.f39633a;
                if (y0 == null || (k0 = y0.f39521b) == null) {
                    return;
                }
                k0.b();
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
                    float a2 = z.a(this.f39442a, this.u);
                    float f4 = this.f39442a.getResources().getDisplayMetrics().widthPixels / 2.0f;
                    if (a2 < f4) {
                        a2 = f4;
                    }
                    s1.b(this.f39442a, a2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (f3 > 0.0f) {
                float a3 = z.a(this.f39442a, this.t);
                float c2 = z.c(this.f39442a) / 2.0f;
                if (a3 < c2) {
                    a3 = c2;
                }
                s1.a(this.f39442a, a3);
            }
        }
    }

    public void setLoadTimeOut(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            s1.a(this.f39442a, j);
        }
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pBSplashListener) == null) {
            this.f39446e = pBSplashListener;
            this.f39443b.f39634b = new g(this);
        }
    }

    public void show(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!z.e(this.f39442a)) {
                PBSplashListener pBSplashListener = this.f39446e;
                if (pBSplashListener != null) {
                    pBSplashListener.onDisplayError(PBError.NO_NETWORK);
                }
            } else if (!isReady()) {
                PBSplashListener pBSplashListener2 = this.f39446e;
                if (pBSplashListener2 != null) {
                    pBSplashListener2.onDisplayError(PBError.NO_LOAD);
                }
            } else if (this.f39443b.b().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.f39442a).inflate(R.layout.win_layout_win_splash, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.win_splash_iv);
                a(inflate);
                imageView.setVisibility(0);
                b(inflate);
                imageView.setImageBitmap(this.f39444c);
                this.o = this.l;
                this.f39443b.a(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.f39442a).inflate(R.layout.win_layout_win_splash, viewGroup);
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
                this.f39443b.a(viewGroup, null);
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
            float a2 = z.a(this.f39442a, this.t);
            float c2 = z.c(this.f39442a) / 2.0f;
            if (a2 < c2) {
                a2 = c2;
            }
            float a3 = z.a(this.f39442a, this.u);
            float f2 = this.f39442a.getResources().getDisplayMetrics().widthPixels / 2.0f;
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
            Y0 y0 = this.f39443b.f39633a;
            long countdown = (y0 == null || !y0.b()) ? 0L : y0.f39522c.getCountdown();
            CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.win_splash_skip);
            this.f39445d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.f39445d.setInCircleColor(Color.parseColor(this.f39442a.getString(R.string.win_cyclecolor)));
            this.f39445d.setProgressColor(Color.parseColor(this.f39442a.getString(R.string.win_cyc_process_color)));
            this.f39445d.setProgressLineWidth(this.f39449h);
            this.f39445d.setProgressType(K1.f39403b);
            CircleProgressbar circleProgressbar2 = this.f39445d;
            if (countdown <= 0) {
                countdown = this.f39448g;
            }
            circleProgressbar2.setTimeMillis(countdown);
            this.f39445d.a();
            this.f39445d.a(1, this.v);
            this.f39447f = false;
            this.f39445d.setOnClickListener(new k(this));
        }
    }
}
