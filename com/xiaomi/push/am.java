package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.al;
/* loaded from: classes7.dex */
public class am extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ al f40230a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, Looper looper) {
        super(looper);
        this.f40230a = alVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        al.b bVar = (al.b) message.obj;
        int i = message.what;
        if (i == 0) {
            bVar.a();
        } else if (i == 1) {
            bVar.mo223c();
        }
        super.handleMessage(message);
    }
}
