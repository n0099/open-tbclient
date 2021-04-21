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
import com.win.opensdk.core.Info;
import com.win.opensdk.image.gif2.GifImageView;
import com.win.opensdk.views.CircleProgressbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes7.dex */
public class PBSplash implements n {
    public static boolean isdpl = false;

    /* renamed from: a */
    public Context f40144a;

    /* renamed from: b */
    public q f40145b;

    /* renamed from: c */
    public Bitmap f40146c;

    /* renamed from: d */
    public CircleProgressbar f40147d;

    /* renamed from: e */
    public PBSplashListener f40148e;
    public File l;
    public byte[] m;
    public h n;
    public File p;
    public ViewGroup r;

    /* renamed from: f */
    public boolean f40149f = false;

    /* renamed from: g */
    public int f40150g = 5000;

    /* renamed from: h */
    public int f40151h = 6;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public File o = null;
    public File q = null;
    public l s = new l(this);
    public Handler t = new m(this, Looper.getMainLooper());

    public PBSplash(Context context, String str) {
        this.f40144a = context;
        this.f40145b = new q(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j.a(com.win.opensdk.W):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.i = z;
        return z;
    }

    public final void a(String str) {
        try {
            File file = new File(G.a(this.f40144a) + File.separator + "win" + File.separator + G.c(str) + ".gif");
            this.p = file;
            if (file == null || !file.exists()) {
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(true);
                }
                h hVar = new h(this, str);
                this.n = hVar;
                hVar.execute(str);
            } else if (this.f40148e == null || this.j || this.f40148e == null) {
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
                    this.f40148e.onLoaded();
                    this.i = true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void b(String str) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        File file = new File(G.a(this.f40144a) + File.separator + "win" + File.separator + G.c(str) + "." + compressFormat.name().toLowerCase());
        this.l = file;
        if (!file.exists()) {
            Y y = new Y(new j(this, compressFormat));
            if (y.f40220b.contains(str)) {
                return;
            }
            new U(y, str, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else if (this.f40148e == null || this.j) {
        } else {
            File file2 = this.l;
            this.f40146c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
            this.f40148e.onLoaded();
            this.i = true;
        }
    }

    public void destroy() {
        File file;
        try {
            Info info = null;
            if (this.f40146c != null) {
                this.f40146c.recycle();
                this.f40146c = null;
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
            if (this.t != null) {
                this.t.removeCallbacksAndMessages(null);
                this.t = null;
            }
            if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                this.n.cancel(false);
                this.n = null;
            }
            if (this.f40145b != null) {
                B1 b1 = this.f40145b.f40400a;
                if (b1 != null && b1.b()) {
                    info = b1.f40011c;
                }
                if (info != null) {
                    a1.a(this.f40144a).a(new b1(info)).a();
                }
                this.f40145b.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean isReady() {
        q qVar = this.f40145b;
        if (qVar == null || this.f40146c == null) {
            q qVar2 = this.f40145b;
            if (qVar2 == null || this.m == null) {
                return false;
            }
            return qVar2.c();
        }
        return qVar.c();
    }

    public void load() {
        long j;
        n1 n1Var;
        if (!G.g(this.f40144a)) {
            PBSplashListener pBSplashListener = this.f40148e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_NETWORK);
            }
        } else if (this.f40145b != null) {
            this.i = false;
            this.j = false;
            this.k = false;
            isdpl = false;
            Handler handler = this.t;
            Message obtain = Message.obtain();
            try {
                j = V1.r(this.f40144a) >= V1.d(this.f40144a) ? V1.r(this.f40144a) : V1.d(this.f40144a);
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 2000;
            }
            handler.sendMessageDelayed(obtain, j);
            B1 b1 = this.f40145b.f40400a;
            if (b1 == null || (n1Var = b1.f40010b) == null) {
                return;
            }
            n1Var.b();
        }
    }

    public void setLoadTimeOut(long j) {
        V1.a(this.f40144a, j);
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        this.f40148e = pBSplashListener;
        this.f40145b.f40401b = new g(this);
    }

    public void show(ViewGroup viewGroup) {
        this.r = viewGroup;
        if (!G.g(this.f40144a)) {
            PBSplashListener pBSplashListener = this.f40148e;
            if (pBSplashListener != null) {
                pBSplashListener.onDisplayError(PBError.NO_NETWORK);
            }
        } else if (!isReady()) {
            PBSplashListener pBSplashListener2 = this.f40148e;
            if (pBSplashListener2 != null) {
                pBSplashListener2.onDisplayError(PBError.NO_LOAD);
            }
        } else if (this.f40145b.b().equals("image")) {
            viewGroup.removeAllViews();
            View inflate = LayoutInflater.from(this.f40144a).inflate(R.layout.layout_win_splash, viewGroup);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.splash_iv);
            imageView.setVisibility(0);
            a(inflate);
            imageView.setImageBitmap(this.f40146c);
            this.o = this.l;
            this.f40145b.a(viewGroup, null);
        } else {
            viewGroup.removeAllViews();
            View inflate2 = LayoutInflater.from(this.f40144a).inflate(R.layout.layout_win_splash, viewGroup);
            GifImageView gifImageView = (GifImageView) inflate2.findViewById(R.id.gifImageView);
            gifImageView.setVisibility(0);
            byte[] bArr = this.m;
            if (bArr != null) {
                gifImageView.setBytes(bArr);
                gifImageView.b();
                this.q = this.p;
            }
            a(inflate2);
            this.f40145b.a(viewGroup, null);
        }
    }

    public final void a(View view) {
        B1 b1 = this.f40145b.f40400a;
        long countdown = (b1 == null || !b1.b()) ? 0L : b1.f40011c.getCountdown();
        CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.splash_skip);
        this.f40147d = circleProgressbar;
        circleProgressbar.setOutLineColor(0);
        this.f40147d.setInCircleColor(Color.parseColor(this.f40144a.getString(R.string.win_cyclecolor)));
        this.f40147d.setProgressColor(Color.parseColor(this.f40144a.getString(R.string.win_cyc_process_color)));
        this.f40147d.setProgressLineWidth(this.f40151h);
        this.f40147d.setProgressType(o2.COUNT_BACK);
        CircleProgressbar circleProgressbar2 = this.f40147d;
        if (countdown <= 0) {
            countdown = this.f40150g;
        }
        circleProgressbar2.setTimeMillis(countdown);
        this.f40147d.a();
        this.f40147d.a(1, this.s);
        this.f40149f = false;
        this.f40147d.setOnClickListener(new k(this));
    }
}
