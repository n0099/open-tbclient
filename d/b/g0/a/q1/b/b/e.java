package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.b.g0.a.q1.b.b.h;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f45566g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f45567h;
    public JSONArray i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f45568e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f45569f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45570g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f45571h;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h a() {
            e eVar = (e) super.a();
            eVar.g(this.f45568e);
            eVar.h(this.f45569f);
            eVar.j(this.f45570g);
            eVar.i(this.f45571h);
            return eVar;
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h b(Context context) {
            return new e(context);
        }

        public a k(JSONArray jSONArray) {
            this.f45568e = jSONArray;
            return this;
        }

        public a l(JSONArray jSONArray) {
            this.f45569f = jSONArray;
            return this;
        }

        public a m(BdMultiPicker.b bVar) {
            this.f45571h = bVar;
            return this;
        }

        public a n(boolean z) {
            this.f45570g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.b.g0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f45566g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f45566g.setLayoutParams(layoutParams);
        this.f45566g.setMultiWheelData(this.f45567h, this.i);
        if (this.k) {
            return;
        }
        this.f45566g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f45566g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f45567h = jSONArray;
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
        this.f45566g.j(i, jSONArray, i2);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().i(this.f45566g);
    }
}
