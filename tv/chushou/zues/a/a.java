package tv.chushou.zues.a;

import tv.chushou.basis.rxjava.RxBus;
/* loaded from: classes5.dex */
public class a {
    public static void post(Object obj) {
        RxBus.get().post(obj);
    }

    public static void register(Object obj) {
        RxBus.get().register(obj);
    }

    public static void ch(Object obj) {
        RxBus.get().unregister(obj);
    }
}
