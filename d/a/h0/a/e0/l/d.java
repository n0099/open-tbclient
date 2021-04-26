package d.a.h0.a.e0.l;

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
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class d extends d.a.h0.a.e0.l.c {
    public String y0;
    public ForbiddenInfo z0;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = d.this.f0;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f42012e;

        public b(d.a.h0.a.y0.e.b bVar) {
            this.f42012e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = d.this.f0;
            if (activity == null || !SwanAppNetworkUtils.h(activity)) {
                return;
            }
            SwanLauncher.j().n(this.f42012e, null);
            d.this.f0.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42014e;

        public c(String str) {
            this.f42014e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.z0 == null || TextUtils.isEmpty(d.this.z0.forbiddenDetail)) {
                return;
            }
            d.a.h0.a.w0.a.q().b(d.this.f(), this.f42014e, d.this.z0.appTitle, d.this.z0.forbiddenDetail);
        }
    }

    public static d D2(String str, ForbiddenInfo forbiddenInfo) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
        bundle.putParcelable("key_forbidden_info", forbiddenInfo);
        dVar.c1(bundle);
        return dVar;
    }

    public final boolean B2() {
        ForbiddenInfo forbiddenInfo = this.z0;
        if (forbiddenInfo == null) {
            return false;
        }
        return forbiddenInfo.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C2(View view) {
        String str;
        d.a.h0.a.y0.e.b launchInfo;
        ForbiddenInfo forbiddenInfo;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(d.a.h0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(d.a.h0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(d.a.h0.a.f.ai_apps_error_text_one);
        TextView textView3 = (TextView) view.findViewById(d.a.h0.a.f.ai_apps_error_feedback);
        String str2 = this.y0;
        String str3 = null;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
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
                str = m().getString(d.a.h0.a.h.swanapp_app_forbidden);
            } else if (c2 == 1) {
                str = m().getString(d.a.h0.a.h.swanapp_path_forbidden);
            } else if (c2 == 2) {
                String string = m().getString(d.a.h0.a.h.aiapps_common_emptyview_detail_text);
                imageView.setImageDrawable(m().getResources().getDrawable(d.a.h0.a.e.aiapps_empty_icon_network));
                textView.setVisibility(0);
                textView2.setVisibility(8);
                str = string;
            } else if (c2 == 3) {
                str = m().getString(d.a.h0.a.h.swanapp_normal_error);
                textView.setVisibility(0);
            } else if (c2 == 4) {
                str = m().getString(d.a.h0.a.h.swanapp_normal_error);
                textView.setVisibility(8);
            }
            TextView textView4 = (TextView) view.findViewById(d.a.h0.a.f.ai_apps_error_msg);
            if (str == null) {
                str = m().getString(d.a.h0.a.h.swanapp_normal_error);
            }
            textView4.setText(str);
            Activity activity = this.f0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
            if (launchInfo == null) {
                str3 = launchInfo.G();
            } else if (O != null) {
                str3 = O.B();
            }
            forbiddenInfo = this.z0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView2.setText("(" + this.z0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView2.setTextColor(t().getColor(d.a.h0.a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new b(launchInfo));
            if (k0.D() || TextUtils.equals(this.y0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
            }
            textView3.setVisibility(0);
            textView3.setOnClickListener(new c(str3));
            return;
        }
        str = null;
        TextView textView42 = (TextView) view.findViewById(d.a.h0.a.f.ai_apps_error_msg);
        if (str == null) {
        }
        textView42.setText(str);
        Activity activity2 = this.f0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        d.a.h0.a.r1.e O2 = d.a.h0.a.r1.e.O();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.z0;
        if (forbiddenInfo != null) {
            textView2.setText("(" + this.z0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView2.setTextColor(t().getColor(d.a.h0.a.c.aiapps_error_detail_color));
        }
        textView.setOnClickListener(new b(launchInfo));
        if (k0.D()) {
        }
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
        super.L1(view);
        f2(-1);
        n2(-16777216);
        j2(false);
        t2(true);
        this.i0.setRightMenuOnClickListener(null);
        this.i0.setRightExitOnClickListener(new a());
        ForbiddenInfo forbiddenInfo = this.z0;
        if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
            return;
        }
        h2(this.z0.appTitle);
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return B2();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle i2 = i();
        if (i2 == null) {
            return;
        }
        this.y0 = i2.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
        this.z0 = (ForbiddenInfo) i2.getParcelable("key_forbidden_info");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.h0.a.g.aiapps_error_fragment, viewGroup, false);
        C2(inflate);
        L1(inflate);
        return K1() ? N1(inflate) : inflate;
    }
}
