package com.google.android.gms.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
/* loaded from: classes.dex */
public final class by extends m {
    public by(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.m
    /* renamed from: a */
    public Room b(int i, int i2) {
        return new bz(this.a, i, i2);
    }

    @Override // com.google.android.gms.internal.m
    protected String c() {
        return "external_match_id";
    }
}
