package d.a.j0.s2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.j0.d3.j0.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes3.dex */
public class w implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<u> f60358a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final u f60359b = new w();

    public static u p() {
        u uVar = f60358a.get();
        return uVar == null ? f60359b : uVar;
    }

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public p b() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public App c(App app, Cmatch cmatch) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.j0.s2.u
    public j e() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public k f(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public l g() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> h(t tVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public void i() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.j0.s2.u
    public List<AppData> j() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public void k(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public d.a.j0.b3.a m() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.a.j0.s2.u
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.a.j0.s2.u
    public r o() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
