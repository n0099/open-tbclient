package d.a.l0.a.h0.g;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.k.n;
import d.a.l0.k.o;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.l0.a.h0.g.d {
    public int A0;
    public String B0;
    public String x0;
    public ForbiddenInfo y0;
    public int z0;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = e.this.f0;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f45728e;

        public b(d.a.l0.a.f1.e.b bVar) {
            this.f45728e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            String str = e.this.B0;
            if (((str.hashCode() == 49 && str.equals("1")) ? (char) 0 : (char) 65535) == 0 && (activity = e.this.f0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.f45728e, null);
                e.this.f0.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45730e;

        public c(String str) {
            this.f45730e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.y0 == null || TextUtils.isEmpty(e.this.y0.forbiddenDetail)) {
                return;
            }
            d.a.l0.a.c1.a.t().b(e.this.h(), this.f45730e, e.this.y0.appTitle, e.this.y0.forbiddenDetail);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.l0.k.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45732e;

        public d(Activity activity) {
            this.f45732e = activity;
        }

        @Override // d.a.l0.k.e
        public boolean b(View view, o oVar) {
            int c2 = oVar.c();
            if (c2 == 5) {
                e.this.V2(this.f45732e);
            } else if (c2 == 9) {
                e.this.S2(this.f45732e);
                return true;
            } else if (c2 == 39) {
                e.this.W2(this.f45732e);
            } else if (c2 == 46) {
                e.this.T2(oVar, this.f45732e);
            } else if (c2 == 47) {
                e.this.U2(oVar, this.f45732e);
            }
            return true;
        }
    }

    /* renamed from: d.a.l0.a.h0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0716e {

        /* renamed from: d.a.l0.a.h0.g.e$e$a */
        /* loaded from: classes2.dex */
        public static class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.j2.p.e f45734e;

            public a(d.a.l0.a.j2.p.e eVar) {
                this.f45734e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.j2.b.i("934", "85", this.f45734e.f());
            }
        }

        public static void a(String str, d.a.l0.a.f1.e.b bVar, ForbiddenInfo forbiddenInfo) {
            d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
            eVar.f46866f = forbiddenInfo.appId;
            eVar.f46867g = "errormenu";
            eVar.f46862b = PrefetchEvent.STATE_CLICK;
            eVar.f46865e = str;
            eVar.f46863c = forbiddenInfo.launchSource;
            eVar.b(d.a.l0.a.j2.k.k(bVar.W()));
            eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            q.i(new a(eVar), "SwanAppFuncClickUBC");
        }
    }

    public static e R2(String str, ForbiddenInfo forbiddenInfo, int i2, int i3) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
        bundle.putParcelable("key_forbidden_info", forbiddenInfo);
        bundle.putInt("key_show_menu_notice", i2);
        bundle.putInt("key_show_menu_privacy", i3);
        eVar.j1(bundle);
        return eVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.l0.a.g.aiapps_error_fragment, viewGroup, false);
        P2(inflate);
        Q1(inflate);
        return P1() ? S1(inflate) : inflate;
    }

    public final boolean J2() {
        ForbiddenInfo forbiddenInfo = this.y0;
        if (forbiddenInfo == null) {
            return false;
        }
        return forbiddenInfo.b();
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        return false;
    }

    public final CharSequence K2(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> c2 = d.a.l0.n.j.i.i.b().c();
        ForbiddenInfo forbiddenInfo = this.y0;
        if (forbiddenInfo != null) {
            String str2 = forbiddenInfo.forbiddenDetail;
            if (str2.length() > 4) {
                String substring = str2.substring(str2.length() - 4);
                String str3 = c2.get(substring + "_btn_text");
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
            }
        }
        char c3 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1242268664) {
            if (hashCode != 38398066) {
                if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                    c3 = 1;
                }
            } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                c3 = 0;
            }
        } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
            c3 = 2;
        }
        if (c3 == 0) {
            String str4 = c2.get("net_conn_failed_btn_text");
            return TextUtils.isEmpty(str4) ? T(d.a.l0.a.h.aiapps_magicbox_on_empty_reload) : str4;
        } else if (c3 == 1) {
            String str5 = c2.get("app_open_failed_btn_text");
            return TextUtils.isEmpty(str5) ? T(d.a.l0.a.h.aiapps_magicbox_on_empty_reload) : str5;
        } else if (c3 != 2) {
            return "";
        } else {
            String str6 = c2.get("app_need_upgrade_btn_text");
            return TextUtils.isEmpty(str6) ? T(d.a.l0.a.h.aiapps_magicbox_on_empty_reload) : str6;
        }
    }

    public final JSONObject L2(Activity activity) {
        if (activity instanceof SwanAppErrorActivity) {
            ForbiddenInfo forbiddenInfo = ((SwanAppErrorActivity) activity).getForbiddenInfo();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", forbiddenInfo.appTitle);
                jSONObject.put("url", forbiddenInfo.launchPath);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, forbiddenInfo.appId);
                jSONObject.put("errorPath", forbiddenInfo.launchPath);
                jSONObject.put("errorDes", forbiddenInfo.forbiddenReason);
            } catch (JSONException e2) {
                if (d.a.l0.a.h0.g.d.w0) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return null;
    }

    public final d.a.l0.a.f1.e.b M2() {
        if (h() == null || !(h() instanceof SwanAppErrorActivity)) {
            return null;
        }
        return ((SwanAppErrorActivity) h()).getLaunchInfo();
    }

    public final String N2(String str, String str2) {
        String str3 = "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1242268664) {
                if (hashCode != 38398066) {
                    if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 1;
                    }
                } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                    c2 = 0;
                }
            } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                c2 = 2;
            }
            if (c2 == 0) {
                str3 = q().getString(d.a.l0.a.h.swanapp_tip_net_unavailable);
            } else if (c2 == 1) {
                str3 = q().getString(d.a.l0.a.h.swanapp_normal_error);
            } else if (c2 == 2) {
                str3 = q().getString(d.a.l0.a.h.swanapp_normal_error);
            }
            Map<String, String> c3 = d.a.l0.n.j.i.i.b().c();
            if (c3 != null) {
                ForbiddenInfo forbiddenInfo = this.y0;
                if (forbiddenInfo != null) {
                    String str4 = forbiddenInfo.forbiddenDetail;
                    if (str4.length() > 4) {
                        String substring = str4.substring(str4.length() - 4);
                        String str5 = c3.get(substring + "_tips");
                        if (!TextUtils.isEmpty(str5)) {
                            return str5;
                        }
                    }
                }
                String str6 = c3.get(str2 + "_tips");
                if (!TextUtils.isEmpty(str6)) {
                    return str6;
                }
            }
        }
        return str3;
    }

    public void O2() {
        FragmentActivity h2 = h();
        if (h2 == null || this.j0 != null) {
            return;
        }
        n nVar = new n(h2, this.i0, 19, d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
        this.j0 = nVar;
        nVar.l(new d(h2));
        b3();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P2(View view) {
        String str;
        d.a.l0.a.f1.e.b launchInfo;
        String D;
        ForbiddenInfo forbiddenInfo;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(d.a.l0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(d.a.l0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(d.a.l0.a.f.ai_apps_error_text_one);
        TextView textView3 = (TextView) view.findViewById(d.a.l0.a.f.ai_apps_error_feedback);
        String str2 = this.x0;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1869797338:
                    if (str2.equals(SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str2.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str2.equals(SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 731215244:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                d.a.l0.a.j2.k.t(this.y0, "offline");
                str = a3();
            } else if (c2 == 1) {
                d.a.l0.a.j2.k.t(this.y0, "pageblock");
                str = TextUtils.isEmpty(this.y0.forbiddenInformation) ? q().getString(d.a.l0.a.h.swanapp_path_forbidden) : this.y0.forbiddenInformation;
            } else if (c2 == 2) {
                d.a.l0.a.j2.k.t(this.y0, "neterror");
                String N2 = N2(this.x0, "net_conn_failed");
                imageView.setImageDrawable(q().getResources().getDrawable(d.a.l0.a.e.aiapps_empty_icon_network));
                if (Q2(this.x0)) {
                    textView.setVisibility(0);
                    textView.setText(K2(this.x0));
                } else {
                    textView.setVisibility(8);
                }
                textView2.setVisibility(8);
                str = N2;
            } else if (c2 == 3) {
                d.a.l0.a.j2.k.t(this.y0, "commonerror");
                str = N2(this.x0, "app_open_failed");
                if (Q2(this.x0)) {
                    textView.setVisibility(0);
                    textView.setText(K2(this.x0));
                } else {
                    textView.setVisibility(8);
                }
            } else if (c2 == 4) {
                d.a.l0.a.j2.k.t(this.y0, IMTrack.DbBuilder.ACTION_UPDATE);
                str = N2(this.x0, "app_need_upgrade");
                if (Q2(this.x0)) {
                    textView.setVisibility(0);
                    textView.setText(K2(this.x0));
                } else {
                    textView.setVisibility(8);
                }
            } else if (c2 == 5) {
                str = q().getString(d.a.l0.a.h.aiapps_game_loadv8_so_failed);
                textView.setVisibility(8);
            }
            TextView textView4 = (TextView) view.findViewById(d.a.l0.a.f.ai_apps_error_msg);
            if (str == null) {
                str = q().getString(d.a.l0.a.h.swanapp_normal_error);
            }
            textView4.setText(str);
            Activity activity = this.f0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (launchInfo == null) {
                D = launchInfo.H();
            } else {
                D = Q != null ? Q.D() : null;
            }
            forbiddenInfo = this.y0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView2.setText("(" + this.y0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView2.setTextColor(z().getColor(d.a.l0.a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new b(launchInfo));
            if (q0.G() || TextUtils.equals(this.x0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
            }
            textView3.setVisibility(0);
            textView3.setOnClickListener(new c(D));
            return;
        }
        str = null;
        TextView textView42 = (TextView) view.findViewById(d.a.l0.a.f.ai_apps_error_msg);
        if (str == null) {
        }
        textView42.setText(str);
        Activity activity2 = this.f0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        d.a.l0.a.a2.e Q2 = d.a.l0.a.a2.e.Q();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.y0;
        if (forbiddenInfo != null) {
            textView2.setText("(" + this.y0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView2.setTextColor(z().getColor(d.a.l0.a.c.aiapps_error_detail_color));
        }
        textView.setOnClickListener(new b(launchInfo));
        if (q0.G()) {
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        R1(view);
        l2(-1);
        t2(-16777216);
        p2(false);
        z2(true);
        this.i0.setRightExitOnClickListener(new a());
        ForbiddenInfo forbiddenInfo = this.y0;
        if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
            return;
        }
        n2(this.y0.appTitle);
    }

    public final boolean Q2(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1242268664) {
            if (hashCode != 38398066) {
                if (hashCode == 731215244 && str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                    c2 = 1;
                }
            } else if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                c2 = 0;
            }
        } else if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return false;
                }
                return X2("app_need_upgrade_btn_cmd");
            }
            return X2("app_open_failed_btn_cmd");
        }
        return X2("net_conn_failed_btn_cmd");
    }

    public void S2(Activity activity) {
        d.a.l0.a.c1.a.G().f(activity, L2(activity));
        C0716e.a("feedback", M2(), this.y0);
    }

    public void T2(o oVar, Activity activity) {
        d.a.l0.a.c1.a.G().e(activity, oVar);
        C0716e.a(ErrorContentResponse.Operations.NOTICE, M2(), this.y0);
    }

    public void U2(o oVar, Activity activity) {
        d.a.l0.a.c1.a.G().a(activity, oVar);
        C0716e.a(ErrorContentResponse.Operations.NOTICE, M2(), this.y0);
    }

    public void V2(Activity activity) {
        d.a.l0.a.j1.a.j(activity);
        C0716e.a("daynightmode", M2(), this.y0);
    }

    public void W2(Activity activity) {
        if (activity instanceof SwanAppErrorActivity) {
            d.a.l0.a.j1.a.t(activity);
        }
        C0716e.a("refresh", M2(), this.y0);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    public final boolean X2(String str) {
        Map<String, String> c2 = d.a.l0.n.j.i.i.b().c();
        ForbiddenInfo forbiddenInfo = this.y0;
        if (forbiddenInfo != null) {
            String str2 = forbiddenInfo.forbiddenDetail;
            if (str2.length() > 4) {
                String substring = str2.substring(str2.length() - 4);
                if (!TextUtils.isEmpty(c2.get(substring + "_btn_cmd"))) {
                    String str3 = c2.get(substring + "_btn_cmd");
                    this.B0 = str3;
                    return !TextUtils.equals(str3, "0");
                }
            }
        }
        String str4 = c2.get(str);
        this.B0 = str4;
        if (TextUtils.isEmpty(str4)) {
            this.B0 = "1";
        }
        return !TextUtils.equals(this.B0, "0");
    }

    public final void Y2() {
        n nVar = this.j0;
        if (nVar != null) {
            nVar.p(d.a.l0.a.c1.a.H().a());
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    public final void Z2() {
        C0716e.a(SupportMenuInflater.XML_MENU, M2(), this.y0);
    }

    public final String a3() {
        PMSAppInfo s;
        String string = q().getString(d.a.l0.a.h.swanapp_app_forbidden);
        ForbiddenInfo forbiddenInfo = this.y0;
        if (forbiddenInfo == null) {
            return string;
        }
        String str = forbiddenInfo.appId;
        return (TextUtils.isEmpty(str) || (s = d.a.l0.n.g.a.h().s(str)) == null || TextUtils.isEmpty(s.statusDesc)) ? string : s.statusDesc;
    }

    public final void b3() {
        n nVar = this.j0;
        if (nVar == null) {
            return;
        }
        o f2 = nVar.f(46);
        o f3 = this.j0.f(47);
        if (f2 != null && this.z0 > 0) {
            f3.o(1);
            f3.n(this.z0);
        }
        if (f3 == null || this.A0 <= 0) {
            return;
        }
        f3.o(1);
        f3.n(this.A0);
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
        O2();
        Y2();
        b3();
        Z2();
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return J2();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle n = n();
        if (n == null) {
            return;
        }
        this.x0 = n.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
        this.y0 = (ForbiddenInfo) n.getParcelable("key_forbidden_info");
        this.z0 = n.getInt("key_show_menu_notice");
        this.A0 = n.getInt("key_show_menu_privacy");
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        n nVar = this.j0;
        if (nVar != null && nVar.g()) {
            this.j0.x(d.a.l0.a.c1.a.H().a());
        }
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar != null) {
            d.a.l0.a.k1.a.o(swanAppActionBar, this.A0 + this.z0);
        }
    }
}
