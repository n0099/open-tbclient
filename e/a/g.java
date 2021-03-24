package e.a;

import android.content.SharedPreferences;
import e.a.h;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class g extends h<Boolean> {

    /* loaded from: classes7.dex */
    public class a implements h.a<Boolean> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: b */
        public Boolean create() {
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: c */
        public Boolean load(String str) {
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: d */
        public String a(Boolean bool) {
            return String.valueOf(true);
        }
    }

    public g(Future<SharedPreferences> future) {
        super(future, "first_start", new a());
    }
}
