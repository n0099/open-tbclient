package com.xiaomi.metoknlp.b;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d extends Handler {
    final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Looper looper) {
        super(looper);
        this.a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        List list;
        List<a> list2;
        List list3;
        List<a> list4;
        switch (message.what) {
            case 200:
                list3 = this.a.d;
                synchronized (list3) {
                    list4 = this.a.d;
                    for (a aVar : list4) {
                        aVar.a((NetworkInfo) message.obj);
                    }
                }
                return;
            case 201:
                list = this.a.d;
                synchronized (list) {
                    list2 = this.a.d;
                    for (a aVar2 : list2) {
                        aVar2.b((NetworkInfo) message.obj);
                    }
                }
                return;
            default:
                return;
        }
    }
}
