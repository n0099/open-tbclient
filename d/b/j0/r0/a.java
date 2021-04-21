package d.b.j0.r0;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f61368b;

    /* renamed from: a  reason: collision with root package name */
    public c f61369a = f();

    /* renamed from: d.b.j0.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1564a implements e {
        public C1564a(a aVar) {
        }

        @Override // d.b.j0.r0.a.e
        public void a(String str, int i) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
        }

        @Override // d.b.j0.r0.a.e
        public void onError(String str) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e {
        public b(a aVar) {
        }

        @Override // d.b.j0.r0.a.e
        public void a(String str, int i) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
        }

        @Override // d.b.j0.r0.a.e
        public void onError(String str) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        ViewGroup a(Activity activity, String str);

        Object b(@NonNull Activity activity, @NonNull String str);

        void c(Activity activity, String str, e eVar, d dVar);

        void d(String str);

        void destroyAd(String str);

        void e(Application application, h hVar);

        void f(Activity activity, @NonNull Object obj, f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, d dVar);

        void g(Activity activity, String str, e eVar, d dVar);

        void h(Activity activity, String str, ViewGroup viewGroup, f fVar, d dVar);

        boolean isAdReady(String str);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f61370a;

        /* renamed from: b  reason: collision with root package name */
        public String f61371b;
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onAdClicked(String str);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes4.dex */
    public static abstract class g implements f {
        @Override // d.b.j0.r0.a.f
        public void onRewardedVideo(String str) {
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();
    }

    public static d a(String str, String str2) {
        d dVar = new d();
        dVar.f61370a = str;
        dVar.f61371b = str2;
        return dVar;
    }

    public static a h() {
        if (f61368b == null) {
            synchronized (a.class) {
                if (f61368b == null) {
                    f61368b = new a();
                }
            }
        }
        return f61368b;
    }

    public void b(String str) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void c(String str) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.destroyAd(str);
        }
    }

    public int d() {
        return d.b.i0.s.c.e.d();
    }

    public int e() {
        return d.b.i0.s.c.e.e();
    }

    public final c f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, c.class);
        if (runTask != null) {
            return (c) runTask.getData();
        }
        return null;
    }

    public ViewGroup g(Activity activity, String str) {
        c cVar = this.f61369a;
        if (cVar != null) {
            return cVar.a(activity, str);
        }
        return null;
    }

    public Object i(@NonNull Activity activity, @NonNull String str) {
        c cVar = this.f61369a;
        if (cVar != null) {
            return cVar.b(activity, str);
        }
        return null;
    }

    public void j() {
        c cVar = this.f61369a;
        if (cVar == null) {
            return;
        }
        cVar.e(TbadkCoreApplication.getInst(), null);
    }

    public boolean k(String str) {
        c cVar = this.f61369a;
        return cVar != null && cVar.isAdReady(str);
    }

    public void l(Activity activity, String str, e eVar, d dVar) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.c(activity, str, eVar, dVar);
        }
    }

    public void m(Activity activity, String str, e eVar, d dVar) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.g(activity, str, eVar, dVar);
        }
    }

    public void n(Activity activity, String str, ViewGroup viewGroup, f fVar, d dVar) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.h(activity, str, viewGroup, fVar, dVar);
        }
    }

    public void o(Activity activity, @NonNull Object obj, f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, d dVar) {
        c cVar = this.f61369a;
        if (cVar != null) {
            cVar.f(activity, obj, fVar, viewGroup, list, list2, dVar);
        }
    }

    public boolean p(Activity activity, String str, d dVar) {
        if (this.f61369a == null || TextUtils.isEmpty(str) || dVar == null) {
            return false;
        }
        boolean isAdReady = this.f61369a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
        this.f61369a.g(activity, str, new C1564a(this), dVar);
        return isAdReady;
    }

    public boolean q(Activity activity, String str, d dVar, String str2) {
        if (this.f61369a == null || TextUtils.isEmpty(str) || dVar == null) {
            return false;
        }
        boolean isAdReady = this.f61369a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
        this.f61369a.g(activity, str, new b(this), dVar);
        return isAdReady;
    }
}
