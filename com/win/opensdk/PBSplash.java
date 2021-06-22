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
import com.win.opensdk.core.Info;
import com.win.opensdk.image.gif2.GifImageView;
import com.win.opensdk.views.CircleProgressbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class PBSplash implements n {
    public static boolean isdpl = false;

    /* renamed from: a */
    public Context f40685a;

    /* renamed from: b */
    public q f40686b;

    /* renamed from: c */
    public Bitmap f40687c;

    /* renamed from: d */
    public CircleProgressbar f40688d;

    /* renamed from: e */
    public PBSplashListener f40689e;
    public File l;
    public byte[] m;
    public h n;
    public File p;
    public ViewGroup r;
    public View s;

    /* renamed from: f */
    public boolean f40690f = false;

    /* renamed from: g */
    public int f40691g = 5000;

    /* renamed from: h */
    public int f40692h = 6;

    /* renamed from: i */
    public boolean f40693i = false;
    public boolean j = false;
    public boolean k = false;
    public File o = null;
    public File q = null;
    public float t = 0.0f;
    public float u = 0.0f;
    public l v = new l(this);
    public Handler w = new m(this, Looper.getMainLooper());

    public PBSplash(Context context, String str) {
        this.f40685a = context;
        try {
            s1.a(context, 0.0f);
            s1.b(context, 0.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f40686b = new q(context, str);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j.a(com.win.opensdk.O):void] */
    public static /* synthetic */ boolean d(PBSplash pBSplash, boolean z) {
        pBSplash.f40693i = z;
        return z;
    }

    public final void a(String str) {
        try {
            File file = new File(z.a(this.f40685a) + File.separator + "win" + File.separator + z.c(str) + ".gif");
            this.p = file;
            if (file == null || !file.exists()) {
                if (this.n != null && this.n.getStatus() == AsyncTask.Status.RUNNING) {
                    this.n.cancel(true);
                }
                h hVar = new h(this, str);
                this.n = hVar;
                hVar.execute(str);
            } else if (this.f40689e == null || this.j || this.f40689e == null) {
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
                    this.f40689e.onLoaded();
                    this.f40693i = true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void b(String str) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        File file = new File(z.a(this.f40685a) + File.separator + "win" + File.separator + z.c(str) + "." + compressFormat.name().toLowerCase());
        this.l = file;
        if (!file.exists()) {
            Q q = new Q(new j(this, compressFormat));
            if (q.f40698b.contains(str)) {
                return;
            }
            new M(q, str, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else if (this.f40689e == null || this.j) {
        } else {
            File file2 = this.l;
            this.f40687c = (!file2.exists() || file2.isDirectory()) ? null : BitmapFactory.decodeFile(file2.getAbsolutePath());
            this.f40689e.onLoaded();
            this.f40693i = true;
        }
    }

    public void destroy() {
        File file;
        try {
            Info info = null;
            if (this.f40687c != null) {
                this.f40687c.recycle();
                this.f40687c = null;
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
            if (this.f40686b != null) {
                Y0 y0 = this.f40686b.f40876a;
                if (y0 != null && y0.b()) {
                    info = y0.f40765c;
                }
                if (info != null) {
                    w0 a2 = x0.a(this.f40685a);
                    try {
                        a2.f40940b = x0.a("ao", new y0(info));
                    } catch (JSONException unused) {
                    }
                    a2.a();
                }
                this.f40686b.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean isReady() {
        q qVar = this.f40686b;
        if (qVar == null || this.f40687c == null) {
            q qVar2 = this.f40686b;
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
        if (!z.e(this.f40685a)) {
            PBSplashListener pBSplashListener = this.f40689e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_NETWORK);
            }
        } else if (this.f40686b != null) {
            this.f40693i = false;
            this.j = false;
            this.k = false;
            isdpl = false;
            Handler handler = this.w;
            Message obtain = Message.obtain();
            try {
                j = s1.p(this.f40685a) >= s1.d(this.f40685a) ? s1.p(this.f40685a) : s1.d(this.f40685a);
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 2000;
            }
            handler.sendMessageDelayed(obtain, j);
            Y0 y0 = this.f40686b.f40876a;
            if (y0 == null || (k0 = y0.f40764b) == null) {
                return;
            }
            k0.b();
        }
    }

    public void setExpressViewAcceptedSize(float f2, float f3) {
        this.t = f3;
        this.u = f2;
        if (f2 > 0.0f) {
            try {
                float a2 = z.a(this.f40685a, this.u);
                float f4 = this.f40685a.getResources().getDisplayMetrics().widthPixels / 2.0f;
                if (a2 < f4) {
                    a2 = f4;
                }
                s1.b(this.f40685a, a2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (f3 > 0.0f) {
            float a3 = z.a(this.f40685a, this.t);
            float c2 = z.c(this.f40685a) / 2.0f;
            if (a3 < c2) {
                a3 = c2;
            }
            s1.a(this.f40685a, a3);
        }
    }

    public void setLoadTimeOut(long j) {
        s1.a(this.f40685a, j);
    }

    public void setSplashListener(PBSplashListener pBSplashListener) {
        this.f40689e = pBSplashListener;
        this.f40686b.f40877b = new g(this);
    }

    public void show(ViewGroup viewGroup) {
        this.r = viewGroup;
        if (!z.e(this.f40685a)) {
            PBSplashListener pBSplashListener = this.f40689e;
            if (pBSplashListener != null) {
                pBSplashListener.onDisplayError(PBError.NO_NETWORK);
            }
        } else if (!isReady()) {
            PBSplashListener pBSplashListener2 = this.f40689e;
            if (pBSplashListener2 != null) {
                pBSplashListener2.onDisplayError(PBError.NO_LOAD);
            }
        } else if (this.f40686b.b().equals("image")) {
            viewGroup.removeAllViews();
            View inflate = LayoutInflater.from(this.f40685a).inflate(R.layout.win_layout_win_splash, viewGroup);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.win_splash_iv);
            a(inflate);
            imageView.setVisibility(0);
            b(inflate);
            imageView.setImageBitmap(this.f40687c);
            this.o = this.l;
            this.f40686b.a(viewGroup, null);
        } else {
            viewGroup.removeAllViews();
            View inflate2 = LayoutInflater.from(this.f40685a).inflate(R.layout.win_layout_win_splash, viewGroup);
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
            this.f40686b.a(viewGroup, null);
        }
    }

    public void show(ViewGroup viewGroup, View view) {
        this.s = view;
        show(viewGroup);
    }

    public final void a(View view) {
        int i2 = (this.t > 0.0f ? 1 : (this.t == 0.0f ? 0 : -1));
        if (i2 <= 0 || i2 <= 0) {
            return;
        }
        try {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.win_splash_logo);
            relativeLayout.removeAllViews();
            if (this.s != null) {
                relativeLayout.addView(this.s);
            }
            View findViewById = view.findViewById(R.id.win_splash_view);
            float a2 = z.a(this.f40685a, this.t);
            float c2 = z.c(this.f40685a) / 2.0f;
            if (a2 < c2) {
                a2 = c2;
            }
            float a3 = z.a(this.f40685a, this.u);
            float f2 = this.f40685a.getResources().getDisplayMetrics().widthPixels / 2.0f;
            if (a3 < f2) {
                a3 = f2;
            }
            findViewById.setLayoutParams(new LinearLayout.LayoutParams((int) a3, (int) a2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(View view) {
        Y0 y0 = this.f40686b.f40876a;
        long countdown = (y0 == null || !y0.b()) ? 0L : y0.f40765c.getCountdown();
        CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(R.id.win_splash_skip);
        this.f40688d = circleProgressbar;
        circleProgressbar.setOutLineColor(0);
        this.f40688d.setInCircleColor(Color.parseColor(this.f40685a.getString(R.string.win_cyclecolor)));
        this.f40688d.setProgressColor(Color.parseColor(this.f40685a.getString(R.string.win_cyc_process_color)));
        this.f40688d.setProgressLineWidth(this.f40692h);
        this.f40688d.setProgressType(K1.COUNT_BACK);
        CircleProgressbar circleProgressbar2 = this.f40688d;
        if (countdown <= 0) {
            countdown = this.f40691g;
        }
        circleProgressbar2.setTimeMillis(countdown);
        this.f40688d.a();
        this.f40688d.a(1, this.v);
        this.f40690f = false;
        this.f40688d.setOnClickListener(new k(this));
    }
}
