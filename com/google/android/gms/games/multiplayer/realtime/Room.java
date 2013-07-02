package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.multiplayer.Participatable;
/* loaded from: classes.dex */
public interface Room extends Parcelable, Freezable, Participatable {
    String a();

    String b();

    long c();

    int d();

    String e();

    int h();

    Bundle i();
}
