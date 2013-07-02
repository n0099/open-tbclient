package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
/* loaded from: classes.dex */
public interface Invitation extends Parcelable, Freezable, Participatable {
    Game a();

    String b();

    Participant c();

    long d();

    int e();
}
