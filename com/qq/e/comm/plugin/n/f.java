package com.qq.e.comm.plugin.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class f extends RelativeLayout implements View.OnClickListener, h {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.d.a f12544a;

    /* renamed from: b  reason: collision with root package name */
    private k f12545b;
    private ImageView c;
    private com.qq.e.comm.plugin.s.e d;
    private a e;
    private CountDownTimer f;
    private boolean g;
    private boolean h;
    private com.qq.e.comm.plugin.y.d i;
    private com.qq.e.comm.plugin.y.c j;
    private String k;
    private int l;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, boolean z);

        void b();

        com.qq.e.comm.plugin.s.a c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, String str, int i, com.qq.e.comm.plugin.s.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        super(context);
        this.k = str;
        this.l = i;
        this.d = eVar;
        this.i = new com.qq.e.comm.plugin.y.d();
        this.j = cVar;
        this.f12544a = new com.qq.e.comm.plugin.ab.d.e(context, null).a();
        this.f12544a.a(new com.qq.e.comm.plugin.ab.d.f() { // from class: com.qq.e.comm.plugin.n.f.1

            /* renamed from: a  reason: collision with root package name */
            long f12546a;

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i2) {
                GDTLogger.d("EndCardView onProgressChanged : " + i2);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i2, String str2, String str3) {
                GDTLogger.d("EndCardView onReceivedError : " + str2);
                if (f.this.g) {
                    return;
                }
                f.this.g = true;
                if (!f.this.h) {
                    if (f.this.f12544a != null) {
                        f.this.f12544a.a(str3);
                    }
                    f.this.h = true;
                }
                if (f.this.f12545b != null) {
                    f.this.f12545b.a();
                }
                com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(f.this.k, "EndCard", f.this.l, System.currentTimeMillis() - this.f12546a, str3, str2, f.this.j);
                if (f.this.k.equals("Interstitial")) {
                    f.this.i.a("wu", str3);
                    u.a(1030019, 0, f.this.j, f.this.i);
                } else if (f.this.k.equals("Reward")) {
                    u.a(1020017, 0, f.this.j, f.this.b(str3));
                }
                if (f.this.l == 2) {
                    u.a(1140004, 0, f.this.j, f.this.b(str3));
                }
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(ValueCallback<Uri> valueCallback, Intent intent) {
                GDTLogger.d("EndCardView openFileChooser");
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str2) {
                GDTLogger.d("EndCardView onPageFinished");
                if (f.this.g) {
                    return;
                }
                com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(f.this.k, "EndCard", f.this.l, System.currentTimeMillis() - this.f12546a, str2, (String) null, f.this.j);
                if (f.this.k.equals("Interstitial")) {
                    f.this.i.a("wu", str2);
                    u.a(1030018, 0, f.this.j, f.this.i);
                } else if (f.this.k.equals("Reward")) {
                    u.a(1020030, f.this.j);
                }
                if (f.this.f12545b != null) {
                    f.this.f12545b.a();
                }
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str2, Bitmap bitmap) {
                GDTLogger.d("EndCardView onPageStarted");
                this.f12546a = System.currentTimeMillis();
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void b(String str2) {
                GDTLogger.d("EndCardView onOverrideUrlLoading");
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
                GDTLogger.d("EndCardView onShowFileChooser");
                return false;
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void c(String str2) {
                GDTLogger.d("EndCardView onReceivedTitle : " + str2);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void d_() {
                GDTLogger.d("EndCardView onLeftApplication");
            }
        });
        addView(this.f12544a.b(), new RelativeLayout.LayoutParams(-1, -1));
        this.c = new ImageView(context);
        this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.c.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        this.c.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(context, 30), ak.a(context, 30));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        layoutParams.topMargin = ak.a(context, 15);
        layoutParams.leftMargin = ak.a(context, 20);
        addView(this.c, layoutParams);
        if (GDTADManager.getInstance().getSM().getInteger("interstitialFullScreenEndcardSoft", 0) == 1) {
            setLayerType(1, null);
        } else {
            this.f12544a.b().setBackgroundColor(0);
        }
        if (this.l == 1) {
            this.f12545b = new k(getContext());
            addView(this.f12545b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.y.d b(String str) {
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        if (str != null) {
            dVar.a("rs", str);
        }
        return dVar;
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a() {
        setVisibility(4);
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a(a aVar) {
        this.e = aVar;
        this.f12544a.c().a("videoService", new e(this.d, this.e));
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.qq.e.comm.plugin.n.f$2] */
    @Override // com.qq.e.comm.plugin.n.h
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.d("EndCardView loadUrl url is null");
        } else if (this.f12544a != null) {
            this.f12544a.a(str);
            if (this.f12545b != null) {
                this.f12545b.setVisibility(0);
                this.f = new CountDownTimer(IMConnection.RETRY_DELAY_TIMES, IMConnection.RETRY_DELAY_TIMES) { // from class: com.qq.e.comm.plugin.n.f.2
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        if (f.this.f12545b != null) {
                            f.this.f12545b.a();
                        }
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                    }
                }.start();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void b() {
        if (this.h && this.g) {
            if (this.e != null) {
                this.e.b();
                return;
            }
            return;
        }
        setVisibility(0);
        if (this.k.equals("Reward")) {
            u.a(1020071, this.j);
        } else if (this.k.equals("Interstitial")) {
            u.a(1030030, this.j);
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void c() {
        if (this.f12544a != null) {
            this.f12544a.a();
        }
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.c || this.e == null) {
            return;
        }
        this.e.b();
    }
}
