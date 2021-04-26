package d.a.h0.a.s0.f;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes2.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43918a;

    public c(@NonNull String str) {
        this.f43918a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(d.a.h0.a.w0.a.t().e(invoker, this.f43918a));
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }
}
