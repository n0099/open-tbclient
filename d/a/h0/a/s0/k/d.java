package d.a.h0.a.s0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class d implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43980a;

    public d(@NonNull String str) {
        this.f43980a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.h0.a.s0.k.g.a b2 = d.a.h0.a.w0.a.t().b(invoker, this.f43980a);
        if (k.f43101a) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + b2.hashCode() + "」");
        }
        return new b(b2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }
}
