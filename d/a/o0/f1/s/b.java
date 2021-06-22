package d.a.o0.f1.s;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import d.a.n0.s.c.q;
import d.a.n0.s.c.r;
/* loaded from: classes4.dex */
public class b {
    public String a(String str) {
        q a2;
        if (str != null) {
            try {
                d.a.n0.r.g0.c.b bVar = new d.a.n0.r.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = FileHelper.getStoreFile(str, 1);
                bVar.a("type", 2);
                r d2 = bVar.d(storeFile);
                if (d2 == null || !d2.d() || (a2 = d2.a()) == null) {
                    return null;
                }
                String b2 = a2.b();
                d.a.n0.r.g0.b.b.b(str, b2);
                return b2;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
