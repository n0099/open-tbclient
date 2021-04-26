package d.a.j0.q3.m;

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
    public List<e> f59356e;

    /* renamed from: f  reason: collision with root package name */
    public String f59357f;

    /* renamed from: g  reason: collision with root package name */
    public int f59358g = -1;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f59359h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59360a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f59361b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59362c;

        /* renamed from: d  reason: collision with root package name */
        public int f59363d;

        public a(d dVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        List<e> list = this.f59356e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            return this.f59356e.get(i2);
        }
        return null;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.f59360a = tbImageView;
        tbImageView.setIsRound(true);
        aVar.f59360a.setDrawerType(1);
        aVar.f59360a.setDefaultBgResource(R.color.transparent);
        aVar.f59360a.setBorderWidth(d.a.c.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
        aVar.f59360a.setConrers(15);
        aVar.f59360a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
        aVar.f59362c = (TextView) view.findViewById(R.id.tv_name);
    }

    public void c() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f59358g = 0;
        this.f59357f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public void d() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f59358g = 1;
        this.f59357f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void e(List<e> list, String str) {
        this.f59356e = list;
        this.f59357f = str;
    }

    public void f(VideoEffectLayout.h hVar) {
        this.f59359h = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f59356e;
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
                aVar.f59361b = progressBar;
                progressBar.setVisibility(4);
                SkinManager.setViewTextColor(aVar.f59362c, R.color.CAM_X0101);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                b(aVar, view, viewGroup);
                aVar.f59361b = (ProgressBar) view.findViewById(R.id.iv_loading);
                aVar.f59360a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                SkinManager.setViewTextColor(aVar.f59362c, R.color.CAM_X0101);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                b(aVar, view, viewGroup);
                SkinManager.setViewTextColor(aVar.f59362c, R.color.CAM_X0101);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List<e> list = this.f59356e;
        if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (eVar = this.f59356e.get(i2)) != null) {
            int itemViewType2 = getItemViewType(i2);
            if (itemViewType2 == 0) {
                aVar.f59360a.V(String.valueOf(eVar.a()), 24, false);
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59357f)) {
                    aVar.f59360a.setDrawBorder(true);
                } else {
                    aVar.f59360a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 1) {
                MusicData musicData = (MusicData) eVar.d();
                if (musicData.editMusicType == 0) {
                    aVar.f59360a.V(musicData.img, 10, false);
                } else {
                    aVar.f59360a.V(String.valueOf(eVar.a()), 24, false);
                }
                if (this.f59358g != i2) {
                    aVar.f59361b.setVisibility(4);
                } else if (aVar.f59361b.getVisibility() == 0) {
                    aVar.f59360a.setDrawBorder(false);
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59357f)) {
                    aVar.f59360a.setDrawBorder(true);
                } else {
                    aVar.f59360a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 2) {
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59357f)) {
                    aVar.f59360a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                } else {
                    aVar.f59360a.setBackgroundResource(R.drawable.bg_beauty_item);
                }
            }
            aVar.f59360a.setTag(eVar);
            aVar.f59360a.setTag(R.id.record_video_effect_holder, aVar);
            aVar.f59360a.setOnClickListener(this);
            aVar.f59362c.setText(eVar.b());
            aVar.f59363d = i2;
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
                statisticItem.param("obj_locate", this.f59356e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f59359h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f59358g = this.f59356e.indexOf(eVar);
                    this.f59357f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59357f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f59358g = this.f59356e.indexOf(eVar);
                }
            } else {
                this.f59358g = this.f59356e.indexOf(eVar);
            }
            this.f59357f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f59359h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
