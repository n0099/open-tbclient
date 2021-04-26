package d.a.h0.g.i.m;

import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
/* loaded from: classes3.dex */
public class d implements V8FileSystemDelegatePolicy {
    @Override // com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy
    public void destroy() {
    }

    @Override // com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy
    public void loadFileFromUrl(String str, ValueCallback<String> valueCallback) {
        b.e().g(str, valueCallback);
    }
}
