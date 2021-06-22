package com.bytedance.sdk.openadsdk.k;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f29680a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29681b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29682c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29683d;

    /* renamed from: e  reason: collision with root package name */
    public int f29684e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29685f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29686g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29687a;

        /* renamed from: b  reason: collision with root package name */
        public int f29688b;

        public a(String str) {
            this.f29687a = str;
        }

        public void a() {
            l.f29680a.add(this.f29687a);
        }

        public void b() {
            l.f29681b.add(this.f29687a);
        }

        public String toString() {
            return this.f29687a;
        }
    }

    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            this.f29683d = list.size();
            this.f29682c = new ArrayList<>(this.f29683d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29680a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29681b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29682c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29682c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29682c.addAll(arrayList2);
            }
            Integer num = e.f29592i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f29683d >= 2 ? 1 : 2;
            }
            this.f29686g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29685f < this.f29686g;
    }

    public a b() {
        if (a()) {
            int i2 = this.f29684e + 1;
            if (i2 >= this.f29683d - 1) {
                this.f29684e = -1;
                this.f29685f++;
            } else {
                this.f29684e = i2;
            }
            a aVar = this.f29682c.get(i2);
            aVar.f29688b = (this.f29685f * this.f29683d) + this.f29684e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29682c = arrayList;
        arrayList.add(new a(str));
        this.f29683d = 1;
        this.f29686g = 1;
    }
}
