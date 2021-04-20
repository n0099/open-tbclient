package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f37190a;

    /* renamed from: b  reason: collision with root package name */
    public int f37191b;

    /* renamed from: c  reason: collision with root package name */
    public long f37192c;

    /* renamed from: d  reason: collision with root package name */
    public long f37193d;

    /* renamed from: e  reason: collision with root package name */
    public long f37194e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f37190a;
    }

    public void a(int i) {
        this.f37190a = i;
    }

    public void a(long j) {
        this.f37192c = j;
    }

    public int b() {
        return this.f37191b;
    }

    public void b(int i) {
        this.f37191b = i;
    }

    public void b(long j) {
        this.f37193d = j;
    }

    public long c() {
        return this.f37192c;
    }

    public void c(long j) {
        this.f37194e = j;
    }

    public long d() {
        return this.f37193d;
    }

    public long e() {
        return this.f37194e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f37190a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f37191b));
        contentValues.put("startOffset", Long.valueOf(this.f37192c));
        contentValues.put("currentOffset", Long.valueOf(this.f37193d));
        contentValues.put("endOffset", Long.valueOf(this.f37194e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f37190a), Integer.valueOf(this.f37191b), Long.valueOf(this.f37192c), Long.valueOf(this.f37194e), Long.valueOf(this.f37193d));
    }
}
