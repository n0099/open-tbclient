package com.mofamulu.tieba.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements y {
    final /* synthetic */ u a;
    private final /* synthetic */ MoreVipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, MoreVipActivity moreVipActivity) {
        this.a = uVar;
        this.b = moreVipActivity;
    }

    @Override // com.mofamulu.tieba.ch.y
    public String a(int i, String str, String str2) {
        return str;
    }

    @Override // com.mofamulu.tieba.ch.y
    public void a(String str) {
        this.b.c(str);
    }
}
