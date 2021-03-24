package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f31549a;

    /* renamed from: b  reason: collision with root package name */
    public final char f31550b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31551c;

    /* renamed from: d  reason: collision with root package name */
    public final double f31552d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31553e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31554f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f31549a = list;
        this.f31550b = c2;
        this.f31551c = d2;
        this.f31552d = d3;
        this.f31553e = str;
        this.f31554f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f31549a;
    }

    public double b() {
        return this.f31552d;
    }

    public int hashCode() {
        return a(this.f31550b, this.f31554f, this.f31553e);
    }
}
