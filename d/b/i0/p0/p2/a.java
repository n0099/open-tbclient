package d.b.i0.p0.p2;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import d.b.i0.i1.o.l.i;
import d.b.i0.p0.i1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.b.j.e.a<?, ?>> f58332a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final b f58333b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f58334c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f58335d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f58336e;

    /* renamed from: d.b.i0.p0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1424a<T> implements Observer<Integer> {
        public C1424a() {
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
        this.f58334c = tbPageContext;
        this.f58335d = bdTypeRecyclerView;
        this.f58336e = videoMiddlePageViewModel;
        TbPageContext<?> tbPageContext2 = this.f58334c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f58336e);
        this.f58333b = bVar;
        this.f58332a.add(bVar);
        this.f58335d.a(this.f58332a);
        MutableLiveData<Integer> c2 = this.f58336e.c();
        Activity pageActivity = this.f58334c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        c2.observe((LifecycleOwner) pageActivity, new C1424a());
    }

    public final BdTypeRecyclerView a() {
        return this.f58335d;
    }

    public final VideoMiddlePageViewModel b() {
        return this.f58336e;
    }

    public final void c() {
        this.f58333b.onDestroy();
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Integer value = this.f58336e.c().getValue();
        if (value == null) {
            value = 0;
        }
        e(value.intValue(), list);
        this.f58335d.setData(list);
    }

    public final void e(int i, List<? extends BaseCardInfo> list) {
        if (i < list.size()) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (list.get(i2) instanceof i) {
                    BaseCardInfo baseCardInfo = list.get(i2);
                    if (baseCardInfo != null) {
                        ((i) baseCardInfo).setAutoPlay(i2 == i);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.lego.card.view.IPassAutoPlayData");
                    }
                }
                i2++;
            }
        }
    }

    public final void f() {
        List<BaseCardInfo> value = this.f58336e.j().getValue();
        if (value != null) {
            Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
            for (BaseCardInfo baseCardInfo : value) {
                if (baseCardInfo instanceof i) {
                    ((i) baseCardInfo).setAutoPlay(false);
                }
            }
            this.f58335d.setData(value);
        }
    }
}
