package com.qq.e.comm.plugin.q;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes4.dex */
public class c implements ACTD, f {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12656a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.d.a f12657b;
    private String c;
    private long d;
    private long e;
    private long f;
    private String g;
    private boolean h;
    private b i;
    private com.qq.e.comm.plugin.ab.b j;
    private String k;
    private boolean l;
    private ValueCallback<Uri[]> m;
    private ValueCallback<Uri> n;
    private com.qq.e.comm.plugin.y.c o;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    public c(Activity activity) {
        this.f12656a = activity;
        this.c = activity.getIntent().getStringExtra("url");
        this.d = activity.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
        String stringExtra = activity.getIntent().getStringExtra("reportUrl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.j = new com.qq.e.comm.plugin.ab.b(stringExtra, this.d);
        }
        this.g = this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        b(i, str, null);
    }

    private void b(int i, String str, String str2) {
        if (GDTADManager.getInstance().getSM().getInteger("lpnaspl", 1) == 1) {
            com.qq.e.comm.plugin.ab.b.a(i, this.d, this.o, str, str2);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i) {
        if (i == 100) {
            this.i.a();
        } else {
            this.i.a(i);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i, String str, String str2) {
        if (this.j != null) {
            this.j.a(str2, com.qq.e.comm.plugin.ab.b.d);
        }
        if (this.s) {
            return;
        }
        this.s = true;
        b(2040004, str2, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return;
        }
        this.n = valueCallback;
        this.f12656a.startActivityForResult(intent, 2);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str) {
        if (this.j != null) {
            this.j.a(str, com.qq.e.comm.plugin.ab.b.c);
        }
        if (this.p) {
            return;
        }
        this.p = true;
        GDTLogger.d("PageFinished url=" + str);
        this.e = System.currentTimeMillis();
        GDTLogger.d("页面加载完成，耗时：" + (this.e - this.f));
        a(2040003, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str, Bitmap bitmap) {
        if (this.j != null) {
            this.j.a(str, com.qq.e.comm.plugin.ab.b.f12003b);
        }
        if (this.r) {
            return;
        }
        this.r = true;
        a(2040002, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void b(String str) {
        this.g = str;
        if (this.q) {
            return;
        }
        this.q = true;
        GDTLogger.d("302 to url:" + str);
        this.f = System.currentTimeMillis();
        GDTLogger.d("点击到302耗时：" + (this.f - this.d));
        a(2040001, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.m = valueCallback;
        this.f12656a.startActivityForResult(intent, 1);
        return true;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void c(String str) {
        if (this.l) {
            return;
        }
        GDTLogger.d("title:" + str);
        if (TextUtils.isEmpty(str)) {
            this.i.a(this.k);
        } else {
            this.i.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void d_() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (1 == i && this.m != null) {
            this.m.onReceiveValue((i2 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.m = null;
        } else if (2 != i || this.n == null) {
        } else {
            this.n.onReceiveValue((i2 != -1 || intent == null) ? null : intent.getData());
            this.n = null;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        JSONObject jSONObject;
        boolean z = true;
        this.f12656a.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.f12656a);
        this.f12656a.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.i = new b(this.f12656a);
        int applyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.f12656a.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, applyDimension);
        layoutParams.gravity = 48;
        this.i.setLayoutParams(layoutParams);
        this.i.setBackgroundColor(-1);
        String stringExtra = this.f12656a.getIntent().getStringExtra(Constants.KEYS.AD_INFO);
        if (stringExtra != null) {
            try {
                jSONObject = new JSONObject(stringExtra);
            } catch (Exception e) {
                GDTLogger.i("Parse adinfo failed:" + e.getMessage());
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            this.k = "";
        } else if (jSONObject.has(DocumentOpenUtil.TXT)) {
            this.k = jSONObject.optString(DocumentOpenUtil.TXT);
        } else {
            this.k = jSONObject.optString("title");
        }
        if (jSONObject != null) {
            if (!jSONObject.has("type") || !"information".equals(jSONObject.optString("type"))) {
                z = false;
            }
            this.l = z;
        } else {
            this.l = false;
        }
        this.o = new com.qq.e.comm.plugin.y.c();
        this.o.a(this.f12656a.getIntent().getStringExtra("posId"));
        if (jSONObject != null) {
            this.o.b(jSONObject.optString(Config.CELL_LOCATION)).c(jSONObject.optString("traceid"));
        }
        this.i.a(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.q.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f12657b.d()) {
                    c.this.f12657b.e();
                    return;
                }
                c.this.f12656a.finish();
                c.this.a(2040005, c.this.g);
            }
        });
        frameLayout.addView(this.i);
        this.f12657b = new e(this.f12656a, jSONObject).a();
        this.f12657b.a(this);
        this.f12657b.a(this.c);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = applyDimension;
        this.f12657b.b().setLayoutParams(layoutParams2);
        frameLayout.addView(this.f12657b.b());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        if (this.j != null) {
            this.j.a(this.g, com.qq.e.comm.plugin.ab.b.e);
        }
        if (SDKStatus.getSDKVersionCode() >= 9) {
            this.f12656a.finish();
            a(2040005, this.g);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f12656a.requestWindowFeature(1);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.j != null) {
            this.j.a(this.g, com.qq.e.comm.plugin.ab.b.g);
        }
        if (this.f12657b != null) {
            this.f12657b.a();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        if (this.j != null) {
            this.j.a(this.g, com.qq.e.comm.plugin.ab.b.f);
        }
        try {
            if (this.f12657b.b() != null) {
                this.f12657b.b().getClass().getMethod(MissionEvent.MESSAGE_PAUSE, new Class[0]).invoke(this.f12657b.b(), null);
                this.h = true;
            }
        } catch (Exception e) {
            GDTLogger.e("InnerBrowser onPause err" + e);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        try {
            if (this.h) {
                if (this.f12657b.b() != null) {
                    this.f12657b.b().getClass().getMethod(MissionEvent.MESSAGE_RESUME, new Class[0]).invoke(this.f12657b.b(), null);
                }
                this.h = false;
            }
        } catch (Exception e) {
            GDTLogger.e("InnerBrowser onResume err");
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
