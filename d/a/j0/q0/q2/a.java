package d.a.j0.q0.q2;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import d.a.j0.j1.o.l.i;
import d.a.j0.q0.i1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a<?, ?>> f58591a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final b f58592b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f58593c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f58594d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f58595e;

    /* renamed from: d.a.j0.q0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1455a<T> implements Observer<Integer> {
        public C1455a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer pos) {
            List<BaseCardInfo> value = a.this.b().j().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: mutableListOf()");
            a aVar = a.this;
            Intrinsics.checkExpressionValueIsNotNull(pos, "pos");
            aVar.e(pos.intValue(), value);
            a.this.a().getListAdapter().notifyDataSetChanged();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        this.f58593c = tbPageContext;
        this.f58594d = bdTypeRecyclerView;
        this.f58595e = videoMiddlePageViewModel;
        TbPageContext<?> tbPageContext2 = this.f58593c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f58595e);
        this.f58592b = bVar;
        this.f58591a.add(bVar);
        this.f58594d.a(this.f58591a);
        MutableLiveData<Integer> c2 = this.f58595e.c();
        Activity pageActivity = this.f58593c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        c2.observe((LifecycleOwner) pageActivity, new C1455a());
    }

    public final BdTypeRecyclerView a() {
        return this.f58594d;
    }

    public final VideoMiddlePageViewModel b() {
        return this.f58595e;
    }

    public final void c() {
        this.f58592b.onDestroy();
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Integer value = this.f58595e.c().getValue();
        if (value == null) {
            value = 0;
        }
        e(value.intValue(), list);
        this.f58594d.setData(list);
    }

    public final void e(int i2, List<? extends BaseCardInfo> list) {
        if (i2 < list.size()) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                if (list.get(i3) instanceof i) {
                    BaseCardInfo baseCardInfo = list.get(i3);
                    if (baseCardInfo != null) {
                        ((i) baseCardInfo).setAutoPlay(i3 == i2);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.lego.card.view.IPassAutoPlayData");
                    }
                }
                i3++;
            }
        }
    }

    public final void f() {
        List<BaseCardInfo> value = this.f58595e.j().getValue();
        if (value != null) {
            Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
            for (BaseCardInfo baseCardInfo : value) {
                if (baseCardInfo instanceof i) {
                    ((i) baseCardInfo).setAutoPlay(false);
                }
            }
            this.f58594d.setData(value);
        }
    }
}
