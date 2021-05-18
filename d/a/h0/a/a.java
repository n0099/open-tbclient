package d.a.h0.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.storage.swankv.SwanKV;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.collections.MapsKt__MapsKt;
/* loaded from: classes2.dex */
public class a extends SwanKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: d.a.h0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class RunnableC0546a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Callable f40314f;

        public RunnableC0546a(Callable callable) {
            this.f40314f = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: d.a.h0.a.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Map<String, ?> all;
            SharedPreferences sharedPreferences = (SharedPreferences) this.f40314f.call();
            if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
                return;
            }
            a.this.m(all, false);
        }
    }

    public a(Context context, String str, int i2, String str2) {
        super(context, str, i2, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        super.q(false);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        super.f();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        super.q(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return super.g(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return MapsKt__MapsKt.emptyMap();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return super.j(str, z);
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return super.getFloat(str, f2);
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return super.getString(str, str2);
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return super.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        super.r(str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        super.t(str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        super.u(str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        super.v(str, j);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        super.w(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        super.y(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not support registerOnSharedPreferenceChangeListener");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        super.p(str);
        return this;
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not support unregisterOnSharedPreferenceChangeListener");
    }

    public void z(Callable<SharedPreferences> callable) {
        new Thread(new RunnableC0546a(callable), "SharedPreferences-import").start();
    }
}
