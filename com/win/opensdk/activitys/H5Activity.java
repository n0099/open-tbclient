package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.win.opensdk.ar;
import com.win.opensdk.aw;
import com.win.opensdk.ax;
import com.win.opensdk.az;
import com.win.opensdk.bj;
import com.win.opensdk.bn;
import com.win.opensdk.bo;
import com.win.opensdk.bp;
import com.win.opensdk.br;
import com.win.opensdk.bu;
import com.win.opensdk.bw;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import com.win.opensdk.views.CloseParentView;
import com.win.opensdk.w;
import com.win.opensdk.x;
import com.win.opensdk.z;
/* loaded from: classes3.dex */
public class H5Activity extends Activity implements ar.a {
    private static final String java = H5Activity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private String f13717a;

    /* renamed from: case  reason: not valid java name */
    private String f8case;
    private Context pYJ;
    private ViewGroup pZb;
    private CloseParentView pZc;
    private bn pZd;
    private Info pZe;
    private long pZf = 0;
    private bj pZg;

    public static void a(Context context, Info info, String str) {
        if (context != null && info != null) {
            Intent intent = new Intent(context, H5Activity.class);
            intent.putExtra("pid", str);
            intent.putExtra("id", info.getId());
            intent.putExtra("traceid", info.getTraceid());
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int i;
        char c;
        super.onCreate(bundle);
        setContentView(d.c.layout_activity_h5);
        this.pYJ = getApplicationContext();
        this.pZb = (ViewGroup) findViewById(d.b.parent);
        this.pZc = (CloseParentView) findViewById(d.b.close_parent);
        this.pZf = 0L;
        this.pZg = new bj(this);
        ar.a("hcl", this);
        ar.a("onT", this);
        ar.a("onRewardedShowFail", this);
        ar.a("onPlayProgress", this);
        ar.a("onRewardedAdFinish", this);
        ar.a("onRewardedAdStart", this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.f8case = intent.getStringExtra("pid");
        String stringExtra2 = intent.getStringExtra("traceid");
        this.pZe = br.eGZ().aaM(bp.aW(stringExtra2, stringExtra, this.f8case));
        this.pZd = bp.eGY().aaL(bp.aW(stringExtra2, stringExtra, this.f8case));
        if (!((this.pZd == null || this.pZe == null) ? false : true)) {
            finish();
        }
        try {
            if (this.pZe != null && this.pZe.getXn() > 0) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(4102);
                }
            }
            Info info = this.pZe;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 25 || i2 >= 28) {
                String str = this.f8case;
                if (ax.aaD(str)) {
                    String substring = str.substring(0, 3);
                    switch (substring.hashCode()) {
                        case 53431:
                            if (substring.equals("601")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53432:
                            if (substring.equals("602")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53433:
                            if (substring.equals("603")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53434:
                            if (substring.equals("604")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53435:
                        case 53436:
                        default:
                            c = 65535;
                            break;
                        case 53437:
                            if (substring.equals("607")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 1;
                            break;
                        case 2:
                            if (!info.isVertical()) {
                                i = 0;
                                break;
                            } else {
                                i = 1;
                                break;
                            }
                        default:
                            i = 2;
                            break;
                    }
                } else {
                    i = 2;
                }
                setRequestedOrientation(i);
            }
            View eGC = this.pZd.eGC();
            eGC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.pZb.addView(eGC, 0);
            if (this.pZd instanceof bw) {
                this.pZd.a(this.pZe.getLoad(), this.pZe);
            }
            this.pZd.a(new bo() { // from class: com.win.opensdk.activitys.H5Activity.1
                @Override // com.win.opensdk.bo
                public final boolean ht(String str2, String str3) {
                    if (aw.a(H5Activity.this.pZe, H5Activity.this.pZf)) {
                        H5Activity.this.pZf = System.currentTimeMillis();
                        aw.a(H5Activity.this.pYJ, str2, H5Activity.this.pZe, H5Activity.this.pZg);
                        w.iK(H5Activity.this.pYJ).a(new x(H5Activity.this.pZe), str2).hu("desc", str3).eGz();
                        ar.f(H5Activity.this.pZe.getId() + H5Activity.this.f8case, "is_click", null);
                        z.a(H5Activity.this.pZe);
                        return true;
                    }
                    return true;
                }

                @Override // com.win.opensdk.bo
                public final void aaE(String str2) {
                    H5Activity.this.f13717a = str2;
                }
            });
            this.pZc.setCollectVisible(false);
            this.pZc.setLocation(220);
            this.pZc.setCountDown(this.pZe.getCdt());
            this.pZc.setOnCloseListener(new CloseParentView.b() { // from class: com.win.opensdk.activitys.H5Activity.2
                @Override // com.win.opensdk.views.CloseParentView.b
                public final void eGz() {
                    H5Activity.this.finish();
                }
            });
            w.iK(this.pYJ).a(new x(this.pZe)).eGz();
            ar.f(this.pZe.getId() + this.f8case, "is_display", null);
            if (this.pZe != null) {
                az.l(this.pYJ, this.pZe.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.pZe);
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.pZe.getCb() == 0) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w.iK(this.pYJ).c(new x(this.pZe)).eGz();
        if (this.pZd != null) {
            this.pZd.eGz();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.pZe == null || this.pZe.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            ar.f(this.pZe.getId() + this.f8case, "is_dismiss", null);
            ar.aaE(this.pZe.getId() + this.f8case);
            ar.aaE("hcl");
            ar.aaE("onT");
            ar.aaE("onRewardedShowFail");
            ar.aaE("onPlayProgress");
            ar.aaE("onRewardedAdFinish");
            ar.aaE("onRewardedAdStart");
        } else if (str.equals("onRewardedShowFail")) {
            try {
                w.iK(this.pYJ).i(new x(this.pZe), (String) obj).eGz();
                ar.f(this.pZe.getId() + this.f8case, "VIDEO_SHOW_FAIL", (String) obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals("onRewardedAdFinish")) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0 && intValue >= this.pZe.getVvt() * 0.9d) {
                w.iK(this.pYJ).a(new x(this.pZe), this.pZe.getVvamount()).eGz();
                ar.f(this.pZe.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.pZe.getVvamount()));
            } else {
                ar.f(this.pZe.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", null);
            }
            Info info = this.pZe;
            try {
                z.a(info, 401);
                if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                    z.aaE(info.getVv_finish_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("onPlayProgress")) {
            try {
                w.iK(this.pYJ).c(new x(this.pZe), ((Integer) obj).intValue()).eGz();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (str.equals("onRewardedAdStart")) {
            Info info2 = this.pZe;
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                        z.a(info2, 400);
                        z.aaE(info2.getVv_start_urls());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (str.equals("onT") && aw.a(this.pZe, this.pZf)) {
            this.pZf = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f13717a)) {
                this.f13717a = "";
            }
            try {
                String str3 = (String) obj;
                String str4 = this.f13717a;
                if (!bu.eHa().pYM) {
                    aw.a(this.pYJ, str3, this.pZe, this.pZg);
                    w.iK(this.pYJ).a(new x(this.pZe), str3).hu("desc", str4).eGz();
                    z.a(this.pZe);
                }
                ar.f(this.pZe.getId() + this.f8case, "is_click", null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
