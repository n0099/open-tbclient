package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f34248a;

    /* renamed from: b  reason: collision with root package name */
    public int f34249b;

    /* renamed from: c  reason: collision with root package name */
    public long f34250c;

    /* renamed from: d  reason: collision with root package name */
    public long f34251d;

    /* renamed from: e  reason: collision with root package name */
    public long f34252e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f34248a;
    }

    public void a(int i2) {
        this.f34248a = i2;
    }

    public void a(long j) {
        this.f34250c = j;
    }

    public int b() {
        return this.f34249b;
    }

    public void b(int i2) {
        this.f34249b = i2;
    }

    public void b(long j) {
        this.f34251d = j;
    }

    public long c() {
        return this.f34250c;
    }

    public void c(long j) {
        this.f34252e = j;
    }

    public long d() {
        return this.f34251d;
    }

    public long e() {
        return this.f34252e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f34248a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f34249b));
        contentValues.put("startOffset", Long.valueOf(this.f34250c));
        contentValues.put("currentOffset", Long.valueOf(this.f34251d));
        contentValues.put("endOffset", Long.valueOf(this.f34252e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f34248a), Integer.valueOf(this.f34249b), Long.valueOf(this.f34250c), Long.valueOf(this.f34252e), Long.valueOf(this.f34251d));
    }
}
