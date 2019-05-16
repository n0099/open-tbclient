package com.vivo.push.b;

import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class m extends s {
    private ArrayList<String> a;

    public m() {
        super(8);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putStringArrayListExtra("tags_list", this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringArrayListExtra("tags_list");
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }
}
