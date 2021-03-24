package d.b.g0.a.e0.l;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.v1.c.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.e0.l.c implements AdapterView.OnItemClickListener {
    public static final boolean C0 = k.f45050a;
    public static String D0 = "pref_close_scope_alert_showed";
    public FrameLayout A0;
    public BaseAdapter y0;
    public final List<d.b.g0.a.v1.c.e> z0 = new ArrayList();
    public boolean B0 = false;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.B0 = false;
        }
    }

    /* renamed from: d.b.g0.a.e0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0659b implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0659b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            b.this.B0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.e f43965e;

        public c(d.b.g0.a.v1.c.e eVar) {
            this.f43965e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            b.this.L2().R().y(b.D0, true);
            b.this.Q2(this.f43965e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.a.i2.u0.b<Map<String, d.b.g0.a.v1.c.e>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Map<String, d.b.g0.a.v1.c.e> map) {
            FragmentActivity f2 = b.this.f();
            if (f2 == null || f2.isFinishing() || f2.isDestroyed()) {
                return;
            }
            d.b.g0.a.q1.b.d.a.b(b.this.A0);
            if (map == null) {
                b.this.O2(f2);
                return;
            }
            for (Map.Entry<String, d.b.g0.a.v1.c.e> entry : map.entrySet()) {
                d.b.g0.a.v1.c.e value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f46770d && value.b() && "2".equals(value.f46771e) && !"snsapi_base".equals(value.f46768b)) {
                    b.this.z0.add(value);
                }
            }
            b.this.T2();
            b.this.y0.notifyDataSetChanged();
            b.this.O2(f2);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BaseAdapter {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.b.g0.a.v1.c.e getItem(int i) {
            return (d.b.g0.a.v1.c.e) b.this.z0.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return b.this.z0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return getItem(i).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null || !(view.getTag() instanceof g)) {
                view = View.inflate(b.this.l(), d.b.g0.a.g.aiapps_setting_item, null);
                g gVar = new g();
                gVar.f43972b = (CheckBox) view.findViewById(d.b.g0.a.f.checkbox);
                gVar.f43971a = (TextView) view.findViewById(d.b.g0.a.f.title);
                view.setTag(gVar);
            }
            g gVar2 = (g) view.getTag();
            d.b.g0.a.v1.c.e item = getItem(i);
            String str = TextUtils.isEmpty(item.f46773g) ? item.f46772f : item.f46773g;
            TextView textView = gVar2.f43971a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
            gVar2.f43972b.setChecked(item.a());
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.e f43969e;

        public f(d.b.g0.a.v1.c.e eVar) {
            this.f43969e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            FragmentActivity f2 = b.this.f();
            if (f2 == null) {
                return;
            }
            d.b.g0.a.q1.b.d.a.b(b.this.A0);
            if (hVar != null && hVar.c()) {
                b.this.R2(this.f43969e, hVar.f46807a.f46822b);
            } else {
                d.b.g0.a.q1.b.f.d.e(f2, d.b.g0.a.h.aiapps_setting_scope_auth_failed).C();
            }
            b.this.B0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public TextView f43971a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f43972b;

        public g() {
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.b.g0.a.v1.c.e {
        public h(String str) {
            super(str);
        }
    }

    public static b N2() {
        return new b();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void H0(View view, @Nullable Bundle bundle) {
        super.H0(view, bundle);
        M2();
    }

    public final void J2(d.b.g0.a.v1.c.e eVar, boolean z) {
        d.b.g0.a.r1.e L2 = L2();
        if (L2 == null) {
            this.B0 = false;
            return;
        }
        d.b.g0.a.q1.b.d.a.e(f(), this.A0);
        L2.R().d(f(), eVar.f46768b, false, z, true, new f(eVar));
    }

    public final BaseAdapter K2() {
        return new e();
    }

    @Nullable
    public d.b.g0.a.r1.e L2() {
        return d.b.g0.a.z0.f.V().t();
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        N1(view);
        g2(-1);
        o2(-16777216);
        i2(G(d.b.g0.a.h.common_menu_authority_management));
        k2(true);
        u2(false);
    }

    public final void M2() {
        d.b.g0.a.q1.b.d.a.e(f(), this.A0);
        this.z0.clear();
        this.y0.notifyDataSetChanged();
        d.b.g0.a.g1.o.c.a.h(new d());
    }

    @UiThread
    public final void O2(@NonNull Activity activity) {
        Cursor query;
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null || (query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"_id", "title", "result"}, "appKey=?", new String[]{O.B()}, null)) == null) {
            return;
        }
        if (query.getCount() > 0) {
            while (query.moveToNext()) {
                int i = query.getInt(query.getColumnIndex("_id"));
                String string = query.getString(query.getColumnIndex("title"));
                int i2 = query.getInt(query.getColumnIndex("result"));
                h hVar = new h(String.valueOf(i));
                hVar.f46772f = string;
                int i3 = -1;
                if (i2 != -1) {
                    i3 = 1;
                }
                hVar.j = i3;
                this.z0.add(hVar);
            }
            T2();
            this.y0.notifyDataSetChanged();
        }
        d.b.g0.p.d.a(query);
    }

    public final void P2(d.b.g0.a.v1.c.e eVar) {
        g.a aVar = new g.a(f());
        aVar.U(d.b.g0.a.h.aiapps_setting_scope_close_alert_title);
        aVar.w(d.b.g0.a.h.aiapps_setting_scope_close_alert_msg);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.O(d.b.g0.a.h.aiapps_setting_scope_close_alert_btn_pos, new c(eVar));
        aVar.C(d.b.g0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0659b());
        aVar.m(true);
        aVar.L(new a());
        aVar.X();
    }

    public final void Q2(d.b.g0.a.v1.c.e eVar) {
        if (eVar instanceof h) {
            S2((h) eVar);
        } else {
            J2(eVar, !eVar.a());
        }
    }

    public final void R2(d.b.g0.a.v1.c.e eVar, boolean z) {
        eVar.j = z ? 1 : -1;
        this.y0.notifyDataSetChanged();
    }

    @UiThread
    public final void S2(@NonNull h hVar) {
        FragmentActivity f2 = f();
        if (f2 == null) {
            this.B0 = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!hVar.a() ? 1 : -1));
        if (f2.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{hVar.f46768b}) > 0) {
            hVar.j = hVar.a() ? -1 : 1;
            this.y0.notifyDataSetChanged();
        }
        this.B0 = false;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    public final void T2() {
        View W = W();
        if (W == null) {
            return;
        }
        boolean isEmpty = this.z0.isEmpty();
        TextView textView = (TextView) W.findViewById(d.b.g0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(J(d.b.g0.a.h.aiapps_setting_tips, L2().M()));
        }
        View findViewById = W.findViewById(d.b.g0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) W.findViewById(d.b.g0.a.f.empty);
        if (isEmpty) {
            textView2.setText(J(d.b.g0.a.h.aiapps_setting_empty, L2().M()));
        }
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
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.g0.a.r1.e L2 = L2();
        if (L2 != null) {
            L2.R().u();
        }
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.B0) {
            return;
        }
        d.b.g0.a.v1.c.e eVar = this.z0.get(i);
        this.B0 = true;
        if (eVar.a() && !L2().R().m(D0, false)) {
            P2(eVar);
            return;
        }
        d.b.g0.a.v1.c.c.j("onItemClick : " + eVar, Boolean.FALSE);
        Q2(eVar);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onPause()");
        }
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        s2(1);
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onResume()");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q0(Activity activity) {
        super.q0(activity);
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.aiapps_setting_fragment, viewGroup, false);
        M1(inflate);
        this.A0 = (FrameLayout) inflate.findViewById(d.b.g0.a.f.container);
        this.y0 = K2();
        ListView listView = (ListView) inflate.findViewById(d.b.g0.a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.y0);
        listView.setOnItemClickListener(this);
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        this.f0 = null;
        super.y0();
    }
}
