package d.b.i0.s2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.d3.j0.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes4.dex */
public class v implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<u> f61741a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final u f61742b = new v();

    public static u p() {
        u uVar = f61741a.get();
        return uVar == null ? f61742b : uVar;
    }

    @Override // d.b.i0.s2.u
    public d.b.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public p b() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public App c(App app, Cmatch cmatch) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public void d(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.s2.u
    public void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.s2.u
    public d.b.c.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public j g() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public k h(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public l i() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public d.b.c.j.e.a<?, ?> j(t tVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public d.b.i0.b3.a k() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public void l(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.s2.u
    public r m() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // d.b.i0.s2.u
    public void n() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // d.b.i0.s2.u
    public List<AppData> o() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
