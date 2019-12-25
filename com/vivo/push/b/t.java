package com.vivo.push.b;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
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
    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a(PushConstants.EXTRA_ERROR_CODE, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.b("content");
        this.b = aVar.b(PushConstants.EXTRA_ERROR_CODE);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
