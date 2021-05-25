package d.l.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f66417a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f66418b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f66419c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f66420d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f66421e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f66422f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f66423g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f66424h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f66422f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f66423g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f66417a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f66418b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f66421e;
    }

    public final HashMap<String, String> f() {
        return this.f66419c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f66420d;
    }

    public final boolean h() {
        return this.f66424h;
    }

    public final void i(boolean z) {
        this.f66424h = z;
    }
}
