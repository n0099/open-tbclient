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
    public static final Set<String> f29725a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29726b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29727c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29728d;

    /* renamed from: e  reason: collision with root package name */
    public int f29729e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29730f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29731g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29732a;

        /* renamed from: b  reason: collision with root package name */
        public int f29733b;

        public a(String str) {
            this.f29732a = str;
        }

        public void a() {
            l.f29725a.add(this.f29732a);
        }

        public void b() {
            l.f29726b.add(this.f29732a);
        }

        public String toString() {
            return this.f29732a;
        }
    }

    public l(@NonNull List<String> list) {
        int i;
        if (!list.isEmpty()) {
            this.f29728d = list.size();
            this.f29727c = new ArrayList<>(this.f29728d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29725a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29726b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29727c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29727c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29727c.addAll(arrayList2);
            }
            Integer num = e.i;
            if (num != null && num.intValue() > 0) {
                i = num.intValue();
            } else {
                i = this.f29728d >= 2 ? 1 : 2;
            }
            this.f29731g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29730f < this.f29731g;
    }

    public a b() {
        if (a()) {
            int i = this.f29729e + 1;
            if (i >= this.f29728d - 1) {
                this.f29729e = -1;
                this.f29730f++;
            } else {
                this.f29729e = i;
            }
            a aVar = this.f29727c.get(i);
            aVar.f29733b = (this.f29730f * this.f29728d) + this.f29729e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29727c = arrayList;
        arrayList.add(new a(str));
        this.f29728d = 1;
        this.f29731g = 1;
    }
}
