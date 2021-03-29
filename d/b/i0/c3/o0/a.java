package d.b.i0.c3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.i0.c3.o0.d.d;
import d.b.i0.c3.o0.d.e;
import d.b.i0.s1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f53527c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f53528d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f53529e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.c3.o0.d.b f53530a;

    /* renamed from: b  reason: collision with root package name */
    public g f53531b;

    public a(g gVar) {
        this.f53531b = gVar;
    }

    public static void b(int i) {
        if (i <= 0) {
            f53528d = 6144000;
        } else {
            f53528d = i;
        }
    }

    public static void c(int i) {
        if (i <= 0) {
            f53527c = 524288;
        } else {
            f53527c = i;
        }
    }

    public static void d(int i) {
        if (i <= 0) {
            f53529e = 524288;
        } else {
            f53529e = i;
        }
    }

    public void a() {
        d.b.i0.c3.o0.d.b bVar = this.f53530a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f53530a = new d(str2, f53529e, this.f53531b);
            } else {
                this.f53530a = new d.b.i0.c3.o0.d.c(str, f53527c, f53528d, this.f53531b);
            }
            this.f53530a.b(eVar);
            return this.f53530a.a(str2, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f53531b;
            if (gVar != null) {
                gVar.d(306, -4399, d.b.i0.s1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
