package d.a.m0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import d.a.m0.a.z1.b.b.i;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f49853g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f49854h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f49855i;
    public BdMultiPicker.b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f49856e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f49857f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f49858g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f49859h;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i a() {
            e eVar = (e) super.a();
            eVar.g(this.f49856e);
            eVar.h(this.f49857f);
            eVar.j(this.f49858g);
            eVar.i(this.f49859h);
            return eVar;
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i b(Context context) {
            return new e(context);
        }

        public a l(JSONArray jSONArray) {
            this.f49856e = jSONArray;
            return this;
        }

        public a m(JSONArray jSONArray) {
            this.f49857f = jSONArray;
            return this;
        }

        public a n(BdMultiPicker.b bVar) {
            this.f49859h = bVar;
            return this;
        }

        public a o(boolean z) {
            this.f49858g = z;
            return this;
        }
    }

    public e(Context context) {
        super(context, d.a.m0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f49853g = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f49853g.setLayoutParams(layoutParams);
        this.f49853g.setMultiWheelData(this.f49854h, this.f49855i);
        if (this.k) {
            return;
        }
        this.f49853g.setMultiSelectedListener(this.j);
    }

    public JSONArray f() {
        return this.f49853g.getCurrentIndex();
    }

    public void g(JSONArray jSONArray) {
        this.f49854h = jSONArray;
    }

    public void h(JSONArray jSONArray) {
        this.f49855i = jSONArray;
    }

    public void i(BdMultiPicker.b bVar) {
        this.j = bVar;
    }

    public void j(boolean z) {
        this.k = z;
    }

    public void k(int i2, JSONArray jSONArray, int i3) {
        this.f49853g.j(i2, jSONArray, i3);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f49853g);
    }
}
