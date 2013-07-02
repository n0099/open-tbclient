package com.mofamulu.tieba.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.mofamulu.tieba.sign.ab {
    final /* synthetic */ NickBinder a;
    private long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(NickBinder nickBinder, String str, int i) {
        super(str, i);
        this.a = nickBinder;
        this.c = System.currentTimeMillis();
    }

    @Override // com.mofamulu.tieba.sign.ab
    protected boolean a() {
        if (System.currentTimeMillis() - com.mofamulu.tieba.dslv.lock.a.c > 1200000) {
            com.mofamulu.tieba.dslv.lock.a.c = System.currentTimeMillis();
            NickService.b();
        } else if (this.a.a()) {
            int q = this.a.a.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.c >= q * 60000) {
                this.a.a(false);
                this.c = currentTimeMillis;
            }
        }
        return false;
    }

    @Override // com.mofamulu.tieba.sign.ab
    protected int b() {
        return 30000;
    }
}
