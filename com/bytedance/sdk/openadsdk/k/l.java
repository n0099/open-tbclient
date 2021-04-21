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
    public static final Set<String> f29418a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29419b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29420c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29421d;

    /* renamed from: e  reason: collision with root package name */
    public int f29422e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29423f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29424g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29425a;

        /* renamed from: b  reason: collision with root package name */
        public int f29426b;

        public a(String str) {
            this.f29425a = str;
        }

        public void a() {
            l.f29418a.add(this.f29425a);
        }

        public void b() {
            l.f29419b.add(this.f29425a);
        }

        public String toString() {
            return this.f29425a;
        }
    }

    public l(@NonNull List<String> list) {
        int i;
        if (!list.isEmpty()) {
            this.f29421d = list.size();
            this.f29420c = new ArrayList<>(this.f29421d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29418a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29419b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29420c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29420c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29420c.addAll(arrayList2);
            }
            Integer num = e.i;
            if (num != null && num.intValue() > 0) {
                i = num.intValue();
            } else {
                i = this.f29421d >= 2 ? 1 : 2;
            }
            this.f29424g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29423f < this.f29424g;
    }

    public a b() {
        if (a()) {
            int i = this.f29422e + 1;
            if (i >= this.f29421d - 1) {
                this.f29422e = -1;
                this.f29423f++;
            } else {
                this.f29422e = i;
            }
            a aVar = this.f29420c.get(i);
            aVar.f29426b = (this.f29423f * this.f29421d) + this.f29422e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29420c = arrayList;
        arrayList.add(new a(str));
        this.f29421d = 1;
        this.f29424g = 1;
    }
}
