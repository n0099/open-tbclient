package d.a.m0.a.y0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f49663a;

    public c(@NonNull String str) {
        this.f49663a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.m0.a.y0.k.g.a c2 = d.a.m0.a.c1.a.z().c(invoker, this.f49663a);
        if (k.f46983a) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + c2.hashCode() + "」");
        }
        d.a.m0.a.u.e.o.k.e().b(c2);
        return new a(c2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }
}
