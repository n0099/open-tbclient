package d.b.h0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class k extends d.b.h0.a.s0.a<d.b.h0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public static String f46610b = "release";

    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return f46610b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.k.g.a aVar) {
        aVar.release();
        d(aVar, command.what, null, false);
    }
}
