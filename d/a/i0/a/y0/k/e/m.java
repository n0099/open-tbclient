package d.a.i0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class m extends d.a.i0.a.y0.a<d.a.i0.a.y0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public static String f45707b = "release";

    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return f45707b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.k.g.a aVar) {
        aVar.release();
        d.a.i0.a.u.e.o.k.e().q(aVar.c());
        d.a.i0.a.u.e.o.k.e().n(aVar);
        d(aVar, command.what, null, false);
    }
}
