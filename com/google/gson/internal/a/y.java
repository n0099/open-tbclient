package com.google.gson.internal.a;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.aa f1642a = new z();
    public static final com.google.gson.ab b = a(Class.class, f1642a);
    public static final com.google.gson.aa c = new ak();
    public static final com.google.gson.ab d = a(BitSet.class, c);
    public static final com.google.gson.aa e = new av();
    public static final com.google.gson.aa f = new az();
    public static final com.google.gson.ab g = a(Boolean.TYPE, Boolean.class, e);
    public static final com.google.gson.aa h = new ba();
    public static final com.google.gson.ab i = a(Byte.TYPE, Byte.class, h);
    public static final com.google.gson.aa j = new bb();
    public static final com.google.gson.ab k = a(Short.TYPE, Short.class, j);
    public static final com.google.gson.aa l = new bc();
    public static final com.google.gson.ab m = a(Integer.TYPE, Integer.class, l);
    public static final com.google.gson.aa n = new bd();
    public static final com.google.gson.aa o = new be();
    public static final com.google.gson.aa p = new aa();
    public static final com.google.gson.aa q = new ab();
    public static final com.google.gson.ab r = a(Number.class, q);
    public static final com.google.gson.aa s = new ac();
    public static final com.google.gson.ab t = a(Character.TYPE, Character.class, s);
    public static final com.google.gson.aa u = new ad();
    public static final com.google.gson.aa v = new ae();
    public static final com.google.gson.aa w = new af();
    public static final com.google.gson.ab x = a(String.class, u);
    public static final com.google.gson.aa y = new ag();
    public static final com.google.gson.ab z = a(StringBuilder.class, y);
    public static final com.google.gson.aa A = new ah();
    public static final com.google.gson.ab B = a(StringBuffer.class, A);
    public static final com.google.gson.aa C = new ai();
    public static final com.google.gson.ab D = a(URL.class, C);
    public static final com.google.gson.aa E = new aj();
    public static final com.google.gson.ab F = a(URI.class, E);
    public static final com.google.gson.aa G = new al();
    public static final com.google.gson.ab H = b(InetAddress.class, G);
    public static final com.google.gson.aa I = new am();
    public static final com.google.gson.ab J = a(UUID.class, I);
    public static final com.google.gson.ab K = new an();
    public static final com.google.gson.aa L = new ap();
    public static final com.google.gson.ab M = b(Calendar.class, GregorianCalendar.class, L);
    public static final com.google.gson.aa N = new aq();
    public static final com.google.gson.ab O = a(Locale.class, N);
    public static final com.google.gson.aa P = new ar();
    public static final com.google.gson.ab Q = a(com.google.gson.r.class, P);
    public static final com.google.gson.ab R = a();

    public static com.google.gson.ab a() {
        return new as();
    }

    public static com.google.gson.ab a(Class cls, com.google.gson.aa aaVar) {
        return new at(cls, aaVar);
    }

    public static com.google.gson.ab a(Class cls, Class cls2, com.google.gson.aa aaVar) {
        return new au(cls, cls2, aaVar);
    }

    public static com.google.gson.ab b(Class cls, Class cls2, com.google.gson.aa aaVar) {
        return new aw(cls, cls2, aaVar);
    }

    public static com.google.gson.ab b(Class cls, com.google.gson.aa aaVar) {
        return new ax(cls, aaVar);
    }
}
