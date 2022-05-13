package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import com.win.opensdk.image.gif2.GifImageView;
import com.win.opensdk.views.CircleProgressbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes5.dex */
public class dp9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public on9 b;
    public Bitmap c;
    public CircleProgressbar d;
    public ep9 e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public File l;
    public byte[] m;
    public it9 n;
    public File o;
    public File p;
    public File q;
    public ViewGroup r;
    public View s;
    public float t;
    public float u;
    public yt9 v;
    public Handler w;

    public dp9(Context context, String str) {
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
        this.v = new yt9(this);
        this.w = new cu9(this, Looper.getMainLooper());
        this.a = context;
        try {
            hq9.k(context, 0.0f);
            hq9.o(context, 0.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = new on9(context, str);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.qt9.a(android.graphics.Bitmap):void, com.repackage.qt9.a(com.win.opensdk.k0):void] */
    public static /* synthetic */ boolean i(dp9 dp9Var, boolean z) {
        dp9Var.i = z;
        return z;
    }

    public final void b(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.t <= 0.0f || i <= 0) {
            return;
        }
        try {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924b4);
            relativeLayout.removeAllViews();
            if (this.s != null) {
                relativeLayout.addView(this.s);
            }
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0924b7);
            float a = ro9.a(this.a, this.t);
            float C = ro9.C(this.a) / 2.0f;
            if (a < C) {
                a = C;
            }
            float a2 = ro9.a(this.a, this.u);
            float f = this.a.getResources().getDisplayMetrics().widthPixels / 2.0f;
            if (a2 < f) {
                a2 = f;
            }
            findViewById.setLayoutParams(new LinearLayout.LayoutParams((int) a2, (int) a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(ro9.e(this.a) + File.separator + "win" + File.separator + ro9.D(str) + ".gif");
                this.p = file;
                if (file == null || !file.exists()) {
                    if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                        this.n.cancel(true);
                    }
                    it9 it9Var = new it9(this, str);
                    this.n = it9Var;
                    it9Var.execute(str);
                } else if (this.e == null || this.j || this.e == null) {
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
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.m = bArr;
                    if (bArr != null) {
                        this.e.onLoaded();
                        this.i = true;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            un9 un9Var = this.b.a;
            long countdown = (un9Var == null || !un9Var.f()) ? 0L : un9Var.c.getCountdown();
            CircleProgressbar circleProgressbar = (CircleProgressbar) view2.findViewById(R.id.obfuscated_res_0x7f0924b6);
            this.d = circleProgressbar;
            circleProgressbar.setOutLineColor(0);
            this.d.setInCircleColor(Color.parseColor(this.a.getString(R.string.obfuscated_res_0x7f0f1588)));
            this.d.setProgressColor(Color.parseColor(this.a.getString(R.string.obfuscated_res_0x7f0f1587)));
            this.d.setProgressLineWidth(this.h);
            this.d.setProgressType(com.win.opensdk.s2.b);
            CircleProgressbar circleProgressbar2 = this.d;
            if (countdown <= 0) {
                countdown = this.g;
            }
            circleProgressbar2.setTimeMillis(countdown);
            this.d.a();
            this.d.b(1, this.v);
            this.f = false;
            this.d.setOnClickListener(new ut9(this));
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(ro9.e(this.a) + File.separator + "win" + File.separator + ro9.D(str) + "." + compressFormat.name().toLowerCase());
            this.l = file;
            if (!file.exists()) {
                new as9(new qt9(this, compressFormat)).a(str, false);
            } else if (this.e == null || this.j) {
            } else {
                File file2 = this.l;
                this.c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
                this.e.onLoaded();
                this.i = true;
            }
        }
    }

    public void j() {
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
                    un9 un9Var = this.b.a;
                    if (un9Var != null && un9Var.f()) {
                        info = un9Var.c;
                    }
                    if (info != null) {
                        tq9 a = xq9.a(this.a);
                        a.b(new br9(info));
                        a.m();
                    }
                    this.b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            on9 on9Var = this.b;
            if (on9Var == null || this.c == null) {
                on9 on9Var2 = this.b;
                if (on9Var2 == null || this.m == null) {
                    return false;
                }
                return on9Var2.d();
            }
            return on9Var.d();
        }
        return invokeV.booleanValue;
    }

    public void l() {
        long j;
        vs9 vs9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!ro9.H(this.a)) {
                ep9 ep9Var = this.e;
                if (ep9Var != null) {
                    ep9Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.b != null) {
                this.i = false;
                this.j = false;
                this.k = false;
                x = false;
                Handler handler = this.w;
                Message obtain = Message.obtain();
                try {
                    j = hq9.K(this.a) >= hq9.r(this.a) ? hq9.K(this.a) : hq9.r(this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                    j = 2000;
                }
                handler.sendMessageDelayed(obtain, j);
                un9 un9Var = this.b.a;
                if (un9Var == null || (vs9Var = un9Var.b) == null) {
                    return;
                }
                vs9Var.g();
            }
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            hq9.d(this.a, j);
        }
    }

    public void n(ep9 ep9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ep9Var) == null) {
            this.e = ep9Var;
            this.b.b = new et9(this);
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            this.r = viewGroup;
            if (!ro9.H(this.a)) {
                ep9 ep9Var = this.e;
                if (ep9Var != null) {
                    ep9Var.b(PBError.NO_NETWORK);
                }
            } else if (!k()) {
                ep9 ep9Var2 = this.e;
                if (ep9Var2 != null) {
                    ep9Var2.b(PBError.NO_LOAD);
                }
            } else if (this.b.c().equals("image")) {
                viewGroup.removeAllViews();
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08c7, viewGroup);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0924b3);
                b(inflate);
                imageView.setVisibility(0);
                e(inflate);
                imageView.setImageBitmap(this.c);
                this.o = this.l;
                this.b.b(viewGroup, null);
            } else {
                viewGroup.removeAllViews();
                View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08c7, viewGroup);
                b(inflate2);
                GifImageView gifImageView = (GifImageView) inflate2.findViewById(R.id.obfuscated_res_0x7f0924ab);
                gifImageView.setVisibility(0);
                byte[] bArr = this.m;
                if (bArr != null) {
                    gifImageView.setBytes(bArr);
                    gifImageView.d();
                    this.q = this.p;
                }
                e(inflate2);
                this.b.b(viewGroup, null);
            }
        }
    }
}
