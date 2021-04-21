package d.b.h0.g.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public class f extends d.b.h0.g.i.a {

    /* loaded from: classes3.dex */
    public static class a extends d.b.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48897a;

        public a(String str) {
            this.f48897a = str;
        }

        @Override // d.b.h0.g.i.n.b
        public String a() {
            return "swan-game-worker.js";
        }

        @Override // d.b.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f48897a;
        }
    }

    public f(@NonNull String str) {
        super("worker", new a(str), null);
    }

    @Override // d.b.h0.g.i.a
    public EventTarget H() {
        return null;
    }

    @Override // d.b.h0.g.i.a
    public EventTarget N() {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }
}
