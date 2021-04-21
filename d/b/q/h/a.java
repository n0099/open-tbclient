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
    public a.C1784a f65418a;

    /* renamed from: b  reason: collision with root package name */
    public b f65419b;

    /* renamed from: c  reason: collision with root package name */
    public String f65420c;

    /* renamed from: d.b.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1785a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f65421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f65422f;

        public RunnableC1785a(a aVar, d dVar, String str) {
            this.f65421e = dVar;
            this.f65422f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65421e.a(this.f65422f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f65423a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.q.g.d.a f65424b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f65425c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f65426d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f65427e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65428a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f65420c = str;
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
        this.f65419b = bVar;
        this.f65418a = bVar.f65424b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f65420c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f65419b.f65426d.submit(new RunnableC1785a(this, dVar, c()));
    }
}
