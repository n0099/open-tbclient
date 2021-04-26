package d.a.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.a.h0.a.q1.b.b.h;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f43640g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f43641h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f43642i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f43643e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f43644f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43645g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f43646h;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h a() {
            e eVar = (e) super.a();
            eVar.g(this.f43643e);
            eVar.h(this.f43644f);
            eVar.j(this.f43645g);
            eVar.i(this.f43646h);
            return eVar;
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new e(context);
        }

        public a k(JSONArray jSONArray) {
            this.f43643e = jSONArray;
            return this;
        }

        public a l(JSONArray jSONArray) {
            this.f43644f = jSONArray;
            return this;
        }

        public a m(BdMultiPicker.b bVar) {
            this.f43646h = bVar;
            return this;
        }

        public a n(boolean z) {
            this.f43645g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.a.h0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f43640g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f43640g.setLayoutParams(layoutParams);
        this.f43640g.setMultiWheelData(this.f43641h, this.f43642i);
        if (this.k) {
            return;
        }
        this.f43640g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f43640g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f43641h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.f43642i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i2, JSONArray jSONArray, int i3) {
        this.f43640g.j(i2, jSONArray, i3);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().i(this.f43640g);
    }
}
