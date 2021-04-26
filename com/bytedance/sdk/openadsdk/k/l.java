package com.bytedance.sdk.openadsdk.k;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f30321a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f30322b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f30323c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30324d;

    /* renamed from: e  reason: collision with root package name */
    public int f30325e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f30326f;

    /* renamed from: g  reason: collision with root package name */
    public final int f30327g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f30328a;

        /* renamed from: b  reason: collision with root package name */
        public int f30329b;

        public a(String str) {
            this.f30328a = str;
        }

        public void a() {
            l.f30321a.add(this.f30328a);
        }

        public void b() {
            l.f30322b.add(this.f30328a);
        }

        public String toString() {
            return this.f30328a;
        }
    }

    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            this.f30324d = list.size();
            this.f30323c = new ArrayList<>(this.f30324d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f30321a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f30322b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f30323c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f30323c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f30323c.addAll(arrayList2);
            }
            Integer num = e.f30233i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f30324d >= 2 ? 1 : 2;
            }
            this.f30327g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f30326f < this.f30327g;
    }

    public a b() {
        if (a()) {
            int i2 = this.f30325e + 1;
            if (i2 >= this.f30324d - 1) {
                this.f30325e = -1;
                this.f30326f++;
            } else {
                this.f30325e = i2;
            }
            a aVar = this.f30323c.get(i2);
            aVar.f30329b = (this.f30326f * this.f30324d) + this.f30325e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f30323c = arrayList;
        arrayList.add(new a(str));
        this.f30324d = 1;
        this.f30327g = 1;
    }
}
