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
import androidx.fragment.app.FragmentManagerImpl;
import com.alibaba.fastjson.asm.Label;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.B2;
import com.win.opensdk.E;
import com.win.opensdk.G;
import com.win.opensdk.H;
import com.win.opensdk.H1;
import com.win.opensdk.I1;
import com.win.opensdk.R;
import com.win.opensdk.R1;
import com.win.opensdk.S;
import com.win.opensdk.V1;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.b1;
import com.win.opensdk.core.Info;
import com.win.opensdk.h2;
import com.win.opensdk.s;
import com.win.opensdk.t;
import com.win.opensdk.views.CloseParentView;
import com.win.opensdk.z2;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5Activity extends Activity implements H1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40251a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40252b;

    /* renamed from: c  reason: collision with root package name */
    public CloseParentView f40253c;

    /* renamed from: d  reason: collision with root package name */
    public z2 f40254d;

    /* renamed from: e  reason: collision with root package name */
    public Info f40255e;

    /* renamed from: f  reason: collision with root package name */
    public String f40256f;

    /* renamed from: g  reason: collision with root package name */
    public String f40257g;

    /* renamed from: h  reason: collision with root package name */
    public long f40258h = 0;
    public h2 i;

    public static void a(Context context, Info info, String str) {
        if (context == null || info == null) {
            return;
        }
        Intent intent = new Intent(context, H5Activity.class);
        intent.putExtra("pid", str);
        intent.putExtra("id", info.getId());
        intent.putExtra("traceid", info.getTraceid());
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0089 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: int */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r1.equals("603") != false) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        View decorView;
        int i;
        Info info = this.f40255e;
        if (info != null && info.getXn() > 0) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                decorView = getWindow().getDecorView();
                i = 8;
            } else if (Build.VERSION.SDK_INT >= 19) {
                decorView = getWindow().getDecorView();
                i = 4102;
            }
            decorView.setSystemUiVisibility(i);
        }
        Info info2 = this.f40255e;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 25 || i3 >= 28) {
            String str = this.f40256f;
            int i4 = 1;
            if (G.g(str)) {
                char c2 = 3;
                String substring = str.substring(0, 3);
                switch (substring.hashCode()) {
                    case 53431:
                        if (substring.equals("601")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 53432:
                        if (substring.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 53433:
                        break;
                    case 53434:
                        if (substring.equals("604")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 53435:
                    case 53436:
                    default:
                        c2 = 65535;
                        break;
                    case 53437:
                        if (substring.equals("607")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    i4 = 0;
                } else if (c2 != 1) {
                    if (c2 == 2) {
                        i4 = info2.isVertical();
                    }
                }
                setRequestedOrientation(i4);
            }
            i4 = 2;
            setRequestedOrientation(i4);
        }
        View b2 = this.f40254d.b();
        b2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f40252b.addView(b2, 0);
        z2 z2Var = this.f40254d;
        if (z2Var instanceof S) {
            z2Var.a(this.f40255e.getLoad(), this.f40255e);
        }
        this.f40254d.a(new s(this));
        this.f40253c.setCollectVisible(false);
        this.f40253c.setLocation(FragmentManagerImpl.ANIM_DUR);
        this.f40253c.setCountDown(this.f40255e.getCdt());
        this.f40253c.setOnCloseListener(new t(this));
        a1.a(this.f40251a).b(new b1(this.f40255e)).a();
        I1.a(this.f40255e.getId() + this.f40256f, "is_display", null);
        if (this.f40255e != null) {
            V1.a(this.f40251a, this.f40255e.getId() + ":" + System.currentTimeMillis(), false);
        }
        G.a(this.f40255e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f40255e.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_h5);
        this.f40251a = getApplicationContext();
        this.f40252b = (ViewGroup) findViewById(R.id.parent);
        this.f40253c = (CloseParentView) findViewById(R.id.close_parent);
        this.f40258h = 0L;
        this.i = new h2(this);
        I1.a("hcl", this);
        I1.a("onT", this);
        I1.a("onRewardedShowFail", this);
        I1.a("onPlayProgress", this);
        I1.a("onRewardedAdFinish", this);
        I1.a("onRewardedAdStart", this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.f40256f = intent.getStringExtra("pid");
        String stringExtra2 = intent.getStringExtra("traceid");
        this.f40255e = E.a().a(B2.a(stringExtra2, stringExtra, this.f40256f));
        z2 a2 = B2.a().a(B2.a(stringExtra2, stringExtra, this.f40256f));
        this.f40254d = a2;
        if (!((a2 == null || this.f40255e == null) ? false : true)) {
            finish();
        }
        try {
            a();
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a1.a(this.f40251a).a(new b1(this.f40255e)).a();
        z2 z2Var = this.f40254d;
        if (z2Var != null) {
            z2Var.a();
        }
        CloseParentView closeParentView = this.f40253c;
        if (closeParentView != null) {
            closeParentView.b();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Info info;
        if (keyEvent.getKeyCode() != 4 || (info = this.f40255e) == null || info.getCb() > 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            I1.a(this.f40255e.getId() + this.f40256f, "is_dismiss", null);
            I1.a(this.f40255e.getId() + this.f40256f);
            I1.a("hcl");
            I1.a("onT");
            I1.a("onRewardedShowFail");
            I1.a("onPlayProgress");
            I1.a("onRewardedAdFinish");
            I1.a("onRewardedAdStart");
            return;
        }
        try {
            if (str.equals("onRewardedShowFail")) {
                Z0 a2 = a1.a(this.f40251a);
                String str3 = (String) obj;
                try {
                    a2.f40234b = a1.a("vvsf", new b1(this.f40255e));
                    a2.a("desc", str3);
                } catch (JSONException unused) {
                }
                a2.a();
                I1.a(this.f40255e.getId() + this.f40256f, "VIDEO_SHOW_FAIL", (String) obj);
            } else if (str.equals("onRewardedAdFinish")) {
                int intValue = ((Integer) obj).intValue();
                if (intValue < 0 || intValue < this.f40255e.getVvt() * 0.9d) {
                    I1.a(this.f40255e.getId() + this.f40256f, "VIDEO_USER_EARNED_REWARD", null);
                } else {
                    Z0 a3 = a1.a(this.f40251a);
                    b1 b1Var = new b1(this.f40255e);
                    long vvamount = this.f40255e.getVvamount();
                    try {
                        a3.f40234b = a1.a("vvss", b1Var);
                        a3.a("desc", vvamount);
                    } catch (JSONException unused2) {
                    }
                    a3.a();
                    I1.a(this.f40255e.getId() + this.f40256f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.f40255e.getVvamount()));
                }
                Info info = this.f40255e;
                try {
                    G.a(info, 401, "");
                    if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                        return;
                    }
                    G.i(info.getVv_finish_urls());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (str.equals("onPlayProgress")) {
                Z0 a4 = a1.a(this.f40251a);
                b1 b1Var2 = new b1(this.f40255e);
                int intValue2 = ((Integer) obj).intValue();
                try {
                    a4.f40234b = a1.a("vvst", b1Var2);
                    a4.a("desc", intValue2);
                } catch (JSONException unused3) {
                }
                a4.a();
            } else if (str.equals("onRewardedAdStart")) {
                Info info2 = this.f40255e;
                if (info2 != null) {
                    try {
                        if (TextUtils.isEmpty(info2.getVv_start_urls())) {
                            return;
                        }
                        G.a(info2, 400, "");
                        G.i(info2.getVv_start_urls());
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (str.equals("onT") && R1.a(this.f40255e, this.f40258h)) {
                this.f40258h = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.f40257g)) {
                    this.f40257g = "";
                }
                try {
                    a((String) obj, this.f40257g);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        if (!H.f40058d.f40061c) {
            R1.a(this.f40251a, str, this.f40255e, this.i, str2);
            a1.a(this.f40251a).a(new b1(this.f40255e), str).a("desc", str2).a();
            G.a(this.f40255e, str2);
        }
        I1.a(this.f40255e.getId() + this.f40256f, "is_click", null);
    }
}
