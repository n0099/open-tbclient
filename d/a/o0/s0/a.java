package d.a.o0.s0;

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
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64191b;

    /* renamed from: a  reason: collision with root package name */
    public d f64192a = f();

    /* renamed from: d.a.o0.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1649a implements f {
        public C1649a(a aVar) {
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
            FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64193a;

        public b(a aVar, String str) {
            this.f64193a = str;
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.f64193a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
            FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.f64193a, "0");
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f64194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f64195b;

        public c(a aVar, f fVar, String str) {
            this.f64194a = fVar;
            this.f64195b = str;
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            f fVar = this.f64194a;
            if (fVar != null) {
                fVar.a(str, i2);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f64195b).param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
            f fVar = this.f64194a;
            if (fVar != null) {
                fVar.onError(str);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f64195b).param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(Activity activity, String str, f fVar, e eVar);

        void b(String str);

        void c(Activity activity, @NonNull Object obj, g gVar, ViewGroup viewGroup, List<View> list, List<View> list2, e eVar);

        ViewGroup d(Activity activity, String str);

        void destroyAd(String str);

        Object e(@NonNull Activity activity, @NonNull String str);

        void f(Application application, i iVar);

        void g(Activity activity, String str, f fVar, e eVar);

        void h(Activity activity, String str, ViewGroup viewGroup, g gVar, e eVar);

        boolean isAdReady(String str);
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f64196a;

        /* renamed from: b  reason: collision with root package name */
        public String f64197b;
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(String str, int i2);

        void onError(String str);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void onAdClicked(String str);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes4.dex */
    public static abstract class h implements g {
        @Override // d.a.o0.s0.a.g
        public void onRewardedVideo(String str) {
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a();
    }

    public static e a(String str, String str2) {
        e eVar = new e();
        eVar.f64196a = str;
        eVar.f64197b = str2;
        return eVar;
    }

    public static a h() {
        if (f64191b == null) {
            synchronized (a.class) {
                if (f64191b == null) {
                    f64191b = new a();
                }
            }
        }
        if (f64191b.f64192a == null && PermissionUtil.isAgreePrivacyPolicy()) {
            f64191b = new a();
        }
        return f64191b;
    }

    public void b(String str) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.b(str);
        }
    }

    public void c(String str) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.destroyAd(str);
        }
    }

    public int d() {
        return d.a.n0.s.c.e.d();
    }

    public int e() {
        return d.a.n0.s.c.e.e();
    }

    public final d f() {
        CustomResponsedMessage runTask;
        if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, d.class)) != null) {
            return (d) runTask.getData();
        }
        return null;
    }

    public ViewGroup g(Activity activity, String str) {
        d dVar = this.f64192a;
        if (dVar != null) {
            return dVar.d(activity, str);
        }
        return null;
    }

    public Object i(@NonNull Activity activity, @NonNull String str) {
        d dVar = this.f64192a;
        if (dVar != null) {
            return dVar.e(activity, str);
        }
        return null;
    }

    public void j() {
        d dVar = this.f64192a;
        if (dVar == null) {
            return;
        }
        dVar.f(TbadkCoreApplication.getInst(), null);
    }

    public boolean k(String str) {
        d dVar = this.f64192a;
        return dVar != null && dVar.isAdReady(str);
    }

    public void l(Activity activity, String str, f fVar, e eVar) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.a(activity, str, fVar, eVar);
        }
    }

    public void m(Activity activity, String str, f fVar, e eVar) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.g(activity, str, fVar, eVar);
        }
    }

    public void n(Activity activity, f fVar, String str) {
        if (this.f64192a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        this.f64192a.g(activity, "6061002182-391683336", new c(this, fVar, str), a("video_middle", VideoMiddleAdSwitch.isOn() ? "1" : "0"));
    }

    public void o(Activity activity, String str, ViewGroup viewGroup, g gVar, e eVar) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.h(activity, str, viewGroup, gVar, eVar);
        }
    }

    public void p(Activity activity, @NonNull Object obj, g gVar, ViewGroup viewGroup, List<View> list, List<View> list2, e eVar) {
        d dVar = this.f64192a;
        if (dVar != null) {
            dVar.c(activity, obj, gVar, viewGroup, list, list2, eVar);
        }
    }

    public boolean q(Activity activity, String str, e eVar) {
        if (this.f64192a == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        boolean isAdReady = this.f64192a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
        System.currentTimeMillis();
        FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
        this.f64192a.g(activity, str, new C1649a(this), eVar);
        return isAdReady;
    }

    public boolean r(Activity activity, String str, e eVar, String str2) {
        if (this.f64192a == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        boolean isAdReady = this.f64192a.isAdReady(str);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
        FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
        this.f64192a.g(activity, str, new b(this, str2), eVar);
        return isAdReady;
    }
}
