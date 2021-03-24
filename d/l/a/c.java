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
    public HashMap<String, Boolean> f66219a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f66220b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f66221c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f66222d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f66223e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f66224f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f66225g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f66226h;

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f66224f;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        return this.f66225g;
    }

    public final HashMap<String, Boolean> c() {
        return this.f66219a;
    }

    public final HashMap<String, Bitmap> d() {
        return this.f66220b;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.f66223e;
    }

    public final HashMap<String, String> f() {
        return this.f66221c;
    }

    public final HashMap<String, TextPaint> g() {
        return this.f66222d;
    }

    public final boolean h() {
        return this.f66226h;
    }

    public final void i(boolean z) {
        this.f66226h = z;
    }
}
