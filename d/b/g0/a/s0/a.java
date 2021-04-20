package d.b.g0.a.s0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.k;
import d.b.g0.a.s0.d;
/* loaded from: classes2.dex */
public abstract class a<W extends d> {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46175a = k.f45443a;

    public abstract void a(@NonNull ZeusPlugin.Command command, @NonNull W w);

    @NonNull
    public abstract String b();

    public void c(@NonNull ZeusPlugin.Command command) {
    }

    public void d(@NonNull W w, @Nullable String str, @Nullable String str2, boolean z) {
        if (f46175a) {
            String str3 = ("【" + w.c0() + "-" + w.hashCode() + "】\t") + "【" + str + "】";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + "\t【" + str2 + "】";
            }
            if (z) {
                d.b.g0.a.c0.c.g("【InlineCommand】", str3);
            } else {
                Log.v("【InlineCommand】", str3);
            }
        }
    }
}
