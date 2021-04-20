package d.b.g0.a.s0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f46279a;

    public c(@NonNull String str) {
        this.f46279a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.b.g0.a.s0.k.g.a d2 = d.b.g0.a.w0.a.t().d(invoker, this.f46279a);
        if (k.f45443a) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + d2.hashCode() + "」");
        }
        return new a(d2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }
}
