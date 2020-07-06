package tv.chushou.zues.toolkit.b;

import tv.chushou.a.a.d.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public interface a {
    public static final a okv = new a() { // from class: tv.chushou.zues.toolkit.b.a.1
        @Override // tv.chushou.zues.toolkit.b.a
        public String Te(String str) {
            return h.isEmpty(str) ? "" : b.encrypt(str);
        }
    };

    String Te(String str);
}
