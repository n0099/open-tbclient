package d.a.i0.a.y0.i;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.i0.a.k;
/* loaded from: classes.dex */
public class b implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f45668a;

    public b(@NonNull String str) {
        this.f45668a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        c cVar = new c(invoker, this.f45668a);
        if (k.f43025a) {
            Log.i(" [[InlineTextAreaFactory]] ", "Factory 「Hash:" + hashCode() + "」 is creating inline textArea「Hash:" + cVar.hashCode() + "」");
        }
        return new a(cVar);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_textarea";
    }
}
