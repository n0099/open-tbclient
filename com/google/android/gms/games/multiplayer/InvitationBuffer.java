package com.google.android.gms.games.multiplayer;

import com.google.android.gms.internal.bw;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.m;
/* loaded from: classes.dex */
public final class InvitationBuffer extends m {
    public InvitationBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.m
    /* renamed from: a */
    public Invitation b(int i, int i2) {
        return new bw(this.a, i, i2);
    }

    @Override // com.google.android.gms.internal.m
    protected String c() {
        return "external_invitation_id";
    }
}
