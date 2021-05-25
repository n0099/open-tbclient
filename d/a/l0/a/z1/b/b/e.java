package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.a.l0.a.z1.b.b.i;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f46071g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f46072h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f46073i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f46074e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f46075f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f46076g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f46077h;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i a() {
            e eVar = (e) super.a();
            eVar.g(this.f46074e);
            eVar.h(this.f46075f);
            eVar.j(this.f46076g);
            eVar.i(this.f46077h);
            return eVar;
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i b(Context context) {
            return new e(context);
        }

        public a l(JSONArray jSONArray) {
            this.f46074e = jSONArray;
            return this;
        }

        public a m(JSONArray jSONArray) {
            this.f46075f = jSONArray;
            return this;
        }

        public a n(BdMultiPicker.b bVar) {
            this.f46077h = bVar;
            return this;
        }

        public a o(boolean z) {
            this.f46076g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f46071g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f46071g.setLayoutParams(layoutParams);
        this.f46071g.setMultiWheelData(this.f46072h, this.f46073i);
        if (this.k) {
            return;
        }
        this.f46071g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f46071g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f46072h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.f46073i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i2, JSONArray jSONArray, int i3) {
        this.f46071g.j(i2, jSONArray, i3);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f46071g);
    }
}
