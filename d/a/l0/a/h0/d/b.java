package d.a.l0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.WebSettings;
import d.a.l0.a.h0.d.a;
import d.a.l0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45639a = k.f46875a;

    @NonNull
    public static WebSettings.CodeCacheSetting a(String str, @NonNull String str2) {
        WebSettings.CodeCacheSetting codeCacheSetting = new WebSettings.CodeCacheSetting();
        codeCacheSetting.id = str;
        ArrayList<String> arrayList = new ArrayList<>();
        codeCacheSetting.pathList = arrayList;
        arrayList.add(str2);
        if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
            codeCacheSetting.maxCount = 20;
            codeCacheSetting.sizeLimit = 102400;
        } else {
            a.C0701a a2 = a.b.a();
            codeCacheSetting.maxCount = a2.f45635a;
            codeCacheSetting.sizeLimit = a2.f45636b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45637c;
        }
        if (f45639a) {
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting cacheType: " + str);
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
            Log.d("WebViewCodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
        }
        return codeCacheSetting;
    }
}
