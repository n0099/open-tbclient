package d.a.m0.a.y0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.m0.a.k;
import d.a.m0.a.y0.d;
/* loaded from: classes3.dex */
public abstract class a<W extends d> {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49553a = k.f46983a;

    public abstract void a(@NonNull ZeusPlugin.Command command, @NonNull W w);

    @NonNull
    public abstract String b();

    public void c(@NonNull ZeusPlugin.Command command) {
    }

    public void d(@NonNull W w, @Nullable String str, @Nullable String str2, boolean z) {
        if (f49553a) {
            String str3 = ("【" + w.k0() + "-" + w.hashCode() + "】\t") + "【" + str + "】";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + "\t【" + str2 + "】";
            }
            if (z) {
                d.a.m0.a.e0.d.g("【InlineCommand】", str3);
            } else {
                Log.v("【InlineCommand】", str3);
            }
        }
    }
}
