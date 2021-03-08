package com.ss.android.a.a.d;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e {
    public String e;
    public boolean g;

    /* renamed from: a  reason: collision with root package name */
    public long f7678a = -1;
    public int b = -1;
    public long c = -1;
    public long d = -1;
    public int f = 0;

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f7678a > eVar.f7678a ? 1 : (this.f7678a == eVar.f7678a ? 0 : -1)) == 0) && (this.b == eVar.b) && ((this.c > eVar.c ? 1 : (this.c == eVar.c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.e) && TextUtils.isEmpty(eVar.e)) || (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(eVar.e) && this.e.equals(eVar.e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7678a), Integer.valueOf(this.b), Long.valueOf(this.c), this.e});
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.f7678a = cVar.g();
            this.b = cVar.q();
            this.d = cVar.eHm();
            this.c = cVar.am();
            this.e = cVar.n();
            com.ss.android.socialbase.downloader.e.a eHX = cVar.eHX();
            if (eHX != null) {
                this.f = eHX.a();
            } else {
                this.f = 0;
            }
            this.g = cVar.x();
        }
    }
}
