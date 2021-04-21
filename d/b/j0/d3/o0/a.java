package d.b.j0.d3.o0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.j0.d3.o0.d.d;
import d.b.j0.d3.o0.d.e;
import d.b.j0.t1.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f55392c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f55393d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f55394e = 524288;

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.d3.o0.d.b f55395a;

    /* renamed from: b  reason: collision with root package name */
    public g f55396b;

    public a(g gVar) {
        this.f55396b = gVar;
    }

    public static void b(int i) {
        if (i <= 0) {
            f55393d = 6144000;
        } else {
            f55393d = i;
        }
    }

    public static void c(int i) {
        if (i <= 0) {
            f55392c = 524288;
        } else {
            f55392c = i;
        }
    }

    public static void d(int i) {
        if (i <= 0) {
            f55394e = 524288;
        } else {
            f55394e = i;
        }
    }

    public void a() {
        d.b.j0.d3.o0.d.b bVar = this.f55395a;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.f55395a = new d(str2, f55394e, this.f55396b);
            } else {
                this.f55395a = new d.b.j0.d3.o0.d.c(str, f55392c, f55393d, this.f55396b);
            }
            this.f55395a.b(eVar);
            return this.f55395a.a(str2, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            g gVar = this.f55396b;
            if (gVar != null) {
                gVar.d(306, -4399, d.b.j0.t1.a.a(e2));
                return null;
            }
            return null;
        }
    }
}
