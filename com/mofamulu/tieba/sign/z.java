package com.mofamulu.tieba.sign;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Comparator {
    final /* synthetic */ AccountSelectBarsToSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(AccountSelectBarsToSignActivity accountSelectBarsToSignActivity) {
        this.a = accountSelectBarsToSignActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(au auVar, au auVar2) {
        return ((auVar2.e ? 10000000 : 0) + auVar2.c) - ((auVar.e ? 10000000 : 0) + auVar.c);
    }
}
