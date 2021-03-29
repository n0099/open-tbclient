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
    public a.C1753a f64460a;

    /* renamed from: b  reason: collision with root package name */
    public b f64461b;

    /* renamed from: c  reason: collision with root package name */
    public String f64462c;

    /* renamed from: d.b.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1754a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64464f;

        public RunnableC1754a(a aVar, d dVar, String str) {
            this.f64463e = dVar;
            this.f64464f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64463e.a(this.f64464f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f64465a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.q.g.d.a f64466b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f64467c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64468d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64469e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64470a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f64462c = str;
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
        this.f64461b = bVar;
        this.f64460a = bVar.f64466b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f64462c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f64461b.f64468d.submit(new RunnableC1754a(this, dVar, c()));
    }
}
