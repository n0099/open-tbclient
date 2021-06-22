package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f32185a;

    /* renamed from: b  reason: collision with root package name */
    public final char f32186b;

    /* renamed from: c  reason: collision with root package name */
    public final double f32187c;

    /* renamed from: d  reason: collision with root package name */
    public final double f32188d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32189e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32190f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f32185a = list;
        this.f32186b = c2;
        this.f32187c = d2;
        this.f32188d = d3;
        this.f32189e = str;
        this.f32190f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f32185a;
    }

    public double b() {
        return this.f32188d;
    }

    public int hashCode() {
        return a(this.f32186b, this.f32190f, this.f32189e);
    }
}
