package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return LightappJsNativeClient.METHOD_GET_CURRENT_POSITION;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        command.ret = aVar.getCurrentPosition();
        String str = command.what;
        d(aVar, str, "Position: " + command.ret, false);
    }
}
