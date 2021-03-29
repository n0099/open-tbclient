package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f31550a;

    /* renamed from: b  reason: collision with root package name */
    public final char f31551b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31552c;

    /* renamed from: d  reason: collision with root package name */
    public final double f31553d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31554e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31555f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f31550a = list;
        this.f31551b = c2;
        this.f31552c = d2;
        this.f31553d = d3;
        this.f31554e = str;
        this.f31555f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f31550a;
    }

    public double b() {
        return this.f31553d;
    }

    public int hashCode() {
        return a(this.f31551b, this.f31555f, this.f31554e);
    }
}
