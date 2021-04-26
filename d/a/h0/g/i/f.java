package d.a.h0.g.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public class f extends d.a.h0.g.i.a {

    /* loaded from: classes3.dex */
    public static class a extends d.a.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46371a;

        public a(String str) {
            this.f46371a = str;
        }

        @Override // d.a.h0.g.i.n.b
        public String a() {
            return "swan-game-worker.js";
        }

        @Override // d.a.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f46371a;
        }
    }

    public f(@NonNull String str) {
        super("worker", new a(str), null);
    }

    @Override // d.a.h0.g.i.a
    public EventTarget A() {
        return null;
    }

    @Override // d.a.h0.g.i.a
    public EventTarget C() {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }
}
