package d.b.h0.a.s0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.h0.a.k;
import d.b.h0.a.s0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class b<W extends d> implements ZeusPlugin {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46505g = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPlugin.Callback f46507b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public W f46508c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46509d = false;

    /* renamed from: e  reason: collision with root package name */
    public final List<ZeusPlugin.Command> f46510e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.a f46511f = new a();

    /* renamed from: a  reason: collision with root package name */
    public c<W> f46506a = new c<>();

    /* loaded from: classes2.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // d.b.h0.a.s0.d.a
        public void a(boolean z) {
            synchronized (b.this) {
                if (b.f46505g) {
                    Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                }
                b.this.d();
                b.this.f46509d = true;
                if (b.f46505g) {
                    Log.i("BaseInlineController", "指令flush完成=========================");
                }
            }
        }
    }

    public b(@NonNull W w) {
        this.f46508c = w;
        if (f46505g) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.f46508c.T(this.f46511f);
    }

    public final void d() {
        if (this.f46510e.size() == 0) {
            return;
        }
        Iterator<ZeusPlugin.Command> it = this.f46510e.iterator();
        while (it.hasNext()) {
            ZeusPlugin.Command next = it.next();
            if (f46505g) {
                Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
            }
            this.f46506a.b(next, this.f46508c);
            it.remove();
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        synchronized (this) {
            if (command == null) {
                return;
            }
            if (this.f46509d) {
                if (f46505g) {
                    Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                }
                this.f46506a.b(command, this.f46508c);
            } else {
                ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                command2.what = command.what;
                command2.arg1 = command.arg1;
                command2.arg2 = command.arg2;
                command2.arg3 = command.arg3;
                command2.arg4 = command.arg4;
                command2.arg5 = command.arg5;
                command2.obj = command.obj;
                this.f46510e.add(command2);
                if (f46505g) {
                    Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                }
                this.f46506a.c(command);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        this.f46507b = callback;
    }
}
