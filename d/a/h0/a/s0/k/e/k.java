package d.a.h0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class k extends d.a.h0.a.s0.a<d.a.h0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public static String f43981b = "release";

    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return f43981b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.k.g.a aVar) {
        aVar.release();
        d(aVar, command.what, null, false);
    }
}
