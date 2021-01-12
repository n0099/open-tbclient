package com.kwad.sdk.contentalliance.detail.photo.comment;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f8449a = new HashSet();

    public static void a(long j, long j2) {
        f8449a.add(d(j, j2));
    }

    public static void b(long j, long j2) {
        f8449a.remove(d(j, j2));
    }

    public static boolean c(long j, long j2) {
        return f8449a.contains(d(j, j2));
    }

    private static String d(long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j).append(j2);
        return sb.toString();
    }
}
