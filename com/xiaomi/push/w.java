package com.xiaomi.push;

import android.content.Context;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class w extends v {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f5125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.f5125a = runnable;
    }

    @Override // com.xiaomi.push.v
    protected void a(Context context) {
        if (this.f5125a != null) {
            this.f5125a.run();
        }
    }
}
