package tv.chushou.zues.toolkit.b;

import tv.chushou.a.a.d.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public interface a {
    public static final a nYC = new a() { // from class: tv.chushou.zues.toolkit.b.a.1
        @Override // tv.chushou.zues.toolkit.b.a
        public String SR(String str) {
            return h.isEmpty(str) ? "" : b.encrypt(str);
        }
    };

    String SR(String str);
}
