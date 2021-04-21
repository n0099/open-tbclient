package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f37285a;

    /* renamed from: b  reason: collision with root package name */
    public int f37286b;

    /* renamed from: c  reason: collision with root package name */
    public long f37287c;

    /* renamed from: d  reason: collision with root package name */
    public long f37288d;

    /* renamed from: e  reason: collision with root package name */
    public long f37289e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f37285a;
    }

    public void a(int i) {
        this.f37285a = i;
    }

    public void a(long j) {
        this.f37287c = j;
    }

    public int b() {
        return this.f37286b;
    }

    public void b(int i) {
        this.f37286b = i;
    }

    public void b(long j) {
        this.f37288d = j;
    }

    public long c() {
        return this.f37287c;
    }

    public void c(long j) {
        this.f37289e = j;
    }

    public long d() {
        return this.f37288d;
    }

    public long e() {
        return this.f37289e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f37285a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f37286b));
        contentValues.put("startOffset", Long.valueOf(this.f37287c));
        contentValues.put("currentOffset", Long.valueOf(this.f37288d));
        contentValues.put("endOffset", Long.valueOf(this.f37289e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f37285a), Integer.valueOf(this.f37286b), Long.valueOf(this.f37287c), Long.valueOf(this.f37289e), Long.valueOf(this.f37288d));
    }
}
