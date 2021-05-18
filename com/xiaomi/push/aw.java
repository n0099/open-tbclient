package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    public static int f37396a;

    public static ar a(Context context) {
        if (av.m139a(context)) {
            f37396a = 1;
            return new av(context);
        } else if (ap.m135a(context)) {
            f37396a = 2;
            return new ap(context);
        } else if (ay.a(context)) {
            f37396a = 4;
            return new ay(context);
        } else if (bc.a(context)) {
            f37396a = 5;
            return new bc(context);
        } else if (au.a(context)) {
            f37396a = 3;
            return new as(context);
        } else {
            f37396a = 0;
            return new bb();
        }
    }
}
