package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f32087a;

    /* renamed from: b  reason: collision with root package name */
    public final char f32088b;

    /* renamed from: c  reason: collision with root package name */
    public final double f32089c;

    /* renamed from: d  reason: collision with root package name */
    public final double f32090d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32091e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32092f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f32087a = list;
        this.f32088b = c2;
        this.f32089c = d2;
        this.f32090d = d3;
        this.f32091e = str;
        this.f32092f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f32087a;
    }

    public double b() {
        return this.f32090d;
    }

    public int hashCode() {
        return a(this.f32088b, this.f32092f, this.f32091e);
    }
}
