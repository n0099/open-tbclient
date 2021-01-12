package com.vivo.push.b;

import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f13565a;

    public a(boolean z, String str, String str2, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str, str2);
        this.f13565a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(CommandMessage.TYPE_TAGS, this.f13565a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13565a = aVar.b(CommandMessage.TYPE_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
