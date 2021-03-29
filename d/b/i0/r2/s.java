package d.b.i0.r2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.c3.j0.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes5.dex */
public class s implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<r> f59848a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final r f59849b = new s();

    public static r o() {
        r rVar = f59848a.get();
        return rVar == null ? f59849b : rVar;
    }

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public m b() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public App c(App app, Cmatch cmatch) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public void d(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.r2.r
    public void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public i g(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public j h() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> i(q qVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public d.b.i0.a3.a j() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public void k(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.r2.r
    public o l() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.r2.r
    public void m() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.r2.r
    public List<AppData> n() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
