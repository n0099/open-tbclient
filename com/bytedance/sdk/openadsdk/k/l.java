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
    public static final Set<String> f29724a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29725b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29726c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29727d;

    /* renamed from: e  reason: collision with root package name */
    public int f29728e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29729f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29730g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29731a;

        /* renamed from: b  reason: collision with root package name */
        public int f29732b;

        public a(String str) {
            this.f29731a = str;
        }

        public void a() {
            l.f29724a.add(this.f29731a);
        }

        public void b() {
            l.f29725b.add(this.f29731a);
        }

        public String toString() {
            return this.f29731a;
        }
    }

    public l(@NonNull List<String> list) {
        int i;
        if (!list.isEmpty()) {
            this.f29727d = list.size();
            this.f29726c = new ArrayList<>(this.f29727d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29724a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29725b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29726c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29726c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29726c.addAll(arrayList2);
            }
            Integer num = e.i;
            if (num != null && num.intValue() > 0) {
                i = num.intValue();
            } else {
                i = this.f29727d >= 2 ? 1 : 2;
            }
            this.f29730g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29729f < this.f29730g;
    }

    public a b() {
        if (a()) {
            int i = this.f29728e + 1;
            if (i >= this.f29727d - 1) {
                this.f29728e = -1;
                this.f29729f++;
            } else {
                this.f29728e = i;
            }
            a aVar = this.f29726c.get(i);
            aVar.f29732b = (this.f29729f * this.f29727d) + this.f29728e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29726c = arrayList;
        arrayList.add(new a(str));
        this.f29727d = 1;
        this.f29730g = 1;
    }
}
