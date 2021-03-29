package d.b.g0.a.e0.l;

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
import d.b.g0.a.i2.k0;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.e0.l.c {
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
        public final /* synthetic */ d.b.g0.a.y0.e.b f43994e;

        public b(d.b.g0.a.y0.e.b bVar) {
            this.f43994e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = d.this.f0;
            if (activity == null || !SwanAppNetworkUtils.h(activity)) {
                return;
            }
            SwanLauncher.j().n(this.f43994e, null);
            d.this.f0.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43996e;

        public c(String str) {
            this.f43996e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.z0 == null || TextUtils.isEmpty(d.this.z0.forbiddenDetail)) {
                return;
            }
            d.b.g0.a.w0.a.q().b(d.this.f(), this.f43996e, d.this.z0.appTitle, d.this.z0.forbiddenDetail);
        }
    }

    public static d E2(String str, ForbiddenInfo forbiddenInfo) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
        bundle.putParcelable("key_forbidden_info", forbiddenInfo);
        dVar.d1(bundle);
        return dVar;
    }

    public final boolean C2() {
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
    public void D2(View view) {
        String str;
        d.b.g0.a.y0.e.b launchInfo;
        ForbiddenInfo forbiddenInfo;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(d.b.g0.a.f.ai_apps_error_image);
        TextView textView = (TextView) view.findViewById(d.b.g0.a.f.ai_apps_emptyview_btn);
        TextView textView2 = (TextView) view.findViewById(d.b.g0.a.f.ai_apps_error_text_one);
        TextView textView3 = (TextView) view.findViewById(d.b.g0.a.f.ai_apps_error_feedback);
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
                str = l().getString(d.b.g0.a.h.swanapp_app_forbidden);
            } else if (c2 == 1) {
                str = l().getString(d.b.g0.a.h.swanapp_path_forbidden);
            } else if (c2 == 2) {
                String string = l().getString(d.b.g0.a.h.aiapps_common_emptyview_detail_text);
                imageView.setImageDrawable(l().getResources().getDrawable(d.b.g0.a.e.aiapps_empty_icon_network));
                textView.setVisibility(0);
                textView2.setVisibility(8);
                str = string;
            } else if (c2 == 3) {
                str = l().getString(d.b.g0.a.h.swanapp_normal_error);
                textView.setVisibility(0);
            } else if (c2 == 4) {
                str = l().getString(d.b.g0.a.h.swanapp_normal_error);
                textView.setVisibility(8);
            }
            TextView textView4 = (TextView) view.findViewById(d.b.g0.a.f.ai_apps_error_msg);
            if (str == null) {
                str = l().getString(d.b.g0.a.h.swanapp_normal_error);
            }
            textView4.setText(str);
            Activity activity = this.f0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (launchInfo == null) {
                str3 = launchInfo.G();
            } else if (O != null) {
                str3 = O.B();
            }
            forbiddenInfo = this.z0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView2.setText("(" + this.z0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView2.setTextColor(u().getColor(d.b.g0.a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new b(launchInfo));
            if (k0.D() || TextUtils.equals(this.y0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
            }
            textView3.setVisibility(0);
            textView3.setOnClickListener(new c(str3));
            return;
        }
        str = null;
        TextView textView42 = (TextView) view.findViewById(d.b.g0.a.f.ai_apps_error_msg);
        if (str == null) {
        }
        textView42.setText(str);
        Activity activity2 = this.f0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        d.b.g0.a.r1.e O2 = d.b.g0.a.r1.e.O();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.z0;
        if (forbiddenInfo != null) {
            textView2.setText("(" + this.z0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView2.setTextColor(u().getColor(d.b.g0.a.c.aiapps_error_detail_color));
        }
        textView.setOnClickListener(new b(launchInfo));
        if (k0.D()) {
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        g2(-1);
        o2(-16777216);
        k2(false);
        u2(true);
        this.i0.setRightMenuOnClickListener(null);
        this.i0.setRightExitOnClickListener(new a());
        ForbiddenInfo forbiddenInfo = this.z0;
        if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
            return;
        }
        i2(this.z0.appTitle);
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return C2();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle j = j();
        if (j == null) {
            return;
        }
        this.y0 = j.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
        this.z0 = (ForbiddenInfo) j.getParcelable("key_forbidden_info");
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.aiapps_error_fragment, viewGroup, false);
        D2(inflate);
        M1(inflate);
        return L1() ? O1(inflate) : inflate;
    }
}
