package d.b.q.h;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import d.b.q.g.d.a;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public a.C1752a f64459a;

    /* renamed from: b  reason: collision with root package name */
    public b f64460b;

    /* renamed from: c  reason: collision with root package name */
    public String f64461c;

    /* renamed from: d.b.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1753a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64463f;

        public RunnableC1753a(a aVar, d dVar, String str) {
            this.f64462e = dVar;
            this.f64463f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64462e.a(this.f64463f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f64464a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.q.g.d.a f64465b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f64466c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64467d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64468e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64469a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f64461c = str;
    }

    public static String b(String str, String str2) {
        String str3;
        String format = String.format("%s-%s-", str, str2);
        try {
            str3 = new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.b.q.g.a.a().a(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(b bVar) {
        this.f64460b = bVar;
        this.f64459a = bVar.f64465b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f64461c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f64460b.f64467d.submit(new RunnableC1753a(this, dVar, c()));
    }
}
