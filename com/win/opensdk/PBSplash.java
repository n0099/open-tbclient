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
import org.json.JSONException;
/* loaded from: classes6.dex */
public class PBSplash implements n {
    public static boolean isdpl = false;

    /* renamed from: a */
    public Context f37729a;

    /* renamed from: b */
    public q f37730b;

    /* renamed from: c */
    public Bitmap f37731c;

    /* renamed from: d */
    public CircleProgressbar f37732d;

    /* renamed from: e */
    public PBSplashListener f37733e;
    public File l;
    public byte[] m;
    public h n;
    public File p;
    public ViewGroup r;

    /* renamed from: f */
    public boolean f37734f = false;

    /* renamed from: g */
    public int f37735g = 5000;

    /* renamed from: h */
    public int f37736h = 6;

    /* renamed from: i */
    public boolean f37737i = false;
    public boolean j = false;
    public boolean k = false;
    public File o = null;
    public File q = null;
    public l s = new l(this);
    public Handler t = new m(this, Looper.getMainLooper());

    public PBSplash(Context context, String str) {
        this.f37729a = context;
        this.f37730b = new q(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j.a(com.win.opensdk.O):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.f37737i = z;
        return z;
    }

    public final void a(String str) {
        try {
            File file = new File(z.a(this.f37729a) + File.separator + "win" + File.separator + z.c(str) + ".gif");
            this.p = file;
            if (file == null || !file.exists()) {
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(true);
                }
                h hVar = new h(this, str);
                this.n = hVar;
                hVar.execute(str);
            } else if (this.f37733e == null || this.j || this.f37733e == null) {
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
                    this.f37733e.onLoaded();
                    this.f37737i = true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void b(String str) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        File file = new File(z.a(this.f37729a) + File.separator + "win" + File.separator + z.c(str) + "." + compressFormat.name().toLowerCase());
        this.l = file;
        if (!file.exists()) {
            Q q = new Q(new j(this, compressFormat));
            if (q.f37742b.contains(str)) {
                return;
            }
            new M(q, str, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else if (this.f37733e == null || this.j) {
        } else {
            File file2 = this.l;
            this.f37731c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
            this.f37733e.onLoaded();
            this.f37737i = true;
        }
    }

    public void destroy() {
        File file;
        try {
            Info info = null;
            if (this.f37731c != null) {
                this.f37731c.recycle();
                this.f37731c = null;
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
            if (this.f37730b != null) {
                Y0 y0 = this.f37730b.f37920a;
                if (y0 != null && y0.b()) {
                    info = y0.f37809c;
                }
                if (info != null) {
                    w0 a2 = x0.a(this.f37729a);
                    try {
                        a2.f37984b = x0.a("ao", new y0(info));
                    } catch (JSONException unused) {
                    }
                    a2.a();
                }
                this.f37730b.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean isReady() {
        q qVar = this.f37730b;
        if (qVar == null || this.f37731c == null) {
            q qVar2 = this.f37730b;
            if (qVar2 == null || this.m == null) {
                return false;
            }
            return qVar2.c();
        }
        return qVar.c();
    }

    public void load() {
        long j;
        K0 k0;
        if (!z.d(this.f37729a)) {
            PBSplashListener pBSplashListener = this.f37733e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_NETWORK);
            }
        } else if (this.f37730b != null) {
            this.f37737i = false;
            this.j = false;
            this.k = false;
            isdpl = false;
            Handler handler = this.t;
            Message obtain = Message.obtain();
            try {
                j = s1.p(this.f37729a) >= s1.d(this.f37729a) ? s1.p(this.f37729a) : s1.d(this.f37729a);
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 2000;
            }
            handler.sendMessageDelayed(obtain, j);
            Y0 y0 = this.f37730b.f37920a;
            if (y0 == null || (k0 = y0.f37808b) == null) {
                return;
            }
            k0.b();
        }
    }

    public void setLoadTimeOut(long j) {
        s1.a(this.f37729a, j);
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        this.f37733e = pBSplashListener;
        this.f37730b.f37921b = new g(this);
    }

    public void show(ViewGroup viewGroup) {
        this.r = viewGroup;
        if (!z.d(this.f37729a)) {
            PBSplashListener pBSplashListener = this.f37733e;
            if (pBSplashListener != null) {
                pBSplashListener.onDisplayError(PBError.NO_NETWORK);
            }
        } else if (!isReady()) {
            PBSplashListener pBSplashListener2 = this.f37733e;
            if (pBSplashListener2 != null) {
                pBSplashListener2.onDisplayError(PBError.NO_LOAD);
            }
        } else if (this.f37730b.b().equals("image")) {
            viewGroup.removeAllViews();
            View inflate = LayoutInflater.from(this.f37729a).inflate(R.layout.win_layout_win_splash, viewGroup);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.win_splash_iv);
            imageView.setVisibility(0);
            a(inflate);
            imageView.setImageBitmap(this.f37731c);
            this.o = this.l;
            this.f37730b.a(viewGroup, null);
        } else {
            viewGroup.removeAllViews();
            View inflate2 = LayoutInflater.from(this.f37729a).inflate(R.layout.win_layout_win_splash, viewGroup);
            GifImageView gifImageView = (GifImageView) inflate2.findViewById(R.id.win_gifImageView);
            gifImageView.setVisibility(0);
            byte[] bArr = this.m;
            if (bArr != null) {
                gifImageView.setBytes(bArr);
                gifImageView.b();
                this.q = this.p;
            }
            a(inflate2);
            this.f37730b.a(viewGroup, null);
        }
    }

    public final void a(View view) {
        Y0 y0 = this.f37730b.f37920a;
        long countdown = (y0 == null || !y0.b()) ? 0L : y0.f37809c.getCountdown();
        CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.win_splash_skip);
        this.f37732d = circleProgressbar;
        circleProgressbar.setOutLineColor(0);
        this.f37732d.setInCircleColor(Color.parseColor(this.f37729a.getString(R.string.win_cyclecolor)));
        this.f37732d.setProgressColor(Color.parseColor(this.f37729a.getString(R.string.win_cyc_process_color)));
        this.f37732d.setProgressLineWidth(this.f37736h);
        this.f37732d.setProgressType(K1.COUNT_BACK);
        CircleProgressbar circleProgressbar2 = this.f37732d;
        if (countdown <= 0) {
            countdown = this.f37735g;
        }
        circleProgressbar2.setTimeMillis(countdown);
        this.f37732d.a();
        this.f37732d.a(1, this.s);
        this.f37734f = false;
        this.f37732d.setOnClickListener(new k(this));
    }
}
