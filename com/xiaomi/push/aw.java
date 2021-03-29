package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    public static int f40252a;

    public static ar a(Context context) {
        if (av.m133a(context)) {
            f40252a = 1;
            return new av(context);
        } else if (ap.m129a(context)) {
            f40252a = 2;
            return new ap(context);
        } else if (ay.a(context)) {
            f40252a = 4;
            return new ay(context);
        } else if (bc.a(context)) {
            f40252a = 5;
            return new bc(context);
        } else if (au.a(context)) {
            f40252a = 3;
            return new as(context);
        } else {
            f40252a = 0;
            return new bb();
        }
    }
}
