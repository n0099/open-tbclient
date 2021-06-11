package e.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f71515a = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public static class a implements Callable<SharedPreferences> {

        /* renamed from: e  reason: collision with root package name */
        public final Context f71516e;

        /* renamed from: f  reason: collision with root package name */
        public final String f71517f;

        /* renamed from: g  reason: collision with root package name */
        public final b f71518g;

        public a(Context context, String str, b bVar) {
            this.f71516e = context;
            this.f71517f = str;
            this.f71518g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f71516e.getSharedPreferences(this.f71517f, 0);
            b bVar = this.f71518g;
            if (bVar != null) {
                bVar.a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        FutureTask futureTask = new FutureTask(new a(context, str, bVar));
        this.f71515a.execute(futureTask);
        return futureTask;
    }
}
