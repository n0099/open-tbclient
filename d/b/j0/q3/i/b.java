package d.b.j0.q3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f61017a;

    /* renamed from: b  reason: collision with root package name */
    public final d f61018b;

    /* loaded from: classes5.dex */
    public class a implements d.b.j0.q3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f61018b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f61018b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f61018b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f61018b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f61018b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f61017a = cloudMusicModel;
        this.f61018b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.b.j0.q3.i.c
    public void a() {
        this.f61018b.displayLoading(true);
        this.f61017a.t(new a());
    }

    @Override // d.b.j0.q3.i.c
    public void cancelLoadData() {
        this.f61017a.cancelLoadData();
    }
}
