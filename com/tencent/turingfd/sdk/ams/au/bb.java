package com.tencent.turingfd.sdk.ams.au;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f13806a = {y.a(y.o), y.a(y.p), y.a(y.q), y.a(y.r), y.a(y.s), y.a(y.t), y.a(y.u), y.a(y.v), y.a(y.w), y.a(y.x), y.a(y.y), y.a(y.z), y.a(y.A), y.a(y.B), y.a(y.C), y.a(y.D), y.a(y.E), y.a(y.F), y.a(y.G), y.a(y.H), y.a(y.I)};

    public static Set<String> a(Set<String> set) {
        HashSet hashSet = new HashSet();
        for (String str : set) {
            for (String str2 : f13806a) {
                if (Pattern.compile(str2).matcher(str).find()) {
                    hashSet.add(str);
                }
            }
        }
        set.removeAll(hashSet);
        return set;
    }
}
