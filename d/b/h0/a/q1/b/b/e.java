package d.b.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.b.h0.a.q1.b.b.h;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f46288g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f46289h;
    public JSONArray i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f46290e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f46291f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f46292g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f46293h;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h a() {
            e eVar = (e) super.a();
            eVar.g(this.f46290e);
            eVar.h(this.f46291f);
            eVar.j(this.f46292g);
            eVar.i(this.f46293h);
            return eVar;
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new e(context);
        }

        public a k(JSONArray jSONArray) {
            this.f46290e = jSONArray;
            return this;
        }

        public a l(JSONArray jSONArray) {
            this.f46291f = jSONArray;
            return this;
        }

        public a m(BdMultiPicker.b bVar) {
            this.f46293h = bVar;
            return this;
        }

        public a n(boolean z) {
            this.f46292g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.b.h0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f46288g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f46288g.setLayoutParams(layoutParams);
        this.f46288g.setMultiWheelData(this.f46289h, this.i);
        if (this.k) {
            return;
        }
        this.f46288g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f46288g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f46289h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i, JSONArray jSONArray, int i2) {
        this.f46288g.j(i, jSONArray, i2);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().i(this.f46288g);
    }
}
