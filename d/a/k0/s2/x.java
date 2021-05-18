package d.a.k0.s2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.k0.d3.j0.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes5.dex */
public class x implements v {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<v> f61093a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final v f61094b = new x();

    public static v p() {
        v vVar = f61093a.get();
        return vVar == null ? f61094b : vVar;
    }

    @Override // d.a.k0.s2.v
    public d.a.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public q b() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public App c(App app, Cmatch cmatch) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.k0.s2.v
    public k e() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public l f(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public m g() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public d.a.c.j.e.a<?, ?> h(u uVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public void i() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.k0.s2.v
    public List<AdvertAppInfo> j() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public void k(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.k0.s2.v
    public d.a.c.j.e.a<?, ?> l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public d.a.k0.b3.a m() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.k0.s2.v
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.k0.s2.v
    public s o() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
