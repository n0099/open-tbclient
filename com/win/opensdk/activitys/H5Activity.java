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
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.asm.Label;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.A;
import com.win.opensdk.E1;
import com.win.opensdk.K;
import com.win.opensdk.R;
import com.win.opensdk.U1;
import com.win.opensdk.W1;
import com.win.opensdk.core.Info;
import com.win.opensdk.e1;
import com.win.opensdk.f1;
import com.win.opensdk.o1;
import com.win.opensdk.s;
import com.win.opensdk.s1;
import com.win.opensdk.t;
import com.win.opensdk.views.CloseParentView;
import com.win.opensdk.w0;
import com.win.opensdk.x;
import com.win.opensdk.x0;
import com.win.opensdk.y0;
import com.win.opensdk.z;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5Activity extends Activity implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f37065a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37066b;

    /* renamed from: c  reason: collision with root package name */
    public CloseParentView f37067c;

    /* renamed from: d  reason: collision with root package name */
    public U1 f37068d;

    /* renamed from: e  reason: collision with root package name */
    public Info f37069e;

    /* renamed from: f  reason: collision with root package name */
    public String f37070f;

    /* renamed from: g  reason: collision with root package name */
    public String f37071g;

    /* renamed from: h  reason: collision with root package name */
    public long f37072h = 0;

    /* renamed from: i  reason: collision with root package name */
    public E1 f37073i;

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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0094 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: int */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        if (r1.equals("603") != false) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        View decorView;
        int i2;
        Info info = this.f37069e;
        if (info != null && info.getXn() > 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 > 11 && i3 < 19) {
                decorView = getWindow().getDecorView();
                i2 = 8;
            } else if (Build.VERSION.SDK_INT >= 19) {
                decorView = getWindow().getDecorView();
                i2 = 4102;
            }
            decorView.setSystemUiVisibility(i2);
        }
        Info info2 = this.f37069e;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 <= 25 || i4 >= 28) {
            String str = this.f37070f;
            char c2 = 3;
            int i5 = 1;
            if (!TextUtils.isEmpty(str) && str.length() > 3) {
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
                    i5 = 0;
                } else if (c2 != 1) {
                    if (c2 == 2) {
                        i5 = info2.isVertical();
                    }
                }
                setRequestedOrientation(i5);
            }
            i5 = 2;
            setRequestedOrientation(i5);
        }
        WebView webView = ((K) this.f37068d).f36922c;
        webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f37066b.addView(webView, 0);
        U1 u1 = this.f37068d;
        if (u1 instanceof K) {
            ((K) u1).a(this.f37069e.getLoad(), this.f37069e);
        }
        ((K) this.f37068d).f36921b = new s(this);
        this.f37067c.setCollectVisible(false);
        this.f37067c.setLocation(220);
        this.f37067c.setCountDown(this.f37069e.getCdt());
        this.f37067c.setOnCloseListener(new t(this));
        x0.a(this.f37065a).a(new y0(this.f37069e)).a();
        f1.a(this.f37069e.getId() + this.f37070f, "is_display", null);
        if (this.f37069e != null) {
            s1.a(this.f37065a, this.f37069e.getId() + ":" + System.currentTimeMillis(), false);
        }
        z.a(this.f37069e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f37069e.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.win_layout_activity_h5);
        this.f37065a = getApplicationContext();
        this.f37066b = (ViewGroup) findViewById(R.id.win_parent);
        this.f37067c = (CloseParentView) findViewById(R.id.win_close_parent);
        this.f37072h = 0L;
        this.f37073i = new E1(this);
        f1.a("hcl", this);
        f1.a("onT", this);
        f1.a("onRewardedShowFail", this);
        f1.a("onPlayProgress", this);
        f1.a("onRewardedAdFinish", this);
        f1.a("onRewardedAdStart", this);
        boolean z = false;
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("id");
            this.f37070f = intent.getStringExtra("pid");
            String stringExtra2 = intent.getStringExtra("traceid");
            this.f37069e = x.a().a(W1.a(stringExtra2, stringExtra, this.f37070f));
            U1 a2 = W1.a().a(W1.a(stringExtra2, stringExtra, this.f37070f));
            this.f37068d = a2;
            if (a2 != null) {
                if (this.f37069e != null) {
                    z = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!z) {
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
        w0 a2 = x0.a(this.f37065a);
        try {
            a2.f37229b = x0.a("ao", new y0(this.f37069e));
        } catch (JSONException unused) {
        }
        a2.a();
        U1 u1 = this.f37068d;
        if (u1 != null) {
            K k = (K) u1;
            WebView webView = k.f36922c;
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(k.f36922c);
                }
                k.f36922c.removeAllViews();
                k.f36922c.stopLoading();
                k.f36922c.setWebChromeClient(null);
                k.f36922c.setWebViewClient(null);
                k.f36922c.destroy();
            }
            if (k.f36921b != null) {
                k.f36921b = null;
            }
        }
        CloseParentView closeParentView = this.f37067c;
        if (closeParentView != null) {
            closeParentView.b();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Info info;
        if (keyEvent.getKeyCode() != 4 || (info = this.f37069e) == null || info.getCb() > 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        if (str.equals("hcl")) {
            finish();
            f1.a(this.f37069e.getId() + this.f37070f, "is_dismiss", null);
            f1.a(this.f37069e.getId() + this.f37070f);
            f1.a("hcl");
            f1.a("onT");
            f1.a("onRewardedShowFail");
            f1.a("onPlayProgress");
            f1.a("onRewardedAdFinish");
            f1.a("onRewardedAdStart");
            return;
        }
        try {
            if (str.equals("onRewardedShowFail")) {
                w0 a2 = x0.a(this.f37065a);
                String str3 = (String) obj;
                try {
                    a2.f37229b = x0.a("vvsf", new y0(this.f37069e));
                    a2.a("desc", str3);
                } catch (JSONException unused) {
                }
                a2.a();
                f1.a(this.f37069e.getId() + this.f37070f, "VIDEO_SHOW_FAIL", (String) obj);
            } else if (str.equals("onRewardedAdFinish")) {
                int intValue = ((Integer) obj).intValue();
                if (intValue < 0 || intValue < this.f37069e.getVvt() * 0.9d) {
                    f1.a(this.f37069e.getId() + this.f37070f, "VIDEO_USER_EARNED_REWARD", null);
                } else {
                    w0 a3 = x0.a(this.f37065a);
                    y0 y0Var = new y0(this.f37069e);
                    long vvamount = this.f37069e.getVvamount();
                    try {
                        a3.f37229b = x0.a("vvss", y0Var);
                        a3.a("desc", vvamount);
                    } catch (JSONException unused2) {
                    }
                    a3.a();
                    f1.a(this.f37069e.getId() + this.f37070f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.f37069e.getVvamount()));
                }
                Info info = this.f37069e;
                try {
                    z.a(info, 401, "");
                    if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                        return;
                    }
                    z.g(info.getVv_finish_urls());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (str.equals("onPlayProgress")) {
                w0 a4 = x0.a(this.f37065a);
                y0 y0Var2 = new y0(this.f37069e);
                int intValue2 = ((Integer) obj).intValue();
                try {
                    a4.f37229b = x0.a("vvst", y0Var2);
                    a4.a("desc", intValue2);
                } catch (JSONException unused3) {
                }
                a4.a();
            } else if (str.equals("onRewardedAdStart")) {
                Info info2 = this.f37069e;
                if (info2 != null) {
                    try {
                        if (TextUtils.isEmpty(info2.getVv_start_urls())) {
                            return;
                        }
                        z.a(info2, 400, "");
                        z.g(info2.getVv_start_urls());
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (str.equals("onT") && o1.a(this.f37069e, this.f37072h)) {
                this.f37072h = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.f37071g)) {
                    this.f37071g = "";
                }
                try {
                    a((String) obj, this.f37071g);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        if (this.f37069e != null) {
            f1.a(this.f37069e.getId() + this.f37070f, "is_click", null);
            if (A.f36847d.f36850c && this.f37069e.getOpent() == 1) {
                return;
            }
            o1.a(this.f37065a, str, this.f37069e, this.f37073i, str2);
            x0.a(this.f37065a).a(new y0(this.f37069e), str).a("desc", str2).a();
            z.a(this.f37069e, str2);
        }
    }
}
