package com.kwai.filedownloader.d;

import android.content.ContentValues;
import com.kwai.filedownloader.f.f;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f35003a;

    /* renamed from: b  reason: collision with root package name */
    public int f35004b;

    /* renamed from: c  reason: collision with root package name */
    public long f35005c;

    /* renamed from: d  reason: collision with root package name */
    public long f35006d;

    /* renamed from: e  reason: collision with root package name */
    public long f35007e;

    public static long a(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.d() - aVar.c();
        }
        return j;
    }

    public int a() {
        return this.f35003a;
    }

    public void a(int i2) {
        this.f35003a = i2;
    }

    public void a(long j) {
        this.f35005c = j;
    }

    public int b() {
        return this.f35004b;
    }

    public void b(int i2) {
        this.f35004b = i2;
    }

    public void b(long j) {
        this.f35006d = j;
    }

    public long c() {
        return this.f35005c;
    }

    public void c(long j) {
        this.f35007e = j;
    }

    public long d() {
        return this.f35006d;
    }

    public long e() {
        return this.f35007e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f35003a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f35004b));
        contentValues.put("startOffset", Long.valueOf(this.f35005c));
        contentValues.put("currentOffset", Long.valueOf(this.f35006d));
        contentValues.put("endOffset", Long.valueOf(this.f35007e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f35003a), Integer.valueOf(this.f35004b), Long.valueOf(this.f35005c), Long.valueOf(this.f35007e), Long.valueOf(this.f35006d));
    }
}
