package d.a.h0.a.e0.l;

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
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.v1.c.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.e0.l.c implements AdapterView.OnItemClickListener {
    public static final boolean C0 = k.f43101a;
    public static String D0 = "pref_close_scope_alert_showed";
    public FrameLayout A0;
    public BaseAdapter y0;
    public final List<d.a.h0.a.v1.c.e> z0 = new ArrayList();
    public boolean B0 = false;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.B0 = false;
        }
    }

    /* renamed from: d.a.h0.a.e0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0631b implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0631b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.B0 = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.e f41984e;

        public c(d.a.h0.a.v1.c.e eVar) {
            this.f41984e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.K2().R().y(b.D0, true);
            b.this.P2(this.f41984e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.h0.a.i2.u0.b<Map<String, d.a.h0.a.v1.c.e>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Map<String, d.a.h0.a.v1.c.e> map) {
            FragmentActivity f2 = b.this.f();
            if (f2 == null || f2.isFinishing() || f2.isDestroyed()) {
                return;
            }
            d.a.h0.a.q1.b.d.a.b(b.this.A0);
            if (map == null) {
                b.this.N2(f2);
                return;
            }
            for (Map.Entry<String, d.a.h0.a.v1.c.e> entry : map.entrySet()) {
                d.a.h0.a.v1.c.e value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f44913d && value.b() && "2".equals(value.f44914e) && !"snsapi_base".equals(value.f44911b)) {
                    b.this.z0.add(value);
                }
            }
            b.this.S2();
            b.this.y0.notifyDataSetChanged();
            b.this.N2(f2);
        }
    }

    /* loaded from: classes2.dex */
    public class e extends BaseAdapter {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.a.h0.a.v1.c.e getItem(int i2) {
            return (d.a.h0.a.v1.c.e) b.this.z0.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return b.this.z0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return getItem(i2).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null || !(view.getTag() instanceof g)) {
                view = View.inflate(b.this.m(), d.a.h0.a.g.aiapps_setting_item, null);
                g gVar = new g();
                gVar.f41991b = (CheckBox) view.findViewById(d.a.h0.a.f.checkbox);
                gVar.f41990a = (TextView) view.findViewById(d.a.h0.a.f.title);
                view.setTag(gVar);
            }
            g gVar2 = (g) view.getTag();
            d.a.h0.a.v1.c.e item = getItem(i2);
            String str = TextUtils.isEmpty(item.f44916g) ? item.f44915f : item.f44916g;
            TextView textView = gVar2.f41990a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
            gVar2.f41991b.setChecked(item.a());
            return view;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.e f41988e;

        public f(d.a.h0.a.v1.c.e eVar) {
            this.f41988e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            FragmentActivity f2 = b.this.f();
            if (f2 == null) {
                return;
            }
            d.a.h0.a.q1.b.d.a.b(b.this.A0);
            if (hVar != null && hVar.c()) {
                b.this.Q2(this.f41988e, hVar.f44952a.f44967b);
            } else {
                d.a.h0.a.q1.b.f.d.e(f2, d.a.h0.a.h.aiapps_setting_scope_auth_failed).C();
            }
            b.this.B0 = false;
        }
    }

    /* loaded from: classes2.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public TextView f41990a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f41991b;

        public g() {
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.a.h0.a.v1.c.e {
        public h(String str) {
            super(str);
        }
    }

    public static b M2() {
        return new b();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void G0(View view, @Nullable Bundle bundle) {
        super.G0(view, bundle);
        L2();
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        return false;
    }

    public final void I2(d.a.h0.a.v1.c.e eVar, boolean z) {
        d.a.h0.a.r1.e K2 = K2();
        if (K2 == null) {
            this.B0 = false;
            return;
        }
        d.a.h0.a.q1.b.d.a.e(f(), this.A0);
        K2.R().d(f(), eVar.f44911b, false, z, true, new f(eVar));
    }

    public final BaseAdapter J2() {
        return new e();
    }

    @Nullable
    public d.a.h0.a.r1.e K2() {
        return d.a.h0.a.z0.f.V().F();
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
        M1(view);
        f2(-1);
        n2(-16777216);
        h2(B(d.a.h0.a.h.common_menu_authority_management));
        j2(true);
        t2(false);
    }

    public final void L2() {
        d.a.h0.a.q1.b.d.a.e(f(), this.A0);
        this.z0.clear();
        this.y0.notifyDataSetChanged();
        d.a.h0.a.g1.o.c.a.h(new d());
    }

    @UiThread
    public final void N2(@NonNull Activity activity) {
        Cursor query;
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null || (query = activity.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"_id", "title", "result"}, "appKey=?", new String[]{O.B()}, null)) == null) {
            return;
        }
        if (query.getCount() > 0) {
            while (query.moveToNext()) {
                int i2 = query.getInt(query.getColumnIndex("_id"));
                String string = query.getString(query.getColumnIndex("title"));
                int i3 = query.getInt(query.getColumnIndex("result"));
                h hVar = new h(String.valueOf(i2));
                hVar.f44915f = string;
                int i4 = -1;
                if (i3 != -1) {
                    i4 = 1;
                }
                hVar.j = i4;
                this.z0.add(hVar);
            }
            S2();
            this.y0.notifyDataSetChanged();
        }
        d.a.h0.p.d.a(query);
    }

    public final void O2(d.a.h0.a.v1.c.e eVar) {
        g.a aVar = new g.a(f());
        aVar.U(d.a.h0.a.h.aiapps_setting_scope_close_alert_title);
        aVar.w(d.a.h0.a.h.aiapps_setting_scope_close_alert_msg);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.O(d.a.h0.a.h.aiapps_setting_scope_close_alert_btn_pos, new c(eVar));
        aVar.C(d.a.h0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0631b());
        aVar.m(true);
        aVar.L(new a());
        aVar.X();
    }

    public final void P2(d.a.h0.a.v1.c.e eVar) {
        if (eVar instanceof h) {
            R2((h) eVar);
        } else {
            I2(eVar, !eVar.a());
        }
    }

    public final void Q2(d.a.h0.a.v1.c.e eVar, boolean z) {
        eVar.j = z ? 1 : -1;
        this.y0.notifyDataSetChanged();
    }

    @UiThread
    public final void R2(@NonNull h hVar) {
        FragmentActivity f2 = f();
        if (f2 == null) {
            this.B0 = false;
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", Integer.valueOf(!hVar.a() ? 1 : -1));
        if (f2.getContentResolver().update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "_id=?", new String[]{hVar.f44911b}) > 0) {
            hVar.j = hVar.a() ? -1 : 1;
            this.y0.notifyDataSetChanged();
        }
        this.B0 = false;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return false;
    }

    public final void S2() {
        View P = P();
        if (P == null) {
            return;
        }
        boolean isEmpty = this.z0.isEmpty();
        TextView textView = (TextView) P.findViewById(d.a.h0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(G(d.a.h0.a.h.aiapps_setting_tips, K2().M()));
        }
        View findViewById = P.findViewById(d.a.h0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) P.findViewById(d.a.h0.a.f.empty);
        if (isEmpty) {
            textView2.setText(G(d.a.h0.a.h.aiapps_setting_empty, K2().M()));
        }
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
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void n0(Activity activity) {
        super.n0(activity);
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
        }
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
        d.a.h0.a.r1.e K2 = K2();
        if (K2 != null) {
            K2.R().u();
        }
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (this.B0) {
            return;
        }
        d.a.h0.a.v1.c.e eVar = this.z0.get(i2);
        this.B0 = true;
        if (eVar.a() && !K2().R().m(D0, false)) {
            O2(eVar);
            return;
        }
        d.a.h0.a.v1.c.c.j("onItemClick : " + eVar, Boolean.FALSE);
        P2(eVar);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onPause()");
        }
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        r2(1);
        if (C0) {
            Log.d("SwanAppAuthoritySettingFragment", "onResume()");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.h0.a.g.aiapps_setting_fragment, viewGroup, false);
        L1(inflate);
        this.A0 = (FrameLayout) inflate.findViewById(d.a.h0.a.f.container);
        this.y0 = J2();
        ListView listView = (ListView) inflate.findViewById(d.a.h0.a.f.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.y0);
        listView.setOnItemClickListener(this);
        if (K1()) {
            inflate = N1(inflate);
        }
        return u1(inflate, this);
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void x0() {
        this.f0 = null;
        super.x0();
    }
}
