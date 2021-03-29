package d.b.i0.d1.s;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.h0.s.c.o;
import d.b.h0.s.c.p;
/* loaded from: classes3.dex */
public class b {
    public String a(String str) {
        o a2;
        if (str != null) {
            try {
                d.b.h0.r.g0.c.b bVar = new d.b.h0.r.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = FileHelper.getStoreFile(str, 1);
                bVar.a("type", 2);
                p d2 = bVar.d(storeFile);
                if (d2 == null || !d2.d() || (a2 = d2.a()) == null) {
                    return null;
                }
                String b2 = a2.b();
                d.b.h0.r.g0.b.b.b(str, b2);
                return b2;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
