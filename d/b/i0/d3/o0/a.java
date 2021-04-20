package d.b.i0.d3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.i0.d3.o0.d.d;
import d.b.i0.d3.o0.d.e;
import d.b.i0.t1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f54971c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f54972d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f54973e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.d3.o0.d.b f54974a;

    /* renamed from: b  reason: collision with root package name */
    public g f54975b;

    public a(g gVar) {
        this.f54975b = gVar;
    }

    public static void b(int i) {
        if (i <= 0) {
            f54972d = 6144000;
        } else {
            f54972d = i;
        }
    }

    public static void c(int i) {
        if (i <= 0) {
            f54971c = 524288;
        } else {
            f54971c = i;
        }
    }

    public static void d(int i) {
        if (i <= 0) {
            f54973e = 524288;
        } else {
            f54973e = i;
        }
    }

    public void a() {
        d.b.i0.d3.o0.d.b bVar = this.f54974a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f54974a = new d(str2, f54973e, this.f54975b);
            } else {
                this.f54974a = new d.b.i0.d3.o0.d.c(str, f54971c, f54972d, this.f54975b);
            }
            this.f54974a.b(eVar);
            return this.f54974a.a(str2, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f54975b;
            if (gVar != null) {
                gVar.d(306, -4399, d.b.i0.t1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
