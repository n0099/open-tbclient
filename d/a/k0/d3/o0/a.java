package d.a.k0.d3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.a.k0.d3.o0.d.d;
import d.a.k0.d3.o0.d.e;
import d.a.k0.t1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f53940c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f53941d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f53942e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.d3.o0.d.b f53943a;

    /* renamed from: b  reason: collision with root package name */
    public g f53944b;

    public a(g gVar) {
        this.f53944b = gVar;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            f53941d = 6144000;
        } else {
            f53941d = i2;
        }
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            f53940c = 524288;
        } else {
            f53940c = i2;
        }
    }

    public static void d(int i2) {
        if (i2 <= 0) {
            f53942e = 524288;
        } else {
            f53942e = i2;
        }
    }

    public void a() {
        d.a.k0.d3.o0.d.b bVar = this.f53943a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f53943a = new d(str2, f53942e, this.f53944b);
            } else {
                this.f53943a = new d.a.k0.d3.o0.d.c(str, f53940c, f53941d, this.f53944b);
            }
            this.f53943a.a(eVar);
            return this.f53943a.b(str2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f53944b;
            if (gVar != null) {
                gVar.f(306, -4399, d.a.k0.t1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
