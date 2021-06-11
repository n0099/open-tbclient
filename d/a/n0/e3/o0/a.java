package d.a.n0.e3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.a.n0.e3.o0.d.d;
import d.a.n0.e3.o0.d.e;
import d.a.n0.u1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f57842c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f57843d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f57844e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e3.o0.d.b f57845a;

    /* renamed from: b  reason: collision with root package name */
    public g f57846b;

    public a(g gVar) {
        this.f57846b = gVar;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            f57843d = 6144000;
        } else {
            f57843d = i2;
        }
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            f57842c = 524288;
        } else {
            f57842c = i2;
        }
    }

    public static void d(int i2) {
        if (i2 <= 0) {
            f57844e = 524288;
        } else {
            f57844e = i2;
        }
    }

    public void a() {
        d.a.n0.e3.o0.d.b bVar = this.f57845a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f57845a = new d(str2, f57844e, this.f57846b);
            } else {
                this.f57845a = new d.a.n0.e3.o0.d.c(str, f57842c, f57843d, this.f57846b);
            }
            this.f57845a.a(eVar);
            return this.f57845a.b(str2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f57846b;
            if (gVar != null) {
                gVar.f(306, -4399, d.a.n0.u1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
