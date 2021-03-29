package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f36901a;

    /* renamed from: b  reason: collision with root package name */
    public int f36902b;

    /* renamed from: c  reason: collision with root package name */
    public long f36903c;

    /* renamed from: d  reason: collision with root package name */
    public long f36904d;

    /* renamed from: e  reason: collision with root package name */
    public long f36905e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f36901a;
    }

    public void a(int i) {
        this.f36901a = i;
    }

    public void a(long j) {
        this.f36903c = j;
    }

    public int b() {
        return this.f36902b;
    }

    public void b(int i) {
        this.f36902b = i;
    }

    public void b(long j) {
        this.f36904d = j;
    }

    public long c() {
        return this.f36903c;
    }

    public void c(long j) {
        this.f36905e = j;
    }

    public long d() {
        return this.f36904d;
    }

    public long e() {
        return this.f36905e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f36901a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f36902b));
        contentValues.put("startOffset", Long.valueOf(this.f36903c));
        contentValues.put("currentOffset", Long.valueOf(this.f36904d));
        contentValues.put("endOffset", Long.valueOf(this.f36905e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f36901a), Integer.valueOf(this.f36902b), Long.valueOf(this.f36903c), Long.valueOf(this.f36905e), Long.valueOf(this.f36904d));
    }
}
