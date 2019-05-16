package com.vivo.push.b;

import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class aa extends c {
    private ArrayList<String> a;

    public aa(boolean z, String str, String str2, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str, str2);
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra(CommandMessage.TYPE_TAGS, this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringArrayListExtra(CommandMessage.TYPE_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }
}
