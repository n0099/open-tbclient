package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f37759a;

    /* renamed from: b  reason: collision with root package name */
    public int f37760b;

    /* renamed from: c  reason: collision with root package name */
    public long f37761c;

    /* renamed from: d  reason: collision with root package name */
    public long f37762d;

    /* renamed from: e  reason: collision with root package name */
    public long f37763e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f37759a;
    }

    public void a(int i2) {
        this.f37759a = i2;
    }

    public void a(long j) {
        this.f37761c = j;
    }

    public int b() {
        return this.f37760b;
    }

    public void b(int i2) {
        this.f37760b = i2;
    }

    public void b(long j) {
        this.f37762d = j;
    }

    public long c() {
        return this.f37761c;
    }

    public void c(long j) {
        this.f37763e = j;
    }

    public long d() {
        return this.f37762d;
    }

    public long e() {
        return this.f37763e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f37759a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f37760b));
        contentValues.put("startOffset", Long.valueOf(this.f37761c));
        contentValues.put("currentOffset", Long.valueOf(this.f37762d));
        contentValues.put("endOffset", Long.valueOf(this.f37763e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f37759a), Integer.valueOf(this.f37760b), Long.valueOf(this.f37761c), Long.valueOf(this.f37763e), Long.valueOf(this.f37762d));
    }
}
