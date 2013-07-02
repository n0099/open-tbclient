package com.google.android.gms.internal;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class k implements ae {
    public static final l a = new l();
    private static final a k = new a(new String[0], null) { // from class: com.google.android.gms.internal.k.1
    };
    int b;
    String[] c;
    Bundle d;
    CursorWindow[] e;
    int f;
    Bundle g;
    int[] h;
    int i;
    boolean j = false;

    /* loaded from: classes.dex */
    public class a {
        private final String[] a;
        private final ArrayList b;
        private final String c;
        private final HashMap d;
        private boolean e;
        private String f;

        private a(String[] strArr, String str) {
            this.a = (String[]) x.a(strArr);
            this.b = new ArrayList();
            this.c = str;
            this.d = new HashMap();
            this.e = false;
            this.f = null;
        }
    }

    private void a(String str, int i) {
        if (this.d == null || !this.d.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (e()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.i) {
            throw new CursorIndexOutOfBoundsException(i, this.i);
        }
    }

    public int a(int i) {
        int i2 = 0;
        x.a(i >= 0 && i < this.i);
        while (true) {
            if (i2 >= this.h.length) {
                break;
            } else if (i < this.h[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.h.length ? i2 - 1 : i2;
    }

    public long a(String str, int i, int i2) {
        a(str, i);
        return this.e[i2].getLong(i - this.h[i2], this.d.getInt(str));
    }

    public void a() {
        this.d = new Bundle();
        for (int i = 0; i < this.c.length; i++) {
            this.d.putInt(this.c[i], i);
        }
        this.h = new int[this.e.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.length; i3++) {
            this.h[i3] = i2;
            i2 += this.e[i3].getNumRows();
        }
        this.i = i2;
    }

    public int b() {
        return this.f;
    }

    public int b(String str, int i, int i2) {
        a(str, i);
        return this.e[i2].getInt(i - this.h[i2], this.d.getInt(str));
    }

    public Bundle c() {
        return this.g;
    }

    public String c(String str, int i, int i2) {
        a(str, i);
        return this.e[i2].getString(i - this.h[i2], this.d.getInt(str));
    }

    public int d() {
        return this.i;
    }

    public boolean d(String str, int i, int i2) {
        a(str, i);
        return Long.valueOf(this.e[i2].getLong(i - this.h[i2], this.d.getInt(str))).longValue() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        l lVar = a;
        return 0;
    }

    public boolean e() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    public byte[] e(String str, int i, int i2) {
        a(str, i);
        return this.e[i2].getBlob(i - this.h[i2], this.d.getInt(str));
    }

    public Uri f(String str, int i, int i2) {
        String c = c(str, i, i2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }

    public void f() {
        synchronized (this) {
            if (!this.j) {
                this.j = true;
                for (int i = 0; i < this.e.length; i++) {
                    this.e[i].close();
                }
            }
        }
    }

    public boolean g(String str, int i, int i2) {
        a(str, i);
        return this.e[i2].isNull(i - this.h[i2], this.d.getInt(str));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        l lVar = a;
        l.a(this, parcel, i);
    }
}
