package d.b.h0.a.e0.i;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.WebSettings;
import d.b.h0.a.e0.i.a;
import d.b.h0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44635a = k.f45772a;

    @NonNull
    public static WebSettings.CodeCacheSetting a(String str, @NonNull String str2) {
        WebSettings.CodeCacheSetting codeCacheSetting = new WebSettings.CodeCacheSetting();
        codeCacheSetting.id = str;
        ArrayList<String> arrayList = new ArrayList<>();
        codeCacheSetting.pathList = arrayList;
        arrayList.add(str2);
        if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
            codeCacheSetting.maxCount = 5;
            codeCacheSetting.sizeLimit = 102400;
        } else {
            a.C0681a b2 = a.b.b();
            codeCacheSetting.maxCount = b2.f44628a;
            codeCacheSetting.sizeLimit = b2.f44629b;
        }
        if (f44635a) {
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting cacheType: " + str);
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
        }
        return codeCacheSetting;
    }
}
