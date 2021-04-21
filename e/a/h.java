package e.a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes7.dex */
public abstract class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Future<SharedPreferences> f68568a;

    /* renamed from: b  reason: collision with root package name */
    public final a f68569b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68570c;

    /* renamed from: d  reason: collision with root package name */
    public T f68571d;

    /* loaded from: classes7.dex */
    public interface a<T> {
        String a(T t);

        T create();

        T load(String str);
    }

    public h(Future<SharedPreferences> future, String str, a<T> aVar) {
        this.f68568a = future;
        this.f68569b = aVar;
        this.f68570c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x000e, DONT_GENERATE, TryCatch #2 {, blocks: (B:4:0x0005, B:14:0x0028, B:16:0x002a, B:18:0x0041, B:20:0x0048, B:19:0x0045, B:9:0x0011, B:11:0x001a), top: B:24:0x0005, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a A[Catch: all -> 0x000e, TryCatch #2 {, blocks: (B:4:0x0005, B:14:0x0028, B:16:0x002a, B:18:0x0041, B:20:0x0048, B:19:0x0045, B:9:0x0011, B:11:0x001a), top: B:24:0x0005, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(T t) {
        SharedPreferences sharedPreferences;
        this.f68571d = t;
        synchronized (this.f68568a) {
            try {
                sharedPreferences = this.f68568a.get();
            } catch (InterruptedException e2) {
                Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
                sharedPreferences = null;
                if (sharedPreferences == null) {
                }
            } catch (ExecutionException e3) {
                Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e3.getCause());
                sharedPreferences = null;
                if (sharedPreferences == null) {
                }
            }
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(this.f68570c, this.f68569b.a(this.f68571d));
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: e.a.h<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public T b() {
        Object load;
        if (this.f68571d == null) {
            synchronized (this.f68568a) {
                String str = null;
                try {
                    SharedPreferences sharedPreferences = this.f68568a.get();
                    if (sharedPreferences != null) {
                        str = sharedPreferences.getString(this.f68570c, null);
                    }
                } catch (InterruptedException e2) {
                    Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
                } catch (ExecutionException e3) {
                    Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e3.getCause());
                }
                if (str == null) {
                    load = this.f68569b.create();
                } else {
                    load = this.f68569b.load(str);
                }
                if (load != null) {
                    a(load);
                }
            }
        }
        return this.f68571d;
    }
}
