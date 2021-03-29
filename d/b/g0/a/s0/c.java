package d.b.g0.a.s0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.k;
import d.b.g0.a.s0.d;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class c<W extends d> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45792b = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a<W>> f45793a = new HashMap<>();

    public void a(a<W> aVar) {
        if (f45792b) {
            Log.v("CommandDispatcher", aVar.b() + " command added to supported command list");
        }
        this.f45793a.put(aVar.b(), aVar);
    }

    public void b(@Nullable ZeusPlugin.Command command, @Nullable W w) {
        if (command == null || TextUtils.isEmpty(command.what)) {
            if (f45792b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't dispatched");
            }
        } else if (w == null) {
            if (f45792b) {
                Log.e("CommandDispatcher", "inlineWidget is null, haven't dispatched");
            }
        } else {
            a<W> aVar = this.f45793a.get(command.what);
            if (aVar == null) {
                if (f45792b) {
                    Log.e("CommandDispatcher", command.what + " command is not supported, haven't dispatched");
                    return;
                }
                return;
            }
            if (f45792b) {
                Log.d("CommandDispatcher", command.what + " command dispatched");
            }
            aVar.a(command, w);
        }
    }

    public void c(@Nullable ZeusPlugin.Command command) {
        if (command != null && !TextUtils.isEmpty(command.what)) {
            a<W> aVar = this.f45793a.get(command.what);
            if (aVar == null) {
                if (f45792b) {
                    Log.e("CommandDispatcher", command.what + " command is not supported, haven't mocked");
                    return;
                }
                return;
            }
            if (f45792b) {
                Log.d("CommandDispatcher", command.what + " cached command return value processed");
            }
            aVar.c(command);
        } else if (f45792b) {
            Log.e("CommandDispatcher", "command or command.what is null, haven't mocked");
        }
    }
}
