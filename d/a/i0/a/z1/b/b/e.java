package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.a.i0.a.z1.b.b.i;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f45895g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f45896h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f45897i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f45898e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f45899f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45900g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f45901h;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i a() {
            e eVar = (e) super.a();
            eVar.g(this.f45898e);
            eVar.h(this.f45899f);
            eVar.j(this.f45900g);
            eVar.i(this.f45901h);
            return eVar;
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i b(Context context) {
            return new e(context);
        }

        public a l(JSONArray jSONArray) {
            this.f45898e = jSONArray;
            return this;
        }

        public a m(JSONArray jSONArray) {
            this.f45899f = jSONArray;
            return this;
        }

        public a n(BdMultiPicker.b bVar) {
            this.f45901h = bVar;
            return this;
        }

        public a o(boolean z) {
            this.f45900g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.a.i0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f45895g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f45895g.setLayoutParams(layoutParams);
        this.f45895g.setMultiWheelData(this.f45896h, this.f45897i);
        if (this.k) {
            return;
        }
        this.f45895g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f45895g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f45896h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.f45897i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i2, JSONArray jSONArray, int i3) {
        this.f45895g.j(i2, jSONArray, i3);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f45895g);
    }
}
