package d.b.i0.q0;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f59259b;

    /* renamed from: a  reason: collision with root package name */
    public b f59260a = f();

    /* renamed from: d.b.i0.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1477a implements d {
        public C1477a(a aVar) {
        }

        @Override // d.b.i0.q0.a.d
        public void a(String str, int i) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
        }

        @Override // d.b.i0.q0.a.d
        public void onError(String str) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        ViewGroup a(Activity activity, String str);

        Object b(@NonNull Activity activity, @NonNull String str);

        void c(Activity activity, String str, d dVar, c cVar);

        void d(String str);

        void destroyAd(String str);

        void e(Application application, g gVar);

        void f(Activity activity, @NonNull Object obj, e eVar, ViewGroup viewGroup, List<View> list, List<View> list2, c cVar);

        void g(Activity activity, String str, d dVar, c cVar);

        void h(Activity activity, String str, ViewGroup viewGroup, e eVar, c cVar);

        boolean isAdReady(String str);
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f59261a;

        /* renamed from: b  reason: collision with root package name */
        public String f59262b;
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void onAdClicked(String str);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements e {
        @Override // d.b.i0.q0.a.e
        public void onRewardedVideo(String str) {
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a();
    }

    public static c a(String str, String str2) {
        c cVar = new c();
        cVar.f59261a = str;
        cVar.f59262b = str2;
        return cVar;
    }

    public static a h() {
        if (f59259b == null) {
            synchronized (a.class) {
                if (f59259b == null) {
                    f59259b = new a();
                }
            }
        }
        return f59259b;
    }

    public void b(String str) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.d(str);
        }
    }

    public void c(String str) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.destroyAd(str);
        }
    }

    public int d() {
        return d.b.h0.s.c.e.a();
    }

    public int e() {
        return d.b.h0.s.c.e.b();
    }

    public final b f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, b.class);
        if (runTask != null) {
            return (b) runTask.getData();
        }
        return null;
    }

    public ViewGroup g(Activity activity, String str) {
        b bVar = this.f59260a;
        if (bVar != null) {
            return bVar.a(activity, str);
        }
        return null;
    }

    public Object i(@NonNull Activity activity, @NonNull String str) {
        b bVar = this.f59260a;
        if (bVar != null) {
            return bVar.b(activity, str);
        }
        return null;
    }

    public void j() {
        b bVar = this.f59260a;
        if (bVar == null) {
            return;
        }
        bVar.e(TbadkCoreApplication.getInst(), null);
    }

    public boolean k(String str) {
        b bVar = this.f59260a;
        return bVar != null && bVar.isAdReady(str);
    }

    public void l(Activity activity, String str, d dVar, c cVar) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.c(activity, str, dVar, cVar);
        }
    }

    public void m(Activity activity, String str, d dVar, c cVar) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.g(activity, str, dVar, cVar);
        }
    }

    public void n(Activity activity, String str, ViewGroup viewGroup, e eVar, c cVar) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.h(activity, str, viewGroup, eVar, cVar);
        }
    }

    public void o(Activity activity, @NonNull Object obj, e eVar, ViewGroup viewGroup, List<View> list, List<View> list2, c cVar) {
        b bVar = this.f59260a;
        if (bVar != null) {
            bVar.f(activity, obj, eVar, viewGroup, list, list2, cVar);
        }
    }

    public boolean p(Activity activity) {
        b bVar;
        if (!d.b.h0.b.d.l() || (bVar = this.f59260a) == null) {
            return false;
        }
        boolean isAdReady = bVar.isAdReady("6051001773-1862514716");
        this.f59260a.g(activity, "6051001773-1862514716", new C1477a(this), a("frs", d.b.h0.b.d.l() ? "1" : "0"));
        return isAdReady;
    }
}
