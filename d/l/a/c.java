package d.l.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f70203a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f70204b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f70205c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f70206d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f70207e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f70208f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f70209g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f70210h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f70208f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f70209g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f70203a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f70204b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f70207e;
    }

    public final HashMap<String, String> f() {
        return this.f70205c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f70206d;
    }

    public final boolean h() {
        return this.f70210h;
    }

    public final void i(boolean z) {
        this.f70210h = z;
    }
}
