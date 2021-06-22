package d.a.o0.e3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.a.o0.e3.o0.d.d;
import d.a.o0.e3.o0.d.e;
import d.a.o0.u1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f57967c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f57968d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f57969e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.e3.o0.d.b f57970a;

    /* renamed from: b  reason: collision with root package name */
    public g f57971b;

    public a(g gVar) {
        this.f57971b = gVar;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            f57968d = 6144000;
        } else {
            f57968d = i2;
        }
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            f57967c = 524288;
        } else {
            f57967c = i2;
        }
    }

    public static void d(int i2) {
        if (i2 <= 0) {
            f57969e = 524288;
        } else {
            f57969e = i2;
        }
    }

    public void a() {
        d.a.o0.e3.o0.d.b bVar = this.f57970a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f57970a = new d(str2, f57969e, this.f57971b);
            } else {
                this.f57970a = new d.a.o0.e3.o0.d.c(str, f57967c, f57968d, this.f57971b);
            }
            this.f57970a.a(eVar);
            return this.f57970a.b(str2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f57971b;
            if (gVar != null) {
                gVar.f(306, -4399, d.a.o0.u1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
