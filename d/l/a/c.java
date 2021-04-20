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
    public HashMap<String, Boolean> f67213a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f67214b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f67215c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f67216d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f67217e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f67218f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f67219g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f67220h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f67218f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f67219g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f67213a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f67214b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f67217e;
    }

    public final HashMap<String, String> f() {
        return this.f67215c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f67216d;
    }

    public final boolean h() {
        return this.f67220h;
    }

    public final void i(boolean z) {
        this.f67220h = z;
    }
}
