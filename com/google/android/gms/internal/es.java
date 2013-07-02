package com.google.android.gms.internal;

import com.google.android.gms.internal.eq;
import com.google.android.gms.plus.model.people.Person;
/* loaded from: classes.dex */
public final class es extends j implements Person {
    public es(k kVar, int i) {
        super(kVar, i);
    }

    public String a() {
        return d("displayName");
    }

    public String b() {
        return d("personId");
    }

    public Person.Image c() {
        return new eq.d(d("image"));
    }

    public int d() {
        return eq.f.a(d("objectType"));
    }

    public String e() {
        return d("url");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f */
    public Person g() {
        return new eq(a(), b(), (eq.d) c(), d(), e());
    }
}
