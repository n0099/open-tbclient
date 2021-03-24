package e.a;

import android.content.SharedPreferences;
import e.a.h;
import java.util.UUID;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class e extends h<String> {

    /* loaded from: classes7.dex */
    public class a implements h.a<String> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.a.h.a
        public /* bridge */ /* synthetic */ String a(String str) {
            String str2 = str;
            d(str2);
            return str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.a.h.a
        /* renamed from: b */
        public String create() {
            return UUID.randomUUID().toString();
        }

        public String c(String str) {
            return str;
        }

        public String d(String str) {
            return str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.a.h.a
        public /* bridge */ /* synthetic */ String load(String str) {
            c(str);
            return str;
        }
    }

    public e(Future<SharedPreferences> future) {
        super(future, "events_distinct_id", new a());
    }
}
