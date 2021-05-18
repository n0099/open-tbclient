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
    public a.C1785a f64374a;

    /* renamed from: b  reason: collision with root package name */
    public b f64375b;

    /* renamed from: c  reason: collision with root package name */
    public String f64376c;

    /* renamed from: d.a.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1786a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64378f;

        public RunnableC1786a(a aVar, d dVar, String str) {
            this.f64377e = dVar;
            this.f64378f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64377e.a(this.f64378f, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f64379a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q.g.d.a f64380b;

        /* renamed from: c  reason: collision with root package name */
        public TrustSubjectManager.d f64381c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64382d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64383e;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64384a = false;
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        void a(T t, Bundle bundle);

        void b(int i2, Exception exc, Bundle bundle);
    }

    public a(String str) {
        this.f64376c = str;
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
        this.f64375b = bVar;
        this.f64374a = bVar.f64380b.d().f("ids");
    }

    public abstract String c();

    public byte[] d() {
        return null;
    }

    public String e() {
        return this.f64376c;
    }

    public abstract void f(c cVar);

    public void g(d<String> dVar) {
        this.f64375b.f64382d.submit(new RunnableC1786a(this, dVar, c()));
    }
}
