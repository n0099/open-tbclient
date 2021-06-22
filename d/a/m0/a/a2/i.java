package d.a.m0.a.a2;

import android.os.Bundle;
import android.text.TextUtils;
import d.a.m0.a.a2.i;
/* loaded from: classes3.dex */
public abstract class i<SelfT extends i<SelfT>> extends d.a.m0.a.f1.e.f.c<SelfT> {

    /* renamed from: f  reason: collision with root package name */
    public final String f44539f;

    /* loaded from: classes3.dex */
    public static final class a extends i<a> {
        public a(String str) {
            super(str);
        }

        public a E() {
            return this;
        }

        @Override // d.a.m0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d.a.m0.a.v2.e1.d a() {
            E();
            return this;
        }

        public a(String str, Bundle bundle) {
            super(str, bundle);
        }
    }

    public i(String str) {
        this(str, null);
    }

    @Override // d.a.m0.a.f1.e.f.c
    public String toString() {
        return String.format("Event(%s) Ext => %s", this.f44539f, super.toString());
    }

    public i(String str, Bundle bundle) {
        super(bundle);
        this.f44539f = TextUtils.isEmpty(str) ? "" : str;
    }
}
