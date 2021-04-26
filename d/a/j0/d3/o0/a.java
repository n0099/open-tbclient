package d.a.j0.d3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.a.j0.d3.o0.d.d;
import d.a.j0.d3.o0.d.e;
import d.a.j0.t1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f53233c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f53234d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f53235e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.d3.o0.d.b f53236a;

    /* renamed from: b  reason: collision with root package name */
    public g f53237b;

    public a(g gVar) {
        this.f53237b = gVar;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            f53234d = 6144000;
        } else {
            f53234d = i2;
        }
    }

    public static void c(int i2) {
        if (i2 <= 0) {
            f53233c = 524288;
        } else {
            f53233c = i2;
        }
    }

    public static void d(int i2) {
        if (i2 <= 0) {
            f53235e = 524288;
        } else {
            f53235e = i2;
        }
    }

    public void a() {
        d.a.j0.d3.o0.d.b bVar = this.f53236a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f53236a = new d(str2, f53235e, this.f53237b);
            } else {
                this.f53236a = new d.a.j0.d3.o0.d.c(str, f53233c, f53234d, this.f53237b);
            }
            this.f53236a.a(eVar);
            return this.f53236a.b(str2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f53237b;
            if (gVar != null) {
                gVar.f(306, -4399, d.a.j0.t1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
