package com.qq.e.comm.plugin.y;

import android.content.Context;
import com.alibaba.fastjson.asm.Opcodes;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.n;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
abstract class a<T extends n> {

    /* renamed from: a  reason: collision with root package name */
    Context f12696a;

    /* renamed from: b  reason: collision with root package name */
    List<T> f12697b = new LinkedList();
    private long c = 0;

    public a(Context context) {
        this.f12696a = context;
    }

    private void e(List<T> list) {
        gdtadv.getVresult(Opcodes.IFEQ, 0, this, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ArrayList arrayList = new ArrayList(this.f12697b);
        this.f12697b.clear();
        d(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(T t) {
        if (t == null) {
            return;
        }
        if (this.f12697b.size() >= 1000) {
            Iterator<T> it = this.f12697b.iterator();
            for (int size = (this.f12697b.size() - 1000) + 1; size > 0 && it.hasNext(); size--) {
                it.next();
                it.remove();
            }
        }
        this.f12697b.add(t);
        GDTLogger.d("Add stat data: " + t + ", total: " + this.f12697b.size());
    }

    void a(List<T> list) {
        GDTLogger.d("Send stat success");
        this.c = System.currentTimeMillis() / 1000;
        HashSet hashSet = new HashSet();
        for (T t : list) {
            if (t != null) {
                if (t.a() >= 0) {
                    hashSet.add(Integer.valueOf(t.a()));
                }
                this.f12697b.remove(t);
            }
        }
        a(hashSet);
    }

    abstract void a(Set<Integer> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        ai.a("Start commit stat data", new Object[0]);
        List<T> arrayList = new ArrayList<>(this.f12697b);
        List<T> f = f();
        if (f != null && f.size() > 0) {
            arrayList.addAll(f);
        }
        if (arrayList.size() > 0) {
            e(arrayList);
        }
    }

    void b(List<T> list) {
        GDTLogger.d("Send stat failed");
    }

    long c() {
        return this.c;
    }

    abstract void c(List<T> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (e()) {
            b();
        }
    }

    abstract void d(List<T> list);

    abstract boolean e();

    abstract List<T> f();
}
