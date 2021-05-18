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
    public static final Set<String> f29566a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29567b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29568c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29569d;

    /* renamed from: e  reason: collision with root package name */
    public int f29570e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29571f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29572g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29573a;

        /* renamed from: b  reason: collision with root package name */
        public int f29574b;

        public a(String str) {
            this.f29573a = str;
        }

        public void a() {
            l.f29566a.add(this.f29573a);
        }

        public void b() {
            l.f29567b.add(this.f29573a);
        }

        public String toString() {
            return this.f29573a;
        }
    }

    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            this.f29569d = list.size();
            this.f29568c = new ArrayList<>(this.f29569d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29566a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29567b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29568c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29568c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29568c.addAll(arrayList2);
            }
            Integer num = e.f29478i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f29569d >= 2 ? 1 : 2;
            }
            this.f29572g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29571f < this.f29572g;
    }

    public a b() {
        if (a()) {
            int i2 = this.f29570e + 1;
            if (i2 >= this.f29569d - 1) {
                this.f29570e = -1;
                this.f29571f++;
            } else {
                this.f29570e = i2;
            }
            a aVar = this.f29568c.get(i2);
            aVar.f29574b = (this.f29571f * this.f29569d) + this.f29570e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29568c = arrayList;
        arrayList.add(new a(str));
        this.f29569d = 1;
        this.f29572g = 1;
    }
}
