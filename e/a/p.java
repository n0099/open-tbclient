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
    public final Executor f67530a = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public static class a implements Callable<SharedPreferences> {

        /* renamed from: e  reason: collision with root package name */
        public final Context f67531e;

        /* renamed from: f  reason: collision with root package name */
        public final String f67532f;

        /* renamed from: g  reason: collision with root package name */
        public final b f67533g;

        public a(Context context, String str, b bVar) {
            this.f67531e = context;
            this.f67532f = str;
            this.f67533g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f67531e.getSharedPreferences(this.f67532f, 0);
            b bVar = this.f67533g;
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
        this.f67530a.execute(futureTask);
        return futureTask;
    }
}
