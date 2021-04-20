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
    public static final Set<String> f29410a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29411b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29412c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29413d;

    /* renamed from: e  reason: collision with root package name */
    public int f29414e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29415f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29416g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29417a;

        /* renamed from: b  reason: collision with root package name */
        public int f29418b;

        public a(String str) {
            this.f29417a = str;
        }

        public void a() {
            l.f29410a.add(this.f29417a);
        }

        public void b() {
            l.f29411b.add(this.f29417a);
        }

        public String toString() {
            return this.f29417a;
        }
    }

    public l(@NonNull List<String> list) {
        int i;
        if (!list.isEmpty()) {
            this.f29413d = list.size();
            this.f29412c = new ArrayList<>(this.f29413d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29410a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29411b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29412c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29412c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29412c.addAll(arrayList2);
            }
            Integer num = e.i;
            if (num != null && num.intValue() > 0) {
                i = num.intValue();
            } else {
                i = this.f29413d >= 2 ? 1 : 2;
            }
            this.f29416g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29415f < this.f29416g;
    }

    public a b() {
        if (a()) {
            int i = this.f29414e + 1;
            if (i >= this.f29413d - 1) {
                this.f29414e = -1;
                this.f29415f++;
            } else {
                this.f29414e = i;
            }
            a aVar = this.f29412c.get(i);
            aVar.f29418b = (this.f29415f * this.f29413d) + this.f29414e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29412c = arrayList;
        arrayList.add(new a(str));
        this.f29413d = 1;
        this.f29416g = 1;
    }
}
