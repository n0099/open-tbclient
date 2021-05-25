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
    public static int f54153c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f54154d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f54155e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e3.o0.d.b f54156a;

    /* renamed from: b  reason: collision with root package name */
    public g f54157b;

    public a(g gVar) {
        this.f54157b = gVar;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            f54154d = 6144000;
        } else {
            f54154d = i2;
        }
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            f54153c = 524288;
        } else {
            f54153c = i2;
        }
    }

    public static void d(int i2) {
        if (i2 <= 0) {
            f54155e = 524288;
        } else {
            f54155e = i2;
        }
    }

    public void a() {
        d.a.n0.e3.o0.d.b bVar = this.f54156a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f54156a = new d(str2, f54155e, this.f54157b);
            } else {
                this.f54156a = new d.a.n0.e3.o0.d.c(str, f54153c, f54154d, this.f54157b);
            }
            this.f54156a.a(eVar);
            return this.f54156a.b(str2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f54157b;
            if (gVar != null) {
                gVar.f(306, -4399, d.a.n0.u1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
