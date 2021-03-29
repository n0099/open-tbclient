package com.kwad.sdk.contentalliance.detail.photo.comment;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f32247a = new HashSet();

    public static void a(long j, long j2) {
        f32247a.add(d(j, j2));
    }

    public static void b(long j, long j2) {
        f32247a.remove(d(j, j2));
    }

    public static boolean c(long j, long j2) {
        return f32247a.contains(d(j, j2));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v0 long), (r3v0 long)] */
    public static String d(long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(j2);
        return sb.toString();
    }
}
