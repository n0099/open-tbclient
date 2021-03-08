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
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import com.win.opensdk.ab;
import com.win.opensdk.ae;
import com.win.opensdk.bd;
import com.win.opensdk.bf;
import com.win.opensdk.bg;
import com.win.opensdk.bp;
import com.win.opensdk.bx;
import com.win.opensdk.ca;
import com.win.opensdk.cd;
import com.win.opensdk.core.Info;
import com.win.opensdk.cy;
import com.win.opensdk.ef;
import com.win.opensdk.ej;
import com.win.opensdk.fe;
import com.win.opensdk.j;
import com.win.opensdk.q;
import com.win.opensdk.v;
import com.win.opensdk.views.CloseParentView;
import com.win.opensdk.z;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class H5Activity extends Activity implements ab {

    /* renamed from: a  reason: collision with root package name */
    public Context f8105a;
    public ViewGroup b;
    public String f;
    public String g;
    public long h = 0;
    public CloseParentView qlp;
    public fe qlq;
    public Info qlr;
    public cy qls;

    public static void a(Context context, Info info, String str) {
        if (context == null || info == null) {
            return;
        }
        Intent intent = new Intent(context, H5Activity.class);
        intent.putExtra("pid", str);
        intent.putExtra("id", info.getId());
        intent.putExtra("traceid", info.getTraceid());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0048 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0138, code lost:
        if (r6.equals("603") == false) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        char c = 3;
        int i = 1;
        Info info = this.qlr;
        if (info != null && info.getXn() > 0) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                getWindow().getDecorView().setSystemUiVisibility(4102);
            }
        }
        Info info2 = this.qlr;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 25 || i3 >= 28) {
            String str = this.f;
            if (v.g(str)) {
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
                if (c == 0) {
                    i = 0;
                } else if (c != 1) {
                    if (c == 2) {
                        i = info2.isVertical();
                    }
                }
                setRequestedOrientation(i);
            }
            i = 2;
            setRequestedOrientation(i);
        }
        View b = this.qlq.b();
        b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.b.addView(b, 0);
        fe feVar = this.qlq;
        if (feVar instanceof bg) {
            feVar.a(this.qlr.getLoad(), this.qlr);
        }
        this.qlq.a(new ef(this));
        this.qlp.setCollectVisible(false);
        this.qlp.setLocation(VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265);
        this.qlp.setCountDown(this.qlr.getCdt());
        this.qlp.setOnCloseListener(new ej(this));
        ca.iT(this.f8105a).a(new cd(this.qlr)).a();
        ae.a(this.qlr.getId() + this.f, "is_display", null);
        if (this.qlr != null) {
            bp.a(this.f8105a, this.qlr.getId() + ":" + System.currentTimeMillis(), false);
        }
        v.d(this.qlr);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.qlr.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(bd.c.layout_activity_h5);
        this.f8105a = getApplicationContext();
        this.b = (ViewGroup) findViewById(bd.b.parent);
        this.qlp = (CloseParentView) findViewById(bd.b.close_parent);
        this.h = 0L;
        this.qls = new cy(this);
        ae.a("hcl", this);
        ae.a("onT", this);
        ae.a("onRewardedShowFail", this);
        ae.a("onPlayProgress", this);
        ae.a("onRewardedAdFinish", this);
        ae.a("onRewardedAdStart", this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.f = intent.getStringExtra("pid");
        String stringExtra2 = intent.getStringExtra("traceid");
        this.qlr = q.eIY().abW(j.a(stringExtra2, stringExtra, this.f));
        this.qlq = j.eIX().abV(j.a(stringExtra2, stringExtra, this.f));
        if (!((this.qlq == null || this.qlr == null) ? false : true)) {
            finish();
        }
        try {
            a();
        } catch (Exception e) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ca.iT(this.f8105a).b(new cd(this.qlr)).a();
        fe feVar = this.qlq;
        if (feVar != null) {
            feVar.a();
        }
        CloseParentView closeParentView = this.qlp;
        if (closeParentView != null) {
            closeParentView.b();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Info info;
        if (keyEvent.getKeyCode() != 4 || (info = this.qlr) == null || info.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.ab
    public void a(String str, String str2, Object obj) {
        if (!str.equals("hcl")) {
            try {
                if (str.equals("onRewardedShowFail")) {
                    bx iT = ca.iT(this.f8105a);
                    String str3 = (String) obj;
                    try {
                        iT.qlo = ca.a("vvsf", new cd(this.qlr));
                        iT.hD("desc", str3);
                    } catch (JSONException e) {
                    }
                    iT.a();
                    ae.a(this.qlr.getId() + this.f, "VIDEO_SHOW_FAIL", (String) obj);
                    return;
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue >= 0 && intValue >= this.qlr.getVvt() * 0.9d) {
                        bx iT2 = ca.iT(this.f8105a);
                        cd cdVar = new cd(this.qlr);
                        long vvamount = this.qlr.getVvamount();
                        try {
                            iT2.qlo = ca.a("vvss", cdVar);
                            iT2.P("desc", vvamount);
                        } catch (JSONException e2) {
                        }
                        iT2.a();
                        ae.a(this.qlr.getId() + this.f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.qlr.getVvamount()));
                    } else {
                        ae.a(this.qlr.getId() + this.f, "VIDEO_USER_EARNED_REWARD", null);
                    }
                    Info info = this.qlr;
                    try {
                        v.a(info, 401, "");
                        if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                            return;
                        }
                        v.i(info.getVv_finish_urls());
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                } else if (str.equals("onPlayProgress")) {
                    bx iT3 = ca.iT(this.f8105a);
                    cd cdVar2 = new cd(this.qlr);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        iT3.qlo = ca.a("vvst", cdVar2);
                        iT3.P("desc", intValue2);
                    } catch (JSONException e4) {
                    }
                    iT3.a();
                    return;
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.qlr;
                    if (info2 != null) {
                        try {
                            if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                                v.a(info2, 400, "");
                                v.i(info2.getVv_start_urls());
                                return;
                            }
                            return;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return;
                        }
                    }
                    return;
                } else if (!str.equals("onT") || !bf.a(this.qlr, this.h)) {
                    return;
                } else {
                    this.h = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.g)) {
                        this.g = "";
                    }
                    try {
                        a((String) obj, this.g);
                        return;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
            } catch (Exception e7) {
                e7.printStackTrace();
                return;
            }
        }
        finish();
        ae.a(this.qlr.getId() + this.f, "is_dismiss", null);
        ae.a(this.qlr.getId() + this.f);
        ae.a("hcl");
        ae.a("onT");
        ae.a("onRewardedShowFail");
        ae.a("onPlayProgress");
        ae.a("onRewardedAdFinish");
        ae.a("onRewardedAdStart");
    }

    public final void a(String str, String str2) {
        if (!z.qkE.c) {
            bf.a(this.f8105a, str, this.qlr, this.qls, str2);
            ca.iT(this.f8105a).a(new cd(this.qlr), str).hD("desc", str2).a();
            v.a(this.qlr, str2);
        }
        ae.a(this.qlr.getId() + this.f, "is_click", null);
    }
}
