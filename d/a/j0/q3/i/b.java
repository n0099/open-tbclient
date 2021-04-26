package d.a.j0.q3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f59148a;

    /* renamed from: b  reason: collision with root package name */
    public final d f59149b;

    /* loaded from: classes5.dex */
    public class a implements d.a.j0.q3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f59149b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f59149b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f59149b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f59149b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f59149b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f59148a = cloudMusicModel;
        this.f59149b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.j0.q3.i.c
    public void a() {
        this.f59149b.displayLoading(true);
        this.f59148a.t(new a());
    }

    @Override // d.a.j0.q3.i.c
    public void cancelLoadData() {
        this.f59148a.cancelLoadData();
    }
}
