package d.a.m0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class m extends d.a.m0.a.y0.a<d.a.m0.a.y0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public static String f49665b = "release";

    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return f49665b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.k.g.a aVar) {
        aVar.release();
        d.a.m0.a.u.e.o.k.e().q(aVar.c());
        d.a.m0.a.u.e.o.k.e().n(aVar);
        d(aVar, command.what, null, false);
    }
}
