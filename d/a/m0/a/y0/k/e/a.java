package d.a.m0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.y0.a<d.a.m0.a.y0.k.g.a> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return LightappJsNativeClient.METHOD_GET_CURRENT_POSITION;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.k.g.a aVar) {
        command.ret = aVar.getCurrentPosition();
        String str = command.what;
        d(aVar, str, "Position: " + command.ret, false);
    }
}
