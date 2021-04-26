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
    public HashMap<String, Boolean> f65688a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f65689b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f65690c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f65691d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f65692e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f65693f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f65694g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f65695h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f65693f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f65694g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f65688a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f65689b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f65692e;
    }

    public final HashMap<String, String> f() {
        return this.f65690c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f65691d;
    }

    public final boolean h() {
        return this.f65695h;
    }

    public final void i(boolean z) {
        this.f65695h = z;
    }
}
