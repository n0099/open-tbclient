package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f11185a;

    /* renamed from: b  reason: collision with root package name */
    private int f11186b;
    private long c;
    private long d;
    private long e;

    public static long a(List<a> list) {
        long j = 0;
        Iterator<a> it = list.iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            a next = it.next();
            j = (next.d() - next.c()) + j2;
        }
    }

    public int a() {
        return this.f11185a;
    }

    public void a(int i) {
        this.f11185a = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public int b() {
        return this.f11186b;
    }

    public void b(int i) {
        this.f11186b = i;
    }

    public void b(long j) {
        this.d = j;
    }

    public long c() {
        return this.c;
    }

    public void c(long j) {
        this.e = j;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f11185a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f11186b));
        contentValues.put("startOffset", Long.valueOf(this.c));
        contentValues.put("currentOffset", Long.valueOf(this.d));
        contentValues.put("endOffset", Long.valueOf(this.e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f11185a), Integer.valueOf(this.f11186b), Long.valueOf(this.c), Long.valueOf(this.e), Long.valueOf(this.d));
    }
}
