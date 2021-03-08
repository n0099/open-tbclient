package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f5396a;
    private final char b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.f5396a = list;
        this.b = c;
        this.c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f5396a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return a(this.b, this.f, this.e);
    }
}
