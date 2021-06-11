package d.a.l0.h.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.l0.a {

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f51092a;

        public a(String str) {
            this.f51092a = str;
        }

        @Override // d.a.l0.a.l0.n.b
        public String a() {
            return "swan-game-worker.js";
        }

        @Override // d.a.l0.a.l0.n.b
        public String getInitBasePath() {
            return this.f51092a;
        }
    }

    public c(@NonNull String str) {
        super("worker", new a(str), null);
    }

    @Override // d.a.l0.a.l0.a
    public EventTarget D() {
        return null;
    }

    @Override // d.a.l0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }

    @Override // d.a.l0.a.l0.a
    public EventTarget w() {
        return null;
    }
}
