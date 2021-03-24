package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f36900a;

    /* renamed from: b  reason: collision with root package name */
    public int f36901b;

    /* renamed from: c  reason: collision with root package name */
    public long f36902c;

    /* renamed from: d  reason: collision with root package name */
    public long f36903d;

    /* renamed from: e  reason: collision with root package name */
    public long f36904e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f36900a;
    }

    public void a(int i) {
        this.f36900a = i;
    }

    public void a(long j) {
        this.f36902c = j;
    }

    public int b() {
        return this.f36901b;
    }

    public void b(int i) {
        this.f36901b = i;
    }

    public void b(long j) {
        this.f36903d = j;
    }

    public long c() {
        return this.f36902c;
    }

    public void c(long j) {
        this.f36904e = j;
    }

    public long d() {
        return this.f36903d;
    }

    public long e() {
        return this.f36904e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f36900a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f36901b));
        contentValues.put("startOffset", Long.valueOf(this.f36902c));
        contentValues.put("currentOffset", Long.valueOf(this.f36903d));
        contentValues.put("endOffset", Long.valueOf(this.f36904e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f36900a), Integer.valueOf(this.f36901b), Long.valueOf(this.f36902c), Long.valueOf(this.f36904e), Long.valueOf(this.f36903d));
    }
}
