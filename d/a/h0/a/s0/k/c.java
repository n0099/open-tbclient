package d.a.h0.a.s0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43979a;

    public c(@NonNull String str) {
        this.f43979a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.h0.a.s0.k.g.a c2 = d.a.h0.a.w0.a.t().c(invoker, this.f43979a);
        if (k.f43101a) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + c2.hashCode() + "」");
        }
        return new a(c2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }
}
