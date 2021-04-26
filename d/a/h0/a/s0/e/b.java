package d.a.h0.a.s0.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class b implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43882a;

    public b(@NonNull String str) {
        this.f43882a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        c cVar = new c(invoker, this.f43882a);
        if (k.f43101a) {
            Log.i("【InlineInputFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline input「Hash:" + cVar.hashCode() + "」");
        }
        return new a(cVar);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_input";
    }
}
