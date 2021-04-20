package d.b.p.h;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import d.b.p.g.d.a;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public a.C1765a f65154a;

    /* renamed from: b  reason: collision with root package name */
    public b f65155b;

    /* renamed from: c  reason: collision with root package name */
    public String f65156c;

    /* renamed from: d.b.p.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1766a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f65157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f65158f;

        public RunnableC1766a(a aVar, d dVar, String str) {
            this.f65157e = dVar;
            this.f65158f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65157e.a(this.f65158f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f65159a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.p.g.d.a f65160b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f65161c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f65162d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f65163e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65164a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f65156c = str;
    }

    public static String b(String str, String str2) {
        String str3;
        String format = String.format("%s-%s-", str, str2);
        try {
            str3 = new d.b.p.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.b.p.g.a.a().a(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(b bVar) {
        this.f65155b = bVar;
        this.f65154a = bVar.f65160b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f65156c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f65155b.f65162d.submit(new RunnableC1766a(this, dVar, c()));
    }
}
