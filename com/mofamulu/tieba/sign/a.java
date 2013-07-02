package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class a extends com.mofamulu.tieba.ch.aa {
    protected SignServiceBinder g;
    private c j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = SignService.a();
        if (this.g == null) {
            this.k = true;
            if (this.j == null) {
                this.j = new c(this);
                bindService(new Intent(this, SignService.class), this.j, 1);
                return;
            }
            return;
        }
        com.mofamulu.tieba.ch.a.a(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.g == null) {
            this.k = true;
            if (this.j == null) {
                this.j = new c(this);
                bindService(new Intent(this, SignService.class), this.j, 1);
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.k && this.j != null) {
            this.k = false;
            unbindService(this.j);
            this.j = null;
            this.g = null;
        }
    }
}
