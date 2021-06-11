package d.a.n0.r0.q2;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import d.a.n0.k1.o.l.i;
import d.a.n0.r0.i1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a<?, ?>> f63165a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final b f63166b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f63167c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f63168d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f63169e;

    /* renamed from: d.a.n0.r0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1598a<T> implements Observer<Integer> {
        public C1598a() {
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
        this.f63167c = tbPageContext;
        this.f63168d = bdTypeRecyclerView;
        this.f63169e = videoMiddlePageViewModel;
        TbPageContext<?> tbPageContext2 = this.f63167c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f63169e);
        this.f63166b = bVar;
        this.f63165a.add(bVar);
        this.f63168d.a(this.f63165a);
        MutableLiveData<Integer> c2 = this.f63169e.c();
        Activity pageActivity = this.f63167c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        c2.observe((LifecycleOwner) pageActivity, new C1598a());
    }

    public final BdTypeRecyclerView a() {
        return this.f63168d;
    }

    public final VideoMiddlePageViewModel b() {
        return this.f63169e;
    }

    public final void c() {
        this.f63166b.onDestroy();
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Integer value = this.f63169e.c().getValue();
        if (value == null) {
            value = 0;
        }
        e(value.intValue(), list);
        this.f63168d.setData(list);
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
        List<BaseCardInfo> value = this.f63169e.j().getValue();
        if (value != null) {
            Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
            for (BaseCardInfo baseCardInfo : value) {
                if (baseCardInfo instanceof i) {
                    ((i) baseCardInfo).setAutoPlay(false);
                }
            }
            this.f63168d.setData(value);
        }
    }
}
