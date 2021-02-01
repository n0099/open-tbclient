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
    private Context qiN;
    private ViewGroup qjf;
    private CloseParentView qjg;
    private bn qjh;
    private Info qji;
    private long qjj = 0;
    private bj qjk;

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
        this.qiN = getApplicationContext();
        this.qjf = (ViewGroup) findViewById(d.b.parent);
        this.qjg = (CloseParentView) findViewById(d.b.close_parent);
        this.qjj = 0L;
        this.qjk = new bj(this);
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
        this.qji = br.eJp().abN(bp.aX(stringExtra2, stringExtra, this.f8case));
        this.qjh = bp.eJo().abM(bp.aX(stringExtra2, stringExtra, this.f8case));
        if (!((this.qjh == null || this.qji == null) ? false : true)) {
            finish();
        }
        try {
            if (this.qji != null && this.qji.getXn() > 0) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(4102);
                }
            }
            Info info = this.qji;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 25 || i2 >= 28) {
                String str = this.f8case;
                if (ax.abE(str)) {
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
            View eIS = this.qjh.eIS();
            eIS.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.qjf.addView(eIS, 0);
            if (this.qjh instanceof bw) {
                this.qjh.a(this.qji.getLoad(), this.qji);
            }
            this.qjh.a(new bo() { // from class: com.win.opensdk.activitys.H5Activity.1
                @Override // com.win.opensdk.bo
                public final boolean hA(String str2, String str3) {
                    if (aw.a(H5Activity.this.qji, H5Activity.this.qjj)) {
                        H5Activity.this.qjj = System.currentTimeMillis();
                        aw.a(H5Activity.this.qiN, str2, H5Activity.this.qji, H5Activity.this.qjk);
                        w.iN(H5Activity.this.qiN).a(new x(H5Activity.this.qji), str2).hB("desc", str3).eIP();
                        ar.f(H5Activity.this.qji.getId() + H5Activity.this.f8case, "is_click", null);
                        z.a(H5Activity.this.qji);
                        return true;
                    }
                    return true;
                }

                @Override // com.win.opensdk.bo
                public final void abF(String str2) {
                    H5Activity.this.f13719a = str2;
                }
            });
            this.qjg.setCollectVisible(false);
            this.qjg.setLocation(VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265);
            this.qjg.setCountDown(this.qji.getCdt());
            this.qjg.setOnCloseListener(new CloseParentView.b() { // from class: com.win.opensdk.activitys.H5Activity.2
                @Override // com.win.opensdk.views.CloseParentView.b
                public final void eIP() {
                    H5Activity.this.finish();
                }
            });
            w.iN(this.qiN).a(new x(this.qji)).eIP();
            ar.f(this.qji.getId() + this.f8case, "is_display", null);
            if (this.qji != null) {
                az.l(this.qiN, this.qji.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qji);
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.qji.getCb() == 0) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w.iN(this.qiN).c(new x(this.qji)).eIP();
        if (this.qjh != null) {
            this.qjh.eIP();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.qji == null || this.qji.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            ar.f(this.qji.getId() + this.f8case, "is_dismiss", null);
            ar.abF(this.qji.getId() + this.f8case);
            ar.abF("hcl");
            ar.abF("onT");
            ar.abF("onRewardedShowFail");
            ar.abF("onPlayProgress");
            ar.abF("onRewardedAdFinish");
            ar.abF("onRewardedAdStart");
        } else if (str.equals("onRewardedShowFail")) {
            try {
                w.iN(this.qiN).i(new x(this.qji), (String) obj).eIP();
                ar.f(this.qji.getId() + this.f8case, "VIDEO_SHOW_FAIL", (String) obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals("onRewardedAdFinish")) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0 && intValue >= this.qji.getVvt() * 0.9d) {
                w.iN(this.qiN).a(new x(this.qji), this.qji.getVvamount()).eIP();
                ar.f(this.qji.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.qji.getVvamount()));
            } else {
                ar.f(this.qji.getId() + this.f8case, "VIDEO_USER_EARNED_REWARD", null);
            }
            Info info = this.qji;
            try {
                z.a(info, 401);
                if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                    z.abF(info.getVv_finish_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("onPlayProgress")) {
            try {
                w.iN(this.qiN).c(new x(this.qji), ((Integer) obj).intValue()).eIP();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (str.equals("onRewardedAdStart")) {
            Info info2 = this.qji;
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                        z.a(info2, 400);
                        z.abF(info2.getVv_start_urls());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (str.equals("onT") && aw.a(this.qji, this.qjj)) {
            this.qjj = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f13719a)) {
                this.f13719a = "";
            }
            try {
                String str3 = (String) obj;
                String str4 = this.f13719a;
                if (!bu.eJq().qiQ) {
                    aw.a(this.qiN, str3, this.qji, this.qjk);
                    w.iN(this.qiN).a(new x(this.qji), str3).hB("desc", str4).eIP();
                    z.a(this.qji);
                }
                ar.f(this.qji.getId() + this.f8case, "is_click", null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
