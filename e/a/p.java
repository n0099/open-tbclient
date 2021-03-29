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
    public final Executor f67439a = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public static class a implements Callable<SharedPreferences> {

        /* renamed from: e  reason: collision with root package name */
        public final Context f67440e;

        /* renamed from: f  reason: collision with root package name */
        public final String f67441f;

        /* renamed from: g  reason: collision with root package name */
        public final b f67442g;

        public a(Context context, String str, b bVar) {
            this.f67440e = context;
            this.f67441f = str;
            this.f67442g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f67440e.getSharedPreferences(this.f67441f, 0);
            b bVar = this.f67442g;
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
        this.f67439a.execute(futureTask);
        return futureTask;
    }
}
