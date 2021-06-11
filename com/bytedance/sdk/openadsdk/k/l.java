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
    public static final Set<String> f29598a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29599b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29600c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29601d;

    /* renamed from: e  reason: collision with root package name */
    public int f29602e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29603f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29604g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29605a;

        /* renamed from: b  reason: collision with root package name */
        public int f29606b;

        public a(String str) {
            this.f29605a = str;
        }

        public void a() {
            l.f29598a.add(this.f29605a);
        }

        public void b() {
            l.f29599b.add(this.f29605a);
        }

        public String toString() {
            return this.f29605a;
        }
    }

    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            this.f29601d = list.size();
            this.f29600c = new ArrayList<>(this.f29601d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29598a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29599b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29600c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29600c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29600c.addAll(arrayList2);
            }
            Integer num = e.f29510i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f29601d >= 2 ? 1 : 2;
            }
            this.f29604g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29603f < this.f29604g;
    }

    public a b() {
        if (a()) {
            int i2 = this.f29602e + 1;
            if (i2 >= this.f29601d - 1) {
                this.f29602e = -1;
                this.f29603f++;
            } else {
                this.f29602e = i2;
            }
            a aVar = this.f29600c.get(i2);
            aVar.f29606b = (this.f29603f * this.f29601d) + this.f29602e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29600c = arrayList;
        arrayList.add(new a(str));
        this.f29601d = 1;
        this.f29604g = 1;
    }
}
