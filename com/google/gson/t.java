package com.google.gson;

import java.util.Set;
/* loaded from: classes.dex */
public final class t extends r {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.q f1680a = new com.google.gson.internal.q();

    public void a(String str, r rVar) {
        if (rVar == null) {
            rVar = s.f1672a;
        }
        this.f1680a.put((String) com.google.gson.internal.a.a(str), (Object) rVar);
    }

    public Set o() {
        return this.f1680a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof t) && ((t) obj).f1680a.equals(this.f1680a));
    }

    public int hashCode() {
        return this.f1680a.hashCode();
    }
}
