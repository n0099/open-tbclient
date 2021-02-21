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
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
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
    private String f13719a;

    /* renamed from: case  reason: not valid java name */
    private String f8case;
    private ViewGroup qjF;
    private CloseParentView qjG;
    private bn qjH;
    private Info qjI;
    private long qjJ = 0;
    private bj qjK;
    private Context qjn;

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
        this.qjn = getApplicationContext();
        this.qjF = (ViewGroup) findViewById(d.b.parent);
        this.qjG = (CloseParentView) findViewById(d.b.close_parent);
        this.qjJ = 0L;
        this.qjK = new bj(this);
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
        this.qjI = br.eJx().abZ(bp.aX(stringExtra2, stringExtra, this.f8case));
        this.qjH = bp.eJw().abY(bp.aX(stringExtra2, stringExtra, this.f8case));
        if (!((this.qjH == null || this.qjI == null) ? false : true)) {
            finish();
        }
        try {
            if (this.qjI != null && this.qjI.getXn() > 0) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(4102);
                }
            }
            Info info = this.qjI;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 25 || i2 >= 28) {
                String str = this.f8case;
                if (ax.abQ(str)) {
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
            View eJa = this.qjH.eJa();
            eJa.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.qjF.addView(eJa, 0);
            if (this.qjH instanceof bw) {
                this.qjH.a(this.qjI.getLoad(), this.qjI);
            }
            this.qjH.a(new bo() { // from class: com.win.opensdk.activitys.H5Activity.1
                @Override // com.win.opensdk.bo
                public final boolean hC(String str2, String str3) {
                    if (aw.a(H5Activity.this.qjI, H5Activity.this.qjJ)) {
                        H5Activity.this.qjJ = System.currentTimeMillis();
                        aw.a(H5Activity.this.qjn, str2, H5Activity.this.qjI, H5Activity.this.qjK);
                        w.iN(H5Activity.this.qjn).a(new x(H5Activity.this.qjI), str2).hD("desc", str3).eIX();
                        ar.f(H5Activity.this.qjI.getId() + H5Activity.this.f8case, "is_click", null);
                        z.a(H5Activity.this.qjI);
                        return true;
                    }
                    return true;
                }

                @Override // com.win.opensdk.bo
                public final void abR(String str2) {
                    H5Activity.this.f13719a = str2;
                }
            });
            this.qjG.setCollectVisible(false);
            this.qjG.setLocation(VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265);
            this.qjG.setCountDown(this.qjI.getCdt());
            this.qjG.setOnCloseListener(new CloseParentView.b() { // from class: com.win.opensdk.activitys.H5Activity.2
                @Override // com.win.opensdk.views.CloseParentView.b
                public final void eIX() {
                    H5Activity.this.finish();
                }
            });
            w.iN(this.qjn).a(new x(this.qjI)).eIX();
            ar.f(this.qjI.getId() + this.f8case, "is_display", null);
            if (this.qjI != null) {
                az.l(this.qjn, this.qjI.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qjI);
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.qjI.getCb() == 0) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w.iN(this.qjn).c(new x(this.qjI)).eIX();
        if (this.qjH != null) {
            this.qjH.eIX();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.qjI == null || this.qjI.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            ar.f(this.qjI.getId() + this.f8case, "is_dismiss", null);
            ar.abR(this.qjI.getId() + this.f8case);
            ar.abR("hcl");
            ar.abR("onT");
            ar.abR("onRewardedShowFail");
            ar.abR("onPlayProgress");
            ar.abR("onRewardedAdFinish");
            ar.abR("onRewardedAdStart");
        } else if (str.equals("onRewardedShowFail")) {
            try {
                w.iN(this.qjn).i(new x(this.qjI), (String) obj).eIX();
                ar.f(this.qjI.getId() + this.f8case, "VIDEO_SHOW_FAIL", (String) obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals("onRewardedAdFinish")) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0 && intValue >= this.qjI.getVvt() * 0.9d) {
                w.iN(this.qjn).a(new x(this.qjI), this.qjI.getVvamount()).eIX();
                ar.f(this.qjI.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.qjI.getVvamount()));
            } else {
                ar.f(this.qjI.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", null);
            }
            Info info = this.qjI;
            try {
                z.a(info, 401);
                if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                    z.abR(info.getVv_finish_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("onPlayProgress")) {
            try {
                w.iN(this.qjn).c(new x(this.qjI), ((Integer) obj).intValue()).eIX();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (str.equals("onRewardedAdStart")) {
            Info info2 = this.qjI;
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                        z.a(info2, 400);
                        z.abR(info2.getVv_start_urls());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (str.equals("onT") && aw.a(this.qjI, this.qjJ)) {
            this.qjJ = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f13719a)) {
                this.f13719a = "";
            }
            try {
                String str3 = (String) obj;
                String str4 = this.f13719a;
                if (!bu.eJy().qjq) {
                    aw.a(this.qjn, str3, this.qjI, this.qjK);
                    w.iN(this.qjn).a(new x(this.qjI), str3).hD("desc", str4).eIX();
                    z.a(this.qjI);
                }
                ar.f(this.qjI.getId() + this.f8case, "is_click", null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
