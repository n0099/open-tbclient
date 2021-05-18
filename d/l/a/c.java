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
    public HashMap<String, Boolean> f66374a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f66375b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f66376c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f66377d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f66378e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f66379f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f66380g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f66381h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f66379f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f66380g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f66374a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f66375b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f66378e;
    }

    public final HashMap<String, String> f() {
        return this.f66376c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f66377d;
    }

    public final boolean h() {
        return this.f66381h;
    }

    public final void i(boolean z) {
        this.f66381h = z;
    }
}
