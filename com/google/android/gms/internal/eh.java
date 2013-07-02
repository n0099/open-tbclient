package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.Moment;
/* loaded from: classes.dex */
public final class eh extends j implements Moment {
    private ef c;

    public eh(k kVar, int i) {
        super(kVar, i);
    }

    private ef b() {
        synchronized (this) {
            if (this.c == null) {
                byte[] e = e("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(e, 0, e.length);
                obtain.setDataPosition(0);
                this.c = ef.a.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: a */
    public ef g() {
        return b();
    }
}
