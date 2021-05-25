package d.a.n0.r3.m;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f60242e;

    /* renamed from: f  reason: collision with root package name */
    public String f60243f;

    /* renamed from: g  reason: collision with root package name */
    public int f60244g = -1;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f60245h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60246a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f60247b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60248c;

        /* renamed from: d  reason: collision with root package name */
        public int f60249d;

        public a(d dVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        List<e> list = this.f60242e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            return this.f60242e.get(i2);
        }
        return null;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.f60246a = tbImageView;
        tbImageView.setIsRound(true);
        aVar.f60246a.setDrawerType(1);
        aVar.f60246a.setDefaultBgResource(R.color.transparent);
        aVar.f60246a.setBorderWidth(d.a.c.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
        aVar.f60246a.setConrers(15);
        aVar.f60246a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
        aVar.f60248c = (TextView) view.findViewById(R.id.tv_name);
    }

    public void c() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f60244g = 0;
        this.f60243f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public void d() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f60244g = 1;
        this.f60243f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void e(List<e> list, String str) {
        this.f60242e = list;
        this.f60243f = str;
    }

    public void f(VideoEffectLayout.h hVar) {
        this.f60245h = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f60242e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        e item = getItem(i2);
        if (item == null) {
            return 0;
        }
        int c2 = item.c();
        if (c2 != 1) {
            return c2 != 3 ? 0 : 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            aVar = new a(this);
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                b(aVar, view, viewGroup);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                aVar.f60247b = progressBar;
                progressBar.setVisibility(4);
                SkinManager.setViewTextColor(aVar.f60248c, R.color.CAM_X0101);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                b(aVar, view, viewGroup);
                aVar.f60247b = (ProgressBar) view.findViewById(R.id.iv_loading);
                aVar.f60246a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                SkinManager.setViewTextColor(aVar.f60248c, R.color.CAM_X0101);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                b(aVar, view, viewGroup);
                SkinManager.setViewTextColor(aVar.f60248c, R.color.CAM_X0101);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List<e> list = this.f60242e;
        if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (eVar = this.f60242e.get(i2)) != null) {
            int itemViewType2 = getItemViewType(i2);
            if (itemViewType2 == 0) {
                aVar.f60246a.V(String.valueOf(eVar.a()), 24, false);
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f60243f)) {
                    aVar.f60246a.setDrawBorder(true);
                } else {
                    aVar.f60246a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 1) {
                MusicData musicData = (MusicData) eVar.d();
                if (musicData.editMusicType == 0) {
                    aVar.f60246a.V(musicData.img, 10, false);
                } else {
                    aVar.f60246a.V(String.valueOf(eVar.a()), 24, false);
                }
                if (this.f60244g != i2) {
                    aVar.f60247b.setVisibility(4);
                } else if (aVar.f60247b.getVisibility() == 0) {
                    aVar.f60246a.setDrawBorder(false);
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f60243f)) {
                    aVar.f60246a.setDrawBorder(true);
                } else {
                    aVar.f60246a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 2) {
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f60243f)) {
                    aVar.f60246a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                } else {
                    aVar.f60246a.setBackgroundResource(R.drawable.bg_beauty_item);
                }
            }
            aVar.f60246a.setTag(eVar);
            aVar.f60246a.setTag(R.id.record_video_effect_holder, aVar);
            aVar.f60246a.setOnClickListener(this);
            aVar.f60248c.setText(eVar.b());
            aVar.f60249d = i2;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoEffectLayout.h hVar;
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.c() == 3 && (eVar.d() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) eVar.d()).id);
                statisticItem.param("obj_locate", this.f60242e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f60245h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f60244g = this.f60242e.indexOf(eVar);
                    this.f60243f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f60243f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f60244g = this.f60242e.indexOf(eVar);
                }
            } else {
                this.f60244g = this.f60242e.indexOf(eVar);
            }
            this.f60243f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f60245h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
