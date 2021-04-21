package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f31934a;

    /* renamed from: b  reason: collision with root package name */
    public final char f31935b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31936c;

    /* renamed from: d  reason: collision with root package name */
    public final double f31937d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31938e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31939f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f31934a = list;
        this.f31935b = c2;
        this.f31936c = d2;
        this.f31937d = d3;
        this.f31938e = str;
        this.f31939f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f31934a;
    }

    public double b() {
        return this.f31937d;
    }

    public int hashCode() {
        return a(this.f31935b, this.f31939f, this.f31938e);
    }
}
