package d.a.l0.a.y0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f45881a;

    public c(@NonNull String str) {
        this.f45881a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.l0.a.y0.k.g.a c2 = d.a.l0.a.c1.a.z().c(invoker, this.f45881a);
        if (k.f43199a) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + c2.hashCode() + "」");
        }
        d.a.l0.a.u.e.o.k.e().b(c2);
        return new a(c2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }
}
