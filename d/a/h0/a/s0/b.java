package d.a.h0.a.s0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.h0.a.k;
import d.a.h0.a.s0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class b<W extends d> implements ZeusPlugin {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43870g = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPlugin.Callback f43872b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public W f43873c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43874d = false;

    /* renamed from: e  reason: collision with root package name */
    public final List<ZeusPlugin.Command> f43875e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.a f43876f = new a();

    /* renamed from: a  reason: collision with root package name */
    public c<W> f43871a = new c<>();

    /* loaded from: classes2.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // d.a.h0.a.s0.d.a
        public void a(boolean z) {
            synchronized (b.this) {
                if (b.f43870g) {
                    Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                }
                b.this.d();
                b.this.f43874d = true;
                if (b.f43870g) {
                    Log.i("BaseInlineController", "指令flush完成=========================");
                }
            }
        }
    }

    public b(@NonNull W w) {
        this.f43873c = w;
        if (f43870g) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.f43873c.A(this.f43876f);
    }

    public final void d() {
        if (this.f43875e.size() == 0) {
            return;
        }
        Iterator<ZeusPlugin.Command> it = this.f43875e.iterator();
        while (it.hasNext()) {
            ZeusPlugin.Command next = it.next();
            if (f43870g) {
                Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
            }
            this.f43871a.b(next, this.f43873c);
            it.remove();
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        synchronized (this) {
            if (command == null) {
                return;
            }
            if (this.f43874d) {
                if (f43870g) {
                    Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                }
                this.f43871a.b(command, this.f43873c);
            } else {
                ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                command2.what = command.what;
                command2.arg1 = command.arg1;
                command2.arg2 = command.arg2;
                command2.arg3 = command.arg3;
                command2.arg4 = command.arg4;
                command2.arg5 = command.arg5;
                command2.obj = command.obj;
                this.f43875e.add(command2);
                if (f43870g) {
                    Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                }
                this.f43871a.c(command);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        this.f43872b = callback;
    }
}
