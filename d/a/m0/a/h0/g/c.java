package d.a.m0.a.h0.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.h0.g.d implements AdapterView.OnItemClickListener {
    public static final boolean G0 = d.a.m0.a.k.f46983a;
    public static String H0 = "pref_close_scope_alert_showed";
    public BaseAdapter C0;
    public FrameLayout E0;
    public final List<d.a.m0.a.e2.c.f> D0 = new ArrayList();
    public boolean F0 = false;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.this.F0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.this.F0 = false;
        }
    }

    /* renamed from: d.a.m0.a.h0.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0717c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.c.f f45808e;

        public DialogInterface$OnClickListenerC0717c(d.a.m0.a.e2.c.f fVar) {
            this.f45808e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.this.Q2().T().z(c.H0, true);
            c.this.U2(this.f45808e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.v2.e1.b<Map<String, d.a.m0.a.e2.c.f>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, d.a.m0.a.e2.c.f> map) {
            FragmentActivity h2 = c.this.h();
            if (h2 == null || h2.isFinishing() || h2.isDestroyed()) {
                return;
            }
            d.a.m0.a.z1.b.d.a.b(c.this.E0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, d.a.m0.a.e2.c.f> entry : map.entrySet()) {
                d.a.m0.a.e2.c.f value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f45481d && value.b() && "2".equals(value.f45482e) && !"snsapi_base".equals(value.f45479b)) {
                    c.this.D0.add(value);
                }
            }
            c.this.W2();
            c.this.C0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BaseAdapter {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.a.m0.a.e2.c.f getItem(int i2) {
            return (d.a.m0.a.e2.c.f) c.this.D0.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return c.this.D0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return getItem(i2).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null || !(view.getTag() instanceof g)) {
                view = View.inflate(c.this.q(), d.a.m0.a.g.aiapps_setting_item, null);
                g gVar = new g();
                gVar.f45815b = (CheckBox) view.findViewById(d.a.m0.a.f.checkbox);
                gVar.f45814a = (TextView) view.findViewById(d.a.m0.a.f.title);
                view.setTag(gVar);
            }
            g gVar2 = (g) view.getTag();
            d.a.m0.a.e2.c.f item = getItem(i2);
            String str = TextUtils.isEmpty(item.f45484g) ? item.f45483f : item.f45484g;
            TextView textView = gVar2.f45814a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
            gVar2.f45815b.setChecked(item.a());
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.c.f f45812e;

        public f(d.a.m0.a.e2.c.f fVar) {
            this.f45812e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            FragmentActivity h2 = c.this.h();
            if (h2 == null) {
                return;
            }
            d.a.m0.a.z1.b.d.a.b(c.this.E0);
            if (iVar != null && iVar.c()) {
                c.this.V2(this.f45812e, iVar.f45520a.f45535b);
            } else {
                d.a.m0.a.z1.b.f.e.f(h2, d.a.m0.a.h.aiapps_setting_scope_auth_failed).F();
            }
            c.this.F0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public TextView f45814a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f45815b;

        public g() {
        }
    }

    public static c S2() {
        return new c();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.m0.a.g.aiapps_setting_fragment, viewGroup, false);
        Q1(inflate);
        this.E0 = (FrameLayout) inflate.findViewById(d.a.m0.a.f.container);
        this.C0 = P2();
        ListView listView = (ListView) inflate.findViewById(d.a.m0.a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.C0);
        listView.setOnItemClickListener(this);
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        this.k0 = null;
        super.E0();
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view, @Nullable Bundle bundle) {
        super.N0(view, bundle);
        R2();
    }

    public final void O2(d.a.m0.a.e2.c.f fVar, boolean z) {
        d.a.m0.a.a2.e Q2 = Q2();
        if (Q2 == null) {
            this.F0 = false;
            return;
        }
        d.a.m0.a.z1.b.d.a.e(h(), this.E0);
        Q2.T().d(h(), fVar.f45479b, false, z, true, new f(fVar));
    }

    public final BaseAdapter P2() {
        return new e();
    }

    @Override // d.a.m0.a.h0.g.d
    public void Q1(View view) {
        R1(view);
        l2(-1);
        t2(-16777216);
        n2(J(d.a.m0.a.h.common_menu_authority_management));
        p2(true);
        z2(false);
    }

    @Nullable
    public d.a.m0.a.a2.e Q2() {
        return d.a.m0.a.g1.f.V().F();
    }

    public final void R2() {
        d.a.m0.a.z1.b.d.a.e(h(), this.E0);
        this.D0.clear();
        this.C0.notifyDataSetChanged();
        d.a.m0.a.n1.q.c.a.h(new d());
    }

    public final void T2(d.a.m0.a.e2.c.f fVar) {
        h.a aVar = new h.a(h());
        aVar.U(d.a.m0.a.h.aiapps_setting_scope_close_alert_title);
        aVar.v(d.a.m0.a.h.aiapps_setting_scope_close_alert_msg);
        aVar.n(new d.a.m0.a.w2.h.a());
        aVar.O(d.a.m0.a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface$OnClickListenerC0717c(fVar));
        aVar.B(d.a.m0.a.h.aiapps_cancel, new b());
        aVar.m(true);
        aVar.K(new a());
        aVar.X();
    }

    public final void U2(d.a.m0.a.e2.c.f fVar) {
        O2(fVar, !fVar.a());
    }

    public final void V2(d.a.m0.a.e2.c.f fVar, boolean z) {
        fVar.j = z ? 1 : -1;
        this.C0.notifyDataSetChanged();
    }

    public final void W2() {
        View b0 = b0();
        if (b0 == null) {
            return;
        }
        boolean isEmpty = this.D0.isEmpty();
        TextView textView = (TextView) b0.findViewById(d.a.m0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(N(d.a.m0.a.h.aiapps_setting_tips, Q2().O()));
        }
        View findViewById = b0.findViewById(d.a.m0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) b0.findViewById(d.a.m0.a.f.empty);
        if (isEmpty) {
            textView2.setText(N(d.a.m0.a.h.aiapps_setting_empty, Q2().O()));
        }
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public void e2() {
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (G0) {
            Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.m0.a.a2.e Q2 = Q2();
        if (Q2 != null) {
            Q2.T().v();
        }
        if (G0) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (this.F0) {
            return;
        }
        d.a.m0.a.e2.c.f fVar = this.D0.get(i2);
        this.F0 = true;
        if (fVar.a() && !Q2().T().m(H0, false)) {
            T2(fVar);
            return;
        }
        d.a.m0.a.e2.c.d.j("onItemClick : " + fVar, Boolean.FALSE);
        U2(fVar);
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (G0) {
            Log.d("SwanAppAuthoritySettingFragment", "onPause()");
        }
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        x2(1);
        if (G0) {
            Log.d("SwanAppAuthoritySettingFragment", "onResume()");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        super.w0(activity);
        if (G0) {
            Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
        }
    }
}
