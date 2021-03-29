package d.b.i0.p0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f57657a;

    /* renamed from: b  reason: collision with root package name */
    public String f57658b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f57659c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57660d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f57661e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f57657a == null) {
                return;
            }
            i.this.f57657a.n();
            i.this.f57657a.c(str);
            i.this.f57657a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f57657a == null) {
                return;
            }
            i.this.f57657a.n();
            i.this.f57660d = z2;
            i.this.f57657a.a(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f57661e = aVar;
        this.f57657a = dVar;
        this.f57659c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel == null || !this.f57660d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.w();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f57658b = str;
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.x(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.y(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f57659c;
        if (videoAggregationModel != null) {
            videoAggregationModel.z(str);
        }
    }
}
