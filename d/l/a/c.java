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
    public HashMap<String, Boolean> f70307a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f70308b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f70309c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f70310d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f70311e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f70312f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f70313g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f70314h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f70312f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f70313g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f70307a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f70308b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f70311e;
    }

    public final HashMap<String, String> f() {
        return this.f70309c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f70310d;
    }

    public final boolean h() {
        return this.f70314h;
    }

    public final void i(boolean z) {
        this.f70314h = z;
    }
}
