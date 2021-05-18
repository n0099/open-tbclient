package com.vivo.push.b;

import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f36595a;

    public a(boolean z, String str, String str2, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str, str2);
        this.f36595a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(CommandMessage.TYPE_TAGS, this.f36595a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36595a = aVar.b(CommandMessage.TYPE_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
