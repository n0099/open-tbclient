package d.a.m0.a.y0.f;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f49602a;

    public c(@NonNull String str) {
        this.f49602a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(d.a.m0.a.c1.a.z().e(invoker, this.f49602a));
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }
}
