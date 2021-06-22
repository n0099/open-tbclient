package d.a.o0.b3.k;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.a.n0.r.q.x1;
import d.a.n0.r.w.b.d;
import d.a.n0.r.w.b.e;
import d.a.o0.b3.j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public CoverFlowView<g> f56072g;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f56074i;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f56070e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f56071f = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public d<g> f56073h = new C1287a();

    /* renamed from: d.a.o0.b3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1287a implements d<g> {
        public C1287a() {
        }

        @Override // d.a.n0.r.w.b.d
        public void b(int i2, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i2));
            g gVar = (g) ListUtils.getItem(a.this.f56071f, i2);
            String c2 = gVar != null ? gVar.c() : null;
            if (UrlManager.getInstance().dealOneLink(a.this.f56074i, new String[]{str, null, makeStatisticsParam}) && i2 == 2 && !TextUtils.isEmpty(c2)) {
                TiebaStatic.eventStat(a.this.f56074i.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, TiebaStatic.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IAdRequestParam.OS, "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            Activity pageActivity = a.this.f56074i.getPageActivity();
            TiebaStatic.eventStat(pageActivity, "square_banner_picture", PrefetchEvent.STATE_CLICK, 1, "loc", (i2 - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, g gVar) {
            if (gVar == null) {
                return;
            }
            String c2 = gVar.c();
            if (i2 == 2 && !TextUtils.isEmpty(c2) && a.this.f56070e.add(c2)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IAdRequestParam.OS, "android", "os_version", Build.VERSION.RELEASE);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.n0.r.w.b.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56076a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f56076a = tbPageContext;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public d.a.n0.r.w.b.c a() {
            d.a.n0.r.w.b.c a2 = super.a();
            if (a2 != null) {
                a2.d(85);
                a2.e(R.dimen.ds20);
                a2.f(R.dimen.ds30);
            }
            return a2;
        }

        @Override // d.a.n0.r.w.b.b, d.a.n0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(this.f56076a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
            return eVar;
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f56072g = null;
        this.f56074i = tbPageContext;
        this.f56072g = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.f56072g.setCoverFlowFactory(new b(this, tbPageContext));
        this.f56072g.setCallback(this.f56073h);
    }

    public CoverFlowView<g> d() {
        return this.f56072g;
    }

    public void e(int i2) {
        CoverFlowView<g> coverFlowView = this.f56072g;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    public void f(ArrayList<x1> arrayList) {
        ArrayList<g> arrayList2 = new ArrayList<>();
        Iterator<x1> it = arrayList.iterator();
        while (it.hasNext()) {
            x1 next = it.next();
            if (next != null) {
                arrayList2.add(new g(next));
            }
        }
        this.f56071f = arrayList2;
        this.f56072g.setData(arrayList2);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<g> arrayList = this.f56071f;
        return (arrayList != null ? arrayList.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return this.f56072g;
    }
}
