package com.vivo.push.b;

import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class a extends c {
    private ArrayList<String> a;

    public a(boolean z, String str, String str2, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str, str2);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putStringArrayListExtra(CommandMessage.TYPE_TAGS, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringArrayListExtra(CommandMessage.TYPE_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
