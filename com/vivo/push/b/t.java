package com.vivo.push.b;

import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class t extends s {
    private ArrayList<String> a;
    private ArrayList<String> b;

    public t(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putStringArrayListExtra("content", this.a);
        intent.putStringArrayListExtra(PushConstants.EXTRA_ERROR_CODE, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringArrayListExtra("content");
        this.b = intent.getStringArrayListExtra(PushConstants.EXTRA_ERROR_CODE);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
