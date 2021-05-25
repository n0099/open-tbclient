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
    public static final Set<String> f29495a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f29496b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f29497c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29498d;

    /* renamed from: e  reason: collision with root package name */
    public int f29499e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29500f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29501g;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f29502a;

        /* renamed from: b  reason: collision with root package name */
        public int f29503b;

        public a(String str) {
            this.f29502a = str;
        }

        public void a() {
            l.f29495a.add(this.f29502a);
        }

        public void b() {
            l.f29496b.add(this.f29502a);
        }

        public String toString() {
            return this.f29502a;
        }
    }

    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            this.f29498d = list.size();
            this.f29497c = new ArrayList<>(this.f29498d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (f29495a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f29496b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f29497c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f29497c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f29497c.addAll(arrayList2);
            }
            Integer num = e.f29407i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f29498d >= 2 ? 1 : 2;
            }
            this.f29501g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        return this.f29500f < this.f29501g;
    }

    public a b() {
        if (a()) {
            int i2 = this.f29499e + 1;
            if (i2 >= this.f29498d - 1) {
                this.f29499e = -1;
                this.f29500f++;
            } else {
                this.f29499e = i2;
            }
            a aVar = this.f29497c.get(i2);
            aVar.f29503b = (this.f29500f * this.f29498d) + this.f29499e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f29497c = arrayList;
        arrayList.add(new a(str));
        this.f29498d = 1;
        this.f29501g = 1;
    }
}
