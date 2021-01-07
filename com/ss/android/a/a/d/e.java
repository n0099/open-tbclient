package com.ss.android.a.a.d;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class e {
    public String e;
    public boolean g;

    /* renamed from: a  reason: collision with root package name */
    public long f13205a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f13206b = -1;
    public long c = -1;
    public long d = -1;
    public int f = 0;

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f13205a > eVar.f13205a ? 1 : (this.f13205a == eVar.f13205a ? 0 : -1)) == 0) && (this.f13206b == eVar.f13206b) && ((this.c > eVar.c ? 1 : (this.c == eVar.c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.e) && TextUtils.isEmpty(eVar.e)) || (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(eVar.e) && this.e.equals(eVar.e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f13205a), Integer.valueOf(this.f13206b), Long.valueOf(this.c), this.e});
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.f13205a = cVar.g();
            this.f13206b = cVar.q();
            this.d = cVar.eIz();
            this.c = cVar.ejL();
            this.e = cVar.n();
            com.ss.android.socialbase.downloader.e.a eJm = cVar.eJm();
            if (eJm != null) {
                this.f = eJm.a();
            } else {
                this.f = 0;
            }
            this.g = cVar.x();
        }
    }
}
