package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f31839a;

    /* renamed from: b  reason: collision with root package name */
    public final char f31840b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31841c;

    /* renamed from: d  reason: collision with root package name */
    public final double f31842d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31843e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31844f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f31839a = list;
        this.f31840b = c2;
        this.f31841c = d2;
        this.f31842d = d3;
        this.f31843e = str;
        this.f31844f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f31839a;
    }

    public double b() {
        return this.f31842d;
    }

    public int hashCode() {
        return a(this.f31840b, this.f31844f, this.f31843e);
    }
}
