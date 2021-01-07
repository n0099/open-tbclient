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
    private String f14017a;

    /* renamed from: case  reason: not valid java name */
    private String f9case;
    private ViewGroup qdB;
    private CloseParentView qdC;
    private bn qdD;
    private Info qdE;
    private long qdF = 0;
    private bj qdG;
    private Context qdj;

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
        this.qdj = getApplicationContext();
        this.qdB = (ViewGroup) findViewById(d.b.parent);
        this.qdC = (CloseParentView) findViewById(d.b.close_parent);
        this.qdF = 0L;
        this.qdG = new bj(this);
        ar.a("hcl", this);
        ar.a("onT", this);
        ar.a("onRewardedShowFail", this);
        ar.a("onPlayProgress", this);
        ar.a("onRewardedAdFinish", this);
        ar.a("onRewardedAdStart", this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.f9case = intent.getStringExtra("pid");
        String stringExtra2 = intent.getStringExtra("traceid");
        this.qdE = br.eKP().abT(bp.aX(stringExtra2, stringExtra, this.f9case));
        this.qdD = bp.eKO().abS(bp.aX(stringExtra2, stringExtra, this.f9case));
        if (!((this.qdD == null || this.qdE == null) ? false : true)) {
            finish();
        }
        try {
            if (this.qdE != null && this.qdE.getXn() > 0) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(4102);
                }
            }
            Info info = this.qdE;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 25 || i2 >= 28) {
                String str = this.f9case;
                if (ax.abK(str)) {
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
            View eKs = this.qdD.eKs();
            eKs.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.qdB.addView(eKs, 0);
            if (this.qdD instanceof bw) {
                this.qdD.a(this.qdE.getLoad(), this.qdE);
            }
            this.qdD.a(new bo() { // from class: com.win.opensdk.activitys.H5Activity.1
                @Override // com.win.opensdk.bo
                public final boolean hu(String str2, String str3) {
                    if (aw.a(H5Activity.this.qdE, H5Activity.this.qdF)) {
                        H5Activity.this.qdF = System.currentTimeMillis();
                        aw.a(H5Activity.this.qdj, str2, H5Activity.this.qdE, H5Activity.this.qdG);
                        w.iM(H5Activity.this.qdj).a(new x(H5Activity.this.qdE), str2).hv("desc", str3).eKp();
                        ar.f(H5Activity.this.qdE.getId() + H5Activity.this.f9case, "is_click", null);
                        z.a(H5Activity.this.qdE);
                        return true;
                    }
                    return true;
                }

                @Override // com.win.opensdk.bo
                public final void abL(String str2) {
                    H5Activity.this.f14017a = str2;
                }
            });
            this.qdC.setCollectVisible(false);
            this.qdC.setLocation(220);
            this.qdC.setCountDown(this.qdE.getCdt());
            this.qdC.setOnCloseListener(new CloseParentView.b() { // from class: com.win.opensdk.activitys.H5Activity.2
                @Override // com.win.opensdk.views.CloseParentView.b
                public final void eKp() {
                    H5Activity.this.finish();
                }
            });
            w.iM(this.qdj).a(new x(this.qdE)).eKp();
            ar.f(this.qdE.getId() + this.f9case, "is_display", null);
            if (this.qdE != null) {
                az.l(this.qdj, this.qdE.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qdE);
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.qdE.getCb() == 0) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w.iM(this.qdj).c(new x(this.qdE)).eKp();
        if (this.qdD != null) {
            this.qdD.eKp();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.qdE == null || this.qdE.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            ar.f(this.qdE.getId() + this.f9case, "is_dismiss", null);
            ar.abL(this.qdE.getId() + this.f9case);
            ar.abL("hcl");
            ar.abL("onT");
            ar.abL("onRewardedShowFail");
            ar.abL("onPlayProgress");
            ar.abL("onRewardedAdFinish");
            ar.abL("onRewardedAdStart");
        } else if (str.equals("onRewardedShowFail")) {
            try {
                w.iM(this.qdj).i(new x(this.qdE), (String) obj).eKp();
                ar.f(this.qdE.getId() + this.f9case, "VIDEO_SHOW_FAIL", (String) obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals("onRewardedAdFinish")) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0 && intValue >= this.qdE.getVvt() * 0.9d) {
                w.iM(this.qdj).a(new x(this.qdE), this.qdE.getVvamount()).eKp();
                ar.f(this.qdE.getId() + this.f9case, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.qdE.getVvamount()));
            } else {
                ar.f(this.qdE.getId() + this.f9case, "VIDEO_USER_EARNED_REWARD", null);
            }
            Info info = this.qdE;
            try {
                z.a(info, 401);
                if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                    z.abL(info.getVv_finish_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("onPlayProgress")) {
            try {
                w.iM(this.qdj).c(new x(this.qdE), ((Integer) obj).intValue()).eKp();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (str.equals("onRewardedAdStart")) {
            Info info2 = this.qdE;
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                        z.a(info2, 400);
                        z.abL(info2.getVv_start_urls());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (str.equals("onT") && aw.a(this.qdE, this.qdF)) {
            this.qdF = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f14017a)) {
                this.f14017a = "";
            }
            try {
                String str3 = (String) obj;
                String str4 = this.f14017a;
                if (!bu.eKQ().qdm) {
                    aw.a(this.qdj, str3, this.qdE, this.qdG);
                    w.iM(this.qdj).a(new x(this.qdE), str3).hv("desc", str4).eKp();
                    z.a(this.qdE);
                }
                ar.f(this.qdE.getId() + this.f9case, "is_click", null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
