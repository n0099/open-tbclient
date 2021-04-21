package d.b.j0.q0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f59777a;

    /* renamed from: b  reason: collision with root package name */
    public String f59778b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f59779c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59780d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f59781e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f59777a == null) {
                return;
            }
            i.this.f59777a.n();
            i.this.f59777a.c(str);
            i.this.f59777a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f59777a == null) {
                return;
            }
            i.this.f59777a.n();
            i.this.f59780d = z2;
            i.this.f59777a.a(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f59781e = aVar;
        this.f59777a = dVar;
        this.f59779c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel == null || !this.f59780d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.w();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f59778b = str;
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.x(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.y(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f59779c;
        if (videoAggregationModel != null) {
            videoAggregationModel.z(str);
        }
    }
}
