package com.qq.e.comm.plugin.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ab.e.e;
import com.qq.e.comm.plugin.ab.e.f;
import com.qq.e.comm.plugin.util.ag;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
public class a implements View.OnClickListener, ACTD, f {
    private static final String h = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final Activity f12324a;

    /* renamed from: b  reason: collision with root package name */
    private HybridADListener f12325b;
    private HybridADSetting c;
    private RelativeLayout d;
    private c e;
    private com.qq.e.comm.plugin.ab.e.a f;
    private ProgressBar g;
    private boolean i;

    public a(Activity activity) {
        this.f12324a = activity;
    }

    private void a() {
        this.d = new RelativeLayout(this.f12324a);
        this.e = new c(this.f12324a, this.c);
        this.e.setId(2131755009);
        this.e.a().setOnClickListener(this);
        this.e.b().setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ak.a((Context) this.f12324a, this.c.getTitleBarHeight()));
        layoutParams.addRule(10, -1);
        this.d.addView(this.e, layoutParams);
        this.f = new e(this.f12324a).a();
        this.f.a(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 2131755009);
        this.d.addView(this.f.c(), layoutParams2);
        this.g = new ProgressBar(this.f12324a);
        this.g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ak.a((Context) this.f12324a, 46), ak.a((Context) this.f12324a, 46));
        layoutParams3.addRule(13, -1);
        this.d.addView(this.g, layoutParams3);
        this.f12324a.setContentView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }

    private void a(final int i) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.o.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f12325b.onError(ag.a(i));
            }
        });
    }

    private void b() {
        if (this.f.a(-1)) {
            this.f.a();
        } else {
            c();
        }
    }

    private void c() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.o.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.f12325b.onClose();
            }
        });
        this.f12324a.finish();
    }

    @Override // com.qq.e.comm.plugin.ab.e.f
    public void a(String str) {
        ai.a("gdt_tag_callback", "onPageFinished(url)");
        ai.b(h, "onPageFinished : url = %s", str);
        if (!this.i) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.o.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f12325b.onLoadFinished();
                }
            });
            u.a(21042, 3, null);
            this.i = true;
        }
        this.g.setVisibility(8);
        if (this.f.a(-1)) {
            this.e.d().setVisibility(0);
            this.e.b().setVisibility(0);
            return;
        }
        this.e.d().setVisibility(4);
        this.e.b().setVisibility(4);
    }

    @Override // com.qq.e.comm.plugin.ab.e.f
    public void a(String str, Bitmap bitmap) {
        ai.a("gdt_tag_callback", "onPageStarted(url, favicon)");
        ai.b(h, "onPageStarted : url = %s", str);
        this.g.setVisibility(0);
    }

    @Override // com.qq.e.comm.plugin.ab.e.f
    public void b(String str) {
        ai.a("gdt_tag_callback", "onReceivedTitle(title)");
        if (this.c == null || TextUtils.isEmpty(this.c.getTitle())) {
            this.e.c().setText(str);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
        ai.a("gdt_tag_callback", "onActivityResult(requestCode, resultCode, data)");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        ai.a("gdt_tag_callback", "onAfterCreate(savedInstanceState)");
        this.f12325b = b.a(this.f12324a.getIntent().getIntExtra("id", 0));
        this.c = (HybridADSetting) this.f12324a.getIntent().getParcelableExtra("setting");
        String stringExtra = this.f12324a.getIntent().getStringExtra("url");
        if (this.f12325b == null || this.c == null || TextUtils.isEmpty(stringExtra)) {
            GDTLogger.e("HybridAD activity fail to create");
            this.f12324a.finish();
            return;
        }
        a();
        switch (this.c.getType()) {
            case 1:
                com.qq.e.comm.plugin.o.a.a aVar = new com.qq.e.comm.plugin.o.a.a();
                this.f.d().a(aVar.a(), aVar);
                this.f.loadUrl(stringExtra);
                u.a(21042, 2, null);
                return;
            default:
                GDTLogger.e("unknow HybridAD type");
                a(4001);
                this.f12324a.finish();
                return;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        ai.a("gdt_tag_callback", "onBackPressed()");
        b();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        ai.a("gdt_tag_callback", "onBeforeCreate(savedInstanceState)");
        this.f12324a.requestWindowFeature(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131755009:
                b();
                u.a(21052, 0, null);
                return;
            case 2131755010:
            default:
                return;
            case 2131755011:
                c();
                u.a(21062, 0, null);
                return;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
        ai.a("gdt_tag_callback", "onConfigurationChanged(newConfig)");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        ai.a("gdt_tag_callback", "onDestroy()");
        if (this.f != null) {
            this.f.b();
        }
        w.a((Object) null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        ai.a("gdt_tag_callback", "onPause()");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        ai.a("gdt_tag_callback", "onResume()");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
        ai.a("gdt_tag_callback", "onStop()");
    }
}
