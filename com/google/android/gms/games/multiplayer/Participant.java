package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;
/* loaded from: classes.dex */
public interface Participant extends Parcelable, Freezable {
    int a();

    String b();

    boolean c();

    String d();

    Uri e();

    Uri f();

    String h();

    Player i();
}
