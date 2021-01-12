package com.qq.e.comm.plugin.v;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.kwai.video.player.PlayerPostEvent;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.m.m;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class d implements ACTD, m {

    /* renamed from: a  reason: collision with root package name */
    private f f12612a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f12613b;
    private i c;
    private e d;
    private View e;
    private FrameLayout f;
    private com.qq.e.comm.plugin.n.h g;
    private volatile boolean h;
    private volatile boolean i;
    private int j;
    private int k;
    private int l;
    private com.qq.e.comm.plugin.y.c m = new com.qq.e.comm.plugin.y.c();

    public d(Activity activity) {
        this.f12613b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.h) {
            return;
        }
        this.e = this.c.getAdView();
        this.c.a(this);
        if (this.e != null) {
            bc.a(this.e);
            this.f.addView(this.e);
        }
    }

    private boolean a(Object obj, String str) {
        if (obj == null) {
            GDTLogger.e("RewardPage activity fail to create ! miss " + str);
            this.f12613b.finish();
            return true;
        }
        return false;
    }

    private void b() {
        com.qq.e.comm.plugin.ad.g e = this.c.e();
        e.a(System.currentTimeMillis());
        e.a(1);
        this.g = com.qq.e.comm.plugin.n.d.a(this.f12613b, this.d, e, "Reward", n.a(this.d, this.d.k_()), this.m);
        this.g.a(new f.a() { // from class: com.qq.e.comm.plugin.v.d.2
            @Override // com.qq.e.comm.plugin.n.f.a
            public void a(String str, boolean z) {
                d.this.c.a(str, z, d.this.f);
            }

            @Override // com.qq.e.comm.plugin.n.f.a
            public void b() {
                d.this.f12612a.b();
                if (d.this.f12613b.isFinishing()) {
                    return;
                }
                d.this.f12613b.finish();
            }

            @Override // com.qq.e.comm.plugin.n.f.a
            public com.qq.e.comm.plugin.s.a c() {
                return d.this.d;
            }
        });
        if (this.d.k_()) {
            c();
        }
        this.g.a();
        this.g.a(this.f);
    }

    private void c() {
        this.i = true;
        this.g.a(this.d.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h = true;
        if (!this.d.k_()) {
            c();
        }
        bc.a(this.e);
        this.g.b();
    }

    @Override // com.qq.e.comm.plugin.m.m
    public void a(int i) {
        if (this.j == 1 && !this.i && n.a(i, this.l, this.d.g(), this.k)) {
            c();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        this.f12612a = a.a(this.f12613b.getIntent().getIntExtra("objectId", 0));
        if (a(this.f12612a, "mAdImpl")) {
            return;
        }
        this.c = this.f12612a.d();
        if (a(this.c, "mDataController")) {
            return;
        }
        this.d = this.c.n();
        if (a(this.d, "mAdData")) {
            return;
        }
        this.f = new FrameLayout(this.f12613b);
        this.f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f12613b.setContentView(this.f, new FrameLayout.LayoutParams(-1, -1));
        this.f12612a.a(this.f);
        this.f12612a.a(new ADListener() { // from class: com.qq.e.comm.plugin.v.d.1
            @Override // com.qq.e.comm.adevent.ADListener
            public void onADEvent(ADEvent aDEvent) {
                switch (aDEvent.getType()) {
                    case 103:
                        d.this.a();
                        return;
                    case 104:
                    case 206:
                    case 207:
                    case PlayerPostEvent.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        d.this.d();
                        return;
                    case 105:
                        if (d.this.f12613b.isFinishing()) {
                            return;
                        }
                        d.this.f12613b.finish();
                        return;
                    default:
                        return;
                }
            }
        });
        this.j = n.a(this.d, this.d.k_());
        if (this.j == 1) {
            this.k = n.a(GDTADManager.getInstance().getSM());
            this.l = n.a(this.d.B());
        }
        a();
        b();
        if (this.c.b() || this.f12612a.c()) {
            d();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        if (this.h) {
            this.f12613b.finish();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f12613b.requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12613b.getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Window window = this.f12613b.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E6000000")));
        window.setFlags(1024, 1024);
        window.setFlags(16777216, 16777216);
        window.setFlags(128, 128);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.c != null) {
            this.c.a((m) null);
            this.c.destroy();
        }
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
