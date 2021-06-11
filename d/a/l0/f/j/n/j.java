package d.a.l0.f.j.n;

import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public String f50608b;

    /* renamed from: c  reason: collision with root package name */
    public String f50609c;

    /* renamed from: e  reason: collision with root package name */
    public String f50611e;

    /* renamed from: a  reason: collision with root package name */
    public DownloadState f50607a = DownloadState.NOT_START;

    /* renamed from: d  reason: collision with root package name */
    public int f50610d = Integer.parseInt("0");

    static {
        boolean z = k.f46875a;
    }

    public static j a(String str, String str2) {
        j jVar = new j();
        jVar.f50608b = str;
        jVar.f50609c = str2;
        return jVar;
    }

    public String b() {
        return this.f50611e;
    }

    public void c(String str) {
        this.f50611e = str;
    }
}
