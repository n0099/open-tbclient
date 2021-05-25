package d.a.n0.s0;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f60377b;

    /* renamed from: a  reason: collision with root package name */
    public c f60378a = f();

    /* renamed from: d.a.n0.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1589a implements e {
        public C1589a(a aVar) {
        }

        @Override // d.a.n0.s0.a.e
        public void a(String str, int i2) {
            FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
        }

        @Override // d.a.n0.s0.a.e
        public void onError(String str) {
            FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60379a;

        public b(a aVar, String str) {
            this.f60379a = str;
        }

        @Override // d.a.n0.s0.a.e
        public void a(String str, int i2) {
            FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.f60379a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
        }

        @Override // d.a.n0.s0.a.e
        public void onError(String str) {
            FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.f60379a, "0");
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(Activity activity, String str, e eVar, d dVar);

        void b(String str);

        void c(Activity activity, @NonNull Object obj, f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, d dVar);

        ViewGroup d(Activity activity, String str);

        void destroyAd(String str);

        Object e(@NonNull Activity activity, @NonNull String str);

        void f(Application application, h hVar);

        void g(Activity activity, String str, e eVar, d dVar);

        void h(Activity activity, String str, ViewGroup viewGroup, f fVar, d dVar);

        boolean isAdReady(String str);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f60380a;

        /* renamed from: b  reason: collision with root package name */
        public String f60381b;
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(String str, int i2);

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
        @Override // d.a.n0.s0.a.f
        public void onRewardedVideo(String str) {
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();
    }

    public static d a(String str, String str2) {
        d dVar = new d();
        dVar.f60380a = str;
        dVar.f60381b = str2;
        return dVar;
    }

    public static a h() {
        if (f60377b == null) {
            synchronized (a.class) {
                if (f60377b == null) {
                    f60377b = new a();
                }
            }
        }
        if (f60377b.f60378a == null && PermissionUtil.isAgreePrivacyPolicy()) {
            f60377b = new a();
        }
        return f60377b;
    }

    public void b(String str) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.b(str);
        }
    }

    public void c(String str) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.destroyAd(str);
        }
    }

    public int d() {
        return d.a.m0.s.c.e.d();
    }

    public int e() {
        return d.a.m0.s.c.e.e();
    }

    public final c f() {
        CustomResponsedMessage runTask;
        if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, c.class)) != null) {
            return (c) runTask.getData();
        }
        return null;
    }

    public ViewGroup g(Activity activity, String str) {
        c cVar = this.f60378a;
        if (cVar != null) {
            return cVar.d(activity, str);
        }
        return null;
    }

    public Object i(@NonNull Activity activity, @NonNull String str) {
        c cVar = this.f60378a;
        if (cVar != null) {
            return cVar.e(activity, str);
        }
        return null;
    }

    public void j() {
        c cVar = this.f60378a;
        if (cVar == null) {
            return;
        }
        cVar.f(TbadkCoreApplication.getInst(), null);
    }

    public boolean k(String str) {
        c cVar = this.f60378a;
        return cVar != null && cVar.isAdReady(str);
    }

    public void l(Activity activity, String str, e eVar, d dVar) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.a(activity, str, eVar, dVar);
        }
    }

    public void m(Activity activity, String str, e eVar, d dVar) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.g(activity, str, eVar, dVar);
        }
    }

    public void n(Activity activity, String str, ViewGroup viewGroup, f fVar, d dVar) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.h(activity, str, viewGroup, fVar, dVar);
        }
    }

    public void o(Activity activity, @NonNull Object obj, f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, d dVar) {
        c cVar = this.f60378a;
        if (cVar != null) {
            cVar.c(activity, obj, fVar, viewGroup, list, list2, dVar);
        }
    }

    public boolean p(Activity activity, String str, d dVar) {
        if (this.f60378a == null || TextUtils.isEmpty(str) || dVar == null) {
            return false;
        }
        boolean isAdReady = this.f60378a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
        System.currentTimeMillis();
        FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
        this.f60378a.g(activity, str, new C1589a(this), dVar);
        return isAdReady;
    }

    public boolean q(Activity activity, String str, d dVar, String str2) {
        if (this.f60378a == null || TextUtils.isEmpty(str) || dVar == null) {
            return false;
        }
        boolean isAdReady = this.f60378a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
        FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
        this.f60378a.g(activity, str, new b(this, str2), dVar);
        return isAdReady;
    }
}
