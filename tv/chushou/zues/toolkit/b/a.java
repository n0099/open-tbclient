package tv.chushou.zues.toolkit.b;

import tv.chushou.a.a.d.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public interface a {
    public static final a nVN = new a() { // from class: tv.chushou.zues.toolkit.b.a.1
        @Override // tv.chushou.zues.toolkit.b.a
        public String SG(String str) {
            return h.isEmpty(str) ? "" : b.encrypt(str);
        }
    };

    String SG(String str);
}
