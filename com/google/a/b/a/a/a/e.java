package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import com.baidu.tieba.owb;
/* loaded from: classes9.dex */
public abstract class e extends com.google.a.a.b implements d {
    public e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    @Override // com.google.a.a.b
    public final boolean a(int i, Parcel parcel) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                owb.a(parcel, Bundle.CREATOR);
                a();
            } else {
                b((Bundle) owb.a(parcel, Bundle.CREATOR));
            }
        } else {
            a((Bundle) owb.a(parcel, Bundle.CREATOR));
        }
        return true;
    }
}
