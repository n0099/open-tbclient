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
    public BdMultiPicker f49745g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f49746h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f49747i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f49748e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f49749f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f49750g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f49751h;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i a() {
            e eVar = (e) super.a();
            eVar.g(this.f49748e);
            eVar.h(this.f49749f);
            eVar.j(this.f49750g);
            eVar.i(this.f49751h);
            return eVar;
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i b(Context context) {
            return new e(context);
        }

        public a l(JSONArray jSONArray) {
            this.f49748e = jSONArray;
            return this;
        }

        public a m(JSONArray jSONArray) {
            this.f49749f = jSONArray;
            return this;
        }

        public a n(BdMultiPicker.b bVar) {
            this.f49751h = bVar;
            return this;
        }

        public a o(boolean z) {
            this.f49750g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f49745g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f49745g.setLayoutParams(layoutParams);
        this.f49745g.setMultiWheelData(this.f49746h, this.f49747i);
        if (this.k) {
            return;
        }
        this.f49745g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f49745g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f49746h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.f49747i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i2, JSONArray jSONArray, int i3) {
        this.f49745g.j(i2, jSONArray, i3);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f49745g);
    }
}
