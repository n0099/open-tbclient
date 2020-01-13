package com.vivo.push.b;

import com.coloros.mcssdk.mode.CommandMessage;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class ab extends c {
    private ArrayList<String> a;

    public ab(boolean z, String str, String str2, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str, str2);
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(CommandMessage.TYPE_TAGS, (Serializable) this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.b(CommandMessage.TYPE_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "TagCommand";
    }
}
