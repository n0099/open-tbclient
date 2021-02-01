package com.ss.android.a.a.d;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e {
    public String e;
    public boolean g;

    /* renamed from: a  reason: collision with root package name */
    public long f12907a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f12908b = -1;
    public long c = -1;
    public long d = -1;
    public int f = 0;

    public boolean equals(Object obj) {
        if ((obj instanceof e) && obj != null) {
            e eVar = (e) obj;
            return ((this.f12907a > eVar.f12907a ? 1 : (this.f12907a == eVar.f12907a ? 0 : -1)) == 0) && (this.f12908b == eVar.f12908b) && ((this.c > eVar.c ? 1 : (this.c == eVar.c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.e) && TextUtils.isEmpty(eVar.e)) || (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(eVar.e) && this.e.equals(eVar.e)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12907a), Integer.valueOf(this.f12908b), Long.valueOf(this.c), this.e});
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.f12907a = cVar.g();
            this.f12908b = cVar.q();
            this.d = cVar.eHa();
            this.c = cVar.eij();
            this.e = cVar.n();
            com.ss.android.socialbase.downloader.e.a eHN = cVar.eHN();
            if (eHN != null) {
                this.f = eHN.a();
            } else {
                this.f = 0;
            }
            this.g = cVar.x();
        }
    }
}
