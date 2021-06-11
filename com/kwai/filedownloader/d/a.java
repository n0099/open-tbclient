package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f37661a;

    /* renamed from: b  reason: collision with root package name */
    public int f37662b;

    /* renamed from: c  reason: collision with root package name */
    public long f37663c;

    /* renamed from: d  reason: collision with root package name */
    public long f37664d;

    /* renamed from: e  reason: collision with root package name */
    public long f37665e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f37661a;
    }

    public void a(int i2) {
        this.f37661a = i2;
    }

    public void a(long j) {
        this.f37663c = j;
    }

    public int b() {
        return this.f37662b;
    }

    public void b(int i2) {
        this.f37662b = i2;
    }

    public void b(long j) {
        this.f37664d = j;
    }

    public long c() {
        return this.f37663c;
    }

    public void c(long j) {
        this.f37665e = j;
    }

    public long d() {
        return this.f37664d;
    }

    public long e() {
        return this.f37665e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f37661a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f37662b));
        contentValues.put("startOffset", Long.valueOf(this.f37663c));
        contentValues.put("currentOffset", Long.valueOf(this.f37664d));
        contentValues.put("endOffset", Long.valueOf(this.f37665e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f37661a), Integer.valueOf(this.f37662b), Long.valueOf(this.f37663c), Long.valueOf(this.f37665e), Long.valueOf(this.f37664d));
    }
}
