package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f34177a;

    /* renamed from: b  reason: collision with root package name */
    public int f34178b;

    /* renamed from: c  reason: collision with root package name */
    public long f34179c;

    /* renamed from: d  reason: collision with root package name */
    public long f34180d;

    /* renamed from: e  reason: collision with root package name */
    public long f34181e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f34177a;
    }

    public void a(int i2) {
        this.f34177a = i2;
    }

    public void a(long j) {
        this.f34179c = j;
    }

    public int b() {
        return this.f34178b;
    }

    public void b(int i2) {
        this.f34178b = i2;
    }

    public void b(long j) {
        this.f34180d = j;
    }

    public long c() {
        return this.f34179c;
    }

    public void c(long j) {
        this.f34181e = j;
    }

    public long d() {
        return this.f34180d;
    }

    public long e() {
        return this.f34181e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f34177a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f34178b));
        contentValues.put("startOffset", Long.valueOf(this.f34179c));
        contentValues.put("currentOffset", Long.valueOf(this.f34180d));
        contentValues.put("endOffset", Long.valueOf(this.f34181e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f34177a), Integer.valueOf(this.f34178b), Long.valueOf(this.f34179c), Long.valueOf(this.f34181e), Long.valueOf(this.f34180d));
    }
}
