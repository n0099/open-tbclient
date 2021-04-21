package d.b.h0.a.s0.i;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class b implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f46575a;

    public b(@NonNull String str) {
        this.f46575a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        c cVar = new c(invoker, this.f46575a);
        if (k.f45772a) {
            Log.i(" [[InlineTextAreaFactory]] ", "Factory 「Hash:" + hashCode() + "」 is creating inline textArea「Hash:" + cVar.hashCode() + "」");
        }
        return new a(cVar);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_textarea";
    }
}
