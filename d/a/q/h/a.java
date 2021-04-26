package d.a.q.h;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import d.a.q.g.d.a;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public a.C1722a f63737a;

    /* renamed from: b  reason: collision with root package name */
    public b f63738b;

    /* renamed from: c  reason: collision with root package name */
    public String f63739c;

    /* renamed from: d.a.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1723a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63741f;

        public RunnableC1723a(a aVar, d dVar, String str) {
            this.f63740e = dVar;
            this.f63741f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f63740e.a(this.f63741f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f63742a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q.g.d.a f63743b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f63744c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f63745d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f63746e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63747a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i2, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f63739c = str;
    }

    public static String b(String str, String str2) {
        String str3;
        String format = String.format("%s-%s-", str, str2);
        try {
            str3 = new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.a.q.g.a.a().a(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(b bVar) {
        this.f63738b = bVar;
        this.f63737a = bVar.f63743b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f63739c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f63738b.f63745d.submit(new RunnableC1723a(this, dVar, c()));
    }
}
