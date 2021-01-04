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
/* loaded from: classes4.dex */
public class H5Activity extends Activity implements ar.a {
    private static final String java = H5Activity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private String f14016a;

    /* renamed from: case  reason: not valid java name */
    private String f8case;
    private Context qbB;
    private ViewGroup qbT;
    private CloseParentView qbU;
    private bn qbV;
    private Info qbW;
    private long qbX = 0;
    private bj qbY;

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
        this.qbB = getApplicationContext();
        this.qbT = (ViewGroup) findViewById(d.b.parent);
        this.qbU = (CloseParentView) findViewById(d.b.close_parent);
        this.qbX = 0L;
        this.qbY = new bj(this);
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
        this.qbW = br.eKl().abS(bp.aX(stringExtra2, stringExtra, this.f8case));
        this.qbV = bp.eKk().abR(bp.aX(stringExtra2, stringExtra, this.f8case));
        if (!((this.qbV == null || this.qbW == null) ? false : true)) {
            finish();
        }
        try {
            if (this.qbW != null && this.qbW.getXn() > 0) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(4102);
                }
            }
            Info info = this.qbW;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 25 || i2 >= 28) {
                String str = this.f8case;
                if (ax.abJ(str)) {
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
            View eJO = this.qbV.eJO();
            eJO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.qbT.addView(eJO, 0);
            if (this.qbV instanceof bw) {
                this.qbV.a(this.qbW.getLoad(), this.qbW);
            }
            this.qbV.a(new bo() { // from class: com.win.opensdk.activitys.H5Activity.1
                @Override // com.win.opensdk.bo
                public final boolean ht(String str2, String str3) {
                    if (aw.a(H5Activity.this.qbW, H5Activity.this.qbX)) {
                        H5Activity.this.qbX = System.currentTimeMillis();
                        aw.a(H5Activity.this.qbB, str2, H5Activity.this.qbW, H5Activity.this.qbY);
                        w.iM(H5Activity.this.qbB).a(new x(H5Activity.this.qbW), str2).hu("desc", str3).eJL();
                        ar.f(H5Activity.this.qbW.getId() + H5Activity.this.f8case, "is_click", null);
                        z.a(H5Activity.this.qbW);
                        return true;
                    }
                    return true;
                }

                @Override // com.win.opensdk.bo
                public final void abK(String str2) {
                    H5Activity.this.f14016a = str2;
                }
            });
            this.qbU.setCollectVisible(false);
            this.qbU.setLocation(220);
            this.qbU.setCountDown(this.qbW.getCdt());
            this.qbU.setOnCloseListener(new CloseParentView.b() { // from class: com.win.opensdk.activitys.H5Activity.2
                @Override // com.win.opensdk.views.CloseParentView.b
                public final void eJL() {
                    H5Activity.this.finish();
                }
            });
            w.iM(this.qbB).a(new x(this.qbW)).eJL();
            ar.f(this.qbW.getId() + this.f8case, "is_display", null);
            if (this.qbW != null) {
                az.l(this.qbB, this.qbW.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qbW);
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.qbW.getCb() == 0) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w.iM(this.qbB).c(new x(this.qbW)).eJL();
        if (this.qbV != null) {
            this.qbV.eJL();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.qbW == null || this.qbW.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            ar.f(this.qbW.getId() + this.f8case, "is_dismiss", null);
            ar.abK(this.qbW.getId() + this.f8case);
            ar.abK("hcl");
            ar.abK("onT");
            ar.abK("onRewardedShowFail");
            ar.abK("onPlayProgress");
            ar.abK("onRewardedAdFinish");
            ar.abK("onRewardedAdStart");
        } else if (str.equals("onRewardedShowFail")) {
            try {
                w.iM(this.qbB).i(new x(this.qbW), (String) obj).eJL();
                ar.f(this.qbW.getId() + this.f8case, "VIDEO_SHOW_FAIL", (String) obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals("onRewardedAdFinish")) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0 && intValue >= this.qbW.getVvt() * 0.9d) {
                w.iM(this.qbB).a(new x(this.qbW), this.qbW.getVvamount()).eJL();
                ar.f(this.qbW.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.qbW.getVvamount()));
            } else {
                ar.f(this.qbW.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", null);
            }
            Info info = this.qbW;
            try {
                z.a(info, 401);
                if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                    z.abK(info.getVv_finish_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("onPlayProgress")) {
            try {
                w.iM(this.qbB).c(new x(this.qbW), ((Integer) obj).intValue()).eJL();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (str.equals("onRewardedAdStart")) {
            Info info2 = this.qbW;
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                        z.a(info2, 400);
                        z.abK(info2.getVv_start_urls());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (str.equals("onT") && aw.a(this.qbW, this.qbX)) {
            this.qbX = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f14016a)) {
                this.f14016a = "";
            }
            try {
                String str3 = (String) obj;
                String str4 = this.f14016a;
                if (!bu.eKm().qbE) {
                    aw.a(this.qbB, str3, this.qbW, this.qbY);
                    w.iM(this.qbB).a(new x(this.qbW), str3).hu("desc", str4).eJL();
                    z.a(this.qbW);
                }
                ar.f(this.qbW.getId() + this.f8case, "is_click", null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
