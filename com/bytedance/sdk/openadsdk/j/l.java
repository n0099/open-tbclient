package com.bytedance.sdk.openadsdk.j;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7307a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f7308b = new HashSet();
    private final ArrayList<a> c;
    private final int d;
    private int e;
    private int f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(@NonNull List<String> list) {
        int i;
        ArrayList arrayList;
        this.e = -1;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        this.d = list.size();
        this.c = new ArrayList<>(this.d);
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        for (String str : list) {
            a aVar = new a(str);
            if (f7307a.contains(str)) {
                arrayList3 = arrayList3 == null ? new ArrayList() : arrayList3;
                arrayList3.add(aVar);
                arrayList = arrayList2;
            } else if (f7308b.contains(str)) {
                arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList.add(aVar);
            } else {
                this.c.add(aVar);
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 != null) {
            this.c.addAll(arrayList2);
        }
        if (arrayList3 != null) {
            this.c.addAll(arrayList3);
        }
        Integer num = e.i;
        if (num == null || num.intValue() <= 0) {
            i = this.d >= 2 ? 1 : 2;
        } else {
            i = num.intValue();
        }
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(@NonNull String str) {
        this.e = -1;
        this.c = new ArrayList<>(1);
        this.c.add(new a(str));
        this.d = 1;
        this.g = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f < this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        int i = this.e + 1;
        if (i >= this.d - 1) {
            this.e = -1;
            this.f++;
        } else {
            this.e = i;
        }
        a aVar = this.c.get(i);
        aVar.f7310b = (this.f * this.d) + this.e;
        return aVar;
    }

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        final String f7309a;

        /* renamed from: b  reason: collision with root package name */
        int f7310b;

        a(String str) {
            this.f7309a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            l.f7307a.add(this.f7309a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            l.f7308b.add(this.f7309a);
        }

        public String toString() {
            return this.f7309a;
        }
    }
}
