package d.m.a;

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
    public HashMap<String, Boolean> f67360a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f67361b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f67362c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f67363d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f67364e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f67365f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f67366g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f67367h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f67365f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f67366g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f67360a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f67361b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f67364e;
    }

    public final HashMap<String, String> f() {
        return this.f67362c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f67363d;
    }

    public final boolean h() {
        return this.f67367h;
    }

    public final void i(boolean z) {
        this.f67367h = z;
    }
}
